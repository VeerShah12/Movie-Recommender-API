# Movie Recommender System - Microservices Documentation

## 1. Movies Service

### Description

This microservice manages the **movie database**, including adding, updating, retrieving, and deleting movie records.

### Structure

- **Entity**: `Movies` (id, title, release date, genre, rating, popularity)
- **Repository**: `MoviesRepository` (handles database operations)
- **Service**: `MoviesService` (performs business logic for movies)
- **Controller**: `MoviesController` (handles API requests)

### Endpoints

- `GET /api/movies` - Retrieve all movies
- `GET /api/movies/{id}` - Retrieve a movie by ID
- `POST /api/movies` - Add a new movie
- `PUT /api/movies/{id}` - Update an existing movie
- `DELETE /api/movies/{id}` - Delete a movie

---

## 2. Review Service

### Description

This microservice allows users to **add, update, delete, and fetch reviews** for movies.

### Structure

- **Entity**: `Review` (reviewId, userId, movieId, rating, comment)
- **Repository**: `ReviewRepository` (handles database operations)
- **Service**: `ReviewService` (performs business logic for reviews)
- **Controller**: `ReviewController` (handles API requests)

### Endpoints

- `GET /api/reviews` - Retrieve all reviews
- `GET /api/reviews/{id}` - Retrieve a review by ID
- `GET /api/reviews/movie/{movieId}` - Retrieve reviews for a specific movie
- `GET /api/reviews/user/{userId}` - Retrieve reviews by a specific user
- `POST /api/reviews` - Add a new review
- `DELETE /api/reviews/{id}` - Delete a review

---
## 3. Recommendation Service

### Description

Provides movie recommendations based on:
- Similar movies (by title, genre, rating, popularity)
- User preferences (genre, rating, popularity)
- Also serves an HTML UI with embedded YouTube trailers

### Endpoints

#### API (JSON)
- `GET /api/recommend/title/{title}` – Recommend movies similar to a given title
- `GET /api/recommend/preference` – Recommend movies by genre, rating, and popularity

#### UI (HTML)
- `GET /recommend/ui/title/{title}` – Show recommendations with trailers
- `GET /recommend/ui/preferences` – Form to input preferences
- `GET /recommend/ui/results` – Show recommendations based on preferences

### Tech Stack
- Spring Boot + Thymeleaf for web UI
- Spring Data JPA for database access
- Feign Client to fetch movie data

---

## 4. API Gateway

### Description

Acts as a single entry point for clients to access all backend microservices. 

### Example Routes

- `/movies/**` → forwarded to Movies Service  
- `/reviews/**` → forwarded to Review Service  
- `/recommend/**` → forwarded to Recommendation Service  

---

## Technology Stack

| Layer         | Technology            |
|---------------|------------------------|
| Language      | Java 17+               |
| Framework     | Spring Boot            |
| Service Calls | Spring Cloud OpenFeign |
| Database      | MySQL                  |
| ORM           | Spring Data JPA        |
| API Gateway   | Spring Cloud Gateway   |
| Discovery     | Eureka                 |

- **Spring Boot** - Microservices Framework
- **Spring Data JPA** - Database interaction
- **MySQL** - Database for storing data

---
