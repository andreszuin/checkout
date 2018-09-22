CREATE TABLE IF NOT EXISTS item (
  idproduto  INTEGER NOT NULL,
  quantidade INTEGER NOT NULL,
  UNIQUE (idproduto),
  FOREIGN KEY (idproduto) REFERENCES produto(id)
);



