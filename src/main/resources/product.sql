CREATE TABLE product (
    product_id  int NOT NULL,
    product_name varchar(255) NOT NULL,
    description varchar(255),
    product_price decimal,
    PRIMARY KEY (product_id)
);



CREATE TABLE customer (
    product_id  int NOT NULL,
    product_name varchar(255) NOT NULL,
    description varchar(255),
    product_price decimal,
    PRIMARY KEY (product_id)
);



create a table customer with fields customer_id,customer_name,customer_age ?