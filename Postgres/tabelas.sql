CREATE SCHEMA IF not exists relatorios;
DROP TABLE IF exists relatorios.orcamento;
DROP TABLE IF exists relatorios.compra;
DROP TABLE IF exists relatorios.venda;
DROP TABLE IF exists relatorios.proventos;
DROP TABLE IF exists relatorios.agenda;


CREATE OR REPLACE FUNCTION set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.ref = current_date;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE relatorios.orcamento (id SERIAL PRIMARY KEY,
                    ref timestamp default current_date,
                    descricao varchar(100) not null,
                    preco money not null
                    );

CREATE TABLE relatorios.compra (id SERIAL PRIMARY KEY,
                        ref  timestamp default current_date,
                        classe varchar(10),
                        ativo varchar(10) NOT NULL,
                        quant int NOT NULL,
                        preco money NOT NULL,
                        total money,
                        preco_medio money 
                         );
CREATE or replace FUNCTION compra_gatilho() RETURNS trigger as $compra_gatilho$
BEGIN
  --Calcular total da Compra.
  new.total = new.quant*new.preco;
  
  --Calcular o Preço Mèdio.
  new.preco_medio = new.total/new.quant;
  return new;
END;
$compra_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER compra_gatilho BEFORE INSERT OR UPDATE ON relatorios.compra
  FOR EACH ROW EXECUTE PROCEDURE compra_gatilho();

    

                        
CREATE TABLE relatorios.venda (id SERIAL PRIMARY KEY,
                        ref  timestamp default current_date,
                        classe varchar(10),
                        ativo varchar(10) NOT NULL,
                        quant int NOT NULL,
                        preco money NOT NULL,
                        total money generated always as (quant*preco) stored
                        );
CREATE TABLE relatorios.proventos (
                       id SERIAL PRIMARY KEY,
                       ref timestamp default current_date,
                       classe varchar(10),
                       ativo varchar(10) not null,
                       quant int not null,
                       valor money not null );
CREATE TABLE relatorios.agenda( id SERIAL PRIMARY KEY,
                     ref timestamp default current_date,
                     organizacao varchar(20) not null,
                     identidade varchar(20) not null,
                     senha varchar(20),
                     observacoes varchar(100)  );

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON relatorios.orcamento
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON relatorios.compra
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON relatorios.venda
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON relatorios.proventos
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();

CREATE TRIGGER set_timestamp
BEFORE UPDATE ON relatorios.agenda
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();
