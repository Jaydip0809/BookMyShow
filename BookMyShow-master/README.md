# 🎬 Movie Ticket Booking System (Spring Boot)

A full-featured backend application for a movie ticket booking system, designed to simulate real-world scenarios like location-based movie discovery, theater management, and seat booking.

This project focuses on building a scalable backend architecture similar to real-world platforms, enabling users to explore movies by city and book tickets seamlessly.

---

## 💻 GitHub Repository

👉 https://github.com/YourName/BookMyShow

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MySQL
* **ORM:** Hibernate & JPA
* **API Testing:** Postman
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

---

## ✨ Key Features

### 🎥 User Features

* Browse movies based on **city/location**
* View running shows in nearby theaters
* Check seat availability in real-time
* Book tickets seamlessly

### 🏢 Admin Features

* Add & manage **cities**
* Add **theaters and screens**
* Add & manage **movies**
* Configure **shows and timings**
* Manage **seat layouts and pricing**

### ⚙️ System Features

* RESTful API design
* Real-world entity relationships (Movie, Theater, Show, Booking, Seat)
* Data validation and exception handling
* Scalable layered architecture

---

## 🧠 Real-World Concepts Implemented

* 🔗 Entity Relationships & Mapping (JPA)
* 📌 Booking flow with seat locking logic
* 🏙️ Location-based filtering (City-wise data handling)
* ⚡ Backend system design similar to production-level apps
* 🧩 Clean architecture (Controller → Service → Repository)

---

## 📂 Project Structure

```
src/main/java/com/project
│
├── controller     # REST APIs
├── service        # Business Logic
├── repository     # Database Layer
├── entity         # JPA Entities
├── dto            # Data Transfer Objects
└── config         # Configurations
```

---


## 📡 API Endpoints (Sample)

| Method | Endpoint | Description        |
| ------ | -------- | ------------------ |
| GET    | /movies  | Get movies by city |
| POST   | /movies  | Add movie (Admin)  |
| POST   | /theater | Add theater        |
| POST   | /show    | Create show        |
| POST   | /booking | Book tickets       |

---

## 🔮 Future Enhancements

* 🔐 User Authentication (JWT / Spring Security)
* 💳 Payment Gateway Integration
* 📱 Frontend UI (React / Angular)
* 📊 Admin Dashboard
* 🎯 Recommendation System
