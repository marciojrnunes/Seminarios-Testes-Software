import com.antonia.Calculadora;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculadora();
    }

    @Test
    public void testSoma() {
        int resultado = calc.somar(3, 7);
        assertThat(resultado, is(10));
    }

    @Test
    public void testSubtracao() {
        int resultado = calc.subtrair(10, 4);
        assertThat(resultado, equalTo(6));
    }

    @Test
    public void testMultiplicacao() {
        int resultado = calc.multiplicar(5, 5);
        assertThat(resultado, is(25));
    }

    @Test
    public void testDivisao() {
        int resultado = calc.dividir(20, 4);
        assertThat(resultado, is(not(0)));
        assertThat(resultado, is(5));
    }

    @Test
    public void testDivisaoPorZero() {
        Exception exception = null;

        try {
            calc.dividir(10, 0);
        } catch (ArithmeticException ex) {
            exception = ex;
        }

        assertThat(exception, is(notNullValue()));
        assertThat(exception.getMessage(), containsString("Divisão por zero"));
    }
}

