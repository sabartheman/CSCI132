package csci132_linkedinlab;


public class Node{

    private Student stu;
    private Node next;
    
    public Node(Student s){
        stu = s;
        next = null;
    }
    
    public void setNext(Node n){
        next = n;
    }
    
    public Node getNext(){
        return next;
    }
    
    public String toString(){
        String combination = ("Student name: " + stu.getName()+ " and ID " + stu.getID());
        return combination;
    }
    
    public int getId(){
        return stu.getID();
    }
    
    public String getName(){
        return stu.getName();
    }
}
