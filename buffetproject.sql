-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2020 at 10:33 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buffetproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `dob` date NOT NULL,
  `age` int(11) NOT NULL,
  `level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `name`, `dob`, `age`, `level`) VALUES
(1, 'นนทวรรณ ศรีปรุ', '2020-10-01', 20, 'Gold'),
(34, 'sfafgfgfd', '2000-02-02', 20, 'Silver');

-- --------------------------------------------------------

--
-- Table structure for table `drink`
--

CREATE TABLE `drink` (
  `drink_id` int(11) NOT NULL,
  `drink_nane` varchar(100) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`username`, `password`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `set_id` int(11) NOT NULL,
  `set_name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`set_id`, `set_name`, `description`, `price`) VALUES
(1, 'บุฟเฟ่ต์ทะเลเผา', 'ปิ้งย่างทะเลเผาที่ยกทะเลสดๆ มาให้เลือกสรรไม่ว่าจะเป็นกุ้ง หอย หมึก ปู ตัวใหญ่ พร้อมให้ปิ้งย่างบนเตาร้อน รับประทานกับน้ำจิ้มรสแซ่บสูตรเด็ด นอกจากนี้ยังมีกระทะจิ้มจุ่มให้ได้อร่อยไม่อั้น แบบไม่จำกัดเวลาจ้าาา', 399),
(2, 'บุฟเฟ่ต์อาหารญี่ปุ่น', 'อาหารญี่ปุ่นสไตล์ฟิวชัน ที่ทางร้านคิดค้นขึ้นมาเอง ดังน๊านนน เมนูน่าทานของทางร้านจึงเยอะมาก เช่น แซลมอนราดซอสไข่กุ้ง ปลาดิบรวม แซลมอนซาซิมิ 8 ชิ้น  Trio Roll ชิ้นใหญ่ ', 499),
(3, 'บุฟเฟ่ต์เนื้อ', 'สายเนื้อห้ามพลาด! คุณภาพไร้ที่ติชวนละมุน ใช้ \"วากิวยูกิฟูริ\" จากเมืองโอบานาซาวา จ.ยามากาตะ ซึ่งไม่เคยส่งออกนอกญี่ปุ่นมาก่อน ที่นี่เป็นที่แรกและที่เดียวในโลกเท่านั้น! เต็มอิ่มกับเนื้อชั้นดีของวัวขนดำ จากเมืองโอบานาซาวา จังหวัดยามากาตะ เมืองที่อุณหภูมิร้อน-หนาวต่างกันสุดขั้ว ทำให้เนื้อวัวมีชั้นไขมันตามธรรมชาติที่ชุ่มฉ่ำสุด ๆ', 699);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `drink`
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`drink_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`set_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
