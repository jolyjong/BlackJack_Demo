# Blackjack Game

This repository contains a console-based implementation of the classic card game Blackjack written in Java. The project includes functionality for simulating a two-player Blackjack game (dealer vs player), complete with game rules, card management, and score tracking.

## Table of Contents

- [How to Play](#howtoplay)
- [Respository Structure](#repositorystructure)
- [Getting Started](#gettingstarted)
- [Gameplay Features](#gameplayfeatures)
- [Acknowledgments](#acknowledgment)

## How to Play

- Blackjack is a card game where the goal is to have a hand value as close to 21 without exceeding it.
- The player competes against the dealer
  - Both the player and the dealer start with two cards
  - The player can choose to "hit" (draw another card) or "stand" (keep their current hand).
  - The dealer must draw cards until their hand value is at least 17.
- Aces can count as either 1 or 11, face cards are worth 10, and number cards are worth their face value.
- The player wins by:
  - Having a hand value closer to 21 than the dealer's
  - The dealer "busting" (hand value exceeding 21).
  - Achieving a "Blackjack" (exactly 21) on their first two cards. 

## Repository Structure
**Files**
- `Card.java`
  - Represents a single playing card with attributes for suit and face value
  - Determines the card's point value and provides utility methods like `toString()` for display.
- `Deck.java`
  - Models a deck of playing cards
  - Supports initalization with one or multiple decks, shuffling, and dealing cards.
- `Blackjack.java`
  - Implements the core gameplay logic:
    - Deals cards to the player and the dealer.
    - Handles player actions (hit or stand) and dealer rules.
    - Track points for wins and losses
    - Resets hands and shuffles the deck periodically
- `BlackjackRunner.java`
  - The main entry point for the game.
  - Manages game flow, including starting rounds and determining if the player wants to continue.

## Getting Started

**Requirements:**
- Java Development Kit (JDK) 8 or higher.

**Instructions:**
1. Clone the repository:
   ```bash
   git clone https://github.com/joljong/BlackJack_Demo
   ```
2. Compile the Java files:
      ```bash
   javac *.java
   ```
3. Run the game:
      ```bash
    java BlackjackRunner
   ```
4. Follow the on-screen prompts to play the game

## Gameplay Features
- **Interactive Console:** The game provides a text-based interface for player interaction
- **Realistic Rules:** Implements standard Blackjack rules, including: 
  - Dealer hitting until 17.
  - Aces being worth 1 or 11.
- **Score Tracking:** Track player wins and losses across multiple rounds
- **Dynamic Deck Shuffling:** Automatically reshuffles the deck every four rounds 

## Acknowledgment 
- Deck implementation by **Carlos Delgado**
