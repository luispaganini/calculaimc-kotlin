package com.calculaimc_kotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val imc = MainActivity.Calculo()

        assertTrue( "IMC calculado: ",  imc.calculaIMC( 80.0, 1.80, "pt" ) in 24.6 .. 24.7 )
    }
}