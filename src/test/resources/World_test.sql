CREATE SCHEMA IF NOT EXISTS World_test;
--Creates a schema/database name world if it doesn't exist.
SET Database Sql SYNTAX MYS TRUE;
    --Configures the database to use sql syntax compatible with mysql.
    SET MODE MYSQL;
        --sets the database mode to behave like mys which effects compatibility, features and behavior.
        USE World_test;
            --Specifying the Database which I'd like to use
CREATE TABLE city(
    `ID` int NOT NULL AUTO_INCREMENT,
    `Name` char(35) NOT NULL DEFAULT '',
    `CountryCode` char(3) NOT NULL DEFAULT '',
    `District` char(20) NOT NULL DEFAULT '',
    `Population` int NOT NULL DEFAULT '0',
    PRIMARY KEY (`ID`),
    KEY `CountryCode` (`CountryCode`),
    CONSTRAINT `city_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

);
CREATE TABLE country(
   `Code` char(3) NOT NULL DEFAULT '',
   `Name` char(52) NOT NULL DEFAULT '',
   `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
   `Region` char(26) NOT NULL DEFAULT '',
   `SurfaceArea` decimal(10,2) NOT NULL DEFAULT '0.00',
   `IndepYear` smallint DEFAULT NULL,
   `Population` int NOT NULL DEFAULT '0',
   `LifeExpectancy` decimal(3,1) DEFAULT NULL,
   `GNP` decimal(10,2) DEFAULT NULL,
   `GNPOld` decimal(10,2) DEFAULT NULL,
   `LocalName` char(45) NOT NULL DEFAULT '',
   `GovernmentForm` char(45) NOT NULL DEFAULT '',
   `HeadOfState` char(60) DEFAULT NULL,
   `Capital` int DEFAULT NULL,
   `Code2` char(2) NOT NULL DEFAULT '',
   PRIMARY KEY (`Code`)

);
CREATE TABLE countryLanguage(
         `CountryCode` char(3) NOT NULL DEFAULT '',
           `Language` char(30) NOT NULL DEFAULT '',
           `IsOfficial` enum('T','F') NOT NULL DEFAULT 'F',
           `Percentage` decimal(4,1) NOT NULL DEFAULT '0.0',
           PRIMARY KEY (`CountryCode`,`Language`),
           KEY `CountryCode` (`CountryCode`),
           CONSTRAINT `countryLanguage_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
);

INSERT INTO `city` VALUES (1,'Kabul','AFG','Kabul',17800000);
