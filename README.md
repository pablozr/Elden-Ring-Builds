# 🌟 Elden Ring Builds - Recomendador de Builds para Chefes 🌟

## 📖 Descrição

**Elden Ring Builds** é uma aplicação desenvolvida em **Spring Boot** que tem como objetivo fornecer recomendações de builds de personagens para os jogadores de *Elden Ring*. Ao inserir o nome de um chefe, a aplicação sugere a **melhor build** para enfrentá-lo, levando em consideração armas, magias, talismãs e estratégias otimizadas.

A aplicação é baseada em um banco de dados com informações sobre **chefes** e **builds**, e o único **endpoint** GET retorna as builds recomendadas para o chefe selecionado.

---

## 🔧 Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para construção da aplicação backend.
- **Spring Data JPA**: Para interação com o banco de dados.
- **MySQL**: Banco de dados relacional.
- **Thymeleaf**: Motor de templates para renderização de páginas HTML.
- **JPA (Hibernate)**: Para mapeamento objeto-relacional.

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

Antes de rodar a aplicação, certifique-se de que os seguintes programas estão instalados:

- **Java 17+**
- **Maven** (para gerenciamento de dependências)
- **MySQL** (ou qualquer banco de dados compatível)
- **Docker** (opcional para rodar em containers)

---

### 1️⃣ Configuração do Banco de Dados

- **Crie o banco de dados** `eldenringbuilds` no seu MySQL.
- Configure as variáveis de ambiente no arquivo `.env`.

Exemplo:

```env
DB_URL=jdbc:mysql://localhost:3306/eldenringbuilds
DB_USERNAME=root
DB_PASSWORD=root
```
---

2️⃣ Configuração da Aplicação
A aplicação usa o arquivo application.properties para configuração do banco de dados.
As variáveis de ambiente são lidas automaticamente de .env

---

3️⃣ Rodando a Aplicação
Para rodar a aplicação, basta executar:

```bash
mvn spring-boot:run
```
Ou gerar o .jar e executar:

```bash
mvn clean package
java -jar target/eldenringbuilds-1.0.0.jar
```
A aplicação estará disponível em http://localhost:8080.

---
🧑‍💻 Funcionalidade Principal:
🔥 Endpoint - Recomendação de Build
GET /api/builds/{bossName}
Este endpoint retorna uma build recomendada com base no nome do chefe fornecido. Exemplo:

```bash
GET http://localhost:8080/api/builds/malenia
```
Exemplo de Resposta:
```json
{
  "nome": "Malenia",
  "arma": "Greatsword",
  "magias": "Flame, Grant Me Strength",
  "talismas": "Radagon's Scarseal",
  "estrategia": "Use fire-based attacks to exploit Malenia's weakness."
}
```
---

👨‍💻 Como Contribuir:
Fork este repositório.
Crie uma branch para a sua feature: git checkout -b minha-nova-feature.
Faça suas alterações e commit com uma mensagem clara: git commit -am 'Adicionando nova feature'.
Push para sua branch: git push origin minha-nova-feature.
Abra um Pull Request explicando as mudanças.
---

📝 Licença
Este projeto está licenciado sob a MIT License. Para mais detalhes, consulte o arquivo LICENSE.
---
🙌 Agradecimentos
Feito com 💙 por Pablo Farina, um apaixonado por Elden Ring e desenvolvimento de software.
