package Atividade3;

import java.util.Set;

public class Medico {
    int id;
    Set<Integer> diasDisponiveis;
    int diasTrabalhados;

    public Medico(int id, Set<Integer> diasDisponiveis) {
        this.id = id;
        this.diasDisponiveis = diasDisponiveis;
        this.diasTrabalhados = 0;
    }
}
