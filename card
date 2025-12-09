import java.util.*;

// by Deegan
// for software class project

 

public class Card {
    enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
        final int value;
        Rank(int v) { value = v; }
    }

    static class PlayingCard {
        final Suit suit;
        final Rank rank;
        PlayingCard(Suit s, Rank r) { suit = s; rank = r; }
        @Override public String toString() { return rank + " of " + suit; }
    }

    static class Deck {
        private final Deque<PlayingCard> cards = new ArrayDeque<>();
        Deck() {
            List<PlayingCard> list = new ArrayList<>();
            for (Suit s : Suit.values())
                for (Rank r : Rank.values())
                    list.add(new PlayingCard(s, r));
            Collections.shuffle(list);
            list.forEach(cards::addLast);
        }
        boolean isEmpty() { return cards.isEmpty(); }
        PlayingCard draw() { return cards.pollFirst(); }
        int size() { return cards.size(); }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Player name: ");
        String playerName = in.nextLine().trim();
        if (playerName.isEmpty()) playerName = "Player";

        String opponent = "Computer";
        Deck deck = new Deck();

        System.out.print("Number of rounds (default 10, max " + deck.size()/2 + "): ");
        String rInput = in.nextLine().trim();
        int maxRounds = deck.size() / 2;
        int rounds = 10;

        try {
            if (!rInput.isEmpty())
                rounds = Math.min(Math.max(Integer.parseInt(rInput), 1), maxRounds);
        } catch (NumberFormatException ignored) {}

        System.out.println("Starting " + rounds + " rounds. Press Enter to draw each round.");

        int scorePlayer = 0, scoreComp = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.print("\nRound " + i + " - press Enter to draw...");
            in.nextLine();

            PlayingCard c1 = deck.draw();
            PlayingCard c2 = deck.draw();

            if (c1 == null || c2 == null) {
                System.out.println("Deck is out of cards!");
                break;
            }

            System.out.println(playerName + " draws: " + c1);
            System.out.println(opponent + " draws: " + c2);

            int v1 = c1.rank.value;
            int v2 = c2.rank.value;

            if (v1 > v2) {
                System.out.println(playerName + " wins the round.");
                scorePlayer++;
            } else if (v2 > v1) {
                System.out.println(opponent + " wins the round.");
                scoreComp++;
            } else {
                System.out.println("Tie. No points awarded.");
            }

            System.out.println("Score: " + playerName + " " + scorePlayer +
                    " - " + opponent + " " + scoreComp);
        }

        System.out.println("\nFinal score: " + playerName + " " + scorePlayer +
                " - " + opponent + " " + scoreComp);

        if (scorePlayer > scoreComp) System.out.println(playerName + " wins the game!");
        else if (scoreComp > scorePlayer) System.out.println(opponent + " wins the game!");
        else System.out.println("The game is a tie.");

        in.close();
    }
}
