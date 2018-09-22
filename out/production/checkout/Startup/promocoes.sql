CREATE TABLE IF NOT EXISTS promocoes(
  id            INTEGER PRIMARY KEY NOT NULL ,
  quantidade    INTEGER NOT NULL,
  valordesconto INTEGER,
  pague         INTEGER,
  tipo          CHARACTER VARYING(10) NOT NULL
);