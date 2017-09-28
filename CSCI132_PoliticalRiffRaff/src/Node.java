public class Node {
    
    private Node next;
    private Node prev;
    private static int position;
    private static String job;
    
    public Node(int pos, Node innext, Node inprev){
        this.position = pos;
        this.next = innext;
        this.prev = inprev;
    }
    
    public void setNext(Node n){
        next = n;
    }
    
    public void setPrev(Node n){
        prev = n;
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