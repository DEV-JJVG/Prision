/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guardias;

import java.time.LocalTime;

/**
 *
 * @author Hugo
 */
public class Activity {
    String nombre;
    LocalTime inicio;
    LocalTime fin;

    public Activity(String nombre, LocalTime inicio, LocalTime fin) {
        setNombre(nombre);
        setInicio(inicio);
        setFin(fin);
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }
    
    //
    //
    //
    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
    
    
}
