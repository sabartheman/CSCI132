package csci132_linkedinlab;
import java.util.Scanner;

public class LinkedList {

    //the two points of a node.
    private Node first;
    private Node last;
    
    //user input variables here
    public static int uopt=0;
    public String suopt = "";
    
    
    public static Scanner scan = new Scanner(System.in);
    
        LinkedList(){
            first = null;
            last = null;
        }


    
        public void add(Node input){
            if(first == null){
                first = input;
                last = first;
                
            }else{
                last.setNext(input);
                last = last.getNext();
                
        }
            
        }
        public void printList(){
            Node iter = first;
            while( iter!= null){
                System.out.print("This node is " + iter.getName() + " and the id number is "+ iter.getId() + "\n");
                iter = iter.getNext();
            }
        
                
                }
        
        public void find(){
            Scanner scan1 = new Scanner(System.in);
            Node iter = first;
            int count = 0;
            String input;
            
            
            System.out.println("Which name would you like to look for");
        
            input = scan1.nextLine();
            
            while(iter != null){
                if(iter.getName().equals(input)){
                    System.out.println("Found!! The id of this Node is " + iter.getId() );
                    return;
                }else{
                    iter = iter.getNext();

                }
                
            }
            System.out.println("The search is now complete.");
        }
        
        
        public Boolean delete(String input){
            Node lag = first;
            Node iter = first;
            
            while(iter != null){
                if(input.equals(iter.getName())){
                    lag.setNext(iter.getNext());
                    iter.setNext(null);
                    //System.out.println("deleted");
                    return true;
                }else{
                    lag= iter;
                    iter = iter.getNext();
                }
            }
            return false;
        }
        
        public void clearList(){
            //possible recursive function for this?
            first = null;
        }

        public void que(){
        while(true){
            System.out.println();
            System.out.println("What would you like to do?\n");
            System.out.println("Press 1 to add item");
            System.out.println("Press 2 to print the list");
            System.out.println("Press 3 to search the list");
            System.out.println("Press 4 to delete item");
            System.out.println("Press 5 to clear the whole list");
            System.out.println("Press -1 to exit");

            suopt = scan.nextLine();
            System.out.println();

            if(suopt.equals("-1")){
                System.exit(0);
            }else if(suopt.equals("1")){
                System.out.println("adding item");
                System.out.println("Enter in a name for a Node");
                String inname = scan.nextLine();
                System.out.println("Enter in a id for this Node");
                int inId      = scan.nextInt();
                Node newNode = new Node(new Student(inId, inname));
                add(newNode);

            }else if(suopt.equals("2")){
                System.out.println("printing list");
                printList();

            }else if(suopt.equals("3")){
                find();

            }else if(suopt.equals("4")){
                System.out.println("Please type in the name of the Node you want distroyed");
                
                String input1 = scan.nextLine();
                
                delete(input1);

            }else if(suopt.equals("5")){
                clearList();
            }else{
                System.out.println("Please enter in a valid option.");
            }
        }
    }
}
