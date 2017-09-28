public class Sundae {
        
    public static int cost;
    public static String iceName;
    public static String topName;
    
    Sundae(String inIce, int inCostIce, String inTop, int inCostTop){
        iceName = inIce;
        topName = inTop;
        cost = (inCostIce) + (inCostTop);
    }
    
    
    public static int getCost(){
        return cost;
    }
}
