package ru.stankin.bd.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stankin.bd.entity.BroadcastEntity;
import ru.stankin.bd.entity.DetailEntity;
import ru.stankin.bd.factory.DynamicLoadFactorFactory;
import ru.stankin.bd.factory.N1MaxFactory;
import ru.stankin.bd.model.Calculation;
import ru.stankin.bd.model.CurrentTransmission;
import ru.stankin.bd.model.ResponseCalculation;
import ru.stankin.bd.repository.BroadcastRepository;
import ru.stankin.bd.repository.DetailRepository;
import ru.stankin.bd.service.CalculationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculationServiceImpl implements CalculationService {

    private final BroadcastRepository broadcastRepository;
    private final DetailRepository detailRepository;

    @Override
    public List<ResponseCalculation> calculation(Calculation calculation) {

        double tv = getTv(calculation.getCurrentTransmissions());
        double n = getN(calculation.getCurrentTransmissions());
        double f = getF(calculation.getCurrentTransmissions());

        double Kd = DynamicLoadFactorFactory.getDynamicLoadFactor(calculation.getLoadType(), calculation.getDriveType());
        double Km = calculation.getChainRowRation().getKm();

        // Эквивалетная полезная нагрузка
        Map<Double, Double> pyMap = new HashMap<>();
        double ky = getKy(n);
        BroadcastEntity broadcast = saveBroadcastEntity(ky, Kd, Km);
        for (CurrentTransmission c : calculation.getCurrentTransmissions()) {
            double fyi = Math.pow(currentCalculation(tv, n, c, calculation), 1/4.0);

            double t = getT(n, ky, getKm(calculation, n));
            double pym = getPym(calculation.getZ1(), tv, t, ky);
            double k = t <= 25.4 ? 24 : 6;
            double py = fyi * Kd / (calculation.getSop() * Km);
            pyMap.put(pym, py);

            save(tv, t, pym, fyi, k, broadcast, calculation, c);
        }

        return pyMap.entrySet().stream()
                .map(entry -> ResponseCalculation.builder().result(entry.getValue()).is(entry.getValue() <= entry.getKey()).build())
                .collect(Collectors.toList());
    }

    private BroadcastEntity saveBroadcastEntity(Double ky, Double kd, Double km) {
        BroadcastEntity broadcast = BroadcastEntity.builder()
                .id(UUID.randomUUID().toString())
                .ky(ky)
                .kv(new Random().nextDouble())
                .kd(kd)
                .kz(new Random().nextDouble())
                .k_t(new Random().nextDouble())
                .km(km)
                .kt(new Random().nextDouble())
                .build();

        return broadcastRepository.save(broadcast);
    }

    private void save(Double tz, Double t, Double pys, Double fyi, Double k, BroadcastEntity broadcast, Calculation calculation, CurrentTransmission currentTransmission) {
        DetailEntity detailEntity = DetailEntity.builder()
                .id(UUID.randomUUID().toString())
                .broadcastEntity(broadcast)
                .z1(Double.valueOf(calculation.getZ1()))
                .n1(currentTransmission.getN())
                .tz(tz)
                .n(Double.valueOf(calculation.getN()))
                .t(t)
                .pys(pys)
                .sop(Double.valueOf(calculation.getSop()))
                .yz(new Random().nextDouble())
                .feu(fyi)
                .fi(currentTransmission.getF())
                .ni(currentTransmission.getN())
                .tzi(currentTransmission.getTv())
                .k(k)
                .build();

        detailRepository.save(detailEntity);
    }

    /**
     * Допустимое среднее давление
     */
    private Double getPym(double z1, double tv, double t, double ky) {
        double kz = Math.pow(z1, 1/12.0);
        double kT = Math.pow((15 * Math.pow(10, 3)) / tv, 1/4.0);

        long k = t <= 25.4 ? 24 : 6;
        double kt = Math.pow(t / 25.4, 1.0/k);

        return 270 * kz * kT / (kt * ky);
    }

    /**
     * Рассчитать Полезную нагрузку для еонкретной передачи
     */
    private Double currentCalculation(double tv, double n, CurrentTransmission currentTransmission, Calculation calculation) {
        double Ky = getKy(currentTransmission.getN());
        double Km = getKm(calculation, currentTransmission.getN());

        // Расчет шага цепи t
        Double t = getT(currentTransmission.getN(), Ky, Km);

        Long n1Max = N1MaxFactory.getN1Max(t, calculation.getZ1());
        if (n1Max < currentTransmission.getN()) {
            throw new RuntimeException("Значение частоты вращение превыщает предельное значение");
        }

        return Math.pow(Math.pow(currentTransmission.getF(), 4) * (currentTransmission.getTv() / tv) * (currentTransmission.getN() / n), 4/9.0);
    }

    private Double getKy(double n) {
        return 10 * Math.pow(n / 10.0, 1/9.0);
    }

    private Double getKm(Calculation calculation, double n) {
        return Math.max(
                calculation.getChainRowRation().getKm(),
                Math.pow(Math.pow(n / 10.0, 2.0), 1/3.0)
        );
    }

    private Double getT(double n, double ky, double maxInKmAndKv) {
        return 30.5 * Math.pow((n * ky) / (n * maxInKmAndKv), 1/3.0);
    }

    /**
     * Общее время работы на основе всех передач tч
     */
    private Double getTv(List<CurrentTransmission> currentTransmissions) {
        return currentTransmissions.stream()
                .mapToDouble(CurrentTransmission::getTv)
                .sum();
    }

    /**
     * Частота вращения ведущей звездочки
     */
    private Double getN(List<CurrentTransmission> currentTransmissions) {
        return currentTransmissions.stream()
                .mapToDouble(CurrentTransmission::getN)
                .sum();
    }

    /**
     * Общая сила
     */
    private Double getF(List<CurrentTransmission> currentTransmissions) {
        return currentTransmissions.stream()
                .mapToDouble(CurrentTransmission::getF)
                .sum();
    }
}