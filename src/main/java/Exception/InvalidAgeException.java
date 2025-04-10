/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author Mañana
 */
public class InvalidAgeException extends Exception {

    public InvalidAgeException() {
        super("Error, invalid age introduced");
    }

    public InvalidAgeException(String message) {
        super(message);
    }
    
}
