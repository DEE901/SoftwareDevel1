import java.util.*;

// Deegan Hansen
// Software Class Project
// it took me all week to do
class Card {
    private String suit;
    private String rank;
    private boolean faceUp;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = false;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    @Override
    public String toString() {
        return faceUp ? (rank + " of " + suit) : "[Hidden]";
    }

    public String getShortName() {
        return faceUp ? (rank + suit.charAt(0)) : "??";
    }
}


class Deck {
    private List<Card> cards;

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7",
                          "8", "9", "10", "J", "Q", "K"};
        cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getRemainingCards() {
        return cards.size();
    }
}


class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    
    
      @param prompt 
      @param allowEmpty 
      @return 
     
    public String readString(String prompt, boolean allowEmpty) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (!allowEmpty && input.isEmpty()) {
                    System.out.println("❌ Input cannot be empty. Please try again.");
                    continue;
                }

                return input;
            } catch (Exception ex) {
                System.out.println("❌ Error reading input: " + ex.getMessage());
            }
        }
    }

    
     
      @param prompt 
      @param minValue 
      @param maxValue 
      @return 
    
    public int readInteger(String prompt, int minValue, int maxValue) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("❌ Input cannot be empty. Please enter a number.");
                    continue;
                }

                int value = Integer.parseInt(input);

                if (value < minValue || value > maxValue) {
                    System.out.println("❌ Please enter a number between " + minValue + " and " + maxValue + ".");
                    continue;
                }

                return value;
            } catch (NumberFormatException ex) {
                System.out.println("❌ Invalid input! Please enter a valid integer.");
            } catch (Exception ex) {
                System.out.println("❌ Error: " + ex.getMessage());
            }
        }
    }

    
     
      @param prompt 
      @return 
     
    public boolean readYesNo(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " (yes/no): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("yes") || input.equals("y")) {
                    return true;
                } else if (input.equals("no") || input.equals("n")) {
                    return false;
                } else {
                    System.out.println("❌ Please enter 'yes' or 'no'.");
                }
            } catch (Exception ex) {
                System.out.println("❌ Error: " + ex.getMessage());
            }
        }
    }

    
     
     
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}


class Game {
    private Deck deck;
    private List<Card> pile;
    private List<Card> foundation;
    private String playerName;
    private int moveCount;
    private int score;

    public Game(String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        this.playerName = playerName;
        this.deck = new Deck();
        this.pile = new ArrayList<>();
        this.foundation = new ArrayList<>();
        this.moveCount = 0;
        this.score = 0;

        for (int i = 0; i < 7; i++) {
            Card c = deck.drawCard();
            if (c != null) {
                c.flip();
                pile.add(c);
            }
        }
    }

    public void drawAndAddToPile() {
        Card c = deck.drawCard();
        if (c != null) {
            c.flip();
            pile.add(c);
        } else {
            System.out.println("No more cards in deck!");
        }
    }

    public boolean removeCardFromPile(int index) {
        if (index < 0 || index >= pile.size()) {
            return false;
        }
        pile.remove(index);
        moveCount++;
        score += 10;
        return true;
    }

    public boolean moveCardToFoundation(int pileIndex) {
        if (pileIndex < 0 || pileIndex >= pile.size()) {
            return false;
        }
        Card card = pile.remove(pileIndex);
        foundation.add(card);
        moveCount++;
        score += 25;
        return true;
    }

    public void displayGameState() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  " + playerName + "'s Solitaire Game");
        System.out.println("=".repeat(50));
        System.out.println("Moves: " + moveCount + " | Score: " + score);
        System.out.println("Deck remaining: " + deck.getRemainingCards() +
                           " | Foundation: " + foundation.size() + " cards");
        System.out.println("\nPile (Current Cards):");
        if (pile.isEmpty()) {
            System.out.println("  [Empty]");
        } else {
            for (int i = 0; i < pile.size(); i++) {
                System.out.println("  [" + i + "] " + pile.get(i));
            }
        }
        System.out.println("=".repeat(50));
    }

    public boolean isGameOver() {
        return pile.isEmpty() || (deck.isEmpty() && pile.size() < 2);
    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Card> getPile() {
        return new ArrayList<>(pile);
    }
}

public class SolitaireGame {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Game game = null;

        try {
            
            System.out.println("\n╔══════════════════════════════════════════════════════╗");
            System.out.println("║          WELCOME TO JAVA SOLITAIRE CARD GAME          ║");
            System.out.println("╚══════════════════════════════════════════════════════╝\n");

            
            String playerName = inputHandler.readString("Enter your name: ", false);

            System.out.println("\n✓ Welcome, " + playerName + "! Initializing game...\n");

            
            game = new Game(playerName);
            game.displayGameState();

            
            while (!game.isGameOver()) {
                System.out.println("\nMenu Options:");
                System.out.println("  1. Draw card from deck");
                System.out.println("  2. Remove card from pile");
                System.out.println("  3. Move card to foundation");
                System.out.println("  4. View current game state");
                System.out.println("  5. Quit game");

            
                int choice = inputHandler.readInteger("\nEnter your choice (1-5): ", 1, 5);

                switch (choice) {
                    case 1:
                        game.drawAndAddToPile();
                        System.out.println("✓ Drew a new card!");
                        break;

                    case 2:
                        if (game.getPile().isEmpty()) {
                            System.out.println("❌ No cards in pile to remove!");
                        } else {
                            
                            int maxIndex = game.getPile().size() - 1;
                            int index = inputHandler.readInteger(
                                "Enter card index (0-" + maxIndex + "): ",
                                0,
                                maxIndex
                            );
                            if (game.removeCardFromPile(index)) {
                                System.out.println("✓ Card removed successfully!");
                            }
                        }
                        break;

                    case 3:
                        if (game.getPile().isEmpty()) {
                            System.out.println("❌ No cards in pile!");
                        } else {
                            int maxIndex = game.getPile().size() - 1;
                            int index = inputHandler.readInteger(
                                "Enter card index to move to foundation (0-" + maxIndex + "): ",
                                0,
                                maxIndex
                            );
                            if (game.moveCardToFoundation(index)) {
                                System.out.println("✓ Card moved to foundation!");
                            }
                        }
                        break;

                    case 4:
                        game.displayGameState();
                        break;

                    case 5:
                        
                        if (inputHandler.readYesNo("Are you sure you want to quit?")) {
                            System.out.println("\n✓ Game ended!");
                            displayFinalStats(game);
                            return;
                        }
                        break;
                }

                game.displayGameState();
            }

        
            System.out.println("\n🎮 Game Over!");
            displayFinalStats(game);

        } catch (IllegalArgumentException ex) {
            System.out.println("❌ Invalid input: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("❌ An unexpected error occurred: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            inputHandler.close();
        }
    }
     
     
    private static void displayFinalStats(Game game) {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║                  FINAL STATISTICS                    ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ Player: " + String.format("%-47s", game.getPlayerName()) + "║");
        System.out.println("║ Total Moves: " + String.format("%-43d", game.getMoveCount()) + "║");
        System.out.println("║ Final Score: " + String.format("%-43d", game.getScore()) + "║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
    }
}