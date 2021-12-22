
create table broadcast (
                           id varchar(36) primary key,
                           ky decimal(16, 5),
                           kv decimal(16, 5),
                           kd decimal(16, 5),
                           kz decimal(16, 5),
                           k_t decimal(16, 5), -- KT
                           km decimal(16, 5),
                           kt decimal(16, 5) -- Kt
);

create table detail (
                        id varchar(36) primary key,
                        broadcast_id varchar(36) references broadcast,
                        z1 decimal(16, 5),
                        n1 decimal(16, 5),
                        tz decimal(16, 5), -- tч
                        n decimal(16, 5),
                        t decimal(16, 5),
                        pys decimal(16, 5), -- [py]
                        sop decimal(16, 5),
                        yz decimal(16, 5),
                        feu decimal(16, 5),
                        fi decimal(16, 5),
                        ni decimal(16, 5),
                        tzi decimal(16, 5),
                        k decimal(16, 5)
);