-- Datenbank anlegen

CREATE USER 'schoener'@'localhost' IDENTIFIED BY 'schoener';
CREATE DATABASE god_doener;
GRANT ALL ON god_doener.* TO 'schoener'@'localhost';
exit