# Movie Recommender System - Microservices Documentation

## 1. User Registration & Login Service

### Description

This microservice handles user authentication and authorization. It enables users to register, log in, and access different roles (**USER/ADMIN**). **Spring Security** is used for authentication.

### Structure

- **Entity**: `UserEntity` (id, username, password, role)
- **Repository**: `UserRepo` (handles database operations)
- **Service**: `CustomUserDetailsService` (fetches user details for authentication)
- **Security**: `WebSecurityConfiguration` (configures access rules, password encoding)
- **Controller**: `HomeController` (handles basic endpoints)

### Endpoints

- `POST /register` - User registration _(to be implemented)_
- `POST /login` - User authentication
- `GET /home` - Accessible to authenticated users
- `GET /admin` - Accessible to **ADMIN** users only

---

## 2. Movies Service

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

## 3. Review Service

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

## 4. User Preference Service

### Description

This microservice allows users to store and manage their **favorite genres and movies**, which can be used for personalized recommendations in the future.

### Structure

- **Entity**: `UserPreference` (id, userId, favoriteGenres, favoriteMovies)
- **Repository**: `UserPreferenceRepository` (handles database operations)
- **Service**: `UserPreferenceService` (performs business logic for user preferences)
- **Controller**: `UserPreferenceController` (handles API requests)

### Endpoints

- `GET /api/user-preferences/{userId}` - Retrieve user preferences
- `POST /api/user-preferences` - Add or update user preferences
- `DELETE /api/user-preferences/{id}` - Delete user preferences

---

## Technology Stack

- **Spring Boot** - Microservices Framework
- **Spring Data JPA** - Database interaction
- **Spring Security** - Authentication & Authorization
- **MySQL** - Database for storing data

---

## How to Run the Services

1. Ensure **MySQL** is running. Update database credentials in `application.properties` if needed.
2. Start each microservice individually:
   ```bash
   mvn spring-boot:run
   ```
3. The services run on the following ports:
   - **User Service** → `8080`
   - **Movies Service** → `8081`
   - **Review Service** → `8082`
   - **User Preference Service** → `8083`

---
