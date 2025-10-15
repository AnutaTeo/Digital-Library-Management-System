# Digital Library Management System

## Team Members
- Surugiu Ioana-Monica
- Teodorescu Ana-Maria

## Project Description
**Digital Library Management System** is a useful digital platform designed to help users search for books, borrow and return items, as well as, access digital materials such as e-books and research papers.  
Administrators can manage the catalog, monitor borrowing activity, send notifications and generate books recommendations.

## Key User Roles
- **User / Client:**  
  Can register, search for books, borrow or return items, reserve books and receive notifications.
  
- **Admin /  Librarian:**  
  Manages the library catalog, user accounts, borrow/return processes and reports.

## Core Functionalities
1. **Book Catalog & Search:**  
   Browse, search and filter books by category or title.
   
2. **Borrowing & Returning:**  
   Borrow and return books while tracking due dates.
   
3. **Notifications:**  
   Send alerts for overdue borrowed books.
   
4. **Digital Resources Access:**  
   Access e-books, research papers, and other digital content from a single platform.
   
5. **Book Recommendation:**  
   Each user can complete a form in order to receive some recommendations about new books they might like.
   

## Design Patterns Used

### 1. Factory Method
- **Usage:**  
Used for creating different types of users (`User`, `Admin`) and notifications.  

- **Problem Solved:**  
Centralizes and encapsulates object creation logic, ensuring that client code is not tightly coupled to specific implementations.  

- **Advantages:**  
   - Supports new user or notification types without modifying existing code.  
   - Improves maintainability and testability.  

### 2. Builder
- **Usage:**  
Used for constructing complex objects such as `Book`, which can have many optional attributes (multiple authors, formats, cover types, edition).  

- **Problem Solved:**  
Avoids long or confusing constructors and ensures that objects are always created in a valid, consistent state.  

- **Advantages:**  
   - Cleaner, more readable object construction.  
   - Easy to add optional fields.  
   - Reduces errors from invalid object creation.  

### 3. Observer
- **Usage:**  
Implements the notification system where users are “subscribers” who receive alerts when certain events occur, for example, when a due date is near, or a new announcement is published.  

- **Problem Solved:**  
Decouples the event producer (library system) from the consumers (users), allowing each to change independently.  

- **Advantages:**  
   - Supports multiple listeners for one event.  
   - Enables dynamic subscription and easy scalability.  

### 4. Strategy
- **Usage:**  
Applied to the recommendation system, allowing the system to switch between different recommendation algorithms, such as `PopularityBasedStrategy` or `GenreBasedStrategy`.

- **Problem Solved:**  
Provides flexibility to easily change or add algorithms without altering the main recommendation logic.  

- **Advantages:**  
   - Encourages reusability and flexibility.  
   - Simplifies algorithm testing and replacement.  
   - Makes it easy to expand the system with new strategies.  

### 5. Singleton
- **Usage:**  
Used for managing global configurations and shared resources like `DatabaseConnectionManager` or `LibraryConfig`.  

- **Problem Solved:**  
Ensures that only one instance of critical global resources exists across the system to maintain consistency.  

- **Advantages:**  
   - Simplifies access to shared resources.  
   - Prevents conflicts from multiple instances.  
   - Reduces memory and connection overhead.  
