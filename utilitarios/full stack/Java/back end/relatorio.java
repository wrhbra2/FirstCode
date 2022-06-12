import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Date;
import java.awt.Component;
import java.awt.Dimension;

public class relatorio {

    public static void menu() {
        System.out.print(
                "----Relatórios Mensais.----\n  Software para gestão e desenvolvimento de pequenas empresas. \n");
        System.out.print("1. Capital Inicial.\n");
        System.out.print("2. Controle Orçamentário.\n");
        System.out.print("3. Plano de Negócio.\n");
        System.out.print("4. Sair. \n");
        System.out.print("Opcao: ");

    }

    public static void CapitalInicial() {
        System.out.print("1. Capital Inicial. \n");

    }

    public static void ControleOrcamentario() {
        System.out.print("2. Controle Orçamentario.\n");

    }

    public static void PlanodeNegocio() {
        System.out.print("3. Plano de Negocio.\n");
    }

    public static void Sair() {
        System.out.print("4. Sair.\n");

    }

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        int opcao;
        while (true) {
            menu();

            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    CapitalInicial();
                    System.out.print("Capital para Iniciar. R$ ");
                    double capital = entrada.nextDouble();
                    System.out.println("O capital de Inicio é R$" + capital);

                    break;

                case 2:
                    ControleOrcamentario();
                    Date dia = new Date();
                    SimpleDateFormat diasdf = new SimpleDateFormat("dd/MM/yyyy");
                    String diaFormat = diasdf.format(dia);
                    System.out.println("Data: " + diaFormat);

                    System.out.print("receita ou despesa. ");
                    String objeto = entrada.next();
                   
                    

                    System.out.print("Novo item: ");
                    String item = entrada.next();

                    System.out.print("Nova Quantidade. ");
                    int quantd = entrada.nextInt();

                    System.out.print("Valor R$ ");
                    Double preco = entrada.nextDouble();
                    System.out.println(objeto);

                    // Estrutura de condição.//
                    if (objeto == "receita") {
                        File file = new File("receita.txt");
                        boolean exists = file.exists();
                        Sstem.out.println(file);
                        // Escrever no arquivo//
                        do {
                            try {

                            FileWriter arq = new FileWriter(file);
                            PrintWriter pr = new PrintWriter(arq);
                            pr.print(diaFormat + "  " + objeto + "  " + item + "  " + quantd + "  " + preco);
                            pr.close();
                            arq.close();

                        } catch (Exception e) {
                            System.out.println("Erro ao escrever o arquivo.");
                        }
                        } while (exists != true); {

                        // Ler Arquivo//
                        try {
                            FileReader fr = new FileReader(file);
                            BufferedReader br = new BufferedReader(fr);
                            String linha;
                            do {
                                linha = br.readLine();
                                if (linha != null) {
                                   System.out.println(linha + "\n");
                            }
                            } while (linha != null);

                        } catch (Exception e) {
                            System.out.println("Erro ao ler o arquivo.");
                            {
                        }else{
                        File file = new File("despesa.txt");
                        }
                             
                

                    break;

                case 3:
                    PlanodeNegocio();
                    Date mensal = new Date();
                    SimpleDateFormat messdf = new SimpleDateFormat("MM/yyyy");
                    String mesFormat = messdf.format(mensal);
                    System.out.println("Data: " + mesFormat);

                    System.out.print("receita ou despesa. ");
                    String doc = entrada.next();

                    if (doc == "receita") {
                        File docfile = new File("receita.txt");
                        try {
                            FileReader fr = new FileReader(docfile);
                            BufferedReader br = new BufferedReader(fr);
                            String linha;
                            do {
                                linha = br.readLine();
                                if (linha != null) {
                                    System.out.println(linha + "\n");
                                }
                            } while (linha != null);

                        } catch (Exception e) {
                            System.out.println("Erro ao ler o arquivo.");
                        }
                    } else {
                        File docfile = new File("despesa.txt");
                    }

                    break;

                case 4:
                    Sair();
                    System.out.println("Você esta saindo do programa.");
                    System.exit(0);
                    break;
            }

        }

    }
}