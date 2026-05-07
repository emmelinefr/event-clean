CREATE TABLE eventos (

    id BIGSERIAL PRIMARY KEY ,
    nome VARCHAR(255) NOT NULL ,
    descricao TEXT ,
    identificador VARCHAR(255) NOT NULL UNIQUE ,
    data_inicio TIMESTAMP NOT NULL ,
    data_fim TIMESTAMP NOT NULL ,
    local_evento VARCHAR(255) NOT NULL ,
    organizador VARCHAR(255) NOT NULL ,
    capacidade INTEGER NOT NULL ,
    tipo VARCHAR(50) NOT NULL

);
