










/*
FOREIGN KEY(user_id) REFERENCES users(user_id)
TABLA 1:1 DNI-USER_ID
CREATE TABLE dni(
    dni_id int AUTO_INCREMENT PRIMARY KEY,
    dni_number int NOT NULL,
    user_id int,
    UNIQUE(dni_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE companies(
   company_id int AUTO_INCREMENT PRIMARY KEY,
   name varchar(100) NOT NULL
);



*/