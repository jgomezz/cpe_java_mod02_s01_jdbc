USE almacen;

DESC categorias;

DESC productos;

SELECT * FROM categorias;

SELECT * FROM productos;

-- -----------------------------------------------------
-- Data for table `almacen`.`productos`
-- -----------------------------------------------------
START TRANSACTION;
USE `almacen`;
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`)
VALUES (1, 'Intel Core I7', 'Procesador Intel Core I7-8700 Lga 1151 8va', 1479.99, 6, 1);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`)
VALUES (2, 'Kingstone', 'Kingstone 64GB DDR3', 80.00, 12, 2);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`)
VALUES (3, 'iPhone 9', 'Iphone', 2000, 6, 1);
INSERT INTO `almacen`.`productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `categorias_id`)
VALUES (4, 'AMD', 'Procesador AMD', 223, 12, 1);
COMMIT ;


-- SQL mas usados

SELECT * FROM productos;

SELECT nombre, descripcion FROM productos;

SELECT MAX(precio) FROM productos;

SELECT MIN(precio) FROM productos;

SELECT MAX(precio), MIN(precio) FROM productos;

SELECT nombre, precio FROM productos ORDER BY precio DESC;

-- SQL : insertar registros

INSERT INTO almacen.productos (id, nombre, descripcion, precio, stock, categorias_id)
VALUES (5, 'NVidia', 'GPU RTX 4090', 2500, 10, 1);

INSERT INTO almacen.productos (id, nombre, descripcion, precio, stock, categorias_id) VALUES 
(6, 'NVidia', 'GPU RTX 3070', 2000, 5, 1),
(7, 'NVidia', 'GPU RTX 2060', 1500, 3, 1),
(8, 'NVidia', 'GPU GTX 1080 TI', 600, 2, 1);

-- SQL : actualizar registros
UPDATE productos SET descripcion = "GPU RTX 5070", precio = 3000 WHERE id = 7;

-- SQL : eliminar registros
DELETE FROM productos WHERE id = 9;