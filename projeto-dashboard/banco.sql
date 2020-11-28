create database bdTelemon;
use bdTelemon;
drop table usuario;
create table tbUsuario (
codUsuario int primary key auto_increment,
nomeUsuario varchar(45),
loginUsuario varchar(45),
senhaUsuario varchar(80),
dataCadastroUsuario datetime,
fkGestor int, foreign key (fkGestor) references tbUsuario(codUsuario));

insert into tbUsuario (nomeUsuario, loginUsuario, senhaUsuario) values ("Larissa", "la", "123");


select * from tbUsuario;
select count(codUsuario) as 'id',nomeUsuario from tbUsuario where loginUsuario = "la" and senhaUsuario = "123";

insert into tbComponenteMaquina values (14,5);
create table tbComponente(
codComponente int primary key auto_increment,
nomeComponente varchar(45),
descComponente varchar(100));
select * from tbComponenteMaquina;

insert into tbcomponente (nomeComponente, descComponente) values ("CPU", "mds");

create table tbPrograma(
codPrograma int primary key auto_increment,
nomePrograma varchar(45));

create table tbMaquina(
codMaquina int primary key auto_increment,
nomeMaquina varchar(45),
modeloMaquina varchar(45),
dataCadastroMaquina datetime);

create table tbComponenteMaquina(
codComponenteMaquina int primary key auto_increment,
fkComponente int, foreign key (fkComponente) references tbComponente(codComponente),
fkMaquina int, foreign key (fkMaquina) references tbMaquina(codMaquina));

drop table tbComponenteMaquina;

insert into tbComponenteMaquina (fkComponente, fkMaquina) values (1,1);
select * from tbComponenteMaquina;

create table tbDadosComponente(
	codDadosComponente int primary key auto_increment,
    valorDadosComponente double,
    registroDadosComponente datetime,
    fkComponenteMaquina int, foreign key (fkComponenteMaquina) references tbComponenteMaquina(codComponenteMaquina)
);

create table tbProcessos(
	codProcesso int primary key auto_increment,
    nomeProcesso varchar(45),
    cpuProcesso double,
    memProcesso double,
    registroProcesso datetime,
    fkMaquina int, foreign key (fkMaquina) references tbMaquina(codMaquina)
);

create table tbProgramaMaquina(
	codProgramaMaquina int primary key auto_increment,
    fkMaquina int, foreign key (fkMaquina) references tbMaquina(codMaquina),
    fkPrograma int, foreign key (fkPrograma) references tbPrograma(codPrograma)
);

create table tbUsuarioMaquina(
	codUsuarioMaquina int primary key auto_increment,
    fkUsuario int, foreign key (fkUsuario) references tbUsuario(codUsuario),
    fkMaquina int, foreign key (fkMaquina) references tbMaquina(codMaquina)
);

select * from tbMaquina;
delete from tbComponente where codComponente = 1 and codComponente = 2;
drop table tbPrograma;
drop table usuario;