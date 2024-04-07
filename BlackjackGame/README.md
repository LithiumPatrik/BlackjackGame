# BlackjackGame

Welcome to BlackjackGame, a simple text-based implementation of the popular card game Blackjack in Java.

## Overview

This Java program simulates a game of Blackjack between a player and a dealer. The game is played using a standard 52-card deck, with cards valued from 1 to 10. Face cards (Jack, Queen, King) are not included in this version.

## How to Play

1. **Getting Started**: Run the `BlackjackGame` class to start the game.
   
2. **Gameplay**: The game proceeds as follows:
   - At the beginning of each round, both the player and the dealer are dealt two cards from the deck.
   - The player's cards are visible, while only one of the dealer's cards is visible to the player.
   - The player has the option to "hit" (receive another card) or "stand" (keep their current hand).
   - If the player's hand value exceeds 21 points, they bust and lose the round.
   - After the player's turn, the dealer reveals their hidden card and continues to draw cards until their hand value reaches 17 or higher.
   - The winner is determined based on the total value of their hand:
     - If a player's hand value exceeds 21, they lose.
     - If both the player and the dealer have hands with values below or equal to 21, the one with the highest hand value wins.
     - In case of a tie, the round is a draw.

3. **Special Features**:
   - **Luck Events**: The game includes two luck events: bad luck and ultra luck.
     - Bad Luck: There is a 10% chance of experiencing bad luck, where the value of the next card drawn is reduced by 5.
     - Ultra Luck: There is a 5% chance of experiencing ultra luck, where the player automatically wins the round.

4. **Play Again**: After each round, the player is prompted to play again. Enter 'y' to play another round or 'n' to exit the game.

## Developer Information

- **Developer**: LithiumPatrik
- **Language**: Java
- **Dependencies**: None

## Disclaimer

This program is a simplified version of Blackjack and is meant for educational purposes only. It does not include all the rules and features of a real casino Blackjack game. 

Enjoy playing BlackjackGame! If you have any feedback or suggestions, feel free to contact the developer.
