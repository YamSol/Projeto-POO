
# 🩺 Projeto de Monitoramento de Pacientes

Este projeto Java simula um sistema de monitoramento de pacientes utilizando dispositivos médicos como sensores de batimentos cardíacos, pressão arterial e temperatura corporal. Ele é construído com base nos princípios da Programação Orientada a Objetos (POO), adotando uma arquitetura em camadas para facilitar a manutenção, escalabilidade e reutilização de código.

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

## ✅ Requisitos

- **Java 11** ou superior instalado.
- **IDE recomendada:** IntelliJ IDEA (mas não obrigatório).

## ▶️ Como Executar

1. Compile os arquivos do diretório `src/`:
   ```bash
   javac src/**/*.java
   ```
2. Execute o programa iniciando pela classe `Main`:
   ```bash
   java src/Main
   ```
3. Use o menu exibido no terminal para navegar pelas opções do sistema.

## 🙌 Contribuindo

Contribuições são sempre bem-vindas!  
Confira o arquivo [`TODO.md`](./TODO.md) para visualizar sugestões de melhorias e funcionalidades planejadas.

## 📄 Licença

Este projeto tem finalidade exclusivamente educacional e não deve ser utilizado em ambientes clínicos reais.
