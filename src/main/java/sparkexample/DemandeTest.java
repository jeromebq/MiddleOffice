package sparkexample;

import static org.junit.Assert.*;

import org.junit.Test;

class DemandeTest {

	@Test
	void demandeTest() {
		
		//Creation classe demande
		String[] reponses = {"Bleu", "Rouge", "Jaune", "Vert"};
		
		Demande demande = new Demande("94984984", "Quelle est votre couleur preferee ?", reponses);
		
		//Test de la methode getQuestion
		assertEquals(demande.getQuestion(), "Quelle est votre couleur preferee ?");
		
		//Test de la fonction getReponses
		assertEquals(demande.getReponses().length,4);
		assertEquals(demande.getReponses()[0], "Bleu");
		assertEquals(demande.getReponses()[1], "Rouge");
		assertEquals(demande.getReponses()[2], "Jaune");
		assertEquals(demande.getReponses()[3], "Vert");
		
	}

}
