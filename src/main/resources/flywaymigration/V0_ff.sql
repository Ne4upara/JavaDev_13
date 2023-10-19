INSERT INTO `clients` VALUES
(1, 'Вася Пупкин'),
(2, 'Коля Подубцев'),
(3, 'Прораб Петя'),
(4, 'Витя Соболев'),
(5, 'Констаха'),
(6, 'Юля Малішева'),
(7, 'Ирка Дирка'),
(8, 'Саня Безруков'),
(9, 'Олег Газманов'),
(10, 'Филя Киркоров');

INSERT INTO `planet` VALUES
('MRS', 'MARS'),
('VEN', 'Venus'),
('EAR', 'Earth'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

INSERT INTO `ticket` VALUES
(1, CURRENT_TIMESTAMP, 1, 'MRS', 'VEN'),
(2, CURRENT_TIMESTAMP, 2, 'EAR', 'JUP'),
(3, CURRENT_TIMESTAMP, 1, 'VEN', 'SAT'),
(4, CURRENT_TIMESTAMP, 3, 'MRS', 'JUP'),
(5, CURRENT_TIMESTAMP, 2, 'SAT', 'VEN');