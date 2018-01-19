package sparkexample;

import org.junit.Test;

class QuestionnaireTest {

	@Test
	void test() {
		
		//Creation classe demande
		String[] reponses = {"Bleu", "Rouge", "Jaune", "Vert"};
				
		Demande demande = new Demande("6546884", "Quelle est votre couleur preferee ?", reponses);
		
		//Creation classe questionnaire
		Questionnaire quest = new Questionnaire();
		
		quest.demandes.add(demande);
	}

}
