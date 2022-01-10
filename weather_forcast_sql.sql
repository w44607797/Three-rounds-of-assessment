
CREATE DATABASE weather_forecast;

CREATE TABLE `weather_forecast`.`city` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `lat` DOUBLE NOT NULL,
  `lon` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `weather_forecast`.`city_weather` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_Id` INT NOT NULL,
  `fx_date` VARCHAR(12) NOT NULL,
  `temp_max` INT NOT NULL,
  `temp_min` INT NOT NULL,
  `text_day` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));
