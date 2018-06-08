-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: phpmyadmin_testing_mariadb
-- Tiempo de generación: 08-06-2018 a las 11:30:33
-- Versión del servidor: 10.2.15-MariaDB-10.2.15+maria~jessie
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `zapateria`
--

-- --------------------------------------------------------

--
-- DROPS
--

DROP TABLE IF EXISTS cliente_direccion;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS CodPos;
DROP TABLE IF EXISTS cod_pos;

DROP TABLE IF EXISTS producto_idioma;
DROP TABLE IF EXISTS producto_categoria;
DROP TABLE IF EXISTS producto;

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellidos`, `dni`) VALUES
(1, 'Angel María', 'Millán Miralles', 25987662),
(2, 'Pepe', 'López Pérez', 258963147);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_direccion`
--

CREATE TABLE `cliente_direccion` (
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_direccion` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nombre_via` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `cp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente_direccion`
--

INSERT INTO `cliente_direccion` (`nombre`, `id_direccion`, `id_cliente`, `nombre_via`, `cp`) VALUES
('Mi casa', 1, 1, 'Paseo de la Estación 44', 23002),
('Casa', 2, 2, 'Rue del Percebe 13', 23006);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cod_pos`
--

CREATE TABLE `cod_pos` (
  `cp` int(11) NOT NULL,
  `localidad` varchar(120) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cod_pos`
--

INSERT INTO `cod_pos` (`cp`, `localidad`) VALUES
(23002, 'Jaén'),
(23006, 'Jaén');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `ruta_imagen` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `ruta_imagen`, `categoria`) VALUES
(1, 'https://static.forumsport.com/img/productos/1000x1000/SALOMON%20BOTA%20TREKKING%20HOMBRE%20AUTHENTIC%20LTR%20GTX%C2%AE-423089.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_categoria`
--

CREATE TABLE `producto_categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(35) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto_categoria`
--

INSERT INTO `producto_categoria` (`id_categoria`, `nombre`) VALUES
(1, 'calzado_deporte_trekking_botas'),
(2, 'calzado_deporte_padel_zapatillas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_idioma`
--

CREATE TABLE `producto_idioma` (
  `cod_idioma` varchar(3) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto_idioma`
--

INSERT INTO `producto_idioma` (`cod_idioma`, `nombre`, `descripcion`, `id_producto`) VALUES
('ENG', 'Brown mountain boots', 'A pair of comfortable but quite ugly mountain boots.', 1),
('ESP', 'Botas marrones de montaña', 'Un par de botas de montaña cómodas pero bastante feas.', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  ADD PRIMARY KEY (`id_direccion`),
  ADD KEY `fk_cp` (`cp`),
  ADD KEY `fk_cliente_direccion` (`id_cliente`);

--
-- Indices de la tabla `cod_pos`
--
ALTER TABLE `cod_pos`
  ADD PRIMARY KEY (`cp`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `producto_idioma`
--
ALTER TABLE `producto_idioma`
  ADD PRIMARY KEY (`cod_idioma`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  MODIFY `id_direccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto_categoria`
--
ALTER TABLE `producto_categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_direccion`
--
ALTER TABLE `cliente_direccion`
  ADD CONSTRAINT `fk_cliente_direccion` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cp` FOREIGN KEY (`cp`) REFERENCES `cod_pos` (`cp`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
