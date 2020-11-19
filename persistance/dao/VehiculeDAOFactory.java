package persistance.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public final class VehiculeDAOFactory {
	
	public static final String JDBC_DAO = "jdbc_dao";
	public static final String JPA_DAO = "jpa_dao";
	
	public static VehiculeDAO getVehiculeDao(String typeDao) {
		
		if (VehiculeDAOFactory.JDBC_DAO.equals(typeDao)) {
			return VehiculeDAOFactory.getVehiculeDaoJdbc();
		}
// Else une autre connexion JPA par exemple
		else {
			return null;
		}
	}
	private static VehiculeDAO getVehiculeDaoJdbc() {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/Incident?useSSL=false";
		String USER = "root";
		String PASS = "rootroot";
		
		try {
			
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return new VehiculeDAOImpl(connection);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
}
