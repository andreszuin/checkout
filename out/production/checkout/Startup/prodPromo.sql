CREATE TABLE IF NOT EXISTS prodPromo(
  idproduto INTEGER NOT NULL ,
  idpromocao INTEGER NOT NULL,
  FOREIGN KEY (idproduto) REFERENCES produto(id),
  FOREIGN KEY (idpromocao) REFERENCES promocoes(id)
);