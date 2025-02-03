# 🌟 Elden Ring Builds - Boss Build Recommender 🌟 #

## 📖 Description

Elden Ring Builds is an application developed in Spring Boot aimed at providing character build recommendations for Elden Ring players. By entering the name of a boss, the application suggests the best build to face it, considering weapons, spells, talismans, and optimized strategies.

The application is based on a database with information about bosses and builds, and the only GET endpoint returns the recommended builds for the selected boss.
---

## 🔧 Technologies Used

- **Java**: Main programming language.
- **Spring Boot**: Framework for building the backend application.
- **Spring Data JPA**: For database interaction.
- **MySQL**: Relational database.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **JPA (Hibernate)**: For object-relational mapping.

---

## 🚀 How to Run the Project

### Prerequisites

Before running the application, make sure the following programs are installed:

- **Java 17+**
- **Maven** (for dependency management)
- **MySQL** (or any compatible database)
- **Docker** (optional for running in containers)

---

### 1️⃣ Database Configuration

- **Create the database** `eldenringbuilds`  in your MySQL.
-Configure the environment variables in the `.env`. file.
- The program only runs with the database, if you want you can create yours, or search on internet a data base with bosses, their weakness and resistences.
- to work properly, you will need a table builds, with some builds, and the essencial column "tipo_dano" that means type of dmg, if its ice dmg, fire dmg.

Exemple:

```env
DB_URL=jdbc:mysql://localhost:3306/eldenringbuilds
DB_USERNAME=root
DB_PASSWORD=root
```
```mysql
CREATE DATABASE EldenRingBuilds;
USE EldenRingBuilds;

CREATE TABLE Bosses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    dificuldade VARCHAR(255),
    fraquezas VARCHAR(255),
    resistencias VARCHAR(255)
);


CREATE TABLE builds (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo_dano VARCHAR(50) NOT NULL,
    tipo_resistencia VARCHAR(50) NOT NULL,
    armas TEXT NOT NULL,
    magias TEXT NOT NULL,
    talismas TEXT NOT NULL,
    estrategia TEXT NOT NULL
);

INSERT INTO Bosses (nome, descricao, dificuldade, fraquezas, resistencias) VALUES
('Radagon of the Golden Order', 'Último chefe antes de Elden Beast, Radagon usa ataques sagrados e tem alto dano físico.', 'Muito Difícil', 'Sangramento, Magia Negra', 'Sagrado, Físico'),

INSERT INTO builds (nome, tipo_dano, tipo_resistencia, armas, magias, talismas, estrategia) VALUES
('Espadachim Sagrado', 'Sagrado', 'Físico', 'Espada Relicário, Espada de Ordovis', 'Chama da Ordem, Lança Relicária', 'Arsenal de Radagon, Proteção de Erdtree', 'Fique perto, abuse do dano sagrado contra inimigos fracos a ele.'),
```
---

2️⃣ Application Setup

The application uses the application.properties file for database configuration. 
The environment variables are automatically read from.env

---

3️⃣ Running the Application

To run the application, simply execute:

```bash
mvn spring-boot:run
```
Or generate the .jar and run:

```bash
mvn clean package
java -jar target/eldenringbuilds-1.0.0.jar
```
The application will be available at http://localhost:8080.

---
🧑‍💻 Main Functionality:

🔥 Endpoint - Build Recommendation
GET /api/builds/{bossName}

This endpoint returns a recommended build based on the provided boss name. Example:
```bash
GET http://localhost:8080/api/builds/malenia
```
Exemple:
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

👨‍💻 How to Contribute:

1. Fork this repository.

2. Create a branch for your feature: git checkout -b my-new-feature.

3. Make your changes and commit with a clear message: git commit -am 'Adding new feature'.

4. Push to your branch: git push origin my-new-feature.

5. Open a Pull Request explaining the changes.

---

📝 License
his project is licensed under the MIT License. For more details, check the LICENSE file.
---
🙌  Acknowledgments
Made with 💙 by Pablo Farina, a passionate fan of Elden Ring and software development.
