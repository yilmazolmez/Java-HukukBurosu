-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 02 May 2020, 22:05:06
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hukukburosu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `avukatbilgi`
--

CREATE TABLE `avukatbilgi` (
  `AvukatTC` varchar(20) NOT NULL,
  `AvukatAd` varchar(30) DEFAULT 'Avukad Adi',
  `AvukatSoyad` varchar(30) DEFAULT 'Avukat Soyadi',
  `AvukatBabaAdi` varchar(25) DEFAULT 'Avukat Baba Adi',
  `AvukatAnaAdi` varchar(25) DEFAULT 'Avukat Anne Adi',
  `AvukatAdres` varchar(100) DEFAULT 'Adres',
  `AvukatDogumTarihi` date DEFAULT NULL,
  `AvukatDogumYeri` varchar(20) DEFAULT 'Dogum Yeri',
  `AvukatCinsiyet` varchar(10) DEFAULT 'Cinsiyet',
  `AvukatTelefon` varchar(11) DEFAULT '5320000000',
  `AvukatSicilNo` varchar(20) DEFAULT '0000000',
  `Avukateposta` varchar(100) DEFAULT NULL,
  `AvukatBaro` varchar(100) DEFAULT 'Istanbul',
  `hatirlat` date DEFAULT NULL,
  `Aciklama` varchar(250) DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `avukatbilgi`
--

INSERT INTO `avukatbilgi` (`AvukatTC`, `AvukatAd`, `AvukatSoyad`, `AvukatBabaAdi`, `AvukatAnaAdi`, `AvukatAdres`, `AvukatDogumTarihi`, `AvukatDogumYeri`, `AvukatCinsiyet`, `AvukatTelefon`, `AvukatSicilNo`, `Avukateposta`, `AvukatBaro`, `hatirlat`, `Aciklama`, `hakedis`) VALUES
('1', 'Av. Sare', 'OZKAN', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('10', 'Av. Hasan', 'HACISULEYMAN', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yer', 'BAYAN', '5321111111', '00000', '', '', NULL, NULL, '0.00'),
('11', 'Av. Ilknur CELIK', '', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('2', 'Av. Zerrin', 'CERKES', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('3', 'Av. Yilmaz', 'OLMEZ', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('4', 'Av. Mustafa', 'ALTUNDAG', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('5', 'Av. Devrim', 'GUNES', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('6', 'Av. Yunus', 'UZULMEZ', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('7', 'Av. Beyza', 'ATES', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('8', 'Av. Salih', 'OZTURK', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00'),
('9', 'Av. Muhammed', 'BEYYUD', 'Baba Adi', 'Ana Adi', 'Adres', '2020-04-21', 'Dogum Yeri', 'BAYAN', '5320000000', '00000', '', '', NULL, NULL, '0.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `burobilgi`
--

CREATE TABLE `burobilgi` (
  `BuroID` int(11) NOT NULL,
  `BuroUnvani` varchar(100) DEFAULT 'X Hukuk Burosu',
  `BuroAdresi` varchar(100) DEFAULT 'Adres Bilgisi',
  `BuroIlce` varchar(25) DEFAULT 'Ilce Bilgisi',
  `BuroSehir` varchar(20) DEFAULT 'Sehir Bilgisi',
  `BuroPostaKodu` varchar(20) DEFAULT '34000',
  `BuroTelefon` varchar(11) DEFAULT '5320000000',
  `BuroCepTel` varchar(11) DEFAULT '5320000000',
  `BuroEPosta` varchar(40) DEFAULT NULL,
  `BuroVergiNo` varchar(20) DEFAULT '0000000000',
  `BuroOrtak1` varchar(45) DEFAULT 'Ortak1',
  `BuroOrtak2` varchar(45) DEFAULT 'Ortak2',
  `BuroOrtak3` varchar(45) DEFAULT 'Ortak3',
  `BuroOrtak4` varchar(45) DEFAULT 'Ortak4',
  `BuroAciklama` varchar(100) DEFAULT 'Buro Detaylari',
  `BuroVergiDairesi` varchar(100) DEFAULT 'Vergi Dairesi'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `burobilgi`
--

INSERT INTO `burobilgi` (`BuroID`, `BuroUnvani`, `BuroAdresi`, `BuroIlce`, `BuroSehir`, `BuroPostaKodu`, `BuroTelefon`, `BuroCepTel`, `BuroEPosta`, `BuroVergiNo`, `BuroOrtak1`, `BuroOrtak2`, `BuroOrtak3`, `BuroOrtak4`, `BuroAciklama`, `BuroVergiDairesi`) VALUES
(2, 'CELIK HUKUK BUROSU', '1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '1', '1', '33333', '33333333333', '33333333333', '', '1111', 'ILKNUR CELIK', '', '', '', 'ISTANBUL', '1111'),
(3, 'CELUK HUKUK VAN', '234', '234', '234', '234', '234324', '234234', '', '', '', '', '', '', 'VAN', '234'),
(4, 'CELIK HUKUK BALIKESIR', '234', '', '', 'Max Uzunluk=5', '234', '234', '', '', '', '', '', '', 'BALIKESIR', '234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hukukajanda`
--

CREATE TABLE `hukukajanda` (
  `islemid` int(11) NOT NULL,
  `Aciklama` varchar(250) DEFAULT NULL,
  `hatirlat` date DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00,
  `personeladisoyadi` varchar(200) DEFAULT NULL,
  `Islemtarihi` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `hukukajanda`
--

INSERT INTO `hukukajanda` (`islemid`, `Aciklama`, `hatirlat`, `hakedis`, `personeladisoyadi`, `Islemtarihi`) VALUES
(2, 'KULLANIM KILAVUZU OK', '2020-05-10', '1.00', 'ZERRIN CERKES', '2020-04-28'),
(3, 'RAPOR MODULU OK', '2020-05-11', '1.00', 'MUSTAFA ALTUNDAG', '2020-04-28'),
(4, 'YETKILENDIRME ENTEGRASYONU OK', '2020-05-12', '3.00', 'MUSTAFA ALTUNDAG', '2020-04-28'),
(5, 'UAT SON KULLANICI TESTLERI OK', '2020-05-13', '3.00', 'YUNUS MAZOOGLU', '2020-04-28'),
(6, 'SETUP ENTEGRASYONU OK', '2020-05-14', '4.00', 'YILMAZ OLMEZ', '2020-04-28'),
(7, 'PINAR HOCAMIZA VIDEOLU SUNUM TESLIMATI', '2020-05-15', '6.00', 'BUTUN DEVELOPER EKIBIMIZ', '2020-04-28'),
(9, 'PLANLAMA CALISMALARI OK', '2020-05-05', '0.00', 'BUTUN DEVELOPER EKIBIMIZ', '2020-04-28'),
(10, 'ANALIZ CALISMALARI OK', '2020-05-06', '0.00', 'BUTUN DEVELOPER EKIBIMIZ', '2020-04-28'),
(11, 'TASARIM KODLAMA OK', '2020-05-07', '0.00', 'BUTUN DEVELOPER EKIBIMIZ', '2020-04-28'),
(12, 'CELIK HUKUK URUN CANLIYA CIKMA', '2020-05-20', '8.00', 'BUTUN DEVELOPER EKIBIMIZ', '2020-04-28'),
(15, 'ZERRIN DOGUM GUNU 19 HAZIRAN', '2020-06-19', '0.00', 'ZERRIN CERKES', '2020-05-02'),
(16, 'DOGUM GUNU HATIRLATMASI', '2020-06-27', '0.00', 'HASAN HACISULEYMAN', '2020-05-02'),
(17, 'DOGUM GUNU HATIRLATMASI', '2020-06-04', '0.00', 'YILMAZ OLMEZ', '2020-05-02');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hukukburosulog`
--

CREATE TABLE `hukukburosulog` (
  `logid` int(11) NOT NULL,
  `logkullaniciadi` varchar(45) DEFAULT NULL,
  `logkullaniciyetkisi` varchar(100) DEFAULT NULL,
  `logdatetime` datetime DEFAULT current_timestamp(),
  `logsunucuparametre` varchar(200) DEFAULT NULL,
  `logaksiyon` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `hukukburosulog`
--

INSERT INTO `hukukburosulog` (`logid`, `logkullaniciadi`, `logkullaniciyetkisi`, `logdatetime`, `logsunucuparametre`, `logaksiyon`) VALUES
(1, '1', 'AVUKAT', '2020-03-18 02:28:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(2, '2', 'AVUKAT', '2020-03-18 02:30:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(3, '1', 'AVUKAT', '2020-03-18 02:38:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(4, '3', 'AVUKAT', '2020-03-18 02:40:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(5, '1', 'AVUKAT', '2020-03-18 02:47:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(6, '12', 'AVUKAT', '2020-03-18 02:48:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(7, '12', 'AVUKAT', '2020-03-18 02:51:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(8, '1', 'AVUKAT', '2020-03-18 03:07:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(9, '1', 'AVUKAT', '2020-03-18 03:08:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(10, '1', 'AVUKAT', '2020-03-18 22:29:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(11, '1', 'AVUKAT', '2020-03-18 23:46:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(12, '1', 'AVUKAT', '2020-03-18 23:47:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(13, '1', 'AVUKAT', '2020-03-18 23:51:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(14, '1', 'AVUKAT', '2020-03-19 01:23:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(15, '1', 'AVUKAT', '2020-03-19 01:55:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(16, '1', 'AVUKAT', '2020-03-19 01:57:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(17, '1', 'AVUKAT', '2020-03-19 01:59:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(18, '1', 'AVUKAT', '2020-03-19 02:13:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(19, '1', 'AVUKAT', '2020-03-19 02:32:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(20, '11', 'AVUKAT', '2020-03-19 02:33:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(21, '102', 'AVUKAT', '2020-03-19 03:08:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(22, '102', 'AVUKAT', '2020-03-19 03:09:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(23, 'admin', 'YONETICI', '2020-03-19 03:14:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(24, 'admin', 'YONETICI', '2020-03-19 03:15:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(25, '10', 'AVUKAT', '2020-03-19 03:19:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(26, '1', 'AVUKAT', '2020-03-19 03:49:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(27, '1', 'AVUKAT', '2020-03-23 15:22:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(28, '1', 'AVUKAT', '2020-03-23 15:23:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(29, '1', 'AVUKAT', '2020-03-23 15:23:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(30, '1', 'AVUKAT', '2020-03-26 00:14:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(31, '1', 'AVUKAT', '2020-03-26 00:16:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(32, '1', 'AVUKAT', '2020-03-26 00:19:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(33, '1', 'AVUKAT', '2020-03-27 13:00:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(34, '1', 'AVUKAT', '2020-03-29 00:05:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(35, '1', 'AVUKAT', '2020-03-29 00:13:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(36, '1', 'AVUKAT', '2020-03-29 00:14:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(37, '1', 'AVUKAT', '2020-03-29 00:15:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(38, '1', 'AVUKAT', '2020-03-29 00:40:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(39, '1', 'AVUKAT', '2020-03-29 00:42:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(40, '1', 'AVUKAT', '2020-03-29 00:43:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(41, '1', 'AVUKAT', '2020-03-29 00:44:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(42, '1', 'AVUKAT', '2020-03-29 00:48:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(43, '1', 'AVUKAT', '2020-03-29 01:09:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(44, '1', 'AVUKAT', '2020-03-29 01:12:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(45, '1', 'AVUKAT', '2020-03-29 01:15:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(46, '1', 'AVUKAT', '2020-03-29 01:17:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(47, '1', 'AVUKAT', '2020-03-29 01:17:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(48, '1', 'AVUKAT', '2020-03-29 01:22:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(49, '11', 'AVUKAT', '2020-03-29 01:23:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(50, '1', 'AVUKAT', '2020-03-29 01:27:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(51, '1', 'AVUKAT', '2020-03-29 01:28:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(52, '1', 'AVUKAT', '2020-03-29 01:33:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(53, '1', 'AVUKAT', '2020-03-29 01:55:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(54, '1', 'AVUKAT', '2020-03-29 01:57:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(55, '1', 'AVUKAT', '2020-03-29 02:25:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(56, '1', 'AVUKAT', '2020-03-30 01:58:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(57, '1', 'AVUKAT', '2020-03-30 02:00:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(58, '1', 'AVUKAT', '2020-03-30 02:08:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(59, '1', 'AVUKAT', '2020-03-30 02:12:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(60, '1', 'AVUKAT', '2020-03-30 02:15:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(61, '1', 'AVUKAT', '2020-03-30 02:27:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(62, '1', 'AVUKAT', '2020-03-30 03:21:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(63, '1', 'AVUKAT', '2020-03-30 03:22:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(64, '1', 'AVUKAT', '2020-03-30 03:26:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(65, '1', 'AVUKAT', '2020-03-30 03:29:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(66, '1', 'AVUKAT', '2020-03-30 03:31:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(67, '1', 'AVUKAT', '2020-03-30 03:46:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(68, '1', 'AVUKAT', '2020-03-30 04:08:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(69, '1', 'AVUKAT', '2020-03-30 04:11:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(70, '1', 'AVUKAT', '2020-03-30 06:49:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(71, '1', 'AVUKAT', '2020-03-30 07:01:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(72, '1', 'AVUKAT', '2020-03-30 07:03:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(73, '1', 'AVUKAT', '2020-03-30 07:04:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(74, '1', 'AVUKAT', '2020-03-30 07:33:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(75, '1', 'AVUKAT', '2020-03-30 07:38:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(76, '1', 'AVUKAT', '2020-03-30 07:42:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(77, '1', 'AVUKAT', '2020-03-30 07:55:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(78, '1', 'AVUKAT', '2020-03-30 07:56:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(79, '1', 'AVUKAT', '2020-03-30 08:00:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(80, '1', 'AVUKAT', '2020-03-31 02:54:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', ''),
(81, '1', 'AVUKAT', '2020-04-01 20:57:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(82, '1', 'AVUKAT', '2020-04-01 20:58:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(83, '1', 'AVUKAT', '2020-04-01 21:05:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(84, '1', 'AVUKAT', '2020-04-01 21:05:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(85, '1', 'AVUKAT', '2020-04-01 21:06:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(86, '1', 'AVUKAT', '2020-04-01 21:07:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(87, '1', 'AVUKAT', '2020-04-01 21:10:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(88, '1', 'AVUKAT', '2020-04-01 21:12:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(89, '1', 'AVUKAT', '2020-04-01 21:15:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(90, '1', 'AVUKAT', '2020-04-01 21:19:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(91, '1', 'AVUKAT', '2020-04-01 21:48:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(92, '1', 'AVUKAT', '2020-04-01 21:48:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(93, '1', 'AVUKAT', '2020-04-01 21:48:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(94, '1', 'AVUKAT', '2020-04-01 21:49:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(95, '2', 'AVUKAT', '2020-04-01 21:50:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(96, '2', 'AVUKAT', '2020-04-01 21:50:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(97, '1', 'AVUKAT', '2020-04-01 22:54:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(98, '1', 'AVUKAT', '2020-04-01 22:54:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(99, '1', 'AVUKAT', '2020-04-01 22:55:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(100, '1', 'AVUKAT', '2020-04-01 22:56:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(101, '1', 'AVUKAT', '2020-04-01 22:58:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(102, '1', 'AVUKAT', '2020-04-01 22:58:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(103, '1', 'AVUKAT', '2020-04-01 23:18:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(104, '1', 'AVUKAT', '2020-04-01 23:18:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(105, '1', 'AVUKAT', '2020-04-02 01:56:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(106, '1', 'AVUKAT', '2020-04-02 01:56:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(107, '1', 'AVUKAT', '2020-04-02 02:46:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(108, '1', 'AVUKAT', '2020-04-02 02:47:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(109, '1', 'AVUKAT', '2020-04-02 02:47:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(110, '1', 'AVUKAT', '2020-04-02 02:47:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(111, '1', 'AVUKAT', '2020-04-02 03:05:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(112, '1', 'AVUKAT', '2020-04-02 03:05:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(113, '1', 'AVUKAT', '2020-04-02 03:07:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(114, '1', 'AVUKAT', '2020-04-02 03:07:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(115, '1', 'AVUKAT', '2020-04-02 03:08:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(116, '1', 'AVUKAT', '2020-04-02 03:08:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(117, '1', 'AVUKAT', '2020-04-02 03:09:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(118, '1', 'AVUKAT', '2020-04-02 03:09:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(119, '1', 'AVUKAT', '2020-04-02 03:25:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(120, '1', 'AVUKAT', '2020-04-02 03:25:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(121, '1', 'AVUKAT', '2020-04-02 03:26:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(122, '1', 'AVUKAT', '2020-04-02 03:26:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(123, '1', 'AVUKAT', '2020-04-02 03:55:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(124, '1', 'AVUKAT', '2020-04-02 03:55:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(125, '1', 'AVUKAT', '2020-04-02 03:56:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(126, '1', 'AVUKAT', '2020-04-02 03:57:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(127, '1', 'AVUKAT', '2020-04-02 05:17:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(128, '1', 'AVUKAT', '2020-04-02 05:18:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(129, '1', 'AVUKAT', '2020-04-02 05:24:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(130, '1', 'AVUKAT', '2020-04-02 05:24:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(131, '1', 'AVUKAT', '2020-04-03 05:51:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(132, '1', 'AVUKAT', '2020-04-03 05:52:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(133, '1', 'AVUKAT', '2020-04-03 06:18:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(134, '1', 'AVUKAT', '2020-04-03 06:18:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(135, '1', 'AVUKAT', '2020-04-03 06:21:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(136, '1', 'AVUKAT', '2020-04-03 06:21:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(137, '1', 'AVUKAT', '2020-04-03 06:30:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(138, '1', 'AVUKAT', '2020-04-03 06:30:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(139, '1', 'AVUKAT', '2020-04-03 06:44:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(140, '1', 'AVUKAT', '2020-04-03 06:45:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(141, '1', 'AVUKAT', '2020-04-03 07:35:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(142, '1', 'AVUKAT', '2020-04-03 07:36:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(143, '1', 'AVUKAT', '2020-04-03 07:38:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(144, '1', 'AVUKAT', '2020-04-03 07:38:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(145, '1', 'AVUKAT', '2020-04-03 07:40:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(146, '1', 'AVUKAT', '2020-04-03 07:41:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(147, '1', 'AVUKAT', '2020-04-03 07:44:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(148, '1', 'AVUKAT', '2020-04-03 07:44:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(149, '1', 'AVUKAT', '2020-04-03 07:47:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(150, '1', 'AVUKAT', '2020-04-03 07:47:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(151, '1', 'AVUKAT', '2020-04-03 07:48:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(152, '1', 'AVUKAT', '2020-04-03 07:48:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(153, '1', 'AVUKAT', '2020-04-03 07:49:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(154, '1', 'AVUKAT', '2020-04-03 07:49:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(155, '1', 'AVUKAT', '2020-04-03 07:49:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(156, '1', 'AVUKAT', '2020-04-03 07:50:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(157, '1', 'AVUKAT', '2020-04-03 07:54:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(158, '1', 'AVUKAT', '2020-04-03 07:54:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(159, '1', 'AVUKAT', '2020-04-03 07:55:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(160, '1', 'AVUKAT', '2020-04-04 01:33:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(161, '1', 'AVUKAT', '2020-04-04 01:33:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(162, '1', 'AVUKAT', '2020-04-04 01:41:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(163, '1', 'AVUKAT', '2020-04-04 01:42:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(164, '1', 'AVUKAT', '2020-04-04 01:42:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(165, '1', 'AVUKAT', '2020-04-04 01:59:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(166, '1', 'AVUKAT', '2020-04-04 02:00:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(167, '1', 'AVUKAT', '2020-04-04 05:09:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(168, '1', 'AVUKAT', '2020-04-04 05:09:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(169, '1', 'AVUKAT', '2020-04-04 05:12:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(170, '1', 'AVUKAT', '2020-04-04 05:12:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(171, '1', 'AVUKAT', '2020-04-04 05:14:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(172, '1', 'AVUKAT', '2020-04-04 05:14:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(173, '1', 'AVUKAT', '2020-04-04 05:17:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(174, '1', 'AVUKAT', '2020-04-04 05:17:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(175, '1', 'AVUKAT', '2020-04-04 05:20:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(176, '1', 'AVUKAT', '2020-04-04 05:20:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(177, '1', 'AVUKAT', '2020-04-04 05:46:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(178, '1', 'AVUKAT', '2020-04-04 05:46:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(179, '1', 'AVUKAT', '2020-04-04 05:49:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(180, '1', 'AVUKAT', '2020-04-04 05:50:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(181, '1', 'AVUKAT', '2020-04-04 05:53:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(182, '1', 'AVUKAT', '2020-04-04 05:54:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(183, '1', 'AVUKAT', '2020-04-04 05:54:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(184, '1', 'AVUKAT', '2020-04-04 06:02:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(185, '1', 'AVUKAT', '2020-04-04 06:03:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(186, '1', 'AVUKAT', '2020-04-04 06:05:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(187, '1', 'AVUKAT', '2020-04-04 06:06:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(188, '1', 'AVUKAT', '2020-04-04 06:07:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(189, '1', 'AVUKAT', '2020-04-04 06:08:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(190, '1', 'AVUKAT', '2020-04-04 06:08:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(191, '1', 'AVUKAT', '2020-04-04 06:08:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(192, '1', 'AVUKAT', '2020-04-04 06:12:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(193, '1', 'AVUKAT', '2020-04-04 06:12:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(194, '1', 'AVUKAT', '2020-04-04 06:16:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(195, '1', 'AVUKAT', '2020-04-04 06:16:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(196, '1', 'AVUKAT', '2020-04-04 06:21:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(197, '1', 'AVUKAT', '2020-04-04 06:21:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(198, '1', 'AVUKAT', '2020-04-04 06:24:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(199, '1', 'AVUKAT', '2020-04-04 06:24:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(200, '1', 'AVUKAT', '2020-04-04 06:25:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(201, '1', 'AVUKAT', '2020-04-04 06:26:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(202, '1', 'AVUKAT', '2020-04-04 07:02:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(203, '1', 'AVUKAT', '2020-04-04 07:02:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(204, '1', 'AVUKAT', '2020-04-04 07:03:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(205, '1', 'AVUKAT', '2020-04-04 07:03:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(206, '1', 'AVUKAT', '2020-04-04 07:04:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(207, '1', 'AVUKAT', '2020-04-04 07:04:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(208, '1', 'AVUKAT', '2020-04-04 07:05:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(209, '1', 'AVUKAT', '2020-04-04 07:06:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(210, '1', 'AVUKAT', '2020-04-04 07:08:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(211, '1', 'AVUKAT', '2020-04-04 07:08:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(212, '1', 'AVUKAT', '2020-04-04 07:09:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(213, '1', 'AVUKAT', '2020-04-04 07:09:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(214, '1', 'AVUKAT', '2020-04-04 07:12:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(215, '1', 'AVUKAT', '2020-04-04 07:12:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(216, '1', 'AVUKAT', '2020-04-04 07:12:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(217, '1', 'AVUKAT', '2020-04-04 07:13:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(218, '1', 'AVUKAT', '2020-04-05 23:15:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(219, '1', 'AVUKAT', '2020-04-05 23:15:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(220, '1', 'AVUKAT', '2020-04-10 16:13:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(221, '1', 'AVUKAT', '2020-04-10 16:13:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(222, '1', 'AVUKAT', '2020-04-10 16:33:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(223, '1', 'AVUKAT', '2020-04-10 16:35:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(224, '1', 'AVUKAT', '2020-04-10 16:51:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(225, '1', 'AVUKAT', '2020-04-10 16:52:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(226, '1', 'AVUKAT', '2020-04-10 16:52:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(227, '1', 'AVUKAT', '2020-04-10 17:04:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(228, '1', 'AVUKAT', '2020-04-10 17:11:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(229, '1', 'AVUKAT', '2020-04-10 17:11:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(230, '1', 'AVUKAT', '2020-04-10 17:12:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(231, '1', 'AVUKAT', '2020-04-10 17:13:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(232, '1', 'AVUKAT', '2020-04-10 17:32:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(233, '1', 'AVUKAT', '2020-04-10 17:33:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(234, '1', 'AVUKAT', '2020-04-10 18:19:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(235, '1', 'AVUKAT', '2020-04-10 18:20:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(236, '1', 'AVUKAT', '2020-04-10 18:46:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(237, '1', 'AVUKAT', '2020-04-10 18:47:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(238, '1', 'AVUKAT', '2020-04-11 02:49:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(239, '1', 'AVUKAT', '2020-04-11 02:50:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(240, '1', 'AVUKAT', '2020-04-11 03:09:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(241, '1', 'AVUKAT', '2020-04-11 03:12:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(242, '1', 'AVUKAT', '2020-04-11 03:21:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(243, '1', 'AVUKAT', '2020-04-11 03:22:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(244, '1', 'AVUKAT', '2020-04-11 03:32:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(245, '1', 'AVUKAT', '2020-04-11 03:33:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(246, '2', 'AVUKAT', '2020-04-11 03:34:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(247, '2', 'AVUKAT', '2020-04-11 03:35:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(248, '1', 'AVUKAT', '2020-04-11 03:43:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(249, '1', 'AVUKAT', '2020-04-11 03:44:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(250, '1', 'AVUKAT', '2020-04-11 03:46:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(251, '1', 'AVUKAT', '2020-04-11 03:47:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(252, '1', 'AVUKAT', '2020-04-11 04:02:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(253, '1', 'AVUKAT', '2020-04-11 04:02:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(254, '2', 'AVUKAT', '2020-04-11 04:04:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(255, '2', 'AVUKAT', '2020-04-11 04:04:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(256, '1', 'AVUKAT', '2020-04-12 19:25:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(257, '1', 'AVUKAT', '2020-04-12 19:25:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(258, '1', 'AVUKAT', '2020-04-12 19:26:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(259, '1', 'AVUKAT', '2020-04-12 19:26:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(260, '1', 'AVUKAT', '2020-04-12 19:54:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(261, '1', 'AVUKAT', '2020-04-12 19:54:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(262, '1', 'AVUKAT', '2020-04-12 20:03:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(263, '1', 'AVUKAT', '2020-04-12 20:04:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(264, '1', 'AVUKAT', '2020-04-12 20:10:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(265, '1', 'AVUKAT', '2020-04-12 20:11:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(266, '1', 'AVUKAT', '2020-04-12 20:38:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(267, '1', 'AVUKAT', '2020-04-12 20:39:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(268, '1', 'AVUKAT', '2020-04-12 20:55:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(269, '1', 'AVUKAT', '2020-04-12 20:58:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(270, '1', 'AVUKAT', '2020-04-12 21:45:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(271, '1', 'AVUKAT', '2020-04-12 21:56:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(272, '1', 'AVUKAT', '2020-04-12 21:57:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(273, '1', 'AVUKAT', '2020-04-12 22:10:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(274, '1', 'AVUKAT', '2020-04-12 22:11:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(275, '1', 'AVUKAT', '2020-04-12 22:12:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(276, '1', 'AVUKAT', '2020-04-12 22:13:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(277, '1', 'AVUKAT', '2020-04-12 22:20:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(278, '1', 'AVUKAT', '2020-04-12 22:21:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(279, '1', 'AVUKAT', '2020-04-12 22:37:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(280, '1', 'AVUKAT', '2020-04-12 22:38:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(281, '1', 'AVUKAT', '2020-04-12 22:39:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(282, '1', 'AVUKAT', '2020-04-12 22:40:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(283, '1', 'AVUKAT', '2020-04-13 03:31:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(284, '1', 'AVUKAT', '2020-04-13 03:31:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(285, '1', 'AVUKAT', '2020-04-13 03:34:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(286, '1', 'AVUKAT', '2020-04-13 03:35:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(287, '1', 'AVUKAT', '2020-04-13 03:59:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(288, '1', 'AVUKAT', '2020-04-13 04:00:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(289, '1', 'AVUKAT', '2020-04-13 05:33:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(290, '1', 'AVUKAT', '2020-04-13 05:33:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(291, '1', 'AVUKAT', '2020-04-13 05:37:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(292, '1', 'AVUKAT', '2020-04-13 05:37:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(293, '1', 'AVUKAT', '2020-04-13 05:41:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(294, '1', 'AVUKAT', '2020-04-13 05:42:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(295, '1', 'AVUKAT', '2020-04-13 05:50:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(296, '1', 'AVUKAT', '2020-04-13 05:51:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(297, '1', 'AVUKAT', '2020-04-13 05:54:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(298, '1', 'AVUKAT', '2020-04-13 05:58:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(299, '1', 'AVUKAT', '2020-04-13 06:01:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(300, '1', 'AVUKAT', '2020-04-13 06:02:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(301, '1', 'AVUKAT', '2020-04-13 06:04:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(302, '1', 'AVUKAT', '2020-04-13 06:05:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(303, '1', 'AVUKAT', '2020-04-13 06:07:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(304, '1', 'AVUKAT', '2020-04-13 06:07:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(305, '1', 'AVUKAT', '2020-04-13 06:10:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(306, '1', 'AVUKAT', '2020-04-13 06:10:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(307, '1', 'AVUKAT', '2020-04-13 06:15:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(308, '1', 'AVUKAT', '2020-04-13 06:15:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(309, '1', 'AVUKAT', '2020-04-13 06:16:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(310, '1', 'AVUKAT', '2020-04-13 06:16:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(311, '1', 'AVUKAT', '2020-04-13 06:18:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(312, '1', 'AVUKAT', '2020-04-13 06:18:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(313, '1', 'AVUKAT', '2020-04-13 06:26:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(314, '1', 'AVUKAT', '2020-04-13 06:27:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(315, '1', 'AVUKAT', '2020-04-13 06:35:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(316, '1', 'AVUKAT', '2020-04-13 06:36:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(317, '1', 'AVUKAT', '2020-04-13 06:44:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(318, '1', 'AVUKAT', '2020-04-13 06:45:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(319, '1', 'AVUKAT', '2020-04-13 06:47:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(320, '1', 'AVUKAT', '2020-04-13 06:48:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(321, '1', 'AVUKAT', '2020-04-13 06:48:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(322, '1', 'AVUKAT', '2020-04-13 06:49:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(323, '1', 'AVUKAT', '2020-04-13 06:51:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(324, '1', 'AVUKAT', '2020-04-13 06:51:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(325, '1', 'AVUKAT', '2020-04-13 07:19:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(326, '1', 'AVUKAT', '2020-04-13 07:21:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(327, '1', 'AVUKAT', '2020-04-13 07:27:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(328, '1', 'AVUKAT', '2020-04-13 07:29:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(329, '1', 'AVUKAT', '2020-04-13 07:36:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(330, '1', 'AVUKAT', '2020-04-13 07:39:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(331, '1', 'AVUKAT', '2020-04-13 07:41:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(332, '1', 'AVUKAT', '2020-04-13 07:41:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(333, '1', 'AVUKAT', '2020-04-14 16:56:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(334, '1', 'AVUKAT', '2020-04-14 16:56:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(335, '1', 'AVUKAT', '2020-04-14 16:59:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(336, '1', 'AVUKAT', '2020-04-14 17:00:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(337, '1', 'AVUKAT', '2020-04-14 17:06:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(338, '1', 'AVUKAT', '2020-04-14 17:06:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(339, '1', 'AVUKAT', '2020-04-14 17:07:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(340, '1', 'AVUKAT', '2020-04-14 17:08:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(341, '1', 'AVUKAT', '2020-04-14 17:11:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(342, '1', 'AVUKAT', '2020-04-14 17:11:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(343, '1', 'AVUKAT', '2020-04-14 17:14:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(344, '1', 'AVUKAT', '2020-04-14 17:14:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(345, '1', 'AVUKAT', '2020-04-14 17:16:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(346, '1', 'AVUKAT', '2020-04-14 17:16:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(347, '1', 'AVUKAT', '2020-04-14 17:18:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(348, '1', 'AVUKAT', '2020-04-14 17:19:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(349, '1', 'AVUKAT', '2020-04-14 17:22:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(350, '1', 'AVUKAT', '2020-04-14 17:22:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(351, '1', 'AVUKAT', '2020-04-14 17:37:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(352, '1', 'AVUKAT', '2020-04-14 17:38:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(353, '1', 'AVUKAT', '2020-04-14 17:39:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti');
INSERT INTO `hukukburosulog` (`logid`, `logkullaniciadi`, `logkullaniciyetkisi`, `logdatetime`, `logsunucuparametre`, `logaksiyon`) VALUES
(354, '1', 'AVUKAT', '2020-04-14 17:40:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(355, '1', 'AVUKAT', '2020-04-14 17:41:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(356, '1', 'AVUKAT', '2020-04-14 17:42:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(357, '1', 'AVUKAT', '2020-04-14 17:42:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(358, '1', 'AVUKAT', '2020-04-14 17:43:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(359, '1', 'AVUKAT', '2020-04-14 17:44:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(360, '1', 'AVUKAT', '2020-04-14 17:44:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(361, '1', 'AVUKAT', '2020-04-14 17:44:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(362, '1', 'AVUKAT', '2020-04-14 17:45:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(363, '1', 'AVUKAT', '2020-04-14 22:33:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(364, '1', 'AVUKAT', '2020-04-14 22:33:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(365, '1', 'AVUKAT', '2020-04-14 22:36:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(366, '1', 'AVUKAT', '2020-04-14 22:37:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(367, '', 'AVUKAT', '2020-04-14 22:37:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(368, '', 'AVUKAT', '2020-04-14 22:37:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(369, '1', 'AVUKAT', '2020-04-14 23:05:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(370, '1', 'AVUKAT', '2020-04-14 23:06:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(371, '', 'AVUKAT', '2020-04-14 23:10:16', 'jdbc:mysql:///hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(372, '', 'AVUKAT', '2020-04-14 23:10:20', 'jdbc:mysql:///hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(373, '1', 'AVUKAT', '2020-04-14 23:25:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(374, '1', 'AVUKAT', '2020-04-14 23:31:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(375, '1', 'AVUKAT', '2020-04-14 23:31:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(376, '1', 'AVUKAT', '2020-04-14 23:31:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(377, '1', 'AVUKAT', '2020-04-14 23:31:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(378, '', 'AVUKAT', '2020-04-14 23:31:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(379, '', 'AVUKAT', '2020-04-14 23:31:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(380, '', 'AVUKAT', '2020-04-14 23:33:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(381, '', 'AVUKAT', '2020-04-14 23:33:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(382, '', 'AVUKAT', '2020-04-15 00:00:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(383, '', 'AVUKAT', '2020-04-15 00:00:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(384, '', 'AVUKAT', '2020-04-15 00:01:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(385, '', 'AVUKAT', '2020-04-15 00:01:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(386, '', 'AVUKAT', '2020-04-15 00:03:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(387, '', 'AVUKAT', '2020-04-15 00:03:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(388, '', 'AVUKAT', '2020-04-15 00:22:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(389, '', 'AVUKAT', '2020-04-15 00:22:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(390, '', 'AVUKAT', '2020-04-15 00:25:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(391, '', 'AVUKAT', '2020-04-15 00:25:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(392, '8', 'AVUKAT', '2020-04-15 00:30:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(393, '8', 'AVUKAT', '2020-04-15 00:31:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(394, '1', 'AVUKAT', '2020-04-15 00:38:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(395, '1', 'AVUKAT', '2020-04-15 00:38:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(396, '1', 'AVUKAT', '2020-04-15 00:39:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(397, '1', 'AVUKAT', '2020-04-15 00:39:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(398, '1', 'AVUKAT', '2020-04-15 01:00:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(399, '1', 'AVUKAT', '2020-04-15 01:01:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(400, '1', 'AVUKAT', '2020-04-15 01:02:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(401, '1', 'AVUKAT', '2020-04-15 01:02:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(402, '1', 'AVUKAT', '2020-04-15 01:12:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(403, '1', 'AVUKAT', '2020-04-15 01:12:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(404, '1', 'AVUKAT', '2020-04-15 01:16:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(405, '1', 'AVUKAT', '2020-04-15 01:16:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(406, '1', 'AVUKAT', '2020-04-15 01:18:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(407, '1', 'AVUKAT', '2020-04-15 01:18:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(408, '1', 'AVUKAT', '2020-04-15 01:21:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(409, '1', 'AVUKAT', '2020-04-15 01:21:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(410, '1', 'AVUKAT', '2020-04-15 01:22:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(411, '1', 'AVUKAT', '2020-04-15 01:22:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(412, '1', 'AVUKAT', '2020-04-15 01:23:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(413, '1', 'AVUKAT', '2020-04-15 01:24:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(414, '1', 'AVUKAT', '2020-04-15 01:25:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(415, '1', 'AVUKAT', '2020-04-15 01:26:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(416, '1', 'AVUKAT', '2020-04-15 01:33:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(417, '1', 'AVUKAT', '2020-04-15 01:33:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(418, '1', 'AVUKAT', '2020-04-15 01:34:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(419, '1', 'AVUKAT', '2020-04-15 01:35:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(420, '1', 'AVUKAT', '2020-04-15 01:36:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(421, '1', 'AVUKAT', '2020-04-15 01:36:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(422, '1', 'AVUKAT', '2020-04-15 01:41:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(423, '1', 'AVUKAT', '2020-04-15 01:41:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(424, '1', 'AVUKAT', '2020-04-15 01:43:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(425, '1', 'AVUKAT', '2020-04-15 01:43:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(426, '1', 'AVUKAT', '2020-04-15 01:49:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(427, '1', 'AVUKAT', '2020-04-15 01:50:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(428, '1', 'AVUKAT', '2020-04-15 01:52:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(429, '1', 'AVUKAT', '2020-04-15 01:52:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(430, '1', 'AVUKAT', '2020-04-15 01:55:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(431, '1', 'AVUKAT', '2020-04-15 01:55:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(432, '1', 'AVUKAT', '2020-04-15 13:42:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(433, '1', 'AVUKAT', '2020-04-15 13:50:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(434, '1', 'AVUKAT', '2020-04-15 22:08:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(435, '1', 'AVUKAT', '2020-04-15 22:10:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(436, '1', 'AVUKAT', '2020-04-15 22:19:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(437, '1', 'AVUKAT', '2020-04-15 22:20:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(438, '1', 'AVUKAT', '2020-04-15 22:23:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(439, '1', 'AVUKAT', '2020-04-15 22:24:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(440, '1', 'AVUKAT', '2020-04-15 22:30:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(441, '1', 'AVUKAT', '2020-04-15 22:30:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(442, '1', 'AVUKAT', '2020-04-15 22:31:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(443, '1', 'AVUKAT', '2020-04-15 22:31:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(444, '1', 'AVUKAT', '2020-04-15 22:36:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(445, '1', 'AVUKAT', '2020-04-15 22:36:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(446, '1', 'AVUKAT', '2020-04-15 22:58:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(447, '1', 'AVUKAT', '2020-04-15 22:59:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(448, '1', 'AVUKAT', '2020-04-15 23:00:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(449, '1', 'AVUKAT', '2020-04-15 23:03:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(450, '1', 'AVUKAT', '2020-04-15 23:04:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(451, '1', 'AVUKAT', '2020-04-15 23:13:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(452, '1', 'AVUKAT', '2020-04-15 23:26:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(453, '1', 'AVUKAT', '2020-04-15 23:28:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(454, '1', 'AVUKAT', '2020-04-15 23:29:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(455, '1', 'AVUKAT', '2020-04-15 23:29:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(456, '1', 'AVUKAT', '2020-04-15 23:36:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(457, '1', 'AVUKAT', '2020-04-15 23:37:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(458, '1', 'AVUKAT', '2020-04-15 23:44:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(459, '1', 'AVUKAT', '2020-04-15 23:46:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(460, '1', 'AVUKAT', '2020-04-15 23:48:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(461, '1', 'AVUKAT', '2020-04-15 23:48:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(462, '1', 'AVUKAT', '2020-04-15 23:49:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(463, '1', 'AVUKAT', '2020-04-15 23:49:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(464, '1', 'AVUKAT', '2020-04-15 23:50:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(465, '1', 'AVUKAT', '2020-04-15 23:51:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(466, '1', 'AVUKAT', '2020-04-15 23:54:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(467, '1', 'AVUKAT', '2020-04-15 23:55:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(468, '1', 'AVUKAT', '2020-04-16 00:03:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(469, '1', 'AVUKAT', '2020-04-16 00:03:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(470, '1', 'AVUKAT', '2020-04-16 01:10:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(471, '1', 'AVUKAT', '2020-04-16 01:11:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(472, '1', 'AVUKAT', '2020-04-18 19:57:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(473, '1', 'AVUKAT', '2020-04-18 19:57:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(474, '1', 'AVUKAT', '2020-04-18 20:35:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(475, '1', 'AVUKAT', '2020-04-18 20:36:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(476, '1', 'AVUKAT', '2020-04-18 20:40:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(477, '1', 'AVUKAT', '2020-04-18 20:41:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(478, '1', 'AVUKAT', '2020-04-18 20:57:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(479, '1', 'AVUKAT', '2020-04-18 21:00:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(480, '1', 'AVUKAT', '2020-04-18 21:00:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(481, '1', 'AVUKAT', '2020-04-18 22:11:29', 'jdbc:mysql://localhost/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(482, '1', 'AVUKAT', '2020-04-18 22:16:26', 'jdbc:mysql://localhost/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(483, '1', 'AVUKAT', '2020-04-18 22:16:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(484, '1', 'AVUKAT', '2020-04-18 22:17:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(485, '1', 'AVUKAT', '2020-04-18 22:27:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(486, '1', 'AVUKAT', '2020-04-18 22:28:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(487, '1', 'AVUKAT', '2020-04-18 22:44:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(488, '1', 'AVUKAT', '2020-04-18 22:46:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(489, '1', 'AVUKAT', '2020-04-18 22:58:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(490, '1', 'AVUKAT', '2020-04-18 23:13:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(491, '1', 'AVUKAT', '2020-04-18 23:13:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(492, '1', 'AVUKAT', '2020-04-18 23:14:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(493, '1', 'AVUKAT', '2020-04-18 23:20:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(494, '1', 'AVUKAT', '2020-04-18 23:21:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(495, '1', 'AVUKAT', '2020-04-18 23:22:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(496, '1', 'AVUKAT', '2020-04-18 23:22:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(497, '1', 'AVUKAT', '2020-04-18 23:24:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(498, '1', 'AVUKAT', '2020-04-18 23:25:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(499, '1', 'AVUKAT', '2020-04-18 23:27:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(500, '1', 'AVUKAT', '2020-04-18 23:28:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(501, '1', 'AVUKAT', '2020-04-18 23:33:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(502, '1', 'AVUKAT', '2020-04-18 23:33:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(503, '1', 'AVUKAT', '2020-04-18 23:36:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(504, '1', 'AVUKAT', '2020-04-18 23:36:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(505, '1', 'AVUKAT', '2020-04-18 23:40:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(506, '1', 'AVUKAT', '2020-04-18 23:41:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(507, '1', 'AVUKAT', '2020-04-18 23:45:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(508, '1', 'AVUKAT', '2020-04-18 23:47:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(509, '1', 'AVUKAT', '2020-04-19 00:08:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(510, '1', 'AVUKAT', '2020-04-19 00:11:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(511, '1', 'AVUKAT', '2020-04-19 00:25:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(512, '1', 'AVUKAT', '2020-04-19 00:26:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(513, '1', 'AVUKAT', '2020-04-19 00:26:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(514, '1', 'AVUKAT', '2020-04-19 00:27:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(515, '1', 'AVUKAT', '2020-04-19 00:45:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(516, '1', 'AVUKAT', '2020-04-19 00:46:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(517, '1', 'AVUKAT', '2020-04-19 00:59:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(518, '1', 'AVUKAT', '2020-04-19 01:01:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(519, '1', 'AVUKAT', '2020-04-19 01:01:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(520, '1', 'AVUKAT', '2020-04-19 01:02:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(521, '1', 'AVUKAT', '2020-04-19 01:03:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(522, '1', 'AVUKAT', '2020-04-19 01:07:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(523, '1', 'AVUKAT', '2020-04-19 01:17:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(524, '1', 'AVUKAT', '2020-04-19 01:27:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(525, '1', 'AVUKAT', '2020-04-19 01:32:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(526, '1', 'AVUKAT', '2020-04-19 01:34:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(527, '1', 'AVUKAT', '2020-04-19 01:36:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(528, '1', 'AVUKAT', '2020-04-19 01:38:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(529, '1', 'AVUKAT', '2020-04-19 01:39:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(530, '1', 'AVUKAT', '2020-04-19 01:41:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(531, '1', 'AVUKAT', '2020-04-19 01:41:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(532, '1', 'AVUKAT', '2020-04-19 01:44:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(533, '1', 'AVUKAT', '2020-04-19 01:44:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(534, '1', 'AVUKAT', '2020-04-19 01:48:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(535, '1', 'AVUKAT', '2020-04-19 01:48:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(536, '1', 'AVUKAT', '2020-04-19 01:50:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(537, '1', 'AVUKAT', '2020-04-19 01:51:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(538, '1', 'AVUKAT', '2020-04-19 01:54:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(539, '1', 'AVUKAT', '2020-04-19 01:55:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(540, '1', 'AVUKAT', '2020-04-19 02:01:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(541, '1', 'AVUKAT', '2020-04-19 02:03:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(542, '1', 'AVUKAT', '2020-04-19 02:04:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(543, '1', 'AVUKAT', '2020-04-19 02:05:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(544, '1', 'AVUKAT', '2020-04-19 02:05:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(545, '1', 'AVUKAT', '2020-04-19 02:06:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(546, '1', 'AVUKAT', '2020-04-19 02:09:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(547, '1', 'AVUKAT', '2020-04-19 02:10:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(548, '1', 'AVUKAT', '2020-04-19 02:14:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(549, '1', 'AVUKAT', '2020-04-19 02:15:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(550, '1', 'AVUKAT', '2020-04-19 03:22:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(551, '1', 'AVUKAT', '2020-04-19 03:23:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(552, '1', 'AVUKAT', '2020-04-19 03:27:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(553, '1', 'AVUKAT', '2020-04-19 03:28:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(554, '1', 'AVUKAT', '2020-04-19 03:53:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(555, '2', 'AVUKAT', '2020-04-19 03:54:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(556, '1', 'AVUKAT', '2020-04-19 03:56:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(557, '1', 'AVUKAT', '2020-04-19 03:57:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(558, '1', 'AVUKAT', '2020-04-19 04:09:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(559, '1', 'AVUKAT', '2020-04-19 04:09:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(560, '1', 'AVUKAT', '2020-04-19 04:10:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(561, '1', 'AVUKAT', '2020-04-19 04:11:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(562, '1', 'AVUKAT', '2020-04-19 04:27:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(563, '1', 'AVUKAT', '2020-04-19 04:28:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(564, '1', 'AVUKAT', '2020-04-19 04:31:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(565, '1', 'AVUKAT', '2020-04-19 04:31:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(566, '1', 'AVUKAT', '2020-04-19 04:34:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(567, '1', 'AVUKAT', '2020-04-19 04:40:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(568, '1', 'AVUKAT', '2020-04-19 04:58:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(569, '1', 'AVUKAT', '2020-04-19 04:59:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(570, '1', 'AVUKAT', '2020-04-19 06:03:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(571, '1', 'AVUKAT', '2020-04-19 06:05:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(572, '1', 'AVUKAT', '2020-04-19 06:13:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(573, '1', 'AVUKAT', '2020-04-19 06:16:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(574, '1', 'AVUKAT', '2020-04-19 06:22:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(575, '1', 'AVUKAT', '2020-04-19 06:32:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(576, '1', 'AVUKAT', '2020-04-19 06:34:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(577, '1', 'AVUKAT', '2020-04-19 06:34:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(578, '1', 'AVUKAT', '2020-04-19 06:36:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(579, '1', 'AVUKAT', '2020-04-19 06:38:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(580, '1', 'AVUKAT', '2020-04-19 06:39:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(581, '1', 'AVUKAT', '2020-04-19 06:50:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(582, '1', 'AVUKAT', '2020-04-19 20:21:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(583, '1', 'AVUKAT', '2020-04-19 20:22:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(584, '1', 'AVUKAT', '2020-04-19 20:27:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(585, '1', 'AVUKAT', '2020-04-19 20:29:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(586, '1', 'AVUKAT', '2020-04-19 20:38:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(587, '1', 'AVUKAT', '2020-04-19 20:39:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(588, '1', 'AVUKAT', '2020-04-19 20:39:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(589, '1', 'AVUKAT', '2020-04-19 20:54:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(590, '1', 'AVUKAT', '2020-04-19 20:54:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(591, '1', 'AVUKAT', '2020-04-19 20:56:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(592, '1', 'AVUKAT', '2020-04-19 20:57:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(593, '1', 'AVUKAT', '2020-04-19 21:02:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(594, '1', 'AVUKAT', '2020-04-19 21:07:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(595, '1', 'AVUKAT', '2020-04-19 21:08:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(596, '1', 'AVUKAT', '2020-04-19 21:16:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(597, '1', 'AVUKAT', '2020-04-19 21:18:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(598, '1', 'AVUKAT', '2020-04-19 21:21:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(599, '1', 'AVUKAT', '2020-04-19 21:29:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(600, '1', 'AVUKAT', '2020-04-19 21:30:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(601, '1', 'AVUKAT', '2020-04-19 21:31:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(602, '1', 'AVUKAT', '2020-04-19 21:32:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(603, '1', 'AVUKAT', '2020-04-20 00:22:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(604, '1', 'AVUKAT', '2020-04-20 00:22:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(605, '1', 'AVUKAT', '2020-04-20 00:26:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(606, '1', 'AVUKAT', '2020-04-20 00:26:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(607, '1', 'AVUKAT', '2020-04-20 00:28:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(608, '1', 'AVUKAT', '2020-04-20 00:28:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(609, '1', 'AVUKAT', '2020-04-20 00:31:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(610, '1', 'AVUKAT', '2020-04-20 00:35:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(611, '1', 'AVUKAT', '2020-04-20 00:37:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(612, '1', 'AVUKAT', '2020-04-20 00:38:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(613, '1', 'AVUKAT', '2020-04-20 00:47:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(614, '1', 'AVUKAT', '2020-04-20 00:49:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(615, '1', 'AVUKAT', '2020-04-20 00:51:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(616, '1', 'AVUKAT', '2020-04-20 00:51:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(617, '1', 'AVUKAT', '2020-04-20 00:55:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(618, '1', 'AVUKAT', '2020-04-20 01:05:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(619, '1', 'AVUKAT', '2020-04-20 01:08:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(620, '1', 'AVUKAT', '2020-04-20 01:09:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(621, '1', 'AVUKAT', '2020-04-20 01:11:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(622, '1', 'AVUKAT', '2020-04-20 01:12:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(623, '1', 'AVUKAT', '2020-04-20 01:14:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(624, '1', 'AVUKAT', '2020-04-20 01:15:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(625, '1', 'AVUKAT', '2020-04-20 01:16:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(626, '1', 'AVUKAT', '2020-04-20 01:20:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(627, '1', 'AVUKAT', '2020-04-20 01:21:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(628, '1', 'AVUKAT', '2020-04-21 01:56:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(629, '1', 'AVUKAT', '2020-04-21 02:01:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(630, '1', 'AVUKAT', '2020-04-21 02:03:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(631, '1', 'AVUKAT', '2020-04-21 02:26:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(632, '1', 'AVUKAT', '2020-04-21 02:27:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(633, '1', 'AVUKAT', '2020-04-21 02:29:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(634, '1', 'AVUKAT', '2020-04-21 02:30:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(635, '1', 'AVUKAT', '2020-04-21 02:34:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(636, '1', 'AVUKAT', '2020-04-21 02:34:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(637, '1', 'AVUKAT', '2020-04-21 02:39:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(638, '1', 'AVUKAT', '2020-04-21 02:40:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(639, '1', 'AVUKAT', '2020-04-21 02:55:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(640, '1', 'AVUKAT', '2020-04-21 02:55:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(641, '1', 'AVUKAT', '2020-04-21 02:56:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(642, '1', 'AVUKAT', '2020-04-21 02:58:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(643, '1', 'AVUKAT', '2020-04-21 17:28:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(644, '1', 'AVUKAT', '2020-04-21 17:32:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(645, '1', 'AVUKAT', '2020-04-21 17:39:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(646, '1', 'AVUKAT', '2020-04-21 17:42:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(647, '1', 'AVUKAT', '2020-04-21 17:46:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(648, '1', 'AVUKAT', '2020-04-21 17:46:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(649, '1', 'AVUKAT', '2020-04-21 17:51:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(650, '1', 'AVUKAT', '2020-04-21 18:04:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(651, '1', 'AVUKAT', '2020-04-21 18:06:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(652, '1', 'AVUKAT', '2020-04-21 18:14:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(653, '1', 'AVUKAT', '2020-04-21 18:20:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(654, '1', 'AVUKAT', '2020-04-21 18:21:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(655, '1', 'AVUKAT', '2020-04-21 18:39:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(656, '1', 'AVUKAT', '2020-04-21 18:40:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(657, '1', 'AVUKAT', '2020-04-21 19:41:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(658, '1', 'AVUKAT', '2020-04-21 19:45:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(659, '1', 'AVUKAT', '2020-04-21 19:47:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(660, '1', 'AVUKAT', '2020-04-21 19:51:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(661, '1', 'AVUKAT', '2020-04-21 19:58:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(662, '1', 'AVUKAT', '2020-04-21 19:59:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(663, '1', 'AVUKAT', '2020-04-21 20:11:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(664, '1', 'AVUKAT', '2020-04-21 20:11:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(665, '1', 'AVUKAT', '2020-04-21 20:36:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(666, '1', 'AVUKAT', '2020-04-21 20:39:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(667, '1', 'AVUKAT', '2020-04-21 20:41:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(668, '1', 'AVUKAT', '2020-04-21 20:46:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(669, '1', 'AVUKAT', '2020-04-21 20:46:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(670, '1', 'AVUKAT', '2020-04-21 20:49:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(671, '1', 'AVUKAT', '2020-04-21 20:49:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(672, '1', 'AVUKAT', '2020-04-21 21:00:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(673, '1', 'AVUKAT', '2020-04-21 21:03:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(674, '1', 'AVUKAT', '2020-04-21 21:03:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(675, '1', 'AVUKAT', '2020-04-21 21:05:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(676, '1', 'AVUKAT', '2020-04-21 21:11:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(677, '1', 'AVUKAT', '2020-04-21 21:21:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(678, '1', 'AVUKAT', '2020-04-21 21:23:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(679, '1', 'AVUKAT', '2020-04-21 21:38:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(680, '1', 'AVUKAT', '2020-04-21 21:38:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(681, '1', 'AVUKAT', '2020-04-21 21:49:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(682, '1', 'AVUKAT', '2020-04-21 21:50:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(683, '1', 'AVUKAT', '2020-04-21 22:53:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(684, '1', 'AVUKAT', '2020-04-21 22:53:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(685, '1', 'AVUKAT', '2020-04-21 22:54:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(686, '1', 'AVUKAT', '2020-04-21 22:55:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(687, '1', 'AVUKAT', '2020-04-21 23:16:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(688, '1', 'AVUKAT', '2020-04-21 23:17:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(689, '1', 'AVUKAT', '2020-04-21 23:26:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(690, '1', 'AVUKAT', '2020-04-21 23:26:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(691, '1', 'AVUKAT', '2020-04-21 23:27:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(692, '1', 'AVUKAT', '2020-04-21 23:28:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(693, '1', 'AVUKAT', '2020-04-21 23:28:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(694, '1', 'AVUKAT', '2020-04-21 23:28:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(695, '1', 'AVUKAT', '2020-04-21 23:30:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti');
INSERT INTO `hukukburosulog` (`logid`, `logkullaniciadi`, `logkullaniciyetkisi`, `logdatetime`, `logsunucuparametre`, `logaksiyon`) VALUES
(696, '1', 'AVUKAT', '2020-04-21 23:30:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(697, '1', 'AVUKAT', '2020-04-22 00:54:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(698, '1', 'AVUKAT', '2020-04-22 00:55:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(699, '1', 'AVUKAT', '2020-04-22 01:03:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(700, '1', 'AVUKAT', '2020-04-22 01:04:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(701, '1', 'AVUKAT', '2020-04-22 01:06:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(702, '1', 'AVUKAT', '2020-04-22 01:07:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(703, '1', 'AVUKAT', '2020-04-22 01:12:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(704, '1', 'AVUKAT', '2020-04-22 01:13:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(705, '1', 'AVUKAT', '2020-04-22 01:47:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(706, '1', 'AVUKAT', '2020-04-22 01:47:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(707, '1', 'AVUKAT', '2020-04-22 01:51:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(708, '1', 'AVUKAT', '2020-04-22 01:51:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(709, '1', 'AVUKAT', '2020-04-22 02:43:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(710, '1', 'AVUKAT', '2020-04-22 02:45:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(711, '1', 'AVUKAT', '2020-04-22 02:46:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(712, '1', 'AVUKAT', '2020-04-22 02:49:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(713, '1', 'AVUKAT', '2020-04-22 02:51:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(714, '1', 'AVUKAT', '2020-04-22 02:51:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(715, '1', 'AVUKAT', '2020-04-22 02:54:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(716, '1', 'AVUKAT', '2020-04-22 02:55:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(717, '1', 'AVUKAT', '2020-04-22 02:56:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(718, '1', 'AVUKAT', '2020-04-22 02:57:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(719, '1', 'AVUKAT', '2020-04-22 02:57:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(720, '1', 'AVUKAT', '2020-04-22 02:58:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(721, '1', 'AVUKAT', '2020-04-22 02:58:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(722, '1', 'AVUKAT', '2020-04-22 02:59:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(723, '1', 'AVUKAT', '2020-04-22 08:49:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(724, '1', 'AVUKAT', '2020-04-22 08:49:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(725, '1', 'AVUKAT', '2020-04-25 01:35:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(726, '1', 'AVUKAT', '2020-04-25 01:43:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(727, '1', 'AVUKAT', '2020-04-25 03:33:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(728, '1', 'AVUKAT', '2020-04-25 03:33:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(729, '1', 'AVUKAT', '2020-04-25 05:46:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(730, '1', 'AVUKAT', '2020-04-25 05:47:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(731, '1', 'AVUKAT', '2020-04-27 14:48:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(732, '1', 'AVUKAT', '2020-04-27 14:52:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(733, '1', 'AVUKAT', '2020-04-27 14:52:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(734, '1', 'AVUKAT', '2020-04-27 15:05:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(735, '1', 'AVUKAT', '2020-04-27 15:05:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(736, '1', 'AVUKAT', '2020-04-27 15:05:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(737, '1', 'AVUKAT', '2020-04-27 15:06:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(738, '1', 'AVUKAT', '2020-04-28 17:15:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(739, '1', 'AVUKAT', '2020-04-28 17:17:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(740, '1', 'AVUKAT', '2020-04-28 17:18:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(741, '1', 'AVUKAT', '2020-04-28 17:20:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(742, '1', 'AVUKAT', '2020-04-28 18:03:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(743, '1', 'AVUKAT', '2020-04-28 18:06:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(744, '1', 'AVUKAT', '2020-04-28 18:06:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(745, '1', 'AVUKAT', '2020-04-28 18:07:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(746, '1', 'AVUKAT', '2020-04-28 18:11:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(747, '1', 'AVUKAT', '2020-04-28 18:12:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(748, '1', 'AVUKAT', '2020-04-28 18:14:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(749, '1', 'AVUKAT', '2020-04-28 18:20:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(750, '1', 'AVUKAT', '2020-04-28 18:30:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(751, '1', 'AVUKAT', '2020-04-28 18:34:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(752, '1', 'AVUKAT', '2020-04-28 18:43:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(753, '1', 'AVUKAT', '2020-04-28 18:44:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(754, '1', 'AVUKAT', '2020-04-28 18:59:16', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(755, '1', 'AVUKAT', '2020-04-28 19:00:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(756, '1', 'AVUKAT', '2020-04-28 19:01:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(757, '1', 'AVUKAT', '2020-04-28 19:04:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(758, '1', 'AVUKAT', '2020-04-28 19:10:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(759, '1', 'AVUKAT', '2020-04-28 19:26:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(760, '1', 'AVUKAT', '2020-04-28 19:31:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(761, '1', 'AVUKAT', '2020-04-28 19:34:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(762, '1', 'AVUKAT', '2020-04-28 19:42:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(763, '1', 'AVUKAT', '2020-04-28 19:45:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(764, '1', 'AVUKAT', '2020-04-28 19:49:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(765, '1', 'AVUKAT', '2020-04-28 20:19:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(766, '1', 'AVUKAT', '2020-04-28 21:05:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(767, '1', 'AVUKAT', '2020-04-29 20:11:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(768, '1', 'AVUKAT', '2020-04-29 20:12:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(769, '1', 'AVUKAT', '2020-04-29 21:15:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(770, '1', 'AVUKAT', '2020-04-29 21:17:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(771, '1', 'AVUKAT', '2020-04-29 21:19:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(772, '1', 'AVUKAT', '2020-04-29 21:19:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(773, '1', 'AVUKAT', '2020-04-29 21:24:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(774, '1', 'AVUKAT', '2020-04-29 21:36:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(775, '1', 'AVUKAT', '2020-04-29 22:59:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(776, '1', 'YONETICI', '2020-04-29 23:00:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(777, '1', 'YONETICI', '2020-04-29 23:01:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(778, '2', 'AVUKAT', '2020-04-29 23:02:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(779, '2', 'AVUKAT', '2020-04-29 23:05:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(780, '1', 'YONETICI', '2020-04-29 23:07:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(781, '2', 'AVUKAT', '2020-04-29 23:07:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(782, '1', 'YONETICI', '2020-04-29 23:42:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(783, '1', 'YONETICI', '2020-04-29 23:43:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(784, '11', 'SEKRETER', '2020-04-29 23:44:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(785, '1', 'YONETICI', '2020-04-29 23:57:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(786, '1', 'YONETICI', '2020-04-30 00:46:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(787, '1', 'YONETICI', '2020-04-30 00:49:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(788, '1', 'YONETICI', '2020-04-30 00:57:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(789, '1', 'YONETICI', '2020-04-30 01:01:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(790, '1', 'YONETICI', '2020-04-30 01:19:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(791, '1', 'YONETICI', '2020-04-30 01:25:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(792, '1', 'YONETICI', '2020-04-30 01:36:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(793, '1', 'YONETICI', '2020-04-30 01:50:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(794, '1', 'YONETICI', '2020-04-30 02:03:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(795, '1', 'YONETICI', '2020-04-30 02:06:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(796, '1', 'YONETICI', '2020-04-30 02:10:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(797, '1', 'YONETICI', '2020-04-30 02:17:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(798, '1', 'YONETICI', '2020-04-30 02:19:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(799, '1', 'YONETICI', '2020-04-30 02:21:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(800, '1', 'YONETICI', '2020-04-30 02:40:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(801, '1', 'YONETICI', '2020-04-30 02:41:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(802, '1', 'YONETICI', '2020-04-30 02:43:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(803, '1', 'YONETICI', '2020-04-30 02:53:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(804, '1', 'YONETICI', '2020-04-30 03:03:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(805, '1', 'YONETICI', '2020-04-30 03:18:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(806, '1', 'YONETICI', '2020-04-30 03:20:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(807, '18', 'YONETICI', '2020-04-30 03:21:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(808, '1', 'YONETICI', '2020-04-30 03:31:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(809, '1', 'YONETICI', '2020-04-30 03:36:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(810, '12', 'SEKRETER', '2020-04-30 03:37:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(811, '1', 'YONETICI', '2020-04-30 03:38:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(812, '1', 'YONETICI', '2020-04-30 03:39:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(813, '2', 'AVUKAT', '2020-04-30 03:39:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(814, '2', 'AVUKAT', '2020-04-30 03:41:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(815, '1', 'YONETICI', '2020-04-30 03:48:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(816, '1', 'YONETICI', '2020-04-30 04:05:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(817, '2', 'AVUKAT', '2020-04-30 04:07:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(818, '1', 'YONETICI', '2020-04-30 04:08:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(819, '1', 'YONETICI', '2020-05-01 00:59:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(820, '1', 'YONETICI', '2020-05-01 01:00:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(821, '1', 'YONETICI', '2020-05-01 01:03:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(822, '1', 'YONETICI', '2020-05-01 01:06:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(823, '1', 'YONETICI', '2020-05-01 01:32:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(824, '1', 'YONETICI', '2020-05-01 01:35:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(825, '1', 'YONETICI', '2020-05-01 01:45:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(826, '1', 'YONETICI', '2020-05-01 01:46:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(827, '1', 'YONETICI', '2020-05-01 01:48:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(828, '11', 'SEKRETER', '2020-05-01 02:08:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(829, '1', 'YONETICI', '2020-05-01 02:09:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(830, '1', 'YONETICI', '2020-05-01 02:11:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(831, '1', 'YONETICI', '2020-05-01 02:12:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(832, '1', 'YONETICI', '2020-05-01 02:23:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(833, '1', 'YONETICI', '2020-05-01 02:37:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(834, '1', 'YONETICI', '2020-05-01 02:41:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(835, '1', 'YONETICI', '2020-05-01 02:42:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(836, '1', 'YONETICI', '2020-05-01 02:45:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(837, '1', 'YONETICI', '2020-05-01 03:02:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(838, '1', 'YONETICI', '2020-05-01 03:13:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(839, '1', 'YONETICI', '2020-05-01 03:21:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(840, '1', 'YONETICI', '2020-05-01 03:54:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(841, '1', 'YONETICI', '2020-05-01 03:56:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(842, '1', 'YONETICI', '2020-05-01 04:06:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(843, '1', 'YONETICI', '2020-05-01 04:20:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(844, '1', 'YONETICI', '2020-05-01 04:45:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(845, '1', 'YONETICI', '2020-05-01 04:46:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(846, '1', 'YONETICI', '2020-05-01 05:01:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(847, '1', 'YONETICI', '2020-05-01 05:01:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(848, '1', 'YONETICI', '2020-05-01 05:01:45', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(849, '1', 'YONETICI', '2020-05-01 05:03:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(850, '1', 'YONETICI', '2020-05-01 05:03:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(851, '1', 'YONETICI', '2020-05-01 05:03:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(852, '1', 'YONETICI', '2020-05-01 05:06:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(853, '1', 'YONETICI', '2020-05-01 05:06:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(854, '1', 'YONETICI', '2020-05-01 05:09:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(855, '1', 'YONETICI', '2020-05-01 05:09:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(856, '1', 'YONETICI', '2020-05-01 05:10:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(857, '1', 'YONETICI', '2020-05-01 05:10:35', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(858, '1', 'YONETICI', '2020-05-01 05:10:43', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(859, '1', 'YONETICI', '2020-05-01 05:10:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(860, '1', 'YONETICI', '2020-05-01 05:16:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(861, '1', 'YONETICI', '2020-05-01 05:16:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(862, '1', 'YONETICI', '2020-05-01 05:17:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(863, '1', 'YONETICI', '2020-05-01 05:19:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(864, '1', 'YONETICI', '2020-05-01 05:22:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(865, '1', 'YONETICI', '2020-05-01 05:27:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(866, '1', 'YONETICI', '2020-05-01 05:31:22', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(867, '1', 'YONETICI', '2020-05-01 05:55:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(868, '1', 'YONETICI', '2020-05-01 05:57:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(869, '1', 'YONETICI', '2020-05-01 06:00:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(870, '1', 'YONETICI', '2020-05-01 06:00:47', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(871, '1', 'YONETICI', '2020-05-01 06:01:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(872, '1', 'YONETICI', '2020-05-01 06:01:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(873, '1', 'YONETICI', '2020-05-01 06:04:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(874, '1', 'YONETICI', '2020-05-01 06:08:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(875, '1', 'YONETICI', '2020-05-01 19:39:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(876, '1', 'YONETICI', '2020-05-01 19:43:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(877, '1', 'YONETICI', '2020-05-01 19:46:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(878, '1', 'YONETICI', '2020-05-01 19:51:58', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(879, '1', 'YONETICI', '2020-05-01 19:55:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(880, '1', 'YONETICI', '2020-05-01 20:00:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(881, '1', 'YONETICI', '2020-05-01 20:10:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(882, '1', 'YONETICI', '2020-05-01 20:11:50', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(883, '1', 'YONETICI', '2020-05-01 20:14:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(884, '1', 'YONETICI', '2020-05-01 20:16:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(885, '1', 'YONETICI', '2020-05-01 20:19:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(886, '1', 'YONETICI', '2020-05-01 21:23:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(887, '1', 'YONETICI', '2020-05-01 21:24:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(888, '1', 'YONETICI', '2020-05-01 21:24:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(889, '1', 'YONETICI', '2020-05-01 21:37:13', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(890, '1', 'YONETICI', '2020-05-01 21:37:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(891, '1', 'YONETICI', '2020-05-01 21:38:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(892, '1', 'YONETICI', '2020-05-01 21:39:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(893, '2', 'AVUKAT', '2020-05-01 21:39:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(894, '1', 'YONETICI', '2020-05-01 21:57:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(895, '1', 'YONETICI', '2020-05-01 21:58:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(896, '1', 'YONETICI', '2020-05-01 21:58:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(897, '1', 'YONETICI', '2020-05-01 21:59:12', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(898, '1', 'YONETICI', '2020-05-01 22:06:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(899, '1', 'YONETICI', '2020-05-01 22:06:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(900, '1', 'YONETICI', '2020-05-01 22:08:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(901, '1', 'YONETICI', '2020-05-01 22:08:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(902, '1', 'YONETICI', '2020-05-01 22:12:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(903, '1', 'YONETICI', '2020-05-01 22:12:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(904, '1', 'YONETICI', '2020-05-01 22:12:26', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(905, '1', 'YONETICI', '2020-05-01 22:24:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(906, '1', 'YONETICI', '2020-05-01 22:29:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(907, '1', 'YONETICI', '2020-05-01 22:30:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(908, '1', 'YONETICI', '2020-05-01 22:30:05', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(909, '1', 'YONETICI', '2020-05-01 22:33:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(910, '1', 'YONETICI', '2020-05-01 22:33:57', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(911, '1', 'YONETICI', '2020-05-01 22:34:03', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(912, '4', 'AVUKAT', '2020-05-01 22:34:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(913, '1', 'YONETICI', '2020-05-01 22:35:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(914, '1', 'YONETICI', '2020-05-01 22:35:09', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(915, '1', 'YONETICI', '2020-05-01 22:35:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(916, '2', 'AVUKAT', '2020-05-01 22:36:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(917, '2', 'AVUKAT', '2020-05-01 22:36:07', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(918, '1', 'YONETICI', '2020-05-01 23:07:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(919, '1', 'YONETICI', '2020-05-01 23:07:25', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(920, '1', 'YONETICI', '2020-05-01 23:07:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(921, '1', 'YONETICI', '2020-05-01 23:18:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(922, '1', 'YONETICI', '2020-05-01 23:18:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(923, '1', 'YONETICI', '2020-05-01 23:18:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(924, '1', 'YONETICI', '2020-05-01 23:19:04', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(925, '2', 'AVUKAT', '2020-05-01 23:20:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(926, '1', 'YONETICI', '2020-05-01 23:20:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(927, '1', 'YONETICI', '2020-05-01 23:20:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(928, '1', 'YONETICI', '2020-05-01 23:21:30', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(929, '1', 'YONETICI', '2020-05-01 23:21:31', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(930, '1', 'YONETICI', '2020-05-01 23:32:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(931, '1', 'YONETICI', '2020-05-01 23:46:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(932, '1', 'YONETICI', '2020-05-01 23:53:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(933, '1', 'YONETICI', '2020-05-01 23:59:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(934, '2', 'AVUKAT', '2020-05-02 00:10:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(935, '2', 'AVUKAT', '2020-05-02 00:11:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(936, '2', 'AVUKAT', '2020-05-02 00:11:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(937, '1', 'YONETICI', '2020-05-02 00:13:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(938, '1', 'YONETICI', '2020-05-02 00:13:20', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(939, '1', 'YONETICI', '2020-05-02 00:16:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(940, '1', 'YONETICI', '2020-05-02 00:16:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(941, '2', 'AVUKAT', '2020-05-02 00:20:18', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(942, '2', 'AVUKAT', '2020-05-02 00:20:33', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(943, '2', 'AVUKAT', '2020-05-02 00:20:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(944, '3', 'AVUKAT', '2020-05-02 00:24:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(945, '3', 'AVUKAT', '2020-05-02 00:24:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(946, '1', 'YONETICI', '2020-05-02 00:25:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(947, '1', 'YONETICI', '2020-05-02 00:25:55', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(948, '1', 'YONETICI', '2020-05-02 00:25:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(949, '1', 'YONETICI', '2020-05-02 00:27:42', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(950, '1', 'YONETICI', '2020-05-02 00:28:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(951, '1', 'YONETICI', '2020-05-02 00:32:00', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(952, '1', 'YONETICI', '2020-05-02 00:34:21', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(953, '1', 'YONETICI', '2020-05-02 00:44:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(954, '1', 'YONETICI', '2020-05-02 01:31:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(955, '11', 'SEKRETER', '2020-05-02 01:33:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(956, '1', 'YONETICI', '2020-05-02 01:36:49', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(957, '1', 'YONETICI', '2020-05-02 01:38:51', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(958, '1', 'YONETICI', '2020-05-02 01:39:19', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(959, '1', 'YONETICI', '2020-05-02 01:40:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(960, '1', 'YONETICI', '2020-05-02 01:42:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(961, '1', 'YONETICI', '2020-05-02 01:42:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(962, '1', 'YONETICI', '2020-05-02 01:43:53', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(963, '1', 'YONETICI', '2020-05-02 01:49:34', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(964, '1', 'YONETICI', '2020-05-02 02:07:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(965, '1', 'YONETICI', '2020-05-02 02:11:44', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(966, '1', 'YONETICI', '2020-05-02 02:11:56', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(967, '1', 'YONETICI', '2020-05-02 02:13:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(968, '1', 'YONETICI', '2020-05-02 02:25:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(969, '1', 'YONETICI', '2020-05-02 02:28:08', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(970, '1', 'YONETICI', '2020-05-02 02:47:32', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(971, '1', 'YONETICI', '2020-05-02 02:53:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(972, '1', 'YONETICI', '2020-05-02 02:53:54', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(973, '1', 'YONETICI', '2020-05-02 03:01:10', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(974, '1', 'YONETICI', '2020-05-02 03:05:37', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(975, '1', 'YONETICI', '2020-05-02 03:05:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(976, '1', 'YONETICI', '2020-05-02 03:07:24', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(977, '1', 'YONETICI', '2020-05-02 03:07:46', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(978, '1', 'YONETICI', '2020-05-02 03:12:52', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(979, '1', 'YONETICI', '2020-05-02 03:16:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(980, '1', 'YONETICI', '2020-05-02 03:17:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(981, '1', 'YONETICI', '2020-05-02 03:18:17', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(982, '1', 'YONETICI', '2020-05-02 03:50:06', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(983, '1', 'YONETICI', '2020-05-02 03:51:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(984, 'Av.Mustafa', 'YONETICI', '2020-05-02 03:51:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(985, 'Av.Mustafa', 'YONETICI', '2020-05-02 03:52:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(986, 'admin', 'YONETICI', '2020-05-02 18:27:11', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(987, 'admin', 'YONETICI', '2020-05-02 19:45:01', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(988, 'admin', 'YONETICI', '2020-05-02 20:20:27', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(989, 'admin', 'YONETICI', '2020-05-02 20:26:38', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(990, 'admin', 'YONETICI', '2020-05-02 20:29:36', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(991, 'admin', 'YONETICI', '2020-05-02 20:33:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(992, '1', 'YONETICI', '2020-05-02 20:34:39', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(993, '1', 'YONETICI', '2020-05-02 22:51:40', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(994, '3', 'AVUKAT', '2020-05-02 22:53:28', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(995, '3', 'AVUKAT', '2020-05-02 22:54:15', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(996, '3', 'AVUKAT', '2020-05-02 22:55:23', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(997, '3', 'AVUKAT', '2020-05-02 22:55:41', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(998, '1', 'YONETICI', '2020-05-02 22:55:48', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(999, '1', 'YONETICI', '2020-05-02 22:59:14', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(1000, '1', 'YONETICI', '2020-05-02 22:59:29', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti'),
(1001, '1', 'YONETICI', '2020-05-02 23:01:59', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sisteme Giris Yapti'),
(1002, '1', 'YONETICI', '2020-05-02 23:03:02', 'jdbc:mysql://localhost:3306/hukukburosu?useTimezone=true&serverTimezone=UTC', 'Sistemden Cikis Yapti');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hukuklogislem`
--

CREATE TABLE `hukuklogislem` (
  `islemid` int(11) NOT NULL,
  `islemzamani` datetime DEFAULT current_timestamp(),
  `kullaniciadi` varchar(100) DEFAULT NULL,
  `Aciklama` varchar(100) DEFAULT NULL,
  `kullaniciyetki` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `hukuklogislem`
--

INSERT INTO `hukuklogislem` (`islemid`, `islemzamani`, `kullaniciadi`, `Aciklama`, `kullaniciyetki`) VALUES
(1, '2020-04-28 18:07:52', '1', 'Muvekkil Ana Ekranına gitti...', 'AVUKAT'),
(2, '2020-04-28 18:07:59', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(3, '2020-04-28 18:08:05', '1', 'Buro Bilgi Ana Ekranina gitti...', 'AVUKAT'),
(4, '2020-04-28 18:08:10', '1', 'Avukat Ana Ekranina gitti...', 'AVUKAT'),
(5, '2020-04-28 18:08:15', '1', 'Kullanici Ana Ekranina gitti...', 'AVUKAT'),
(6, '2020-04-28 18:11:19', '1', 'Raporlama Ana Ekranina gitti...', 'AVUKAT'),
(7, '2020-04-28 18:11:23', '1', 'Avukat Ana Ekranina gitti...', 'AVUKAT'),
(8, '2020-04-28 18:13:27', '1', 'Raporlama Ana Ekranina gitti...', 'AVUKAT'),
(9, '2020-04-28 18:13:33', '1', 'Yardim Ana Ekranina gitti...', 'AVUKAT'),
(10, '2020-04-28 18:13:51', '1', 'Avukat Ana Ekranina gitti...', 'AVUKAT'),
(11, '2020-04-28 18:30:24', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(12, '2020-04-28 18:34:41', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(13, '2020-04-28 18:34:59', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(14, '2020-04-28 18:36:17', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(15, '2020-04-28 18:36:41', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(16, '2020-04-28 18:43:58', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(17, '2020-04-28 18:44:05', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(18, '2020-04-28 18:45:01', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(19, '2020-04-28 18:45:05', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(20, '2020-04-28 18:47:24', '1', 'Yardim Ana Ekranina gitti...', 'AVUKAT'),
(21, '2020-04-28 18:47:30', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(22, '2020-04-28 18:47:57', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(23, '2020-04-28 18:53:46', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(24, '2020-04-28 18:55:04', '1', 'Yardim Ana Ekranina gitti...', 'AVUKAT'),
(25, '2020-04-28 18:55:10', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(26, '2020-04-28 18:59:31', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(27, '2020-04-28 19:00:57', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(28, '2020-04-28 19:01:31', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(29, '2020-04-28 19:02:40', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(30, '2020-04-28 19:02:44', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(31, '2020-04-28 19:03:38', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(32, '2020-04-28 19:05:01', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(33, '2020-04-28 19:32:12', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(34, '2020-04-28 19:34:39', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(35, '2020-04-28 19:36:49', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(36, '2020-04-28 19:40:11', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(37, '2020-04-28 19:45:44', '1', 'Muvekkil Ana Ekranına gitti...', 'AVUKAT'),
(38, '2020-04-28 19:46:03', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(39, '2020-04-28 19:46:22', '1', 'Muvekkil Ana Ekranına gitti...', 'AVUKAT'),
(40, '2020-04-28 19:48:00', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(41, '2020-04-28 19:49:40', '1', 'Kullanici Ana Ekranina gitti...', 'AVUKAT'),
(42, '2020-04-28 20:19:42', '1', 'Personel Ana Ekranina gitti...', 'AVUKAT'),
(43, '2020-04-29 21:25:04', '1', 'Yardim Ana Ekranina gitti...', 'AVUKAT'),
(44, '2020-04-29 21:36:05', '1', 'Muvekkil Ana Ekranına gitti...', 'AVUKAT'),
(45, '2020-04-29 22:59:12', '1', 'Kullanici Ana Ekranina gitti...', 'AVUKAT'),
(46, '2020-04-29 23:00:45', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(47, '2020-04-29 23:02:07', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(48, '2020-04-29 23:02:26', '2', 'Kullanici Ana Ekranina gitti...', 'AVUKAT'),
(49, '2020-04-29 23:05:14', '2', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(50, '2020-04-29 23:07:19', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(51, '2020-04-29 23:07:23', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(52, '2020-04-29 23:43:02', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(53, '2020-04-29 23:43:36', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(54, '2020-04-29 23:44:20', '11', 'Muvekkil Ana Ekranına gitti...', 'SEKRETER'),
(55, '2020-04-29 23:57:46', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(56, '2020-04-30 00:46:23', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(57, '2020-04-30 00:49:40', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(58, '2020-04-30 00:57:33', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(59, '2020-04-30 00:58:05', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(60, '2020-04-30 01:01:47', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(61, '2020-04-30 01:19:40', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(62, '2020-04-30 01:25:35', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(63, '2020-04-30 01:36:28', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(64, '2020-04-30 01:50:09', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(65, '2020-04-30 02:03:24', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(66, '2020-04-30 02:06:07', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(67, '2020-04-30 02:10:26', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(68, '2020-04-30 02:17:57', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(69, '2020-04-30 02:19:58', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(70, '2020-04-30 02:22:01', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(71, '2020-04-30 02:40:34', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(72, '2020-04-30 02:41:53', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(73, '2020-04-30 02:43:40', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(74, '2020-04-30 02:54:03', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(75, '2020-04-30 03:03:37', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(76, '2020-04-30 03:18:54', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(77, '2020-04-30 03:20:38', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(78, '2020-04-30 03:21:12', '18', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(79, '2020-04-30 03:31:13', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(80, '2020-04-30 03:36:55', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(81, '2020-04-30 03:37:22', '12', 'Kullanici Ana Ekranina gitti...', 'SEKRETER'),
(82, '2020-04-30 03:38:14', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(83, '2020-04-30 03:40:05', '2', 'Avukat Ana Ekranina gitti...', 'AVUKAT'),
(84, '2020-04-30 03:40:14', '2', 'Raporlama Ana Ekranina gitti...', 'AVUKAT'),
(85, '2020-04-30 03:40:21', '2', 'Kullanici Ana Ekranina gitti...', 'AVUKAT'),
(86, '2020-04-30 03:48:47', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(87, '2020-04-30 04:05:58', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(88, '2020-04-30 04:07:32', '2', 'Avukat Ana Ekranina gitti...', 'AVUKAT'),
(89, '2020-04-30 04:08:48', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(90, '2020-05-01 00:59:14', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(91, '2020-05-01 01:00:14', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(92, '2020-05-01 01:00:25', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(93, '2020-05-01 01:01:04', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(94, '2020-05-01 01:01:27', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(95, '2020-05-01 01:01:31', '1', 'Yardim Ana Ekranina gitti...', 'YONETICI'),
(96, '2020-05-01 01:04:01', '1', 'Online Kullanim Hukukyardim.pdf Ekranina gitti...', 'YONETICI'),
(97, '2020-05-01 01:06:12', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(98, '2020-05-01 01:32:48', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(99, '2020-05-01 01:35:37', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(100, '2020-05-01 01:45:21', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(101, '2020-05-01 01:46:31', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(102, '2020-05-01 01:48:59', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(103, '2020-05-01 02:08:56', '11', 'Buro Bilgi Ana Ekranina gitti...', 'SEKRETER'),
(104, '2020-05-01 02:09:59', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(105, '2020-05-01 02:11:35', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(106, '2020-05-01 02:12:59', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(107, '2020-05-01 02:24:05', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(108, '2020-05-01 02:24:55', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(109, '2020-05-01 02:37:20', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(110, '2020-05-01 02:41:22', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(111, '2020-05-01 02:42:40', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(112, '2020-05-01 02:45:57', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(113, '2020-05-01 03:02:35', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(114, '2020-05-01 03:13:53', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(115, '2020-05-01 03:14:33', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(116, '2020-05-01 03:21:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(117, '2020-05-01 03:55:28', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(118, '2020-05-01 03:56:43', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(119, '2020-05-01 04:07:03', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(120, '2020-05-01 04:20:16', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(121, '2020-05-01 04:45:17', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(122, '2020-05-01 04:46:26', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(123, '2020-05-01 05:01:30', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(124, '2020-05-01 06:01:17', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(125, '2020-05-01 06:02:01', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(126, '2020-05-01 06:02:10', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(127, '2020-05-01 19:39:29', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(128, '2020-05-01 19:43:21', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(129, '2020-05-01 19:46:22', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(130, '2020-05-01 19:47:05', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(131, '2020-05-01 19:47:49', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(132, '2020-05-01 19:52:03', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(133, '2020-05-01 19:56:02', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(134, '2020-05-01 20:00:27', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(135, '2020-05-01 20:10:56', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(136, '2020-05-01 20:11:54', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(137, '2020-05-01 20:12:05', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(138, '2020-05-01 20:12:22', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(139, '2020-05-01 20:14:48', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(140, '2020-05-01 20:16:15', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(141, '2020-05-01 20:19:15', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(142, '2020-05-01 20:19:21', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(143, '2020-05-01 20:19:40', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(144, '2020-05-01 20:19:45', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(145, '2020-05-01 20:19:48', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(146, '2020-05-01 20:20:05', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(147, '2020-05-01 20:20:11', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(148, '2020-05-01 20:20:15', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(149, '2020-05-01 20:20:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(150, '2020-05-01 21:23:42', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(151, '2020-05-01 21:23:47', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(152, '2020-05-01 21:23:50', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(153, '2020-05-01 21:23:52', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(154, '2020-05-01 21:23:55', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(155, '2020-05-01 21:23:59', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(156, '2020-05-01 21:38:42', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(157, '2020-05-01 21:39:52', '2', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'AVUKAT'),
(158, '2020-05-01 21:57:15', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(159, '2020-05-01 21:57:19', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(160, '2020-05-01 21:57:27', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(161, '2020-05-01 21:57:32', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(162, '2020-05-01 21:57:36', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(163, '2020-05-01 21:57:38', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(164, '2020-05-01 21:57:42', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(165, '2020-05-01 21:57:45', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(166, '2020-05-01 21:59:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(167, '2020-05-01 22:34:28', '4', 'Muvekkil Ana Ekranına gitti...', 'AVUKAT'),
(168, '2020-05-01 23:32:52', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(169, '2020-05-01 23:33:05', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(170, '2020-05-01 23:46:23', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(171, '2020-05-01 23:53:29', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(172, '2020-05-01 23:59:24', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(173, '2020-05-02 00:00:23', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(174, '2020-05-02 00:01:45', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(175, '2020-05-02 00:01:52', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(176, '2020-05-02 00:16:44', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(177, '2020-05-02 00:32:06', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(178, '2020-05-02 00:32:10', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(179, '2020-05-02 00:32:12', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(180, '2020-05-02 00:32:14', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(181, '2020-05-02 00:34:25', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(182, '2020-05-02 00:34:32', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(183, '2020-05-02 00:44:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(184, '2020-05-02 00:44:20', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(185, '2020-05-02 00:44:22', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(186, '2020-05-02 01:33:08', '11', 'Muvekkil Ana Ekranına gitti...', 'SEKRETER'),
(187, '2020-05-02 01:33:15', '11', 'Muvekkil Ana Ekranına gitti...', 'SEKRETER'),
(188, '2020-05-02 01:33:20', '11', 'Muvekkil Ana Ekranına gitti...', 'SEKRETER'),
(189, '2020-05-02 01:33:22', '11', 'Muvekkil Ana Ekranına gitti...', 'SEKRETER'),
(190, '2020-05-02 01:36:54', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(191, '2020-05-02 01:37:00', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(192, '2020-05-02 01:37:02', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(193, '2020-05-02 01:38:55', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(194, '2020-05-02 01:39:24', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(195, '2020-05-02 01:40:34', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(196, '2020-05-02 01:42:19', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(197, '2020-05-02 01:42:22', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(198, '2020-05-02 01:42:25', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(199, '2020-05-02 01:43:57', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(200, '2020-05-02 01:44:02', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(201, '2020-05-02 01:44:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(202, '2020-05-02 01:44:25', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(203, '2020-05-02 01:49:39', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(204, '2020-05-02 01:49:47', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(205, '2020-05-02 02:11:49', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(206, '2020-05-02 02:12:00', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(207, '2020-05-02 02:13:10', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(208, '2020-05-02 02:13:15', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(209, '2020-05-02 02:25:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(210, '2020-05-02 02:28:15', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(211, '2020-05-02 02:28:18', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(212, '2020-05-02 02:28:30', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(213, '2020-05-02 02:47:37', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(214, '2020-05-02 02:47:42', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(215, '2020-05-02 02:47:45', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(216, '2020-05-02 02:47:50', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(217, '2020-05-02 02:47:53', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(218, '2020-05-02 02:53:45', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(219, '2020-05-02 03:01:14', '1', 'Online Kullanim Hukukyardim.pdf Ekranina gitti...', 'YONETICI'),
(220, '2020-05-02 03:01:32', '1', 'Online Kullanim Hukukyardim.pdf Ekranina gitti...', 'YONETICI'),
(221, '2020-05-02 03:01:52', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(222, '2020-05-02 03:05:43', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(223, '2020-05-02 03:07:28', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(224, '2020-05-02 03:07:32', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(225, '2020-05-02 03:07:34', '1', 'Online Kullanim Hukukyardim.pdf Ekranina gitti...', 'YONETICI'),
(226, '2020-05-02 03:07:53', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(227, '2020-05-02 03:16:10', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(228, '2020-05-02 03:16:19', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(229, '2020-05-02 03:17:43', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(230, '2020-05-02 03:18:21', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(231, '2020-05-02 03:50:12', '1', 'Kullanici Ana Ekranina gitti...', 'YONETICI'),
(232, '2020-05-02 03:51:45', 'Av.Mustafa', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(233, '2020-05-02 03:52:02', 'Av.Mustafa', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(234, '2020-05-02 18:27:21', 'admin', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(235, '2020-05-02 19:46:19', 'admin', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(236, '2020-05-02 19:47:38', 'admin', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(237, '2020-05-02 19:48:41', 'admin', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(238, '2020-05-02 20:21:58', 'admin', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(239, '2020-05-02 20:23:16', 'admin', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(240, '2020-05-02 20:30:51', 'admin', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(241, '2020-05-02 20:32:37', 'admin', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(242, '2020-05-02 20:33:20', 'admin', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI'),
(243, '2020-05-02 22:55:52', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(244, '2020-05-02 22:55:58', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(245, '2020-05-02 22:56:02', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(246, '2020-05-02 22:56:19', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(247, '2020-05-02 22:59:21', '1', 'Kullanici Log Yonetimi Ana Ekranina gitti...', 'YONETICI'),
(248, '2020-05-02 22:59:26', '1', 'Raporlama Ana Ekranina gitti...', 'YONETICI'),
(249, '2020-05-02 23:02:04', '1', 'Muvekkil Ana Ekranına gitti...', 'YONETICI'),
(250, '2020-05-02 23:02:08', '1', 'Personel Ana Ekranina gitti...', 'YONETICI'),
(251, '2020-05-02 23:02:12', '1', 'Buro Bilgi Ana Ekranina gitti...', 'YONETICI'),
(252, '2020-05-02 23:02:19', '1', 'Avukat Ana Ekranina gitti...', 'YONETICI'),
(253, '2020-05-02 23:02:41', '1', 'Hukuk Ajanda ve Hatirlatma Ana Ekranina gitti...', 'YONETICI');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hukukversionbilgi`
--

CREATE TABLE `hukukversionbilgi` (
  `versionid` int(11) NOT NULL,
  `versiondb` varchar(45) DEFAULT NULL,
  `versionuygulama` varchar(45) DEFAULT NULL,
  `versionadi` varchar(200) DEFAULT 'Hukuk Otomasyonu v '
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `hukukversionbilgi`
--

INSERT INTO `hukukversionbilgi` (`versionid`, `versiondb`, `versionuygulama`, `versionadi`) VALUES
(1, 'Db 01.04.20', 'App 01.04.20', 'Hukuk Otomasyonu v '),
(2, 'Db 02.04.20', 'App 02.04.20', 'Hukuk Otomasyonu v '),
(3, 'Db 11.04.20', 'App 11.04.20', 'Hukuk Otomasyonu v '),
(4, 'Db 15.04.20', 'App 15.04.20', 'Hukuk Otomasyonu v '),
(5, 'Db 16.04.20', 'App 16.04.20', 'Hukuk Otomasyonu v '),
(6, 'Db 20.04.20', 'App 20.04.20', 'Hukuk Otomasyonu v '),
(7, 'Db 22.04.20', 'App 22.04.20', 'Hukuk Otomasyonu v '),
(8, 'Db 28.04.20', 'App 28.04.20', 'Hukuk Otomasyonu v '),
(9, 'Db 30.04.20', 'App 30.04.20', 'Hukuk Otomasyonu v '),
(10, 'Db 01.05.20', 'App 01.05.20', 'Hukuk Burosu v '),
(11, 'Db 02.05.20', 'App 02.05.20', 'Hukuk Burosu v '),
(12, 'Db 03.05.20', 'App 03.05.20', 'Hukuk Burosu v ');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanicibilgi`
--

CREATE TABLE `kullanicibilgi` (
  `kadi` varchar(45) NOT NULL,
  `sifresi` varbinary(100) NOT NULL,
  `kaciklama` varchar(45) NOT NULL,
  `yetki` varchar(45) NOT NULL,
  `kullaniciid` int(11) NOT NULL,
  `sifrehatirlatmasoru` varchar(100) NOT NULL,
  `sifrehatirlatmacevap` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kullanicibilgi`
--

INSERT INTO `kullanicibilgi` (`kadi`, `sifresi`, `kaciklama`, `yetki`, `kullaniciid`, `sifrehatirlatmasoru`, `sifrehatirlatmacevap`) VALUES
('admin', 0x071106071d84c4f5cc9e3886a95705d9, 'admin', 'YONETICI', 1, 'admin', 'admin'),
('1', 0x212cf3cfb410317aeda27d22afc76a8f, 'Av. Zerrin CERKES', 'YONETICI', 2, '1', '1'),
('2', 0x5e40880a10e32c707929360f012e15ab, 'Av. Yilmaz OLMEZ', 'AVUKAT', 3, '2', '2'),
('3', 0x4dc9b3cdedda6be453ed3ac4709e5296, 'Av. Yunus MAZOOGLU', 'AVUKAT', 4, '3', '3'),
('4', 0xe2819bdd173a0cffe73397de68c85353, 'Av.  Sare OZKAN', 'AVUKAT', 5, '4', '4'),
('5', 0x185089b04209025a22e4f2e3c5d6bc1c, 'Av. Mustafa ALTUNDAG', 'AVUKAT', 6, '5', '5'),
('6', 0x94e05bc3a994210cdbe31e8874a371d4, 'Av. Salih BEY', 'AVUKAT', 7, '6', '6'),
('7', 0x4ce5a936f6c5668346e930c71ea3d50e, 'Av. Devrim HANIM', 'AVUKAT', 8, '7', '7'),
('8', 0xbc593e1f85cd69d59997de181227d4a7, 'Av. Beyza ATES', 'AVUKAT', 9, '8', '8'),
('9', 0xc0d29ad793b5ec88b7f6367b23c3ee11, 'Av. Muhammed BEY', 'AVUKAT', 10, '9', '9'),
('10', 0xdf1f31799caa8973e3a01b0f864e2e03, 'Av. Hasan HACISULEYMAN', 'AVUKAT', 11, '10', '10'),
('11', 0xefbd3a8ff93a3745574e2e476ae24af6, 'SEKRETER', 'SEKRETER', 22, '11', '11'),
('Av.Mustafa', 0x5abc31343c8e7d456d549ac44db8b53c, 'Av.Mustafa', 'YONETICI', 23, '12', '12');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkilbilgi`
--

CREATE TABLE `muvekkilbilgi` (
  `MuvekkilTC` varchar(20) NOT NULL,
  `MuvekkilAdi` varchar(20) DEFAULT NULL,
  `MuvekkilSoyadi` varchar(20) DEFAULT NULL,
  `MuvekkilDogumTarihi` date DEFAULT NULL,
  `MuvekkilDogumYeri` varchar(20) DEFAULT NULL,
  `MuvekkilTelefon` varchar(11) DEFAULT NULL,
  `MuvekkilBabaAdi` varchar(20) DEFAULT NULL,
  `MuvekkilAnaAdi` varchar(20) DEFAULT NULL,
  `MuvekkilCinsiyet` varchar(10) DEFAULT NULL,
  `MuvekkilVergiDairesi` varchar(50) DEFAULT NULL,
  `MuvekkilVergiNo` varchar(15) DEFAULT NULL,
  `MuvekkilAdres` varchar(100) DEFAULT NULL,
  `MuvekkilIl` varchar(20) DEFAULT NULL,
  `Muvekkililce` varchar(20) DEFAULT NULL,
  `MuvekkilAvukat` varchar(45) DEFAULT NULL,
  `Muvekkileposta` varchar(45) DEFAULT NULL,
  `Muvekkilaciklama` varchar(150) DEFAULT NULL,
  `SirketSSKIsYeriNo` varchar(20) DEFAULT NULL,
  `SirketUnvani` varchar(100) DEFAULT NULL,
  `hatirlat` date DEFAULT NULL,
  `Aciklama` varchar(250) DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkilbilgi`
--

INSERT INTO `muvekkilbilgi` (`MuvekkilTC`, `MuvekkilAdi`, `MuvekkilSoyadi`, `MuvekkilDogumTarihi`, `MuvekkilDogumYeri`, `MuvekkilTelefon`, `MuvekkilBabaAdi`, `MuvekkilAnaAdi`, `MuvekkilCinsiyet`, `MuvekkilVergiDairesi`, `MuvekkilVergiNo`, `MuvekkilAdres`, `MuvekkilIl`, `Muvekkililce`, `MuvekkilAvukat`, `Muvekkileposta`, `Muvekkilaciklama`, `SirketSSKIsYeriNo`, `SirketUnvani`, `hatirlat`, `Aciklama`, `hakedis`) VALUES
('4', 'AYSE', 'SOYAD', '2020-03-04', '', '33333333333', '', '', 'BAYAN', '', '', '', '', '', 'Av. Mustafa ALTUNDAG', '', '', '', '', NULL, NULL, '0.00'),
('5', 'AHMET ', 'SOYAD', '2020-05-05', '', '44444444444', '', '', 'BAYAN', '', '', '', '', '', 'Av. Zerrin CERKES', '', '', '', '', NULL, NULL, '0.00'),
('8', 'MEHMET', 'SOYAD', '2020-04-08', '', '55555555555', '', '', 'BAYAN', '', '', '', '', '', 'Av. Sare OZKAN', '', '', '', '', NULL, NULL, '0.00'),
('999', 'MAHMUT', 'SOYAD', '2020-04-21', 'ISTANBUL', '66666666666', 'Baba Adi', 'Ana Adi', 'BAYAN', 'Vergi Dairesi', '00000', 'Adres', 'ISTANBUL', 'MERKEZ', 'Av. Ilknur CELIK ', '', 'Aciklama', '00000', '', NULL, NULL, '0.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkilcarihareket`
--

CREATE TABLE `muvekkilcarihareket` (
  `Muvekkilcarihareketno` int(15) NOT NULL,
  `Muvekkilalacaktutar` decimal(10,2) DEFAULT 0.00,
  `Islemtarihi` date DEFAULT NULL,
  `Muvekkilborctutar` decimal(10,2) DEFAULT 0.00,
  `Aciklama` varchar(250) DEFAULT NULL,
  `MuvekkilTC` varchar(20) NOT NULL,
  `hatirlat` date DEFAULT NULL,
  `hakedis` decimal(10,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkilcarihareket`
--

INSERT INTO `muvekkilcarihareket` (`Muvekkilcarihareketno`, `Muvekkilalacaktutar`, `Islemtarihi`, `Muvekkilborctutar`, `Aciklama`, `MuvekkilTC`, `hatirlat`, `hakedis`) VALUES
(15, '0.00', '2020-04-19', '0.00', '4444', '4', '2020-04-19', '0.00'),
(16, '0.00', '2020-04-19', '0.00', '5555', '5', '2020-04-19', '0.00'),
(17, '88.00', '2020-04-20', '0.00', '888', '8', '2020-04-20', '0.00'),
(18, '55.00', '2020-04-20', '55.00', '555', '5', '2020-04-20', '0.00'),
(19, '444.00', '2020-04-20', '44.00', '444', '4', '2020-04-20', '0.00'),
(21, '334340.00', '2020-04-02', '34340.00', '3434', '999', '2020-04-21', '34340.00'),
(23, '1230.00', '2020-04-01', '1230.00', '123', '999', '2020-04-21', '23.00'),
(24, '0.00', '2020-04-22', '0.00', '123', '8', '2020-04-22', '123.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkildavahareket`
--

CREATE TABLE `muvekkildavahareket` (
  `DavaNo` int(15) NOT NULL,
  `DavaMahkemesi` varchar(100) DEFAULT 'Sulh Mahkemesi',
  `DosyaNo` int(15) DEFAULT NULL,
  `DavaAvukati` varchar(100) DEFAULT 'Sistem Avukati',
  `DavaKonusu` varchar(50) DEFAULT 'Sulh Ceza',
  `DavaTipi` varchar(50) DEFAULT 'Sulh Ceza',
  `DavaninAcilisTarihi` date DEFAULT NULL,
  `DurusmaTarihi` date DEFAULT NULL,
  `DurusmaSaati` varchar(45) DEFAULT NULL,
  `KararNeyeDair` varchar(50) DEFAULT 'Taraflarin Aciklamalarina',
  `KararTarihi` date DEFAULT NULL,
  `KararEsasNo` varchar(50) DEFAULT '00000',
  `KararTebligTarihi` date DEFAULT NULL,
  `TemyizTarihi` date DEFAULT NULL,
  `TemyizSonucu` varchar(100) DEFAULT 'Temyiz Durumu',
  `MuvekkilTC` varchar(20) NOT NULL,
  `Davasondurum` varchar(100) DEFAULT NULL,
  `Aciklama` varchar(250) DEFAULT 'Dava Son Durum Bilgisi',
  `hatirlat` date DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkildavahareket`
--

INSERT INTO `muvekkildavahareket` (`DavaNo`, `DavaMahkemesi`, `DosyaNo`, `DavaAvukati`, `DavaKonusu`, `DavaTipi`, `DavaninAcilisTarihi`, `DurusmaTarihi`, `DurusmaSaati`, `KararNeyeDair`, `KararTarihi`, `KararEsasNo`, `KararTebligTarihi`, `TemyizTarihi`, `TemyizSonucu`, `MuvekkilTC`, `Davasondurum`, `Aciklama`, `hatirlat`, `hakedis`) VALUES
(2, 'Sulh Ceza', 4444, '444', '4', '4', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '4444', '2020-04-20', '2020-04-20', '4', '4', 'ARA KARAR VERILDI', '4', '2020-04-20', '4444.00'),
(5, 'Sulh Ceza', 8, '8', '8', '8', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '8', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(6, 'Sulh Ceza', 81, '', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '8', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(7, 'Sulh Ceza', 82, '', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '8', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(8, 'Sulh Ceza', 41, '', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '4', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(9, 'Sulh Ceza', 42, '', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '4', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(10, 'Sulh Ceza', 51, '51', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '5', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(12, 'Sulh Ceza', 52222, '5222', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '5', 'ARA KARAR VERILDI', '', '2020-04-20', '52222.00'),
(13, 'Sulh Ceza', 81, '8181', '', '', '2020-04-20', '2020-04-20', '00:00', '', '2020-04-20', '00000', '2020-04-20', '2020-04-20', '', '8', 'ARA KARAR VERILDI', '', '2020-04-20', '0.00'),
(14, 'Sulh Ceza', 0, 'Av. Hasan HACISULEYMAN', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(15, 'Sulh Ceza', 0, 'Av. Sare OZKAN', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(16, 'Sulh Ceza', 0, 'Av. Mustafa ALTUNDAG', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '23442', '2020-04-21', '0.00'),
(17, 'Sulh Ceza', 0, 'Av. Yunus UZULMEZ', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(18, 'Sulh Ceza', 0, 'Av. Devrim GUNES', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(19, 'Sulh Ceza', 0, 'Av. Yilmaz OLMEZ', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(20, 'Sulh Ceza', 0, 'Av. Zerrin CERKES', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(21, 'Sulh Ceza', 0, 'Av. Muhammed BEYYUD', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(24, 'Sulh Ceza', 0, 'Av. Beyza ATES', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(25, 'Sulh Ceza', 0, 'Av. Salih OZTURK', '', '', '2020-04-21', '2020-04-21', '00:00', '', '2020-04-21', '00000', '2020-04-21', '2020-04-21', '', '999', 'ARA KARAR VERILDI', '', '2020-04-21', '0.00'),
(26, 'Sulh Ceza', 0, 'Av. Sare OZKAN', 'dededede', '', '2020-04-22', '2020-04-22', '00:00', '', '2020-04-22', '00000', '2020-04-22', '2020-04-22', '', '999', 'ARA KARAR VERILDI', '', '2020-04-22', '0.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkildavalibilgi`
--

CREATE TABLE `muvekkildavalibilgi` (
  `DavaliAdSoyad` varchar(60) DEFAULT NULL,
  `DavaliTelefon` varchar(11) DEFAULT '5320000000',
  `DavaliAdres` varchar(100) DEFAULT 'Davali Lokasyon bilgisi',
  `DavaliVekili` varchar(60) DEFAULT NULL,
  `MuvekkilTC` varchar(20) NOT NULL,
  `DavaliTC` varchar(20) NOT NULL,
  `Davaliaciklama` varchar(100) DEFAULT 'Davali Taraflar Bilgisi',
  `Davaliid` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkildavalibilgi`
--

INSERT INTO `muvekkildavalibilgi` (`DavaliAdSoyad`, `DavaliTelefon`, `DavaliAdres`, `DavaliVekili`, `MuvekkilTC`, `DavaliTC`, `Davaliaciklama`, `Davaliid`) VALUES
('81', '81', '81		', '', '8', '81', '', 5),
('82', '82', '82', '82', '8', '82', '', 6),
('81', '81', '81', '', '5', '81', '', 7),
('44', '44', '44', '44', '4', '44', '', 8),
('45', '45', '45', '45', '4', '45', '45', 9),
('3', '3', '3', '3', '999', '3', '3', 11);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkilhukukihareket`
--

CREATE TABLE `muvekkilhukukihareket` (
  `HareketNo` int(15) NOT NULL,
  `HareketTarihi` date DEFAULT NULL,
  `HareketNotlari` varchar(250) DEFAULT 'Notlar',
  `HareketAciklamasi` varchar(100) DEFAULT 'Aciklamalar',
  `IcraTakipTarihi` date DEFAULT NULL,
  `HareketAvukati` varchar(100) DEFAULT 'Sistem Avukati',
  `HareketTipi` varchar(100) DEFAULT 'Icra,Dilekce,Talep,Itiraz islemi',
  `MuvekkilTC` varchar(20) NOT NULL,
  `IcraDairesi` varchar(100) DEFAULT 'Icra Dairesi',
  `IcraMemuru` varchar(100) DEFAULT 'Icra Memuru',
  `IcraTalepTutari` decimal(10,2) DEFAULT 0.00,
  `IcraTahsiledilentutar` decimal(10,2) DEFAULT 0.00,
  `Aciklama` varchar(250) DEFAULT 'Aciklamasi',
  `hatirlat` date DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkilhukukihareket`
--

INSERT INTO `muvekkilhukukihareket` (`HareketNo`, `HareketTarihi`, `HareketNotlari`, `HareketAciklamasi`, `IcraTakipTarihi`, `HareketAvukati`, `HareketTipi`, `MuvekkilTC`, `IcraDairesi`, `IcraMemuru`, `IcraTalepTutari`, `IcraTahsiledilentutar`, `Aciklama`, `hatirlat`, `hakedis`) VALUES
(1, '2020-04-02', '88d', '88d', '2020-04-03', '88', '88', '8', '88', '88', '88.00', '88.00', '88d', '2020-04-04', '35345345.00'),
(2, '2020-04-01', '', '', '2020-04-15', '82', '', '8', '82', '', '121212.00', '121212.00', '', '2020-04-15', '234234.00'),
(3, '2020-04-15', '5', '5', '2020-04-21', '5', '5', '5', '5', '5', '5.00', '5.00', '5', '2020-04-16', '0.00'),
(5, '2020-04-19', '', '', '2020-04-19', '', '', '8', '', '', '0.00', '0.00', '', '2020-04-19', '0.00'),
(8, '2020-04-19', '444', 'Talep', '2020-04-19', '', 'Icra , Dilekce , Talep vs', '4', 'Icra Dairesi', '', '0.00', '0.00', 'Icra', '2020-04-19', '0.00'),
(9, '2020-04-20', '', 'Talep', '2020-04-20', '888', 'Icra , Dilekce , Talep vs', '8', 'Icra Dairesi', '', '0.00', '0.00', 'Icra', '2020-04-20', '0.00'),
(10, '2020-04-01', '', 'Talep', '2020-04-21', 'Av. Hasan HACISULEYMAN', 'Icra , Dilekce , Talep vs', '999', 'Icra Dairesi', '', '0.00', '0.00', 'Icra', '2020-04-21', '0.00'),
(11, '2020-04-21', '', 'Talep', '2020-04-21', 'Av. Hasan HACISULEYMAN', 'dedede', '999', 'Icra Dairesi', '', '0.00', '0.00', 'Icra', '2020-04-21', '0.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `muvekkilozelhareket`
--

CREATE TABLE `muvekkilozelhareket` (
  `OzelHareketID` int(11) NOT NULL,
  `Ozelharekettarihi` date DEFAULT NULL,
  `KonusulanKisi` varchar(100) DEFAULT 'Muvekkil Bilgisi',
  `KonusanAvukat` varchar(100) DEFAULT 'Sistem Avukati',
  `Aciklama` varchar(250) DEFAULT 'Alinan bilgiler',
  `MuvekkilTC` varchar(20) NOT NULL,
  `hatirlat` date DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `muvekkilozelhareket`
--

INSERT INTO `muvekkilozelhareket` (`OzelHareketID`, `Ozelharekettarihi`, `KonusulanKisi`, `KonusanAvukat`, `Aciklama`, `MuvekkilTC`, `hatirlat`, `hakedis`) VALUES
(2, '2020-04-05', '5', '5', '5', '5', '2020-04-05', '55555.00'),
(4, '2020-04-09', '822', '822', '822', '8', '2020-04-09', '82222.00'),
(5, '2020-04-20', '444', '444', '444', '4', '2020-04-20', '44440.00'),
(6, '2020-04-02', 'aa', 'Av. Sare OZKAN', 'aa', '999', '2020-04-02', '0.00'),
(7, '2020-05-28', 'bbb', 'Av. Sare OZKAN', 'bbbb', '999', '2020-05-01', '0.00'),
(8, '2020-05-15', 'ccc', 'Av. Sare OZKAN', 'cccc', '999', '2020-05-01', '0.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personelbilgi`
--

CREATE TABLE `personelbilgi` (
  `PersonelTC` varchar(20) NOT NULL,
  `PersonelAdSoyad` varchar(60) DEFAULT 'Personel',
  `PersonelMaasNET` decimal(10,2) DEFAULT 0.00,
  `PersonelTelefon` varchar(11) DEFAULT '5320000000',
  `PersonelTipi` varchar(20) DEFAULT 'AVUKAT',
  `PersonelEposta` varchar(100) DEFAULT NULL,
  `PersonelKayitTarihi` date DEFAULT NULL,
  `Personelid` int(11) NOT NULL,
  `hatirlat` date DEFAULT NULL,
  `Aciklama` varchar(250) DEFAULT NULL,
  `hakedis` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `personelbilgi`
--

INSERT INTO `personelbilgi` (`PersonelTC`, `PersonelAdSoyad`, `PersonelMaasNET`, `PersonelTelefon`, `PersonelTipi`, `PersonelEposta`, `PersonelKayitTarihi`, `Personelid`, `hatirlat`, `Aciklama`, `hakedis`) VALUES
('33333333333', 'ZERRIN CERKES', '9999.00', '', 'YONETICI', '', '2020-04-01', 26, NULL, NULL, '0.00'),
('44444444444', 'YUNUS MAZOOGLU', '9999.00', '', 'YONETICI', '', '2020-04-01', 27, NULL, NULL, '0.00'),
('55555555555', 'SARE OZKAN', '88888.00', '', 'AVUKAT', '', '2020-04-03', 28, NULL, NULL, '0.00'),
('66666666666', 'BUTUN DEVELOPER EKIBIMIZ', '111.00', '', 'AVUKAT', '', '2020-04-01', 29, NULL, NULL, '0.00'),
('77777777777', 'DONE ATES', '8888.00', '', 'AVUKAT', '', '2020-04-01', 30, NULL, NULL, '0.00'),
('88888888888', 'DEVRIM GUNES', '9999.00', '', 'AVUKAT', '', '2020-04-01', 31, NULL, NULL, '0.00'),
('11111111111', 'YILMAZ OLMEZ', '9999.00', '', 'YONETICI', '', '2020-04-01', 33, NULL, NULL, '0.00'),
('99999999998', 'MUHAMMED BEYYUD', '9999.00', '', 'AVUKAT', '', '2020-04-01', 35, NULL, NULL, '0.00'),
('99999999997', 'HASAN HACISULEYMAN', '9999.00', '', 'AVUKAT', '', '2020-04-01', 37, NULL, NULL, '0.00'),
('22222222222', 'MEHMET SALIH OZTURK', '8888.00', '', 'AVUKAT', '', '2020-04-01', 38, NULL, NULL, '0.00'),
('99999999999', 'MUSTAFA ALTUNDAG', '1.00', '', 'AVUKAT', '', '2020-04-01', 39, NULL, NULL, '0.00');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `avukatbilgi`
--
ALTER TABLE `avukatbilgi`
  ADD PRIMARY KEY (`AvukatTC`);

--
-- Tablo için indeksler `burobilgi`
--
ALTER TABLE `burobilgi`
  ADD PRIMARY KEY (`BuroID`);

--
-- Tablo için indeksler `hukukajanda`
--
ALTER TABLE `hukukajanda`
  ADD PRIMARY KEY (`islemid`);

--
-- Tablo için indeksler `hukukburosulog`
--
ALTER TABLE `hukukburosulog`
  ADD PRIMARY KEY (`logid`);

--
-- Tablo için indeksler `hukuklogislem`
--
ALTER TABLE `hukuklogislem`
  ADD PRIMARY KEY (`islemid`);

--
-- Tablo için indeksler `hukukversionbilgi`
--
ALTER TABLE `hukukversionbilgi`
  ADD PRIMARY KEY (`versionid`);

--
-- Tablo için indeksler `kullanicibilgi`
--
ALTER TABLE `kullanicibilgi`
  ADD PRIMARY KEY (`kullaniciid`),
  ADD UNIQUE KEY `kadi` (`kadi`);

--
-- Tablo için indeksler `muvekkilbilgi`
--
ALTER TABLE `muvekkilbilgi`
  ADD PRIMARY KEY (`MuvekkilTC`);

--
-- Tablo için indeksler `muvekkilcarihareket`
--
ALTER TABLE `muvekkilcarihareket`
  ADD PRIMARY KEY (`Muvekkilcarihareketno`) USING BTREE,
  ADD KEY `MuvekkilTC` (`MuvekkilTC`) USING BTREE;

--
-- Tablo için indeksler `muvekkildavahareket`
--
ALTER TABLE `muvekkildavahareket`
  ADD PRIMARY KEY (`DavaNo`),
  ADD KEY `MuvekkilTC` (`MuvekkilTC`) USING BTREE;

--
-- Tablo için indeksler `muvekkildavalibilgi`
--
ALTER TABLE `muvekkildavalibilgi`
  ADD PRIMARY KEY (`Davaliid`),
  ADD KEY `MuvekkilTC` (`MuvekkilTC`) USING BTREE;

--
-- Tablo için indeksler `muvekkilhukukihareket`
--
ALTER TABLE `muvekkilhukukihareket`
  ADD PRIMARY KEY (`HareketNo`) USING BTREE,
  ADD KEY `MuvekkilTC` (`MuvekkilTC`) USING BTREE;

--
-- Tablo için indeksler `muvekkilozelhareket`
--
ALTER TABLE `muvekkilozelhareket`
  ADD PRIMARY KEY (`OzelHareketID`),
  ADD KEY `MuvekkilTC` (`MuvekkilTC`);

--
-- Tablo için indeksler `personelbilgi`
--
ALTER TABLE `personelbilgi`
  ADD PRIMARY KEY (`Personelid`) USING BTREE,
  ADD UNIQUE KEY `PersonelTC_2` (`PersonelTC`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `burobilgi`
--
ALTER TABLE `burobilgi`
  MODIFY `BuroID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `hukukajanda`
--
ALTER TABLE `hukukajanda`
  MODIFY `islemid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Tablo için AUTO_INCREMENT değeri `hukukburosulog`
--
ALTER TABLE `hukukburosulog`
  MODIFY `logid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;

--
-- Tablo için AUTO_INCREMENT değeri `hukuklogislem`
--
ALTER TABLE `hukuklogislem`
  MODIFY `islemid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- Tablo için AUTO_INCREMENT değeri `hukukversionbilgi`
--
ALTER TABLE `hukukversionbilgi`
  MODIFY `versionid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `kullanicibilgi`
--
ALTER TABLE `kullanicibilgi`
  MODIFY `kullaniciid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Tablo için AUTO_INCREMENT değeri `muvekkilcarihareket`
--
ALTER TABLE `muvekkilcarihareket`
  MODIFY `Muvekkilcarihareketno` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Tablo için AUTO_INCREMENT değeri `muvekkildavahareket`
--
ALTER TABLE `muvekkildavahareket`
  MODIFY `DavaNo` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Tablo için AUTO_INCREMENT değeri `muvekkildavalibilgi`
--
ALTER TABLE `muvekkildavalibilgi`
  MODIFY `Davaliid` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `muvekkilhukukihareket`
--
ALTER TABLE `muvekkilhukukihareket`
  MODIFY `HareketNo` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `muvekkilozelhareket`
--
ALTER TABLE `muvekkilozelhareket`
  MODIFY `OzelHareketID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `personelbilgi`
--
ALTER TABLE `personelbilgi`
  MODIFY `Personelid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `muvekkilcarihareket`
--
ALTER TABLE `muvekkilcarihareket`
  ADD CONSTRAINT `muvekkilcarihareket_ibfk_1` FOREIGN KEY (`MuvekkilTC`) REFERENCES `muvekkilbilgi` (`MuvekkilTC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `muvekkildavahareket`
--
ALTER TABLE `muvekkildavahareket`
  ADD CONSTRAINT `muvekkildavahareket_ibfk_1` FOREIGN KEY (`MuvekkilTC`) REFERENCES `muvekkilbilgi` (`MuvekkilTC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `muvekkildavalibilgi`
--
ALTER TABLE `muvekkildavalibilgi`
  ADD CONSTRAINT `muvekkildavalibilgi_ibfk_1` FOREIGN KEY (`MuvekkilTC`) REFERENCES `muvekkilbilgi` (`MuvekkilTC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `muvekkilhukukihareket`
--
ALTER TABLE `muvekkilhukukihareket`
  ADD CONSTRAINT `muvekkilhukukihareket_ibfk_1` FOREIGN KEY (`MuvekkilTC`) REFERENCES `muvekkilbilgi` (`MuvekkilTC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `muvekkilozelhareket`
--
ALTER TABLE `muvekkilozelhareket`
  ADD CONSTRAINT `muvekkilozelhareket_ibfk_1` FOREIGN KEY (`MuvekkilTC`) REFERENCES `muvekkilbilgi` (`MuvekkilTC`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
