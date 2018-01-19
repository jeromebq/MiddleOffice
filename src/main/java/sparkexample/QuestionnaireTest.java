package sparkexample;

import static org.junit.Assert.*;

import org.junit.Test;

class QuestionnaireTest {

	@Test
	void test() {
		
		//Creation classe demande
		String[] reponses = {"Bleu", "Rouge", "Jaune", "Vert"};
				
		Demande demande = new Demande("Quelle est votre couleur preferee ?", reponses);
		
		//Creation classe questionnaire
		Questionnaire quest = new Questionnaire();
		
		quest.demandes.add(demande);
	}

}
