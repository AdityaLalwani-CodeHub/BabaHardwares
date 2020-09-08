-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2019 at 04:19 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_category`
--

CREATE TABLE `customer_category` (
  `id` varchar(40) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer_category`
--

INSERT INTO `customer_category` (`id`, `Name`) VALUES
('CUCT2019062515002154021916', 'Distributor'),
('CUCT2019062515001354013988', 'Retailer');

-- --------------------------------------------------------

--
-- Table structure for table `customer_table`
--

CREATE TABLE `customer_table` (
  `id` varchar(40) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `OrderCount` int(11) NOT NULL DEFAULT '0',
  `TotalOrderAmount` float NOT NULL DEFAULT '0',
  `LastOrderDate` date DEFAULT NULL,
  `Balance` float NOT NULL DEFAULT '0',
  `AddDate` date DEFAULT NULL,
  `CustomerCategoryID` varchar(40) NOT NULL,
  `LastSecondOrderDate` date DEFAULT NULL,
  `GSTIN` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer_table`
--

INSERT INTO `customer_table` (`id`, `FirstName`, `LastName`, `Phone`, `Email`, `OrderCount`, `TotalOrderAmount`, `LastOrderDate`, `Balance`, `AddDate`, `CustomerCategoryID`, `LastSecondOrderDate`, `GSTIN`) VALUES
('CUST2019062520172873048551', 'shiva', 'shakti', '1112234', 'aaadddd', 2, 1630, '2019-06-25', 1280, '2019-06-25', 'CUCT2019062515002154021916', '2019-06-25', '');

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `id` varchar(40) NOT NULL,
  `OrderID` varchar(40) NOT NULL,
  `ProductDetailID` varchar(40) NOT NULL,
  `UnitPrice` float NOT NULL,
  `PurchasedQty` float NOT NULL,
  `ProductDiscountPrice` float NOT NULL,
  `ProductTax` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`id`, `OrderID`, `ProductDetailID`, `UnitPrice`, `PurchasedQty`, `ProductDiscountPrice`, `ProductTax`) VALUES
('ORDT2019062515015254112137', 'ORDR2019062515013154091270', 'PRDT2019062416133458414581', 50, 2, 0, 0),
('ORDT2019062515015254112145', 'ORDR2019062515013154091270', 'PRDT2019062416141458454261', 230, 2, 0, 0),
('ORDT2019062515015254112153', 'ORDR2019062515013154091270', 'PRDT2019062416144558485629', 450, 2, 0, 0),
('ORDT2019062520215173311016', 'ORDR2019062520190473144278', 'PRDT2019062416133458414581', 100, 2, 20, 0),
('ORDT2019062520215173311029', 'ORDR2019062520190473144278', 'PRDT2019062416141458454261', 230, 1, 0, 0),
('ORDT2019062523155883758767', 'ORDR2019062523150883708051', 'PRDT2019062416133458414581', 50, 2, 0, 0),
('ORDT2019062523155883758788', 'ORDR2019062523150883708051', 'PRDT2019062416141458454261', 230, 5, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `id` varchar(40) NOT NULL,
  `CustomerID` varchar(40) NOT NULL,
  `OrderDate` date NOT NULL,
  `OrderAmount` float NOT NULL,
  `OverallDiscountPrice` float NOT NULL,
  `OverallTax` float DEFAULT '0',
  `Balance` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`id`, `CustomerID`, `OrderDate`, `OrderAmount`, `OverallDiscountPrice`, `OverallTax`, `Balance`) VALUES
('ORDR2019062515013154091270', 'GENERAL', '2019-06-25', 1460, 0, 0, 0),
('ORDR2019062520190473144278', 'CUST2019062520172873048551', '2019-06-25', 380, 10, 0, 330),
('ORDR2019062523150883708051', 'CUST2019062520172873048551', '2019-06-25', 1250, 0, 0, 950);

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `id` varchar(40) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`id`, `Name`) VALUES
('PRCT2019062416095758197514', 'Adhesive'),
('PRCT2019062416115958319891', 'Car'),
('PRCT2019062416100358203599', 'Cement'),
('PRCT2019062416121758337977', 'Engine Oil'),
('PRCT2019062416101058210850', 'Grease'),
('PRCT2019062416095058190523', 'Mobile'),
('PRCT2019062520135372833172', 'PIPES'),
('PRCT2019062416094058180811', 'TV');

-- --------------------------------------------------------

--
-- Table structure for table `product_detail`
--

CREATE TABLE `product_detail` (
  `id` varchar(40) NOT NULL,
  `ProductID` varchar(40) NOT NULL,
  `UnitSize` float NOT NULL,
  `UnitPrice` float NOT NULL,
  `Quantity` float NOT NULL,
  `CostPrice` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_detail`
--

INSERT INTO `product_detail` (`id`, `ProductID`, `UnitSize`, `UnitPrice`, `Quantity`, `CostPrice`) VALUES
('PRDT2019062416133458414581', 'PROD2019062416132058400082', 0.1, 50, 12, 25),
('PRDT2019062416141458454261', 'PROD2019062416132058400082', 0.5, 230, 10, 150),
('PRDT2019062416144558485629', 'PROD2019062416132058400082', 1, 450, 16, 250),
('PRDT2019062416151658516645', 'PROD2019062416132058400082', 5, 2200, 20, 1500),
('PRDT2019062416171058630117', 'PROD2019062416170158621017', 1, 100, 20, 40),
('PRDT2019062416174658666725', 'PROD2019062416170158621017', 10, 920, 20, 450),
('PRDT2019062416201058810159', 'PROD2019062416194858788269', 1, 10000, 20, 2000),
('PRDT2019062416210358863540', 'PROD2019062416204758847525', 1, 10500, 20, 4350),
('PRDT2019062416213558895516', 'PROD2019062416212458884554', 1, 65000, 20, 27000);

-- --------------------------------------------------------

--
-- Table structure for table `product_table`
--

CREATE TABLE `product_table` (
  `id` varchar(40) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `SubType` varchar(50) DEFAULT NULL,
  `CategoryID` varchar(40) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `AddDate` date NOT NULL,
  `UnitCategoryID` varchar(40) DEFAULT NULL,
  `Picture` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_table`
--

INSERT INTO `product_table` (`id`, `Name`, `SubType`, `CategoryID`, `Description`, `AddDate`, `UnitCategoryID`, `Picture`) VALUES
('PROD2019062416132058400082', 'Fevicol', 'Marine', 'PRCT2019062416095758197514', '', '2019-06-24', 'UNIT2019062416125158371593', NULL),
('PROD2019062416170158621017', 'Fevicol', 'Wood', 'PRCT2019062416095758197514', '', '2019-06-24', 'UNIT2019062416125158371593', NULL),
('PROD2019062416194858788269', 'Motorola', 'G3', 'PRCT2019062416095058190523', '', '2019-06-24', 'UNIT2019062416130258382650', NULL),
('PROD2019062416204758847525', 'Xiaomi', 'Redmi Note 3', 'PRCT2019062416095058190523', '', '2019-06-24', 'UNIT2019062416130258382650', NULL),
('PROD2019062416212458884554', 'Sony', 'Bravia', 'PRCT2019062416094058180811', '', '2019-06-24', 'UNIT2019062416130258382650', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_modes`
--

CREATE TABLE `transaction_modes` (
  `id` varchar(40) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction_modes`
--

INSERT INTO `transaction_modes` (`id`, `Name`) VALUES
('TRMO2019062514592953969608', 'CASH');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_table`
--

CREATE TABLE `transaction_table` (
  `id` varchar(40) NOT NULL,
  `OrderID` varchar(40) NOT NULL,
  `Amount` float NOT NULL,
  `TransactionModeID` varchar(40) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Direction` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction_table`
--

INSERT INTO `transaction_table` (`id`, `OrderID`, `Amount`, `TransactionModeID`, `Date`, `Time`, `Direction`) VALUES
('TRAN2019062515015354113895', 'ORDR2019062515013154091270', 1460, 'TRMO2019062514592953969608', '2019-06-25', '15:02:03', 1),
('TRAN2019062520230773387224', 'ORDR2019062520190473144278', 100, 'TRMO2019062514592953969608', '2019-06-25', '20:23:34', 1),
('TRAN2019062520240173441960', 'ORDR2019062520190473144278', 50, 'TRMO2019062514592953969608', '2019-06-25', '20:24:22', 1),
('TRAN2019062520244273482064', 'ORDR2019062520190473144278', 100, 'TRMO2019062514592953969608', '2019-06-25', '20:24:55', 0),
('TRAN2019062523160183761760', 'ORDR2019062523150883708051', 400, 'TRMO2019062514592953969608', '2019-06-25', '23:16:22', 1),
('TRAN2019062523170883828275', 'ORDR2019062523150883708051', 100, 'TRMO2019062514592953969608', '2019-06-25', '23:17:15', 0);

-- --------------------------------------------------------

--
-- Table structure for table `unit_category`
--

CREATE TABLE `unit_category` (
  `id` varchar(40) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unit_category`
--

INSERT INTO `unit_category` (`id`, `Name`) VALUES
('UNIT2019062416124058360009', 'Kg(s)'),
('UNIT2019062416125158371593', 'Litre(s)'),
('UNIT2019062416130258382650', 'No(s)');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(40) NOT NULL,
  `fullname` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `picture` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `phone`, `email`, `picture`) VALUES
('admin', 'admin', 'admin', 'admin', 'admin', 'admin', NULL),
('USER2019062520004172041287', 'adi', 'adi', 'adi', '1111', 'aaaa', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_category`
--
ALTER TABLE `customer_category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexes for table `customer_table`
--
ALTER TABLE `customer_table`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Phone` (`Phone`),
  ADD KEY `CustomerCategoryID` (`CustomerCategoryID`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_detail_ibfk_1` (`OrderID`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexes for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Indexes for table `product_table`
--
ALTER TABLE `product_table`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CategoryID` (`CategoryID`),
  ADD KEY `UnitCategoryID` (`UnitCategoryID`);

--
-- Indexes for table `transaction_modes`
--
ALTER TABLE `transaction_modes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexes for table `transaction_table`
--
ALTER TABLE `transaction_table`
  ADD PRIMARY KEY (`id`),
  ADD KEY `OrderID` (`OrderID`);

--
-- Indexes for table `unit_category`
--
ALTER TABLE `unit_category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_table`
--
ALTER TABLE `customer_table`
  ADD CONSTRAINT `customer_table_ibfk_1` FOREIGN KEY (`CustomerCategoryID`) REFERENCES `customer_category` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `order_table` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `product_detail_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product_table` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `product_table`
--
ALTER TABLE `product_table`
  ADD CONSTRAINT `product_table_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `product_category` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `product_table_ibfk_2` FOREIGN KEY (`UnitCategoryID`) REFERENCES `unit_category` (`id`) ON DELETE SET NULL;

--
-- Constraints for table `transaction_table`
--
ALTER TABLE `transaction_table`
  ADD CONSTRAINT `transaction_table_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `order_table` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
