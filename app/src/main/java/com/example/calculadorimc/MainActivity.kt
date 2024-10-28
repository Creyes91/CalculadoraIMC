package com.example.calculadorimc

import android.health.connect.datatypes.WeightRecord
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculadorimc.R.string.Obesity
import com.google.android.material.slider.Slider

import java.util.Locale
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var txtHeight: TextView
    lateinit var sldrHeight: Slider
    lateinit var minusBtn: Button
    lateinit var txtWeight: TextView
    lateinit var addBtn: Button
    lateinit var calcBtn: Button
    lateinit var txtResult: TextView
    lateinit var txtDescription: TextView
    private var height : Int = 175
    private var weight : Int = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtHeight= findViewById(R.id.tvHeight)
        sldrHeight=findViewById(R.id.sliderHeight)
        minusBtn=findViewById(R.id.minusBtn)
        addBtn=findViewById(R.id.addBtn)
        calcBtn=findViewById(R.id.calcBtn)
        txtResult=findViewById(R.id.tvResult)
        txtDescription=findViewById(R.id.tvDescription)

        sldrHeight

        calcBtn.setOnClickListener {


             weight = txtWeight.text.toString().toInt()
            val result = 20.00//(weight / (height / 100).pow(2))
             txtResult.text = String.format("%.2f",result)

            when (result) {
                in 0.00..< 18.5 -> {
                    setColorText(R.color.uWeight, R.string.uWeight)

                }

                in 18.5..< 25.0 -> {
                    Log.i("MainActivity", "boton")
                    setColorText(R.color.nWeight, R.string.nWeight)
                }

                in 25.00..< 30.00 -> {
                    setColorText(R.color.eWeight, R.string.eWeight)
                }

                else -> {
                    setColorText(R.color.Obesity, Obesity)
                }


        }





        }

    }

    private fun setColorText(colorRes: Int, txtRes: Int) {
        val color= getColor(colorRes)
        txtDescription.setTextColor(color)
        txtResult.setTextColor(color)
        txtDescription.setText(txtRes)

    }

    // fuera de on create funciones

}