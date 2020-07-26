use fixeddepositdb2;

CREATE TABLE `fixeddeposit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `initialamount` decimal(19,2) DEFAULT NULL,
  `maturityamount` decimal(19,2) DEFAULT NULL,
  `rate` decimal(19,2) DEFAULT NULL,
  `tenure` varchar(255) DEFAULT NULL,
  `userno` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `interestrate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenure` varchar(20) DEFAULT NULL,
  `rate` decimal(8,3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenure` (`tenure`)
);

