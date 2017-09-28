/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci132_linkedinlab;

/**
 *
 * @author sabar
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LinkedList ll = new LinkedList();
        String[] names = {"Hunter", "Marge", "Homer","Bart","Lisa"};
        int[] ids = {0,1,2,3,4};
        for(int i = 0; i<names.length;i++){
            System.out.println("The name " + names[i] + " has been entered into the list \nassosiated with id number: " + ids[i]);
            ll.add(new Node(new Student(i,names[i])));
        }
        ll.printList();

        ll.que();
    }
    
}
