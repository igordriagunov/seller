CREATE table if not exists seller (
article TEXT NOT NULL PRIMARY KEY UNIQUE ,
name TEXT NOT NULL ,
price INTEGER NOT NULL ,
quantity INTEGER CHECK (quantity >= 0)
);




