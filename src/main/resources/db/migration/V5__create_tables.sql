DROP TABLE IF EXISTS stock, size, product;
CREATE TABLE product (
  id int PRIMARY KEY,
  sequence int NOT NULL
 );
 
CREATE TABLE size (
  id int PRIMARY KEY,
  productId int NOT NULL,
  backSoon boolean NOT NULL,
  special boolean NOT NULL,
  FOREIGN KEY (productId) REFERENCES product(id)
 );
 
CREATE TABLE stock (
  sizeId int NOT NULL,
  quantity int NOT NULL,
  FOREIGN KEY (sizeId) REFERENCES size(id)
 );
 
COPY product FROM '/home/dxd/Documents/product.csv' DELIMITER ',' CSV;
COPY size FROM '/home/dxd/Documents/size.csv' DELIMITER ',' CSV;
COPY stock FROM '/home/dxd/Documents/stock.csv' DELIMITER ',' CSV;

