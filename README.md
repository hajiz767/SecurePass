# SecurePass: Credential Breach Detection Tool

SecurePass is a Spring Boot application designed to help users identify compromised credentials without sacrificing privacy. This project bridges the gap between web development and cybersecurity by implementing the K-Anonymity model for secure API communication.

## 🚀 Key Features
* **Breach Detection:** Integrates with the **Have I Been Pwned** REST API to cross-reference credentials against billions of leaked records.
* **Privacy-Preserving (K-Anonymity):** Only the first 5 characters of a SHA-1 hash are sent to the API. The final comparison happens locally, ensuring plain-text passwords never leave the system.
* **Security Metrics:** Evaluates password entropy and complexity to provide actionable feedback on credential strength.
* **Architecture:** Built using **Spring MVC** to ensure a clean separation of concerns between security logic and the user interface.

## 🛠 Tech Stack
* **Backend:** Java 17, Spring Boot (Web, Data JPA)
* **Security:** SHA-1 Hashing (MessageDigest), K-Anonymity
* **Frontend:** Thymeleaf, CSS3
* **Build Tool:** Maven

## 🧠 Engineering Takeaways
* **Handling Sensitive Data:** Learned to implement hashing strategies that prevent plain-text exposure during external API calls.
* **Component Design:** Developed a modular service layer to handle hash generation and API response parsing separately.
* **State Management:** Used Spring's MVC pattern to maintain a responsive and intuitive user dashboard.

## ⚙️ Setup
1. Clone the repository: `git clone https://github.com/yourusername/SecurePass.git`
2. Build and run: `./mvnw spring-boot:run`
3. Access at: `http://localhost:8080`
