import java.util.*;
import Auxiliary.Menu;
import Graph.Graph;
import Auxiliary.CheckType;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean direcionado;
        int quantidadeVertices;
        int vertice, origem, destino;
        String option = "";

        quantidadeVertices = CheckType.getInt("\nDigite o número de vértices desejado: ", "\n--- Número INVÁLIDO ---");
        direcionado = direcionado();
        Graph graph = new Graph(quantidadeVertices, direcionado);

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
                    int representacaoOpcao = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Opção INVÁLIDA ---");
                    switch (representacaoOpcao) {
                        case 1:
                            System.out.println("\nMostrando grafo usando Matriz de Adjacência: ");
                            graph.printAdjacencyMatrix();
                            break;
                        case 2:
                            System.out.println("\nMostrando grafo usando Lista de Adjacência: ");
                            graph.printAdjacencyList();
                            break;
                        default:
                            System.out.print("\n      === ERRO === \n --- Opção INVÁLIDA ---\n");
                            break;
                    }
                    break;

                case "2":
                    System.out.println( "\n=== Criar Arestas ===");
                    do {
                        origem = CheckType.getInt("\nDigite a origem da aresta (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                        if (origem != -1){
                            destino = CheckType.getInt("Digite o destino da aresta: ", "\n--- Vértice INVÁLIDO ---");
                            graph.adicionarAresta(origem, destino);
                        }
                    } while (origem != -1);
                    break;

                case "3":
                    System.out.println( "\n=== Excluir Arestas ===");
                    do {
                        origem = CheckType.getInt("\nDigite a origem da aresta (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                        if (origem != -1){
                            destino = CheckType.getInt("Digite o destino da aresta: ", "\n--- Vértice INVÁLIDO ---");
                            graph.excluirAresta(origem, destino);
                        }
                    } while(origem != -1);
                    break;

                
                case "4 Direcionado":
                    if (direcionado) {
                        do {
                            vertice = CheckType.getInt("\nDigite o vértice para identificar os predecessores e sucessores (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");

                            if (vertice != -1){
                                List<Integer> predecessores = graph.predecessores(vertice);
                                System.out.println("Predecessores do vértice " + vertice + ": " + predecessores);
                                List<Integer> sucessores = graph.sucessores(vertice);
                                System.out.println("Sucessores do vértice " + vertice + ": " + sucessores);
                            }
                        } while (vertice != -1);
                    }
                    break;

                case "4 Nao Direcionado":
                    do {
                        vertice = CheckType.getInt("\nDigite o vértice para identificar a vizinhança (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                        if (vertice != -1){
                            List<Integer> vizinhanca = graph.vizinhanca(vertice);
                            System.out.println("Vizinhança do vértice " + vertice + ": " + vizinhanca);
                        }
                    } while (vertice != -1);
                    break;

                case "5":
                    System.out.println( "\n=== Grau do vértice ===");
                    if(!direcionado){
                        do {
                            System.out.print("\nDigite o vértice para identificar o grau (-1 para sair): ");
                            vertice = sc.nextInt();
                            if (vertice == -1) break;
                            int grau = graph.grau(vertice);
                            if (grau != -1){
                                System.out.println("Grau do vértice " + vertice + ": " + grau);
                            }
                        } while (true);
                    }
                    else{
                        do {
                            System.out.print("\nDigite o vértice para identificar o grau de entrada e de saída (-1 para sair): ");
                            vertice = sc.nextInt();
                            if (vertice == -1) break;
                            int grauEntrada = graph.grauEntrada(vertice);
                            if (grauEntrada != -1){    
                                System.out.println("Grau de entrada do vértice " + vertice + ": " + grauEntrada);
                            }
                            int grauSaida = graph.grau(vertice);
                            if (grauSaida != -1){
                                System.out.println("Grau de saída do vértice " + vertice + ": " + grauSaida);
                            }
                        } while (true);
                    }
                    break;

                case "6":
                    if (graph.isSimples()) {
                        System.out.println("- O grafo é simples.");
                    } else {
                        System.out.println("- O grafo não é simples.");
                    }

                    break;

                case "7":
                    if(!direcionado){    
                        if (graph.isRegular()) {
                            System.out.println("- O grafo é regular.");
                        } else {
                            System.out.println("- O grafo não é regular.");
                        }
                    }
                    else{
                        if (graph.isRegularDirecionado()) {
                            System.out.println("- O grafo é regular.");
                        } else {
                            System.out.println("- O grafo não é regular.");
                        }
                    }
                    break;

                case "8":
                    if(!direcionado){
                        if (graph.isCompleto()) {
                            System.out.println("- O grafo é completo.");
                        } else {
                            System.out.println("- O grafo não é completo.");
                        }
                    }
                    else{
                        if (graph.isCompletoDirecionado()) {
                            System.out.println("- O grafo é completo.");
                        } else {
                            System.out.println("- O grafo não é completo.");
                        }
                    }
                    break;
                
                case "9":
                    if (graph.isBipartido()) {
                        System.out.println("- O grafo é bipartido.");
                    } else {
                        System.out.println("- O grafo não é bipartido.");
                    }
                    break;

                default:
                    System.out.print("\n      === ERRO === \n --- Opção INVÁLIDA ---\n");
                    break;
            }
        }while(option.equals("0") == false);
    }

    public static Boolean direcionado() {
        int resposta;
        do{
            Menu.menuDirecionado();
            resposta = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Opção INVÁLIDA ---");
        } while (resposta!=1 && resposta!=2);

        if(resposta == 1){
            return true;
        }else{
            return false;
        }
    }
}
