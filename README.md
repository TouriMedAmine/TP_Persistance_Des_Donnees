# TP1JDBC
TP1 : Rappel de JDBC – Injection SQL

réalisé par : Touri Mohamed Amine

Encadré par : Mme El Hari

Environnements requis:

§ Java SE Development Kit 8 :
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-
2133151.html
§ Eclipse IDE 2019-06 R : https://www.eclipse.org/downloads/packages/ (Choisir Eclipse
IDE for Enterprise Java Developers)
§ Mysql Community Server 8.0.17: https://dev.mysql.com/downloads/mysql/ (lors de
l’installation mettre : root rootroot)
§ Mysql Workbench 8.0.17: https://dev.mysql.com/downloads/workbench/
§ Mysql Connector J 8.0.17: https://dev.mysql.com/downloads/connector/j/ (Choisir
“Platform Independent”)

Création de la base de données:

1/Créez via Workbench le schéma la base de données My SQL : Incident

2/Créez la table « Vehicule »

  Use Incident;
  CREATE TABLE `Vehicule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_interne` varchar(45) DEFAULT NULL,
  `immatriculation` varchar(45) DEFAULT NULL,
  `dateMiseEnCirculation` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
