
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class relatorio extends JFrame{
   
   String texto  = "1 - Capital Inicial\n2 - Controle Orçamentário\n3 - Plano de Negócios\nS - Sair";
   
   public String exibeRelatorio(){


      return JOptionPane.showInputDialog(null, texto);
   }
   public void executaRelatorio(){
      String opcao = "";

      while (!opcao.equalsIgnoreCase("s")){
         opcao = exibeRelatorio();
      switch(opcao){
         case "1":
         executaOpcao1();
         break;

         case "2":
         executaOpcao2();
         break;
         
         case "3":
         executaOpcao3();
         break;

         case "S":
         case "s":

         JOptionPane.showMessageDialog(null,"Você esta deixando o Programa!!!");
         break;

         default:
         extracted();         
      }
      
   }
      
   }
   private void extracted() {
      JOptionPane.showMessageDialog(null,"Seja Bem Vindo Novamente");
   }
   private void executaOpcao1(){

     JOptionPane.showMessageDialog(null, "Software para gestão e desenvolvimento de Pequenas Empresas.", "Relatorios Mensais.",JOptionPane.INFORMATION_MESSAGE);

     String nome;
     StringBuilder mensagem = new StringBuilder();

     nome = JOptionPane.showInputDialog("Qual o capital Inicial");
     mensagem.append("Seu CAIXA é de R$:").append(nome).append("!");
     JOptionPane.showMessageDialog(null, mensagem);
   }

   private void executaOpcao2(){
      String[] colNames = {"Name", "Sport", "Years", "Vegetarian"};
      Object[][] data = {
       {"Kathy", "Snowboarding", new Integer(5), new Boolean(false)},
       {"John", "Rowing", new Integer(3), new Boolean(true)},
       {"Sue", "Knitting", new Integer(2), new Boolean(false)},
       {"Jane", "Speed reading", new Integer(20), new Boolean(true)},
       {"Joe", "Pool", new Integer(10), new Boolean(false)}};
     JTable table = new JTable(data, colNames);
     table.setPreferredScrollableViewportSize(new Dimension(500,80));
     table.setFillsViewportHeight(true);
     //Create the scroll pane and add the table to it.
     JScrollPane scrollPane = new JScrollPane(table);
     //Add the scroll pane to the JFrame.
     JScrollPane f = new JScrollPane();
     f.add(scrollPane);
      }
   private void executaOpcao3(){
      JOptionPane.showMessageDialog(null,"Plano de Negócios");
   }
            
    public static void main(String[]args){
        relatorio r = new relatorio();
        r.executaRelatorio(); 
                    
   }  
}
  

   
  


