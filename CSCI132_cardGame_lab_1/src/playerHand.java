public class playerHand {
    
    
    playerHand(){
        
    }
    
    //method to put new cards into the winner of a first round.
    public static int[] insertCard(int[] beforeHand, int[] newCards){
        int size = (beforeHand.length + newCards.length);
        int [] newHand = new int[(beforeHand.length + newCards.length)];
 
        //debug statements to check the size of the hand is what we want it to be.
        //System.out.println("size of hand + new cards: "+ size);
        // System.out.println("size of new hand variable: " + newHand.length);
        
        //adding the current hand to the array that is going to spit out of this function
        
        for(int i =1; i<beforeHand.length; i++){
            newHand[i-1] = beforeHand[i];
        }
        //adding new cards to the bottom of the deck. (end of the array)
        newHand[beforeHand.length-1] = beforeHand[0]; 
        for (int j=0; j<newCards.length;j++){
            newHand[(beforeHand.length+j)] = newCards[j];
        }
        
        // debug statement to make sure that the cards are being put into the hand of the player.
        System.out.println("The winners hand is now:");
        
        for(int k=0; k<newHand.length; k++){
            System.out.print("[" + newHand[k]+ "]");
        }
        System.out.print("     {"+newHand.length+"} cards");
        System.out.println();
        return newHand;
    }
    
    
    
    public static int[] insertCardTie(int[] beforeHand, int[] newCards,int potSize){
        int [] newHand = new int[(beforeHand.length + (potSize/2))];
 
        
        
        //debug statements to check the size of the hand is what we want it to be.
        //System.out.println("size of hand + new cards: "+ size);
        //System.out.println("size of new hand variable: " + newHand.length);
        
        //adding the current hand to the array that is going to spit out of this function
        for(int k=0;k<(beforeHand.length-(potSize/2));k++){
            //System.out.println(k);
            newHand[k] = beforeHand[((potSize/2))+k];
        }
        //adding the new cards to the winning hand array
        for(int j=0; j<newCards.length;j++){
            newHand[(beforeHand.length-(potSize/2))+j] = newCards[j];
        }
        
        
        /*
        //debug statements to make sure everything is correct
        System.out.println("BeforeHand length: "+beforeHand.length);
        System.out.println("newCards length: "+newCards.length);
        System.out.println("newHand length: " + newHand.length);
        System.out.println("size of the pot coming into the hand: "+potSize);
        */
        
        // debug statement to make sure that the cards are being put into the hand of the player.
        System.out.println("The winners hand is now:");
        for(int k=0; k<newHand.length; k++){
            System.out.print("[" + newHand[k]+ "]");
        }
        
        System.out.print("     {"+newHand.length+"} cards");
        System.out.println();
        return newHand;
    }
    
    
    public static int[] pullCard(int[] loser, int loss){
        int[] newHand = new int[(loser.length - loss)];
        for(int i = 0; i<(loser.length-loss); i++){
            newHand[i] = loser[i+loss];
        }
        
        System.out.println("the loser deck has been reduced to :");
        //System.out.println("[" + newHand.length + "]");
        for(int j =0; j<newHand.length;j++){
            System.out.print("[" + newHand[j]+"]");
        }
        System.out.print("     {"+newHand.length+"} cards");
        
        System.out.println("\n");
        return newHand;
    }
    
    
    //compares the first card of each player
    //will set flag to show which player has won the round
    public static int compareCards(int[] player1, int[] player2,int cardCompared){
        int winner = 0;
        //player 1 wins
        if(player1[cardCompared] > player2[cardCompared]){
            winner =1;
        }
        //player 2 wins
        else if(player1[cardCompared] < player2[cardCompared]){
            winner =2;    
        }
        //there is a tie
        else if(player1[cardCompared] == player2[cardCompared]){
            winner =0;
        }
        return winner;
    }
    
}
