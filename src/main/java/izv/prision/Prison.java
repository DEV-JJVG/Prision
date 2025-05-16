/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izv.prision;

import Exception.InvalityCapacityException;
import Guardias.Guard;
import Inmate.Inmate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Hugo
 */
public class Prison {

    protected int prisonID;
    protected String name;
    protected String location;
    protected int capacity;
    protected ArrayList<Inmate> inmates;
    //the Integer represent the pay of the guard
    protected HashMap<Guard, Integer> guards;

    public Prison(String name, String location, int capacity, ArrayList<Inmate> Inmates, HashMap<Guard, Integer> Guards) throws InvalityCapacityException {
        setName(name);
        setLocation(location);
        setInmates(Inmates);
        setCapacity(capacity);
        setGuards(Guards);
    }

    public Prison(int prisonID, String name, String location, int capacity, ArrayList<Inmate> inmates, HashMap<Guard, Integer> guards) throws InvalityCapacityException{
        this.prisonID = prisonID;
        setName(name);
        setLocation(location);
        setInmates(inmates);
        setCapacity(capacity);
        setGuards(guards);
    }

    
    //
    //
    //
    //getters
    public int getPrisonID() {
        return prisonID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Inmate> getInmates() {
        return inmates;
    }

    public HashMap<Guard, Integer> getGuards() {
        return guards;
    }
    
    public String getNameid(){
        return getName() + ": " +  getPrisonID();
    }



    //
    //
    //
    //setters


    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            this.name = "no name";
        }
    }

    public void setLocation(String location) {
        if (!location.isBlank()) {
            this.location = location;
        } else {
            this.location = "no location";
        }
    }

    public void setCapacity(int capacity) throws InvalityCapacityException {
        
        if (inmates.size() < capacity) {
            this.capacity = capacity;
        } else {
            throw new InvalityCapacityException();
        }
    }

    //para el setter
    public void setInmates(ArrayList<Inmate> inmates) {
        this.inmates = inmates;
    }

    public void setGuards(HashMap<Guard, Integer> guards) {
        this.guards = guards;
    }


    //
    //
    //
    //metods
    
    //
    //
    //
    //toString

    @Override
    public String toString() {
        String phrase = "the Prison named " + getName() + " with the id " + getPrisonID() + " located in " + getLocation()
                + ".\nIt has a capacity of " + getCapacity() + ", and it currently has " + getInmates().size()
                + " inmates and " + getGuards().size() + " guards";

        return phrase;
    }

}
