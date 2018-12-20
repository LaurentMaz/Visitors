package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONObject;

import bdd.Data;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.*;

@WebServlet("/Visitor")
public class Visitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Visitor() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		Data visitorsDatas = new Data(); 
		request.setAttribute("utilisateurs", visitorsDatas.recupererUtilisateurs());
		
	    this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 //Store the body POST request
			BufferedReader readData = request.getReader();
			
		//Convert JSON to Java object	
			Gson gson = new Gson();
			Data visiteur = gson.fromJson(readData.readLine(), Data.class);
			
			try {
							
				visiteur.ajoutDonneeVisiteur();				
				
			} catch (Exception e) {
				e.printStackTrace();
			};
		 
			
	     	        
	     this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
