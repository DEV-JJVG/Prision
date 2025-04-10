/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmate;

import Exception.InvalidAgeException;
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
    //true means he is currently being held
    protected boolean status;
    protected String felony;
    boolean reoffending = false;
    ArrayList<Visit> visits;

    public Inmate(Date entrance_date, Date exit_date, boolean status, String felony, ArrayList<Visit> visits, String name, Date born_date, Date current_date) throws InvalidAgeException {
        super(name, born_date);
        this.entrance_date = entrance_date;
        this.exit_date = exit_date;
        this.status = status;
        this.felony = felony;
        this.visits = visits;
    }

    //
    //
    //
    //getters
    public Date getEntrance_date() {
        return entrance_date;
    }

    public Date getExit_date() {
        return exit_date;
    }

    public boolean isStatus() {
        return status;
    }

    public String getFelony() {
        return felony;
    }

    public boolean isReoffending() {
        return reoffending;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    //
    //
    //
    //setters
    public void setEntrance_date(Date entrance_date) {
        this.entrance_date = entrance_date;
    }

    public void setExit_date(Date exit_date) {
        this.exit_date = exit_date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFelony(String felony) {
        this.felony = felony;
    }

    public void setReoffending(boolean reoffending) {
        this.reoffending = reoffending;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
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
        String phrase = "";
        phrase += "Inmate called " + getName() + " witch ID is " + getId() + "of age " + getAge()
                + "\nIt was introduced in " + getEntrance_date();

        if (isReoffending()) {
            phrase += "\nIt is a reoffending, ";
        } else {
            phrase += "\nIt is not a reoffending, ";
        }

        if (isStatus()) {
            phrase += "it is currently being held and he will be release " + getExit_date();
        } else {
            phrase += "it is not currently being held and was realised " + getExit_date();
        }

        phrase += "\nIt was sentences for:\n" + getFelony()+ "\n and it has been visited " + getVisits().size() + " times by:";

 
        if (getVisits().size() > 0) {
            for (Visit visit : getVisits()) {
                phrase += "\n" + visit.getVisitor().getName();
            }
        }else{
            phrase += "no one";
        }
        return phrase;
    }

}
