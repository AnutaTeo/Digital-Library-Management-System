# Digital Library Management System
### Milestone 5 – Message Queue & CI/CD Integration

This project implements a **microservices-based Digital Library Management System**, extended in **Milestone 5** with:
- **Asynchronous communication using a message queue (RabbitMQ)**
- **A complete CI/CD pipeline using GitHub Actions**
- **Automated tests executed in the CI pipeline**
- **Docker-based deployment to a local environment**

The goal of this milestone is to demonstrate decoupled microservices communication, automated validation and deployment readiness.

---

## System Overview

The system is composed of multiple independent microservices, each modeling a core concept of a digital library:

- **User Service** – manages library users (members)
- **Catalog Service** – manages books and catalog information
- **Borrowing Service** – handles borrowing and returning of books
- **Notification Service** – sends notifications related to borrowing events
- **RabbitMQ** – message broker enabling asynchronous communication

Each service is developed, built, tested and deployed independently.

---

## Message Queue Integration (RabbitMQ)

### Purpose of Using a Message Queue
RabbitMQ is used to enable **asynchronous, event-driven communication** between microservices.  
Instead of services calling each other directly via REST, important events are published to a message queue and consumed by interested services.

This approach improves:
- **Decoupling** – services do not depend directly on each other
- **Scalability** – consumers can be scaled independently
- **Fault tolerance** – messages are preserved even if a consumer is temporarily unavailable

---

### How RabbitMQ Is Integrated

RabbitMQ is deployed as a **separate service** using Docker Compose and runs alongside the microservices.

**Example interaction:**
- The **Borrowing Service** publishes an event when a book is borrowed.
- The **Notification Service** consumes this event and processes it (e.g. sending a notification).

The producer does not know which service consumes the message, ensuring loose coupling.

---

### Asynchronous Communication Flow

1. A user borrows a book through the Borrowing Service.
2. The Borrowing Service registers the borrowing in its database.
3. A `BookBorrowed` event is published to RabbitMQ.
4. The Notification Service listens to the queue.
5. When the event arrives, the Notification Service processes it asynchronously.

This ensures that the borrowing operation does not block waiting for notifications to be processed.

---

### Benefits Demonstrated

- **Decoupling**: Borrowing and Notification services are independent.
- **Fault tolerance**: If the Notification Service is down, messages remain in the queue.
- **Scalability**: Multiple consumers can be added without modifying the producer.
- **Asynchronous execution**: Faster response times for user actions.

---

## CI/CD Pipeline (GitHub Actions)

### Overview

A **CI/CD pipeline** is implemented using **GitHub Actions**.  
The pipeline runs automatically on each code change and validates that the system is buildable, testable, and deployable.

The workflow definition is located at: `.github/workflows/main.yml`

---

### Pipeline Responsibilities

The CI/CD pipeline performs the following steps automatically:

1. **Builds and tests all microservices**
    - Runs Maven builds for each service.
    - Executes automated tests that validate core digital library functionality:
        - Registering users
        - Adding books to the catalog
        - Borrowing books
    - External dependencies such as RabbitMQ and other microservices are mocked where necessary to ensure reliable CI execution.

2. **Builds Docker images**
    - Creates Docker images for all microservices.
    - Validates Dockerfiles and Docker Compose configuration.
    - Ensures the system is correctly packaged for local deployment.

---

### How to Observe the CI/CD Pipeline

The CI/CD pipeline runs automatically on every push or pull request.

To observe the pipeline execution:

1. Open the GitHub repository.
2. Navigate to the **Actions** tab.
3. Select the most recent workflow run.
4. Inspect the logs for each step, including:
    - Maven build
    - Test execution
    - Docker image build

No manual intervention is required.

---

## Automated Testing

The project includes **automated tests** that simulate real digital library behavior and are executed as part of the CI/CD pipeline.

The implemented functional tests cover the following scenarios:

- **User Service**: registering a new library user
- **Catalog Service**: adding a book to the catalog
- **Borrowing Service**: borrowing a book

External dependencies such as other microservices and RabbitMQ are mocked where necessary to ensure that tests are **isolated**, **reliable**, and suitable for automated CI execution.

---

## Conclusion

By integrating RabbitMQ and a complete CI/CD pipeline, this project demonstrates:

- Event-driven, asynchronous communication between microservices
- Improved decoupling, scalability, and fault tolerance
- Automated building, testing, and deployment validation
- A clear and maintainable microservices architecture
