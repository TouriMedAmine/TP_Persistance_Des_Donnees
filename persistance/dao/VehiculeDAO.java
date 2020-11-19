package persistance.dao;
import java.util.List;

public interface VehiculeDAO {
	
	List<Vehicule> listerVehicules();
	
	void insererVehicule(String _codeInterne, String _immatriculation, java.sql.Date _dateMiseEnCirculation);
	
	void modifierVehiculeParId(long _id, String _codeInterne);
	
	void supprimerVehiculeParId(long _id);

}
