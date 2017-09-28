public class Candy extends DessertItem{
    public static int scost;
    public static String name;
    
    Candy(String inName, double inWeight, int inCostperlb){
        name = inName;
        double dcost = inCostperlb;
       
        dcost = (((inCostperlb)*inWeight)); //this is *100 large
        //System.out.print("cost of candy per pound " + dcost + " "+ inCostperlb); 
        scost = (int)dcost;
        
    }
    
    public int getCost(){
        //System.out.println("The cost of the candy is: " +scost);
        return scost;
    
    }
    
    
}
