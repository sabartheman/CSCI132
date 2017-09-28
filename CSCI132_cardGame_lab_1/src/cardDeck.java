import java.util.Random;
public class cardDeck {

    
    //when initialized this does nothing but initializes
    cardDeck(){
    }
    
    //used to fill the dealers hand with required cards
    //no suites seperating each card
    public void fillSection(int[] suite){
        int cardnumber = 0;
        //System.out.println("array position");
        for (int i=0; i<6; i++){
            for(int j =0; j<4; j++){
                //System.out.print(cardnumber + ", ");
                suite[cardnumber] = i+5;
                cardnumber++;
            }
        }
        //shows the cards that are in the dealers hand
        for(int i = 0; i<24;i++){
            System.out.print("[" + suite[i] + "]");
        }
        System.out.println();
    }
    
    //scrambles the cards of whatever deck in intered into the parameter
    public int[] scrambleDeck(int[] dealerHand){
        Random rando = new Random();
        int[] newHand = new int[dealerHand.length];
        int tempInt;
        for(int i=0; i<dealerHand.length;){
            tempInt = rando.nextInt(dealerHand.length);
            //checks the array with a number that isn't part of the game
            //used to scramble the deck around.  
            if(dealerHand[tempInt] != 666){
                newHand[i] = dealerHand[tempInt];
                dealerHand[tempInt] = 666;
                i++;
            }
        }
        //returns the scrambled hand
        return newHand;
    }   
}
