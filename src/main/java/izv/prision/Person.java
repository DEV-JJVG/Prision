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
        this.name = name;
        this.born_date = born_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name.toUpperCase();
        this.name = name;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date, Date current_date) throws InvalidAgeException {
        if (current_date.getYear() - born_date.getYear() > 0) {
            this.born_date = born_date;
        }
        else throw new InvalidAgeException();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", born_date=" + born_date + ", id=" + id + '}';
    }

}
