package com.example.calculatorsederhanaxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtPanjang : EditText
    private lateinit var edtLebar : EditText
    private lateinit var edtTinggi : EditText
    private lateinit var btnCalculate : Button
    private lateinit var txtResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPanjang = findViewById(R.id.et_panjang)
        edtLebar = findViewById(R.id.et_lebar)
        edtTinggi = findViewById(R.id.et_tinggi)
        btnCalculate = findViewById(R.id.btn_hitung)
        txtResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            txtResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,txtResult.text.toString())
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btn_hitung) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            when {
                inputPanjang.isEmpty() -> {
                    edtPanjang.error = "Field ini tidak boleh kosong"
                }

                inputLebar.isEmpty() -> {
                    edtLebar.error = "Field ini tidak boleh kosong"
                }

                inputTinggi.isEmpty() -> {
                    edtTinggi.error = "Field ini tidak boleh kosong"
                }

                else -> {
                    val hasil =
                        inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                    txtResult.text = hasil.toString()
                }
            }

        }
    }
}
