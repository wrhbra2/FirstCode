import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class relatorios {

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
        System.out.print("Sair do programa.\n");

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
                System.out.print("Capital para Iniciar. R$");
                double capital = entrada.nextDouble();
                System.out.printf("O capital de Inicio é R$" + capital);

                break;

            case 2:
                ControleOrcamentario();
                Date dia = new Date();
                SimpleDateFormat diasdf = new SimpleDateFormat("dd/MM/yyyy");
                String diaFormat = diasdf.format(dia);
                System.out.println("Data: " + diaFormat);

                System.out.print("receita ou despesa.: ");
                String objeto;
                objeto = entrada.next();

                System.out.print("Novo item: ");
                String item;
                item = entrada.next();

                System.out.print("Nova Quantidade. :");
                int quantd;
                quantd = entrada.nextInt();

                System.out.print("Valor R$.: ");
                Double preco;
                preco = entrada.nextDouble();

                System.out.println("Registro Efetuado com Sucesso.");

                // Estrutura de condição.//
                if (objeto == "receita") {
                    String file = ("/home/wander/receitas.txt");
                    // Escrever no arquivo//
                    try {

                        FileWriter arq = new FileWriter(file);
                        PrintWriter pr = new PrintWriter(arq);
                        pr.println(diaFormat + "  " + objeto + "  " + item + "  " + quantd + "  "
                                + preco);
                        arq.close();

                    } catch (Exception e) {
                        System.out.println("Erro ao escrever o arquivo.");
                    }

                    // Ler Arquivo//
                    try {
                        FileInputStream arquivo = new FileInputStream(file);
                        InputStreamReader input = new InputStreamReader(arquivo);
                        BufferedReader br = new BufferedReader(input);
                        String linha;
                        do {
                            linha = br.readLine();
                            System.out.println(linha);
                            if (linha != null) {
                                System.out.print("Lido = " + linha);
                            }
                        } while (linha != null);
                     }catch (Exception e) {
                        System.out.println("Erro ao ler o arquivo.");}
                     }else{
                        String file = ("/home/wander/despesas.txt");
                    }
                break;

            case 3:
                PlanodeNegocio();
                // Operação de diferença entre arquivo receita e despesa + itens caros, ou que
                // contribuiram para variação alta ou baixa.//
                Date mes = new Date();
                SimpleDateFormat messdf = new SimpleDateFormat("MM/yyyy");
                String mesFormat = messdf.format(mes);
                System.out.println("Data: " + mesFormat);
                System.out.println("Este é o resultado Mensal.");

                try {
                    FileInputStream arquivo = new FileInputStream(file);
                    InputStreamReader input = new InputStreamReader(arquivo);
                    BufferedReader br = new BufferedReader(input);
                    String linha;
                    do {
                        linha = br.readLine();
                        System.out.println(linha);
                        if (linha != null) {
                            System.out.print("Lido = " + linha);
                        }
                    } while (linha != null);
                } catch (Exception e) {
                    System.out.println("Erro ao ler o arquivo.");
                }
            } else {
                String file = ("/home/wander/despesas.txt");
            }
            break;

            case 4:
                Sair();
                System.out(0);
                break;
            }
        }
    }

