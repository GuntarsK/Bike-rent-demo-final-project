CREATE TABLE IF NOT EXISTS user (
    user_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password_hash VARCHAR(250) NOT NULL,
    user_type VARCHAR(50) NOT NULL
);

INSERT INTO user (name, phone_number, email, password_hash, user_type) VALUES
('John Doe', '+371 20003000', 'john.doe@mail.com', '00000', 'ADMIN'),
('Jane Doe', '+371 50001000', 'jane.doe@mail.com', '00000', 'CUSTOMER'),
('Barack Obama', '+371 40002000', 'barack.o@mail.com', '00000', 'CUSTOMER'),
('Donald Trump', '+371 60008000', 'donald.t@mail.com', '00000', 'CUSTOMER'),
('Donald Duck', '+371 90004000', 'donal.duck@mail.com', '00000', 'CUSTOMER');
