package sparkexample;

import static spark.Spark.*;

import java.util.*;

public class Questionnaire {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Demande> demandes = new ArrayList<Demande>();

	public static void main(String[] args) {

		setPort(80);

		get("/newdemande", (request, response) -> {

			return "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"utf-8\" />"
					+ "<title>Creation de demande</title>" + "</head>" + "<body>" + "<p>Creation de demande : </p>"
					+ "<form method=\"post\" action=\"/demandes\">" + "<p>"
					+ "<label for=\"description\">Description :</label>"
					+ "<input type=\"text\" name=\"description\" id=\"description\" />" + "<br />"
					+ "<label for=\"chargeutile\">Charge utile :</label>"
					+ "<input type=\"text\" name=\"chargeutile\" id=\"chargeutile\" />" + "<br />"
					+ "<label for=\"urlsioui\">URL si oui :</label>"
					+ "<input type=\"text\" name=\"urlsioui\" id=\"urlsioui\" />" + "<br />"
					+ "<label for=\"urlsinon\">URL si non :</label>"
					+ "<input type=\"text\" name=\"urlsinon\" id=\"urlsinon\" />" + "</p>"
					+ "<input type=\"submit\" value=\"Creer la demande\" />" + "</form>" + "<form action=\"/demandes\">"
					+ "<input type=\"submit\" value=\"Annuler\" />" + "</form>" + "</body>" +

					"</html>";
		});

		post("/demandes", (request, response) -> {

			String id = UUID.randomUUID().toString();
			String question = request.queryParams("description");
			String chargeutile = request.queryParams("chargeutile");
			String ouiadresse = request.queryParams("urlsioui");
			String nonadresse = request.queryParams("urlsinon");

			demandes.add(new Demande(id, question, chargeutile, ouiadresse, nonadresse));

			response.redirect("/demandes");

			return "";
		});

		get("/demandes", (request, response) -> {

			String affichage;

			affichage = "<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Affichage des demandes</title>"
					+ "<meta charset=\"utf-8\">" + "</head>" + "<body>" + "<form action=\"/newdemande\">"
					+ "<input type=\"submit\" value=\"Creer une demande\" />" + "</form>" + "<ul>";
			for (Demande demande : demandes) {
				affichage += "<li><a href=\"/demandes/" + demande.getID() + "\">" + demande.getQuestion() + "</a></li>";

			}
			affichage += "</ul>" + "</body>" + "</html>";
			return affichage;
		});

		get("/demandes/:id", (request, response) -> {

			Demande mydemande = null;

			for (Demande demande : demandes) {
				if (demande.getID().equals(request.params(":id")))
					mydemande = demande;
			}

			String affichage;

			if (!mydemande.getVote()) {
				affichage = "<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Affichage de la demande "
						+ mydemande.getQuestion() + "</title>" + "<meta charset=\"utf-8\">" + "</head>" + "<body>"
						+ "<form method=\"post\" action=\"/demandes/" + mydemande.getID() + "\">"
						+ "<input type=\"submit\" value=\"Accepter la demande\" />" + "</form>"
						+ "<form action=\"/demandes\">" + "<input type=\"submit\" value=\"Retour\" />" + "</form>"
						+ "</body>";
			} else {
				affichage = "<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Affichage de la demande "
						+ mydemande.getQuestion() + "</title>"
						+ "<meta http-equiv=\"refresh\" content=\"2; URL=/demandes\">" + "</head>" + "<body>"
						+ "<a> Vous avez deja vote. La redirection est en cours. </a>" + "</body>" + "</html>" + "<html>";
			}

			return affichage;
		});

		post("/demandes/:id", (request, response) -> {

			for (Demande demande : demandes) {
				if (demande.getID().equals(request.params(":id")))
					demande.setVote();
			}

			response.redirect("/demandes");

			return "";
		});

	}
}
