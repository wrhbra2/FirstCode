DROP TABLE IF exists orcamento;
DROP TABLE IF exists compra;
DROP TABLE IF exists venda;
DROP TABLE IF exists proventos;
DROP TABLE IF exists agenda;


CREATE OR REPLACE FUNCTION set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.ref = current_date;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE orcamento (id SERIAL PRIMARY KEY,
                    ref timestamp default current_date,
                    descricao varchar(100) not null,
                    preco money not null
                    );

CREATE TABLE compra (id SERIAL PRIMARY KEY,
                        ref  timestamp default current_date,
                        classe varchar(10),
                        ativo varchar(10) NOT NULL,
                        quant int NOT NULL,
                        preco money NOT NULL
                        );
CREATE TABLE venda (id SERIAL PRIMARY KEY,
                        ref  timestamp default current_date,
                        classe varchar(10),
                        ativo varchar(10) NOT NULL,
                        quant int NOT NULL,
                        preco money NOT NULL
                        );
CREATE TABLE proventos (
                       id SERIAL PRIMARY KEY,
                       ref timestamp default current_date,
                       classe varchar(10),
                       ativo varchar(10) not null,
                       quant int not null,
                       valor money not null );
CREATE TABLE agenda( id SERIAL PRIMARY KEY,
                     ref timestamp default current_date,
                     organizacao varchar(100) not null,
                     identidade varchar(100) not null,
                     senha varchar,
                     observacoes varchar(1000)  );

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON orcamento
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON compra
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON venda
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON proventos
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON agenda
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();
