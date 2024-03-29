package Graph;
import java.util.*;

public class Graph {
    private int numVertices;
    private boolean direcionado;
    private List<List<Integer>> adjacencias;

    public Graph(int numVertices, boolean direcionado) {
        this.numVertices = numVertices;
        this.direcionado = direcionado;
        this.adjacencias = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            this.adjacencias.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            System.out.println("Vértice inválido!");
            return;
        }
        adjacencias.get(origem).add(destino);
        if (!direcionado) {
            adjacencias.get(destino).add(origem); // Para grafos não direcionados, adicionamos a aresta nos dois sentidos
        }
    }

    public void excluirAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            System.out.println("Vértice inválido!");
            return;
        }
        adjacencias.get(origem).remove(Integer.valueOf(destino));
        if (!direcionado) {
            adjacencias.get(destino).remove(Integer.valueOf(origem)); // Para grafos não direcionados, removemos a aresta nos dois sentidos
        }
    }

    public List<Integer> vizinhanca(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            System.out.println("Vértice inválido!");
            return Collections.emptyList();
        }
        return adjacencias.get(vertice);
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
        return adjacencias.get(vertice);
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
            if (i != vertice && adjacencias.get(i).contains(vertice)) {
                predecessores.add(i);
            }
        }
        return predecessores;
    }

    public void printAdjacencyList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("|  "+ i +"  |");
            for (int j = 0; j < adjacencias.get(i).size(); j++) {
                System.out.print(" -->  | " + adjacencias.get(i).get(j) + " |" );
            }
            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        int newSize = numVertices + 1;
        int[][] newMatrix = new int[newSize][newSize];
    
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newMatrix[i][j] = adjacencias.get(i).contains(j) ? 1 : 0;
            }
        }

        System.out.print("  | ");
        for(int i = 0; i < numVertices; i++){
            System.out.print(i + " | ");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print(i+ " | ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(newMatrix[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public boolean isSimples() {
        for (int i = 0; i < numVertices; i++) {
            List<Integer> vizinhos = adjacencias.get(i);
            if (vizinhos.contains(i)) { // Verifica se há laços
                return false;
            }
            for (int j = 0; j < vizinhos.size(); j++) {
                int vizinho = vizinhos.get(j);
                if (i != vizinho && Collections.frequency(vizinhos, vizinho) > 1) { // Verifica se há arestas múltiplas
                    return false;
                }
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
        for (int i = 0; i < numVertices; i++) {
            if (i != vertice && adjacencias.get(i).contains(vertice)) {
                contGrauEntrada++;
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
        for (int i = 1; i < numVertices; i++) {
            if (grau(i) != grauSaidaPadrao) {
                return false;
            }
        }
        int grauEntradaPadrao = grauEntrada(0); //Grau de entrada do primeiro vértice
        for (int i = 1; i < numVertices; i++) {
            if (grauEntrada(i) != grauEntradaPadrao) {
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
            if ((grau(i) + grauEntrada(i)) != numVertices - 1) {
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

                    for (int vizinho : adjacencias.get(atual)) {
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
        return true; // Se nenhum conflito de cor foi encontrado, o grafo é bipartido
    
    }

    
}


