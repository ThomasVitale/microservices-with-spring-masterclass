CREATE TABLE IF NOT EXISTS orders (
      id                  BIGSERIAL PRIMARY KEY NOT NULL,
      isbn                varchar(255) NOT NULL,
      status              varchar(255) NOT NULL
);