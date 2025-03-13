# Backend_Traini8_Hemanth_Madishetti
SpringBoot Assignment


Here’s a **detailed `README.md`** file for your **Training Center API** setup, including installation, usage, and filtering instructions.



# **Training Center API**
A **Spring Boot** REST API for managing training centers with filtering capabilities.

## 📌 **Features**
- **Create** and save training centers.
- **Get All Centers
- **Validation** for input fields.
- **Exception Handling** for errors.
- **Response DTOs** to control the response format.

---

## ⚡ **Tech Stack**
- **Spring Boot** (REST API)
- **Spring Data JPA** (Database Access)
- **Hibernate** (ORM)
- **H2 / MySQL** (Database)
- **Lombok** (Boilerplate Code Reduction)
- **ModelMapper** (Object Mapping)

---

## 🔧 **Setup Instructions**
### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/your-username/training-center-api.git
cd training-center-api
```

### **2️⃣ Install Dependencies**
Make sure you have **Java 17+** and **Maven** installed.
```bash
mvn clean install
```

### **3️⃣ Configure the Database**
Modify `application.properties` for **H2 (in-memory)** or **MySQL**.

#### **Option 1: H2 Database (Default)**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
> The H2 console will be available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

#### **Option 2: MySQL**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```
> Run `CREATE DATABASE training_center_db;` in MySQL before starting.

### **4️⃣ Run the Application**
```bash
mvn spring-boot:run
```
> The server will start at **`http://localhost:8080`**.

---

## 📌 **API Documentation**
### **1️⃣ Create Training Center**
#### **Endpoint:** `POST /api/training-centers`
#### **Request Body (JSON)**:
```json
{
    "centerName": "Tech Hub",
    "centerCode": "TECHHUB12345X",
    "address": {
        "detailedAddress": "123 Main Street",
        "city": "Bangalore",
        "state": "Karnataka",
        "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python"],
    "contactEmail": "info@techhub.com",
    "contactPhone": "+919876543210",
    "createdOn": 1741879234  // Will be ignored by the system
}
```
#### **Response:**
```json
{
    "id": 1,
    "centerName": "Tech Hub",
    "centerCode": "TECHHUB12345X",
    "address": {
        "detailedAddress": "123 Main Street",
        "city": "Bangalore",
        "state": "Karnataka",
        "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python"],
    "createdOn": "2025-03-12 14:30:00",
    "contactEmail": "info@techhub.com",
    "contactPhone": "+919876543210"
}
```

---


---

## ⚠️ **Error Handling**
| Scenario  | Error Response |
|------------|--------------|
| **Missing Required Field** | `{"message": "Center name is required"}` |
| **Invalid Email** | `{"message": "Invalid email format"}` |
| **Invalid Center Code** | `{"message": "Center code must be exactly 12 alphanumeric characters"}` |
| **Invalid Phone Number** | `{"message": "Phone number must be 10-15 digits"}` |

---

## 🚀 **Development & Contribution**
### **1️⃣ Install Dependencies**
```bash
mvn clean install
```
### **2️⃣ Run Tests**
```bash
mvn test
```
### **3️⃣ Contribution Guide**
- Fork the repo & create a feature branch.
- Implement your changes & commit.
- Submit a Pull Request.

---

## 🛠️ **Troubleshooting**
| Issue | Solution |
|-------|----------|
| **Database not connecting** | Ensure MySQL is running & `application.properties` is configured. |
| **H2 Console not opening** | Visit `http://localhost:8080/h2-console` & set JDBC URL to `jdbc:h2:mem:testdb`. |
| **CORS Issues** | Add `@CrossOrigin` annotation in `TrainingCenterController`. |

---

## 📜 **License**
This project is licensed under the **MIT License**.

---

## 📞 **Support**
For any issues, please **open an issue** on GitHub or contact **your-email@example.com**.

---

### 🎉 **Now Your README is Ready for Deployment!** 🚀
