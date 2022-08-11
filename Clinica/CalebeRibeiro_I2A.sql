create database PROJETODENTISTA;
use PROJETODENTISTA;

CREATE TABLE Cliente(
CODCliente INT PRIMARY KEY auto_increment,
NOME VARCHAR(90) NOT NULL,
CPF NUMERIC(20),
CIDADE VARCHAR(30),
TELEFONE VARCHAR(30),
IDADE SMALLINT
);

CREATE TABLE FUNCIONARIOS(
CODFUNC INT PRIMARY KEY auto_increment,
NOME VARCHAR(90) NOT NULL,
CPF NUMERIC(20) unique,
SALARIO NUMERIC(10),
IDADE SMALLINT
);

CREATE TABLE DENTISTA(
CODDENTISTA INT primary KEY auto_increment,
NOME varchar(90) NOT NULL,
CPF NUMERIC(20) unique,
CONTATO VARCHAR(100)
);

create TABLE EXAME(
CODEXAME INT primary KEY auto_increment,
CATEGORIA VARCHAR(40),
PRESCRICAO VARCHAR(100),
CODCLIENTE INT,
FOREIGN KEY (CODCLIENTE) REFERENCES CLIENTE(CODCLIENTE)
);

create TABLE CONSULTA(
CODCONSULTA INT primary KEY auto_increment,
PRECO DOUBLE,
CODDENTISTA INT,
CODCLIENTE INT,
CODFUNCIONARIO INT,
CODEXAME INT,
FOREIGN KEY (CODDENTISTA) REFERENCES DENTISTA(CODDENTISTA),
FOREIGN KEY (CODCLIENTE) REFERENCES CLIENTE(CODCLIENTE),
FOREIGN KEY (CODFUNCIONARIO) REFERENCES FUNCIONARIOS(CODFUNC),
FOREIGN KEY (CODEXAME) references EXAME(CODEXAME)
);

INSERT INTO Cliente(NOME,CPF,CIDADE,TELEFONE,IDADE) VALUES
	('Calebe Ribeiro Salema','15662031612','São João Evangelista','(33)98876-5432',18),
    ('Douglas Carlos Pinto','13209813432','São João Evangelista','(33)98812-2341',16),
    ('Fabiana Tânia Oliveira','54043541511','São João Evangelista','(33)99626-3408',20),
    ('Manuela Alana Cardoso','37428022673','São João Evangelista','(33)99707-0236',23),
    ('Bruno Thales Yuri Almeida','83495051503','São João Evangelista','(31)98738-0121',30),
    ('Letícia Sophia Tereza Teixeira','70310842700','São João Evangelista','(31)98604-2740',22),
    ('Caio Martin Osvaldo Aragão','35964683967','São João Evangelista','(98)99302-1456',25),
    ('Silvana Jaqueline Araújo','48689348301','São João Evangelista','(92)99723-7064',21),
    ('Lucca Lorenzo Giovanni Fernandes','37102215100','São João Evangelista','(55)98195-7445',31),
    ('Fernando Mário Caldeira','02925623905','São João Evangelista','(95)99178-6125',40),
    ('Joana Gabriela Oliveira','54119140784','São João Evangelista','(92)98118-4552',31),
    ('Márcio Enrico Dias','06215166359','São João Evangelista','(51)99975-4210',28),
    ('Benjamin Yuri Caleb Ramos','42106681925','São João Evangelista','(34)99386-7376',31),
    ('João Tiago Almada','80043328970','São João Evangelista','(85)98276-5709',40),
    ('Caleb Severino Lima','47862562771','São João Evangelista','(61) 98224-2929',31),
    ('Sophie Débora Giovana Nascimento','69350027453','São João Evangelista','(95)99404-9519',29),
    ('Nicolas César da Costa','08718104339','São João Evangelista','(67)98433-6376',30),
    ('Sebastião Pedro da Rocha','34183947952','São João Evangelista','(66)99809-8506',25),
    ('Priscila Helena Fogaça','63015956612','São João Evangelista','(48)99936-0563',24),
    ('Thiago Gabriel Mário Pires','02365660754','São João Evangelista','(69)99302-3790',38),
	('Jennifer Juliana Antônia Rodrigues','43162666406','São João Evangelista','(61)99921-6986',19),
    ('Theo Benjamin Pinto','64863583869','São João Evangelista','(83)99846-4613',23),
    ('Luiz Fábio Cauê Araújo','36362462033','São João Evangelista','(84)99445-0224',23),
    ('Cecília Daniela Mariah Assunção','52864435837','São João Evangelista','(81)98655-1144',33),
    ('Elza Caroline Ribeiro','20471541702','São João Evangelista','(84)98670-5526',39),
    ('Renata Isabel Lima','26882131643','São João Evangelista','(31)98604-1234',27),
    ('Luís André Santos','43933913497','São João Evangelista','(62)98805-9211',35),
    ('Otávio Raul Viana','18153483137','São João Evangelista','(54)99678-4274',28),
    ('Sebastião Samuel Nathan da Rocha','74716149277','São João Evangelista','(63)98330-8845',21),
    ('Antonella Giovana Fernanda Sales','90780102070','São João Evangelista','(84)99375-9440',48),
    ('Murilo Francisco Assis','40236856154','São João Evangelista','(92)99490-8297',31),
    ('Analu Sophia Emilly Alves','40811825744','São João Evangelista','(83)98889-2525',23),
    ('Emanuelly Mirella Stefany Santos','66408607241','São João Evangelista','(63)99393-0573',21),
    ('Daniel Gustavo da Rosa','36110195693','São João Evangelista','(51)98392-7120',30),
    ('Thiago Bernardo Galvão','20781920078','São João Evangelista','(82)99441-8844',32),
    ('Mariana Bianca dos Santos','83583008162','São João Evangelista','(71)99794-9022',25),
    ('Matheus Fábio Manoel Ribeiro','84211681931','São João Evangelista','(27)98274-1712',20),
    ('Stella Laís Maya Campos','63923331851','São João Evangelista','(88)98587-7490',35),
    ('Carlos Eduardo Paulo Diego Castro','03879826714','São João Evangelista','(21)98980-7915',28),
    ('Pedro Severino Nathan da Conceição','83490427459','São João Evangelista','(91)99698-5722',18);
select * from cliente;

INSERT INTO FUNCIONARIOS(NOME,CPF,SALARIO,IDADE) VALUES
	('Tereza Lívia Jesus','86119653708','2000',30),
    ('Lorenzo Joaquim Silva','04218632855','2200',27),
    ('Roberto Anthony Teixeira','14165365319','2000',29),
    ('Stefany Benedita Simone Aparício','24211245490','2500',31),
    ('Alana Sara Tânia Viana','67164656347','1500',20);
select * from FUNCIONARIOS;

insert into DENTISTA(NOME,CPF,CONTATO) values
	('Luciana Sônia Nunes','84613255163','llucianasonianunes@tecsysbrasil.com.br'),
    ('Caleb Nelson Peixoto','11071867652','(82) 2779-0457'),
    ('Yuri Eduardo Joaquim Carvalho','86613616133','yurieduardojoaquimcarvalho@bds.com.br'),
    ('Isabelly Adriana da Mata','66303693431','isabellyadrianadamata_@suzano.com.br');
select * from Dentista;

insert into EXAME(CATEGORIA,PRESCRICAO,CODCLIENTE) VALUES
	('Manutenção','Manutenção e Limpeza',1),
    ('Limpeza','Limpeza dos dentes completo',2),
    ('Consulta','Consulta Simples',3),
    ('Aparelho','Retirada do Aparelho',4),
    ('Orçamento','Orçamento Inicial',5),
    ('Manutenção','Manutenção completa',6),
    ('Limpeza','Limpeza simples',7),
    ('Aparelho','Colocar aparelho',8),
    ('Aparelho','Troca de aparelho',9),
    ('Orçamento','Orçamento final',10),
    ('Manutenção','Manutenção',11),
    ('Limpeza','Limpeza dos dentes completo',12),
    ('Consulta','Consulta Simples',13),
    ('Aparelho','Retirada do Aparelho',14),
    ('Orçamento','Orçamento Inicial',15),
    ('Manutenção','Manutenção completa',16),
    ('Limpeza','Limpeza simples',17),
    ('Aparelho','Colocar aparelho',18),
    ('Aparelho','Troca de aparelho',19),
    ('Orçamento','Orçamento final',20),
    ('Manutenção','Manutenção e remoção',21),
    ('Limpeza','Limpeza dos dentes completo',22),
    ('Consulta','Consulta Simples',23),
    ('Aparelho','Retirada do Aparelho',24),
    ('Orçamento','Orçamento Inicial',25),
    ('Manutenção','Manutenção completa',26),
    ('Limpeza','Limpeza simples',27),
    ('Aparelho','Colocar aparelho',28),
    ('Aparelho','Troca de aparelho',29),
    ('Orçamento','Orçamento final',30),
    ('Manutenção','Manutenção e Limpeza',31),
    ('Limpeza','Limpeza dos dentes',32),
    ('Consulta','Consulta Simples',33),
    ('Aparelho','Retirada do Aparelho',34),
    ('Orçamento','Orçamento Inicial',35),
    ('Manutenção','Manutenção completa',36),
    ('Limpeza','Limpeza simples',37),
    ('Aparelho','Colocar aparelho',38),
    ('Aparelho','Troca de aparelho',39),
    ('Orçamento','Orçamento final',40);
select * from Exame;

insert into CONSULTA(PRECO,CODDENTISTA,CODCLIENTE,CODFUNCIONARIO,CODEXAME) values
    (249.0,1,7,5,7),
    (350.0,1,4,5,4),
    (470.0,1,4,4,4);
select * from consulta;    

select c.CODCLIENTE,C.NOME,co.preco,CO.CODDENTISTA,D.NOME from Cliente as C, Consulta as co, Dentista as d
where c.CODCLIENTE = CO.CODCLIENTE
AND CO.PRECO > 100
AND CO.CODDENTISTA >= 2
AND D.CODDENTISTA = CO.CODDENTISTA;

