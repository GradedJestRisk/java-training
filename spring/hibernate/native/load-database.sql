DROP TABLE IF EXISTS people;
CREATE TABLE people (id SERIAL PRIMARY KEY, content JSONB);
INSERT INTO people (content) VALUES ('{"name": "jane"}');
INSERT INTO people (content) VALUES ('{"name": "mary"}');


DROP TABLE IF EXISTS animal;
CREATE TABLE animal (id INTEGER, content JSONB);
INSERT INTO animal (id, content) VALUES (1, '{"name": "dog"}');
INSERT INTO animal (id, content) VALUES (2, '{"name": "cat"}');