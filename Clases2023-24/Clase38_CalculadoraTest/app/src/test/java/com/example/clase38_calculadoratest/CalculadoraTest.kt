package com.example.clase38_calculadoratest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Tag

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.assertTimeout
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.Duration


class CalculadoraTest {

    fun datos(): ArrayList<Array<Int>> {
        return arrayListOf(
            arrayOf(1, 2, -1),
            arrayOf(4, 2, 2),
            arrayOf(7, 4, 3)
        )
    }

    @Timeout(1)
    @Test
    fun sumarTest() {
        //var calc= Calculadora()
        assertEquals(5, calc.sumar(2, 3))
        assertNotEquals(6, calc.sumar(2, 3))

        datos().forEach { dato ->
            assertEquals(dato[0], calc.sumar(dato[1], dato[2]))
        }

    }

    @Tag("testeos")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun restarTest(valor : Int) {
        assertEquals(valor, calc.restar(valor, 0))
        println("El valor es $valor")
    }

    @Tag("produccion")
    @ParameterizedTest
    @CsvFileSource(resources = ["/datos.csv"], numLinesToSkip = 1)
    @DisplayName("Prueba Multiplicación")
    fun multiplicarTest(oper1:Int,oper2:Int, resultado:Int) {
        assertEquals(resultado, calc.multiplicar(oper1, oper2))
    }

    @Tag("produccion")
    @Test
    @DisplayName("Prueba División")
    fun dividirTest() {
        //var calc= Calculadora()
        assertEquals(2, calc.dividir(6, 3))
        assertThrows(ArithmeticException::class.java) {
            calc.dividir(6, 0)
        }
        assertTimeout(Duration.ofSeconds(2)) {
            calc.dividir(6, 3)
        }

    }

    @RepeatedTest(8)
    @DisplayName("Prueba de repetición")
    fun testRepetido(info : RepetitionInfo) {
        assertEquals(2, calc.dividir(6, 3))
        println("Repetición ${info.currentRepetition} de ${info.totalRepetitions}")
    }

    companion object {
        lateinit var calc: Calculadora

        @JvmStatic
        @BeforeAll
        fun inicializar(): Unit {
            calc=Calculadora()
        }
    }
}