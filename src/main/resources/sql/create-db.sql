-- DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id    INTEGER PRIMARY KEY,
  name  VARCHAR(30),
  email VARCHAR(50)
);
CREATE TABLE books (
  id     INTEGER PRIMARY KEY,
  title  VARCHAR(30),
  author VARCHAR(30),
  pages  INTEGER,
  isbn   VARCHAR(30)
);
