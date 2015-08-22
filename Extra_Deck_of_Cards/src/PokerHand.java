import java.util.Collections;

@SuppressWarnings("JavaDoc")
public class PokerHand extends Deck {
    private HandRank handRank;
    private Rank sameKindRank1;
    private Rank sameKindRank2;

    public PokerHand(Deck fiveCards) {
        super(true);
        if (fiveCards.cardsRemaining() != 5) {
            throw new IllegalArgumentException();
        }
        setDeck(fiveCards.getDeck());
        sortCardsByRank();
        handRank = handRank();
    }

    public HandRank handRank() {
        if (isStraightFlush())
            return HandRank.STRAIGHT_FLUSH;
        if (isFourOfAKind())
            return HandRank.FOUR_OF_A_KIND;
        if (isFullHouse())
            return HandRank.FULL_HOUSE;
        if (isFlush())
            return HandRank.FLUSH;
        if (isStraight())
            return HandRank.STRAIGHT;
        if (isThreeOfAKind())
            return HandRank.THREE_OF_A_KIND;
        if (isTwoPair())
            return HandRank.TWO_PAIR;
        if (isOnePair())
            return HandRank.ONE_PAIR;
        return HandRank.HIGH_CARD;
    }

    /**
     * @param another
     * @return 1, win; -1, lose; 0, draw;
     */
    public int compareTo(PokerHand another) {
        int res = 0;
        int cmpHandRank = handRank.compareTo(another.handRank);
        if (cmpHandRank > 0) {
            res = 1;
        } else if (cmpHandRank < 0) {
            res = -1;
        } else {
            switch (handRank) {
                case HIGH_CARD:
                case STRAIGHT:
                case FLUSH:
                case STRAIGHT_FLUSH: {
                    for (int i = 0; i < getDeck().size(); i++) {
                        int tempRes = getDeck().get(i).compareToByRank(another.getDeck().get(i));
                        if (tempRes != 0) {
                            res = tempRes;
                            break;
                        }
                    }
                    break;
                }
                case FULL_HOUSE: {
                    res = getDeck().get(2).compareTo(another.getDeck().get(2));
                }
                break;

                case ONE_PAIR: {
                    if (sameKindRank1.compareTo(another.sameKindRank1) == 0) {
                        for (int i = 0; i < getDeck().size(); i++) {
                            int tempRes = getDeck().get(i).compareToByRank(another.getDeck().get(i));
                            if (tempRes != 0) {
                                res = tempRes;
                                break;
                            }
                        }
                    } else
                        res = sameKindRank1.compareTo(another.sameKindRank1);
                }

                case TWO_PAIR: {
                    if (sameKindRank1.compareTo(another.sameKindRank1) == 0) {
                        if (sameKindRank2.compareTo(another.sameKindRank2) == 0) {
                            for (int i = 0; i < getDeck().size(); i++) {
                                int tempRes = getDeck().get(i).compareToByRank(another.getDeck().get(i));
                                if (tempRes != 0) {
                                    res = tempRes;
                                    break;
                                }
                            }
                        } else
                            res = sameKindRank2.compareTo(another.sameKindRank2);
                    } else
                        res = sameKindRank1.compareTo(another.sameKindRank1);
                }

                case THREE_OF_A_KIND:
                case FOUR_OF_A_KIND: {
                    if (sameKindRank1.compareTo(another.sameKindRank1) == 0) {
                        for (int i = 0; i < getDeck().size(); i++) {
                            int tempRes = getDeck().get(i).compareToByRank(another.getDeck().get(i));
                            if (tempRes != 0) {
                                res = tempRes;
                                break;
                            }
                        }
                    } else
                        res = sameKindRank1.compareTo(another.sameKindRank1);
                }
            }
        }
        if (res > 0)
            res = 1;
        else if (res < 0)
            res = -1;
        return res;
    }

    private void sortCardsByRank() {
//        Collections.sort(getDeck(), new Comparator<Card>() {
//
//            @Override
//            public int compare(Card o1, Card o2) {
//                return -o1.compareTo(o2);
//            }
//        });
        Collections.sort(getDeck(), (o1, o2) -> -o1.compareTo(o2));
    }

    private boolean isStraightFlush() {
        return isStraight() && isFlush();
    }

    private boolean isFourOfAKind() {
        boolean res = false;
        int numAKind = 1;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToByRank(getDeck().get(i + 1)) != 0) {
                if (numAKind == 4) {
                    res = true;
                    sameKindRank1 = getDeck().get(i).getRank();
                }
                numAKind = 0;
            }
            numAKind++;
        }
        if (numAKind == 4) {
            res = true;
            sameKindRank1 = getDeck().get(getDeck().size() - 1).getRank();
        }
        return res;
    }

    private boolean isFullHouse() {
        boolean res;
        int numAKind = 1;
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToByRank(getDeck().get(i + 1)) != 0) {
                if (numAKind == 2) {
                    hasTwoOfAKind = true;
                } else if (numAKind == 3) {
                    hasThreeOfAKind = true;
                }
                numAKind = 0;
            }
            numAKind++;
        }
        if (numAKind == 2) {
            hasTwoOfAKind = true;
        } else if (numAKind == 3) {
            hasThreeOfAKind = true;
        }
        res = hasThreeOfAKind && hasTwoOfAKind;
        return res;
    }

    private boolean isFlush() {
        boolean res = true;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToBySuit(getDeck().get(i + 1)) != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean isStraight() {
        boolean res = true;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).getRank().compareTo(getDeck().get(i + 1).getRank()) != 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean isThreeOfAKind() {
        boolean res = false;
        int numAKind = 1;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToByRank(getDeck().get(i + 1)) != 0) {
                if (numAKind == 3) {
                    res = true;
                    sameKindRank1 = getDeck().get(i).getRank();
                }
                numAKind = 0;
            }
            numAKind++;
        }
        if (numAKind == 3) {
            res = true;
            sameKindRank1 = getDeck().get(getDeck().size() - 1).getRank();
        }
        return res;
    }

    private boolean isTwoPair() {
        boolean res;
        int numAKind = 1;
        boolean hasAPair = false;
        boolean hasAnotherPair = false;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToByRank(getDeck().get(i + 1)) != 0) {
                if (numAKind == 2) {
                    if (!hasAPair) {
                        hasAPair = true;
                        sameKindRank1 = getDeck().get(i).getRank();
                    } else {
                        hasAnotherPair = true;
                        sameKindRank2 = getDeck().get(i).getRank();
                    }
                }
                numAKind = 0;
            }
            numAKind++;
        }
        if (numAKind == 2) {
            if (!hasAPair) {
                hasAPair = true;
                sameKindRank1 = getDeck().get(getDeck().size() - 1).getRank();
            } else {
                hasAnotherPair = true;
                sameKindRank2 = getDeck().get(getDeck().size() - 1).getRank();
            }
        }
        res = hasAPair && hasAnotherPair;
        return res;
    }

    private boolean isOnePair() {
        boolean res = false;
        int numAKind = 1;
        for (int i = 0; i < getDeck().size() - 1; i++) {
            if (getDeck().get(i).compareToByRank(getDeck().get(i + 1)) != 0) {
                if (numAKind == 2) {
                    res = true;
                    sameKindRank1 = getDeck().get(i).getRank();
                }
                numAKind = 0;
            }
            numAKind++;
        }
        if (numAKind == 2) {
            res = true;
            sameKindRank1 = getDeck().get(getDeck().size() - 1).getRank();
        }
        return res;
    }

    public void showHand() {
        System.out.println("Hand:  " + handRank);
        for (int i = 0; i < getDeck().size(); i++) {
            System.out.println(getDeck().get(i).toString());
        }
        System.out.println();
    }
}
