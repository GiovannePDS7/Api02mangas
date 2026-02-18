-- schema.sql

CREATE TABLE manga(
    id int primary key auto_increment,
    nome varchar(255) not null,
    autor varchar(255) not null,
    qtd_volumes int not null,
    editora varchar(255) not null
);

INSERT INTO manga(nome, autor, qtd_volumes, editora) VALUES ('Monster', 'autor01', 2, 'editora');