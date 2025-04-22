# PROJECT REPORT

## Project Title: SimForge Platform – A Web-Based Marketplace for CFD and FEA Engineering Solutions

### Problem Statement
**Objective**: To design and implement SimForge Platform, a full-stack e-commerce web application tailored for the distribution of ready-to-use CFD and FEA engineering solutions. The platform serves as a bridge between engineering experts and clients across aerospace, automotive, energy, and manufacturing sectors, providing instant access to high-value simulation deliverables.

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
![Picture1](https://github.com/user-attachments/assets/1121cda4-cc71-4bde-90d2-d9e51a1e1541)

#### Backend Class Diagrams
![Picture2](https://github.com/user-attachments/assets/ac630b43-0536-4d00-9279-a2dfe1b59ec7)

---

### Architecture

#### Monolithic Architecture
![Picture3](https://github.com/user-attachments/assets/8c568da0-3653-4ce8-8c31-5e36c7913ec6)
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
![Picture4](https://github.com/user-attachments/assets/8b498998-05b1-4ce4-850c-34bf200a83ef)


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
4. Build docker image for back-end API
   ```bash
   docker build -t phiducngo/cfd-fea-api:1.0.4 .
5. Push back-end image to Docker Hub (https://hub.docker.com/)
   ```bash
   docker push phiducngo/cfd-fea-api:1.0.4
6. Create Web App
   Go to App Services, create Web App and select Publish as Container.
   ![image](https://github.com/user-attachments/assets/5e91f51d-9e46-476f-8683-9fa99d42674e)

**In Deployment -> Deployment Center, configure**

  - **Container type: Docker Compose**

  - **Registry source: Docker Hub**
  - And upload the Docker compose file prepared into Config textbox
![Picture5](https://github.com/user-attachments/assets/f7df2747-bbfe-415c-8705-e6d6a848f970)
![Picture6](https://github.com/user-attachments/assets/fec3adcc-3911-4553-8ba4-8d461a70423f)
![Picture7](https://github.com/user-attachments/assets/9fd9a95e-5dac-4672-81c9-c91e9d7ee64f)
