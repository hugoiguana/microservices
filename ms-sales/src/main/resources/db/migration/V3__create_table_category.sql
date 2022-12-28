

CREATE TABLE sales.category
(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR,
    dt_criation TIMESTAMP,
    dt_modification TIMESTAMP
);


insert into sales.category(id, name, description, dt_criation, dt_modification)
values(uuid_generate_v4(), lower('smartphones'), 'Smartphones', current_timestamp, current_timestamp);