-- Carga de datos

-- -----------------------------------------------------
-- Data for table `almacen`.`categorias`
-- -----------------------------------------------------
START TRANSACTION;
USE `almacen`;
INSERT INTO `almacen`.`categorias` (`id`, `nombre`, `descripcion`, `orden`) VALUES (1, 'Procesador', 'Categoria de Procesador', 1);
INSERT INTO `almacen`.`categorias` (`id`, `nombre`, `descripcion`, `orden`) VALUES (2, 'Memorias', 'Categorias de Memorias', 2);
INSERT INTO `almacen`.`categorias` (`id`, `nombre`, `descripcion`, `orden`) VALUES (3, 'Disco duros', 'Categorias de discos duros', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `almacen`.`productos`
-- -----------------------------------------------------
START TRANSACTION;
USE `almacen`;
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`) VALUES (1, 'Intel Core I7', 'Procesador Intel Core I7-8700 Lga 1151 8va', 1479.99, 6, 1);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`) VALUES (2, 'Kingstone', 'Kingstone 64GB DDR3', 80.00, 12, 2);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`) VALUES (3, 'iPhone 9', 'Iphone', 2000, 6, 1);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`) VALUES (4, 'AMD', 'Procesador AMD', 223, 12, 1);

COMMIT;

