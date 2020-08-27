CREATE TABLE IF NOT EXISTS reservation (
    reservation_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_pk BIGINT NOT NULL,
    bike_pk BIGINT NOT NULL,
    date_from TIMESTAMP NOT NULL,
    date_to TIMESTAMP NOT NULL
);

INSERT INTO reservation (user_pk, bike_pk, date_from, date_to) VALUES
(3, 1, '2020-08-27', '2020-08-28'),
(2, 5, '2020-08-29', '2020-09-01'),
(5, 3, '2020-08-25', '2020-08-29'),
(4, 1, '2020-08-26', '2020-08-28'),
(4, 2, '2020-08-26', '2020-08-28');
