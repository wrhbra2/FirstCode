import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class caderno {
  public static void Formulario() {

    Scanner entrada = new Scanner(System.in);

    Date data = new Date();
    SimpleDateFormat datasdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String dataFormat = datasdf.format(data);
    System.out.println("Data: " + dataFormat);

    System.out.print("Matéria: ");a
    String materia = entrada.nextLine();

    System.out.print("Semana: ");
    int semana = entrada.nextInt();

    System.out.print("Tema da aula: ");
    String tema = entrada.nextLine();

    System.out.print("Palavra/Expressão-Chave: ");
    String chave = entrada.nextLine();

    System.out.print("Comentários: ");
    String coment = entrada.nextLine();

    File arq = new File("caderno.txt");
    boolean exists = arq.exists();
    
    do {
      try {
        FileWriter fw = new FileWriter(arq, true);
        PrintWriter pr = new PrintWriter(fw);
        pr.print(dataFormat + " " + materia + " " + semana + " " + tema + " " + chave + " " + coment + "\n");
        pr.close();
        fw.close();

     } catch (Exception e) {
       System.out.println("Ocorreu erro ao escrever o arquivo.");
     }
      
      
    } while (exists != true);{
      try {
        FileReader fr = new FileReader(arq);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        do{
          linha = br.readLine();
          if (linha != null){
            System.out.print(linha+"\n");            
            }
        } while (linha != null);
        br.close();
        fr.close();
               
          
        
      } catch (Exception e) {
        System.out.println("Ocorreu erro ao ler o arquivo.");
      }
    }
      

    

  }

  public static void main(String[] args) {

    Formulario();
  }

}
