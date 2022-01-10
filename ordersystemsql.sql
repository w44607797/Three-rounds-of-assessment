create database order_database;
CREATE TABLE `order_database`.`my_order` (
`order_id` INT NOT NULL,
`commodity_id` INT NOT NULL,
`order_time` DATE NOT NULL,
PRIMARY KEY (`order_id`));

CREATE TABLE `order_database`.`commodity` (
`commodity_id` INT NOT NULL,
`commodity_name` VARCHAR(45) NOT NULL,
`commodity_price` DOUBLE NOT NULL,
PRIMARY KEY (`commodity_id`));

INSERT INTO `order_database`.`my_order` (`order_id`, `commodity_id`, `order_time`) VALUES ('1', '1', '2021-12-15');
INSERT INTO `order_database`.`my_order` (`order_id`, `commodity_id`, `order_time`) VALUES ('2', '2', '2021-12-15');
INSERT INTO `order_database`.`my_order` (`order_id`, `commodity_id`, `order_time`) VALUES ('3', '3', '2021-12-15');
INSERT INTO `order_database`.`my_order` (`order_id`, `commodity_id`, `order_time`) VALUES ('4', '4', '2021-12-15');
INSERT INTO `order_database`.`my_order` (`order_id`, `commodity_id`, `order_time`) VALUES ('5', '5', '2021-12-15');

INSERT INTO `order_database`.`commodity` (`commodity_id`, `commodity_name`, `commodity_price`) VALUES ('1', '羊肉片', '20');
INSERT INTO `order_database`.`commodity` (`commodity_id`, `commodity_name`, `commodity_price`) VALUES ('2', '牛肉', '5');
INSERT INTO `order_database`.`commodity` (`commodity_id`, `commodity_name`, `commodity_price`) VALUES ('3', '手机', '5000');
INSERT INTO `order_database`.`commodity` (`commodity_id`, `commodity_name`, `commodity_price`) VALUES ('4', '鼠标', '50');
INSERT INTO `order_database`.`commodity` (`commodity_id`, `commodity_name`, `commodity_price`) VALUES ('5', '电脑', '10000');

