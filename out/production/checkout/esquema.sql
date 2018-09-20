CREATE TABLE produto(
  id    SERIAL PRIMARY KEY,
  nome  CHARACTER VARYING(15) NOT NULL,
  valor INTEGER               NOT NULL,
  UNIQUE (nome)
);

CREATE TABLE item (
  idproduto  INTEGER NOT NULL,
  quantidade INTEGER NOT NULL,
  UNIQUE (idproduto),
  FOREIGN KEY (idproduto) REFERENCES produto(id)
);

CREATE TABLE promocoes (
  id            SERIAL PRIMARY KEY,
  quantidade    INTEGER NOT NULL,
  valordesconto INTEGER,
  pague         INTEGER,
  idproduto     INTEGER,
  tipo          CHARACTER VARYING(10) NOT NULL ,
  FOREIGN KEY (idproduto) REFERENCES produto (id)
);