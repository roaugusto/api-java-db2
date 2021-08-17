DROP TABLE IF EXISTS tickets;

CREATE TABLE tickets (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  num_ticket VARCHAR(250) NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);

--INSERT INTO tickets (num_Ticket, description) VALUES
--  ('NUM00001', 'Arquivo criado com tamanho errado'),
--  ('NUM00010', 'Erro no acesso a tabela XXXXX');