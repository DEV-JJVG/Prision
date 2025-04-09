/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izv.prision;

/**
 *
 * @author Hugo
 */
public class Cell {
    protected int cellID;
    protected Integer cellNumber;
    protected String location;
    protected Integer CellCapacity;

    public Cell(Integer cellNumber, String location, Integer CellCapacity) {
        setCellNumber(cellNumber);
        setLocation(location);
        setCellCapacity(CellCapacity);
    }

    //ATETION NEVER USE THIS CONTRUTOR, THE ID MUST BE AN AUTOINCREMENT
    //PLEASE DONT USE THIS THING IS FOR TESTS ONLY
    public Cell(int cellID, Integer cellNumber, String location, Integer CellCapacity) {
        this.cellID = cellID;
        setCellNumber(cellNumber);
        setLocation(location);
        setCellCapacity(CellCapacity);
    }
    
    
    
    //
    //
    //
    //getters

    public int getCellID() {
        return cellID;
    }

    public Integer getCellNumber() {
        return cellNumber;
    }

    public String getLocation() {
        return location;
    }

    public Integer getCellCapacity() {
        return CellCapacity;
    }
    
    //
    //
    //
    //setters

    public void setCellNumber(Integer cellNumber) {
        if (cellNumber > 0)
        this.cellNumber = cellNumber;
    }

    public void setLocation(String location) {
        if (!location.isBlank())
        this.location = location;
    }

    public void setCellCapacity(Integer CellCapacity) {
        if (CellCapacity > 0)
        this.CellCapacity = CellCapacity;
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
        return "the cell with the ID " + getCellID() + ", has the number " + 
                getCellNumber() + " is located in " + getLocation() + " and has a capacity of " + getCellCapacity() + " inmates";
    }
    
    


    
}
