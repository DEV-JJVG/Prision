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
public class VirtualTime {
    protected static Date vitualGlobalDate = new Date(125, 0, 1);

    public VirtualTime() {
    }
    
    //
    //
    //
    //getters
    
    public static Date getVitualGlobalDate() {
        return vitualGlobalDate;
    }

    //
    //
    //
    //setters
    public static void setVitualGlobalDate(Date vitualGlobalDate) {
        VirtualTime.vitualGlobalDate = vitualGlobalDate;
    }
    
    
}
