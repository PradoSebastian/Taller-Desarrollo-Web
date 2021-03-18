DROP TABLE IF EXISTS Books;

CREATE TABLE Books (
                       idBook INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       description VARCHAR(200) NOT NULL,
                       price INT NOT NULL,
                       publishedYear INT(4) NOT NULL,
                       numberPages INT NOT NULL,
                       authorNames VARCHAR(100) NOT NULL
);
