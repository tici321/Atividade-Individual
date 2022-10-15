CREATE TABLE Site (
    NomeSite VARCHAR(50) NOT NULL,
    Id_Site INT(7) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    EnderecoSite VARCHAR(100) NOT NULL
);

CREATE  TABLE  Usuario (
NomeUsuario VARCHAR ( 100 ) NOT NULL ,
Id_Cliente INT ( 12 ) PRIMARY KEY  NOT NULL auto_increment,
EnderecoCliente VARCHAR ( 100 ) NOT NULL ,
UsuarioUCliente VARCHAR ( 15 ) NOT NULL ,
SenhaCliente VARCHAR ( 10 ) NOT NULL, 
EmailCliente VARCHAR ( 50 ) NOT NULL
);


CREATE TABLE Contato (
id_usuario VARCHAR ( 20 ) PRIMARY KEY  NOT NULL auto_increment,
Nome VARCHAR ( 80 ) NOT NULL,
Email VARCHAR ( 50 ) NOT NULL,
Telefone INT ( 12 ) NOT NULL,
Mensagem VARCHAR( 300 ) NOT NULL
);

CREATE TABLE Destinos (
id_lugares VARCHAR ( 20 ) PRIMARY KEY  NOT NULL auto_increment,
Internacionais VARCHAR (20) NOT NULL,
Nacionais VARCHAR (20) NOT NULL
);

CREATE TABLE Promoções (
id_promocoes VARCHAR ( 20 ) PRIMARY KEY  NOT NULL auto_increment,
Comprar VARCHAR (20)
);