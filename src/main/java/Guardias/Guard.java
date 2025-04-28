/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guardias;

import Exception.InvalidAgeException;
import izv.prision.Person;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Hugo
 */
public class Guard extends Person implements MandatoryTasks {

    enum CARGO {
        director,
        subdirector,
        securityCheif,
        captain,
        liutenant,
        sargeant,
        oficer,

    }

    public Guard(String name, Date born_date) throws InvalidAgeException {
        super(name, born_date);
    }
    //getters

    //
    //
    //
    //
    //setters
}
