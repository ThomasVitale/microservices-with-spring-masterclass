CREATE TABLE book (
      id                  BIGSERIAL PRIMARY KEY NOT NULL,
      isbn                varchar(255) UNIQUE NOT NULL,
      title               varchar(255) NOT NULL
);