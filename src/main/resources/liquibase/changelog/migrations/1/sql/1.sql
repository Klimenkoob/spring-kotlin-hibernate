CREATE TABLE department
(
    id          BIGSERIAL PRIMARY KEY,
    name        TEXT      NOT NULL,
    created     TIMESTAMP NOT NULL,
    modified    TIMESTAMP NOT NULL
);

CREATE TABLE employee
(
    id            BIGSERIAL PRIMARY KEY,
    department_id BIGINT REFERENCES department (id) NOT NULL,
    first_name    TEXT                              NOT NULL,
    last_name     TEXT,
    created       TIMESTAMP                         NOT NULL,
    modified      TIMESTAMP                         NOT NULL
)