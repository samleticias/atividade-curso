package application;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

        List<Produto> list = new ArrayList<>();
        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++){
            System.out.println("Dados do produto #" + i +" : ");
            System.out.print("Comum, usado, importado (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preco: ");
            double preco = sc.nextDouble();
            if (type == 'c') {
                list.add(new Produto(name, preco));
            }
            else if (type == 'u') {
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new ProdutoUsado(name, preco, date));
            }
            else {
                System.out.print("Taxa de importacao: ");
                double taxaImportacao = sc.nextDouble();
                list.add(new ProdutoImportado(name, preco, taxaImportacao ));
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for (Produto prod : list) {
            System.out.println(prod.taxa());
        }

        sc.close();
    }


}

