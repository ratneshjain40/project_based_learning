import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Card {
    private int rank;
    private int suit;
    private static String[] ranks = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King" };
    private static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int get_rank() {
        return rank;
    }

    public int get_suit() {
        return suit;
    }

    public String to_string() {
        return (ranks[this.rank] + " of " + suits[this.suit]);
    }
}

class Deck {
    private Card[] deck;
    private Card[] dealt_cards;

    Deck() {
        deck = new Card[52];
    }

    public void create_deck() {
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void deal_cards(int n) {
        if(deck == null)
        {
            System.out.println("Deck is empty!");
            return;
        }
        dealt_cards = new Card[n];
        int i = 0;
        while(i < n) {
            int temp_int = new Random().nextInt(52);
            Card temp_card = deck[temp_int];
            if (!Arrays.asList(dealt_cards).contains(temp_card)) {
                dealt_cards[i] = temp_card;
                i++;
            }
        }
        print_pack();
    }

    public void find_card() {
        if(deck == null)
        {
            System.out.println("Deck is empty!");
            return;
        }
        Card search_card = enter_card();
        for (Card card : dealt_cards) {
            if (card.get_rank() == search_card.get_rank() && card.get_suit() == search_card.get_suit()) {
                System.out.println(search_card.to_string() + " Card exists in pack !");
                return;
            }
        }
        System.out.println(search_card.to_string() + " Card does not exists in pack !");
    }

    public void compare_cards() {
        System.out.println("Enter card 1 :");
        Card card1 = enter_card();
        System.out.println("Enter card 2 :");
        Card card2 = enter_card();
        
        int card1_val = card1.get_rank() + card1.get_suit();
        int card2_val = card2.get_rank() + card2.get_suit();

        if (card1_val < card2_val) {
            System.out.println(card1.to_string() + " is greater than " + card2.to_string());
        } else if (card1_val > card2_val) {
            System.out.println(card1.to_string() + " is lesser than " + card2.to_string());
        } else {
            System.out.println(card1.to_string() + " is the same as " + card2.to_string());
        }

    }

    public Card enter_card() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter Rank 1 - 13 : ");
            int rank = Integer.parseInt(input.readLine());
            System.out.print("Enter Suit\n0 - Clubs\n2 - Diamonds\n3 - Hearts\n4 - Spades\n: ");
            int suit = Integer.parseInt(input.readLine());

            if (rank <= 13 && rank > 0 && suit <= 3 && suit >= 0) {
                return new Card(rank, suit);
            } else {
                System.out.println("Invalid Input !");
            }
        } catch (Exception e) {
            System.out.println("Invalid Input !");
        }
        return null;
    }

    public void sort_pack() {
        if(deck == null)
        {
            System.out.println("Deck is empty!");
            return;
        }
        Comparator<Card> comp = Comparator.comparing(Card::get_suit)
                .thenComparing(Comparator.comparing(Card::get_rank));
        Arrays.sort(dealt_cards, comp);
        print_pack();
    }

    public void print_pack() {
        if(deck == null)
        {
            System.out.println("Deck is empty!");
            return;
        }
        System.out.println("");
        System.out.println("Cards are :");
        for (Card card : dealt_cards) {
            System.out.println(card.to_string());
        }
    }

    public void finalize() throws Throwable
    {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
}

public class Cards {
    public static void main(String[] args) {
        Deck pack = new Deck();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Create Deck");
                System.out.println("2. Deal Cards");
                System.out.println("3. Sort Pack");
                System.out.println("4. Find Card");
                System.out.println("5. Compare Cards");
                System.out.println("6. Print Pack");
                System.out.println("7. Reset Pack");


                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    pack.create_deck();
                    System.out.println("Deck of 52 Cards Created!");
                    break;
                }

                case 2: {
                    pack.deal_cards(5);
                    break;
                }

                case 3: {
                    pack.sort_pack();
                    break;
                }

                case 4: {
                    pack.find_card();
                    break;
                }

                case 5: {
                    pack.compare_cards();
                    break;
                }

                case 6: {
                    pack.print_pack();
                    break;
                }

                case 7: {
                    pack = null;
                    System.gc();
                    TimeUnit.SECONDS.sleep(1);
                    pack = new Deck();
                    break;
                }

                default: {
                    loop = false;
                    break;
                }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!" + e.getMessage());
        }
    }
}