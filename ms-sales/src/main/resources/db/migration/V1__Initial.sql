

CREATE SCHEMA sales;

CREATE TABLE sales.product
(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR,
    dt_criation TIMESTAMP,
    dt_modification TIMESTAMP
);
