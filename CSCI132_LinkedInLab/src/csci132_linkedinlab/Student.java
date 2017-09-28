package csci132_linkedinlab;

public class Student {

    private static int id;
    private static String name;
    
    
    public Student(int inId, String inName){
        this.id = inId;
        this.name = inName;
    }
    //the name of hte student
    public String getName(){
        return name;
    }
    //id of student
    public int getID(){
        return id;
    }
    
    
    
}
