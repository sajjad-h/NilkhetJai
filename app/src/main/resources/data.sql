-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2022 at 09:39 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nilkhetjai`
--

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `author`, `file_data`, `file_type`, `is_available`, `language`, `name`, `number_of_books`, `type`) VALUES
(1, 'Sajjad', NULL, NULL, b'1', 'english', 'ha ha hi hi', 5, 'baaaaaaaaaa'),
(2, 'author', NULL, NULL, b'1', 'la la', 'ha 2', 100, 'hey');

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`cart_id`) VALUES
(1);

--
-- Dumping data for table `cart_books`
--

INSERT INTO `cart_books` (`cart_id`, `book_id`) VALUES
(1, 1),
(1, 2);

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `first_name`, `is_active`, `last_name`, `password`, `cart_id`) VALUES
(1, 'sajjad@ab', 'Sajjad', b'0', 'Hossain', '$2a$10$91iODOzQ0hd05SNYTQp9ZuzwHtaAqyGCCFqVhiBFZH9mxwBkenyOS', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
