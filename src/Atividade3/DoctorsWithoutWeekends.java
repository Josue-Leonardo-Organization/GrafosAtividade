package Atividade3;

import java.util.*;

public class DoctorsWithoutWeekends {

    public static Map<Integer, Integer> obterAtribuicaoMedicos(List<Medico> medicos, List<PeriodoFerias> periodos, int c) {
        Map<Integer, Integer> diaParaMedico = new HashMap<>();
        if (backtrack(medicos, periodos, c, 0, diaParaMedico)) {
            return diaParaMedico;
        } else {
            return null;
        }
    }

    private static boolean backtrack(List<Medico> medicos, List<PeriodoFerias> periodos, int c, int diaIndex, Map<Integer, Integer> diaParaMedico) {
        if (diaIndex >= getTotalDias(periodos)) {
            return true;
        }

        int diaAtual = getDia(periodos, diaIndex);

        for (Medico medico : medicos) {
            if (medico.diasDisponiveis.contains(diaAtual) && medico.diasTrabalhados < c && !diaParaMedico.containsKey(diaAtual)) {
                diaParaMedico.put(diaAtual, medico.id);
                medico.diasTrabalhados++;

                if (backtrack(medicos, periodos, c, diaIndex + 1, diaParaMedico)) {
                    return true;
                }

                diaParaMedico.remove(diaAtual);
                medico.diasTrabalhados--;
            }
        }

        return false;
    }

    private static int getTotalDias(List<PeriodoFerias> periodos) {
        return periodos.stream().mapToInt(p -> p.dias.size()).sum();
    }

    private static int getDia(List<PeriodoFerias> periodos, int diaIndex) {
        int count = 0;
        for (PeriodoFerias periodo : periodos) {
            for (int dia : periodo.dias) {
                if (count == diaIndex) {
                    return dia;
                }
                count++;
            }
        }
        throw new IllegalArgumentException("Dia index fora do intervalo.");
    }
}


