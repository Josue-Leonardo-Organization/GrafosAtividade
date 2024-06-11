import java.util.*;

import Atividade3.DoctorsWithoutWeekends;
import Atividade3.Medico;
import Atividade3.PeriodoFerias;
import Auxiliary.*;
import Graph.Graph;


public class Main {
    public static void main(String[] args) throws Exception {
        
        boolean direcionado = IsDirected.directedOrNot();
        int quantidadeVertices = CheckType.getInt("\nDigite o número de vértices desejado: ", "\n--- Número INVÁLIDO ---");
        int op;

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
                        case 70:
                            System.out.println("\nMostrando grafo usando Matriz de Peso: ");
                            graph.printPesoMatrix();
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
                
                case 10:
                    if (direcionado) {
                        vertice = CheckType.getInt("\nDigite o vértice incial da busca: ", "\n--- Vértice INVÁLIDO ---");
                        System.out.println("Realizando busca em largura...");
                        List<Integer> resultadoBFS = graph.buscaEmLargura(vertice);
                        System.out.println("Resultado da busca em largura: " + resultadoBFS);
                    } else {
                        vertice = CheckType.getInt("\nDigite o vértice incial da busca: ", "\n--- Vértice INVÁLIDO ---");
                        System.out.println("Realizando busca em largura...");
                        List<Integer> resultadoBFS = graph.buscaEmLargura(vertice);
                        System.out.println("Resultado da busca em largura: " + resultadoBFS);
                    }
                    break;
                
                case 11:
                    if (direcionado) {
                        vertice = CheckType.getInt("\nDigite o vértice incial da busca: ", "\n--- Vértice INVÁLIDO ---");
                        System.out.println("Realizando busca em profundidade...");
                        Map<String, List<Integer>> resultadoDFS = graph.buscaEmProfundidade(vertice);
                        System.out.println("Resultado da busca em profundidade: " + resultadoDFS);
                    } else {
                        vertice = CheckType.getInt("\nDigite o vértice incial da busca: ", "\n--- Vértice INVÁLIDO ---");
                        System.out.println("Realizando busca em profundidade...");
                        Map<String, List<Integer>> resultadoDFS = graph.buscaEmProfundidade(vertice);
                        System.out.println("Resultado da busca em profundidade: " + resultadoDFS);
                    }
                    break;
                
                case 12:
                    System.out.println("Realizando ordenação topológica...");
                    List<Integer> ordenacao = graph.ordenacaoTopologica();
                    System.out.println("Resultado da ordenação: " + ordenacao);
                    break;
                
                case 13:
                    graph.MetodoKruskal();
                    break;

                case 14:
                    boolean conexo = graph.isConexo();
                    if(conexo==true){
                        System.out.println("O grafo é conexo.");
                    }
                    else{
                        System.out.println("O grafo não é conexo.");
                    }
                    break;

                case 15:
                    origem = CheckType.getInt("\nDigite a origem do caminho (-1 para sair): ", "\n--- Vértice INVÁLIDO ---");
                    if (origem != -1){
                        Map <Integer, Integer> caminhoMinimo = graph.caminhoMinimo(origem);
                        System.out.println("Caminho mínimo: " + caminhoMinimo);
                    }
                    break;

                case 16:
                   
                    int n = CheckType.getInt("Digite o número de médicos: ", "\n--- Valor INVÁLIDO ---");
                    int somaDias = 0, cont = 0;

                    List<Medico> medicos = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        int diasDisponiveisCount = CheckType.getInt("\nDigite o número de dias disponíveis do médico " + (i + 1) + ": ", "\n--- Valor INVÁLIDO ---");
                        Set<Integer> diasDisponiveis = new HashSet<>();
                        for (int j = 0; j < diasDisponiveisCount; j++) {
                            diasDisponiveis.add(CheckType.getInt("\nDigite o " + (j + 1) + "º dia disponível do médico " + (i + 1) + ": \n", "\n--- Valor INVÁLIDO ---"));
                        }
                        medicos.add(new Medico(i + 1, diasDisponiveis));
                    }

                    int k = CheckType.getInt("\nDigite o número de períodos de férias: ", "\n--- Valor INVÁLIDO ---");

                    List<PeriodoFerias> periodos = new ArrayList<>();
                    for (int i = 0; i < k; i++) {
                        System.out.print("Digite o número de dias do período de férias " + (i + 1) + ": ");
                        int diasCount = CheckType.getInt("","");
                        somaDias += diasCount;
                        Set<Integer> dias = new HashSet<>();
                        for (int j = 0; j < diasCount; j++) {
                            
                            dias.add(CheckType.getInt("\nDigite o " + (j + 1) + "º dia do " + (i + 1) + "º período: \n","\n--- Valor INVÁLIDO ---"));
                        }
                        periodos.add(new PeriodoFerias(i + 1, dias));
                    }

                    System.out.print("Digite o valor de c (máximo de dias que um médico pode trabalhar): ");
                    int c = CheckType.getInt("","");

                    Map<Integer, Integer> atribuicao = DoctorsWithoutWeekends.obterAtribuicaoMedicos(medicos, periodos, c);
                    if (atribuicao != null) {
                        System.out.println("Atribuição de médicos:");
                        for (Map.Entry<Integer, Integer> entry : atribuicao.entrySet()) {
                            System.out.println("Dia " + entry.getKey() + " -> Médico " + entry.getValue());
                            cont++;
                        }
                    } else {
                        System.out.println("Não é possível fazer a atribuição.");
                    }
                    break;

                default:
                    System.out.print("\n      === ERRO === \n --- Opção INVÁLIDA ---\n");
                    break;
            }
        }while(option != 0);
    }
}
