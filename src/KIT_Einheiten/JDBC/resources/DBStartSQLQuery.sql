-- Ausführsprache: SQLite

-- Aktiviert die Möglichkeit Foreign Keys überhaupt zu benutzen
PRAGMA FOREIGN_KEYS = ON;

-- Löscht die Tabellen, wenn diese überhaupt existieren
DROP TABLE IF EXISTS adressen;
DROP TABLE IF EXISTS telefon;

-- Erzeugt die Tabellen
CREATE TABLE adressen
(
    pk_id   INT PRIMARY KEY,
    name    TEXT,
    strasse TEXT
);

CREATE TABLE telefon
(
    pk_id INT PRIMARY KEY,
    fk_id INT,
    art   TEXT,
    nr    TEXT,

    FOREIGN KEY (fk_id) REFERENCES adressen (pk_id)
);

-- Verschiedene Auswahlmöglichkeiten
SELECT *
FROM adressen;
SELECT name, strasse
FROM adressen;
SELECT name, strasse
FROM adressen
WHERE pk_id = 1;
SELECT name, strasse
FROM adressen
WHERE name LIKE '%r';
SELECT *
FROM adressen,
     telefon
WHERE adressen.pk_id = fk_id;

-- Löscht alle Inhalte aus einer Tabelle
DELETE
FROM adressen;

-- Fügt diverse Einträge in die jeweilige Tabelle ein
INSERT INTO adressen
VALUES (1, 'Huber', 'Goethestr. 12');
INSERT INTO adressen
VALUES (2, 'Hayer', 'Hauptstr. 14');
INSERT INTO adressen
VALUES (3, 'Schmidt', 'Fischerstr. 20');

INSERT INTO telefon
VALUES (1, 1, 'Fest', '0123456');