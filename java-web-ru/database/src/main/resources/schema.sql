-- BEGIN
CREATE TABLE if not exists products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    price INT NOT NULL
);
-- END