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
}
