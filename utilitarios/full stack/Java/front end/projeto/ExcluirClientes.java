// ExcluirClientes.java
// Definição da classe ExcluirClientes
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class ExcluirClientes implements ActionListener {
   private RotuloClientes fields;
   private JTextArea output;
   private Connection connection;

   public ExcluirClientes( Connection c, RotuloClientes f,
                      JTextArea o )
   {
      connection = c;
      fields     = f;
      output     = o;
   }

   public void actionPerformed( ActionEvent e )
   {
      try {
         if ( !fields.id.getText().equals( "" ) ) {
            Statement statement =connection.createStatement();
            String query = "DELETE FROM addresses " +
                           "WHERE firstname = '" +
                           fields.first.getText() + "'" + "AND lastname = '" +
                           fields.last.getText() + "'";

            statement.executeQuery( query );
            statement.close();

         }
         else
              JOptionPane.showMessageDialog(
              null, "É preciso ter um registro para apagar!!" , "Aviso",
              JOptionPane.WARNING_MESSAGE );
      }
      catch ( SQLException sqlex ) {
          JOptionPane.showMessageDialog(
         null, "Registro Apagado!!!", "Aviso",
         JOptionPane.PLAIN_MESSAGE );
      }
   }
 }


