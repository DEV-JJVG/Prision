/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izv.prision;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Visit {

    private int visit_Id;
    private Date visit_Date;
    private String visitor;
    private String relationship;
    public int inmate_ID;


    public Visit(Date visit_Date, String visitor, String relationship, int inmate_ID) {
        setVisit_Date(visit_Date);
        setVisitor(visitor);
        setRelationship(relationship);
        this.inmate_ID = inmate_ID;
    }
    public Visit(Date visit_Date, String visitor, String relationship) {
        setVisit_Date(visit_Date);
        setVisitor(visitor);
        setRelationship(relationship);
    }
    //ATETION NEVER USE THIS CONTRUTOR, THE ID MUST BE AN AUTOINCREMENT
    //PLEASE DONT USE THIS THING IS FOR TESTS ONLY
    public Visit(int visit_Id, Date visit_Date, String visitor, String relationship, int inmate_ID) {
        this.visit_Id = visit_Id;
        setVisit_Date(visit_Date);
        setVisitor(visitor);
        setRelationship(relationship);
        this.inmate_ID = inmate_ID;
    }
    public Visit(int visit_Id, Date visit_Date, String visitor, String relationship) {
        this.visit_Id = visit_Id;
        setVisit_Date(visit_Date);
        setVisitor(visitor);
        setRelationship(relationship);
    }
    
    
    //
    //
    //
    //
    //getters

    public int getVisit_Id() {
        return visit_Id;
    }

    public Date getVisit_Date() {
        return visit_Date;
    }

    public String getVisitor() {
        return visitor;
    }

    public String getRelationship() {
        return relationship;
    }

    public int getInmate_ID() {
        return inmate_ID;
    }
    
    


    //
    //
    //
    //setters

    public void setVisit_Date(Date visit_Date) {
        this.visit_Date = visit_Date;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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
        return "the visit was made in " + getVisit_Date() + " its id is " + getVisit_Id() + 
                ", the visitor was " + getVisitor() + " and their relationship is: " + getRelationship()
                + "\nthe inmate ID was: " + getInmate_ID();
    }
    

}
