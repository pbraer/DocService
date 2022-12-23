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
                         image TEXT,
                         monday TEXT,
                         tuesday TEXT,
                         wednesday TEXT,
                         thursday TEXT,
                         friday TEXT,
                         saturday TEXT,
                         sunday TEXT,
                         timefrom TEXT,
                         timeto TEXT
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

CREATE TABLE images (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        title TEXT,
                        uploaddate blob,
                        extension TEXT,
                        downloadlink TEXT
);


INSERT INTO patientsappoitm(userid,pass,email,qualif,doctor,dateappoitm,timeappoitm)
VALUES
    ('12345','12345', 'p@gmail.com','Гастроэнтеролог','Ivanov','12/12/2022','9:00'),
    ('12345','00000', 'o@gmail.com','Гастроэнтеролог','Ivanov','12/12/2022','17:00'),
    ('12345','12345', 'p@gmail.com','Инфекционист','Ivanov','12/12/2022','15:00'),
    ('12345','00000', '0@gmail.com','Инфекционист','Ivanov','12/12/2022','9:00'),
    ('12345','12312', 'm@gmail.com','Хирург','Ivanov','12/12/2022','9:00');

INSERT INTO doctors(userid,pass,email,qualif,firstname,lastname,middlename,monday,tuesday,wednesday,thursday,friday,saturday,timefrom,timeto)
VALUES
    ('1','1234!M', 'petrovii@gmail.com','Гастроэнтеролог','Петров','Иван','Иванович','1','1','0','1','1','1','9:00','18:00'),
    ('2','1234!A', 'turchinovichma@gmail.com','Дераматовенеролог','Турчинович','Мария','Александровна','1','1','0','1','1','1','9:00','18:00'),
    ('3','1234!K', 'ivanovaea@gmail.com','Инфекционист','Иванова','Екатерина','Андреевна','1','1','0','1','1','1','9:00','18:00'),
    ('4','1234!B', 'limanovop@gmail.com','Кардиолог','Лиманов','Олег','Петрович','1','1','0','1','1','1','9:00','18:00'),
    ('5','1234!L', 'goreevma@gmail.com','Невролог','Гореев','Максим','Алексеевич','1','1','0','1','1','1','9:00','18:00'),
    ('6','1234!J', 'zuevalm@gmail.com','Невролог','Зуева','Любовь','Михайловна','1','1','0','1','1','1','9:00','18:00'),
    ('7','11134', 'volkovyy@gmail.com','Офтальмолог','Волков','Юрий','Юрьевич','1','1','0','1','1','1','9:00','18:00'),
    ('8','11135', 'zhilingi@gmail.com','Терапевт','Жилин','Григорий','Иванович','1','1','1','1','1','0','10:00','20:00'),
    ('9','11136', 'buzovaop@gmail.com','Хирург','Бузова','Ольга','Петровна','1','1','1','1','1','1','15:00','16:00'),
    ('10','11137', 'morozovae@gmail.com','Терапевт','Морозов','Александр','Евгеньевич','1','1','1','1','1','0','10:00','20:00');

INSERT INTO usertable(pass,email,isdoc)
VALUES
    ('1234!M', 'petrovii@gmail.com','1'),
    ('1234!A', 'turchinovichma@gmail.com','1'),
    ('1234!K', 'ivanovaea@gmail.com','1'),
    ('1234!B', 'limanovop@gmail.com','1'),
    ('1234!L', 'goreevma@gmail.com','1'),
    ('1234!J', 'zuevalm@gmail.com','1'),
    ('11134', 'volkovyy@gmail.com','1'),
    ('11135', 'zhilingi@gmail.com','1'),
    ('11136', 'buzovaop@gmail.com','1'),
    ('11137', 'morozovae@gmail.com','1'),
    ('12344', 'p@gmail.com','0'),
    ('00000', 'o@gmail.com','0'),
    ('12312', 'm@gmail.com','0');