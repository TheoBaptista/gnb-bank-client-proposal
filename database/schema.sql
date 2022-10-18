CREATE TABLE user (
  id int PRIMARY KEY AUTO_INCREMENT,
  client_id varchar(255) UNIQUE NOT NULL,
  email varchar(255) UNIQUE NOT NULL,
  name varchar(255) UNIQUE NOT NULL,
  last_name varchar(255) NOT NULL,
  phone_number varchar(255) NOT NULL,
  birthdate date NOT NULL,
  cpf varchar(255) UNIQUE NOT NULL,
  password varchar(255) NOT NULL,
  created_at timestamp
);

CREATE TABLE propose (
  id int PRIMARY KEY AUTO_INCREMENT,
  client_id varchar(255) UNIQUE NOT NULL,
  status ENUM ('NAO_ELEGIVEL', 'ELEGIVEL'),
  status_cartao ENUM ('NEGADO', 'EM_PROCESSAMENTO', 'CRIADO')
);

ALTER TABLE propose ADD FOREIGN KEY (client_id) REFERENCES user (client_id);