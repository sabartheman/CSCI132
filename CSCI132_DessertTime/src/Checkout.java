public class Checkout {
    public static double tcost, ttax;
    public static int tnumber;
    
    Checkout(){
        //put some stuff here
    }

    //retrieves the cost of the cookies
    public static void enterItem(Cookie inCookie){
        tcost = tcost + ((double)inCookie.getCost()/100);
        tnumber++;
    }
    //retrieves the cost of the candy
    public static void enterItem(Candy inCandy){
        tcost = tcost + ((double)inCandy.getCost()/100);
        tnumber++;
    }
    //retrieves the cost of the icecream
    public static void enterItem(IceCream inIceCream){
        tcost = tcost + ((double)inIceCream.getCost()/100);
        tnumber++;
    }
    //retrieves the cost of the sunday
    public static void enterItem(Sundae inSundae){
        tcost = tcost + ((double)inSundae.getCost()/100);
        tnumber++;
    }
    //
    public static int numberOfItems(){
        return tnumber;
    }
    
    public static double totalCost(){
        
        return tcost;
    }
    
    public static double totalTax(){
        String stax = "";
        double tax = .065; //7% tax on items
        double sumtax =0, sumcost = 0;
        
        
        //getting tax and adding that to the total cost
        ttax = (tcost * tax);
        
        
        
        //returns a string 
        return ttax;
        
    }
    
    public static void clear(){
        tcost = 0;
        tnumber = 0;
        ttax = 0;
    }
    
}
