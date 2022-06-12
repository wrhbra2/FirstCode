// RotuloClientes.java
// Definição da classe RotuloClientes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ScrollPaneLayout;

public class RotuloClientes extends JPanel {
   private JPanel labelPanel, fieldsPanel;
   private String labels[] = 
                 { "Código:", "Nome:", "Sobrenome:",
                   "Endereço:", "Cidade:", "Estado:",
                   "CEP:", "Pais:", "E-mail:",
                   "Telefone:", "Celular:" };
   JTextField id, first, last, address,     // accesso de pacote
              city, state, zip,
              country, email, home, fax;

   public RotuloClientes()
   {
      // Painel de Rótulo
      labelPanel = new JPanel();
      labelPanel.setLayout(new GridLayout( labels.length, 1 ) );

      for ( int i = 0; i < labels.length; i++ )
         labelPanel.add( new JLabel( labels[ i ], 0) );

      // Painel de TextField 
      fieldsPanel = new JPanel();
      fieldsPanel.setLayout(new GridLayout( labels.length, 1 ) );
      id = new JTextField( 20 );
      id.setEditable( false );
      fieldsPanel.add( id );
      first = new JTextField( 20 );
      fieldsPanel.add( first );
      last = new JTextField( 20 );
      fieldsPanel.add( last );
      address = new JTextField( 20 );
      fieldsPanel.add( address );
      city = new JTextField( 20 );
      fieldsPanel.add( city );
      state = new JTextField( 20 );
      fieldsPanel.add( state  );
      zip = new JTextField( 20 );
      fieldsPanel.add( zip );
      country = new JTextField( 20 );
      fieldsPanel.add( country );
      email = new JTextField( 20 );
      fieldsPanel.add( email );
      home = new JTextField( 20 );
      fieldsPanel.add( home );
      fax = new JTextField( 20 );
      fieldsPanel.add( fax );

      setLayout( new GridLayout( 1, 2 ) );
      add( labelPanel );
      add( fieldsPanel );
   }
}


