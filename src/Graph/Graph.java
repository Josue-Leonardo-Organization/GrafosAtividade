package Graph;
import java.util.*;

public class Graph {
    private int numVertices;
    private boolean direcionado;
    private List<List<Aresta>> adjacencias;

    public Graph(int numVertices, boolean direcionado) {
        this.numVertices = numVertices;
        this.direcionado = direcionado;
        this.adjacencias = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            this.adjacencias.add(new ArrayList<>());
        }
    }

    class Aresta {
        int destino;
        int peso;
    
        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            System.out.println("Vértice inválido!");
            return;
        }
        adjacencias.get(origem).add(new Aresta(destino, peso));
        if (!direcionado) {
            adjacencias.get(destino).add(new Aresta(origem, peso)); // Para grafos não direcionados, adicionamos a aresta nos dois sentidos
        }
    }

    public void excluirAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            System.out.println("Vértice inválido!");
            return;
        }
        adjacencias.get(origem).removeIf(aresta -> aresta.destino == destino);
        if (!direcionado) {
            adjacencias.get(destino).removeIf(aresta -> aresta.destino == origem); // Para grafos não direcionados, removemos a aresta nos dois sentidos
            System.out.println("Todas as arestas entre " + origem + " e " + destino + " foram removidas");
        }
        if(direcionado){
            System.out.println("Todas as arestas de " + origem + " até " + destino + " foram removidas");
        }
    }

    public List<Integer> vizinhanca(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return Collections.emptyList();
        }
        List<Integer> vizinhos = new ArrayList<>();
        for (Aresta aresta : adjacencias.get(vertice)) {
            vizinhos.add(aresta.destino);
        }
        return vizinhos;
    }

    public List<Integer> sucessores(int vertice) {
        if (!direcionado) {
            System.out.println("Operação válida apenas para grafos direcionados!");
            return Collections.emptyList();
        }
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return Collections.emptyList();
        }
        List<Integer> sucessores = new ArrayList<>();
        for (Aresta aresta : adjacencias.get(vertice)) {
            sucessores.add(aresta.destino);
        }
        return sucessores;
    }

    public List<Integer> predecessores(int vertice) {
        if (!direcionado) {
            System.out.println("Operação válida apenas para grafos direcionados!");
            return Collections.emptyList();
        }
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return Collections.emptyList();
        }
        List<Integer> predecessores = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            for (Aresta aresta : adjacencias.get(i)) {
                if (aresta.destino == vertice) {
                    predecessores.add(i);
                    break;
                }
            }
        }
        return predecessores;
    }

    public void printAdjacencyList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("|  " + i + "  |");
            for (Aresta aresta : adjacencias.get(i)) {
                System.out.print(" -->  | " + aresta.destino + "(" + aresta.peso + ") |");
            }
            System.out.println();
        }
    }
    
    public void printAdjacencyMatrix() {
        int newSize = numVertices + 1;
        int[][] newMatrix = new int[newSize][newSize];
    
        for (int i = 0; i < numVertices; i++) {
            for (Aresta aresta : adjacencias.get(i)) {
                newMatrix[i][aresta.destino] = aresta.peso; // Preenche a matriz com o peso da aresta, se existir
            }
        }
    
        System.out.print("  | ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
    
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < numVertices; j++) {
                if(newMatrix[i][j] != 0){
                    System.out.print(1 + " | ");
                }
                else{
                    System.out.print(newMatrix[i][j] + " | ");
                }
            }
            System.out.println();
        }
    }

    public boolean isSimples() {
        for (int i = 0; i < numVertices; i++) {
            List<Aresta> arestas = adjacencias.get(i);
            Set<Integer> vizinhos = new HashSet<>();
            for (Aresta aresta : arestas) {
                int vizinho = aresta.destino;
                if (vizinho == i) {
                    return false; // Se houver um laço, o grafo não é simples
                }
                if (vizinhos.contains(vizinho)) {
                    return false; // Se houver uma aresta múltipla, o grafo não é simples
                }
                vizinhos.add(vizinho);
            }
        }
        return true;
    }

    public int grau(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return -1;
        }
        return adjacencias.get(vertice).size();
    }

    public int grauEntrada(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return -1;
        }
        int contGrauEntrada = 0;
        for (List<Aresta> arestas : adjacencias) {
            for (Aresta aresta : arestas) {
                if (aresta.destino == vertice) {
                    contGrauEntrada++;
                }
            }
        }
        return contGrauEntrada;
    }

    public boolean isRegular() {
        int grauPadrao = grau(0); // Grau do primeiro vértice
        for (int i = 1; i < numVertices; i++) {
            if (grau(i) != grauPadrao) {
                return false;
            }
        }
        return true;
    }

    public boolean isRegularDirecionado() {
    int grauSaidaPadrao = grau(0); // Grau de saída do primeiro vértice
    int grauEntradaPadrao = grauEntrada(0); // Grau de entrada do primeiro vértice
    for (int i = 1; i < numVertices; i++) {
        if (grau(i) != grauSaidaPadrao || grauEntrada(i) != grauEntradaPadrao) {
            return false;
        }
    }
    return true;
}

    public boolean isCompleto() {
        for (int i = 0; i < numVertices; i++) {
            if (grau(i) != numVertices - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isCompletoDirecionado() {
        for (int i = 0; i < numVertices; i++) {
            int grauTotal = grau(i) + grauEntrada(i);
            if (grauTotal != numVertices - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartido() {
        int[] cor = new int[numVertices]; // Vetor para armazenar a cor de cada vértice (0: não visitado, 1: cor 1, -1: cor 2)
        Arrays.fill(cor, 0); // Inicialmente, nenhum vértice está colorido
    
        for (int i = 0; i < numVertices; i++) {
            if (cor[i] == 0) { // Se o vértice não foi visitado
                cor[i] = 1; // Colorir o vértice com a cor 1
                Queue<Integer> fila = new LinkedList<>();
                fila.add(i); // Adicionar o vértice à fila
    
                while (!fila.isEmpty()) {
                    int atual = fila.poll();
    
                    // Verificar arestas de saída
                    for (Aresta aresta : adjacencias.get(atual)) {
                        int vizinho = aresta.destino;
                        if (cor[vizinho] == 0) { // Se o vizinho não foi visitado
                            cor[vizinho] = -cor[atual]; // Colorir o vizinho com a cor oposta ao vértice atual
                            fila.add(vizinho); // Adicionar o vizinho à fila
                        } else if (cor[vizinho] == cor[atual]) { // Se o vizinho já foi visitado e tem a mesma cor do vértice atual
                            return false; // O grafo não é bipartido
                        }
                    }
    
                    // Verificar arestas de entrada (apenas para grafos direcionados)
                    if (direcionado) {
                        for (int j = 0; j < numVertices; j++) {
                            for (Aresta aresta : adjacencias.get(j)) {
                                if (aresta.destino == atual) {
                                    int vizinho = j;
                                    if (cor[vizinho] == 0) { // Se o vizinho não foi visitado
                                        cor[vizinho] = -cor[atual]; // Colorir o vizinho com a cor oposta ao vértice atual
                                        fila.add(vizinho); // Adicionar o vizinho à fila
                                    } else if (cor[vizinho] == cor[atual]) { // Se o vizinho já foi visitado e tem a mesma cor do vértice atual
                                        return false; // O grafo não é bipartido
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true; // Se nenhum conflito de cor foi encontrado, o grafo é bipartido
    }
    

    
}


