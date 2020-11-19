package persistance;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.xdevapi.Statement;

public class TestJDBC {
	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	static final String DB_URL= "jdbc:mysql://localhost:3306/Incident";
	static final String USER= "root";
	static final String PASS= "rootroot";
	static Connection conn= null;
	
	public static void main(String[] args) {
		try {
			TestJDBC.conn= TestJDBC.initConnection(TestJDBC.conn);
			String date = "2020-09-01";
			java.sql.Date SqlDate = java.sql.Date.valueOf(date);
			ArrayList<Vehicule> listeTousLesVehicules = TestJDBC.listerObjVehicule();
			
			} catch (SQLException se) {
				se.printStackTrace();
			} finally{
				TestJDBC.closeConnection(TestJDBC.conn);
			}
		}


private static Connection initConnection(Connection conn) throws SQLException {
	try{
		Class.forName(TestJDBC.JDBC_DRIVER);
		conn= DriverManager.getConnection(TestJDBC.DB_URL, TestJDBC.USER, TestJDBC.PASS);
	  } catch(ClassNotFoundException e) {
			throw new SQLException("Impossible de trouver le driver JDBC : "+ e.getMessage());
			}
		return conn;
	}

private static void closeConnection(Connection conn) {
	try {
		if (conn!= null) {
			conn.close();
			System.out.println("Fermeture de la connexion!");
		}
	} catch(SQLException e) {
		
	}
	
}
private static void listerVehicules() {
	java.sql.Statement stmt= null;
	System.out.println("Statement listerVehicule...");
	try {
		stmt= TestJDBC.conn.createStatement();
		String sql;
		sql= "select id, code_interne, immatriculation, dateMiseEnCirculation from Vehicule;";
		ResultSet rs= ((java.sql.Statement) stmt).executeQuery(sql);
		while(rs.next()) {
			int id= rs.getInt("id");
			String codeInterne= rs.getString("code_interne");
			String immatriculation= rs.getString("immatriculation");
			String dateMiseEnCirculation= rs.getString("dateMiseEnCirculation");
			System.out.print("ID: "+ id);
			System.out.print(", Code interne: "+ codeInterne);
			System.out.print(", Immatriculation : "+ immatriculation);
			System.out.println(", Date de mise en circulation: "+ dateMiseEnCirculation);
		}
		rs.close();
		((Connection) stmt).close();
	} catch (SQLException se) {
		se.printStackTrace();
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}
private static void listerVehicule(String code_interne) {
	java.sql.Statement stmt= null;
	try {
		stmt= TestJDBC.conn.createStatement();
		String sql;
		sql= "select id, code_interne, immatriculation, dateMiseEnCirculation from Vehicule where code_interne ="+ code_interne + ";";
		System.out.println(sql);
		
		ResultSet rs= ((java.sql.Statement) stmt).executeQuery(sql);
		while(rs.next()) {
			int id= rs.getInt("id");
			String codeInterne= rs.getString("code_interne");
			String immatriculation= rs.getString("immatriculation");
			String dateMiseEnCirculation= rs.getString("dateMiseEnCirculation");
			System.out.print("ID: "+ id);
			System.out.print(", Code interne: "+ codeInterne);
			System.out.print(", Immatriculation : "+ immatriculation);
			System.out.println(", Date de mise en circulation: "+ dateMiseEnCirculation);
		}
		rs.close();
		((Connection) stmt).close();
	} catch (SQLException se) {
		se.printStackTrace();
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}
private static void insererVehicule(String code_interne, String immatriculation, java.sql.Date date ) {
	java.sql.Statement stmt= null;
	System.out.println("inserer");
	try {
		PreparedStatement pst=null;
		
		String sql;
		sql="insert into vehicule(code_interne,immatriculation,dateMiseEnCirculation) values (?,?,?)";
		pst=TestJDBC.conn.prepareStatement(sql);
		pst.setString(1, code_interne );
		pst.setString(2,  immatriculation);
		pst.setDate(3, date );
		pst.executeUpdate();
		pst.close();
	} catch (SQLException se) {
		System.out.println("erreur");
		se.printStackTrace();
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}
private static void modifierVehicule(int id, String code_interne) {
	java.sql.Statement stmt= null;
	System.out.println("modifier");
	try {
		PreparedStatement pst=null;
		String sql;
		sql="UPDATE vehicule set code_interne=? where id=?";
		pst=TestJDBC.conn.prepareStatement(sql);
		pst.setString(1, code_interne);
		pst.setInt(2, id );
		
		pst.executeUpdate();
		pst.close();
	} catch (SQLException se) {
		System.out.println("erreur");
		se.printStackTrace();
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}
private static ArrayList<Vehicule> listerObjVehicule () {
	java.sql.Statement stmt= null;
	try {
		ArrayList<Vehicule> l = new ArrayList<Vehicule> ();
		stmt= TestJDBC.conn.createStatement();
		String sql;
		sql="Select id,code_interne,immatriculation,dateMiseEnCirculation from vehicule";
		System.out.println(sql);
		
		ResultSet rs= ((java.sql.Statement) stmt).executeQuery(sql);
		Vehicule a;
		while(rs.next()) {
			int id= rs.getInt("id");
			String code_interne= rs.getString("code_interne");
			String immatriculation= rs.getString("immatriculation");
			String dateMiseEnCirculation= rs.getString("dateMiseEnCirculation");
			a=new Vehicule(id,code_interne,immatriculation,dateMiseEnCirculation);
			l.add(a);
		}
		for(Vehicule v:l)
			 System.out.println(v.toString());
		rs.close();
		((Connection) stmt).close();
		return l ;
		
	} catch (SQLException se) {
		ArrayList<Vehicule> l = new ArrayList<Vehicule> ();
		se.printStackTrace();
		return l;
		
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}

private static void supprimerVehicule(int id) {
	java.sql.Statement stmt= null;
	System.out.println("supprimer");
	try {
		PreparedStatement pst=null;
		String sql="Delete from vehicule where id=?";
		pst=TestJDBC.conn.prepareStatement(sql);
		pst.setInt(1, id);
		
		pst.executeUpdate();
		pst.close();
	} catch (SQLException se) {
		System.out.println("erreur");
		se.printStackTrace();
	} finally{
		try {
			if (stmt!= null) {
				((Connection) stmt).close();
			}
		} catch(SQLException se2) {
			
		}
	}
}
}







