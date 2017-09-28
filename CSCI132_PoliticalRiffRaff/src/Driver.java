import java.util.Scanner;
import java.io.*;


public class Driver {
    ///variables for input from a text file.
    public static int N,countk,countj;
    //initializing a list to be used throughout this class
    public static cLinkedList list = new cLinkedList();
    
    
    public static void main(String[] args) {
    
        //method to scan designated file in this case this is init.txt
        fileScan();


        System.out.println("N = "+ N +", k = " + countk + ", j = "+countj);
        System.out.println("\nOutput (*See note below)\n------");
        //this tells the cLinkedList class the max size of the list from start to end.
        list.setSize(N);
        
        list.genline();
        //will print off the position numbers in order of first to last, but will loop
        //forever since this is a circular doubly linked list.
        //list.printList();
        
        //to test and see if the list is empty
        //this will increase as the loop iterates to move the judges to different positions
        int multiplier = 1;
        //this part checks to see if the doubly linked list is empty, if it isn't this will go into the while loop
        while(list.isEmpty()!= 0){
            //judge k will count k number of applicants from 1 clockwise (++)
            //some math to make sure that the selected spots can be scaled up.
            int ktie = ((countk*multiplier)%N);
            int jtie = ((countj*multiplier)%N);
            
            if(ktie == jtie){
                System.out.println("a politician has been selected");
                list.removeThisTie(ktie);
            }else{
                list.removeThisc(ktie);
                list.removeThiscc(N+1-jtie);
            }
            
            //the multiplyer increates
            multiplier++;
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //a simple function to scan the input file
    public static void fileScan(){
        boolean tflag = true, sflag = true;
        File file = new File("/home/sabar/NetBeansProjects/CSCI132_PoliticalRiffRaff/src/init.txt");
        //incase there is no file to read from
        try{
            Scanner scan = new Scanner(file);
            String tmp = "";
            /*
                N = scan.nextInt(); 
                countk = scan.nextInt();
                countj = scan.nextInt();
              */
            while(tflag){
                if(sflag){    
                    tmp = scan.nextLine();
                    sflag = false;
                }
                 
                String tmp1 = scan.nextLine();
                //to check and see if there are no more lines after
                if(tmp1.equals("0 0 0") &&!sflag){
                    String[] att = tmp.split(" ");

                    N = Integer.parseInt(att[0]);
                    countj = Integer.parseInt(att[1]);
                    countk = Integer.parseInt(att[2]);
                    tflag = false;
                }else{
                    tmp = tmp1;
                }
            }
                
        }
        //if there is no matching file this catch statement will go off
        catch(FileNotFoundException e){
            System.out.println("hey you need to add the file to the src directory");
            //the rest of the program isn't going to work so why not
            System.exit(0);
        }
    }
    
}
