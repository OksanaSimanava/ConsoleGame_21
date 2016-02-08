
public class Karta {
	private String masNameKarta = null;
	private int priceKarta = 0;
	private String masMast = null;


	private Karta karta;
	private String strNameKarta, strMasKarta, strKarta;

	public Karta() {
	}

	public Karta(String strNameKarta, String strMast, int price) {

		this.masNameKarta = strNameKarta;
		this.masMast = strMast;
		this.priceKarta = price;
	}

	public String toString() {
		return masNameKarta + masMast;
	}

	public int getPrice(Karta karta, boolean b) {
		this.karta = karta;
		if(karta.priceKarta == 11 && b == false){//дописать условие
			karta.priceKarta = 1;
		}
		return karta.priceKarta;
	}


}
