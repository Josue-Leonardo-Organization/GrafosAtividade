package Auxiliary;

public class IsDirected {
        public static Boolean directedOrNot() {
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
