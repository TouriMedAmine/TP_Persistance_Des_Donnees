package persistance.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class TestVehiculeDAO {

	public static void main(String[] args) {
		
		TestVehiculeDAO.executer(new VehiculeDAOFactory().JDBC_DAO);
		
	}
	public static void executer(String typeDao) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			VehiculeDAO vehiculeDao = VehiculeDAOFactory.getVehiculeDao(typeDao);
		
			/* List<Vehicule> listeTousLesVehicules = vehiculeDao.listerVehicules();
			int l = listeTousLesVehicules.size();
		
			for (int i=0; i<l; i++) {
				
				Vehicule vehicule =  listeTousLesVehicules.get(i);
				int id= vehicule.getId();
				String codeInterne= vehicule.getCode_interne();
				String immatriculation= vehicule.getImmatriculation();
				String dateMiseEnCirculation= vehicule.getDateMiseEnCirculation();
				
				System.out.print("ID: "+ id);
				System.out.print(", Code interne: "+ codeInterne);
				System.out.print(", Immatriculation : "+ immatriculation);
				System.out.println(", Date de mise en circulation: "+ dateMiseEnCirculation);
				
			}
			*/
			Scanner sc = new Scanner(System.in);
			System.out.println("inserer");
			System.out.println("Entrez l'immatriculation: ");
			String immatriculation = sc.next();
			System.out.println("Nv code interne: ");
			String code_interne = sc.next();
			System.out.println("Entrez la date de mise en production: ");
			String date = sc.next();
			java.sql.Date SqlDate = java.sql.Date.valueOf(date);
			//vehiculeDao.modifierVehiculeParId(id, code_interne);
			vehiculeDao.insererVehicule(code_interne, immatriculation, SqlDate);
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
	



