# 🚌 Bus Ticket Reservation System

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/Postgres-13-blue)](https://www.postgresql.org/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-orange)](https://www.thymeleaf.org/)

A **web-based bus ticket reservation system** built with **Spring Boot MVC**, **Thymeleaf**, and **PostgreSQL**.  
Admins can create trips, and users can search, buy, and return tickets.

---

## ✨ Features

### 👥 User
- **Register** and **login** (Spring Security + BCrypt)
- **Search** trips by departure, destination and date
- **Buy** tickets
- **Return** tickets (release them back as available)
- **View** purchased tickets and ticket details

### 🛠️ Admin
- **Create trips** with departure/destination, date/time, bus type, driver, and number of tickets
- Admin-only pages for trip management (role-based access)

---

## 🧰 Tech Stack

- **Backend:** Spring Boot MVC, Spring Security  
- **Frontend:** Thymeleaf, HTML, CSS  
- **Database:** PostgreSQL  
- **ORM:** Hibernate / JPA  
- **Password hashing:** BCrypt  
- **Build:** Maven

