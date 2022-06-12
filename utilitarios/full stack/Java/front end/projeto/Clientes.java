// Clientes.java
// Inserindo, atualizando e pesquisando dados em um banco de dados
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class Clientes extends JFrame {
   private BotoesPainel controls;
   private RotuloClientes scrollArea;
   private JTextArea output;
   private String url;
   private Connection connect;
   private JScrollPane textpane;

   public Clientes()
   {
      super( "Aplica��o de Banco de Dados de Agenda de Endere�os" );

      Container c = getContentPane();

      // Inicia o layout da tela
      scrollArea = new RotuloClientes();
      c.setLayout( new BorderLayout() );
      c.add( new JScrollPane( scrollArea ),
             BorderLayout.CENTER );

      // Configura a conex�o de banco de dados
      try {
         url = "jdbc:odbc:AddressBook";
         Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
         connect = DriverManager.getConnection( url );
      }
      catch ( ClassNotFoundException cnfex ) {
         // processa ClassNotFoundExceptions aqui
         JOptionPane.showMessageDialog(
         null, "A conex�o falhou!\n" + cnfex.toString(), "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }
      catch ( SQLException sqlex ) {
         // processa SQLExceptions aqui
          JOptionPane.showMessageDialog(
         null, "A conex�o falhou!\n", "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }
      catch ( Exception ex ) {
         // processa Exceptions remanescentes aqui
         JOptionPane.showMessageDialog(
         null, ex.toString(), "Aviso",
         JOptionPane.WARNING_MESSAGE );
      }

      // Completa layout de tela
      controls =
         new BotoesPainel( connect, scrollArea, output);
      c.add( controls, BorderLayout.NORTH );

      setSize( 500, 400 );
      move(150, 150);
      show();
   }

   public static void main( String[] args )
   {
      Clientes app = new Clientes();

      app.addWindowListener(
               new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }
}


