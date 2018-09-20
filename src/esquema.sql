DROP TABLE promocoes CASCADE ;
DROP TABLE item CASCADE ;
DROP TABLE promocoes CASCADE ;
DROP TABLE prodPromo CASCADE ;

CREATE TABLE IF NOT EXISTS produto(
  id    INTEGER PRIMARY KEY NOT NULL ,
  nome  CHARACTER VARYING(15) NOT NULL,
  valor NUMERIC               NOT NULL,
  UNIQUE (nome)
);

CREATE TABLE IF NOT EXISTS item (
  idproduto  INTEGER NOT NULL,
  quantidade INTEGER NOT NULL,
  UNIQUE (idproduto),
  FOREIGN KEY (idproduto) REFERENCES produto(id)
);

CREATE TABLE IF NOT EXISTS promocoes(
  id            INTEGER PRIMARY KEY NOT NULL ,
  quantidade    INTEGER NOT NULL,
  valordesconto INTEGER,
  pague         INTEGER,
  tipo          CHARACTER VARYING(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS prodPromo(
  idproduto INTEGER NOT NULL ,
  idpromocao INTEGER NOT NULL,
  FOREIGN KEY (idproduto) REFERENCES produto(id),
  FOREIGN KEY (idpromocao) REFERENCES promocoes(id)
);