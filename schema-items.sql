
--  SQLite version

-- CREATE table if not exists seller (
-- article TEXT NOT NULL PRIMARY KEY UNIQUE ,
-- name TEXT NOT NULL ,
-- price INTEGER NOT NULL ,
-- quantity INTEGER CHECK (quantity >= 0)
-- );


-- mySQL version
create table if not exists items(
article varchar(99) not null primary key unique,
name varchar(99) not null,
price int not null,
quantity int
);


DELIMITER
create trigger qty_check
before insert on items
for each row
begin
if quantity<=0 then
set new.quantity = 0;
end if;
end;





