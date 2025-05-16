/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guardias;

import Exception.InvalidAgeException;
import izv.prision.Person;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Guard extends Person {

    public enum CARGO {
        director,
        subdirector,
        securityCheif,
        captain,
        liutenant,
        sargeant,
        official,

    }
    
    private CARGO cargo;

    public Guard(String name, Date born_date, CARGO cargo) throws InvalidAgeException {
        super(name, born_date);
    }

    public Guard(CARGO cargo, String name, Date born_date) throws InvalidAgeException {
        super(name, born_date);
        this.cargo = cargo;
    }

    
    public Guard(CARGO cargo, String name, Date born_date, int id) throws InvalidAgeException {
        super(name, born_date, id);
        setCargo(cargo);
    }
    
    //getters
    public CARGO getCargo() {
        return cargo;
    }    
    
    public String getNamePositioId(){
       return getName() + " is a " + getCargo().name() + " and its Id is: " + getId(); 
    }
    

    //
    //
    //
    //
    //setters

    public void setCargo(CARGO cargo) {
        this.cargo = cargo;
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
        return "the guard named: " + getName() + " is a " + getCargo() +
                "\nit was born in " + getBorn_date() + " and its ID is " + getId(); 
    }
    

}
