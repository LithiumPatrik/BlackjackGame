package com.LithiumPatrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackjackGame {

    private static final Random random = new Random();
    private static final double BAD_LUCK_PROBABILITY = 0.1;
    private static final double ULTRA_LUCK_PROBABILITY = 0.05;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        while (true) {
            List<Integer> deck = initializeDeck();
            List<Integer> playerHand = new ArrayList<>();
            List<Integer> dealerHand = new ArrayList<>();

            dealCard(playerHand, deck);
            dealCard(dealerHand, deck);
            dealCard(playerHand, deck);
            dealCard(dealerHand, deck);

            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer's hand: [" + dealerHand.get(0) + ", *]");

            boolean badLuck = isBadLuck();
            boolean ultraLuck = isUltraLuck();

            playPlayerTurn(playerHand, deck, scanner, badLuck);

            playDealerTurn(dealerHand, deck, badLuck);

            determineWinner(playerHand, dealerHand);

            if (ultraLuck) {
                System.out.println("Congratulations! Ultra luck strikes. You win automatically!");
            }

            if (!playAgain(scanner)) {
                break;
            }
        }

        scanner.close();
    }

    private static List<Integer> initializeDeck() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            deck.add(i);
        }
        return deck;
    }

    private static void dealCard(List<Integer> hand, List<Integer> deck) {
        int nextCardIndex = random.nextInt(deck.size());
        int nextCard = deck.remove(nextCardIndex);
        hand.add(nextCard);
    }

    private static void playPlayerTurn(List<Integer> playerHand, List<Integer> deck, Scanner scanner, boolean badLuck) {
        while (true) {
            System.out.println("Hit or stand? (h/s)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                int nextCardIndex = random.nextInt(deck.size());
                int nextCard = deck.remove(nextCardIndex);
                if (badLuck) {
                    System.out.println("Bad luck strikes. Your next card is reduced by 5.");
                    nextCard -= 5;
                }
                playerHand.add(nextCard);
                System.out.println("Your hand: " + playerHand);
                if (getHandValue(playerHand) > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid option! Please enter 'h' for hit or 's' for stand.");
            }
        }
    }

    private static void playDealerTurn(List<Integer> dealerHand, List<Integer> deck, boolean badLuck) {
        while (getHandValue(dealerHand) < 17) {
            int nextCardIndex = random.nextInt(deck.size());
            int nextCard = deck.remove(nextCardIndex);
            if (badLuck) {
                System.out.println("Dealer experiences bad luck. Their next card is reduced by 5.");
                nextCard -= 5;
            }
            dealerHand.add(nextCard);
        }
        System.out.println("Dealer's hand: " + dealerHand);
    }

    private static void determineWinner(List<Integer> playerHand, List<Integer> dealerHand) {
        int playerValue = getHandValue(playerHand);
        int dealerValue = getHandValue(dealerHand);
        if (playerValue > 21) {
            System.out.println("You bust! Dealer wins.");
        } else if (dealerValue > 21 || playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static int getHandValue(List<Integer> hand) {
        int value = 0;
        boolean hasAce = false;
        for (int card : hand) {
            if (card == 1) {
                hasAce = true;
            }
            value += Math.min(card, 10);
        }
        if (hasAce && value + 10 <= 21) {
            value += 10;
        }
        return value;
    }

    private static boolean isBadLuck() {
        return random.nextDouble() < BAD_LUCK_PROBABILITY;
    }

    private static boolean isUltraLuck() {
        return random.nextDouble() < ULTRA_LUCK_PROBABILITY;
    }

    private static boolean playAgain(Scanner scanner) {
        while (true) {
            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine();
            if (playAgain.equalsIgnoreCase("y")) {
                return true;
            } else if (playAgain.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid option! Please enter 'y' or 'n'.");
            }
        }
    }
}
