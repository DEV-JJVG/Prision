/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package izv.prision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author JJ y Hugo
 */
public class Prision {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(manualPersonCreator());
    }

    /*
    
    
    
    
    
    
    
    empty espace to make the main look prettier
    
    
    
    
    
    
    
    
    
    
     */
    //normal funtions
    //here there will be oall the funtions normaly used in the program
    /*
    
    
    
    
    
    
    
     */
    //manual creation of obgets,
    //here the will be funtions that will create obgets in the program itself, and with 
    //no prtections from erros, they will only be used to test the obgets
    //and are only meantto be used by the programer
    //the will be call manual to make clear what they do, other similar funtions
    //meants for the user will be call "user______" and will be put in the section above
    public static Cell manualCellcreation() {
        System.out.println("int cellID, Integer cellNumber, String location, Integer CellCapacity");
        int cellID = input.nextInt();
        int cellNumber = input.nextInt();
        input.nextLine();
        String location = input.nextLine();
        int cellCapacity = input.nextInt();
        Cell cell = new Cell(cellID, cellNumber, location, cellCapacity);
        System.out.println(cell);
        return cell;
    }

    public static Person manualPersonCreator() {
        System.out.println("String name, Date born_date (dd/MM/yyyy), int id");
        String name = input.nextLine();
        
        String date = input.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        
        int id = input.nextInt();
        
        try {
            Date born_date = format.parse(date);
            Person person = new Person(name, born_date, id);
            return person;
        } catch (ParseException e) {
            System.out.println("date format invalid.");
        }
        //in case it doesnt work I just placed a return with an error person 
        return new Person("error", new Date(125, 3, 10), 1);
    }

    /*
    
    
    
    
    
     */
    //automatic creation of obgets
    //here there will be funtions that will create obgets automaticly and ramdomly
    //they will be used when a valid obget is nededd and witch atributtes doesn't matter
}
