<a name="readme-top"></a>

# 📗 Table of Contents

- [📖 About the Project](#about-project)
  - [🛠 Built With](#built-with)
    - [Tech Stack](#tech-stack)
- [💻 Getting Started](#getting-started)
  - [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Install](#install)
  - [Usage](#usage)
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

3. Build the Docker image.
  docker build -t restaurant-api .

4. Once the image is built, you can use Docker Compose to run the container.
docker-compose up -d

5. Access the API endpoints using Swagger.
localhost:8080/swagger-ui/index.html

No additional installation steps are required as the dependencies are managed by Gradle.

Run tests
To run tests, execute the following command:
./gradlew test

<p align="right">(<a href="#readme-top">back to top</a>)</p>
👥 Authors <a name="authors"></a>

    GitHub: @WalidAmmarAli
    Twitter: @AmmarAli3111
    LinkedIn: Ammar Ali

📝 License <a name="license"></a>

This project is MIT licensed.
<p align="right">(<a href="#readme-top">back to top</a>)</p>
