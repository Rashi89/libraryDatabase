-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 10 Lut 2022, 16:09
-- Wersja serwera: 10.4.13-MariaDB
-- Wersja PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `library`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `baskets`
--

CREATE TABLE `baskets` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `total_books` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `baskets`
--

INSERT INTO `baskets` (`id`, `id_user`, `total_books`) VALUES
(1, 1, 0),
(18, 18, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `type` varchar(40) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(40) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `publication_year` int(11) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `description` longtext NOT NULL DEFAULT 'Brak opisu.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `books`
--

INSERT INTO `books` (`id`, `type`, `title`, `author`, `publisher`, `publication_year`, `pages`, `quantity`, `description`) VALUES
(1, 'album', 'Beksiński obrazy', 'Zdzisław Beksiński', 'Bosz', 2022, NULL, 1, '<p>Wyjątkowy album poświęcony twórczości Zdzisława Beksińskiego – jednego\r\n                                z najciekawszych i&nbsp;najbardziej intrygujących współczesnych artystów.\r\n                                Publikacja przygotowana zostanie we współpracy z&nbsp;Muzeum Historycznym\r\n                                w Sanoku  – spadkobiercą i patronem twórczości sanockiego Mistrza.</p>\r\n\r\n                            <p>Wyboru reprodukcji dzieł dokona, wspólnie z wydawcą, były i obecny dyrektor\r\n                                Muzeum – Wiesław Banach oraz Jarosław Serafin. Album ukaże się w wersji\r\n                                luksusowej: w powiększonym formacie i&nbsp;eleganckiej szacie graficznej,\r\n                                o objętości ok. 400 stron. Będzie zawierać najlepsze prace malarskie\r\n                                (obrazy) artysty, poprzez które artysta wyrażał się najpełniej.\r\n                                Pokazane zostaną zarówno dzieła znane powszechnemu odbiorcy, jak i nowe,\r\n                                dotąd niepublikowane, znajdujące się w zagranicznych kolekcjach prywatnych.\r\n                                Reprodukcjom towarzyszyć będą teksty wybitnego tenora Wiesława Ochmana –\r\n                                długoletniego przyjaciela artysty, oraz Wiesława Banacha – znakomitego znawcy\r\n                                dorobku Beksińskiego.</p>\r\n\r\n\r\n                            <p>Całość zaprezentowana zostanie w&nbsp;unikalnej oprawie graficznej autorstwa prof.\r\n                                Władysława Pluty. </p>\r\n\r\n                            <p>Powyższy opis pochodzi od wydawcy.</p>'),
(2, 'comics', 'Zmysły', 'Matteo Farinella ', 'Marginesy', 2020, NULL, 0, '                                        <p>Młoda kobieta pracująca nad budową maszyny wirtualnej rzeczywistości ulega wypadkowi, \r\n                                            który zabiera ją na wycieczkę po pięciu zmysłach i fizjologii, która jest ich podstawą. \r\n                                            Czy to wszystko jest tylko gorączkowym snem, gdy jest nieprzytomna?</p>\r\n                                        \r\n                                        <p>\"Zmysły\" to żartobliwa, szczegółowa, aczkolwiek wciąż łatwa w odbiorze książka. Neurobiolog \r\n                                            i&nbsp;ilustrator Matteo Farinella zabiera czytelnika na dziką przejażdżkę po kluczowych postaciach \r\n                                            i&nbsp;fascynujących faktach dotyczących każdego z naszych pięciu zmysłów. Opisy najbardziej aktualnych badań \r\n                                            urozmaicają wyjaśniające je rysunki i wykresy, które spodobają się nawet najbardziej niedoświadczonym \r\n                                            naukowo osobom.</p>\r\n                                        \r\n                                        <p>Książka jest bardzo podstawowym wprowadzeniem do zmysłów - do zrozumienia głównych narządów zmysłowego \r\n                                            układu nerwowego oraz sposobu ich pracy i komunikacji ze sobą.</p>\r\n                                        \r\n                                        <p>Ilustracje w książce są bardzo funkcjonalne, jednak nie warto czytać tej powieści graficznej wyłącznie \r\n                                            dla sztuki - przeczytaj ją, ponieważ możesz się czegoś nauczyć! To duża dawka wiedzy z dziedziny anatomii \r\n                                            i fizjologii, ale również i spora porcja zabawy.</p>\r\n                                        \r\n                                        <p>Dr Farinella wydaje się być dobrze zorientowana we wszystkich najnowszych badaniach dotyczących dotyku, \r\n                                            smaku, zapachu, słuchu i wzroku. Wszystko jest wyjaśnione tak prosto, jak to tylko możliwe, ale nie ma sensu,\r\n                                             aby cokolwiek było celowo pomijane, by ułatwić odbiór przez czytelników.</p>'),
(3, 'fairytale', 'Baśnie', 'Hans Christian Andersen', 'G&P', 2021, NULL, 1, ' <p>Wybór najpiękniejszych baśni Hansa Christiana Andersena  ilustrowanych przez Jana Marcina Szancera. \r\n                                            Spis baśni: Dzieje roku, Calineczka, Syrena, Dzielny ołowiany żołnierz, Pasterka i&nbsp;kominiarczyk,\r\n                                            Stokrotka, Dzikie łabędzie, Słowik, Brzydkie kaczątko, Krzesiwo, Latający kufer , Imbryk, Igła do \r\n                                            cerowania, Księżniczka na ziarnku grochu, Len, Stara uliczna latarnia, Nowe szaty cesarza, Świniopas, \r\n                                            Ogrodnik i jego chlebodawcy, Najpiękniejsza róża świata, Dziewczynka z zapałkami, Królowa Śniegu, Choinka.</p>'),
(4, 'guide', 'Podróże z pasją Grecja', 'Lance Chilton,', 'Wydawnictwo Naukowe PWN', 2009, NULL, 5, '                                        <p>Przewodnik, który powstał z pasji podróżowania!</p>\r\n                                        <p>Napisany przez doświadczonego podróżnika, który odwiedził i opisał setki miejsc na świecie, \r\n                                            z myślą o osobach preferujących samodzielne wyprawy.</p>\r\n                                            \r\n                                        <p>Autor przewodnika oprowadza po wielu niezwykłych miejscach, a wśród nich tych położonych na popularnych \r\n                                            szlakach, a także po mniej znanych, ale uczęszczanych, dla których warto zjechać z trasy.</p>\r\n                                            \r\n                                            <p>Książka zawiera 2 obszerne części - Informacje praktyczne i Przewodnik - poprzedzone opisem 25 atrakcji, \r\n                                                których nie można przegapić, w tym zabytki, wydarzenia i lokalne smakołyki.</p>'),
(5, 'science', 'Kobiety wojowniczki', 'Iwona Kienzler', 'Bellona', 2020, 368, 3, '<p>Prowadzenie wojen, zwycięstwa i porażki w bitwach i potyczkach to domena przede wszystkim mężczyzn. \r\n                                            Ale czy na pewno udział kobiet w wojnach ograniczał się do roli markietanek czy niewolnic branych w jasyr?\r\n                                             Historia obfituje w epizody walecznych bojowniczek. Przybliżmy czytelnikom niektóre z nich, począwszy od Amazonek, \r\n                                             poprzez Artemizję – kobietę w funkcji admirała – czy Agryppinę Starszą. Przyjrzyjmy się Joannie d’Arc, \r\n                                             która poprowadziła do boju Francuzów, zapoznajmy się z wyczynami Katarzyny Sforzy i polskim kresowym wilczycom. \r\n                                             Do znanych kobiet w mundurze należała Joanna Żubr, której, jako pierwszej kobiecie przyznano Virtuti Militari. \r\n                                             Do historii weszła też Henryka Pustowójtówna i legionistki Piłsudskiego.</p>\r\n\r\n                                            <p>Wszystkie te kobiety udowodniły, że odwaga, dzielność i spryt pomagają w wojowaniu i nie są tylko atrybutami mężczyzn.</p>'),
(6, 'album', 'Nowa galeria kotów. Druga odsłona sztuki z pazurem', 'Susan Herbert', 'Media Rodzina', 2021, NULL, 3, 'Brak opisu.'),
(7, 'comics', 'Armada. Tom 2', 'Jean-David Morvan', 'Egmont', 2022, NULL, 4, 'Brak opisu.'),
(8, 'fairytale', 'Brzechwa dzieciom', 'Jan Brzechwa', 'Siedmioróg', 2021, NULL, 3, 'Brak opisu.'),
(9, 'guide', 'Podróże z pasją Egipt', 'Dan Richardson', 'Wydawnictwo Naukowe PWN', 2009, NULL, 4, 'Brak opisu.'),
(10, 'science', 'Lato 1920', 'Joanna Rolińska', 'Bellona', 2020, 456, 5, 'Brak opisu.'),
(11, 'science', 'Wstęp do psychoanalizy', 'Zygmunt Freud', 'Bellona', 2010, 304, 3, 'Brak opisu.'),
(12, 'guide', 'Podróże z pasją Chiny', 'David Leffman', 'Wydawnictwo Naukowe PWN', 2010, NULL, 4, 'Brak opisu.'),
(13, 'fairytale', 'Kicia Kocia Zima', 'Anita Głowińska', 'Media Rodzina', 2021, NULL, 4, 'Brak opisu.'),
(14, 'comics', 'Nieustraszony. Daredevil. Tom 7', 'Antony Johnston', 'Egmont', 2021, NULL, 5, 'Brak opisu.'),
(15, 'album', 'Wanderlust USA', 'Cam Honan', 'Gestalten', 2019, NULL, 5, 'Brak opisu.'),
(16, 'science', 'Rozmyślania', 'Marek Aureliusz', 'Onepress', 2016, 160, 4, 'Brak opisu.'),
(17, 'guide', 'Podróże z pasją Portugalia', 'Jules Brown', 'Wydawnictwo Naukowe PWN', 2010, NULL, 3, 'Brak opisu.'),
(18, 'fairytale', 'Kicia Kocia na lotnisku', 'Anita Głowińska', 'Media Rodzina', 2021, NULL, 3, 'Brak opisu.'),
(19, 'comics', 'X-Men. Czerwoni', 'Tom Taylor', 'Egmont', 2021, NULL, 5, 'Brak opisu.'),
(20, 'album', 'Psy rasowe', 'Anna Biziorek', 'Wademekum', 2017, NULL, 4, 'Brak opisu.'),
(21, 'album', 'Skarby malarstwa', 'Joanna Babiarz', 'SBM', 2018, NULL, 3, 'Brak opisu.'),
(22, 'comics', 'Ostatnie wyzwanie. Strażnicy Galaktyki. Tom 1', 'Donny Cates', 'Egmont', 2021, NULL, 4, 'Brak opisu.'),
(23, 'fairytale', 'Kicia Kocia sprząta', 'Anita Głowińska', 'Media Rodzina', 2021, NULL, 3, 'Brak opisu.'),
(24, 'guide', 'Podróże z pasją Hiszpania', 'Jules Brown', 'Wydawnictwo Naukowe PWN', 2010, NULL, 2, 'Brak opisu.'),
(25, 'science', 'Przewodnik po Wszechświecie', 'Stephen Hawking', 'Zysk i S-ka', 2021, 432, 4, 'Brak opisu.'),
(34, 'fairytale', 'Kicia Kocia prasuje', 'Anita', 'Media Rodzina', 2020, NULL, 4, 'Brak opisu.'),
(35, 'album', 'Koty', 'Anita', 'Media Rodzina', 2019, NULL, 2, 'Brak opisu.'),
(36, 'album', 'Kocie życie', 'Anita', 'Media Rodzina', 2021, NULL, 3, 'Brak opisu.'),
(37, 'guide', 'Jak wychowac kitku', 'Anita', 'Media Rodzina', 2022, NULL, 4, 'Brak opisu.'),
(38, 'comics', 'Kitku w opałach', 'Anita', 'Media Rodzina', 2011, NULL, 5, 'Brak opisu.'),
(39, 'comics', 'Superkitku i bandyci', 'Anita', 'Media Rodzina', 2012, NULL, 3, 'Brak opisu.'),
(40, 'comics', 'Superkitku i jego banda', 'Anita', 'Media Rodzina', 2012, NULL, 6, 'Brak opisu.'),
(41, 'science', 'Sekretne życie kotów', 'Anita', 'Media Rodzina', 2015, 123, 3, 'Brak opisu.'),
(42, 'comics', 'Superkitku i zaczarowany las', 'Anita', 'Media Rodzina', 2018, NULL, 5, 'Brak opisu.'),
(43, 'comics', 'Superkitku i wiedźma', 'Anita', 'Media Rodzina', 2017, NULL, 4, 'Brak opisu.'),
(44, 'album', 'Sekretne życie futrzaków', 'Anita', 'Media Rodzina', 2012, NULL, 3, 'Brak opisu.'),
(45, 'fairytale', 'Mała kitówa', 'Anita', 'Media Rodzina', 2013, NULL, 5, 'Brak opisu.'),
(46, 'guide', 'Małe kocie sprawy', 'Anita', 'Media Rodzina', 2014, NULL, 2, 'Brak opisu.'),
(47, 'science', 'Kocie', 'Anita', 'Media Rodzina', 2009, 23, 0, 'Brak opisu.');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `book_orders`
--

CREATE TABLE `book_orders` (
  `id` int(11) NOT NULL,
  `id_basket` int(11) NOT NULL,
  `id_book` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rentals`
--

CREATE TABLE `rentals` (
  `id` int(11) NOT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL,
  `comments` longtext DEFAULT NULL,
  `is_return` bit(1) DEFAULT b'0',
  `id_comment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `rentals`
--

INSERT INTO `rentals` (`id`, `start`, `end`, `id_user`, `id_book`, `comments`, `is_return`, `id_comment`) VALUES
(1, '2022-01-01', '2022-01-07', 1, 6, '', b'0', NULL),
(2, '2022-01-11', '2022-01-18', 1, 7, '', b'1', 6),
(3, '2022-01-13', '2022-01-20', 1, 14, '', b'0', 7),
(4, '2022-01-05', '2022-01-13', 2, 6, '', b'1', 2),
(5, '2022-01-09', '2022-01-16', 2, 10, '', b'1', NULL),
(6, '2022-01-20', '2022-01-27', 2, 7, '', b'0', 8),
(7, '2021-03-01', '2022-04-07', 3, 3, '', b'1', 1),
(8, '2021-12-27', '2022-01-04', 3, 17, '', b'1', NULL),
(9, '2022-01-22', '2022-01-29', 3, 19, '', b'0', NULL),
(10, '2022-01-05', '2022-01-12', 4, 2, '', b'1', NULL),
(11, '2021-12-01', '2021-12-08', 4, 11, '', b'1', NULL),
(12, '2022-01-19', '2022-01-26', 4, 15, '', b'0', NULL),
(13, '2022-01-04', '2022-01-11', 5, 25, '', b'1', NULL),
(14, '2022-01-07', '2022-01-14', 5, 6, '', b'1', 4),
(15, '2021-05-11', '2021-05-18', 5, 22, '', b'1', NULL),
(16, '2019-04-03', '2019-04-09', 11, 21, '', b'1', 3),
(17, '2020-06-18', '2020-06-23', 13, 7, '', b'1', 5),
(18, '2021-09-05', '2021-09-08', 1, 7, '', b'1', 9),
(21, '2022-01-20', '2022-01-27', 2, 41, '', b'0', NULL),
(28, '2022-02-08', '2022-02-15', 1, 5, '', b'0', NULL),
(29, '2022-02-08', '2022-02-15', 1, 7, '', b'0', NULL),
(30, '2022-02-08', '2022-02-15', 1, 8, '', b'0', NULL),
(31, '2022-02-08', '2022-02-15', 1, 13, '', b'0', NULL),
(32, '2022-02-08', '2022-02-15', 1, 11, '', b'0', NULL),
(35, '2022-02-08', '2022-02-15', 18, 5, '', b'0', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `reviews`
--

INSERT INTO `reviews` (`id`, `comment`, `points`) VALUES
(1, 'Fajna ksiazka', 4),
(2, 'Beznadzieja', 1),
(3, 'Beznadziejna ta książka', 1),
(4, 'Może być', 2),
(5, 'Szału nie ma', 3),
(6, 'Fajna', 4),
(7, 'Polecam', 5),
(8, 'Naprawde nie polecam', 2),
(9, 'Nie czytalem', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `name`, `surname`, `password`) VALUES
(1, 'Agata', 'Rachańska', 'b6ad34b0b6b7e38f878a513b3f7927ebeb4cffb01aeb6d9fd9f9ad67fbc76517'),
(2, 'Katarzyna', 'Rachańska', 'Kat'),
(3, 'Barbara', 'Rachańska', 'Bar'),
(4, 'Jan', 'Kowalski', 'Jan'),
(5, 'Kamila', 'Kowalska', 'Kam'),
(7, 'Agnieszka', 'Mazur', 'Agn'),
(8, 'Adam', 'Mazur', 'Ada'),
(9, 'Olga', 'Raj', 'Olg'),
(10, 'Kamil', 'Raj', 'Kam'),
(11, 'Natalia', 'Zazu', 'Nat'),
(12, 'Zenon', 'Zazu', 'Zen'),
(13, 'Aleksandra', 'Olsza', 'Ale'),
(14, 'Olek', 'Olsza', 'Ole'),
(15, 'Magdalena', 'Misio', 'Mag'),
(16, 'Michał', 'Misio', 'Mic'),
(17, 'Rashi', 'Lavi', 'qwerty1'),
(18, 'Lavi', 'Rashi', 'b6ad34b0b6b7e38f878a513b3f7927ebeb4cffb01aeb6d9fd9f9ad67fbc76517');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `baskets`
--
ALTER TABLE `baskets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeksy dla tabeli `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `book_orders`
--
ALTER TABLE `book_orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_basket` (`id_basket`),
  ADD KEY `id_book` (`id_book`);

--
-- Indeksy dla tabeli `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_comment` (`id_comment`);

--
-- Indeksy dla tabeli `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `baskets`
--
ALTER TABLE `baskets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT dla tabeli `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT dla tabeli `book_orders`
--
ALTER TABLE `book_orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT dla tabeli `rentals`
--
ALTER TABLE `rentals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT dla tabeli `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `baskets`
--
ALTER TABLE `baskets`
  ADD CONSTRAINT `baskets_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Ograniczenia dla tabeli `book_orders`
--
ALTER TABLE `book_orders`
  ADD CONSTRAINT `book_orders_ibfk_1` FOREIGN KEY (`id_basket`) REFERENCES `baskets` (`id`),
  ADD CONSTRAINT `book_orders_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`);

--
-- Ograniczenia dla tabeli `rentals`
--
ALTER TABLE `rentals`
  ADD CONSTRAINT `id_comment` FOREIGN KEY (`id_comment`) REFERENCES `reviews` (`id`),
  ADD CONSTRAINT `rentals_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `rentals_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
