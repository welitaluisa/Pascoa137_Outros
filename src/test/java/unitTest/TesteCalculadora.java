package unitTest;// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static br.com.iterasys.Calculadora.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Classes
public class TesteCalculadora {
    //Atributos
    // Funções e Métodos

    @Test
    public void testeSomarDoisNumeros() {
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;

        // Valores de saída
        double resultadoEsperado= 12;

        // Executa
       double resultadoAtual = Calculadora.somarDoisNumeros( num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @ParameterizedTest
    @CsvSource( value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            " -8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String txtNun1,String txtNun2,String resultadoEsperado ) {
        // Configura
        //  Os dados de entrada e resultado esperdo vem da lista
        // Valores de entrada


        // Valores de saída


        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNun1), Integer.valueOf(txtNun2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @ParameterizedTest
    @CsvFileSource( resources = "src/test/resources/csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String txtNun1,String txtNun2,String resultadoEsperado ) {
        // Configura
        //  Os dados de entrada e resultado esperdo vem da lista
        // Valores de entrada


        // Valores de saída


        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNun1), Integer.valueOf(txtNun2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @Test
    public void testeSubtrairDoisNumeros() {
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;

        // Valores de saída
        double resultadoEsperado= 2;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros( num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvSource( value = {
            "7, 5, 2.0",
            "56, 44, 12.0",
            "10, 0, 10.0",
            "15, -5, 20.0",
            " -8, -6, -2.0",
            "-1, -2, 1.0"
    }, delimiter = ',')
    public void testeSubtrairDoisNumerosLendoLista(String txtNun1,String txtNun2,String resultadoEsperado ) {
        // Configura
        //  Os dados de entrada e resultado esperdo vem da lista
        // Valores de entrada


        // Valores de saída


        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(txtNun1), Integer.valueOf(txtNun2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @Test
    public void testeMultiplicarDoisNumeros() {
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;

        // Valores de saída
        double resultadoEsperado= 35;

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros( num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvSource( value = {
            "7, 5,35.0",
            "56, 44, 2464.0",
            "40, 40, 1600.0",
            "10, 0, 0",
            "15, -5, -75.0",
            " -8, -6, 48.0",
            "-1, -2, 2.0",
            "0, 0, 0.0"
    }, delimiter = ',')
    public void testeMultiplicarDoisNumerosLendoLista(String txtNun1,String txtNun2,String resultadoEsperado ) {
        // Configura
        //  Os dados de entrada e resultado esperdo vem da lista
        // Valores de entrada


        // Valores de saída


        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(Integer.valueOf(txtNun1), Integer.valueOf(txtNun2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


    @Test
    public void testeDividirDoisNumeros() {
        // Configura
        // Valores de entrada
        double num1 = 4;
        double num2 =2 ;

        // Valores de saída
        double resultadoEsperado= 2;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros( num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void testeDividirPorzero() {
        // Configura
        // Valores de entrada
        double num1 = -100000;
        double num2 = 0 ;

        // Valores de saída
        double resultadoEsperado = 0;

                //= Double.NEGATIVE_INFINITY;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros( num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvSource( value = {
            "4, 2, 2",
            "100, 5, 20",
            "40, 40, 1",
            "10, 5, 2",
            "15, 5, 3",
            "8, 6, 1.3333333333333333",
            "0, 0, 0.0"
          }, delimiter = ',')
    public void testeDividirDoisNumerosLendoLista(String txtNun1,String txtNun2,String resultadoEsperado ) {
        // Configura
        //  Os dados de entrada e resultado esperdo vem da lista
        // Valores de entrada


        // Valores de saída


        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(Integer.valueOf(txtNun1), Integer.valueOf(txtNun2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testeDivirDoisNumerosInteiros(){
        int numA = 8;
        int numB = 0;
        String resultadoEsperado = "Não é possivel dividir por zero";

        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        assertEquals(resultadoEsperado,resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println(" O resultado esperado: " + resultadoEsperado);

    }

}
