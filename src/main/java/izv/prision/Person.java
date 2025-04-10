/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izv.prision;

import Exception.InvalidAgeException;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Person {
    protected String name;
    protected Date born_date;
    protected int id;

    public Person(String name, Date born_date) throws InvalidAgeException {
        setName(name);
        setBorn_date(born_date);
    }

    
    //ATETION NEVER USE THIS CONTRUTOR, THE ID MUST BE AN AUTOINCREMENT
    //PLEASE DONT USE THIS THING IS FOR TESTS ONLY
    public Person(String name, Date born_date, int id) throws InvalidAgeException {
        setName(name);
        setBorn_date(born_date);
        this.id = id;
    }

    

    //
    //
    //
    //getters
    public String getName() {
        return name;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public int getId() {
        return id;
    }
    
    public int getAge(){
        return VirtualTime.getVitualGlobalDate().getYear() - born_date.getYear();
    }

    //
    //
    //
    //setters
    public void setName(String name) {
        name.toUpperCase();
        this.name = name;
    }

    public void setBorn_date(Date born_date) throws InvalidAgeException {
        if (VirtualTime.getVitualGlobalDate().getYear() - born_date.getYear() > 0) {
            this.born_date = born_date;
        } else {
            throw new InvalidAgeException();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    //
    //
    //
    //methods
    
    //
    //
    //
    //toString
    @Override
    public String toString() {
        return "Person named " + getName() + " born in " + getBorn_date()
                + " with the id: " + getId();
    }

}

