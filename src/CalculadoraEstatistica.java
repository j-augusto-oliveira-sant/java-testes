import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculadoraEstatistica {
    private List<Double> dados;

    public void setDados(List<Double> dados) {
        this.dados = dados;
    }

    public double calcularMedia() {
        double soma = 0.0;
        for (Double valor : dados) {
            soma += valor;
        }
        return soma / dados.size();
    }

    public double calcularMediana() {
        Collections.sort(dados);
        int tamanho = dados.size();
        if (tamanho % 2 == 0) {
            int meio1 = tamanho / 2 - 1;
            int meio2 = tamanho / 2;
            return (dados.get(meio1) + dados.get(meio2)) / 2.0;
        } else {
            int meio = tamanho / 2;
            return dados.get(meio);
        }
    }

    public double calcularVariancia() {
        double media = calcularMedia();
        double soma = 0.0;
        for (Double valor : dados) {
            soma += Math.pow(valor - media, 2);
        }
        return soma / dados.size();
    }

    public double calcularDesvioPadrao() {
        return Math.sqrt(calcularVariancia());
    }

    public List<Double> calcularModa() {
        Map<Double, Integer> mapaFrequencia = new HashMap<>();
        for (Double valor : dados) {
            mapaFrequencia.put(valor, mapaFrequencia.getOrDefault(valor, 0) + 1);
        }

        int frequenciaMaxima = Collections.max(mapaFrequencia.values());
        List<Double> modas = new ArrayList<>();
        for (Map.Entry<Double, Integer> entrada : mapaFrequencia.entrySet()) {
            if (entrada.getValue() == frequenciaMaxima) {
                modas.add(entrada.getKey());
            }
        }

        return modas;
    }
}
