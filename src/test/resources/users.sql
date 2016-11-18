/**
* 用户表数据, 仅供测试, 项目确认后可将该文件夹(database)删除.
*/

DROP TABLE `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;


INSERT INTO `users` (`id`, `name`, `age`, `phone`, `address`, `email`, `created_at`, `updated_at`)
VALUES
	(11, '11-user name', 11, '123456', 'user address', 'user email', NULL, NULL),
	(12, '12-user name', 12, 'user phone', 'user address', 'user email', NULL, NULL),
	(13, '13-user name', 13, 'user phone', 'user address', 'user email', NULL, NULL),
	(14, 'user name', 20, 'user phone', 'user address', 'user email', NULL, NULL),
	(19, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(20, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(21, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(22, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(23, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(24, 'user-test', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(25, 'user-test', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(26, 'user-test', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(27, 'user-test', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(28, 'user-123', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(29, 'user-123', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(30, 'user-123', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(31, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(32, 'user n1ame', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(33, 'user n1ame', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(34, 'user name', 20, 'user phone', 'user address', 'user email', '2016-09-08', '2016-09-08'),
	(35, 'test_transaction', 20, 'test-phone', 'test-address', 'test-email', '2016-09-14', '2016-09-14');
