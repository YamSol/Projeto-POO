CREATE DATABASE projeto_monitoramento;

USE projeto_monitoramento;
MySQLConnection    valor VARCHAR(50),
    unidade VARCHAR(20),
    timestamp DATETIME,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE
);

CREATE TABLE dispositivo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id VARCHAR(50),
    tipo VARCHAR(50),
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE
);
