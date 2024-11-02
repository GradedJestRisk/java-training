DROP TABLE IF EXISTS people;
CREATE TABLE people (id SERIAL PRIMARY KEY, content JSONB);
INSERT INTO people (content) VALUES ('{"name": "jane"}');
INSERT INTO people (content) VALUES ('{"name": "mary"}');