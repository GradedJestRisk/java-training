-- https://www.jooq.org/doc/3.3/manual-single-page/

DROP TABLE IF EXISTS book_to_book_store;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS book_store;

CREATE TABLE language (
  id              INTEGER    NOT NULL PRIMARY KEY,
  cd              TEXT       NOT NULL,
  description     TEXT
);

CREATE TABLE author (
  id             INTEGER   NOT NULL PRIMARY KEY,
  first_name      TEXT,
  last_name       TEXT  NOT NULL,
  date_of_birth   DATE,
  year_of_birth   INTEGER,
  distinguished   INTEGER
);

CREATE TABLE book (
  id              INTEGER    NOT NULL PRIMARY KEY,
  author_id       INTEGER    NOT NULL REFERENCES author(id),
  title           TEXT       NOT  NULL,
  published_in    INTEGER    NOT NULL,
  language_id     INTEGER    NOT NULL REFERENCES language(id)
);

CREATE TABLE book_store (
  name            TEXT NOT NULL UNIQUE
);

CREATE TABLE book_to_book_store (
  name            TEXT     NOT NULL REFERENCES book_store(name),
  book_id         INTEGER  NOT NULL REFERENCES book(id),
  stock           INTEGER  NOT NULL,
  PRIMARY KEY(name, book_id)
);

INSERT INTO language (id, cd, description) VALUES (1, 'en', 'English');
INSERT INTO language (id, cd, description) VALUES (2, 'de', 'Deutsch');
INSERT INTO language (id, cd, description) VALUES (3, 'fr', 'Français');
INSERT INTO language (id, cd, description) VALUES (4, 'pt', 'Português');

INSERT INTO author (id, first_name, last_name, date_of_birth    , year_of_birth)
VALUES           (1 , 'George'  , 'Orwell' , DATE '1903-06-26', 1903         );
INSERT INTO author (id, first_name, last_name, date_of_birth    , year_of_birth)
VALUES           (2 , 'Paulo'   , 'Coelho' , DATE '1947-08-24', 1947         );

INSERT INTO book (id, author_id, title         , published_in, language_id)
VALUES         (1 , 1        , '1984'        , 1948        , 1          );
INSERT INTO book (id, author_id, title         , published_in, language_id)
VALUES         (2 , 1        , 'Animal Farm' , 1945        , 1          );
INSERT INTO book (id, author_id, title         , published_in, language_id)
VALUES         (3 , 2        , 'O Alquimista', 1988        , 4          );
INSERT INTO book (id, author_id, title         , published_in, language_id)
VALUES         (4 , 2        , 'Brida'       , 1990        , 2          );

INSERT INTO book_store VALUES ('Orell Füssli');
INSERT INTO book_store VALUES ('Ex Libris');
INSERT INTO book_store VALUES ('Buchhandlung im Volkshaus');

INSERT INTO book_to_book_store VALUES ('Orell Füssli'             , 1, 10);
INSERT INTO book_to_book_store VALUES ('Orell Füssli'             , 2, 10);
INSERT INTO book_to_book_store VALUES ('Orell Füssli'             , 3, 10);
INSERT INTO book_to_book_store VALUES ('Ex Libris'                , 1, 1 );
INSERT INTO book_to_book_store VALUES ('Ex Libris'                , 3, 2 );
INSERT INTO book_to_book_store VALUES ('Buchhandlung im Volkshaus', 3, 1 );