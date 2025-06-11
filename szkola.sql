-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Cze 11, 2025 at 02:29 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `szkola`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klasy`
--

CREATE TABLE `klasy` (
  `id_klasy` int(11) NOT NULL,
  `nazwa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `klasy`
--

INSERT INTO `klasy` (`id_klasy`, `nazwa`) VALUES
(1, 'klasa_1'),
(2, 'klasa_2'),
(3, 'klasa_3'),
(4, 'klasa_4'),
(5, 'klasa_5'),
(6, 'klasa_6');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `personel`
--

CREATE TABLE `personel` (
  `id_personelu` int(11) NOT NULL,
  `imie` varchar(50) DEFAULT NULL,
  `nazwisko` varchar(50) DEFAULT NULL,
  `rola` enum('nauczyciel','kucharz','sprzątacz') DEFAULT NULL,
  `nr_telefonu` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pensja` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `personel`
--

INSERT INTO `personel` (`id_personelu`, `imie`, `nazwisko`, `rola`, `nr_telefonu`, `email`, `pensja`) VALUES
(1, 'Jan', 'Długosz', 'nauczyciel', '+48502001001', 'jan.długosz@szkola.pl', 4750.00),
(2, 'Maria', 'Zielińska', 'nauczyciel', '+48502001002', 'maria.zielińska@szkola.pl', 4750.00),
(3, 'Andrzej', 'Nowak', 'sprzątacz', '+48502001003', 'andrzej.nowak@szkola.pl', 3950.00),
(4, 'Elżbieta', 'Wójcik', 'nauczyciel', '+48502001004', 'elżbieta.wójcik@szkola.pl', 4750.00),
(5, 'Paweł', 'Mazur', 'nauczyciel', '+48502001005', 'paweł.mazur@szkola.pl', 4750.00),
(6, 'Anna', 'Kowalczyk', 'nauczyciel', '+48502001006', 'anna.kowalczyk@szkola.pl', 4750.00),
(7, 'Tomasz', 'Kaczmarek', 'nauczyciel', '+48502001007', 'tomasz.kaczmarek@szkola.pl', 4750.00),
(8, 'Monika', 'Sikora', 'nauczyciel', '+48502001008', 'monika.sikora@szkola.pl', 4750.00),
(9, 'Krzysztof', 'Kamiński', 'nauczyciel', '+48502001009', 'krzysztof.kamiński@szkola.pl', 4750.00),
(10, 'Karolina', 'Piotrowska', 'nauczyciel', '+48502001010', 'karolina.piotrowska@szkola.pl', 4750.00),
(11, 'Barbara', 'Baran', 'kucharz', '+48502001011', 'barbara.baran@szkola.pl', 4350.00),
(12, 'Zbigniew', 'Kubiak', 'kucharz', '+48502001012', 'zbigniew.kubiak@szkola.pl', 4350.00),
(13, 'Danuta', 'Czarnecka', 'kucharz', '+48502001013', 'danuta.czarnecka@szkola.pl', 4350.00),
(14, 'Renata', 'Wrona', 'sprzątacz', '+48502001014', 'renata.wrona@szkola.pl', 4250.00),
(15, 'Mirosław', 'Leśniak', 'sprzątacz', '+48502001015', 'mirosław.leśniak@szkola.pl', 4250.00),
(16, 'Bożena', 'Jasińska', 'sprzątacz', '+48502001016', 'bożena.jasińska@szkola.pl', 4250.00);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uczniowie`
--

CREATE TABLE `uczniowie` (
  `id_ucznia` int(11) NOT NULL,
  `imie` varchar(50) DEFAULT NULL,
  `nazwisko` varchar(50) DEFAULT NULL,
  `nr_telefonu_opiekuna` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `uczniowie`
--

INSERT INTO `uczniowie` (`id_ucznia`, `imie`, `nazwisko`, `nr_telefonu_opiekuna`) VALUES
(1, 'Anna', 'Nowak', '+48501111001'),
(2, 'Kacper', 'Kowalski', '+48501111002'),
(3, 'Zuzanna', 'Wiśniewska', '+48501111003'),
(4, 'Jan', 'Wójcik', '+48501111004'),
(5, 'Oliwia', 'Kaczmarek', '+48501111005'),
(6, 'Michał', 'Mazur', '+48501111006'),
(7, 'Julia', 'Dąbrowska', '+48501111007'),
(8, 'Szymon', 'Piotrowski', '+48501111008'),
(9, 'Aleksandra', 'Grabowska', '+48501111009'),
(10, 'Filip', 'Nowicki', '+48501111010'),
(11, 'Maja', 'Szymański', '+4850111110'),
(12, 'Lena', 'Woźniak', '+4850111111'),
(13, 'Mateusz', 'Pawlak', '+4850111112'),
(14, 'Natalia', 'Sikora', '+4850111113'),
(15, 'Jakub', 'Sikora', '+4850111114'),
(16, 'Amelia', 'Górska', '+4850111115'),
(17, 'Lena', 'Szymański', '+4850111116'),
(18, 'Maja', 'Zielińska', '+4850111117'),
(19, 'Mateusz', 'Pawlak', '+4850111118'),
(20, 'Antoni', 'Wieczorek', '+4850111119'),
(21, 'Lena', 'Sikora', '+4850111120'),
(22, 'Lena', 'Lewandowski', '+4850111121'),
(23, 'Wiktoria', 'Woźniak', '+4850111122'),
(24, 'Mateusz', 'Król', '+4850111123'),
(25, 'Lena', 'Zając', '+4850111124'),
(26, 'Lena', 'Lis', '+4850111125'),
(27, 'Natalia', 'Jankowska', '+4850111126'),
(28, 'Natalia', 'Zielińska', '+4850111127'),
(29, 'Bartosz', 'Wieczorek', '+4850111128'),
(30, 'Maja', 'Zielińska', '+4850111129'),
(31, 'Bartosz', 'Woźniak', '+4850111130'),
(32, 'Lena', 'Lis', '+4850111131'),
(33, 'Jakub', 'Lis', '+4850111132'),
(34, 'Bartosz', 'Król', '+4850111133'),
(35, 'Wiktoria', 'Król', '+4850111134'),
(36, 'Wiktoria', 'Wieczorek', '+4850111135'),
(37, 'Bartosz', 'Woźniak', '+4850111136'),
(38, 'Laura', 'Wróbel', '+4850111137'),
(39, 'Amelia', 'Lewandowski', '+4850111138'),
(40, 'Bartosz', 'Wieczorek', '+4850111139'),
(41, 'Franciszek', 'Wieczorek', '+4850111140'),
(42, 'Maja', 'Król', '+4850111141'),
(43, 'Mateusz', 'Zając', '+4850111142'),
(44, 'Wiktoria', 'Wróbel', '+4850111143'),
(45, 'Wiktoria', 'Wróbel', '+4850111144'),
(46, 'Amelia', 'Król', '+4850111145'),
(47, 'Jakub', 'Wróbel', '+4850111146'),
(48, 'Bartosz', 'Wieczorek', '+4850111147'),
(49, 'Wiktoria', 'Zielińska', '+4850111148'),
(50, 'Maja', 'Sikora', '+4850111149'),
(51, 'Amelia', 'Sikora', '+4850111150'),
(52, 'Mateusz', 'Sikora', '+4850111151'),
(53, 'Antoni', 'Lis', '+4850111152'),
(54, 'Wiktoria', 'Wróbel', '+4850111153'),
(55, 'Amelia', 'Jankowska', '+4850111154'),
(56, 'Bartosz', 'Woźniak', '+4850111155'),
(57, 'Amelia', 'Zielińska', '+4850111156'),
(58, 'Maja', 'Szymański', '+4850111157'),
(59, 'Maja', 'Woźniak', '+4850111158'),
(60, 'Bartosz', 'Sikora', '+4850111159'),
(61, 'Patryk', 'Oki', '+48555222111');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uczniowie_klasy`
--

CREATE TABLE `uczniowie_klasy` (
  `id_ucznia` int(11) NOT NULL,
  `id_klasy` int(11) NOT NULL,
  `numer_w_dzienniku` int(11) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `uczniowie_klasy`
--

INSERT INTO `uczniowie_klasy` (`id_ucznia`, `id_klasy`, `numer_w_dzienniku`, `status`) VALUES
(1, 2, 10, NULL),
(2, 1, 7, ''),
(3, 5, 1, ''),
(4, 6, 3, ''),
(5, 1, 6, 'wiceprzewodniczący'),
(6, 2, 9, ''),
(7, 1, 1, 'przewodniczący'),
(8, 3, 4, ''),
(9, 1, 2, ''),
(10, 3, 1, ''),
(11, 4, 2, ''),
(12, 5, 2, 'wiceprzewodniczący'),
(13, 3, 2, ''),
(14, 3, 5, 'skarbnik'),
(15, 3, 6, ''),
(16, 1, 3, ''),
(17, 4, 3, ''),
(18, 6, 6, ''),
(19, 3, 3, ''),
(20, 4, 5, ''),
(21, 3, 7, 'przewodniczący'),
(22, 2, 3, 'wiceprzewodniczący'),
(23, 5, 3, 'skarbnik'),
(24, 1, 8, 'skarbnik'),
(25, 6, 4, ''),
(26, 2, 5, ''),
(27, 1, 4, ''),
(28, 6, 7, 'skarbnik'),
(29, 4, 6, ''),
(30, 6, 8, 'przewodniczący'),
(31, 5, 4, ''),
(32, 2, 6, 'przewodniczący'),
(33, 2, 7, ''),
(34, 1, 9, ''),
(35, 1, 10, ''),
(36, 4, 7, ''),
(37, 5, 5, 'przewodniczący'),
(38, 5, 8, ''),
(39, 2, 4, ''),
(40, 4, 8, ''),
(41, 4, 9, ''),
(42, 2, 1, ''),
(43, 6, 5, ''),
(44, 5, 9, ''),
(45, 5, 10, ''),
(46, 2, 2, ''),
(47, 6, 1, ''),
(48, 4, 10, ''),
(49, 6, 9, ''),
(50, 3, 8, ''),
(51, 3, 9, 'wiceprzewodniczący'),
(52, 3, 10, 'przewodniczący'),
(53, 2, 8, ''),
(54, 6, 2, ''),
(55, 1, 5, ''),
(56, 5, 6, 'przewodniczący'),
(57, 6, 10, 'wiceprzewodniczący'),
(58, 4, 4, ''),
(59, 5, 7, ''),
(60, 4, 1, ''),
(61, 6, 11, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `id_uzytkownika` int(11) NOT NULL,
  `typ_uzytkownika` varchar(20) DEFAULT NULL,
  `nazwa` varchar(20) DEFAULT NULL,
  `haslo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id_uzytkownika`, `typ_uzytkownika`, `nazwa`, `haslo`) VALUES
(1, 'admin', 'Dyrektor', 'Dyrektor123'),
(2, 'uzytkownik', 'Jan', 'Jan123');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `klasy`
--
ALTER TABLE `klasy`
  ADD PRIMARY KEY (`id_klasy`);

--
-- Indeksy dla tabeli `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`id_personelu`);

--
-- Indeksy dla tabeli `uczniowie`
--
ALTER TABLE `uczniowie`
  ADD PRIMARY KEY (`id_ucznia`);

--
-- Indeksy dla tabeli `uczniowie_klasy`
--
ALTER TABLE `uczniowie_klasy`
  ADD PRIMARY KEY (`id_ucznia`,`id_klasy`),
  ADD KEY `id_klasy` (`id_klasy`);

--
-- Indeksy dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id_uzytkownika`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klasy`
--
ALTER TABLE `klasy`
  MODIFY `id_klasy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `personel`
--
ALTER TABLE `personel`
  MODIFY `id_personelu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `uczniowie`
--
ALTER TABLE `uczniowie`
  MODIFY `id_ucznia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `uczniowie_klasy`
--
ALTER TABLE `uczniowie_klasy`
  MODIFY `id_ucznia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id_uzytkownika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `uczniowie_klasy`
--
ALTER TABLE `uczniowie_klasy`
  ADD CONSTRAINT `uczniowie_klasy_ibfk_1` FOREIGN KEY (`id_ucznia`) REFERENCES `uczniowie` (`id_ucznia`),
  ADD CONSTRAINT `uczniowie_klasy_ibfk_2` FOREIGN KEY (`id_klasy`) REFERENCES `klasy` (`id_klasy`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
