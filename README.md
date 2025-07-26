This project is a Spring Boot application that integrates ActiveMQ and MySQL to demonstrate how message-driven architecture can work alongside traditional database operations. The primary goal was to build a system that could accept account information via REST APIs, store it in a MySQL database, and simultaneously use ActiveMQ to send and receive messages for asynchronous communication. This combination is powerful for backend systems where data persistence and decoupled service interactions are both necessary.

The project includes core features such as creating, updating, and retrieving account data. This information is stored in a local MySQL database named spring_db, which we created using MySQL Workbench. ActiveMQ is used to manage the messaging layer, where messages can be published and consumed using a publisher and a listener. We used Spring Data JPA to simplify database interactions, and structured the project with clear separation of concerns using service, DAO, controller, and message handling classes.

We resolved dependency issues in the pom.xml file, specifically around the MySQL connector, and corrected package imports and project structure. The system was tested locally with Postman, and all services were verified to ensure that both the database operations and message queues were functioning properly. We used Maven to build and run the application, and Git to version control and push the final version to GitHub.

Technologies used include Spring Boot 3.1.5, Java 17, ActiveMQ, MySQL 8.0+, Spring Data JPA, and Maven. The project was developed and tested using Visual Studio Code. The entire setup was pushed to a GitHub repository under the username sadhvika30.

Overall, this project is a practical implementation of how messaging systems like ActiveMQ can be integrated into real-world backend applications alongside standard RESTful operations and database connectivity. It’s a good starting point for developers looking to build scalable, decoupled systems with Spring Boot.







