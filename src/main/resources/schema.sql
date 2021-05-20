drop table if exists produto;

create table produto(
    id_produto bigint auto_increment,
    nome varchar(20) not null,
    marca varchar(25) not null,
    cor char(10) not null,
    preco double not null,
    primary key(id_produto)
    );