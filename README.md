# 🕵️‍♂️ Spy Mission Manager

Welcome to the **Spy Mission Manager** application! This Spring Boot and Thymeleaf application allows users to select a spy, view their assigned missions, and manage mission details. Perfect for those looking to manage covert operations! 🕶️

## 🚀 Features

- **Spy Selection**: Choose one of three spies to view their current missions.
- **Mission Management**: Add, edit, and delete missions for each spy.
- **Dynamic Interface**: Built with Thymeleaf for seamless page updates.
- **Bootstrap & CSS**: Sleek and responsive design for an engaging user experience.

## 📂 Project Structure

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── code.app.spy             # Application's Java source code
│   │   ├── resources
│   │   │   ├── templates                # Thymeleaf HTML templates
│   │   │   ├── application.properties   # Application configurations
│   │   │   └── schema.sql               # SQL file to create initial database schema
│   └── test                             # Unit tests
├── Dockerfile                           # Docker configuration for building app image
├── docker-compose.yml                   # Docker Compose configuration for app and database
├── pom.xml                              # Project dependencies and build configuration (for Maven)
└── README.md                            # Project documentation
```

## 🛠️ Prerequisites

- **Java 21**
- **Maven** for dependency management
- **MySQL** or **PostgreSQL** (Optional)

## 📦 Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/harshil-padasala/spyapp.git
   cd spyapp
   ```

2. **Set up the database** (if applicable):
   - Create a database and update the connection details in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/spy_missions_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Build the application**:
     ```bash
     mvn clean install
     ```

4. **Run the application**:
   ```bash
   java -jar target/spyapp-0.0.1-SNAPSHOT.jar
   ```

### 🐳 Dockerfile

The `Dockerfile` to containerize the Spring Boot application.

### 🐳 docker-compose.yml

The `docker-compose.yml` file to configure the Spring Boot application and PostgreSQL database containers.

## 🌐 Usage

- **Access the application**: Once started, go to [http://localhost:8080](http://localhost:8080).
- **Select a Spy**: Choose one of the three available spies to view their current mission list.
- **Mission Management**:
  - **Add Mission**: Assign new missions to a selected spy.
  - **Edit Mission**: Update mission details as needed.
  - **Delete Mission**: Remove missions that are completed or no longer relevant.

## 📄 Configuration

You can configure application-specific settings in the `application.properties` or `application.yml` files. Some common configurations:

```properties
# Server settings
server.port=8080
```

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 💬 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

---

Enjoy managing covert missions with the Spy Mission Manager! 🕵️‍♀️🌐

---
