CREATE table if not exists sales (
id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
itemArticle TEXT NOT NULL ,
saleQuantity INTEGER CHECK (saleQuantity >= 0),
FOREIGN KEY (saleQuantity) REFERENCES items(quantity)
);




