@SuppressWarnings("JavaDoc")
public class Card {

	private Suit suit;

	private Rank rank;

	public Card() {
	}

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	/**
	 * compare 2 cards by rank first, if same then by suit.
	 * 
	 * @param anotherCard
	 * @return -1, if this card is lesser than another card; 1, if this card is
	 *         greater than another card; 0, if two cards are same;
	 */
	public int compareTo(Card anotherCard) {
		int res = 42;
		int cmpRank = this.getRank().compareTo(anotherCard.getRank());

		if (0 > cmpRank) {
			res = -1;
		} else if (0 < cmpRank) {
			res = 1;
		} else if (0 == cmpRank) {
			int cmpSuit = this.getSuit().compareTo(anotherCard.getSuit());

			if (0 > cmpSuit) {
				res = -1;
			} else if (0 < cmpSuit) {
				res = 1;
			} else {
				res = 0;
			}
		}
		if (42 == res) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * compare 2 cards by suit first, if same then by rank.
	 * 
	 * @param anotherCard
	 * @return -1, if this card is lesser than another card; 1, if this card is
	 *         greater than another card; 0, if two cards are same;
	 */
	public int compareToBySuitRank(Card anotherCard) {
		int res = 42;
		int cmpSuit = this.getSuit().compareTo(anotherCard.getSuit());

		if (0 > cmpSuit) {
			res = -1;
		} else if (0 < cmpSuit) {
			res = 1;
		} else if (0 == cmpSuit) {
			int cmpRank = this.getRank().compareTo(anotherCard.getRank());

			if (0 > cmpRank) {
				res = -1;
			} else if (0 < cmpRank) {
				res = 1;
			} else {
				res = 0;
			}
		}
		if (42 == res) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * compare 2 cards by rank.
	 * 
	 * @param anotherCard
	 * @return -1, if this card is lesser than another card; 1, if this card is
	 *         greater than another card; 0, if two cards are same;
	 */
	public int compareToByRank(Card anotherCard) {
		int res = 42;
		int cmpRank = this.getRank().compareTo(anotherCard.getRank());

		if (0 > cmpRank) {
			res = -1;
		} else if (0 < cmpRank) {
			res = 1;
		} else if (0 == cmpRank) {
			res = 0;
		}
		if (42 == res) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * compare 2 cards by suit.
	 * 
	 * @param anotherCard
	 * @return -1, if this card is lesser than another card; 1, if this card is
	 *         greater than another card; 0, if two cards are same;
	 */
	public int compareToBySuit(Card anotherCard) {
		int res = 42;
		int cmpSuit = this.getSuit().compareTo(anotherCard.getSuit());

		if (0 > cmpSuit) {
			res = -1;
		} else if (0 < cmpSuit) {
			res = 1;
		} else if (0 == cmpSuit) {
			res = 0;
		}
		if (42 == res) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}// Card
