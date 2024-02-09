<a name="readme-top"></a>

# 📗 Table of Contents

- [📖 About the Project](#about-project)
  - [🛠 Built With](#built-with)
    - [Tech Stack](#tech-stack)
- [💻 Getting Started](#getting-started)
  - [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Run tests](#run-tests)
- [👥 Authors](#authors)
- [📝 License](#license)


# 📖 API Restaurant Backend <a name="about-project"></a>

This project is an API developed in Java 17 (or 11), Spring Boot, and Gradle for managing restaurant reservations, including a menu system connected to an SQL database.

## 🛠 Built With <a name="built-with"></a>

### Tech Stack <a name="tech-stack"></a>

- Java 17 (or 11)
- Spring Boot
- Gradle
- SQL Database (e.g., MySQL)
- Docker
- Swagger

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## 💻 Getting Started <a name="getting-started"></a>

### Prerequisites

In order to run this project, you need:

- Java 17 (or 11) installed
- Docker installed

### Setup

1. Clone the repository.
    git clone https://github.com/ammarAlaliS/Restaurant-Api.git

2. Navigate to the project directory.
    cd restaurant-api

3. Build the Docker images whit the following comand.
    docker-compose build

4. Once the image is built, you can use Docker Compose to run the container.
    docker-compose up 

5. Access the API endpoints using Swagger.
    localhost:8080/swagger-ui/index.html

No additional installation steps are required as the dependencies are managed by Gradle.

<h1>OBJETIVE</h1>
<ul>
  <li>Create a new reservation</li>
  <li>Implement methods to perform queries and updates in the database</li>
  <li>Get reservation information by ID</li>
  <li>List all reservations made</li>
  <li>Cancel a reservation</li>
  <li>List all menu dishes</li>
  <li>Get dish information by ID</li>
</ul>


To run tests, execute the following command:
./gradlew test

📝 License <a name="license"></a>

This project is MIT licensed.
<p align="right">(<a href="#readme-top">back to top</a>)</p>
