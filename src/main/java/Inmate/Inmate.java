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
    protected String status;
    protected String felony;
    ArrayList<Visit> visits;

    public Inmate(Date entrance_date, Date exit_date, String status, String felony,
            ArrayList<Visit> visits, String name, Date born_date) throws InvalidAgeException {
        super(name, born_date);
        setEntrance_date(entrance_date);
        setExit_date(exit_date);
        setStatus(status);
        setFelony(felony);
        setVisits(visits);
    }
    public Inmate(Date entrance_date, Date exit_date, String status, 
            String name, Date born_date, int id) throws InvalidAgeException {
        super(name, born_date, id);
        setEntrance_date(entrance_date);
        setExit_date(exit_date);
        setStatus(status);
        setFelony(felony);
        setVisits(visits);
    }

    //ATETION NEVER USE THIS CONTRUTOR, THE ID MUST BE AN AUTOINCREMENT
    //PLEASE DONT USE THIS THING IS FOR TESTS ONLY
    public Inmate(Date entrance_date, Date exit_date, String status, String felony,
            ArrayList<Visit> visits, String name, Date born_date, int id) throws InvalidAgeException {
        super(name, born_date, id);
        setEntrance_date(entrance_date);
        setExit_date(exit_date);
        setStatus(status);
        setFelony(felony);
        setVisits(visits);
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

    public String getStatus() {
        return status;
    }

   

    public String getFelony() {
        return felony;
    }



    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public int getTimeInPrison() {
        return getExit_date().getYear() - getEntrance_date().getYear();
    }

    //
    //
    //
    //setters
    public void setEntrance_date(Date entrance_date) throws InvalidAgeException {
        if (entrance_date.getYear() - born_date.getYear() > 16) {
            this.entrance_date = entrance_date;
        } else {
            throw new InvalidAgeException("Error, it was sent to prison while been a minor or before been born");
        }

    }

    public void setExit_date(Date exit_date) throws InvalidAgeException {
        if (exit_date.getTime() > entrance_date.getTime()) {
            this.exit_date = exit_date;
        } else {
            throw new InvalidAgeException("Error, it was sent to get out of prison before he got in");
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFelony(String felony) {
        if (!felony.isBlank()) {
            this.felony = felony;
        } else {
            this.felony = "it did something very bad";
        }
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
        phrase += "Inmate called " + getName() + " witch ID is " + getId() + " of age " + getAge()
                + "\nIt was introduced in " + getEntrance_date();

        if (getStatus().equalsIgnoreCase("active")) {
            phrase += "it is currently being held and he will be release " + getExit_date();
        } else {
            phrase += "it is not currently being held and was realised " + getExit_date();
        }

        phrase += "(Time in prison: " + getTimeInPrison() + ")\nIt was sentences for:\n"
                + getFelony() + "\n and it has been visited " + getVisits().size() + " times by:";

        if (getVisits().size() > 0) {
            for (Visit visit : getVisits()) {
                phrase += "\n" + visit.getVisitor();
            }
        } else {
            phrase += "no one";
        }
        return phrase;
    }

}
