/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesGraficas;

/**
 *
 * @author Mañana
 */
import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class InmateInterface1 extends javax.swing.JFrame {

    private javax.swing.JLabel bornDateLabel1;
    private javax.swing.JLabel bornDateLabel2;
    private javax.swing.JLabel bornDateLabel3;
    private javax.swing.JTextField addName;
    private javax.swing.JComboBox<String> estatusComboBox;
    private javax.swing.JLabel entranceDate;
    private javax.swing.JLabel exitDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel nameLabel;
    private JCalendar bornDateCalendar;
    private JCalendar entranceDateCalendar;
    private JCalendar exitDateCalendar;

    public InmateInterface1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        addName = new javax.swing.JTextField();
        exitDate = new javax.swing.JLabel();
        bornDateLabel1 = new javax.swing.JLabel();
        entranceDate = new javax.swing.JLabel();
        estatusComboBox = new javax.swing.JComboBox<>();
        bornDateLabel2 = new javax.swing.JLabel();
        bornDateLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Configurar los componentes
        nameLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        nameLabel.setText("Name");
        /*
        exitDate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exitDate.setText("Exit date");

        bornDateLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bornDateLabel1.setText("Born date");

        entranceDate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        entranceDate.setText("Entrance date");

        estatusComboBox.setMaximumRowCount(2);
        estatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Active", "Free"}));

        bornDateLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bornDateLabel2.setText("Felony description");

        bornDateLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bornDateLabel3.setText("Status");

        // Configurar el área de texto para la descripción del crimen
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        title.setText("Inmate creation formulary");

        // Botón Enviar
        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        // Crear instancias de JCalendar
        bornDateCalendar = new JCalendar();
        entranceDateCalendar = new JCalendar();
        exitDateCalendar = new JCalendar();

        // Agregar los calendarios al panel sin usar setBounds
        panel.setLayout(new GroupLayout(panel)); // Usando GroupLayout
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Agregar el título y otros componentes
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(175)
                                .addComponent(bornDateLabel1)
                                .addGap(50)
                                .addComponent(entranceDate)
                                .addGap(100)
                                .addComponent(exitDate)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addGap(175)
                                .addComponent(bornDateCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(entranceDateCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(exitDateCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(bornDateLabel1)
                                .addComponent(entranceDate)
                                .addComponent(exitDate)
                        )
                        .addGap(50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bornDateCalendar)
                                .addComponent(entranceDateCalendar)
                                .addComponent(exitDateCalendar)
                        )
        );
         */
        // Agregar otros componentes al panel
        panel.add(nameLabel);
        panel.add(addName);
        panel.add(estatusComboBox);
        panel.add(bornDateLabel2);
        panel.add(bornDateLabel3);
        panel.add(jScrollPane1);
        panel.add(botonEnviar);

        // Diseño del layout
        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout1);
        layout1.setHorizontalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout1.setVerticalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener los valores de los calendarios
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String bornDate = dateFormat.format(bornDateCalendar.getDate());
        String entranceDate = dateFormat.format(entranceDateCalendar.getDate());
        String exitDate = dateFormat.format(exitDateCalendar.getDate());

        // Obtener los valores de la interfaz gráfica
        String name = addName.getText();
        String status = (String) estatusComboBox.getSelectedItem();
        String crime = jTextArea1.getText();

        // Sentencia SQL
        String sql = "INSERT INTO inmates (name, born_date, entrance_date, exit_date, status, crime) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Establecer parámetros
            stmt.setString(1, name);
            stmt.setString(2, bornDate);
            stmt.setString(3, entranceDate);
            stmt.setString(4, exitDate);
            stmt.setString(5, status);
            stmt.setString(6, crime);

            // Ejecutar la consulta
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Inmate inserted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert inmate", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/prison";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InmateInterface1().setVisible(true);
            }
        });
    }

}
