create database bdClarilimp;
use bdClarilimp;
UPDATE usuario set logradouro = 'Rua Cyrillo', 
cep = '08470-590', numeroCasa = '44', telefoneFixo = '2259-3398',
 telefoneCelular = '93736-2836', bairro = 'Ct',cidade = 'São Paulo' 
 where emailUsuario = 'larissa@exemplo.com' and senhaUsuario = '8282';
 SELECT codigoUsuario FROM usuario where emailUsuario = 'larissa@exemplo.com' and senhaUsuario = '8282';
create table usuario (
codigoUsuario int primary key auto_increment,
nomeUsuaio varchar(45),
emailUsuario varchar(45),
senhaUsuario varchar(45),
logradouro varchar(80),
cep varchar(9),
numeroCasa varchar(10),
telefoneFixo varchar(14),
telefoneCelular varchar(14),
bairro varchar(45),
cidade varchar(45));

create table Produto (
codProduto int primary key auto_increment,
nomeProduto varchar(45),
descProduto varchar(80),
precoAtacado decimal(5,2),
precoVarejo decimal(5,2));

create table Mensagem (
codMensagem int primary key auto_increment,
nome varchar(45),
email varchar(45),
textoMensagem varchar(120));
select * from usuario;
create table Pedido (
codPedido int primary key auto_increment,
fkUsuario int, foreign key (fkUsuario) references usuario(codigoUsuario),
dataPedido datetime,
valorPedido decimal(6,2));
select * from Pedido;
SELECT codigoUsuario FROM usuario where emailUsuario = 'larissa@exemplo.com' and senhaUsuario = '8282';

insert into Pedido (fkUsuario, dataPedido, valorPedido) values ();
create table ProdutoPedido (
codProdutoPedido int primary key auto_increment,
fkProduto int, foreign key (fkProduto) references Produto(codProduto),
fkPedido int, foreign key (fkPedido) references Pedido(codPedido));
select*from ProdutoPedido;