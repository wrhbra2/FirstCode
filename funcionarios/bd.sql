DROP TABLE IF EXISTS funcionarios;
DROP TABLE IF EXISTS material;

DROP TABLE IF EXISTS agendamento;

DROP TABLE IF EXISTS devolucao;

CREATE SEQUENCE sq_exemplo INCREMENT 1 MINVALUE 0 MAXVALUE 99999;



CREATE TABLE funcionarios(
    id CHAR(5) DEFAULT lpad(nextval('sq_exemplo')::CHAR(5),5,'0';) PRIMARY KEY,
    nome varchar(30),
    cargo VARCHAR(30),
    celular int(10),
    email varchar(30)
    );

CREATE TABLE material(
    id CHAR(5) DEFAULT lpad(nextval('sq_exemplo')::CHAR(5),5,'0';) PRIMARY KEY,
    descricao VARCHAR(50),
    periferico varchar(50),
    avaria varchar(200)
);

CREATE TABLE agendamento(
    id_material CHAR(5),
    id_funcionario CHAR(5),
    local_uso VARCHAR(50),
    saida CURRENT_TIMESTAMP(0) primary key,
    retorno date
);

CREATE TABLE devolucao(
    id_material char(5) primary key,
    id_funcionario char(5),
    conservacao varchar(200),
    carencia date
);