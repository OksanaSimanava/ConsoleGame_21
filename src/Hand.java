import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
	ArrayList<Karta> al = new ArrayList<Karta>();
	private int sum = 0;

	public Hand() {
	}

	public ArrayList<Karta> getAl() {
		return al;
	}

	public int getSum(ArrayList<Karta> al) {
		this.al = al;
		Karta karta = new Karta();
		sum = 0;
		int count = countTyz();
		//count = countTyz();
		for (int i = 0; i < al.size(); i++) {

			karta = al.get(i);
			sum += karta.getPrice(karta, true);
		}

		if(al.size() == 2 && sum == 22){
			return 21;
		}
		
		if (ifTyz(al) == true && sum > 21 ) {
			sum = 0;
			karta = null;
			for (int i = 0; i < al.size(); i++) {
				karta = al.get(i);
				if(count == 1){
					sum += karta.getPrice(karta, false);
				}else
					sum += karta.getPrice(karta, true);
			}
		}
		return sum;
	}

	public boolean ifTyz(ArrayList<Karta> al) {//если 2 туза не по порядку, доделать
		this.al = al;
		Karta karta = new Karta();
		for (int i = 0; i < al.size(); i++) {
			karta = al.get(i);
			if (karta.getPrice(karta, true) == 11) {
				return true;
			}
		}
		return false;
	}
	
	public int countTyz(){
		int countTyz = 0;
		Karta karta = new Karta();
		for (int j = 0; j < al.size(); j++) {
			karta = al.get(j);
			if(karta.getPrice(karta, true) == 1 || karta.getPrice(karta, true) == 11){
				countTyz ++;
			}
		}
		return countTyz;
	}
	
}
