package sparkexample;

public class Demande {
	private String id;
	private String question;
	private String chargeutile;
	private String ouiadresse;
	private String nonadresse;
	private boolean vote = false;
	
	public Demande (String id, String question, String chargeutile, String ouiadresse, String nonadresse)
	{
		this.id = id;
		this.question = question;
		this.chargeutile = chargeutile;
		this.ouiadresse = ouiadresse;
		this.nonadresse = nonadresse;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getChargeutile() {
		return this.chargeutile;
	}
	
	public String getOuiadresse() {
		return this.ouiadresse;
	}
	
	public String getNonadresse() {
		return this.nonadresse;
	}
	
	public boolean getVote() {
		return this.vote;
	}
	
	public void setVote() {
		vote = true;
	}
}
