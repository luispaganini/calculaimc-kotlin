package com.calculaimc_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener{
            btLimparOnClick()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun btCalcularOnClick() {
        if (etPeso.text.toString().isEmpty()) {
            etPeso.error = getString(R.string.campo_peso_deve_ser_preenchido)
            etPeso.requestFocus()
            return
        }
        if (etAltura.text.toString().isEmpty()) {
            etAltura.error = getString(R.string.campo_altura_deve_ser_preenchida)
            etAltura.requestFocus()
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val df = NumberFormat.getNumberInstance(Locale.getDefault())

        tvResultado.text = df.format(Calculo().calculaIMC(peso, altura, Locale.getDefault().language))
    }

    private fun btLimparOnClick() {
        etPeso.setText("")
        etAltura.setText("")
        tvResultado.text = getString(R.string.zeros)
        etPeso.requestFocus()
        Toast.makeText(this, getString(R.string.tela_reniciada), Toast.LENGTH_LONG).show()
    }

    class Calculo() {
        fun calculaIMC(peso: Double, altura: Double, language: String): Double {
            var imc = 0.0
            if (language == "en")
                imc = 703 * (peso / altura.pow(2))
            else
                imc = peso / altura.pow(2)

            return imc
        }
    }
}