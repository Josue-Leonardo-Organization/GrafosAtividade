package Auxiliary;


public class Menu {
    
    public static void menuDirecionado() {
        System.out.print("\n=============================================\n");
        System.out.print("     === Definição do tipo de grafo ==="          );
        System.out.print("\nOpção 1 - Direcionado"                          );
        System.out.print("\nOpção 2 - Não Direcionado"                      );
        System.out.print("\n=============================================\n");
    }
    
    public static void menuRepresentacao() {
        System.out.print("\n=============================================\n");
        System.out.print("     === Mostrar grafo ==="                       );
        System.out.print("\nOpção 1 - Matriz de Adjacência"                 );
        System.out.print("\nOpção 2 - Lista de Adjacência"                  );
        System.out.print("\n=============================================\n");
    }

    public static void menu(boolean direcionado) {
        if(direcionado == true){
            System.out.print("\n\n===================================================================\n");
            System.out.print("\t\t      ===   Menu   ===   "                                            );
            System.out.print("\n   Opção 0 - Sair"                                                      );
            System.out.print("\n   Opção 1 - Mostrar grafo"                                             );
            System.out.print("\n   Opção 2 - Criar arestas"                                             );
            System.out.print("\n   Opção 3 - Remover arestas"                                           );
            System.out.print("\n   Opção 4 - Identificar sucessores e predecessores de um vértice"      );
            System.out.print("\n   Opção 5 - Identificar o grau de um vértice"                          );
            System.out.print("\n   Opção 6 - Testar se o grafo é simples"                               );
            System.out.print("\n   Opção 7 - Testar se o grafo é regular"                               );
            System.out.print("\n   Opção 8 - Testar se o grafo é completo"                              );
            System.out.print("\n   Opção 9 - Testar se o grafo é bipartido"                             );
            System.out.print("\n   Opção 10 - Busca em largura"                                         );
            System.out.print("\n   Opção 11 - Busca em profundidade"                                    );
            System.out.print("\n   Opção 12 - Ordenação topológica"                                     );
            System.out.print("\n   Opção 13 - AGM"                                                      );
            System.out.print("\n   Opção 14 - Testar se o grafo é conexo"                               );
            System.out.print("\n   Opção 15 - Identificar o caminho mínimo entre dois vértices"         );
            System.out.print("\n===================================================================\n"  );
        
        }
        else{
            System.out.print("\n\n===================================================================\n");
            System.out.print("\t\t      ===   Menu   ===   "                                            );
            System.out.print("\n   Opção 0 - Sair"                                                      );
            System.out.print("\n   Opção 1 - Mostrar grafo"                                             );
            System.out.print("\n   Opção 2 - Criar arestas"                                             );
            System.out.print("\n   Opção 3 - Remover arestas"                                           );
            System.out.print("\n   Opção 4 - Identificar vizinhança de um vértice"                      );
            System.out.print("\n   Opção 5 - Identificar o grau de um vértice"                          );
            System.out.print("\n   Opção 6 - Testar se o grafo é simples"                               );
            System.out.print("\n   Opção 7 - Testar se o grafo é regular"                               );
            System.out.print("\n   Opção 8 - Testar se o grafo é completo"                              );
            System.out.print("\n   Opção 9 - Testar se o grafo é bipartido"                             );
            System.out.print("\n   Opção 10 - Busca em largura"                                         );
            System.out.print("\n   Opção 11 - Busca em profundidade"                                    );
            System.out.print("\n   Opção 12 - Ordenação topológica"                                     );
            System.out.print("\n   Opção 13 - AGM"                                                      );
            System.out.print("\n   Opção 14 - Testar se o grafo é conexo"                               );
            System.out.print("\n   Opção 15 - Identificar o caminho mínimo entre dois vértices"         );
            System.out.print("\n===================================================================\n"  );
        }
    }
}
