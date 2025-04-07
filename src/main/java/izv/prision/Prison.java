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
    protected ArrayList<Inmate> Inmates;
    protected HashMap<Guard,Integer> Guards;
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
        return Inmates;
    }

    public HashMap<Guard, Integer> getGuards() {
        return Guards;
    }

    public ArrayList<String> getRegiones() {
        return regiones;
    }
    
    //
    //
    //
    //setters


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setInmates(ArrayList<Inmate> Inmates) {
        this.Inmates = Inmates;
    }

    public void setGuards(HashMap<Guard, Integer> Guards) {
        this.Guards = Guards;
    }

    public void setRegiones(ArrayList<String> regiones) {
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
        return "Prison{" + "prisonID=" + prisonID + ", name=" + name + ", location=" + location + ", capacity=" + capacity + ", Inmates=" + Inmates + ", Guards=" + Guards + ", regiones=" + regiones + '}';
    }
    
}
