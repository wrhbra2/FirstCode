// SalvarClientes.java
// Definição de classe SalvarClientes
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class SalvarClientes implements ActionListener {
   private RotuloClientes fields;
   private JTextArea output;
   private Connection connection;

   public SalvarClientes( Connection c, RotuloClientes f,
                     JTextArea o )
   {
      connection = c;
      fields     = f;
      output     = o;
   }

   public void actionPerformed( ActionEvent e )
   {
      try {
         Statement statement = connection.createStatement();

         if ( !fields.first.getText().equals( "" ) &&
              !fields.last.getText().equals( "" ) ) {
            String query = "INSERT INTO addresses (" +
               "firstname, lastname, address, city, " +
               "stateorprovince, postalcode, country, " +
               "emailaddress, homephone, faxnumber" +
               ") VALUES ('" +
               fields.first.getText() + "', '" + 
               fields.last.getText() + "', '" + 
               fields.address.getText() + "', '" + 
               fields.city.getText() + "', '" + 
               fields.state.getText() + "', '" + 
               fields.zip.getText() + "', '" + 
               fields.country.getText() + "', '" + 
               fields.email.getText() + "', '" + 
               fields.home.getText() + "', '" + 
               fields.fax.getText() + "')";

            int result = statement.executeUpdate( query );
               
            if ( result == 1 )
              JOptionPane.showMessageDialog(
              null, "A inseção foi um sucesso.", "Aviso",
              JOptionPane.PLAIN_MESSAGE );
            else {
              JOptionPane.showMessageDialog(
              null, "A inserção falhou!.", "Aviso",
              JOptionPane.WARNING_MESSAGE );

               fields.first.setText( "" );
               fields.last.setText( "" );
               fields.address.setText( "" );
               fields.city.setText( "" );
               fields.state.setText( "" );
               fields.zip.setText( "" );
               fields.country.setText( "" );
               fields.email.setText( "" );
               fields.home.setText( "" );
               fields.fax.setText( "" );
            }
         }
         else{
              JOptionPane.showMessageDialog(
              null, "\nDigite o Nome e\n" + "o Sobrenome e aperte\n" +
                   "o botão Salvar\n" , "Aviso",
              JOptionPane.WARNING_MESSAGE );

         statement.close();
         }
      }
      catch ( SQLException sqlex ) {
         JOptionPane.showMessageDialog(
         null, sqlex.toString(), "Aviso",
         JOptionPane.WARNING_MESSAGE );

      }
   }
}


