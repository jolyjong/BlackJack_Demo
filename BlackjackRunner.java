// Class: BlackjackRunner
// Purpose: Runner class used to initiate and play blackjack
// @author TAS
// @version November 2021 updated 2024

import java.util.Scanner;

public class BlackjackRunner
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Blackjack!!");
        Blackjack bj = new Blackjack();
        Scanner kb = new Scanner(System.in);

        String y = "y"; 
        while(y.equals("y"))
        {
            bj.playRound();
            System.out.println("want to make more money ? yes(y) or no(n)?");
            y=kb.next();
            
            //makes sure player only inputs H and S 
            while(!y.equals("y") && !y.equals("n"))
            {
                System.out.println("pls choose yes(y) or no(n)"); 
                y=kb.next();
            }
            
        }

        // say bb 
        System.out.println("k bye");

        
    }
}
