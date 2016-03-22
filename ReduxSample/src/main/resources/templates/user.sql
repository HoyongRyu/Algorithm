CREATE TABLE `tbas_user` (
  `USR_ID` varchar(30) NOT NULL,
  `AUTH_FG` tinyint(1) NOT NULL,
  `CMPY_ID` int(10) DEFAULT NULL,
  `CRT_DT` date NOT NULL,
  `CRTR_ID` varchar(30) NOT NULL,
  `MDFY_DT` date NOT NULL,
  `MDFR_ID` varchar(30) NOT NULL,
  PRIMARY KEY (`USR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
