-- liquibase formatted sql

-- changeset egor.krivosheev:init_users_table
CREATE TABLE users
(
    id VARCHAR(64) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);
