import java.util.*;
import Auxiliary.Menu;
import Auxiliary.CheckType;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean direcionado;
        int op;
        int opdir;
        int origem, destino;
        int vertice;
        String option = "";

        op = CheckType.getInt("\nDigite o número de vértices desejado: ", "\n--- Número INVÁLIDO ---");

        System.out.println("N de vértices: " + op);

        do{
            Menu.menuDirecionado();
            opdir = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Opção INVÁLIDA ---");
        } while (opdir != 1 && opdir != 2);

        if(opdir == 1){
            direcionado = true;
        }else{
            direcionado = false;
        }

        System.out.println("Direcionado: " + direcionado);

        System.out.println("N de vértices: " + op);

        Graph graph = new Graph(op, direcionado);

        do{
            Menu.menu(direcionado);
            System.out.print("\nDigite a opção desejada: ");
            option = sc.nextLine();

            if(option.equals("4") && direcionado == true){
                option = "4 Direcionado";

            } else if(option.equals("4") && direcionado == false){
                option = "4 Nao Direcionado";
            }

            switch (option) {
                case "0":
                    System.out.print("\n --- Você Saiu --- \n\n");

                    break;

                case "1":
                    Menu.menuRepresentacao();

                    break;

                case "2":
                    do {
                        System.out.print("\nDigite a origem da aresta (-1 para sair): ");
                        origem = sc.nextInt();
                        if (origem == -1) break;
                        System.out.print("Digite o destino da aresta: ");
                        destino = sc.nextInt();
                        graph.adicionarAresta(origem, destino);
                    } while (true);

                    break;

                case "3":
                    break;
                
                case "4 Direcionado":
                    if (direcionado) {
                        do {
                            System.out.print("\nDigite o vértice para identificar os predecessores e sucessores (-1 para sair): ");
                            vertice = sc.nextInt();
                            if (vertice == -1) break;
                            List<Integer> predecessores = graph.predecessores(vertice);
                            System.out.println("Predecessores do vértice " + vertice + ": " + predecessores);
                            List<Integer> sucessores = graph.sucessores(vertice);
                            System.out.println("Sucessores do vértice " + vertice + ": " + sucessores);
                        } while (true);
                    }

                    break;

                case "4 Nao Direcionado":
                    do {
                        System.out.print("\nDigite o vértice para identificar a vizinhança (-1 para sair): ");
                        vertice = sc.nextInt();
                        if (vertice == -1) break;
                        List<Integer> vizinhanca = graph.vizinhanca(vertice);
                        System.out.println("Vizinhança do vértice " + vertice + ": " + vizinhanca);
                    } while (true);

                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    break;

                case "7":
                    break;

                case "8":
                    break;

                default:
                    System.out.print("\n      === ERRO === \n --- Opção INVÁLIDA ---\n");
                    break;
            }
        }while(option.equals("0") == false);

        

        
    }
}
