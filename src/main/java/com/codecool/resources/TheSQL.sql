CREATE TABLE IF NOT EXISTS Users (
 ID text NOT NULL PRIMARY KEY,
 UserName text NOT NULL,
 Password text NOT NULL,
 Name text NOT NULL,
 Surname text NOT NULL,
 Group int NOT NULL
);

CREATE TABLE IF NOT EXISTS Students (
 ID text NOT NULL PRIMARY KEY,
 UserName text NOT NULL,
 Password text NOT NULL,
 Name text NOT NULL,
 Surname text NOT NULL,
 Group int NOT NULL,
 Class text NOT NULL,
 Email text NOT NULL
);

CREATE TABLE IF NOT EXISTS Grades (
 StudentId text NOT NULL PRIMARY KEY,
 Hangman text,
 Enigma text,
 Eisenhower text,
 Battleship text,
 OOPGeometry text,
 Klondike text,
 ExpertSystem text,
 BattleOfCards text,
 TextAnalyser text,
 CcMS text
 FOREIGN KEY (StudentId) REFERENCES Students(ID)
);

INSERT INTO Users VALUES("AADDMM###1", "admin", "adm123", "Jurek", "Jurek", 1);
INSERT INTO Users VALUES("RREEMM###2", "miri", "mir123", "Miriam", "Miri", 2);
INSERT INTO Users VALUES("MMEENN###3", "mentor1", "men123", "Dominik", "Undeadslayer", 3);
INSERT INTO Users VALUES("MENTOR###4", "mentor2", "mentor2", "Marcin", "Burgerking", 3);

INSERT INTO Students VALUES("STUD#####1", "leser1", "dup123", "Zygfryd", "von Bugger", 4, "2018-1", "zigi@email.com");
INSERT INTO Students VALUES("STUD#####2", "nieroob", "dup123", "Stach", "Owerflow", 4, "2018-1", "stach@email.com");
INSERT INTO Students VALUES("STUD#####3", "franek", "dup123", "Franek", "Luck", 4, "2017-9", "franek@luck.com");

INSERT INTO Grades VALUES("STUD#####1", "5", null, null, null, null, null, null, null, null, null);
INSERT INTO Grades VALUES("STUD#####2", "5", "3", "3", null, "4", null, "5", null, null, null);
INSERT INTO Grades VALUES("STUD#####3", "5", "4", "4", "5", "4", "3", "5", "4", "5", "3");


