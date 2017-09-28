public class Politician {
  
    int position;   //where they were placed in the ring
    public String job;
    
    Politician(){
     
    }
    public void setPos(int pos){
        position = pos;
        //when put into line the politician is waiting, hence
        job = "waiting";
    }
    
    public void setJob(String input){
        //when the politician is picked his/her role in life is assigned
        job = input;
    }
    
    public int getPosition(){            //returns the posistion number
        //while in line and the end should be the only time this is used.
        return position;
    }
    
    public String getJob(){
        //this shows what the current job of the politician is.
        return job;
    }
    
    
    
}