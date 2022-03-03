create table Product
(
    product_id   int primary key,
    product_name varchar(200) not null,
    price        double       not null,
    image_file_name varchar(200) not null,
    quantity int not null
);


