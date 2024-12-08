# PROJECT REPORT

## Project Title: Development of an E-Commerce Platform for CFD and FEA Solutions

### Problem Statement
**Objective**: To design and implement an e-commerce platform that caters specifically to professionals, researchers, and organizations in the fields of Computational Fluid Dynamics (CFD) and Finite Element Analysis (FEA). The platform will provide a user-friendly interface to purchase, download, and manage licenses for CFD and FEA software, tools, and resources.

### Objective Analysis

**Target Audience**:
1. **Professionals**: Engineers and scientists involved in CFD and FEA projects in industries like aerospace, automotive, and energy.
2. **Researchers**: Academics and students in universities and research institutions.
3. **Organizations**: Companies that need simulation tools for product development, optimization, or compliance.

**Requirements Analysis**:
- Show a list of products
- Add products to shopping cart (CRUD)
- Shopping cart checkout
- User login/logout security
- Track previous orders for logged-in users

---

### Software Modeling
**Include UML diagrams** such as use case diagrams, class diagrams, or sequence diagrams as applicable.

#### Frontend Class Diagrams
*(Include your diagrams here)*

#### Backend Class Diagrams
*(Include your diagrams here)*

---

### Architecture

#### Monolithic Architecture

**Technologies Used**:
- **Back-end**:
  - Spring Boot, Spring MVC, Spring Data JPA, OKTA Spring Security, MapStruct
  - Database: MySQL
  - Authentication and Authorization: JWT token
  - Testing: JUnit, Mockito, Postman
- **Front-end**:
  - Angular 14.7
  - Bootstrap
  - OKTA: A standards-compliant OAuth 2.0 authorization server

---

### ER Diagram
*(Include your ER diagram here)*

---

### Local Setup Instructions

#### 6.1 Back-end
1. Setup database connection in `application.properties`.
2. Start the application:
   - When the application starts, it creates database products, countries, and states. The setup is in `config/SetupInitialData.java`.

**Step-by-step instructions**:
- *(Include detailed setup instructions and necessary screenshots such as database configuration and running the application)*

#### 6.2 Front-end
1. Configure API URL in `app/service/constant.ts`.
2. Start the application:
   - In the command line, type `npm start` to run the script for HTTPS.

---

### Azure Setup Instructions

**Using Docker Compose to deploy back-end APIs and MySQL on Azure App Services**:

1. Create a `Dockerfile` for the back-end to build the image.
2. Create a Docker Compose file including MySQL and back-end API.
3. Create a JAR file (ensure to comment out database information in `application.properties` to avoid deployment issues):
   ```bash
   mvn clean package -DskipTests
