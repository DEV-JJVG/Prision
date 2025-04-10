/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izv.prision;

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
    protected ArrayList<String> regiones;

    public Prison(String name, String location, int capacity, ArrayList<Inmate> Inmates, HashMap<Guard, Integer> Guards, ArrayList<String> regiones) {
        setName(name);
        setLocation(location);
        setCapacity(capacity);
        setInmates(Inmates);
        setGuards(Guards);
        setRegiones(regiones);
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

    public ArrayList<String> getRegiones() {
        return regiones;
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

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            this.capacity = 1;
        }
    }

    public void setInmates(ArrayList<Inmate> inmates) {
        this.inmates = inmates;
    }

    public void setGuards(HashMap<Guard, Integer> guards) {
        this.guards = guards;
    }

    public void setRegiones(ArrayList<String> regiones) {
        for (String regione : regiones) {
            if (regione.isBlank()) {
                regiones.remove(regione);
            }
        }
        this.regiones = regiones;
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
                + " Inmates and " + getGuards().size() + " guards and the areas of the prison are:";
        for (String region : getRegiones()){
            phrase = "\n" + region;
        }
        return phrase;
    }

}
