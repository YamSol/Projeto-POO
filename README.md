# 🩺 Projeto de Monitoramento de Pacientes

Este projeto em Java simula um sistema de monitoramento de pacientes utilizando dispositivos médicos como sensores de batimentos cardíacos, pressão arterial e temperatura corporal.

O desenvolvimento segue os princípios da Programação Orientada a Objetos (POO), com ênfase em herança, encapsulamento e especialmente **polimorfismo**, permitindo que diferentes dispositivos de monitoramento compartilhem uma interface comum e sejam tratados de forma unificada no código.

## 📁 Estrutura do Projeto

```
Projeto-POO-master/
│
├── dados/                          # Armazenamento de dados simulados
│   ├── leituras/                   # Leituras de sensores
│   └── pacientes/                  # Informações dos pacientes
│
├── src/                            # Código-fonte principal
│   ├── controller/                 # Camada de controle e orquestração
│   │   ├── ConcentradorDeDados.java
│   │   └── Servidor.java
│   │
│   ├── database/                   # Simulação de banco de dados
│   │   └── BancoDeDados.java
│   │
│   ├── model/                      # Entidades e dispositivos médicos
│   │   ├── Dado.java
│   │   ├── Paciente.java
│   │   ├── DispositivoDeMonitoramento.java
│   │   ├── DispositivoDeBatimentoCardiaco.java
│   │   ├── DispositivoDePressao.java
│   │   └── DispositivoDeTemperatura.java
│   │
│   ├── view/                       # Interface de usuário via terminal
│   │   └── Menu.java
│   │
│   └── Main.java                   # Classe principal que inicia o sistema
│
├── .gitignore                      # Arquivos ignorados pelo Git
├── Projeto-POO.iml                 # Arquivo de projeto (IntelliJ IDEA)
└── TODO.md                         # Lista de tarefas e melhorias futuras
```

## ⚙️ Funcionalidades

- 📋 Cadastro e gerenciamento de pacientes.
- 📡 Simulação de sensores médicos:
  - Monitor de batimentos cardíacos.
  - Sensor de pressão arterial.
  - Termômetro corporal.
- 💾 Armazenamento de leituras simuladas.
- 🖥️ Interface textual para navegação e uso do sistema.

## 💡 Abordagens Técnicas

- Utilização de **interfaces e classes abstratas** para definição de comportamentos genéricos dos sensores.
- Implementação de dispositivos como batimentos cardíacos, pressão e temperatura usando herança.
- Uso de APIs padrão do Java, como:
  - `java.io` para manipulação de arquivos.
  - `java.util` para estrutura de dados como listas.
  - `java.time` para registro temporal das leituras.

## ✅ Requisitos

- Java 11 ou superior.

## ▶️ Como Executar

1. Compile o projeto:
   ```bash
   javac src/**/*.java
   ```
2. Execute a aplicação:
   ```bash
   java src/Main
   ```
## 🙌 Contribuindo

Contribuições são bem-vindas! Consulte o arquivo `TODO.md` para ideias de melhorias.

## 📄 Licença

Este projeto tem fins educacionais e não deve ser usado em aplicações clínicas reais.

## 👥 Contribuidores

- **Gustavo Pivoto Ambrósio**  
  [@GustavoPivoto](https://github.com/GustavoPivoto) • Collaborator

- **Lucca Santos**  
  [@lucca-santos](https://github.com/lucca-santos) • Collaborator

- **Lucca Zogbi**  
  [@luccazogbi](https://github.com/luccazogbi) • Collaborator

- **Lucas do Lago Figueiredo**  
  [@olucas-fg](https://github.com/olucas-fg) • Collaborator

- **Yam Sol Bertamini**  
  [@yamsol](https://github.com/YamSol) • Collaborator
