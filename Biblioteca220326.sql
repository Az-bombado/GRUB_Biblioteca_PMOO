-- Criação das Tabelas (Biblioteca):
CREATE TABLE cliente (
	pk_cliente SERIAL PRIMARY KEY,
	codigo_cliente INTEGER UNIQUE,
	nome_cliente VARCHAR (50) NOT NULL,
	cpf VARCHAR (11) NOT NULL UNIQUE,
	emprestimo_ativo BOOLEAN,
	cadastro_ativo BOOLEAN
);

CREATE TABLE bibliotecario(
	pk_bibliotecario SERIAL PRIMARY KEY,
	codigo_bibliotecario INTEGER UNIQUE,
	nome_bibliotecario VARCHAR (50) NOT NULL,
	senha VARCHAR (20) NOT NULL
);

CREATE TABLE autor (
	pk_autor SERIAL PRIMARY KEY,
	nome_autor VARCHAR (50)NOT NULL
);

CREATE TABLE livro (
	pk_livro SERIAL PRIMARY KEY,
	codigo_livro INTEGER UNIQUE,
	isbn VARCHAR (20) UNIQUE,
	titulo VARCHAR (100) NOT NULL,
	data_publicacao DATE,
	quantidade_estoque INTEGER DEFAULT 0,
	quantidade_emprestada INTEGER DEFAULT 0,
	fk_autor INTEGER,
	
	CONSTRAINT fk_livro_autor 
        FOREIGN KEY (fk_autor) REFERENCES autor(pk_autor)
);

-- Relacionamento entre tabelas (Empréstimo):
CREATE TABLE emprestimo (
	pk_emprestimo SERIAL PRIMARY KEY,
	fk_livro INTEGER NOT NULL,
	fk_cliente INTEGER NOT NULL,
	fk_bibliotecario INTEGER NOT NULL,
	data_emprestimo DATE NOT NULL,
	data_devolucao_prevista DATE NOT NULL,

    CONSTRAINT fk_emprestimo_livro 
        FOREIGN KEY (fk_livro) REFERENCES livro (pk_livro),
        
    CONSTRAINT fk_emprestimo_cliente 
        FOREIGN KEY (fk_cliente) REFERENCES cliente (pk_cliente),
        
    CONSTRAINT fk_emprestimo_bibliotecario
        FOREIGN KEY (fk_bibliotecario) REFERENCES bibliotecario (pk_bibliotecario)
);

-- Só pro Teste
-- inserindo Dados:
-- Inserindo Autores:
	INSERT INTO autor (nome_autor)
	VALUES ('J.K. Rowling'),
		   ('George R.R. Martin'),
		   ('J.R.R. Tolkien');

-- Inserindo Clientes:
	INSERT INTO cliente (codigo_cliente, nome_cliente, cpf, emprestimo_ativo, cadastro_ativo)
	VALUES (101, 'Ana Silva', '12345678901', FALSE, TRUE),
		   (102, 'Bruno Souza', '98765432100', FALSE, TRUE);

-- Inserindo Bibliotecários:
	INSERT INTO bibliotecario (codigo_bibliotecario, nome_bibliotecario, senha)
	VALUES (1, 'Admin_Marcos', 'senha123'),
	       (2, 'Paula_Biblio', 'livros456');


	INSERT INTO livro (codigo_livro, isbn, titulo, data_publicacao, quantidade_estoque, fk_autor)
	VALUES (501, '978-8532511010', 'Harry Potter e a Pedra Filosofal', '1997-06-26', 10, 1),
		   (502, '978-8576573005', 'A Guerra dos Tronos', '1996-08-01', 5, 2),
		   (503, '978-8535914849', 'O Senhor dos Anéis', '1954-07-29', 8, 3);

	INSERT INTO emprestimo (fk_livro, fk_cliente, fk_bibliotecario, data_emprestimo, data_devolucao_prevista)
	VALUES (1, 1, 1, CURRENT_DATE, CURRENT_DATE + 7); -- "Current" Date puxa a data da máquina,
													  -- "+" soma um número a esta data.
--Consulta das Tabelas:
SELECT * FROM cliente;
SELECT * FROM bibliotecario;
SELECT * FROM autor;
SELECT * FROM livro;

-- Consulta dos Empréstimos:
SELECT * FROM emprestimo;



