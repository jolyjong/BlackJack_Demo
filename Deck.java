/**
 * This Class represents a Deck and is meant to
 * show how to write code for larger projects.
 * 
 * @author Carlos Delgado
 * @version Nov 2021
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;
    private int numDecks;
    private int currentCard;

    // constructors
    public Deck()
    {
        this(0);
    }

    public Deck(int numDecks)
    {
        cards = new ArrayList<Card>();
        this.numDecks = numDecks;
        initializeDeck();
        currentCard = 0;
    }
 
    // add all 52 cards to the deck and then shuffle it
    public void initializeDeck()
    {
        // generate 52 cards for each deck requested
        for (int d = 0; d < numDecks; d++)
        {
            for(String suit: Card.SUITS)
            {
                for(int i = 1; i<Card.FACES.length; i++)
                {
                    cards.add(new Card(suit,i));
                }
            }
        }
        shuffle();
    }
    
    // get the deck's size
    public int size()
    {
        return cards.size();
    }
    
    // deal a card (return the top card)
    public Card dealCard()
    {
        // if we reached the end, go back to the beginning
        if (currentCard >= cards.size()) {
            currentCard = 0;
        }
        
        return cards.get(currentCard++);
    }
    
    // use Colletions.shuffle to randomly shuffle the cards
    // and then reset the top card 
    public void shuffle()
    {
        currentCard = 0;
        Collections.shuffle(cards);
    }
    
    public String toString()
    {
        return "currentCard="+ currentCard + ", cards:" + cards;
    }
}