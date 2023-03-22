-- Ausführsprache: SQLite
PRAGMA FOREIGN_KEYS = ON;

DROP TABLE IF EXISTS KontoStamm;
DROP TABLE IF EXISTS Buchung;
DROP TABLE IF EXISTS Darlehenskonto;
DROP TABLE IF EXISTS Sparkonto;
DROP TABLE IF EXISTS Girokonto;

CREATE TABLE KontoStamm
(
    Kontonummer  INTEGER NOT NULL PRIMARY KEY,
    Kontoinhaber TEXT    NULL,
    AnlageDatum  TEXT    NULL,
    Saldo        REAL    NULL,
    Kontoart     TEXT    NULL
);

CREATE TABLE Buchung
(
    Buchungsnr  INTEGER NULL PRIMARY KEY AUTOINCREMENT,
    Kontonummer INTEGER NULL,
    Betrag      REAL    NULL,
    Datum       TEXT    NULL,

    FOREIGN KEY (Kontonummer) REFERENCES KontoStamm (Kontonummer)
);

CREATE TABLE Darlehenskonto
(
    lfdNr       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Kontonummer INTEGER NULL,
    Dispo       REAL    NULL,
    Sollzins    REAL    NULL,

    FOREIGN KEY (Kontonummer) REFERENCES KontoStamm (Kontonummer)
);

CREATE TABLE Sparkonto
(
    lfdNr       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Kontonummer INTEGER NULL,
    Habenzins   REAL    NULL,
    Kuendbetrag REAL    NULL,
    Kuenddatum  TEXT    NULL,

    FOREIGN KEY (Kontonummer) REFERENCES KontoStamm (Kontonummer)
);

CREATE TABLE Girokonto
(
    lfdNr       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Kontonummer INTEGER NULL,
    Dispo       REAL    NULL,
    Sollzins    REAL    NULL,

    FOREIGN KEY (Kontonummer) REFERENCES KontoStamm (Kontonummer)
);
