
CREATE DATABASE weather_forecast;

CREATE TABLE `weather_forecast`.`city` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `lat` DOUBLE NOT NULL,
  `lon` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `weather_forecast`.`city_weather` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cityId` INT NOT NULL,
  `fxDate` VARCHAR(12) NOT NULL,
  `tempMax` INT NOT NULL,
  `tempMin` INT NOT NULL,
  `textDay` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));
  
