CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3),
    UNIQUE (name)
);

CREATE TABLE Planet (
    id VARCHAR PRIMARY KEY CHECK (id SIMILAR TO '[A-Z0-9]+'),
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1),
    UNIQUE (id)
);

CREATE TABLE Ticket
(
   id SERIAL PRIMARY KEY,
   created_at TIMESTAMP,
   client_id INT NOT NULL,
   from_planet_id  VARCHAR NOT NULL,
   to_planet_id VARCHAR NOT NULL,
   FOREIGN KEY (client_id) REFERENCES Client(id),
   FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
   FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);