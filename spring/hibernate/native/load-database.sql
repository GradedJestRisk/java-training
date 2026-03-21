DROP TABLE IF EXISTS people;
CREATE TABLE people (id SERIAL PRIMARY KEY, content JSONB);
INSERT INTO people (content) VALUES ('{"name": "jane"}');
INSERT INTO people (content) VALUES ('{"name": "mary"}');


DROP TABLE IF EXISTS animal;
CREATE TABLE animal (id INTEGER, content JSONB);
INSERT INTO animal (id, content) VALUES (1, '{"name": "dog"}');
INSERT INTO animal (id, content) VALUES (2, '{"name": "cat"}');

DROP TABLE IF EXISTS thing;
CREATE TABLE thing (id INTEGER, content TEXT);
INSERT INTO thing (id, content) VALUES (1, 'a table');
INSERT INTO thing (id, content) VALUES (2, 'a chair');