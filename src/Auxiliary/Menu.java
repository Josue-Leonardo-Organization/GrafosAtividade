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
        int representacaoOpcao = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Opção INVÁLIDA ---");
        switch (representacaoOpcao) {
            case 1:
                // Implemente a lógica para mostrar o grafo usando matriz de adjacência
                System.out.println("\nMostrando grafo usando Matriz de Adjacência...");
                // Chame o método ou insira o código necessário para mostrar o grafo usando matriz de adjacência
                break;
            case 2:
                // Implemente a lógica para mostrar o grafo usando lista de adjacência
                System.out.println("\nMostrando grafo usando Lista de Adjacência...");
                // Chame o método ou insira o código necessário para mostrar o grafo usando lista de adjacência
                break;
            default:
                System.out.print("\n      === ERRO === \n --- Opção INVÁLIDA ---\n");
                break;
        }
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
            System.out.print("\n===================================================================\n"  );
        }
    }
}
