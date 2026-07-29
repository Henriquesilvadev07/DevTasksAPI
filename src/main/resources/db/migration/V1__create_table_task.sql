CREATE TABLE tasks(
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL ,
    descricao TEXT,
    status VARCHAR(30) NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);