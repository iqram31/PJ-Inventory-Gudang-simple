-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2017 at 02:33 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_inventory_gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE IF NOT EXISTS `tb_admin` (
`no_admin` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(8) NOT NULL,
  `akses` enum('Manajer','Petugas Gudang','Penjualan') NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`no_admin`, `nama`, `username`, `password`, `akses`) VALUES
(1, 'Saeful Rahman', 'saeful13', '123', 'Manajer'),
(2, 'Iqram Anwar', 'iqram', '123', 'Petugas Gudang'),
(4, 'Acep Rian Pauji', 'acep', '123', 'Penjualan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE IF NOT EXISTS `tb_barang` (
  `kd_barang` char(8) NOT NULL,
  `no_jenis` int(11) DEFAULT NULL,
  `nama` varchar(30) NOT NULL,
  `stok` int(11) NOT NULL,
  `kode_supplier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`kd_barang`, `no_jenis`, `nama`, `stok`, `kode_supplier`) VALUES
('BBR-0001', 14, 'Bilal Bin Rubah', 10, 19),
('BLV-0001', 12, 'Believe', 104, 19),
('FTH-0001', 12, 'Faith', 62, 19),
('IMH-0001', 12, 'Imam Mahdi', 125, 19),
('KHF-0001', 12, 'Khulafu', 128, 19),
('LPY-0001', 17, 'Lets Pray', 9, 19),
('LTY-0001', 17, 'Logo Type', 94, 20),
('MJD-0001', 16, 'Mad Jadda', 48, 20),
('MKH-0001', 12, 'Makkah', 87, 19),
('MKH-0002', 12, 'Mekah', 39, 19),
('RJT-0001', 12, 'Reject', 72, 19),
('STN-0001', 16, 'Satan', 27, 19),
('SWD-0001', 16, 'Swords', 88, 20),
('TBY-0001', 12, 'Tabayyun', 77, 19),
('UMN-0001', 12, 'Utsman', 183, 19);

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_barang`
--

CREATE TABLE IF NOT EXISTS `tb_detail_barang` (
  `kd_barang` varchar(8) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `detail_jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_barang`
--

INSERT INTO `tb_detail_barang` (`kd_barang`, `harga_barang`, `detail_jenis`) VALUES
('BBR-0001', 78000, 'Celana Hitam'),
('BLV-0001', 185352, 'Pakaian Panjang'),
('FTH-0001', 70000, 'Pakaian Panjang'),
('IMH-0001', 70000, 'Pakaian Pendek'),
('KHF-0001', 290000, 'Pakaian Pendek'),
('LPY-0001', 150000, 'Jaket Kulit'),
('LTY-0001', 79000, 'Jaket Kulit'),
('MJD-0001', 98000, 'Kemeja Lengan Panjang'),
('MKH-0001', 120000, 'Pakaian Muslim'),
('MKH-0002', 100000, 'Pakaian Muslim'),
('RJT-0001', 70000, 'Pakaian Pendek'),
('STN-0001', 59000, 'Kemeja Lengan Panjang'),
('SWD-0001', 56000, 'Kemeja Lengan Panjang'),
('TBY-0001', 45000, 'Pakaian Panjang'),
('UMN-0001', 120000, 'Pakaian Panjang');

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_pembelian`
--

CREATE TABLE IF NOT EXISTS `tb_detail_pembelian` (
  `kode_beli` varchar(15) NOT NULL,
  `kd_barang` varchar(8) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status` enum('Ya','Tidak') NOT NULL DEFAULT 'Tidak'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_pembelian`
--

INSERT INTO `tb_detail_pembelian` (`kode_beli`, `kd_barang`, `jumlah`, `status`) VALUES
('PBL/190117/0001', 'FTH-0001', 20, 'Ya'),
('PBL/190117/0001', 'TBY-0001', 30, 'Tidak'),
('PBL/190117/0001', 'UMN-0001', 20, 'Ya'),
('PBL/190117/0002', 'MKH-0001', 1, 'Ya'),
('PBL/190117/0002', 'MKH-0002', 2, 'Tidak'),
('PBL/190117/0002', 'RJT-0001', 3, 'Tidak'),
('PBL/190117/0003', 'KHF-0001', 20, 'Tidak'),
('PBL/190117/0003', 'FTH-0001', 20, 'Ya'),
('PBL/190117/0003', 'IMH-0001', 90, 'Tidak'),
('PBL/190117/0003', 'TBY-0001', 5, 'Ya'),
('PBL/190117/0004', 'MKH-0001', 20, 'Tidak'),
('PBL/190117/0004', 'MKH-0002', 20, 'Tidak'),
('PBL/200117/0005', 'KHF-0001', 3, 'Tidak'),
('PBL/200117/0005', 'UMN-0001', 39, 'Ya'),
('PBL/200117/0006', 'RJT-0001', 2, 'Tidak'),
('PBL/200117/0006', 'STN-0001', 1, 'Tidak'),
('PBL/200117/0007', 'FTH-0001', 2, 'Ya'),
('PBL/200117/0007', 'MKH-0001', 2, 'Tidak'),
('PBL/200117/0008', 'TBY-0001', 2, 'Tidak'),
('PBL/200117/0009', 'MKH-0001', 3, 'Tidak'),
('PBL/200117/0009', 'MKH-0002', 1, 'Tidak'),
('PBL/200117/0009', 'FTH-0001', 2, 'Ya'),
('PBL/200117/0010', 'MKH-0002', 2, 'Tidak'),
('PBL/200117/0010', 'MKH-0001', 50, 'Tidak'),
('PBL/200117/0011', 'RJT-0001', 56, 'Tidak'),
('PBL/200117/0012', 'LTY-0001', 40, 'Tidak'),
('PBL/200117/0012', 'SWD-0001', 30, 'Tidak'),
('PBL/200117/0013', 'KHF-0001', 2, 'Tidak'),
('PBL/200117/0013', 'TBY-0001', 20, 'Tidak'),
('PBL/200117/0013', 'IMH-0001', 25, 'Tidak'),
('PBL/200117/0014', 'SWD-0001', 20, 'Tidak'),
('PBL/200117/0014', 'MJD-0001', 29, 'Tidak'),
('PBL/200117/0014', 'LTY-0001', 10, 'Tidak'),
('PBL/200117/0015', 'SWD-0001', 34, 'Tidak'),
('PBL/200117/0015', 'SWD-0001', 67, 'Tidak'),
('PBL/200117/0015', 'LTY-0001', 20, 'Tidak'),
('PBL/200117/0016', 'RJT-0001', 20, 'Tidak'),
('PBL/200117/0016', 'KHF-0001', 23, 'Tidak'),
('PBL/200117/0017', 'MJD-0001', 30, 'Tidak'),
('PBL/200117/0017', 'SWD-0001', 50, 'Tidak'),
('PBL/200117/0018', 'MKH-0001', 2, 'Tidak'),
('PBL/200117/0018', 'UMN-0001', 3, 'Tidak'),
('PBL/240217/0019', 'UMN-0001', 40, 'Tidak'),
('PBL/240217/0019', 'TBY-0001', 50, 'Tidak'),
('PBL/240217/0019', 'KHF-0001', 40, 'Tidak'),
('PBL/240217/0019', 'MJD-0001', 50, 'Tidak'),
('PBL/240217/0019', 'KHF-0001', 40, 'Tidak'),
('PBL/240217/0020', 'UMN-0001', 25, 'Tidak'),
('PBL/240217/0020', 'TBY-0001', 50, 'Tidak'),
('PBL/240217/0020', 'BLV-0001', 20, 'Tidak'),
('PBL/240217/0020', 'IMH-0001', 40, 'Tidak'),
('PBL/240217/0021', 'KHF-0001', 50, 'Tidak'),
('PBL/240217/0021', 'MKH-0002', 20, 'Tidak'),
('PBL/240217/0021', 'IMH-0001', 35, 'Tidak'),
('PBL/240217/0021', 'FTH-0001', 10, 'Ya'),
('PBL/240217/0022', 'TBY-0001', 20, 'Tidak'),
('PBL/240217/0022', 'BLV-0001', 20, 'Tidak'),
('PBL/250217/0023', 'RJT-0001', 90, 'Tidak'),
('PBL/250217/0023', 'MKH-0001', 60, 'Tidak'),
('PBL/250217/0024', 'UMN-0001', 10, 'Ya'),
('PBL/250217/0024', 'IMH-0001', 10, 'Ya'),
('PBL/250217/0024', 'MKH-0002', 12, 'Ya'),
('PBL/210117/0025', 'MKH-0002', 2, 'Tidak'),
('PBL/210117/0025', 'BBR-0001', 3, 'Tidak'),
('PBL/210117/0025', 'IMH-0001', 60, 'Tidak'),
('PBL/210117/0026', 'BLV-0001', 10, 'Tidak'),
('PBL/210117/0026', 'IMH-0001', 5, 'Tidak'),
('PBL/220117/0027', 'FTH-0001', 2, 'Tidak'),
('PBL/220117/0027', 'RJT-0001', 4, 'Tidak'),
('PBL/220117/0028', 'BLV-0001', 2, 'Tidak'),
('PBL/220117/0028', 'FTH-0001', 45, 'Tidak'),
('PBL/220117/0028', 'MKH-0002', 56, 'Tidak'),
('PBL/220117/0029', 'MKH-0002', 3, 'Tidak'),
('PBL/220117/0029', 'KHF-0001', 4, 'Tidak'),
('PBL/220117/0030', 'FTH-0001', 10, 'Tidak'),
('PBL/220117/0030', 'KHF-0001', 3, 'Tidak'),
('PBL/220117/0031', 'STN-0001', 13, 'Tidak'),
('PBL/220117/0031', 'FTH-0001', 10, 'Tidak');

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_penjualan`
--

CREATE TABLE IF NOT EXISTS `tb_detail_penjualan` (
  `kode_jual` varchar(15) NOT NULL,
  `kd_barang` varchar(8) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `sub_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_penjualan`
--

INSERT INTO `tb_detail_penjualan` (`kode_jual`, `kd_barang`, `harga`, `jumlah`, `sub_total`) VALUES
('PJL/190117/0001', 'FTH-0001', 60000, 2, 120000),
('PJL/190117/0001', 'BLV-0001', 54000, 1, 54000),
('PJL/200117/0002', 'RJT-0001', 84000, 2, 168000),
('PJL/200117/0002', 'MJD-0001', 0, 1, 0),
('PJL/200117/0003', 'KHF-0001', 108000, 1, 108000),
('PJL/200117/0003', 'MKH-0001', 84000, 2, 168000),
('PJL/200117/0003', 'MKH-0002', 54000, 1, 54000),
('PJL/200117/0003', 'KHF-0001', 108000, 1, 108000),
('PJL/200117/0003', 'SWD-0001', 67200, 2, 134400),
('PJL/200117/0004', 'MKH-0001', 84000, 1, 84000),
('PJL/200117/0004', 'TBY-0001', 67200, 2, 134400),
('PJL/200117/0005', 'STN-0001', 70800, 1, 70800),
('PJL/200117/0005', 'IMH-0001', 60000, 3, 180000),
('PJL/200117/0006', 'BLV-0001', 54000, 1, 54000),
('PJL/200117/0006', 'IMH-0001', 60000, 2, 120000),
('PJL/200117/0007', 'IMH-0001', 60000, 1, 60000),
('PJL/200117/0007', 'UMN-0001', 84000, 2, 168000),
('PJL/200117/0008', 'TBY-0001', 67200, 1, 67200),
('PJL/200117/0008', 'IMH-0001', 60000, 2, 120000),
('PJL/200117/0008', 'MJD-0001', 117600, 1, 117600),
('PJL/200217/0009', 'TBY-0001', 67200, 1, 67200),
('PJL/200217/0009', 'IMH-0001', 60000, 2, 120000),
('PJL/210217/0010', 'RJT-0001', 84000, 2, 168000),
('PJL/210217/0010', 'IMH-0001', 60000, 1, 60000),
('PJL/210217/0011', 'TBY-0001', 67200, 1, 67200),
('PJL/210217/0011', 'STN-0001', 70800, 2, 141600),
('PJL/210217/0012', 'IMH-0001', 60000, 1, 60000),
('PJL/210217/0012', 'RJT-0001', 84000, 2, 168000),
('PJL/210217/0012', 'MJD-0001', 117600, 3, 352800),
('PJL/210217/0013', 'KHF-0001', 108000, 1, 108000),
('PJL/210217/0013', 'MJD-0001', 117600, 2, 235200),
('PJL/210217/0013', 'FTH-0001', 54000, 2, 108000),
('PJL/230217/0014', 'IMH-0001', 60000, 2, 120000),
('PJL/230217/0014', 'MKH-0002', 54000, 1, 54000),
('PJL/240217/0015', 'MKH-0002', 54000, 1, 54000),
('PJL/240217/0015', 'IMH-0001', 60000, 2, 120000),
('PJL/240217/0015', 'STN-0001', 70800, 1, 70800),
('PJL/250217/0016', 'MKH-0001', 84000, 2, 168000),
('PJL/250217/0016', 'BLV-0001', 54000, 2, 108000),
('PJL/250217/0016', 'MKH-0001', 84000, 1, 84000),
('PJL/260217/0017', 'IMH-0001', 60000, 1, 60000),
('PJL/260217/0017', 'UMN-0001', 84000, 2, 168000),
('PJL/260217/0017', 'FTH-0001', 54000, 3, 162000),
('PJL/260217/0017', 'MKH-0001', 84000, 2, 168000),
('PJL/260217/0018', 'FTH-0001', 54000, 2, 108000),
('PJL/260217/0018', 'FTH-0001', 54000, 1, 54000),
('PJL/260217/0018', 'MKH-0002', 54000, 3, 162000),
('PJL/270217/0019', 'IMH-0001', 60000, 1, 60000),
('PJL/280217/0020', 'MKH-0001', 84000, 2, 168000),
('PJL/280217/0020', 'FTH-0001', 54000, 6, 324000),
('PJL/280217/0020', 'RJT-0001', 84000, 2, 168000),
('PJL/300117/0021', 'MKH-0002', 54000, 4, 216000),
('PJL/300117/0021', 'IMH-0001', 60000, 2, 120000),
('PJL/210117/0022', 'IMH-0001', 60000, 2, 120000),
('PJL/210117/0022', 'MJD-0001', 117600, 4, 470400),
('PJL/210117/0022', 'BLV-0001', 54000, 7, 378000),
('PJL/210117/0022', 'KHF-0001', 108000, 1, 108000),
('PJL/210117/0022', 'IMH-0001', 60000, 2, 120000),
('PJL/210117/0022', 'RJT-0001', 84000, 1, 84000),
('PJL/210117/0022', 'MKH-0002', 54000, 3, 162000),
('PJL/220117/0023', 'IMH-0001', 60000, 2, 120000),
('PJL/220117/0023', 'MKH-0002', 54000, 3, 162000),
('PJL/220117/0023', 'FTH-0001', 84000, 3, 252000),
('PJL/220117/0024', 'FTH-0001', 84000, 2, 168000),
('PJL/220117/0024', 'MKH-0002', 54000, 4, 216000),
('PJL/220117/0024', 'FTH-0001', 84000, 1, 84000),
('PJL/220117/0025', 'MKH-0001', 84000, 1, 84000),
('PJL/220117/0025', 'FTH-0001', 84000, 2, 168000),
('PJL/220117/0025', 'BLV-0001', 222422, 2, 444844),
('PJL/220117/0026', 'KHF-0001', 348000, 2, 696000),
('PJL/220117/0026', 'IMH-0001', 84000, 3, 252000),
('PJL/220117/0027', 'KHF-0001', 348000, 1, 348000),
('PJL/220117/0027', 'BLV-0001', 222422, 1, 222422),
('PJL/220117/0028', 'BLV-0001', 222422, 10, 2224220),
('PJL/220117/0029', 'FTH-0001', 84000, 2, 168000),
('PJL/220117/0030', 'UMN-0001', 144000, 10, 1440000),
('PJL/220117/0030', 'BLV-0001', 222422, 15, 3336330),
('PJL/220117/0031', 'MJD-0001', 117600, 5, 588000),
('PJL/220117/0031', 'UMN-0001', 144000, 7, 1008000),
('PJL/220117/0031', 'MKH-0001', 144000, 1, 144000),
('PJL/220117/0032', 'TBY-0001', 54000, 10, 540000),
('PJL/220117/0032', 'MJD-0001', 117600, 5, 588000),
('PJL/230117/0033', 'RJT-0001', 84000, 10, 840000),
('PJL/230117/0033', 'FTH-0001', 84000, 5, 420000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_jenis`
--

CREATE TABLE IF NOT EXISTS `tb_jenis` (
`no_jenis` int(11) NOT NULL,
  `jenis_barang` varchar(40) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `tb_jenis`
--

INSERT INTO `tb_jenis` (`no_jenis`, `jenis_barang`) VALUES
(12, 'Pakaian'),
(14, 'Celana'),
(16, 'Kemeja'),
(17, 'Jaket'),
(22, 'Tas');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pembelian`
--

CREATE TABLE IF NOT EXISTS `tb_pembelian` (
  `kode_beli` varchar(15) NOT NULL,
  `no_admin` int(11) NOT NULL,
  `kode_supplier` int(11) NOT NULL,
  `tgl_beli` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pembelian`
--

INSERT INTO `tb_pembelian` (`kode_beli`, `no_admin`, `kode_supplier`, `tgl_beli`) VALUES
('PBL/190117/0001', 2, 19, '2017-01-19'),
('PBL/190117/0002', 2, 19, '2017-01-19'),
('PBL/190117/0003', 2, 19, '2017-01-19'),
('PBL/190117/0004', 2, 19, '2017-01-19'),
('PBL/200117/0005', 2, 19, '2017-01-20'),
('PBL/200117/0006', 2, 19, '2017-01-20'),
('PBL/200117/0007', 2, 19, '2017-01-20'),
('PBL/200117/0008', 2, 19, '2017-01-20'),
('PBL/200117/0009', 2, 19, '2017-01-20'),
('PBL/200117/0010', 2, 19, '2017-01-20'),
('PBL/200117/0011', 2, 19, '2017-01-20'),
('PBL/200117/0012', 2, 20, '2017-01-20'),
('PBL/200117/0013', 2, 19, '2017-01-20'),
('PBL/200117/0014', 2, 20, '2017-01-20'),
('PBL/200117/0015', 2, 20, '2017-01-20'),
('PBL/200117/0016', 2, 19, '2017-01-20'),
('PBL/200117/0017', 2, 20, '2017-01-20'),
('PBL/200117/0018', 2, 19, '2017-01-20'),
('PBL/210117/0025', 2, 19, '2017-01-21'),
('PBL/210117/0026', 2, 19, '2017-01-21'),
('PBL/220117/0027', 2, 19, '2017-01-22'),
('PBL/220117/0028', 2, 19, '2017-01-22'),
('PBL/220117/0029', 2, 19, '2017-01-22'),
('PBL/220117/0030', 2, 19, '2017-01-22'),
('PBL/220117/0031', 2, 19, '2017-01-22'),
('PBL/240217/0019', 2, 28, '2017-02-24'),
('PBL/240217/0020', 2, 22, '2017-02-24'),
('PBL/240217/0021', 2, 24, '2017-02-24'),
('PBL/240217/0022', 2, 24, '2017-02-24'),
('PBL/250217/0023', 2, 28, '2017-02-25'),
('PBL/250217/0024', 2, 29, '2017-02-25');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penjualan`
--

CREATE TABLE IF NOT EXISTS `tb_penjualan` (
  `kode_jual` varchar(15) NOT NULL,
  `no_admin` int(11) NOT NULL,
  `tgl_jual` date NOT NULL,
  `total` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penjualan`
--

INSERT INTO `tb_penjualan` (`kode_jual`, `no_admin`, `tgl_jual`, `total`, `total_bayar`, `kembalian`) VALUES
('PJL/190117/0001', 4, '2017-01-19', 174000, 280000, 106000),
('PJL/200117/0002', 4, '2017-01-20', 168000, 170000, 2000),
('PJL/200117/0003', 4, '2017-01-20', 572400, 600000, 27600),
('PJL/200117/0004', 4, '2017-01-20', 790800, 900000, 109200),
('PJL/200117/0005', 4, '2017-01-20', 250800, 300000, 49200),
('PJL/200117/0006', 4, '2017-01-20', 174000, 200000, 26000),
('PJL/200117/0007', 4, '2017-01-20', 228000, 250000, 22000),
('PJL/200117/0008', 4, '2017-01-20', 532800, 550000, 17200),
('PJL/200217/0009', 4, '2017-02-20', 187200, 200000, 12800),
('PJL/210117/0022', 4, '2017-01-21', 1442400, 1500000, 57600),
('PJL/210217/0010', 4, '2017-02-21', 228000, 250000, 22000),
('PJL/210217/0011', 4, '2017-02-21', 436800, 500000, 63200),
('PJL/210217/0012', 4, '2017-02-21', 580800, 600000, 19200),
('PJL/210217/0013', 4, '2017-02-21', 451200, 500000, 48800),
('PJL/220117/0023', 4, '2017-01-22', 534000, 600000, 66000),
('PJL/220117/0024', 4, '2017-01-22', 468000, 500000, 32000),
('PJL/220117/0025', 4, '2017-01-22', 696844, 700000, 3156),
('PJL/220117/0026', 4, '2017-01-22', 948000, 1000000, 52000),
('PJL/220117/0027', 4, '2017-01-22', 570422, 600000, 29578),
('PJL/220117/0028', 4, '2017-01-22', 2224220, 2300000, 75780),
('PJL/220117/0029', 4, '2017-01-22', 168000, 170000, 2000),
('PJL/220117/0030', 4, '2017-01-22', 4776330, 4776330, 0),
('PJL/220117/0031', 4, '2017-01-22', 1740000, 1740000, 0),
('PJL/220117/0032', 4, '2017-01-22', 1128000, 1128000, 0),
('PJL/230117/0033', 4, '2017-01-23', 1260000, 1260000, 0),
('PJL/230217/0014', 4, '2017-02-23', 174000, 180000, 6000),
('PJL/240217/0015', 4, '2017-02-24', 244800, 250000, 5200),
('PJL/250217/0016', 4, '2017-02-25', 360000, 370000, 10000),
('PJL/260217/0017', 4, '2017-02-26', 558000, 600000, 42000),
('PJL/260217/0018', 4, '2017-02-26', 324000, 400000, 76000),
('PJL/270217/0019', 4, '2017-02-27', 60000, 70000, 10000),
('PJL/280217/0020', 4, '2017-02-28', 660000, 670000, 10000),
('PJL/300117/0021', 4, '2017-01-30', 336000, 400000, 64000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_supplier`
--

CREATE TABLE IF NOT EXISTS `tb_supplier` (
`kode_supplier` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(60) NOT NULL,
  `no_hp` varchar(12) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `tb_supplier`
--

INSERT INTO `tb_supplier` (`kode_supplier`, `nama`, `alamat`, `no_hp`) VALUES
(19, 'Earthman', 'Bandung', '086088900567'),
(20, 'C59 (Basma)', 'Bandung', '085603167909'),
(21, 'Fath 1437 H', 'Cimahi', '082100988755'),
(22, 'Ghuraba', 'Sumedang', '081900877544'),
(24, 'Musa', 'Bogor', '085603116854'),
(25, 'Shalah', 'Jakarta Pusat', '089990123894'),
(26, 'Go Hijrah', 'Jakarta Timur', '087903923232'),
(27, 'Tauhid', 'Solo', '087428932394'),
(28, 'Dzikrullah', 'Semarang', '087523023493'),
(29, 'Celana X', 'Makassar', '087367189387'),
(30, 'Celana', 'Aceh', '083723203232');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
 ADD PRIMARY KEY (`no_admin`);

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
 ADD PRIMARY KEY (`kd_barang`), ADD KEY `no_jenis` (`no_jenis`), ADD KEY `kode_supplier` (`kode_supplier`);

--
-- Indexes for table `tb_detail_barang`
--
ALTER TABLE `tb_detail_barang`
 ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `tb_detail_pembelian`
--
ALTER TABLE `tb_detail_pembelian`
 ADD KEY `kd_barang` (`kd_barang`), ADD KEY `kode_beli` (`kode_beli`);

--
-- Indexes for table `tb_detail_penjualan`
--
ALTER TABLE `tb_detail_penjualan`
 ADD KEY `kode_jual` (`kode_jual`), ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `tb_jenis`
--
ALTER TABLE `tb_jenis`
 ADD PRIMARY KEY (`no_jenis`);

--
-- Indexes for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
 ADD PRIMARY KEY (`kode_beli`), ADD KEY `kode_supplier` (`kode_supplier`), ADD KEY `no_admin` (`no_admin`);

--
-- Indexes for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
 ADD PRIMARY KEY (`kode_jual`), ADD KEY `no_admin` (`no_admin`);

--
-- Indexes for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
 ADD PRIMARY KEY (`kode_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
MODIFY `no_admin` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_jenis`
--
ALTER TABLE `tb_jenis`
MODIFY `no_jenis` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
MODIFY `kode_supplier` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_barang`
--
ALTER TABLE `tb_barang`
ADD CONSTRAINT `no_jenis` FOREIGN KEY (`no_jenis`) REFERENCES `tb_jenis` (`no_jenis`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_barang_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `tb_supplier` (`kode_supplier`);

--
-- Constraints for table `tb_detail_barang`
--
ALTER TABLE `tb_detail_barang`
ADD CONSTRAINT `tb_detail_barang_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `tb_barang` (`kd_barang`);

--
-- Constraints for table `tb_detail_pembelian`
--
ALTER TABLE `tb_detail_pembelian`
ADD CONSTRAINT `tb_detail_pembelian_ibfk_1` FOREIGN KEY (`kode_beli`) REFERENCES `tb_pembelian` (`kode_beli`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_detail_pembelian_ibfk_2` FOREIGN KEY (`kd_barang`) REFERENCES `tb_barang` (`kd_barang`) ON UPDATE CASCADE;

--
-- Constraints for table `tb_detail_penjualan`
--
ALTER TABLE `tb_detail_penjualan`
ADD CONSTRAINT `tb_detail_penjualan_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `tb_barang` (`kd_barang`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_detail_penjualan_ibfk_2` FOREIGN KEY (`kode_jual`) REFERENCES `tb_penjualan` (`kode_jual`) ON UPDATE CASCADE;

--
-- Constraints for table `tb_pembelian`
--
ALTER TABLE `tb_pembelian`
ADD CONSTRAINT `tb_pembelian_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `tb_supplier` (`kode_supplier`) ON UPDATE CASCADE,
ADD CONSTRAINT `tb_pembelian_ibfk_2` FOREIGN KEY (`no_admin`) REFERENCES `tb_admin` (`no_admin`);

--
-- Constraints for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
ADD CONSTRAINT `tb_penjualan_ibfk_1` FOREIGN KEY (`no_admin`) REFERENCES `tb_admin` (`no_admin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
