import java.util.ArrayList;

public class Test {
	private static final HandRank GOAL = HandRank.FULL_HOUSE;

	public static void main(String[] args) {
		int i = 0;
		while (true) {
			Deck deck = new Deck();
			deck.shuffle(3);
			ArrayList<Deck> hands = deck.dealHands(4, 5);
			PokerHand ph = new PokerHand(hands.get(0));
			PokerHand pha = new PokerHand(hands.get(1));
			i++;
			if (ph.handRank().compareTo(GOAL) >= 0 && pha.handRank().compareTo(GOAL) >= 0) {
				System.out.println("Times: " + i);
				ph.showHand();
				pha.showHand();
				System.out.println(ph.compareTo(pha));
				break;
			}

		}
	}
}
