# molas-niqueladas

### Run mysql: 
`docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:5.7`

### Run tables: 

CREATE DATABASE IF NOT EXISTS metalflex;
USE metalflex;

-- Cliente table
CREATE TABLE cliente (
    ID_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    cpf_cnpj VARCHAR(20),
    contato VARCHAR(255),
    logradouro VARCHAR(255),
    cidade VARCHAR(255),
    numero VARCHAR(10),
    uf CHAR(2),
    telefone VARCHAR(15),
    telefone2 VARCHAR(15),
    inscricao_estadual VARCHAR(20),
    email VARCHAR(255),
    cep VARCHAR(10),
    bairro VARCHAR(255)
);

-- Produto table
CREATE TABLE produto (
    ID_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    utilizacao VARCHAR(255),
    estoque_minimo VARCHAR(50),
    ideal_dia DOUBLE
);

-- Entrada_Produto table
CREATE TABLE entrada_produto (
    ID_entrada INT PRIMARY KEY AUTO_INCREMENT,
    ID_produto INT,
    qtde DOUBLE,
    valor_unitario DOUBLE,
    FOREIGN KEY (ID_produto) REFERENCES Produto(ID_produto)
);

-- Estoque table
CREATE TABLE estoque (
    ID_estoque INT PRIMARY KEY AUTO_INCREMENT,
    ID_produto INT,
    qtde DOUBLE,
    nome VARCHAR(255),
    valor_unitario DOUBLE,
    utilizacao VARCHAR(255),
    data DATE,
    estoque_minimo DOUBLE,
    ideal_dia FLOAT,
    quantidade_utilizada FLOAT,
    dias_trabalhados INT,
    produto_coringa VARCHAR(255),
    FOREIGN KEY (ID_produto) REFERENCES Produto(ID_produto)
);

-- Continue with other tables in similar fashion

-- Faturamento table
CREATE TABLE faturamento (
    ID_faturamento INT PRIMARY KEY AUTO_INCREMENT,
    vale VARCHAR(255),
    nfe VARCHAR(255),
    situacao VARCHAR(255),
    ID_cliente INT,
    peso DOUBLE,
    valor DOUBLE,
    data DATE,
    firma VARCHAR(255),
    FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID_CLIENTE)
);

-- Pedido table
CREATE TABLE pedido (
    ID_pedido INT PRIMARY KEY AUTO_INCREMENT,
    `OF` VARCHAR(50),
    codigo VARCHAR(50),
    data_pedido VARCHAR(50),
    data_entrega VARCHAR(50),
    quantidade INT,
    tipo VARCHAR(50),
    ID_cliente INT,
    status VARCHAR(50),
    path_desenho VARCHAR(255),
    nome_cliente VARCHAR(255),
    qtde_itens_mes VARCHAR(50),
    FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID_CLIENTE)
);

-- Qualidade table
CREATE TABLE qualidade (
    ID_qualidade INT PRIMARY KEY AUTO_INCREMENT,
    `of` int,
    codigo VARCHAR(50),
    ID_cliente INT,
    qtde INT,
    sobra INT,
    abertura VARCHAR(50),
    arame VARCHAR(50),
    externo VARCHAR(50),
    interno VARCHAR(50),
    passo VARCHAR(50),
    lo_corpo VARCHAR(50),
    lo_total VARCHAR(50),
    espiras VARCHAR(50),
    acabamento VARCHAR(50),
    obs VARCHAR(255),
    FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID_CLIENTE)
);

-- Relogio table
CREATE TABLE relogio (
    ID_relogio INT PRIMARY KEY AUTO_INCREMENT,
    inicio INT,
    fim INT,
    data DATE
);

-- Saida table
CREATE TABLE saida (
    ID_saida INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    ID_produto INT,
    FOREIGN KEY (ID_produto) REFERENCES Produto(ID_produto)
);

-- Saida_Produto table
CREATE TABLE saida_produto (
    ID_saida INT PRIMARY KEY AUTO_INCREMENT,
    ID_produto INT,
    qtde DOUBLE,
    banho VARCHAR(50),
    valor_unitario DOUBLE,
    FOREIGN KEY (ID_produto) REFERENCES Produto(ID_produto)
);

-- Usuario table
CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50),
    senha VARCHAR(50),
    perfil VARCHAR(50)
);


### Create User
nome   | senha  | perfil
master | master | gerente
