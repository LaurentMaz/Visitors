package bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Data {
	   private Connection connexion;
	   private String ip;
	   private String country;
	   private String screen;
	   private String browser;
	   
	   public void Data(String ipAdress, String country, String screen, String browser) {
			this.ip = ip;
			this.country = country;
			this.screen = screen;
			this.browser = browser;
		}
	   
	   // Méthode qui ajoute les données dans la base 
	    public void ajoutDonneeVisiteur()
	    {
	    	loadDatabase();   	
	        
	        try {
				PreparedStatement preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO visiteurs(ip, pays, browser, screen) VALUES(?, ?, ?, ?);");
				preparedStatement.setString(1, ip);
				preparedStatement.setString(2, country);
				preparedStatement.setString(3, browser);
				preparedStatement.setString(4, screen);
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    };  
	   
	   
	   // Méthode qui récupère les données déjà présentent dans la base 
	    public List<Utilisateur> recupererUtilisateurs() {
	        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	        Statement statement = null;
	        ResultSet resultat = null;
	        loadDatabase();
	        
	        try {
	            statement = (Statement) connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT * FROM visiteurs;");

	            // Récupération des données
	            while (resultat.next()) {
	                String ip = resultat.getString("ip");
	                String pays = resultat.getString("pays");
	                String browser = resultat.getString("browser");
	                String screen = resultat.getString("screen");
	                
	                Utilisateur utilisateur = new Utilisateur();
	                utilisateur.setIp(ip);
	                utilisateur.setPays(pays);
	                utilisateur.setBrowser(browser);
	                utilisateur.setScreen(screen);
	                
	                utilisateurs.add(utilisateur);
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	       	
	        return utilisateurs;
	    }
	    
	   // Méthode qui charge la base
	    public void loadDatabase() {
	        // Chargement du driver
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/visitors", "root", "");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	      
	    
};
