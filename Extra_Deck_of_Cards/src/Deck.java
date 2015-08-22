import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        newSorted52CardsDeck(this.deck);
    }

    public Deck(boolean empty) {
        this.deck = new ArrayList<>();
        if (!empty) {
            newSorted52CardsDeck(this.deck);
        }
    }

    @SuppressWarnings("unchecked")
    public Deck(Deck other) {
        if (other != null)
            this.deck = (ArrayList<Card>) other.deck.clone();
    }

    public int cardsRemaining() {
        return this.deck.size();
    }

    public void shuffle(int n) {
        if (this.deck.size() > 0 && n > 0)
            for (int i = 0; i < n; i++) {
                Collections.shuffle(this.deck);
            }
    }

    public Card dealCard() {
        Card res = null;
        if (this.deck.size() > 0)
            res = this.deck.remove(this.deck.size() - 1);
        return res;
    }

    public void addCard(Card c) {
        if (c != null)
            this.deck.add(0, c);
    }

    public ArrayList<Deck> dealHands(int numPlayers, int numCards) {
        int totalDealNum = numPlayers * numCards;
        if (totalDealNum > this.deck.size()) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<Deck> players = new ArrayList<>();
            for (int i = 0; i < numPlayers; i++) {
                players.add(new Deck(true));
            }

            int dealtNum = 0;
            while (totalDealNum > dealtNum) {
                for (int i = 0; i < numPlayers; i++) {
                    players.get(i).deck.add(this.dealCard());
                    dealtNum++;
                }
            }

            for (int i = 0; i < numPlayers; i++) {
                players.get(i).sortCards();
            }
            return players;
        }
    }

    private void newSorted52CardsDeck(ArrayList<Card> deck) {
        deck.clear();
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();
        for (int i = 3; i >= 0; i--) {
            for (int j = 12; j >= 0; j--) {
                Card card = new Card(ranks[j], suits[i]);
                deck.add(card);
            }
        }
    }

    private void sortCards() {
//        Collections.sort(this.deck, new Comparator<Card>() {
//
//            @Override
//            public int compare(Card o1, Card o2) {
//                return -o1.compareToBySuitRank(o2);
//            }
//        });
        Collections.sort(this.deck, (o1, o2) -> -o1.compareToBySuitRank(o2));
    }

    public void showCards() {
        System.out.println("Cards:");
        for (Card card : this.deck) {
            System.out.println(card.toString());
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

}// Deck
