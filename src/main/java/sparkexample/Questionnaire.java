package sparkexample;

import org.json.*;
import static spark.Spark.*;

import java.util.*;

public class Questionnaire {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Demande> demandes = new ArrayList<Demande>();

	public static void main(String[] args) {
    	
        setPort(80);

        post("/demandes", (request, response) -> {
        	
        	JSONObject obj = new JSONObject(request.body());
        	String id = obj.getString("id");
        	String question = obj.getString("question");

        	JSONArray reponsesJSON = obj.getJSONArray("reponses");
        	String[] reponses = new String[reponsesJSON.length()]; 
        	for (int i = 0; i < reponsesJSON.length(); i++)
        	{
        	    reponses[i] = reponsesJSON.getString(i);
        	}
        	
        	demandes.add(new Demande(id, question, reponses));
        	
        	return "add";
        });

        get("/demandes", (request, response) -> {
        	JSONObject obj = new JSONObject();
        	
        	for (Demande demande : demandes){
        		obj.append("id", demande.getID());
        		obj.append("question", demande.getQuestion());
        		obj.append("reponses", demande.getReponses());
        		obj.append("oui", demande.getOui());
        		obj.append("non", demande.getNon());
        	}
        	
        	String affichage;
        	
        	affichage = "<!DOCTYPE html>"+
        	"<html>"+
        	  "<head>"+
        	    "<title>Affichage des demandes</title>"+
        	    "<meta charset=\"utf-8\">"+
        	  "</head>"+
        	  "<body>"+
        	  "<ul>";
        	  for (Demande demande : demandes){
        		  affichage += "<li><a href=\"/demandes/" + demande.getID() + "\">" + demande.getQuestion() + "</a></li>";
        		  affichage += "<ul>";
        		  for (String rep : demande.getReponses()){
        			  affichage += "<li>" + rep + "</li>";
        		  }
        		  affichage += "</ul>";

        	  }
        	  affichage +="</ul>"+
        	  "</body>"+
        	"</html>";
        	  
        	  return affichage;
            //return obj.toString();
        });
        
        post("/demandes/:id", (request, response) -> {
        	
        	for (Demande demande : demandes){
        		if (demande.getID().equals(request.params(":id")))
        			if (request.queryParams("choix") == "oui")
        				demande.addOui();
        			else
        				demande.addNon();
        	}

        	return "veto";
        });
       
    }
}
