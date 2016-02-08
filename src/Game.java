import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	ArrayList<Karta> alHand = new ArrayList<Karta>();
	ArrayList<Karta> alBot = new ArrayList<Karta>();
	private int sumBot = 0;
	private int masSum[];
	int count = 0;

	Koloda koloda = new Koloda();
	Karta karta = new Karta();

	public Game() {

	}

	public void startGame() {

		koloda.createKoloda1();
		koloda.mixKoloda();
		System.out.println("введите количество игроков:");
		Scanner sc = new Scanner(System.in);
		int countPlayers = 0;
		if (sc.hasNextInt()) {
			countPlayers = sc.nextInt();
		}

		masSum = new int[countPlayers];

		while (countPlayers > count) {
			Hand hand = new Hand();
			alHand = new ArrayList<Karta>();
			handBegin(hand, true);

			System.out
					.println("если нужна еще карта, введите 1, если нет, введите 0");

			sc = new Scanner(System.in);
			int choise = 0;
			if (sc.hasNextInt()) {
				choise = sc.nextInt();
			}
			while (choise == 1) {
				handBegin(hand, true);
				System.out
						.println("если нужна еще карта, введите 1, если нет, введите 0");
				sc = new Scanner(System.in);
				if (sc.hasNextInt()) {
					choise = sc.nextInt();
				}
			}
			count++;
		}

		// for bot to show
		System.out.println("-------------------------------");
		Hand handBot = new Hand();
		alBot = new ArrayList<Karta>();
		handBegin(handBot, false);
		while (sumBot <= 17) {
			handBegin(handBot, false);
		}
		System.out.println("sumBot = " + sumBot + "	Bot: " + alBot);
		resultGame();
	}

	public void handBegin(Hand hand, boolean b) {
		if(b == true){//игрок
			if(alHand.isEmpty()){
				for (int i = 0; i < 2; i++) {
					karta = koloda.getOne();
					alHand.add(karta);
				}
			}
			else{
				karta = koloda.getOne();
				alHand.add(karta);
			}
			
			masSum[count] = hand.getSum(alHand);//.getSum();

			System.out.println("sum = " + masSum[count] + " игрок" + (count + 1)
					+ ":  " + alHand);
		}
		if(b == false){//если бот
			if(alBot.isEmpty()){
				for (int i = 0; i < 2; i++) {
					karta = koloda.getOne();
					alBot.add(karta);
				}
			}
			else{
				karta = koloda.getOne();
				alBot.add(karta);
			}
			sumBot = hand.getSum(alBot);
		}
	}
	
	public void resultGame() {
		System.out.println("-----------------------");
		int maxHand = 0;
		ArrayList<Integer> nomer = new ArrayList<Integer>();

		for (int i = 0; i < masSum.length; i++) {// выбрать максимальное
													// значение среди игроков
			if (masSum[i] >= maxHand && masSum[i] <= 21) {
				if (masSum[i] > maxHand && masSum[i] <= 21) {
					nomer.clear();
				}
				maxHand = masSum[i];
				nomer.add(i + 1);
			}
		}

		if ((maxHand <= 21 && sumBot > 21)
				|| (maxHand <= 21 && sumBot < 21 && maxHand > sumBot)) {
			System.out.println("выиграл(и) игрок(и)" + nomer);
		} else if(sumBot > 21 && maxHand > 21){
			System.out.println("компьютер выиграл");
		}else {
			System.out.println("компьютер выиграл");
		}
	}
}
