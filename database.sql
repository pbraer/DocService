CREATE DATABASE MedServ;
USE MedServ;
SET GLOBAL time_zone = '+7:00';

CREATE TABLE usertable (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           pass TEXT,
                           email TEXT,
                           isdoc TEXT
);

CREATE TABLE doctors (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         userid TEXT,
                         pass TEXT NOT NULL,
                         email TEXT NOT NULL,
                         firstname TEXT,
                         lastname TEXT,
                         middlename TEXT,
                         qualif TEXT,
                         image VARCHAR(1024) DEFAULT '/tmp/default.jpg',
                         monday BOOLEAN,
                         tuesday BOOLEAN,
                         wednesday BOOLEAN,
                         thursday BOOLEAN,
                         friday BOOLEAN,
                         saturday BOOLEAN,
                         sunday BOOLEAN,
                         timeFrom VARCHAR(5),
                         timeTo VARCHAR(5)
);

CREATE TABLE patientsAppoitm (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 userid TEXT,
                                 pass TEXT,
                                 email TEXT,
                                 qualif TEXT,
                                 doctor TEXT,
                                 dateappoitm TEXT,
                                 timeappoitm TEXT
);



INSERT INTO doctors (pass, email)
VALUES
    ('1234!M', 'mayMoris@gmail.com'),
    ('1234!A', 'annAger@gmail.com'),
    ('1234!K', 'kateKrull@gmail.com'),
    ('1234!B', 'bobBrayan@gmail.com'),
    ('1234!L', 'luceLucart@gmail.com');

INSERT INTO patientsappoitm(userid,pass,email,qualif,doctor,dateappoitm,timeappoitm)
VALUES
    ('12345','12345', 'p@gmail.com','Гастроэнтеролог','Ivanov','12/12/2022','9:00'),
    ('12345','00000', 'o@gmail.com','Гастроэнтеролог','Ivanov','12/12/2022','17:00'),
    ('12345','12345', 'p@gmail.com','Инфекционист','Ivanov','12/12/2022','15:00'),
    ('12345','00000', '0@gmail.com','Инфекционист','Ivanov','12/12/2022','9:00'),
    ('12345','12312', 'm@gmail.com','Хирург','Ivanov','12/12/2022','9:00');

INSERT INTO doctors(userid,pass,email,qualif,firstname,lastname,middlename,monday,tuesday,wednesday,thursday,friday,saturday,timeFrom,timeTo)
VALUES
    ('6','11134', 'doc1@gmail.com','Гастроэнтеролог','Ivan','Ivanov','Ivanovich','1','1','0','1','1','1','9:00','18:00'),
    ('7','11134', 'doc2@gmail.com','Инфекционист','Petr','Petrov','Petrovich','1','1','1','1','1','0','10:00','20:00'),
    ('8','11134', 'doc3@gmail.com','Хирург','Maxim','Max','Maximovna','1','1','1','1','1','1','15:00','16:00');


INSERT INTO usertable(pass,email,isdoc)
VALUES
    ('1234!M', 'mayMoris@gmail.com','1'),
    ('1234!A', 'annAger@gmail.com','1'),
    ('1234!K', 'kateKrull@gmail.com','1'),
    ('1234!B', 'bobBrayan@gmail.com','1'),
    ('1234!L', 'luceLucart@gmail.com','1'),
    ('11134', 'doc1@gmail.com','1'),
    ('11134', 'doc2@gmail.com','1'),
    ('11134', 'doc3@gmail.com','1'),
    ('12345', 'p@gmail.com','0'),
    ('00000', 'o@gmail.com','0'),
    ('12312', 'm@gmail.com','0');