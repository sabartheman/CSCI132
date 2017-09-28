public class Cookie {
    
    public static int cost;
    public static String name;
    
    
    Cookie(String inName, int inNumber, int inCost){
        double numcook = inNumber;
        double dcost = inCost;
        
        cost = (int)((numcook/12)*dcost);
        //debug statement to make sure that the correct value of cookies was calculated.
        //System.out.println("the cost of the cookies: " + cost);
        name = inName;
        
    }
    
    
    public int getCost(){
        return cost;
    }


    
}
