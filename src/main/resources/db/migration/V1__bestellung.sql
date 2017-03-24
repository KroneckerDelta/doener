CREATE TABLE `Bestellung` (
  id  BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  bestellnummer VARCHAR(255) NOT NULL,
  fleischart VARCHAR(255) ,
  extras VARCHAR(255), 
  bestelldatum DATE
        
);
