-- liquibase formatted sql

-- changeset egor.krivosheev:init_profiles_table
CREATE TABLE profiles
(
    id      VARCHAR(80) NOT NULL,
    user_id VARCHAR(64) NOT NULL,
    type    VARCHAR(16) NOT NULL,
    CONSTRAINT pk_profiles PRIMARY KEY (id),
    CONSTRAINT fk_profiles_on_user FOREIGN KEY (user_id) REFERENCES users (id)
);
