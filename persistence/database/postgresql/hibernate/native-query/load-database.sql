DROP TABLE IF EXISTS item;
CREATE TABLE item (id SERIAL PRIMARY KEY, content TEXT);
INSERT INTO item (content) VALUES ('hammer');
INSERT INTO item (content) VALUES ('teapot');
INSERT INTO item (content) VALUES ('pride and prejudice');
