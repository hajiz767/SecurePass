# SecurePass: Java-Based Security Analysis Tool

**SecurePass** is a professional-grade password health and breach detection application built using the **Spring Boot** framework. This project demonstrates the integration of software engineering best practices with core cybersecurity principles.

## Key Features
* **Real-Time Strength Analysis:** Implements complex logic to evaluate password entropy and complexity.
* **HIBP API Integration:** Utilizes the "Have I Been Pwned" REST API to check for credential leaks among 10B+ compromised accounts.
* **Privacy-First Design (K-Anonymity):** Implements a security model where only the first 5 characters of a SHA-1 hash are transmitted externally, ensuring user data never leaves the local environment.
* **Automated Hashing:** Uses Java's `MessageDigest` to perform one-way SHA-1 hashing for secure data comparison.

## Tech Stack
* **Language:** Java 17/21
* **Framework:** Spring Boot (Web, Thymeleaf)
* **Security:** SHA-1 Hashing, K-Anonymity
* **Build Tool:** Maven
* **Frontend:** HTML5, CSS3 (Thymeleaf templates)

## What I Learned
Through this project, I gained hands-on experience in:
1.  **MVC Architecture:** Decoupling business logic (Services) from request handling (Controllers).
2.  **RESTful API Consumption:** Using `RestTemplate` to handle asynchronous data from external security databases.
3.  **Cybersecurity Fundamentals:** Understanding one-way hashing, salting concepts, and the importance of preventing plain-text data transmission.

## Getting Started
1. Clone the repository: `git clone https://github.com/yourusername/SecurePass-Manager.git`
2. Run the application via Maven: `./mvnw spring-boot:run`
3. Access the dashboard at: `http://localhost:8080`
