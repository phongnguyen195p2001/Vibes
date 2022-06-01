-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2020 at 04:00 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eproject1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `mail` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `idbrand` int(11) NOT NULL,
  `imagebr` varchar(500) NOT NULL,
  `namebrand` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`idbrand`, `imagebr`, `namebrand`) VALUES
(6, 'rolex.png', 'Rolex'),
(7, 'omega.png', 'Omega'),
(8, 'casio.png', 'Casio'),
(9, 'hublot.png', 'Hublot');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL,
  `namecategory` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`idcategory`, `namecategory`) VALUES
(1, 'Sport'),
(2, 'Classic'),
(3, 'Men'),
(4, 'Women');

-- --------------------------------------------------------

--
-- Table structure for table `tblcontact`
--

CREATE TABLE `tblcontact` (
  `idcontact` int(11) NOT NULL,
  `user_name` varchar(150) NOT NULL,
  `user_email` varchar(150) NOT NULL,
  `content` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `watchs`
--

CREATE TABLE `watchs` (
  `idwatchs` int(11) NOT NULL,
  `image` varchar(500) NOT NULL,
  `namewatchs` varchar(150) NOT NULL,
  `price` int(11) NOT NULL,
  `code` varchar(150) NOT NULL,
  `descriptions` mediumtext NOT NULL,
  `idbrand` int(11) DEFAULT NULL,
  `idcategory` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `watchs`
--

INSERT INTO `watchs` (`idwatchs`, `image`, `namewatchs`, `price`, `code`, `descriptions`, `idbrand`, `idcategory`) VALUES
(16, 'L2.628.5.38.7.webp', 'LONGINES L2.628.5.38.7', 3100, 'L2.628.5.38.7', '<p>Thương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; Watchmaking Tradition<br />\r\nBộ sưu tập:&nbsp; &nbsp; The Longines Master Collection<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sĩ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Classic/ Phong c&aacute;ch Lịch l&atilde;m<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; &nbsp;Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 38.50 x 38.50mm<br />\r\nĐộ d&agrave;y:&nbsp; &nbsp; 10.00mm<br />\r\nChất liệu vỏ:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L/ Bọc v&agrave;ng 18k&nbsp;<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L/ Bọc v&agrave;ng 18k&nbsp;<br />\r\nChất liệu k&iacute;nh:&nbsp; &nbsp; Sapphire/ Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số:&nbsp; &nbsp; Mặt m&agrave;u v&agrave;ng, Đ&iacute;nh kim cương<br />\r\nThiết kế đ&aacute;y:&nbsp; &nbsp; Đ&aacute;y lộ m&aacute;y, nắp cậy<br />\r\nChi tiết kh&oacute;a d&acirc;y:&nbsp; &nbsp; Kh&oacute;a liền c&oacute; n&uacute;t bấm<br />\r\nChức năng:&nbsp; &nbsp; 3 kim, lịch ng&agrave;y<br />\r\nĐộ chịu nước:&nbsp; &nbsp; 3 bar (30 m)<br />\r\nTrọng lượng (bao gồm phụ kiện):&nbsp; &nbsp; 1.50 KG<br />\r\nBảo h&agrave;nh Quốc Tế:&nbsp; &nbsp; 2 năm</p>\r\n', 6, 2),
(17, 'L2.919.4.92.6.webp', 'LONGINES L2.919.4.92.6', 2300, 'L2.919.4.92.6', '<p>M&atilde; sản phẩm:&nbsp; &nbsp; L2.919.4.92.6<br />\r\nThương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; Watchmaking Tradition<br />\r\nBộ sưu tập:&nbsp; &nbsp; The Longines Master Collection<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sĩ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Classic/ Phong c&aacute;ch thanh lịch<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; &nbsp;Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 41.00 x 41.00mm<br />\r\nChất liệu vỏ:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu k&iacute;nh:&nbsp; &nbsp; Sapphire/Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số:&nbsp; &nbsp; Mặt xanh, số vạch<br />\r\nChức năng:&nbsp; &nbsp; 3 kim, xem giờ<br />\r\nĐộ chịu nước:&nbsp; &nbsp; 3 bar (30m)<br />\r\nTrọng lượng (bao gồm phụ kiện):&nbsp; &nbsp;1.5kg<br />\r\nBảo h&agrave;nh Quốc Tế:&nbsp; &nbsp; 2 năm</p>\r\n', 6, 2),
(18, 'L2.909.4.78.6.webp', 'LONGINES L2.909.4.78.6', 2300, 'L2.909.4.78.6', '<p>Thương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; Watchmaking Tradition<br />\r\nBộ sưu tập:&nbsp; &nbsp; The Longines Master Collection-Retrograte<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sỹ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Classic/ Phong c&aacute;ch Lịch l&atilde;m<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; &nbsp;Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 40.00 x 40.00mm<br />\r\nChất liệu vỏ:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp;Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu k&iacute;nh:&nbsp; Sapphire/ Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số:&nbsp; &nbsp; Mặt m&agrave;u ghi, số học tr&ograve;<br />\r\nChức năng:&nbsp; &nbsp; 3 kim xem giờ<br />\r\nĐộ chịu nước :&nbsp; &nbsp;3 bar (30m)<br />\r\nTrọng lượng (bao gồm phụ kiện):&nbsp; &nbsp; 1.50 KG<br />\r\nBảo h&agrave;nh Quốc Tế:&nbsp; &nbsp; 2 năm</p>\r\n', 6, 1),
(19, 'L2.909.4.51.6.webp', 'LONGINES L2.909.4.51.6', 2300, 'L2.909.4.51.6', '<p>Thương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; Watchmaking Tradition<br />\r\nBộ sưu tập:&nbsp; &nbsp; The Longines Master Collection-Retrograte<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sỹ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Sport/ Phong c&aacute;ch Lịch l&atilde;m<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; &nbsp;Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 40.00 x 40.00mm<br />\r\nChất liệu vỏ :&nbsp; &nbsp;Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu k&iacute;nh:&nbsp; &nbsp; Sapphire/ Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số:&nbsp; &nbsp; Mặt m&agrave;u đen, số la m&atilde;<br />\r\nChức năng:&nbsp; &nbsp; 3 kim xem giờ<br />\r\nĐộ chịu nước:&nbsp; &nbsp; 3 bar (30m)<br />\r\nTrọng lượng (bao gồm phụ kiện):&nbsp; &nbsp; 1.50 KG<br />\r\nBảo h&agrave;nh Quốc Tế:&nbsp; &nbsp; 2 năm</p>\r\n', 6, 1),
(20, 'L2.909.4.51.7.webp', 'LONGINES L2.909.4.51.7', 2000, 'L2.909.4.51.7', '<p>Thương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; Watchmaking Tradition<br />\r\nBộ sưu tập:&nbsp; &nbsp;The Longines Master Collection-Retrograte<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sỹ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Classic/ Phong c&aacute;ch Lịch l&atilde;m<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; &nbsp;Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 40.00 x 40.00mm<br />\r\nChất liệu vỏ :&nbsp; &nbsp;Th&eacute;p kh&ocirc;ng gỉ 316L<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp; Da c&aacute; sấu cao cấp<br />\r\nChất liệu k&iacute;nh:&nbsp; &nbsp;Sapphire/ Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số :&nbsp; &nbsp;Mặt m&agrave;u đen, số la m&atilde;<br />\r\nChức năng:&nbsp; &nbsp; 3 kim xem giờ<br />\r\nĐộ chịu nước:&nbsp; &nbsp; 3 bar (30m)<br />\r\nTrọng lượng (bao gồm phụ kiện):&nbsp; &nbsp; 1.50 KG<br />\r\nBảo h&agrave;nh Quốc Tế :&nbsp; &nbsp;2 năm</p>\r\n', 6, 3),
(21, 'L2.755.5.37.7.webp', 'LONGINES L2.755.5.37.7', 3350, 'L2.755.5.37.7', '<p>Thương hiệu:&nbsp; &nbsp; Longines<br />\r\nD&ograve;ng sản phẩm:&nbsp; &nbsp; WATCHMAKING TRADITION<br />\r\nBộ sưu tập:&nbsp; &nbsp; The Longines Master Collection<br />\r\nXuất xứ:&nbsp; &nbsp; Thụy Sĩ<br />\r\nPhong c&aacute;ch:&nbsp; &nbsp; Sport/ Phong c&aacute;ch Lịch l&atilde;m<br />\r\nGiới t&iacute;nh:&nbsp; &nbsp; Nam<br />\r\nKiểu m&aacute;y:&nbsp; &nbsp; &nbsp;Automatic/ M&aacute;y tự động l&ecirc;n d&acirc;y c&oacute;t<br />\r\nKiểu d&aacute;ng:&nbsp; &nbsp; Tr&ograve;n<br />\r\nK&iacute;ch cỡ:&nbsp; &nbsp; 38.50 x 38.50 mm<br />\r\nĐộ d&agrave;y:&nbsp; &nbsp; 9.50 mm<br />\r\nChất liệu vỏ:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L/ Mạ v&agrave;ng PVD<br />\r\nChất liệu d&acirc;y:&nbsp; &nbsp; Th&eacute;p kh&ocirc;ng gỉ 316L/ Mạ v&agrave;ng PVD<br />\r\nChất liệu k&iacute;nh:&nbsp; &nbsp; Sapphire/ Ch&ocirc;́ng tr&acirc;̀y xước<br />\r\nThiết kế mặt số:&nbsp; &nbsp; Mặt m&agrave;u v&agrave;ng, đ&iacute;nh kim cương<br />\r\nChức năng:&nbsp; &nbsp; 3 kim, lịch ng&agrave;y<br />\r\nĐộ chịu nước:&nbsp; &nbsp; 3 bar (30 m)<br />\r\nTrọng lượng (bao gồm phụ kiện) :&nbsp; &nbsp;1.50 KG<br />\r\nBảo h&agrave;nh Quốc Tế :&nbsp; &nbsp;2 năm</p>\r\n', 6, 1),
(22, 'timthumb.jpg', 'TIMTHUMB', 5000, 'RL 91', '<p>Mẫu vỏ<br />\r\n&nbsp; &nbsp; Oyster, 40 mm, v&agrave;ng Everose v&agrave; kim cương<br />\r\n&nbsp; &nbsp; Kiến tr&uacute;c Oyster<br />\r\n&nbsp; &nbsp; Vỏ ch&iacute;nh Monobloc, n&uacute;t vặn nắp lưng v&agrave; n&uacute;t chỉnh l&ecirc;n d&acirc;y<br />\r\n&nbsp; &nbsp; Đường k&iacute;nh<br />\r\n&nbsp; &nbsp; 40 mm<br />\r\n&nbsp; &nbsp; Chất liệu<br />\r\n&nbsp; &nbsp; V&agrave;ng Everose 18 ct với tai đồng hồ nạm kim cương<br />\r\n&nbsp; &nbsp; V&agrave;nh đồng hồ<br />\r\n&nbsp; &nbsp; Chất liệu v&agrave;ng Everose 18 ct kết hợp với 36 vi&ecirc;n ngọc b&iacute;ch h&igrave;nh baguette m&agrave;u cầu vồng<br />\r\n&nbsp; &nbsp; N&uacute;m vặn<br />\r\n&nbsp; &nbsp; Xoắn v&iacute;t, hệ thống chống thấm nước 3 tầng Triplock<br />\r\n&nbsp; &nbsp; Mặt đồng hồ<br />\r\n&nbsp; &nbsp; Ngọc b&iacute;ch chống trầy xước<br />\r\n&nbsp; &nbsp; Chống chịu nước<br />\r\n&nbsp; &nbsp; Khả năng chống thấm nước l&ecirc;n đến mức 100m/330 feet</p>\r\n\r\n<p>Bộ chuyển động<br />\r\n&nbsp; &nbsp; Bộ chuyển động<br />\r\n&nbsp; &nbsp; Perpetual, bộ m&aacute;y cơ đếm giờ, tự l&ecirc;n d&acirc;y<br />\r\n&nbsp; &nbsp; Calibre<br />\r\n&nbsp; &nbsp; 4130, Nh&agrave; sản xuất Rolex<br />\r\n&nbsp; &nbsp; Độ ch&iacute;nh x&aacute;c<br />\r\n&nbsp; &nbsp; -2/+2 gi&acirc;y/ng&agrave;y, sau khi lắp đặt ho&agrave;n chỉnh<br />\r\n&nbsp; &nbsp; Chức năng<br />\r\n&nbsp; &nbsp; Kim giờ, kim ph&uacute;t, kim gi&acirc;y ch&iacute;nh, kim gi&acirc;y nhỏ tại điểm 6 giờ. Bộ đếm giờ ( kim ch&iacute;nh) c&oacute; độ ch&iacute;nh x&aacute;c trong khoảng 1/8 gi&acirc;y, đếm 30 ph&uacute;t tại điểm 3 giờ v&agrave; đếm 12 giờ tại điểm 9 giờ. Cơ chế ngừng chỉnh đề điều chỉnh thời gian ch&iacute;nh x&aacute;c<br />\r\n&nbsp; &nbsp; Bộ dao động<br />\r\n&nbsp; &nbsp; D&acirc;y t&oacute;c xanh Parachrom thuận từ<br />\r\n&nbsp; &nbsp; Sự l&ecirc;n d&acirc;y<br />\r\n&nbsp; &nbsp; Tự l&ecirc;n d&acirc;y c&oacute;t 2 chiều qua Perpetual rotor<br />\r\n&nbsp; &nbsp; Dự trữ năng lượng<br />\r\n&nbsp; &nbsp; Xấp xỉ 72 tiếng</p>\r\n\r\n<p>D&acirc;y đeo<br />\r\n&nbsp; &nbsp; D&acirc;y đeo<br />\r\n&nbsp; &nbsp; Oyster, mối nối 3 mảnh dạng phẳng<br />\r\n&nbsp; &nbsp; Chất liệu d&acirc;y đeo<br />\r\n&nbsp; &nbsp; V&agrave;ng Everose 18 ct<br />\r\n&nbsp; &nbsp; Kh&oacute;a<br />\r\n&nbsp; &nbsp; Kh&oacute;a gập an to&agrave;n Oysterlock với mối nối gi&atilde;n Easylink 5mm tiện dụng</p>\r\n\r\n<p>Mặt số<br />\r\n&nbsp; &nbsp; Mặt số<br />\r\n&nbsp; &nbsp; Bộ pha l&ecirc; đen v&agrave; v&agrave;ng với ngọc b&iacute;ch<br />\r\n&nbsp; &nbsp; Bộ chạm ngọc<br />\r\n&nbsp; &nbsp; 11 vi&ecirc;n ngọc b&iacute;ch dạng baguette, sắc cầu vồng</p>\r\n', 6, 4),
(23, '14670814_23243596_480.webp', 'Rolex Daytona Rainbow', 3000, 'RL1', '<p>Điểm nổi bật:<br />\r\n- Vỏ 40mm quay số m&agrave;u đen. Vỏ th&eacute;p kh&ocirc;ng gỉ vương miện đẩy xuống v&ograve;ng đeo tay li&ecirc;n kết th&eacute;p kh&ocirc;ng gỉ chốt triển khai Dự trữ năng lượng 72 giờ chỉ số kim cương viền sapphire cầu vồng (6.48ct) khung bezel khắc .<br />\r\n- Mục n&agrave;y đi k&egrave;m với một hộp v&agrave; giấy tờ.<br />\r\nĐồng hồ n&agrave;y l&agrave; đồng hồ cũ đ&atilde; được MAD t&ugrave;y chỉnh, kh&ocirc;ng phải l&agrave; đại l&yacute; ủy quyền của nh&agrave; sản xuất ban đầu. Bảo đảm ban đầu của nh&agrave; sản xuất kh&ocirc;ng c&ograve;n hiệu lực v&agrave; c&aacute;c đặc t&iacute;nh kỹ thuật ban đầu c&oacute; thể đ&atilde; thay đổi v&agrave; một số bộ phận c&oacute; thể đ&atilde; được thay thế.<br />\r\n&nbsp;</p>\r\n', 6, 4),
(24, 'dong-ho-nam-omega-de-ville-43163412102001-hour-vision-vang-hong-18k-1.jpg', 'Omega De Ville', 9500, '43163412102001', '<p>T&igrave;nh trạng: H&agrave;ng new 100% Fullbox, Cam kết tất cả c&aacute;c chi tiết đều zin nguy&ecirc;n bản từ nh&agrave; sản xuất Omega Thụy sĩ.<br />\r\nVỏ: V&agrave;ng hồng đ&uacute;c 18k, Niềng: V&agrave;ng hồng đ&uacute;c 18k, Đ&aacute;y: V&agrave;ng hồng đ&uacute;c 18k<br />\r\nCơ chế m&aacute;y: Automatic M&aacute;y Omega 8501 chuẩn Chronometer.<br />\r\nD&acirc;y: Da c&aacute; sấu zin Omega, kh&oacute;a đ&ocirc;i v&agrave;ng hồng đ&uacute;c 18k zin Omega<br />\r\nMặt k&iacute;nh: Shapphire cong chống phản chiếu<br />\r\nMặt đồng hồ: Mặt m&agrave;u trắng hai l&ograve;ng, lịch ng&agrave;y<br />\r\nK&iacute;ch thước mặt: 41 mm, độ d&agrave;y 11,8 mm (Từ đ&aacute;y l&ecirc;n mặt k&iacute;nh)<br />\r\nĐồng hồ chịu nước 10 ATM<br />\r\nPhong c&aacute;ch : Lịch sự sang trọng đẳng cấp VIP<br />\r\nBảo h&agrave;nh kỹ thuật 02 năm</p>\r\n', 7, 3),
(25, 'dong-ho-omega-deville-46338033-gmt-vang-khoi-18k-size-38-7mm-1.jpg', 'Omega Deville Prestige', 5500, '46142002', '<p>Đồng hồ Omega Deville Prestige 46142002 v&agrave;ng hồng đ&uacute;c 18k full box hộp sổ thẻ ch&iacute;nh h&atilde;ng Thụy Sỹ.<br />\r\nT&igrave;nh trạng: H&agrave;ng đ&atilde; qua sử dụng mới 98%. Nguy&ecirc;n zin 100% ch&iacute;nh h&atilde;ng Omega, đồng hồ c&ograve;n hộp sổ v&agrave; 3 thẻ của h&atilde;ng<br />\r\nVỏ: V&agrave;ng hồng nguy&ecirc;n khối 18k, Niềng: V&agrave;ng hồng 18k, Đ&aacute;y: V&agrave;ng hồng nguy&ecirc;n khối 18k<br />\r\nCơ chế m&aacute;y: Automatic Calibre 2202<br />\r\nD&acirc;y: da b&ograve;, kh&oacute;a c&agrave;i Omega v&agrave;ng hồng 18k<br />\r\nMặt k&iacute;nh: Shapphire chống trầy xước<br />\r\nMặt đồng hồ: Mặt m&agrave;u trắng sứ cọc số la m&atilde;, kim rốn .<br />\r\nK&iacute;ch thước mặt: 39 mm .<br />\r\nĐồng hồ chịu nước 3 ATM<br />\r\nPhong c&aacute;ch: Lịch sự sang trọng classic<br />\r\nBảo h&agrave;nh kỹ thuật 01 năm, hỗ trợ bảo dưỡng trọn đời</p>\r\n', 7, 2),
(26, 'dong-ho-omega-constellation-vintage-bat-quai-rang-ca-map-ruong-bac-thang-7.jpg', 'Omega Constellation Vintage', 7400, 'om1', '<p>T&igrave;nh trạng : H&agrave;ng xưa sx thập ni&ecirc;n 60 nhưng độ mới cao, đẹp xuất sắc.<br />\r\nVỏ: Vỏ v&agrave;ng hồng đ&uacute;c 18k, Niềng: v&agrave;ng hồng đ&uacute;c 18k, Đ&aacute;y: Đ&agrave;i thi&ecirc;n văn v&agrave;ng hồng đ&uacute;c 18k<br />\r\nCơ chế m&aacute;y: Automatic<br />\r\nD&acirc;y: Da cao cấp, kh&oacute;a Omega<br />\r\nMặt k&iacute;nh: K&iacute;nh mika<br />\r\nMặt đồng hồ: Mặt b&aacute;t qu&aacute;i mặt số cọc mũi t&ecirc;n ruộng bậc thang<br />\r\nK&iacute;ch thước mặt: 34,5mm, Độ d&agrave;y 11mm (Từ đ&aacute;y l&ecirc;n mặt k&iacute;nh)<br />\r\nĐồng hồ kh&ocirc;ng chịu nước<br />\r\nPhong c&aacute;ch: Lịch sự sang trọng đẳng cấp classic<br />\r\nBảo h&agrave;nh kỹ thuật 1 năm</p>\r\n', 7, 2),
(27, 'dong-ho-nu-omega-1591-71-00-constellation-size-275mm-chinh-hang-thuy-sy-2.jpg', 'Omega 1591.71.00 Constellation', 1500, '1591.71.00', '<p>T&igrave;nh trạng: H&agrave;ng đ&atilde; qua sử dụng c&ograve;n mới 98%, chỉ c&ograve;n đồng hồ<br />\r\nVỏ: Th&eacute;p kh&ocirc;ng gỉ, Niềng: Th&eacute;p kh&ocirc;ng gỉ, Đ&aacute;y: Th&eacute;p kh&ocirc;ng gi đ&agrave;i thi&ecirc;n văn<br />\r\nCơ chế m&aacute;y: Automatic Calibre Omega 2520, trữ c&oacute;t 42h<br />\r\nD&acirc;y: Th&eacute;p kh&ocirc;ng gỉ<br />\r\nMặt k&iacute;nh: Shapphire<br />\r\nMặt đồng hồ: x&agrave; cừ trắng MOP, lịch ng&agrave;y<br />\r\nK&iacute;ch thước mặt: 27,5 mm<br />\r\nĐồng hồ chịu nước 3 bar (30 metres / 100 feet)<br />\r\nBảo h&agrave;nh kỹ thuật 01 năm</p>\r\n', 7, 4),
(28, 'dong-ho-omega-seamaster-aqua-terra-150m-co-axial-chronograph-44mm-231-23-44-50-06-001-6.jpg', 'Omega Seamaster Aqua Terra 150M Co-Axial Chronograph', 5000, '231.23.44.50.06.001', '<p>✔️: T&igrave;nh trạng: H&agrave;ng đ&atilde; qua sử dụng c&ograve;n rất mới 98% . Chỉ c&ograve;n đồng hồ<br />\r\n✔️: Vỏ: Th&eacute;p kh&ocirc;ng gỉ, Niềng: V&agrave;ng 18k, Đ&aacute;y: Th&eacute;p kh&ocirc;ng gỉ lộ m&aacute;y<br />\r\n✔️: Cơ chế m&aacute;y: Automatic Co-Axial Caliber 3313<br />\r\n✔️: D&acirc;y: da cao cấp, kho&aacute; bấm Omega zin<br />\r\n✔️: Mặt k&iacute;nh: Shapphire chống trầy xước<br />\r\n✔️: Mặt đồng hồ: M&agrave;u x&aacute;m, cọc số dạ quang, Chronograph, lịch ng&agrave;y<br />\r\n✔️: K&iacute;ch thước mặt: 44 mm<br />\r\n✔️: Đồng hồ chịu nước 150 Meters/500 Feet Water-Resistant<br />\r\n✔️: Phong c&aacute;ch: Lịch sự sang trọng đẳng cấp<br />\r\n✔️: Bảo h&agrave;nh kỹ thuật 02 năm<br />\r\nMặt k&iacute;nh: Shapphire chống trầy xước<br />\r\nMặt đồng hồ: M&agrave;u đen kẻ, lịch ng&agrave;y<br />\r\nK&iacute;ch thước mặt: 41,5 mm<br />\r\nĐồng hồ chịu nước 150m<br />\r\nPhong c&aacute;ch: Lịch sự sang trọng đẳng cấp<br />\r\nBảo h&agrave;nh kỹ thuật 02 năm</p>\r\n', 7, 1),
(29, 'dong-ho-omega-23120422108001-aqua-terra-master-co-axial-2.jpg', 'Omega Seamaster Aqua Terra', 5000, '231.23.44.50.06.001', '<p>✔️: T&igrave;nh trạng: H&agrave;ng đ&atilde; qua sử dụng c&ograve;n rất mới 98% . Chỉ c&ograve;n đồng hồ<br />\r\n✔️: Vỏ: Th&eacute;p kh&ocirc;ng gỉ, Niềng: V&agrave;ng 18k, Đ&aacute;y: Th&eacute;p kh&ocirc;ng gỉ lộ m&aacute;y<br />\r\n✔️: Cơ chế m&aacute;y: Automatic Co-Axial Caliber 3313<br />\r\n✔️: D&acirc;y: da cao cấp, kho&aacute; bấm Omega zin<br />\r\n✔️: Mặt k&iacute;nh: Shapphire chống trầy xước<br />\r\n✔️: Mặt đồng hồ: M&agrave;u x&aacute;m, cọc số dạ quang, Chronograph, lịch ng&agrave;y<br />\r\n✔️: K&iacute;ch thước mặt: 44 mm<br />\r\n✔️: Đồng hồ chịu nước 150 Meters/500 Feet Water-Resistant<br />\r\n✔️: Phong c&aacute;ch: Lịch sự sang trọng đẳng cấp<br />\r\n✔️: Bảo h&agrave;nh kỹ thuật 02 năm</p>\r\n', 7, 1),
(30, 'cropped-dong-ho-omega-de-ville-6.jpg', 'Omega De Ville Prestige Co-Axial', 4500, '4614.50.01', '<p>✔ T&igrave;nh trạng: H&agrave;ng đ&atilde; qua sử dụng mới 99%. Nguy&ecirc;n zin 100% ch&iacute;nh h&atilde;ng Omega, đồng hồ c&ograve;n hộp sổ.<br />\r\n✔ Vỏ: V&agrave;ng hồng nguy&ecirc;n khối 18k, Niềng: V&agrave;ng hồng 18k, Đ&aacute;y: V&agrave;ng hồng nguy&ecirc;n khối 18k<br />\r\n✔ Cơ chế m&aacute;y: Automatic Calibre 2202<br />\r\n✔ D&acirc;y: C&aacute; sấu cao cấp Omega, kh&oacute;a c&agrave;i Omega v&agrave;ng hồng 18k<br />\r\n✔ Mặt k&iacute;nh: Shapphire chống trầy xước<br />\r\n✔ Mặt đồng hồ: Mặt m&agrave;u đen cọc số la m&atilde;, kim rốn .<br />\r\n✔ K&iacute;ch thước mặt: 39 mm .<br />\r\n✔ Đồng hồ chịu nước 3 ATM<br />\r\n✔ Phong c&aacute;ch: Lịch sự sang trọng classic<br />\r\n✔ Bảo h&agrave;nh kỹ thuật 01 năm</p>\r\n', 7, 2),
(31, 'la680wa-7df-0.png', 'Casio LA680WA-7DF', 700, 'LA680WA-7DF', '<p>Th&ocirc;ng số kỹ thuật Đồng hồ Casio LA680WA-7DF:<br />\r\n&bull; Chống nước<br />\r\n&bull; Thiết kế retro được ưa th&iacute;ch<br />\r\n&bull; tươi biến thể m&agrave;u sắc mới<br />\r\n&bull; B&aacute;o động<br />\r\nNhựa thủy tinh<br />\r\nChống nước<br />\r\nLiệu trường hợp / bezel: Nhựa / Chrome mạ<br />\r\nTh&eacute;p kh&ocirc;ng gỉ nhạc<br />\r\nClasp điều chỉnh<br />\r\n1/10-second đồng hồ bấm giờ<br />\r\nkhả năng đo: 59&#39;59&#39;&#39; 0,9<br />\r\nThời gian đ&atilde; qua: Chế độ đo<br />\r\nĐồng hồ đếm ngược<br />\r\n30 ph&uacute;t: phạm vi đếm ngược<br />\r\nthời gian bắt đầu đếm ngược đặt trước: 1, 3, 5, 10, 15, 20, 30 ph&uacute;t<br />\r\nB&aacute;o h&agrave;ng ng&agrave;y<br />\r\nT&iacute;n hiệu thời gian theo giờ<br />\r\nAuto-lịch (28 ng&agrave;y cho th&aacute;ng hai)<br />\r\nTh&ocirc;ng tin cơ bản: giờ, ph&uacute;t, gi&acirc;y, chiều, th&aacute;ng, ng&agrave;y, th&aacute;ng, ng&agrave;y<br />\r\nĐộ ch&iacute;nh x&aacute;c: &plusmn; 30 gi&acirc;y mỗi th&aacute;ng<br />\r\nXấp xỉ. Tuổi thọ pin: 2 năm tr&ecirc;n CR1216<br />\r\nK&iacute;ch thước của trường hợp:&ensp;&nbsp;30,3 &times;&ensp;&nbsp;24,6 &times;&ensp;&nbsp;7,3 mm<br />\r\nTổng trọng lượng: 32 g<br />\r\n&nbsp;</p>\r\n', 8, 2),
(32, 'BA-110BE-7ADR 600X600.jpg', 'CASIO BABY-G', 500, 'BA-110BE-7ADR', '<p>Đồng hồ nữ BA-110BE-7ADR với mặt k&iacute;nh kho&aacute;ng, d&acirc;y đeo v&agrave; vỏ đều được l&agrave;m từ nhựa. Tạo cảm gi&aacute;c thoải m&aacute;i khi đeo.</p>\r\n\r\n<p>M&ocirc; tả sản phẩm<br />\r\nCasio thương hiệu đồng hồ nổi tiếng với nhiều kiểu d&aacute;ng, mẫu m&atilde; đồng hồ cho cả nam v&agrave; nữ.<br />\r\nĐối với đồng hồ nữ Casio đ&atilde; ưu &aacute;i cho ph&aacute;i đẹp của ch&uacute;ng ta ri&ecirc;ng một d&ograve;ng đồng hồ ri&ecirc;ng biệt đ&oacute; ch&iacute;nh l&agrave; Casio Baby-G.<br />\r\nCasio Baby-G d&ograve;ng đồng hồ mạnh mẽ v&agrave; đ&aacute;ng y&ecirc;u bởi sự kết hợp tinh tế giữa c&aacute;c chức năng với c&aacute;c phong c&aacute;ch thời trang trẻ trung, năng động.</p>\r\n\r\n<p>Nằm trong &ldquo;d&ograve;ng họ&rdquo; Baby G BA 110, Casio BA-110BE-7ADR đ&atilde; thể hiện r&otilde; được phong c&aacute;ch trẻ trung, năng động của m&igrave;nh.<br />\r\nĐồng hồ Casio nữ BA-110BE-7ADR chiếc đồng hồ được thiết kế chỉ để d&agrave;nh ri&ecirc;ng cho ph&aacute;i đẹp</p>\r\n\r\n<p>BA-110BE-7ADR THIẾT KẾ VỚI VẺ NGO&Agrave;I CUỐN H&Uacute;T</p>\r\n\r\n<p>D&acirc;y đeo v&agrave; vỏ: D&acirc;y đeo v&agrave; vỏ của đồng hồ đều được l&agrave;m từ nhựa.; Bởi vậy m&agrave; chiếc đồng hồ khi đeo c&oacute; cảm gi&aacute;c rất nhẹ.</p>\r\n\r\n<p>Mặt k&iacute;nh: Mặt k&iacute;nh của đồng hồ l&agrave; mặt k&iacute;nh kho&aacute;ng. Một loại k&iacute;nh cứng c&oacute; khả năng chống va đập tốt nhưng chống xước chưa được tốt lắm.</p>\r\n\r\n<p>K&iacute;ch thước c&aacute;c chiều: 46,3&times;43,4&times;15,8mm. Một k&iacute;ch thước kh&aacute; vừa vặn cho một chiếc đồng hồ nữ.</p>\r\n\r\n<p>Trọng lượng: Bởi vỏ v&agrave; d&acirc;y đeo của đồng hồ đều được l&agrave;m từ nhựa n&ecirc;n trọng lượng của chiếc đồng hồ n&agrave;y kh&aacute; nhẹ chỉ l&ecirc;n đến 45g.</p>\r\n\r\n<p>N&uacute;t bấm: c&aacute;c n&uacute;t bấm được thiết kế chắc chắn, kh&ocirc;ng lỏng lẻo tiện lợi, dễ d&agrave;ng cho việc điều chỉnh c&aacute;c chức năng của một chiếc</p>\r\n\r\n<p>BA-110BE-7ADR VỚI NHIỀU T&Iacute;NH NĂNG NỔI BẬT</p>\r\n\r\n<p>Khả năng chống nước: khả năng chống nước l&ecirc;n đến 100M, kh&aacute; thoải m&aacute;i cho việc đi mưa hay tham gia c&aacute;c hoạt động thể thao dưới nước như bơi lội m&agrave; chẳng sợ đồng hồ bị v&agrave;o nước.</p>\r\n\r\n<p>Tuổi thọ pin: chỉ ỏ mức xấp xỉ 2 năm với pin SR726W &times; 2.</p>\r\n\r\n<p>Hệ thống đ&egrave;n LED</p>\r\n\r\n<p>Đồng hồ nữ BA-110BE-7ADR với đa dạng c&aacute;c t&iacute;nh năng chủ yếu l&agrave; xoay quanh thời gian như:</p>\r\n\r\n<p>Giờ Thế Giới: 29 m&uacute;i giờ (48 th&agrave;nh phố + giờ phối hợp quốc tế), hiển thị m&atilde; th&agrave;nh phố, bật/tắt tiết kiệm &aacute;nh s&aacute;ng ban ng&agrave;y</p>\r\n\r\n<p>Đồng hồ bấm giời: &nbsp;1/100 gi&acirc;y<br />\r\nKhả năng đo: 23:59&#39;59.99&#39;&#39;<br />\r\nChế độ đo: Thời gian đ&atilde; tr&ocirc;i qua, ngắt giờ, thời gian về đ&iacute;ch thứ nhất-thứ hai</p>\r\n\r\n<p>Đ&ocirc;̀ng h&ocirc;̀ đ&ecirc;́m ngược<br />\r\nĐơn vị đo: 1 gi&acirc;y<br />\r\nKhoảng đếm ngược: 24 giờ<br />\r\nKhoảng c&agrave;i đặt thời gian bắt đầu đếm ngược: 1 ph&uacute;t đến 24 giờ (khoảng tăng 1 ph&uacute;t v&agrave; khoảng tăng 1 giờ)</p>\r\n\r\n<p>5 chế độ b&aacute;o giờ h&agrave;ng ng&agrave;y (với 1 chế độ b&aacute;o lặp)<br />\r\n&nbsp;</p>\r\n', 8, 1),
(33, 'DW-5900-1-000.jpg', 'Casio G Shock', 200, 'DW-5900-1DR', '<p>Đồng hồ Nam Casio G Shock DW-5900-1DR D&acirc;y Nhựa M&agrave;u Đen - Đ&egrave;n Nền EL, chống sốc, tuổi thọ pin 5 năm, K&iacute;ch thước (H &times; W &times; D): 51,4 &times; 46,8 &times; 15,5 mm</p>\r\n\r\n<p>M&ocirc; tả sản phẩm<br />\r\nMẫu đồng hồ Casio G Shock DW-5900-1DR nằm trong bộ sưu tập đồng hồ mới nhất được cho ra mắt tại Nhật Bản mới đ&acirc;y. Mang phong c&aacute;ch mạnh mẽ v&agrave; đầy nam t&iacute;nh đang tạo n&ecirc;n cơn sốt tr&ecirc;n to&agrave;n Ch&acirc;u &Aacute;. Chiếc đồng hồ n&agrave;y l&agrave; một sự lựa chọn th&ocirc;ng minh d&agrave;nh cho những qu&yacute; &ocirc;ng hay đi phượt, ưa th&iacute;ch phưu lưu, thể thao.</p>\r\n\r\n<p>Kể từ khi ra đời v&agrave;o năm 1983, G-SHOCK, theo đuổi sự dẻo dai v&agrave; ph&aacute;t triển, kỷ niệm sinh nhật lần thứ 35 của m&igrave;nh v&agrave;o năm 2018. Để tưởng nhớ n&oacute;, để xem x&eacute;t lại nguồn gốc &quot;căn bản&quot; chủ đề đến DW-5900 dường như đ&atilde; l&agrave;m sống lại qu&aacute; khứ của t&ecirc;n m&aacute;y với d&ograve;ng điện.&nbsp;</p>\r\n\r\n<p>Th&ocirc;ng số kỹ thuật:<br />\r\nChất liệu: Nhựa<br />\r\nBăng nhựa<br />\r\nCấu tr&uacute;c t&aacute;c động (Chống sốc)<br />\r\nK&iacute;nh v&ocirc; cơ<br />\r\n20 ATM khả năng chịu nước<br />\r\nGiờ thế giới: Hiển thị thời gian của 48 th&agrave;nh phố (29 m&uacute;i giờ) tr&ecirc;n thế giới, với chức năng c&agrave;i đặt thời gian m&ugrave;a h&egrave;<br />\r\nĐồng hồ bấm giờ (1/100 gi&acirc;y, tổng cộng 60 ph&uacute;t, c&oacute; chia nhỏ)<br />\r\nBộ hẹn giờ (bộ đơn vị: 1 ph&uacute;t, bộ tối đa: 24 giờ, được đo theo gia số 1 gi&acirc;y)<br />\r\nThời gian b&aacute;o động 5 chiếc (chỉ với 1 chức năng b&aacute;o lại)<br />\r\nTo&agrave;n bộ lịch tự động<br />\r\n12/24 giờ chuyển đổi hiển thị<br />\r\nChức năng chuyển đổi ON / OFF &acirc;m thanh hoạt động<br />\r\nĐ&egrave;n nền EL (với chức năng ph&aacute;t s&aacute;ng, thời gian chuyển đổi sau khi ph&aacute;t s&aacute;ng (1,5 gi&acirc;y / 3 gi&acirc;y) được đ&iacute;nh k&egrave;m)<br />\r\nĐộ ch&iacute;nh x&aacute;c: ch&ecirc;nh lệch trung b&igrave;nh h&agrave;ng th&aacute;ng &plusmn; 15 gi&acirc;y<br />\r\nTuổi thọ pin: khoảng 5 năm<br />\r\nK&iacute;ch thước (H &times; W &times; D): 51,4 &times; 46,8 &times; 15,5 mm<br />\r\nTrọng lượng: 60 g<br />\r\n&nbsp;</p>\r\n', 8, 1),
(34, 'GBD-100-1DR-00.jpg', 'Casio G Shock 2', 500, 'GBD-100-1DR', '<p>M&ocirc; tả sản phẩm<br />\r\nĐồng Hồ Casio G Shock GBD-100-1DR d&agrave;nh cho Nam, D&acirc;y Nhựa M&agrave;u Đen, Kết Nối Điện Thoại Th&ocirc;ng Minh, Theo d&otilde;i được dữ liệu luyện tập h&agrave;ng ng&agrave;y, K&iacute;ch thước vỏ : 58,2&times;49,3&times;17mm nằm trong bộ sưu tập đồng hồ Casio G Shock G-SQUAD mang đến nhiều t&iacute;nh năng hiện đại hơn gi&uacute;p phục vụ c&aacute;ch tốt nhất cho qu&aacute; tr&igrave;nh tập luyện thể thao d&agrave;nh cho nam.</p>\r\n\r\n<p>Đ&acirc;y l&agrave; c&aacute;c sản phẩm mới nhất trong d&ograve;ng đồng hồ thể thao G-SQUAD của G-SHOCK, hiện đ&atilde; c&oacute; t&iacute;nh năng Bluetooth&reg; cho ph&eacute;p kết nối li&ecirc;n tục với điện thoại th&ocirc;ng minh.</p>\r\n\r\n<p><br />\r\nTh&ocirc;ng số kỹ thuật</p>\r\n\r\n<p>Chất liệu vỏ / khung bezel: Nhựa / Nh&ocirc;m<br />\r\nD&acirc;y đeo bằng nhựa<br />\r\nCấu tr&uacute;c chống sốc (chống sốc)<br />\r\nMặt k&iacute;nh kho&aacute;ng<br />\r\n20 ATM chống nước<br />\r\nChức năng li&ecirc;n kết di động (chức năng lồng v&agrave;o nhau với điện thoại di động tương th&iacute;ch th&ocirc;ng qua giao tiếp Bluetooth&reg;)<br />\r\nChức năng đ&agrave;o tạo (t&iacute;nh to&aacute;n v&agrave; hiển thị khoảng c&aacute;ch, tốc độ, tốc độ, v.v. bằng GPS hoặc cảm biến gia tốc của điện thoại di động), chức năng tự động / thủ c&ocirc;ng, chức năng tạm dừng tự động, chức năng c&agrave;i đặt cảnh b&aacute;o th&ocirc;ng b&aacute;o đến (thời gian, mức ti&ecirc;u thụ calo), chức năng t&ugrave;y chỉnh hiển thị đ&agrave;o tạo<br />\r\nDữ liệu nhật k&yacute; đ&agrave;o tạo (tối đa 100 lần chạy, mỗi lần tối đa 140 v&ograve;ng), thời gian đo, khoảng c&aacute;ch, tốc độ, lượng calo được đốt ch&aacute;y<br />\r\nChức năng đếm bước (phạm vi hiển thị bước: 0 đến 99.999 bước), đặt lại số bước (đặt lại tự động v&agrave;o nửa đ&ecirc;m mỗi ng&agrave;y)<br />\r\nGiờ thế giới: 38 th&agrave;nh phố tr&ecirc;n khắp thế giới (38 m&uacute;i giờ * , với chức năng c&agrave;i đặt thời gian m&ugrave;a h&egrave; tự động) + Hiển thị thời gian UTC (Giờ phối hợp quốc tế)<br />\r\n* C&oacute; thể được cập nhật khi kết nối với điện thoại di động.<br />\r\nĐồng hồ bấm giờ (1 gi&acirc;y, tổng cộng 100 giờ, c&oacute; ph&acirc;n chia)<br />\r\nHẹn giờ: Hẹn giờ để đo khoảng thời gian c&oacute; thể thiết lập tối đa 5 lần (đơn vị đặt: 1 gi&acirc;y, đặt tối đa: 60 ph&uacute;t, đo theo đơn vị 1 gi&acirc;y, tự động lặp lại, tự động bắt đầu)<br />\r\n4 b&aacute;o thức thời gian (c&oacute; chức năng b&aacute;o lại)<br />\r\nLịch ho&agrave;n to&agrave;n tự động<br />\r\nChuyển đổi hiển thị 12/24 giờ<br />\r\nChức năng chuyển đổi &acirc;m thanh BẬT / TẮT<br />\r\nĐ&egrave;n nền LED (c&oacute; đ&egrave;n tự động, đ&egrave;n si&ecirc;u s&aacute;ng, chức năng ph&aacute;t s&aacute;ng, chuyển đổi thời gian ph&aacute;t s&aacute;ng (1,5 gi&acirc;y / 3 gi&acirc;y))<br />\r\nChức năng rung<br />\r\nĐộ ch&iacute;nh x&aacute;c: Ch&ecirc;nh lệch trung b&igrave;nh h&agrave;ng th&aacute;ng &plusmn; 15 gi&acirc;y<br />\r\nTuổi thọ pin: khoảng 2 năm<br />\r\n* Nếu bạn kh&ocirc;ng li&ecirc;n kết với điện thoại th&ocirc;ng minh, n&oacute; sẽ hoạt động với độ ch&iacute;nh x&aacute;c thạch anh b&igrave;nh thường (ch&ecirc;nh lệch trung b&igrave;nh h&agrave;ng th&aacute;ng &plusmn; 15 gi&acirc;y).<br />\r\nK&iacute;ch thước (H &times; W &times; D): 58,2 &times; 49,3 &times; 17mm<br />\r\nKhối lượng: 69g<br />\r\n&nbsp;</p>\r\n', 8, 3),
(35, 'AE-1200WH-1BVDF-00.jpg', 'CASIO AE-1200WH-1BVDF', 100, 'AE-1200WH-1BVDF', '<p>Đồng hồ Casio Standard AE-1200WH-1BVDF thuộc d&ograve;ng đồng hồ nam standard với tuổi thọ sử dụng pin l&ecirc;n đến 10 năm ch&iacute;nh v&igrave; chất lượng sản phẩm cực k&igrave; tốt l&ecirc;n casio lu&ocirc;n l&agrave; h&atilde;ng đồng được y&ecirc;u th&iacute;ch nhất tr&ecirc;n thị trường</p>\r\n\r\n<p>M&ocirc; tả sản phẩm<br />\r\nĐồng hồ Casio Standard AE-1200WH-1BVDF Ch&iacute;nh h&atilde;ng l&agrave; d&ograve;ng đồng hồ c&oacute; tuổi thọ pin k&eacute;o d&agrave;i 10 năm, khả năng chống nước 100 m&eacute;t. Thiết kế d&acirc;y đeo c&ugrave;ng với mặt đồng hồ vu&ocirc;ng với đầy đủ c&aacute;c t&iacute;nh năng ưu việt v&agrave; tiện &iacute;ch kh&aacute;c ở tr&ecirc;n m&agrave;n h&igrave;nh mang lại sự thoải m&aacute;i v&agrave; phong c&aacute;ch thể thao mạnh mẽ rất ph&ugrave; hợp đối với những bạn nam năng động v&agrave; mạnh mẽ.</p>\r\n\r\n<p>Th&ocirc;ng số kỹ thuật Đồng hồ Casio:<br />\r\nVật liệu vỏ / gờ: Nhựa</p>\r\n\r\n<p>D&acirc;y đeo bằng nhựa</p>\r\n\r\n<p>Mặt k&iacute;nh nhựa</p>\r\n\r\n<p>Khả năng chống nước ở độ s&acirc;u 100 m&eacute;t</p>\r\n\r\n<p>Đ&egrave;n LED<br />\r\nThời lượng chiếu s&aacute;ng c&oacute; thể lựa chọn, ph&aacute;t s&aacute;ng sau</p>\r\n\r\n<p>Nhiều m&uacute;i giờ (4 th&agrave;nh phố kh&aacute;c nhau)</p>\r\n\r\n<p>Giờ thế giới<br />\r\n31 m&uacute;i giờ (48 th&agrave;nh phố + giờ phối hợp quốc tế), bật/tắt tiết kiệm &aacute;nh s&aacute;ng ban ng&agrave;y, chuyển đổi th&agrave;nh phố Giờ chuẩn/Giờ thế giới</p>\r\n\r\n<p>Đồng hồ bấm giờ 1/100 gi&acirc;y<br />\r\nKhả năng đo: 23:59&#39;59,99&#39;&#39;<br />\r\nChế độ đo: Thời gian đ&atilde; tr&ocirc;i qua, ngắt giờ, thời gian về đ&iacute;ch thứ nhất-thứ hai</p>\r\n\r\n<p>Đồng hồ đếm ngược<br />\r\nĐơn vị đo: 1/10 gi&acirc;y<br />\r\nKhoảng nhập: 1 gi&acirc;y đến 24 giờ (khoảng tăng 1 gi&acirc;y, khoảng tăng 1 ph&uacute;t v&agrave; khoảng tăng 1 giờ)</p>\r\n\r\n<p>5 chế độ b&aacute;o h&agrave;ng ng&agrave;y hoặc một lần</p>\r\n\r\n<p>T&iacute;n hiệu thời gian h&agrave;ng giờ</p>\r\n\r\n<p>Lịch ho&agrave;n to&agrave;n tự động (đến năm 2099)</p>\r\n\r\n<p>Định dạng giờ 12/24</p>\r\n\r\n<p>Bật/tắt &acirc;m nhấn n&uacute;t</p>\r\n\r\n<p>Giờ hiện h&agrave;nh th&ocirc;ng thường: Giờ, ph&uacute;t, gi&acirc;y, chiều, th&aacute;ng, ng&agrave;y, thứ</p>\r\n\r\n<p>Độ ch&iacute;nh x&aacute;c: &plusmn;30 gi&acirc;y một th&aacute;ng</p>\r\n\r\n<p>Tuổi thọ pin xấp xỉ: 10 năm với pin CR2025</p>\r\n\r\n<p>K&iacute;ch thước vỏ : 45&times;42,1&times;12,5mm</p>\r\n\r\n<p>Tổng trọng lượng : 39g</p>\r\n', 8, 2),
(36, 'hublot-classic-fusion-581-nx-7170-lr-quarz-33mm.jpg', 'HUBLOT CLASSIC FUSION', 5000, '84751', '<p>TH&Ocirc;NG TIN CHI TIẾT<br />\r\nVỏ titan được đ&aacute;nh b&oacute;ng với c&aacute;c li&ecirc;n kết trung t&acirc;m tr&ecirc;n &amp; dưới ho&agrave;n th&agrave;nh chải giữa c&aacute;c vấu.<br />\r\nViền titan với mặt tr&ecirc;n được chải ho&agrave;n thiện &amp; cạnh v&aacute;t ho&agrave;n thiện được đ&aacute;nh b&oacute;ng, được bảo đảm bằng 6 ốc v&iacute;t titan kiểu chữ H được đ&aacute;nh b&oacute;ng.<br />\r\nVương miện titan được đ&aacute;nh b&oacute;ng khắc logo Hublot.<br />\r\nNhựa composite m&agrave;u xanh &quot;bezel lug&quot; kẹp giữa khung v&agrave; vỏ.<br />\r\nMặt số m&agrave;u xanh.<br />\r\n&Aacute;p dụng đ&aacute;nh dấu chỉ số giờ th&eacute;p kh&ocirc;ng gỉ.<br />\r\nĐ&aacute;nh b&oacute;ng xong tay inox.<br />\r\nCửa sổ ng&agrave;y nằm ở vị tr&iacute; 3 giờ.<br />\r\nHublot Quartz / Pin chạy bằng pin HUB2912, gồm 38 phần.<br />\r\nVỏ h&igrave;nh &nbsp;tr&ograve;n<br />\r\nK&iacute;ch thước &nbsp;vỏ 33mm<br />\r\nChất liệu &nbsp;vỏ Titan<br />\r\nQuay số m&agrave;u &nbsp;xanh<br />\r\nPha l&ecirc; &nbsp;Sapphire chống trầy xước<br />\r\nViền &nbsp;cố định<br />\r\nV&iacute;t-in Crown &nbsp;No<br />\r\nChống nước &nbsp;50m / 150ft<br />\r\nCase Back &nbsp;Solid<br />\r\nChất liệu ban nhạc &nbsp;Alligator / Da c&aacute; sấu<br />\r\nM&agrave;u / Kết th&uacute;c &nbsp;m&agrave;u xanh<br />\r\nClasp &nbsp;Đẩy N&uacute;t Folding Clasp<br />\r\nPhong tr&agrave;o &nbsp;thạch anh</p>\r\n', 9, 2),
(37, 'spirit-of-big-bang-641-om-0183-lr-ceramic-42.jpg', 'HUBLOT BIG BANG ', 21000, '94015', '<p>TH&Ocirc;NG TIN CHI TIẾT<br />\r\nVỏ<br />\r\nTham khảo 441up7320nrgit20<br />\r\nĐường k&iacute;nh 42 Mm<br />\r\nVỏ bọc bằng nh&ocirc;m Anodized hồng l&acirc;u năm được ho&agrave;n thiện v&agrave; đ&aacute;nh b&oacute;ng<br />\r\nBezel Satin-Ho&agrave;n th&agrave;nh v&agrave; đ&aacute;nh b&oacute;ng nh&ocirc;m Anodized Mill Years Pink<br />\r\nChống nước 100m hoặc 10 Atm<br />\r\nCrystal Sapphire với điều trị chống phản xạ<br />\r\nQuay số Mat Mill Years Pink Skeleton<br />\r\nPhong tr&agrave;o<br />\r\nMovement Hub1280 Unico Sản xuất Chronograph Flying tự cuộn d&acirc;y với b&aacute;nh xe cột<br />\r\nDự trữ năng lượng 72 giờ<br />\r\nD&acirc;y đeo &amp; clasp<br />\r\nD&acirc;y đeo Velcro D&acirc;y đeo trong Mill ng&agrave;n hồng đan, kh&acirc;u hồng ng&agrave;n năm<br />\r\nKh&oacute;a thể thao clasp bằng nh&ocirc;m mạ v&agrave;ng ng&agrave;n năm được đ&aacute;nh b&oacute;ng, được khắc logo &quot;Hublot&quot; được lấp đầy bằng sơn m&agrave;i trắng<br />\r\n&nbsp;</p>\r\n', 9, 2),
(38, 'hublot-classic-fusion-581-nx-7071-lr-quartz-33mm.jpg', 'HUBLOT CLASSIC FUSION 1', 10000, '86550', '<p>TH&Ocirc;NG TIN CHI TIẾT<br />\r\nĐồng hồ n&agrave;y c&oacute; t&iacute;nh năng:<br />\r\nVỏ titan được đ&aacute;nh b&oacute;ng với c&aacute;c li&ecirc;n kết trung t&acirc;m tr&ecirc;n &amp; dưới ho&agrave;n th&agrave;nh chải giữa c&aacute;c vấu.<br />\r\nViền titan với mặt tr&ecirc;n được chải ho&agrave;n thiện &amp; cạnh v&aacute;t ho&agrave;n thiện được đ&aacute;nh b&oacute;ng, được bảo đảm bằng 6 ốc v&iacute;t titan kiểu chữ H được đ&aacute;nh b&oacute;ng.<br />\r\nVương miện titan được đ&aacute;nh b&oacute;ng khắc logo Hublot.<br />\r\nNhựa composite m&agrave;u đen &quot;bezel lug&quot; kẹp giữa khung v&agrave; vỏ.<br />\r\nMặt trời satin m&agrave;u x&aacute;m satin đ&atilde; ho&agrave;n th&agrave;nh quay số.<br />\r\n&Aacute;p dụng đ&aacute;nh dấu chỉ số giờ.<br />\r\nĐ&aacute;nh b&oacute;ng tay rhodium.<br />\r\nCửa sổ ng&agrave;y nằm ở vị tr&iacute; 3 giờ.<br />\r\nHublot Quartz / Pin chạy bằng pin HUB2912, gồm 38 phần.<br />\r\n&nbsp;<br />\r\nT&igrave;nh trạng &nbsp;mới / chưa c&oacute;<br />\r\nVỏ h&igrave;nh &nbsp;tr&ograve;n<br />\r\nK&iacute;ch thước &nbsp;vỏ 33mm<br />\r\nChất liệu &nbsp;vỏ Titan<br />\r\nQuay số m&agrave;u &nbsp;x&aacute;m<br />\r\nPha l&ecirc; &nbsp;Sapphire chống trầy xước<br />\r\nViền &nbsp;cố định<br />\r\nV&iacute;t-in Crown &nbsp;No<br />\r\nChống nước &nbsp;50m / 150ft<br />\r\nCase Back &nbsp;Solid<br />\r\nChất liệu ban nhạc &nbsp;Alligator &amp; Rubber<br />\r\nM&agrave;u / Kết th&uacute;c &nbsp;X&aacute;m<br />\r\nClasp &nbsp;Đẩy N&uacute;t Folding Clasp<br />\r\nPhong tr&agrave;o &nbsp;thạch anh&nbsp;</p>\r\n', 9, 2),
(39, 'hublot-big-bang-346-px-0880-vr-1204-watch-41.jpg', 'HUBLOT BIG BANG 1', 40000, '80704', '<p>Tham khảo 346.Px.0880.Vr.1204<br />\r\nK&iacute;ch thước vỏ 41 Mm<br />\r\nỐp lưng mạ v&agrave;ng 18k 5n<br />\r\nBezel được đ&aacute;nh b&oacute;ng bằng v&agrave;ng 18k 5n<br />\r\nĐặt với 36 vi&ecirc;n kim cương cho 1,80cts với 6 ốc v&iacute;t 5n bằng v&agrave;ng 18k h&igrave;nh chữ H<br />\r\nTinh thể vỏ b&ecirc;n trong<br />\r\nSapphire với Điều trị chống phản chiếu v&agrave; Logo Hublot được in ở mặt trong<br />\r\nMặt số mạ v&agrave;ng được đ&aacute;nh b&oacute;ng&nbsp;<br />\r\nB&agrave;n tay mạ v&agrave;ng si&ecirc;u nhỏ<br />\r\nD&acirc;y đeo &amp; D&acirc;y đeo cao su đen v&agrave; d&acirc;y đeo b&ecirc; đen b&oacute;ng<br />\r\nM&oacute;c kh&oacute;a bằng v&agrave;ng đỏ 18k v&agrave; đen Pvd Th&eacute;p kh&ocirc;ng gỉ triển khai Kh&oacute;a clasp Hoạt động b&ecirc;n trong<br />\r\nHub1112 Phong tr&agrave;o tự l&ecirc;n d&acirc;y c&oacute;t<br />\r\nDự trữ năng lượng 42 giờ</p>\r\n', 9, 2),
(40, 'hublot-401-nq-0123-vr-big-bang-unico-ferrari-45mm-.jpg', 'HUBLOT BIG BANG 401.NQ.0123.VR FERRARI', 20000, '77277', '<p>TH&Ocirc;NG TIN CHI TIẾT<br />\r\nVới c&aacute;c th&agrave;nh phần l&agrave;m từ sợi carbon, một trong những vật liệu mang t&iacute;nh c&aacute;ch mạng nhất v&agrave; chắc chắn l&agrave; một vật liệu c&oacute; tỷ lệ trọng lượng v&agrave; sức mạnh cao nhất, chiếc đồng hồ tinh xảo n&agrave;y của Hublot, giới hạn ở 1000 chiếc, thực sự t&ocirc;n vinh sự hợp t&aacute;c với Ferrari bằng c&aacute;ch sử dụng trạng th&aacute;i hiện đại vật liệu -art v&agrave; đảm bảo độ ch&iacute;nh x&aacute;c v&agrave; hiệu quả cao. Với khả năng dự trữ năng lượng trong 72 giờ, tầm cỡ HUB6016 tự l&ecirc;n d&acirc;y c&oacute; thể nh&igrave;n thấy qua mặt số sapphire với c&aacute;c kim v&agrave; chỉ số ph&aacute;t quang m&agrave;u trắng được mạ rhodium v&agrave; hiển thị giờ trung t&acirc;m, ph&uacute;t v&agrave; đồng hồ bấm giờ gi&acirc;y, c&ugrave;ng với bộ đếm 60 ph&uacute;t . Được gắn tr&ecirc;n d&acirc;y đeo bằng da của Lịch tr&igrave;nh với chỉ kh&acirc;u m&agrave;u đỏ v&agrave; kẹp gấp titan, vỏ 45mm được l&agrave;m bằng titan ho&agrave;n thiện,<br />\r\nVỏ titan với kết th&uacute;c chải &amp; đ&aacute;nh b&oacute;ng g&oacute;c ho&agrave;n th&agrave;nh.<br />\r\nViền bằng sợi carbon, được bảo đảm bằng 6 ốc v&iacute;t titan kiểu chữ &quot;H&quot; m&agrave;u đen.<br />\r\nTrường hợp trung t&acirc;m (cạnh) ch&egrave;n nhựa composite m&agrave;u đen b&ecirc;n.<br />\r\nSatin đ&atilde; ho&agrave;n th&agrave;nh titan rown với ch&egrave;n cao su m&agrave;u đen ở đầu &amp; ph&acirc;n đoạn xung quanh vương miện để tăng cường độ b&aacute;m - với chỉ b&aacute;o m&agrave;u đỏ để hiển thị khi vương miện được th&aacute;o ra.<br />\r\nSatin đ&atilde; ho&agrave;n th&agrave;nh c&aacute;c n&uacute;t chrono bằng titan, với một miếng cao su m&agrave;u đen ở n&uacute;t tr&ecirc;n c&ugrave;ng v&agrave; logo Ferrari sơn m&agrave;i m&agrave;u đỏ ở n&uacute;t dưới c&ugrave;ng.<br />\r\nM&agrave;u đỏ pha l&ecirc; sapphire.<br />\r\nMặt số trong suốt bằng pha l&ecirc; Sapphire với ứng dụng được đ&aacute;nh dấu ho&agrave;n thiện bằng th&eacute;p kh&ocirc;ng gỉ kiểu chữ &quot;Đ&iacute;nh&quot; theo kiểu Ả Rập.<br />\r\nMặt b&iacute;ch b&ecirc;n trong được n&acirc;ng / thon l&ecirc;n tr&ecirc;n chu vi của mặt số với r&atilde;nh ph&uacute;t / gi&acirc;y được in m&agrave;u trắng, ph&acirc;n số được in m&agrave;u đỏ của r&atilde;nh thứ hai v&agrave; được đ&aacute;nh dấu khối v&agrave;ng hồng 5 ph&uacute;t (giống như giờ) với chấm s&aacute;ng tr&ecirc;n cạnh.<br />\r\nChải đậm bằng th&eacute;p kh&ocirc;ng gỉ ph&uacute;t &amp; kim giờ với đ&aacute;y lấp đầy &amp; đ&aacute;y khung.<br />\r\nChức năng bấm giờ / Đồng hồ bấm giờ:<br />\r\nĐồng hồ bấm giờ b&aacute;nh xe cột.<br />\r\nC&oacute; chức năng &quot;Flyback&quot;, cho ph&eacute;p khởi động lại đồng hồ bấm giờ ngay lập tức chỉ bằng một lần nhấn n&uacute;t thay v&igrave; cần dừng, đặt lại v&agrave; sau đ&oacute; khởi động lại đồng hồ bấm giờ.<br />\r\nSố gi&acirc;y lớn m&agrave;u đỏ trung t&acirc;m.<br />\r\nQuay số phụ 60 ph&uacute;t đặt tại vị tr&iacute; 3 giờ.<br />\r\nCửa sổ ng&agrave;y với nền m&agrave;u v&agrave;ng nằm ở vị tr&iacute; 3 giờ.<br />\r\nD&acirc;y đeo:<br />\r\nMỗi chiếc đồng hồ được cung cấp 2 d&acirc;y đeo 1) da m&agrave;u đen theo lịch đen với chỉ kh&acirc;u m&agrave;u đỏ &amp; 2) cao su m&agrave;u đen.<br />\r\nD&acirc;y đeo c&oacute; thể dễ d&agrave;ng thay thế cho nhau th&ocirc;ng qua hệ thống n&uacute;t nhấn giải ph&oacute;ng nhanh độc đ&aacute;o được ph&aacute;t triển bởi Hublot. C&aacute;c n&uacute;t được l&agrave;m bằng gốm đen &amp; nằm tr&ecirc;n c&aacute;c vấu trung t&acirc;m tr&ecirc;n c&ugrave;ng v&agrave; dưới c&ugrave;ng.<br />\r\nSản xuất trong nh&agrave; Hublot Calibre UNICO HUB1241:<br />\r\nMicroblast anthracite ruthenium mạ &amp; cầu ch&iacute;nh.<br />\r\nC&aacute;nh quạt vonfram với kết th&uacute;c xử l&yacute; microblazed, anthracite &amp; ruthenium.<br />\r\nNhịp đập ở 28.800 vph.<br />\r\nBao gồm trong số 330 th&agrave;nh phần.<br />\r\nChứa 38 vi&ecirc;n ngọc<br />\r\nV&agrave; c&oacute; một dự trữ năng lượng xấp xỉ 72 giờ.</p>\r\n', 9, 1),
(41, 'classic-fusion-510-no-1180-no-titanium-king-gold-45.jpg', 'HUBLOT CLASSIC FUSION 2', 15000, '86497', '<p>Th&ocirc;ng số kỹ thuật Vỏ ngo&agrave;i<br />\r\nTham khảo 510.Kh&ocirc;ng.1180. Kh&ocirc;ng<br />\r\nK&iacute;ch thước vỏ 45 Mm<br />\r\nVỏ Satin-Ho&agrave;n thiện v&agrave; đ&aacute;nh b&oacute;ng Titanium<br />\r\nV&ograve;ng bezel<br />\r\nV&agrave;ng hồng Satin được ho&agrave;n thiện v&agrave; đ&aacute;nh b&oacute;ng<br />\r\n6 ốc v&iacute;t h&igrave;nh chữ H<br />\r\nVỏ b&ecirc;n trong<br />\r\nCrystal Sapphire với điều trị chống phản xạ<br />\r\nMặt số m&agrave;u đen mờ<br />\r\nD&acirc;y đeo Satin-V&agrave;ng 18k King Gold v&agrave; Titanium được đ&aacute;nh b&oacute;ng<br />\r\nChốt<br />\r\nTitan kh&oacute;a triển khai clasp<br />\r\nNội c&ocirc;ng<br />\r\nPhong tr&agrave;o Hub1112<br />\r\nPhong tr&agrave;o tự l&ecirc;n d&acirc;y c&oacute;t<br />\r\nDự trữ năng lượng 42 giờ<br />\r\nChống nước 50m hoặc 5 Atm</p>\r\n', 9, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`idbrand`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idcategory`);

--
-- Indexes for table `tblcontact`
--
ALTER TABLE `tblcontact`
  ADD PRIMARY KEY (`idcontact`);

--
-- Indexes for table `watchs`
--
ALTER TABLE `watchs`
  ADD PRIMARY KEY (`idwatchs`),
  ADD UNIQUE KEY `namewatchs` (`namewatchs`),
  ADD KEY `idbrand` (`idbrand`),
  ADD KEY `FK_category` (`idcategory`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idadmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `idbrand` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `idcategory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tblcontact`
--
ALTER TABLE `tblcontact`
  MODIFY `idcontact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `watchs`
--
ALTER TABLE `watchs`
  MODIFY `idwatchs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `watchs`
--
ALTER TABLE `watchs`
  ADD CONSTRAINT `FK_Brand` FOREIGN KEY (`idbrand`) REFERENCES `brand` (`idbrand`),
  ADD CONSTRAINT `FK_category` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`),
  ADD CONSTRAINT `watchs_ibfk_1` FOREIGN KEY (`idbrand`) REFERENCES `brand` (`idbrand`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
