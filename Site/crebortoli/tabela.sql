
DROP TABLE IF exists agenda;

CREATE OR REPLACE FUNCTION set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.ref = current_date;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;





CREATE TABLE agenda (id SERIAL PRIMARY KEY,
                        ref TIMESTAMP DEFAULT current_date,
                        nome varchar(60)  NULL,
                        email varchar(60) NULL,
                        telefone varchar(20) null,
                        dia DATE NULL,
                        hora TIME NULL,
                        mensagem varchar(10000)  NULL
                        );


CREATE TRIGGER set_timestamp
BEFORE UPDATE ON public.agenda
FOR EACH ROW
EXECUTE FUNCTION set_timestamp();
