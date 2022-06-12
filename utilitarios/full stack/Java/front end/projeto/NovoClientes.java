// NovoClientes.java
// Definição da classe NovoClientes
import java.awt.*;
import java.awt.event.*;
import javax.swing.ScrollPaneLayout;

public class NovoClientes implements ActionListener {
   private RotuloClientes fields;

   public NovoClientes( RotuloClientes f )
   {
      fields = f;
   }

   //Limpa os campos
   public void actionPerformed( ActionEvent e )
   {
      fields.id.setText( "" );
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


