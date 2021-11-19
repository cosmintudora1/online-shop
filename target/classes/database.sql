CREATE SCHEMA IF NOT EXISTS onlineshop;


CREATE TABLE onlineshop.products
(
    product_id         VARCHAR(50) NOT NULL,
    old_price          integer,
    new_price          integer,
    discount           integer,
    available_quantity integer,
    photo              text,
    UNIQUE (product_id)
);


CREATE TABLE onlineshop.orders
(
    order_id         VARCHAR(50) NOT NULL,
    user_id          VARCHAR(50) NOT NULL,
    products         text,
    total_order_cost integer,
    UNIQUE (order_id)
);

insert into onlineshop.products (product_id, old_price, new_price, discount, available_quantity, photo)
values ('5ccbd37a-4876-11ec-81d3-0242ac130003', 2000, 1900, 100, 14, 'www.photo.ro'),
       ('5ccbd37a-4876-11ec-81d3-0242ac139999', 400, 300, 100, 54, 'www.photo2.ro'),
       ('5ccbd37a-4876-11ec-81d3-023a2c139999', 400, 300, 100, 54, 'www.photo2.ro'),
       ('5ccbd37a-4876-123c-81d3-0242ac139999', 39, 21, 11, 54, 'www.photo2.ro'),
       ('6ef5e0fc-4936-11ec-81d3-0242ac130003', 12, 22, 100, 54, 'www.photo2.ro'),
       ('5cc4437a-4876-11ec-81d3-0242ac139999', 45, 66, 66, 54, 'www.photo2.ro'),
       ('6ef5e1ba-4936-11ec-81d3-0242ac130003', 57, 55, 22, 54, 'www.photo2.ro');