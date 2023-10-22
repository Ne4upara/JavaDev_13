insert into clients (id, name) values
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

insert into planet (id, name) values
('MRS', 'MARS'),
('VEN', 'Venus'),
('EAR', 'Earth'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');

insert into ticket (id, created_at, client_id, from_planet_id, to_planet_id) values
(1, CURRENT_TIMESTAMP, 1, 'MRS', 'VEN'),
(2, CURRENT_TIMESTAMP, 2, 'EAR', 'JUP'),
(3, CURRENT_TIMESTAMP, 1, 'VEN', 'SAT'),
(4, CURRENT_TIMESTAMP, 3, 'MRS', 'JUP'),
(5, CURRENT_TIMESTAMP, 2, 'SAT', 'VEN');