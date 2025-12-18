# Digital Library Management System – Microservices

This project implements a **Digital Library Management System (DLMS)** using a **microservices architecture**.

The system is split into three independent Spring Boot services:

1. **User Service** – manages library users  
2. **Catalog Service** – manages books  
3. **Borrowing Service** – coordinates borrowing between users and books

All services run in **Docker containers** and communicate over HTTP using REST APIs.  
This README explains exactly how to run the system and how to test it using **Postman**.

---

## 1. Architecture Overview

### 1.1 Services & Responsibilities

| Service           | Port  | Responsibility                                              |
|-------------------|-------|------------------------------------------------------------|
| `user-service`    | 8081  | Create, list users and validate user existence (for borrowing)                                      |
| `catalog-service` | 8082  | Add books, retrieve all books and check if a book exists                                      |
| `borrowing-service` | 8083 | Validate that a user exists (via UserService), validate that a book exists (via CatalogService), create a borrowing record and list all borrowings. |

All services use an **in-memory H2 database**, so no database installation is required.  
Data is reset each time the containers are restarted.
Books and users must be created **before borrowing**.

### 1.2 Communication Between Services

- `borrowing-service` calls:
  - `user-service`  
  - `catalog-service`  

---

## 2. Technologies Used

- **Java 21**
- **Spring Boot 3**
- **Spring Web / Spring Data JPA / H2**
- **Docker & Docker Compose**
- **Postman**

---

## 3. Prerequisites

- Docker Desktop:
https://www.docker.com/products/docker-desktop  
- Git (to clone the repository):
https://github.com/
- Postman (used for testing):
https://www.postman.com/downloads/
---

## 4. How to Run the System

### 4.1 Clone the Repository

```bash
git clone <REPOSITORY_URL>
cd <CLONED_FOLDER_NAME>
```

### 4.2 Start All Services

```bash
docker compose up --build
```
This command will:

- Build all 3 microservices  
- Create a shared Docker network  
- Start all services in the correct order  
- Expose ports 8081, 8082 and 8083  

Wait a few seconds until you see:

```
Tomcat started on port 8081
Tomcat started on port 8082
Tomcat started on port 8083
```
This means all services are running.

### 4.3 Stop Services

```bash
Ctrl + C
docker compose down
```
---

## 5. API Endpoints

### User Service (`http://localhost:8081`)

POST `/users`
```json
{
  "name": "Ana",
  "email": "ana@gmail.com"
}
```

GET `/users` – list users

---

### Catalog Service (`http://localhost:8082`)

POST `/books`
```json
{
  "title": "Harry Potter",
  "author": "J.K. Rowling",
  "genre": "Fantasy",
  "year": 1997
}
```

GET `/books` – list books

---

### Borrowing Service (`http://localhost:8083`)

POST `/borrow`
```json
{
  "userId": 1,
  "bookId": 1
}
```
If everything works, you will get a JSON response confirming the borrowing.

---

## 6. Testing with Postman

This project includes a Postman collection that mirrors all API endpoints.

### Import the Postman Collection

1. Open Postman  
2. Click **Import**  
3. Select the provided `postman_collection.json`  
4. Send requests in this order:
   - Create User  
   - Create Book  
   - Borrow Book  

Each request should return HTTP 200 or 201.

---

## 7. Troubleshooting

### Ports in use
Change the port mapping in `docker-compose.yml`.

### Docker command not found
Install Docker Desktop.

### Postman returns "could not get any response"
- Check if Docker is running  
- Ensure the logs show “Tomcat started”  
- Verify URLs (must use localhost)

### Borrowing Service returns 500
Cause: User or Book does not exist in H2  
Fix: Create them again - H2 resets on container restar

---

## 8. Conclusion

This project demonstrates:

- Microservices architecture  
- REST communication between services  
- Docker-based deployment  
- Clear, reproducible testing using Postman  

Run everything with:

```bash
docker compose up --build
```

Stop with:

```bash
docker compose down
```
And tested completely with the included Postman collection.