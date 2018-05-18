CREATE table if not exists sales (
article TEXT NOT NULL PRIMARY KEY UNIQUE ,
saleQuantity INTEGER CHECK (saleQuantity >= 0)
);




