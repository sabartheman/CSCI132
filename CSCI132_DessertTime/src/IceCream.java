public class IceCream extends DessertItem{
    public static String name;
    public static int price;
    
    IceCream(String nameIn, int priceIn){
        name = nameIn;
        price = priceIn;
    }
    
    public int getCost(){
        return price;
    }

    
    
}
