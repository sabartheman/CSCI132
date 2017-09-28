public class cLinkedList {

    private static Node first,last;
    private int n= 0;
    public static int size;
    public static int sflag = 0; 
    public static boolean fflag = true;
   
    
///////////////////////////////
    /////private node class for the application in particular plus easier to 
    /////handle private variables.
private class Node {

    private Node next;
    private Node prev;
    private int position;
    private String job;
    
    public Node(int pos, Node innext, Node inprev){
        this.position = pos;
        this.next = innext;
        this.prev = inprev;
    }
    
    public void setNext(Node n){
        this.next = n;
    }
    
    public void setPrev(Node n){
        this.prev = n;
    }
    
    public Node getNext(){
        return next;
    }
    
    public Node getPrev(){
        return prev;
    }
    
    //to assign job after getting picked out of line. while in line this is "waiting"
    //two options "tarred" or "politician"
    public void setJob(String input){
        job = input;
    }
    
    public String getJob(){
        return job;
    }
    public int getPos(){
        return position;
    }
    
}
    
    ////////////////////////////////////////////
/////end of private node class ////////////////
    
    
    
    
    
    
    //initializes the first and last to be null
    public cLinkedList(){
        this.first = this.last = null;
    }
    //generates the line of politician hopefuls
    public void genline(){
        int fsize = size+1;
        for(int i = 1; i<fsize;i++){
            n++;
            if(fflag){
                addFirst(i);
                fflag=false;
            }
            else if(i<fsize-1){
                addLast(i);
            }else if(i == fsize-1){
                addLast(i);
                linkLast();
                //System.out.println("this is the last spot");
            }
            
        }
    }
    //adds the first node and can add onto the from like a stack
    public void addFirst(int i) {
        Node tmp = new Node(i, first, null);
        if(first != null ) {first.prev = tmp;}
        first = tmp;
        if(last == null) { last = tmp;}
        size++;
        //System.out.println("adding: "+i + " to the beginning");
    }
    //adds a node to the end of the list
    public void addLast(int i) {
         
        Node tmp = new Node(i, null, last);
        if(last != null) {last.next = tmp;}
        last = tmp;
        if(first == null) { first = tmp;}
        size++;
        //System.out.println("adding: "+i + " to the end");
    }
    
    
    //checks how many spots are left in the list
    public int isEmpty(){
        return n;
        
    }
    //this method moves clockwise around the list.
    public void removeThisc(int byebye){
        Node iter = first;
        int remove = byebye;
        int count = 0;
        while(iter != null){
            count++;
            if(iter.getPos() == byebye){
                //useless tarred set, the politician dissapears forever after this
                iter.setJob("tarred");
                System.out.print(iter.getPos() + " ");
                //need to make sure that this node completely dissapears
                Node temp = iter.getNext();
                iter =iter.getPrev();
                iter.setNext(temp);
                n--;
                return;
            }else if(count > n){
                //will handle if there is no position number on this line.
                remove = ((remove+1)%size);
                count = 0;
            }
            else{
                iter = iter.getNext();
            }
        }
    }
    //this method moved counter clockwise around the doublylinked list.
    public void removeThiscc(int byebye){
        Node iter = first;
        int remove = byebye;
        int count = 0;
        while(iter != null){
            count++;
            if(iter.getPos() == byebye){
                iter.setJob("tarred");
                System.out.println(iter.getPos() + " ");
                //need to make sure that this node completely dissapears
                Node temp = iter.getPrev();
                iter =iter.getNext();
                iter.setPrev(temp);
                n--;
                return;
            }else if(count > n){
                //to handle if there is no position number at this spot this will move the judge to the previous number
             if(remove <=1){
                 remove = remove + 9;
                 count = 0;
             }else{
                 remove--;
                 count = 0;
             }
            }else{
                iter = iter.getPrev();
            }
        }
    }
    
    
    public void removeThisTie(int byebye){
        Node iter = first;
        while(iter != null){
            if(iter.getPos() == byebye){
                iter.setJob("Politician");
                System.out.println("The Politician at spot "  + iter.getPos()+ "has been sent off for Sucess");
                Node temp = iter.getNext();
                iter = iter.getPrev();
                iter.setNext(temp);
                n--;
            }else{
                iter = iter.getNext();
            }
        }
    }
    
    //connectes the last node to the first after the line is filled.
    public static void linkLast(){
        last.setNext(first);
        first.setPrev(last);
    }
    //a simple method to print off the position of all the spots in order form first to last.
    public static void printList(){
        Node iter = first;
        int i = 1;
        while(iter != null){
        //for(int i = 0 ; i<6; i++){
            System.out.println("waiting");
            System.out.print(" and position is "+ iter.getPos() + "\n");
            iter = iter.getNext();
            }
    }
    //just takes in the size of the group for use in this class
    public static void setSize(int input){
        size = input;
    }

    
}
