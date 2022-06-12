// PesquisarClientes.java
// Definição da classe PesquisarClientes
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class PesquisarClientes implements ActionListener {
   private RotuloClientes fields;
   private JTextArea output;
   private Connection connection;

   public PesquisarClientes( Connection c, RotuloClientes f,
                      JTextArea o )
   {
      connection = c;
      fields     = f;
      output     = o;
   }

   public void actionPerformed( ActionEvent e )
   {
      try {
         if ( !fields.last.getText().equals( "" ) ) {
            Statement statement =connection.createStatement();
            String query = "SELECT * FROM addresses " +
                           "WHERE lastname = '" +
                           fields.last.getText() + "'";
            ResultSet rs = statement.executeQuery( query );
            display( rs );
            statement.close();
         }
         else
            fields.last.setText(
               "Digite o Sobrenome e aperte Pesquisar" );
      }
      catch ( SQLException sqlex ) {
         JOptionPane.showMessageDialog(
         null, sqlex.toString() + "" + 1 , "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }
   }

   // Exibe os resultados da consulta.
   public void display( ResultSet rs )
   {
      try {         
         rs.next();

         int recordNumber = rs.getInt( 1 );

         if ( recordNumber != 0 ) {
            fields.id.setText( String.valueOf( recordNumber));
            fields.first.setText( rs.getString( 2 ) );
            fields.last.setText( rs.getString( 3 ) );
            fields.address.setText( rs.getString( 4 ) );
            fields.city.setText( rs.getString( 5 ) );
            fields.state.setText( rs.getString( 6 ) );
            fields.zip.setText( rs.getString( 7 ) );
            fields.country.setText( rs.getString( 8 ) );
            fields.email.setText( rs.getString( 9 ) );
            fields.home.setText( rs.getString( 10 ) );
            fields.fax.setText( rs.getString( 11 ) );
         }
         else{
         JOptionPane.showMessageDialog(
         null, "Registro não encontrado!!" , "Aviso",
         JOptionPane.WARNING_MESSAGE );
         }
       }
      catch ( SQLException sqlex ) {
         JOptionPane.showMessageDialog(
         null, "Registro não encontrado!!" , "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }
   }
}


