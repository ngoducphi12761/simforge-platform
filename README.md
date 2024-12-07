
					PROJECT REPORT

Project Title: Development of an E-Commerce Platform for CFD and FEA Solutions
Problem Statement:
1.	Objective: To design and implement an e-commerce platform that caters specifically to professionals, researchers, and organizations in the fields of Computational Fluid Dynamics (CFD) and Finite Element Analysis (FEA). The platform will provide a user-friendly interface to purchase, download, and manage licenses for CFD and FEA software, tools, and resources.



Objective Analysis
Target Audience:
1.	Professionals: Engineers and scientists involved in CFD and FEA projects in industries like aerospace, automotive, and energy.
2.	Researchers: Academics and students in universities and research institutions.
3.	Organizations: Companies that need simulation tools for product development, optimization, or compliance.
2.	Requirements Analysis:
-	Show a list of products
-	Add products to shopping cart (CRUD)
-	Shopping cart check out
-	//User login/logout security
-	Track previous orders for logged in users

 
3.	Software Modeling: Include UML diagrams such as use case diagrams, class diagrams, or sequence diagrams as applicable.
 	Frontend Class diagrams:
 

 
 	Backend Class diagrams
 

4.	Architecture:
Monolithic architecture:
Technologies used:
Back-end:
•	SpringBoot, Spring MVC, Spring Data JPA,OKTA Spring Security, MapStruct
•	Database: MySQL
•	Authentication and Authorization: JWT token
•	Testing: JUnit, Mockito, Postman
Front-end
•	Angular 14.7
•	Bootstrap, OKTA: a standards-compliant OAuth 2.0 authorization serve

 




 

5.	ER Diagram:
 
 
6. Local Setup Instructions
6.1 Back-end
1. Setup database connection in application.properties
2. Start the application
When the application starts, it creates database products, countries and states. The setup is in config/SetupInitialData.java
Provide step-by-step instructions for setting up the application.
Include necessary screenshots (e.g., database configuration, running the application).
 6.2 Front-end
1. Configure API URL in app/service/constant.ts
2. Start the application (in command line type "npm start" to run script about https) 

7. Azure Setup Instructions

	Using Docker compose to deploy back-end APIs and MySQL on Azure App Services
1.	Create Dockerfile for back-end to build image
2.	Create Docker compose file including MySQL and back-end API
3.	Create jar file (make sure to comment out database information in application.properties file. If not, it does not work when deploying to Azure)
mvn clean package -DskipTests
4.	Build docker image for back-end API
docker build -t phiducngo/cfd-fea-api:1.0.1 .
5.	Push back-end image to Docker Hub (https://hub.docker.com/)
docker push phiducngo/ cfd-fea-api:1.0.1
6.	Create Web App on Azure cloud
 
 

 


 



7.	Thank you

Specially thanks to 
