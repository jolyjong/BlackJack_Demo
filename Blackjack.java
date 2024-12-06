// Class: Blackjack
// Purpose: Main class used to play the card game Blackjack
// @author TAS
// @version November 2021

import java.util.Scanner;

public class Blackjack
{
    // deck of cards used for this game
    private Deck deck; 
    // arrays to hold the dealer's and player's hands
    private Card[] dealer; 
    private Card[] player;
    // indexes to keep track of cards in players hands
    private int playercardsinhands;
    private int dealercardsinhands;

    // keep track of win points for player
    private int playerwin;
    private int dealerwin;

    // number of rounds that have been played
    private int rounds; 
    // scanner used for keyboard input
    private Scanner kb;

    // constructor
    public Blackjack()
    {
        deck = new Deck(2);
        rounds = 0;
        playercardsinhands = 0; 
        dealercardsinhands = 0;
        playerwin = 0;
        dealerwin= 0;
        dealer = new Card[15];
        player = new Card[15];
        kb = new Scanner(System.in);
    }

    // "main" method in the class, used to play one complete round of Blackjack
    public void playRound()
    {

        dealer[dealercardsinhands++] = deck.dealCard(); // give each person one cards 
        player[playercardsinhands++] = deck.dealCard();
        System.out.println("dealer:" +  dealer[0]) ;
        System.out.print("player:" + player[0]);

        player[playercardsinhands++] = deck.dealCard(); //give each person another card
        dealer[dealercardsinhands++] = deck.dealCard();
        System.out.println("," + player[1] + "=" + getHandValue(player));
        if(getHandValue(player) == 21) // if player gets blackjack 
        {
            System.out.println("Congrats you got blackjack $$$ ");
            playerwin = playerwin + 2;
        }
        else{ // the code for if player does not get blackjack 
            System.out.println("player: what do you wanna do? (h)it or (s)tand?"); // ask the player for it's next move 
            String answer = kb.next();
            while(!(answer.equals("s"))&& !(answer.equals("h"))) // when the user wants to put in random things
            {
                System.out.println("pls read the question"); // makes them type the wanted answer 
                answer = kb.next();
            }
            while(answer.equals("h")) // when the player wants to hit 
            {
                player[playercardsinhands++] = deck.dealCard(); // give player another card 
                System.out.println("player:" + printHand(player) + "=" + getHandValue(player)); // print out the player's cards in hands 
                if(getHandValue(player) > 21) // when the player hits and bust 
                {
                    System.out.println("  player gg, dealer $$ " );
                    playerwin--;
                    break;
                }
                System.out.println("player: what do you wanna do? (h)it or (s)tand?"); // ask the player if they want to hit or stand 
                answer = kb.next(); // ask for player input again 
                while(!(answer.equals("s"))&& !(answer.equals("h"))) // when the user wants to put in random things
                {
                    System.out.println("pls read the question"); // makes them type the wanted answer 
                    answer = kb.next();// ask for user input again 
                }
            }
            if(answer.equals("s")) // when the player doens't want to hit again 
            {
                while(getHandValue(dealer) < 17) // dealer's hands is less than 17 
                {
                    dealer[dealercardsinhands ++] = deck.dealCard();
                }
                if(getHandValue(dealer) > 21) // if the dealer bust after they pulled a card 
                {
                    System.out.println("dealer:" + printHand(dealer) + "=" + getHandValue(dealer));
                    System.out.println(" dealer gg, player $$ " );
                    playerwin++;
                }
                else // if they don't bust after pulling a card it goes to the method checkWinner 
                {
                    checkWinner();
                }
            }
        }

        System.out.println("points:" + (playerwin));  // prints out player's points
        rounds++; // counts the rounds so it can shuffle after 4 rounds 
        if(rounds % 4 == 0 && rounds > 0) 
        {
            deck.shuffle();
            System.out.println(" wait, it's shuffling ");
        }
        resetHands(); // resets the player's cardsinhands 

    }

    // after a round, clear out the player/dealer hands
    public void resetHands()
    {
        playercardsinhands = 0; 
        dealercardsinhands = 0;
        dealer = new Card[15];
        player = new Card[15];
    }

    // return a nicely formatted string of the cards in a hand
    public String printHand(Card[] cards)
    {
        String out = "";
        for(int i = 0; i <cards.length ; i ++) 
        {
            if( cards[i] != null ) 
            {
                out += ( "" + cards[i]);
            }
        }
        return out;
    }

    // look at the current hands and determine a winner, and print it out
    public void checkWinner()
    {
        if(getHandValue(player)<getHandValue(dealer)) // when the player is less than the dealer 
        {
            System.out.println("dealer:" + printHand(dealer) + "=" + getHandValue(dealer));
            System.out.println("player lost -$$");
            playerwin--;

        }
        else if(getHandValue(player)>getHandValue(dealer)) // when the player is more than the dealer 
        {
            System.out.println("dealer:" + printHand(dealer) + "=" + getHandValue(dealer));
            System.out.println("player win $$$");
            playerwin++;
        }
        else if(getHandValue(player) == getHandValue(dealer)) // when the value of the player is the same as the dealer 
        {
            System.out.println("dealer:" + printHand(dealer) + "=" + getHandValue(dealer));
            System.out.println(" it's a tie" );
            playerwin = playerwin; 
        }
    }

    // calculate the value of a hand (handle aces correctly!)
    public int getHandValue(Card[] cards) // the sum of the value of the cards in hands 
    {
        int sum = 0;
        int ace = 0; // counts the aces 
        for( Card value : cards )
        {
            if( value != null )
            {
                if(value.getValue() == 11){ // when it goes through the array, when there is an ace it would count the aces 
                    ace++;
                }
                sum = sum + value.getValue() ; // get the total sum 
            }
        }
        while((sum > 21 ) && (ace >= 1)) // if there are aces in the hand and the sum is more than 21 it would change the aces into 1's
        {
            sum -= 10; 
            ace--;
        }

        return sum;
    }

}