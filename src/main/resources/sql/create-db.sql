-- DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id       INTEGER PRIMARY KEY,
  name     VARCHAR(30),
  email    VARCHAR(50),
  login    VARCHAR(30),
  password VARCHAR(30)

);
CREATE TABLE books (
  id     INTEGER PRIMARY KEY,
  title  VARCHAR(30),
  author VARCHAR(30),
  pages  INTEGER,
  isbn   VARCHAR(30)
);
CREATE TABLE orders (
  id             INTEGER PRIMARY KEY,
  books          VARCHAR(999),
  userName       VARCHAR(30),
  date_of_return VARCHAR(30)
);
