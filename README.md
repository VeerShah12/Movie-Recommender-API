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

This microservice provides movie recommendations based on:
- Movie similarity (genre, rating, popularity)
- User preferences (genre, rating threshold, popularity threshold)

### Structure

- **Model**: `Movie` DTO (same as in Movies Service)
- **Client**: `MovieClient` (Feign client to fetch movie data from Movies Service)
- **Service**: `RecommendationService` – logic for generating recommendations
- **Controller**: `RecommendationController` – REST endpoints

### Endpoints

- `GET /api/recommend/title/{title}` – Recommend movies similar to a given title  
- `GET /api/recommend/preference?genre=&minRating=&minPopularity=` – Recommend movies based on user preferences  

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
