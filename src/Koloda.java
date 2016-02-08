import java.util.ArrayList;
import java.util.Collections;

public class Koloda {

	//private Koloda koloda;
	ArrayList<Karta> al = new ArrayList<Karta>();
	private String masNameKarta[] = { "6", "7", "8", "9", "10", "B", "D", "K", "T" };
	private int priceKarta[] = { 6, 7, 8, 9, 10, 2, 3, 4, 11};
	private String masMast[] = { "♥", "♠", "♦", "♣"};
	

	public Koloda() {

	}

	//public Koloda getKoloda() {
	//	return koloda;
	//}

	//public void setKoloda(Koloda koloda) {
	//	this.koloda = koloda;
	//}

	public ArrayList<Karta> getAl() {
		return this.al;
	}

	//public void setAl(ArrayList<Karta> al) {
	//	this.al = al;
	//}

	public void createKoloda1() {
		for (int i = 0; i < masNameKarta.length; i++) {
			for (int j = 0; j < masMast.length; j++) {
				Karta karta = null;
				al.add(karta = new Karta(masNameKarta[i], masMast[j], priceKarta[i]));
			}
		}
	}

	public void mixKoloda() {
		Collections.shuffle(al);// разброс
	}

	public Karta getOne() {
		Karta karta = new Karta();
		for (int i = 0; i < al.size(); i++) {
			karta = al.get(i);
			al.remove(i);
			return karta;
		}
		return null;
	}

}
