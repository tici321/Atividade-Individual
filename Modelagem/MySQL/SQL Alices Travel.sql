CREATE TABLE agencia(
NomeAgencia VARCHAR(50) NOT NULL,
IdAgencia INT(7) PRIMARY KEY NOT NULL auto_increment,
EnderecoAgencia VARCHAR(100) NOT NULL

);

CREATE TABLE cliente(
NomeCliente VARCHAR(100) NOT NULL,
IdCliente INT(12) PRIMARY KEY NOT NULL auto_increment,
EnderecoCliente VARCHAR(100) NOT NULL,
UsuarioCliente VARCHAR(15) NOT NULL,
SenhaCliente VARCHAR(10) NOT NULL,
EmailCliente VARCHAR(50)NOT NULL

);


CREATE TABLE pedido(
IdPedido INT(10) PRIMARY KEY NOT NULL auto_increment,

IdCliente INT(12),
FOREIGN KEY (IdCliente) REFERENCES cliente (IdCliente)
);



CREATE TABLE Viagem(
DataIda DATE NOT NULL,
DataVolta DATE,
IdViagem INT (20) PRIMARY KEY NOT NULL auto_increment,
Valor DOUBLE ,
Destino VARCHAR(100)
);


CREATE TABLE seguro(
codigo INT(13) PRIMARY KEY NOT NULL auto_increment,
NomeCliente VARCHAR(100) NOT NULL,
IdCliente INT(12) NOT NULL auto_increment,
periodo DATE NOT NULL,
FOREIGN KEY (IdCliente) REFERENCES cliente (IdCliente),
FOREIGN KEY (NomeCliente) REFERENCES cliente (NomeCliente)
);
