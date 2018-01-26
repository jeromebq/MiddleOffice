package sparkexample;

import org.json.*;
import static spark.Spark.*;

import java.util.*;

public class Questionnaire {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Demande> demandes = new ArrayList<Demande>();

	public static void main(String[] args) {
    	
        setPort(80);
        
        get("/newdemande", (request, response) -> {
        	
        	return "<!DOCTYPE html>" +
        	"<html>" +
            "<head>" +
            "<meta charset=\"utf-8\" />" +
                "<title>Creation de demande</title>" +
            "</head>" +
        	"<body>" +
        		"<p>Creation de demande : </p>" +
        		"<form>"+
        			"<p>"+
        			"<label for=\"description\">Description :</label>"+
        			"<input type=\"text\" name=\"description\" id=\"description\" />"+
        			"<br />"+
        			"<label for=\"chargeutile\">Charge utile :</label>"+
        			"<input type=\"text\" name=\"chargeutile\" id=\"chargeutile\" />"+
        			"<br />"+
        			"<label for=\"urlsioui\">URL si oui :</label>"+
        			"<input type=\"text\" name=\"urlsioui\" id=\"urlsioui\" />"+
        			"<br />"+
        			"<label for=\"urlsinon\">URL si non :</label>"+
        			"<input type=\"text\" name=\"urlsinon\" id=\"urlsinon\" />"+
        			"</p>"+
        		"</form>"+
        		"<form action=\"accueil.html\">"+
        			"<input type=\"submit\" value=\"Creer la demande\" />"+
        		"</form>"+
        		"<form action=\"/demandes\">"+
        			"<input type=\"submit\" value=\"Annuler\" />"+
        		"</form>"+
            "</body>"+
        	
        "</html>";
        });

        post("/demandes", (request, response) -> {
        	
        	String id = UUID.randomUUID().toString();
        	String question = request.queryParams("description");
        	String chargeutile = request.queryParams("chargeutile");
        	String ouiadresse = request.queryParams("urlsioui");
        	String nonadresse = request.queryParams("urlsinon");
        	
        	demandes.add(new Demande(id, question, chargeutile, ouiadresse, nonadresse));
        	
        	response.redirect("/demandes");//Serveur redirect HTTP request Web client
        	return "";
        });

        get("/demandes", (request, response) -> {
        	JSONObject obj = new JSONObject();
        	
        	for (Demande demande : demandes){
        		obj.append("id", demande.getID());
        		obj.append("question", demande.getQuestion());
        	}
        	
        	String affichage;
        	
        	affichage = "<!DOCTYPE html>"+
        	"<html>"+
        	  "<head>"+
        	    "<title>Affichage des demandes</title>"+
        	    "<meta charset=\"utf-8\">"+
        	  "</head>"+
        	  "<body>"+
      		"<form action=\"/newdemande\">" +
  			"<input type=\"submit\" value=\"Creer une demande\" />"+
  			"</form>"+
        	"<ul>";
        	  for (Demande demande : demandes){
        		  affichage += "<li><a href=\"/demandes/" + demande.getID() + "\">" + demande.getQuestion() + "</a></li>";

        	  }
        	  affichage +="</ul>"+
        	  "</body>"+
        	"</html>";
        	 return affichage;
        });
        
        get("/demandes/:id", (request, response) -> {
        	// Verifier si getVote =/ true sinon redirection sur les demandes


        	return "html";
        });
        
        post("/demandes/:id", (request, response) -> {
        	// Verifier si getVote =/ true sinon redirection sur les demandes
        	
        	for (Demande demande : demandes){
        		if (demande.getID().equals(request.params(":id")))
        			if (request.queryParams("choix") == "oui") {
        				demande.setVote();
        				
        			}
        			else {
        				
        			}
        	}

        	
        	return "<html>" +
        			"<head>" +
        			"<meta http-equiv=\"refresh\" content=\"1; URL=/demandes\">" +
        			"</head>" +
        			"<body>" +
        			"</body>" +
        			"</html>" +
        			"<html>";
        });
       
    }
}
