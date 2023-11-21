INSERT INTO Client(name)
VALUES
('Vasyl'),
('Ivan'),
('Petro'),
('Ivanka'),
('Orest'),
('Andrii'),
('Ganna'),
('Rodrigo'),
('ShiFa'),
('Olha');

INSERT INTO Planet(id, name)
VALUES
('MARS', 'Mars'),
('VENUS', 'Venus'),
('EARTH', 'Earth'),
('DUNE', 'Dune'),
('EARTH21', 'Earth21');

INSERT INTO Ticket(created_at, client_id, from_planet_id, to_planet_id)
VALUES
(CURRENT_TIMESTAMP, 1, 'EARTH', 'EARTH21'),
(CURRENT_TIMESTAMP + INTERVAL '1 years', 1, 'EARTH', 'DUNE'),
(CURRENT_TIMESTAMP + INTERVAL '3 years', 2, 'EARTH', 'MARS'),
(CURRENT_TIMESTAMP + INTERVAL '100 months', 3, 'MARS', 'VENUS'),
(CURRENT_TIMESTAMP + INTERVAL '39 months', 4, 'MARS', 'EARTH'),
(CURRENT_TIMESTAMP + INTERVAL '28 days', 5, 'MARS', 'EARTH21'),
(CURRENT_TIMESTAMP + INTERVAL '10 days', 6, 'EARTH21', 'EARTH'),
(CURRENT_TIMESTAMP + INTERVAL '586 days', 7, 'DUNE', 'EARTH21'),
(CURRENT_TIMESTAMP + INTERVAL '74 months', 8, 'DUNE', 'EARTH21'),
(CURRENT_TIMESTAMP + INTERVAL '300 years', 9, 'MARS', 'VENUS'),
(CURRENT_TIMESTAMP + INTERVAL '297 years', 10, 'VENUS', 'EARTH21');