// EditarClientes.java
// Definição da classe EditarClientes
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class EditarClientes implements ActionListener {
   private RotuloClientes fields;
   private JTextArea output;
   private Connection connection;

   public EditarClientes( Connection c, RotuloClientes f,
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

         if ( ! fields.id.getText().equals( "" ) ) {
            String query = "UPDATE addresses SET " +
                   "firstname='" + fields.first.getText() +
                   "', lastname='" + fields.last.getText() +
                   "', address='" + fields.address.getText() +
                   "', city='" + fields.city.getText() +
                   "', stateorprovince='" +
                   fields.state.getText() + 
                   "', postalcode='" + fields.zip.getText() +
                   "', country='" + fields.country.getText() +
                   "', emailaddress='" +
                   fields.email.getText() + 
                   "', homephone='" + fields.home.getText() +
                   "', faxnumber='" + fields.fax.getText() +
                   "' WHERE id=" + fields.id.getText();

            int result = statement.executeUpdate( query );
            
            if ( result == 1 )
                JOptionPane.showMessageDialog(
               null, "Registro alterado." , "Aviso",
               JOptionPane.PLAIN_MESSAGE );
            else {
               JOptionPane.showMessageDialog(
               null, "Falha na alteração!" , "Aviso",
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

            statement.close();
         }
         else
            JOptionPane.showMessageDialog(
            null, "\nUse Alterar somente quando\n  " +
                           "existim registros. Use Pesquisar para\n " +
                           "localizar um registro, então\n " +
                           "modifique a informação e\n " +
                           "pressione Alterar.\n" , "Aviso",
            JOptionPane.PLAIN_MESSAGE );
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
         JOptionPane.showMessageDialog(
         null, sqlex.toString(), "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }
   }
}


