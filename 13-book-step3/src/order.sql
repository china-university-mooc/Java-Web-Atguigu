USE book;

CREATE TABLE `order` (
    order_id VARCHAR(50) PRIMARY KEY,
    create_time DATETIME NOT NULL,
    price DECIMAL(11,2) NOT NULL,
    status INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_order_user FOREIGN KEY(user_id) REFERENCES user(id)
);

DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(100) NOT NULL ,
    count INT NOT NULL ,
    price DECIMAL(11,2) NOT NULL ,
    total_price DECIMAL(11,2) NOT NULL ,
    order_id VARCHAR(50),
    CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES `order`(order_id)
);