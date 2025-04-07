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
    private int inmate_id;
    private Person visitor;
    private String relationship;

    public Visit(Date visit_Date, int inmate_id, Person visitor, String relationship) {
        this.visit_Date = visit_Date;
        this.inmate_id = inmate_id;
        this.visitor = visitor;
        this.relationship = relationship;
    }

    public int getVisit_Id() {
        return visit_Id;
    }

    public void setVisit_Id(int visit_Id) {
        this.visit_Id = visit_Id;
    }

    public Date getVisit_Date() {
        return visit_Date;
    }

    public void setVisit_Date(Date visit_Date) {
        this.visit_Date = visit_Date;
    }

    public Person getVisitor() {
        return visitor;
    }

    public void setVisitor(Person visitor) {
        this.visitor = visitor;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getInmate_id() {
        return inmate_id;
    }

    public void setInmate_id(int inmate_id) {
        this.inmate_id = inmate_id;
    }

    
    @Override
    public String toString() {
        return "Visit{" + "visit_Id=" + visit_Id + ", visit_Date=" + visit_Date + ", inmate_id=" + inmate_id + ", visitor=" + visitor + ", relationship=" + relationship + '}';
    }
    
}
