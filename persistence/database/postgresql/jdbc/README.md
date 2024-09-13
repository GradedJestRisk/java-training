# JDBC

From https://www.sohamkamani.com/java/jdbc-postgresql/

Create dataset
```postgresql
CREATE TABLE birds (
                       id SERIAL PRIMARY KEY,
                       bird VARCHAR(256),
                       description VARCHAR(1024)
);

INSERT INTO birds (bird , description) VALUES 
('pigeon', 'common in cities'),
('eagle', 'bird of prey');
```

See also https://jdbc.postgresql.org/documentation/query/