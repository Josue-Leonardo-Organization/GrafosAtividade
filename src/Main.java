import java.util.*;
import Auxiliary.Menu;
import Auxiliary.CheckType;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean direcionado;
        int op;
        String option = "";

        op = CheckType.getInt("\nDigite o número de vértices desejado: ", "\n--- Número INVÁLIDO ---");

        do{
            Menu.menuDirecionado();
            op = CheckType.getInt("\nDigite a opção desejada: ", "\n--- Opção INVÁLIDA ---");
        } while (op != 1 && op != 2);

        if(op == 1){
            direcionado = true;
        }else{
            direcionado = false;
        }

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
                    //Menu.menuRepresentacao();
                    break;

                case "2":
                    break;

                case "3":
                    break;
                
                case "4 Direcionado":
                    break;

                case "4 Nao Direcionado":
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
