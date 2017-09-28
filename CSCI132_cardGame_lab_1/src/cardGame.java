import java.util.Random;
//random class to randomly pick a card from the deck of 24 cards

public class cardGame {
    
    //dealer has the whole deck at the beginning of the game
    public static int[] dealer = new int[24];
    
    //each of the players originally have only 12 cards, once they start playing
    //the number of cards in each players hand changes.
    public static int[] player1 = new int[12];
    public static int[] player2 = new int[12];
    
    //if a player wins first round they get winning hand.
    public static int[] winningHand = new int[3];
    public static int[] potTop = new int[8];
    
    //a check to make sure that multiple commands dont spit out when the game ends
    public static int tie = 0;
    //variables to check stats
    public static int battleCount=0;
    public static int shuffleCount=0;
    public static int compareCount=0;
   
    //initialized static object object
    public static playerHand playerAlt = new playerHand();
    
    /*
    //debug variables to check different aspects of the game
    public static int[] playertemp = {6,7,8,9,11,12,13,14,15,16,17,18};
    public static int[] player2temp = {6,22,23,24,25,26,27,28,29,30,31,32};
    public static int[] winningpottemp = {6,8,9,11,6,22,23,24};
    */
    
    
    public static void main(String[] args) {
        
        //try statement to try and make sure that there weren't unseen errors
        try{
            //initializing objects for use later
            cardDeck cards = new cardDeck();
            System.out.println("Dealers Hand:");
            //fills the dealers deck with required cards
            cards.fillSection(dealer);
            
            //randomizes cards in dealers hand
            dealer = cards.scrambleDeck(dealer);
            System.out.println("Hand after scramble");
                for(int k = 0; k<24;k++){
                    System.out.print("[" + dealer[k] + "]");
                }System.out.println();
            
            //deal all cards to players so that each player has 12 cards
            dealPlayers();
            //starts the game, will play rounds until one player wins.
            playGame();
        
            
            
            /*
            //debug code for playing a tiebreaker
            //uses hand created arrays to make sure outcome is correct
            System.out.println("Player 1");
            for(int i=0; i<playertemp.length;i++){
                System.out.print("["+playertemp[i]+"]");
            }System.out.println("\nPlayer2: ");
            for(int i=0; i<playertemp.length;i++){
                System.out.print("["+player2temp[i]+"]");
            }System.out.println("\n");
            
            playerAlt.insertCardTie(player2temp, winningpottemp, 8);
            playerAlt.pullCard(playertemp,4);
            
            tieBreaker(playertemp, player2temp,8);
            */
            
        
        }
        //if at some point one of the methods tries to fill an array spot that
        //doesn't exist
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("fallin out of the array");
        }
        
    }
    //this method plays the game
    public static void playGame(){
        int i = 0;
        //both players compare their top card[0] and see who has the higher card
        while((player2.length>0) && (player1.length>0)){
            //for(int o =0;o<5;o++){
            i = playerAlt.compareCards(player1,player2,0);
            compareCount++;
            int[] winnings = new int[1];
            battleCount++;
            if(i==0){
                System.out.println("There has been a tie");
                tieBreaker(player1, player2, 8);
                
            }else if(i==1){
                System.out.println("Player 1 has won this round");
                winnings[0] = player2[0];
                player1 = playerAlt.insertCard(player1, winnings);
                player2 = playerAlt.pullCard(player2, 1);
                
            }else if(i==2){
                System.out.println("Player 2 has won this round");
                winnings[0] = player1[0];
                player2 = playerAlt.insertCard(player2, winnings);
                player1 = playerAlt.pullCard(player1, 1);

            }else{
                System.out.println("Game Over");

           }
        }
        //this if statement checks to see if player 1 has no cards in their deck if so player2 is declared winner
        if((player1.length == 0)&&(tie ==0)){
            System.out.println("Player 2 has won War.  Player 1 has run out of cards from playing round to round");
            System.out.println("There were "+battleCount+" battles in this game");
            System.out.println("There were "+compareCount+" compares and "+ shuffleCount+" shuffles(counting the initial and tiebreaker winning pot shuffle)");
            tie =1;
        }
        //this if statement checks to see if player2 has no cards in their deck if so player1 is declared winner
        if((player2.length == 0)&&(tie ==0)){
            System.out.println("Player 1 has won War.  Player 2 has run out of cards from playing round to round");
            System.out.println("There were "+battleCount+" battles in this game");
            System.out.println("There were "+compareCount+" compares and "+ shuffleCount+" shuffles(counting the initial and tiebreaker winning pot shuffle)");
            tie =1;
        }
    }
    
    
    //this function deals cards to each of the players in a random order.  
    public static void dealPlayers(){
        int l=0, m=0;
        //deals cards to each of the players after dealer has shuffled deck.        
        for(int i = 0;i<dealer.length;i++){
            if((i%2) == 0){
                player2[l] = dealer[i];
                l++;
                
//              System.out.println("you have dealt player2 when i="+i);
            }
            else if((i%2) == 1){
                player1[m] = dealer[i];
                m++;
//                System.out.println("you have dealt player1 when i="+i);
            }
            else{
                //shouldn't ever get here
                System.err.println("this shouldn't be possible, correct your logic");
            }
        }
        //shows the cards of each player to show that they have the same amount of cards per deck
        System.out.println("player 1 has: ");
        for(int j=0; j<12; j++){
            System.out.print("[" + player1[j] + "]");
        }
        System.out.println("\nPlayer 1 has "+player1.length+" in their hand."+"\n\nplayer 2 has: ");
        for(int k=0; k<12; k++){
            System.out.print("[" + player2[k] + "]");
        }
        System.out.println("\nPlayer 2 has " + player2.length +" in their hand.\n \n");
    }
    //potentially recursive function that will play tiebreaker until one of the players wins.  
    //If there is a another tiebreaker this function become recursive
    public static void tieBreaker(int[] winner, int[] loser, int winPot){
        //creates a array to store cards for a winner, only stays on one layer
        int[] winnings = new int[winPot];
        cardDeck cards = new cardDeck();
        
        //will check to see if there are no more cards
        if(player1.length < (winPot/2)){
            System.out.println("Player 2 has won the game. \nPlayer 1 has lost because they ran out of cards for tiebreaker\n \n");
            //sets a flag to alert program that a tie is the last round of the game.
            tie =1;
            System.out.println("There were "+battleCount+" battles in this game");
            System.out.println("There were "+compareCount+" compares and "+ shuffleCount+" shuffles(counting the initial and tiebreaker winning pot shuffle)");
            //will exit at this point.  There is no more program after this next line
            
            System.exit(0);
        }
        else if(player2.length < (winPot/2)){
            System.out.println("Player1 has won the game. \n Player 2 has lost because they ran out of cards for tiebreaker\n \n");
            tie =1;
            System.out.println("There were "+battleCount+" battles in this game");
            System.out.println("There were "+compareCount+" compares and "+ shuffleCount+" shuffles(counting the initial and tiebreaker winning pot shuffle)");
                    
            System.exit(0);
        }
        
        
        
        //stores cards into array for winner
        for(int i = 0; i<((winPot)/2);i++){
            winnings[i] = winner[i];
        }
        for(int j=0; j<((winPot)/2); j++){
            winnings[j+(((winPot)/2))] = loser[j];
        }
        
        //shuffle the winning pot before adding to the winners deck
        winnings = cards.scrambleDeck(winnings);
        shuffleCount++;
        
        /*
        //debug statements to check and see if the winning pot is correct
        
        for(int o=0;o<winPot;o++){
            System.out.print("["+winnings[o]+"]");
        }
        System.out.println("\n size of the winnings pot: "+winnings.length+"\n");
        */
        
        //if player 1 has a high value card then they get the winning array 
        //added to their cards and player 2 loses their cards
        if(winner[(winPot/2)-1] > loser[(winPot/2)-1]){
            System.out.println("Player 1 has won this round after tie");
            player1 = playerAlt.insertCardTie(winner, winnings, winPot);
            player2 = playerAlt.pullCard(loser,(winPot/2));
            compareCount++;
            return;

        }
        //if player 2 has a high value card then they get the winning array 
        //added to their cards and player 1 loses those cards
        else if(winner[(winPot/2)-1] < loser[(winPot/2)-1]){
            System.out.println("Player 2 has won this round after tie");
            player2 = playerAlt.insertCardTie(loser, winnings, winPot);
            player1 = playerAlt.pullCard(winner,(winPot/2));
            compareCount++;
            return;
        }
        else{
            System.out.println("There is another tie!!!");
            tieBreaker(winner,loser ,winPot+6);
            
        }
    }
}
