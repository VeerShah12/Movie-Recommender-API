USE MovieProj;

CREATE TABLE IF NOT EXISTS movies (
    id int PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year int,
    genre VARCHAR(255),
    rating DOUBLE,    
    popularity DOUBLE
);

Select * from movies;

INSERT INTO movies (id, title, release_year, genre, rating, popularity) VALUES
(1, 'Inception', 2010, 'Sci-Fi', 8.8, 12000),
(2, 'The Dark Knight', 2008, 'Action', 9.0, 15000),
(3, 'Interstellar', 2014, 'Sci-Fi', 8.7, 11000),
(4, 'The Matrix', 1999, 'Sci-Fi', 8.7, 9500),
(5, 'Pulp Fiction', 1994, 'Crime', 8.9, 10000),
(6, 'Forrest Gump', 1994, 'Drama', 8.8, 9800),
(7, 'The Shawshank Redemption', 1994, 'Drama', 9.3, 15500),
(8, 'The Godfather', 1972, 'Crime', 9.2, 8700),
(9, 'The Godfather: Part II', 1974, 'Crime', 9.0, 8000),
(10, 'The Lord of the Rings: The Return of the King', 2003, 'Fantasy', 8.9, 9400),
(11, 'The Lord of the Rings: The Fellowship of the Ring', 2001, 'Fantasy', 8.8, 9600),
(12, 'The Lord of the Rings: The Two Towers', 2002, 'Fantasy', 8.7, 9200),
(13, 'Avengers: Endgame', 2019, 'Action', 8.4, 8900),
(14, 'Avengers: Infinity War', 2018, 'Action', 8.4, 9100),
(15, 'Gladiator', 2000, 'Action', 8.5, 8800),
(16, 'Titanic', 1997, 'Romance', 7.9, 14000),
(17, 'Schindler\'s List', 1993, 'Biography', 9.0, 7200),
(18, 'The Silence of the Lambs', 1991, 'Thriller', 8.6, 7800),
(19, 'Saving Private Ryan', 1998, 'War', 8.6, 8300),
(20, 'Fight Club', 1999, 'Drama', 8.8, 9900),
(21, 'The Green Mile', 1999, 'Drama', 8.6, 7300),
(22, 'Django Unchained', 2012, 'Western', 8.4, 8700),
(23, 'The Departed', 2006, 'Crime', 8.5, 8100),
(24, 'Whiplash', 2014, 'Drama', 8.5, 5000),
(25, 'Joker', 2019, 'Crime', 8.4, 9100),
(26, 'The Prestige', 2006, 'Mystery', 8.5, 7700),
(27, 'Parasite', 2019, 'Thriller', 8.6, 8600),
(28, 'The Grand Budapest Hotel', 2014, 'Comedy', 8.1, 4300),
(29, 'No Country for Old Men', 2007, 'Crime', 8.2, 6200),
(30, 'Shutter Island', 2010, 'Mystery', 8.2, 8100),
(31, 'Mad Max: Fury Road', 2015, 'Action', 8.1, 6900),
(32, 'The Revenant', 2015, 'Adventure', 8.0, 5400),
(33, 'Blade Runner 2049', 2017, 'Sci-Fi', 8.0, 6800),
(34, 'A Beautiful Mind', 2001, 'Biography', 8.2, 5300),
(35, 'Se7en', 1995, 'Thriller', 8.6, 8900),
(36, 'Logan', 2017, 'Action', 8.1, 7400),
(37, 'The Wolf of Wall Street', 2013, 'Biography', 8.2, 8100),
(38, 'The Social Network', 2010, 'Biography', 7.7, 4600),
(39, 'Deadpool', 2016, 'Comedy', 8.0, 6800),
(40, 'The Big Short', 2015, 'Biography', 7.8, 4200),
(41, 'The Lion King', 1994, 'Animation', 8.5, 8500),
(42, 'Toy Story', 1995, 'Animation', 8.3, 6000),
(43, 'Up', 2009, 'Animation', 8.3, 5500),
(44, 'WALL-E', 2008, 'Animation', 8.4, 7100),
(45, 'Inside Out', 2015, 'Animation', 8.1, 4800),
(46, 'Finding Nemo', 2003, 'Animation', 8.2, 5200),
(47, 'Coco', 2017, 'Animation', 8.4, 3900),
(48, 'Ratatouille', 2007, 'Animation', 8.1, 4400),
(49, 'The Irishman', 2019, 'Crime', 7.8, 3700),
(50, 'Once Upon a Time in Hollywood', 2019, 'Comedy', 7.6, 4100);


CREATE TABLE Review (
    reviewID INT AUTO_INCREMENT PRIMARY KEY,
    userID BIGINT NOT NULL,
    movieID INT NOT NULL,
    rating DECIMAL(3,2) NOT NULL,
    comment TEXT,
    FOREIGN KEY (userID) REFERENCES user_entity(ID),
    FOREIGN KEY (movieID) REFERENCES movies(ID),
    CHECK (rating >= 0.00 AND rating <= 10.00)
);

INSERT INTO Review (userID, movieID, rating, comment)
VALUES (1, 1, 8.5, "Great movie with mind bending concepts!");

SELECT * FROM Review;
