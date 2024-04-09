-- liquibase formatted sql

-- changeset Andrey:1

create table if not exists t1persons.timing_methods
(
id_timing_methods bigserial primary key not null,
name_method varchar not null,
time_total bigint not null
);