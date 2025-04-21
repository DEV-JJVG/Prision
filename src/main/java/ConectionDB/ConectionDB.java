/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Mañana
 */
public class ConectionDB {

    public class DatabaseConnection {

        public static Connection connect() throws Exception {
            // Parámetros de conexión (ajústalos según tu base de datos)
            String url = "jdbc:mysql://localhost:3306/prision"; // Cambia el nombre de la base de datos
            String user = "root";
            String password = "";

            // Establecer la conexión con la base de datos
            return DriverManager.getConnection(url, user, password);
        }

        public static void hacerConsulta() {
            // Consulta SQL
            String query = "SELECT inmate_ID, name, born_date, insertion_date, exit_date, status, crime, sentence FROM inmates";

            try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                // Procesar los resultados de la consulta
                while (rs.next()) {
                    int inmateId = rs.getInt("inmate_ID");
                    String name = rs.getString("name");
                    String bornDate = rs.getString("born_date");
                    String insertionDate = rs.getString("insertion_date");
                    String exitDate = rs.getString("exit_date");
                    String status = rs.getString("status");
                    String crime = rs.getString("crime");
                    String sentence = rs.getString("sentence");

                    // Mostrar los resultados
                    System.out.println("Inmate ID: " + inmateId);
                    System.out.println("Name: " + name);
                    System.out.println("Born Date: " + bornDate);
                    System.out.println("Insertion Date: " + insertionDate);
                    System.out.println("Exit Date: " + exitDate);
                    System.out.println("Status: " + status);
                    System.out.println("Crime: " + crime);
                    System.out.println("Sentence: " + sentence);
                    System.out.println("-------------------------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            // Realizar la consulta
            hacerConsulta();
        }
    }

}
