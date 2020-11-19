# TP Persistance des donnees
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
  
Création du projet :
  
1/Dans Eclipse, créez un projet nommé « JDBC ». (File->New->JavaProject)
  
2/Ajoutez mysql-connector.jar dans les librairies du projet
  
  Click droit sur le projet -- > Properties--> build path -- > configure build path.
  Dans l’onglet Libraries cliquez sur Add External Jar et Selectionnez le jar correspondant.
  
  TP 2/
  
  1/Dans le même projet « JDBC », créez le package « persistance.dao»
  
  2/Copiez la classe « Vehicule.java » du TP1 dans ce nouveau package.
  
  3/Créez une interface « VehiculeDao» qui regroupe la déclaration de toutes les méthodes de l’accès vu dans le TP1.
  
  4/Créez une classe « VehiculeDAOImpl.java » qui implémente l’interface VehiculeDAO, et implémentez la méthode qui permet de lister tous les véhicules. Son prototype est : public List<Vehicule> listerVehicules().
  
  5/Afin de finaliser la mise en place du pattern DAO, on met en oeuvre une classe factory pour masquer l'origine des objets et masquer la classe utilisée concrètement pour créer les objets. Créez une classe « VehiculeDAOFactory.java »
  
  6/Créez une classe « TestVehiculeDAO.java » dont le but est de tester les méthodes implémentées.
  
  7/Comparez les deux implémentations du TP1 et TP2.
  
  8/Implémentez et testez les autres méthodes de l’interface « VehiculeDAO »
