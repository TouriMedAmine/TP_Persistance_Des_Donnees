package persistance.dao;

import java.util.List;

import persistance.TestJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehiculeDAOImpl implements VehiculeDAO {
	
	private Connection connection;
	
	public VehiculeDAOImpl(Connection _connection) {
		
		this.connection = _connection;
	
	}
	

	@Override
	public List<Vehicule> listerVehicules() {
		
		Statement statement = null;
		try {
			String rechercherTousLesVehiculeQuery = "select v.* from vehicule v";
			statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery(rechercherTousLesVehiculeQuery);
			List<Vehicule> listeTousLesVehicules = new ArrayList<>();
			while (resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String code_interne = resultSet.getString("code_interne");
				String immatriculation = resultSet.getString("immatriculation");
				String dateMiseEnCirculation= resultSet.getString("dateMiseEnCirculation");
				Vehicule vehicule = new Vehicule(id, code_interne, immatriculation, dateMiseEnCirculation);
				listeTousLesVehicules.add(vehicule);
					
			}
			return listeTousLesVehicules;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if ((statement != null) && !statement.isClosed()) {
				statement.close();
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
		}
		
	}
	
	@Override
	public void modifierVehiculeParId(long _id, String _codeInterne) {
		
		Statement statement = null;
		
		try {
			PreparedStatement pst=null;
			String sql;
			sql="UPDATE vehicule set code_interne=? where id=?";
			pst = this.connection.prepareStatement(sql);
			
			pst.setString(1, _codeInterne);
			pst.setLong(2, _id );
			
			pst.executeUpdate();
			System.out.println();
			pst.close();
		} catch (SQLException se) {
			System.out.println("erreur");
			se.printStackTrace();
		} finally{
			try {
				if (statement!= null) {
					((Connection) statement).close();
				}
			} catch(SQLException se2) {
				se2.printStackTrace();
				
			}
		}
		
	}
	
	
	protected void finalize() throws Throwable {
		
		if ((this.connection != null) && !this.connection.isClosed()) {
			
			try {
				this.connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.finalize();
		
	}

	



	@Override
	public void supprimerVehiculeParId(long _id) {
		java.sql.Statement stmt= null;
		try {
			PreparedStatement pst=null;
			String sql="Delete from vehicule where id=?";
			pst=this.connection.prepareStatement(sql);
			pst.setLong(1, _id);
			
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


	@Override
	public void insererVehicule(String _codeInterne, String _immatriculation, java.sql.Date _dateMiseEnCirculation) {
		java.sql.Statement stmt= null;
		try {
			PreparedStatement pst=null;
			
			String sql;
			sql="insert into vehicule(code_interne,immatriculation,dateMiseEnCirculation) values (?,?,?)";
			pst=this.connection.prepareStatement(sql);
			pst.setString(1, _codeInterne );
			pst.setString(2,  _immatriculation);
			pst.setDate(3, _dateMiseEnCirculation );
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
