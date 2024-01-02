CREATE TABLE IF NOT EXISTS Users
(
    username varchar(255) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Models
(
    id        SERIAL PRIMARY KEY,
    name      varchar(255) NOT NULL,
    type      varchar(50)  NOT NULL,
    username varchar(255) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (username) REFERENCES Users (username)
);