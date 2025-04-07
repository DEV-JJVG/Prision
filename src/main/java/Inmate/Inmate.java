/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmate;

import izv.prision.Person;
import izv.prision.Visit;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Inmate extends Person {

    protected Date entrance_date;
    protected Date exit_date;
    protected boolean status;
    protected String felony;
    boolean reoffending = false;
    ArrayList<Visit> visits;

    public Inmate(Date entrance_date, Date exit_date, boolean status, String felony, ArrayList<Visit> visits, String name, Date born_date) {
        super(name, born_date);
        this.entrance_date = entrance_date;
        this.exit_date = exit_date;
        this.status = status;
        this.felony = felony;
        this.visits = visits;
    }

    public Date getEntrance_date() {
        return entrance_date;
    }

    public void setEntrance_date(Date entrance_date) {
        this.entrance_date = entrance_date;
    }

    public Date getExit_date() {
        return exit_date;
    }

    public void setExit_date(Date exit_date) {
        this.exit_date = exit_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFelony() {
        return felony;
    }

    public void setFelony(String felony) {
        this.felony = felony;
    }

    public boolean isReoffending() {
        return reoffending;
    }

    public void setReoffending(boolean reoffending) {
        this.reoffending = reoffending;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date) {
        this.born_date = born_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        //Terminar toString de las visitas
        for (Visit visit : visits) {
        }
        return super.toString() + "Entrance date: " + entrance_date + "Exit date: " + exit_date + "Status: " + status + "Felony: " + felony + "Visits: ";

    }

}
