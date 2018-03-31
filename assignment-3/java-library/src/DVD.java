import collections.ArrayList;

/**
 * Denna klass beskriver ett DVD-objekt. Klassen har flera konstruktor som
 * instansierar objektet med olika startvärden. Man kan sätta titel, år, mediaId
 * och skådespelare. Man kan även returnera dessa värden. Klassen är subklass
 * till klassen Media och kan därmed använda alla dess metoder.
 * 
 * @author Danial Mahmoud
 *
 */
public class DVD extends Media {
	private String[] actors;

	public DVD() {

	}

	/**
	 * Skapar ett DVD-objekt
	 * 
	 * @param actors
	 * @param mediaId
	 * @param title
	 * @param year
	 */
	public DVD(String[] actors, String mediaId, String title, String year) {
		super(mediaId, title, year, false);
		this.actors = new String[actors.length];
		for (int i = 0; i < actors.length; i++) {
			this.actors[i] = actors[i];
		}
	}

	/**
	 * Denna konstruktor tar emot en ArrayList som innehåller mediaId, titel, år
	 * och lånestatus. Dessa värden ska tilldelas som startvärden till en
	 * instans av klassen. Eftersom antalet skådespelare kan variera måste man
	 * avgöra antalet genom att iterera genom listan från rätt position
	 * (position 3). Därefter kan objektet tilldelas skådespelararna i listan
	 * via anrop till metoden setActors.
	 * 
	 * @param list
	 */
	public DVD(ArrayList<String> list) {
		super(list.get(0), list.get(1), list.get(2), false);
		String[] actors;
		int nbrOfActors = 0;
		for (int i = 3; i < list.size(); i++) {
			if (list.get(i) != null)
				nbrOfActors++;
		}
		int k = 0;
		actors = new String[nbrOfActors];
		for (int i = 3; i < list.size(); i++) {
			if(list.get(i)!=null){
			actors[k] = list.get(i);
			}
			k++;
		}
		setActors(actors);
	}

	/**
	 * Jämför namnet name med ett skådespelarnamn i vektorn actors. Om namnet
	 * finns i listan så returneras det annars returneras null.
	 * 
	 * @param name
	 * @return skådespelarnamnet om den finns i objektet
	 */
	public boolean containsActor(String name) {
		for (int i = 0; i < actors.length; i++) {
			if (name.equals(actors[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metoden mottar en vektor med sträng-objekt som sedan förs över till
	 * vektor actors.
	 * 
	 * @param names
	 */
	public void setActors(String[] names) {
		actors = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			actors[i] = names[i];
		}
	}

	/**
	 * Returnerar en sträng-representation av antalet skådespelare som objektet
	 * har.
	 * 
	 * @return res (stränglista över antalet skådespelare)
	 */
	public String getActorsAsString() {
		String res = "";
		for (int i = 0; i < actors.length; i++) {
			if (i < actors.length - 1) {
				res += actors[i] + "\n";
			} else {
				res += actors[i];
			}
		}
		return res;
	}

	/**
	 * Returnerar en String-array med alla namnen på alla skådespelarna.
	 * 
	 * @return actors Alla skådespelare för denna DVD
	 */
	public String[] getActors() {
		return this.actors;
	}

	/**
	 * Returnerar en sträng-representation av objektets mediaId, titel, år,
	 * lånestatus och antal skådespelare.
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < actors.length; i++) {
			res += actors[i] + " ";
		}
		return super.toString() + " Skådespelare: " + res;

	}
}
