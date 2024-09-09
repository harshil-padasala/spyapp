CREATE TABLE mission (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    agent VARCHAR NOT NULL,
    title VARCHAR NOT NULL,
    gadget1 VARCHAR,
    gadget2 VARCHAR
);


INSERT INTO mission (agent, title, gadget1, gadget2)
VALUES
    ('Johnny English', 'Rescue the Queen', 'Exploding Sigar', 'Voice Controlled Rolls Royce'),
    ('Natasha Romanova', 'Kill Iron Man', 'Armored Suit', 'Industructible Pole'),
    ('Austin Powers', '', 'Red, White and Blue Shaguar', 'Mini Cooper');