import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculadoraEstatisticaTest {
    CalculadoraEstatistica calculadora = new CalculadoraEstatistica();

    @Test
    void calcularMedia() {
        List<Double> valores = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        calculadora.setDados(valores);
        assertEquals(3.0, calculadora.calcularMedia(), 0.001);
    }

    @Test
    void calcularMediana() {
        List<Double> valores = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        calculadora.setDados(valores);
        assertEquals(3.0, calculadora.calcularMediana(), 0.001);
    }

    @Test
    void calcularVariancia() {
        List<Double> valores = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        calculadora.setDados(valores);
        assertEquals(2.0, calculadora.calcularVariancia(), 0.001);
    }

    @Test
    void calcularDesvioPadrao() {
        List<Double> valores = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        calculadora.setDados(valores);
        assertEquals(1.4142135623730951, calculadora.calcularDesvioPadrao(), 0.001);
    }

    @Test
    void calcularModa() {
        List<Double> valores = Arrays.asList(1.0, 2.0, 2.0, 3.0, 4.0, 4.0, 5.0);
        calculadora.setDados(valores);
        List<Double> moda = calculadora.calcularModa();
        List<Double> modaEsperada = Arrays.asList(2.0, 4.0);
        assertTrue(moda.containsAll(modaEsperada) && modaEsperada.containsAll(moda));
    }
}
