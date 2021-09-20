
drop database loja_virtual;
create database loja_virtual;
use loja_virtual;
create table produtos (
  id int not null auto_increment,
  nome varchar(100),
  descricao varchar(200),
  unidade varchar(3),
  preco float,
  primary key (id)
);
insert into produtos (nome, descricao, unidade, preco) values ('Banana', 'Banana Prata', 'KG', 3.99);
insert into produtos (nome, descricao, unidade, preco) values ('Leite', 'Leite Semidesnatado', 'LT', 4.19);