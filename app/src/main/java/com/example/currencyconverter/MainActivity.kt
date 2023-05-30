package com.example.currencyconverter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btuConvert: Button
    private lateinit var linkText: TextView
    private lateinit var fromConutry: AutoCompleteTextView
    private lateinit var toConutry: AutoCompleteTextView
    private lateinit var textAmount: TextInputEditText
    private lateinit var resultEdit: TextInputEditText

    private val egyptianPound = "Egyptian Pound"
    private val americanDollar = "American Dollar"
    private val AED = "AED"
    private val GBP = "GBP"
    private val Euro = "Euro"
    private val Yuan = "Yuan"
    private val Rupee = "Rupee"

    val values = mapOf(
        americanDollar to 1.0, egyptianPound to 30.90,
        AED to 3.67 , GBP to 0.81, Euro to 0.93, Yuan to 7.08,
        Rupee to 82.68
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fvb()
        adapter()

        textAmount.addTextChangedListener {
            cal()
        }
        fromConutry.setOnItemClickListener { parent, view, position, id ->
            cal()
        }
        toConutry.setOnItemClickListener { parent, view, position, id ->
            cal()
        }


    }


    private fun cal(){
        if (textAmount.text.toString().isEmpty()){
            textAmount.setError("Amount is Empty.")

        }else  if(fromConutry.text.toString() == toConutry.text.toString()){
            Snackbar.make(textAmount, "Chane currency", Snackbar.LENGTH_SHORT).show()
            resultEdit.setText(" ")
        }else{
            val from = values[fromConutry.text.toString()]
            val amount = textAmount.text.toString().toDouble()
            val to = values[toConutry.text.toString()]
            var result = amount.times(to!!.div(from!!))
            val format = String.format("%.3f", result)
            resultEdit.setText(format)
        }
    }

   private fun adapter(){
        val list = listOf(egyptianPound , americanDollar , AED ,GBP , Euro, Yuan, Rupee)
        val adapter = ArrayAdapter(this, R.layout.drop_down_list, list)
        fromConutry.setAdapter(adapter)
        toConutry.setAdapter(adapter)
    }
    private fun fvb(){
        fromConutry = findViewById(R.id.sCountry)
        toConutry = findViewById(R.id.sCountry2)
        btuConvert = findViewById(R.id.convert)
        textAmount = findViewById(R.id.Amount)
        resultEdit = findViewById(R.id.resultEdit)
        linkText = findViewById(R.id.link)
    }

    fun link(view: View) {
        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.xe.com/symbols/")).also {
            startActivity(it)

        }
    }
}