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
                                 doctorid TEXT,
                                 dateappoitm TEXT,
                                 timeappoitm TEXT
);

INSERT INTO patientsappoitm(userid,pass,email,qualif,doctorid,doctor,dateappoitm,timeappoitm)
VALUES
    ('11','12345', 'p@gmail.com','Гастроэнтеролог','1','Петров И.И.','2022-12-12','09:00'),
    ('12','00000', 'o@gmail.com','Гастроэнтеролог','1','Петров И.И.','2022-12-12','17:00'),
    ('11','12345', 'p@gmail.com','Инфекционист','3','Иванова И.А.','2022-12-12','15:00'),
    ('12','00000', '0@gmail.com','Невролог','3','Иванова И.А.','2022-12-12','09:00'),
    ('13','12312', 'm@gmail.com','Хирург','6','Зуева Л.М.','2022-12-12','09:00');

INSERT INTO doctors(userid,pass,email,qualif,lastname,firstname,middlename)
VALUES
    ('1','1234!M', 'petrovii@gmail.com','Гастроэнтеролог','Петров','Иван','Иванович'),
    ('2','1234!A', 'turchinovichma@gmail.com','Дераматовенеролог','Турчинович','Мария','Александровна'),
    ('3','1234!K', 'ivanovaea@gmail.com','Инфекционист','Иванова','Екатерина','Андреевна'),
    ('4','1234!B', 'limanovop@gmail.com','Кардиолог','Лиманов','Олег','Петрович'),
    ('5','1234!L', 'goreevma@gmail.com','Невролог','Гореев','Максим','Алексеевич'),
    ('6','1234!J', 'zuevalm@gmail.com','Невролог','Зуева','Любовь','Михайловна'),
    ('7','11134', 'volkovyy@gmail.com','Офтальмолог','Волков','Юрий','Юрьевич'),
    ('8','11135', 'zhilingi@gmail.com','Терапевт','Жилин','Григорий','Иванович'),
    ('9','11136', 'buzovaop@gmail.com','Хирург','Бузова','Ольга','Петровна'),
    ('10','11137', 'morozovae@gmail.com','Терапевт','Морозов','Александр','Евгеньевич');

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
