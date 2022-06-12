import java.awt.*;
import javax.swing.*;
import java.util.*;

public class relatorio extends JFrame {
   private JTextArea texto = new JTextArea();

   public relatorio() {
      super("Relatorio");
      this.exibeRelatorio();
   }

   private void exibeRelatorio() {
      this.getContentPane().add(texto);
      
      JTextField texto = new JTextField("1 - Capital Inicial\n2 - Controle Orçamentário\n3 - Plano de Negócios\nS - Sair");
  
      String opcao = "";

      while (!opcao.equalsIgnoreCase("s")) {
         opcao = exibeRelatorio();
         switch (opcao) {
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

               JOptionPane.showMessageDialog(null, "Você esta deixando o Programa!!!");
               break;

            default:
               JOptionPane.showMessageDialog(null, "Seja Bem Vindo Novamente");
         }

      }

   }

   private void executaOpcao1() {

      JOptionPane.showMessageDialog(null, "Software para gestão e desenvolvimento de Pequenas Empresas.",
            "Relatorios Mensais.", JOptionPane.INFORMATION_MESSAGE);

      String nome;
      StringBuilder mensagem = new StringBuilder();

      nome = JOptionPane.showInputDialog("Determine Capital Inicial.");
      mensagem.append("Seu CAIXA atualmente é de  é de R$").append(nome).append("!");
      JOptionPane.showMessageDialog(null, mensagem);
   }

   private void executaOpcao2() {

   }

   private void executaOpcao3() {
      JOptionPane.showMessageDialog(null, "Plano de Negócios");

   }

   public static void main(String[] args) {
      relatorio start = new relatorio();
      start.setSize(540, 440);
      start.setVisible(true);
      JFrame frame = new JFrame();
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(new JTextField(), BorderLayout.NORTH); // Essa linha insere o JTextField
      frame.setSize(300, 300);
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setVisible(true);

   }
}
