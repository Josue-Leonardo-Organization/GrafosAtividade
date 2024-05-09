import java.util.*;
import Auxiliary.*;
import Graph.Graph;


public class Main {
    public static void main(String[] args) throws Exception {
        
        boolean direcionado = IsDirected.directedOrNot();
        int quantidadeVertices = CheckType.getInt("\nDigite o número de vértices desejado: ", "\n--- Número INVÁLIDO ---");
        
        Graph graph = new Graph(quantidadeVertices, direcionado);
        
        int option, vertice, origem, destino, peso;

        do{
            Menu.menu(direcionado);
            option = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Digite uma opção válida ---");

            switch (option) {
                case 1000:
                graph.MetodoKruskal();
                break;

                case 0:
                    System.out.print("\n --- Você Saiu --- \n\n");
                    break;

                case 1:
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

                case 2:
                    System.out.println( "\n=== Criar Arestas ===");
                    do {
                        origem = CheckType.getInt("\nDigite a origem da aresta (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                        if (origem != -1){
                            destino = CheckType.getInt("Digite o destino da aresta: ", "\n--- Vértice INVÁLIDO ---");
                            peso = CheckType.getInt("Digite o peso da aresta: ", "\n--- Valor INVÁLIDO ---");
                            graph.adicionarAresta(origem, destino, peso);
                        }
                    } while (origem != -1);
                    break;

                case 3:
                    System.out.println( "\n=== Excluir Arestas ===");
                    do {
                        origem = CheckType.getInt("\nDigite a origem da aresta (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                        if (origem != -1){
                            destino = CheckType.getInt("Digite o destino da aresta: ", "\n--- Vértice INVÁLIDO ---");
                            graph.excluirAresta(origem, destino);
                        }
                    } while(origem != -1);
                    break;

                case 4:
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
                    else{
                        do {
                            vertice = CheckType.getInt("\nDigite o vértice para identificar a vizinhança (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                            if (vertice != -1){
                                List<Integer> vizinhanca = graph.vizinhanca(vertice);
                                System.out.println("Vizinhança do vértice " + vertice + ": " + vizinhanca);
                            }
                        } while (vertice != -1);
                    }
                    break;


              
               
                case 5:
                    System.out.println( "\n=== Grau do vértice ===");
                    if(direcionado){
                        do {
                            vertice = CheckType.getInt("\nDigite o vértice para identificar o grau de entrada e de saída (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                            if (vertice != -1){
                                int grauEntrada = graph.grauEntrada(vertice);
                                if (grauEntrada != -1){    
                                    System.out.println("Grau de entrada do vértice " + vertice + ": " + grauEntrada);
                                }
                                int grauSaida = graph.grau(vertice);
                                if (grauSaida != -1){
                                    System.out.println("Grau de saída do vértice " + vertice + ": " + grauSaida);
                                }
                            }
                        } while (vertice != -1);
                    }
                    else{
                        do {
                            vertice = CheckType.getInt("\nDigite o vértice para identificar o grau (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                            if (vertice != -1){
                                int grau = graph.grau(vertice);
                                if (grau != -1){
                                    System.out.println("Grau do vértice " + vertice + ": " + grau);
                                }
                            }
                        } while (vertice != -1);
                    }
                    break;

                case 6:
                    if (graph.isSimples()) {
                        System.out.println("- O grafo é simples.");
                    } else {
                        System.out.println("- O grafo não é simples.");
                    }

                    break;

                case 7:
                    if (graph.isRegular()) {
                        System.out.println("- O grafo é regular.");
                    } else {
                        System.out.println("- O grafo não é regular.");
                    }
                    break;

                case 8:
                    if (graph.isCompleto()) {
                        System.out.println("- O grafo é completo.");
                    } else {
                        System.out.println("- O grafo não é completo.");
                    }
                    break;
                
                case 9:
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
        }while(option != 0);
    }
}
