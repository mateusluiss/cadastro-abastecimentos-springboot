# ⛽ Sistema de Abastecimento  

## 📌 Sobre o projeto  
O **Sistema de Abastecimento** é uma aplicação backend desenvolvida em **Spring Boot** para gerenciar abastecimentos realizados em bombas de combustível.  
O sistema foi projetado seguindo a **arquitetura em camadas (Controller → Service → Repository)**, boas práticas de desenvolvimento e tratamento de exceções centralizado.  

Este projeto tem como objetivo demonstrar conceitos de:  
- CRUD com Spring Data JPA  
- Relacionamentos entre entidades (Ex: Abastecimento ↔ Bomba)  
- Validações com Bean Validation  
- Uso de DTOs para entrada e saída de dados  
- Tratamento de exceções com `@ControllerAdvice`  

---

## ⚙️ Funcionalidades  
- **Cadastrar abastecimento** indicando a bomba e a litragem.  
- **Listar todos os abastecimentos** registrados.  
- **Buscar abastecimento por ID**.  
- **Deletar abastecimento** com validação de existência.  
- **Validações automáticas** (campos obrigatórios, dados inválidos).  
- **Tratamento de erros** retornando mensagens claras em JSON.  

---

## 🛠️ Tecnologias utilizadas  
- **Java 17**  
- **Spring Boot**  
  - Spring Web  
  - Spring Data JPA  
  - Bean Validation  
- **PostgreSQL**  
- **Maven**  
- **Lombok**  

---
## ▶️ Como executar o projeto 
1. Abra o terminal ou Git Bash.

2. Navegue até a pasta onde você quer clonar o projeto:

    ```bash
    cd caminho/para/sua/pasta
    ```

3. Clone o repositório usando o comando `git clone`:

    ```bash
    git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
    ```

4. Entre na pasta do projeto:

    ```bash
    cd NOME_DO_REPOSITORIO
    ```
