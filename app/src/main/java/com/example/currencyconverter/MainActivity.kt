package com.example.currencyconverter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
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
    private val AED = "United Arab Emirates Dirham"
    private val GBP = "GBP"
    private val Euro = "Euro"
    private val Yuan = "Yuan"
    private val Rupee = "Rupee"
    private val Afghan  = "Afghan"
    private val Albanian_Lek  = "Albanian Lek"
    private val Algerian_Dinar  = "Algerian Dinar"
    private val Angolan_Kwanza  = "Angolan Kwanza"
    private val Argentine_Peso  = "Argentine Peso"
    private val Armenian_Dram = "Armenian Dram"
    private val Aruban_Florin = "Aruban Florin"
    private val Australian_Dollar = "Australian Dollar"
    private val Azerbaijani_Manat = "Azerbaijani Manat"
    private val Bahamian_Dollar = "Bahamian Dollar"
    private val Bahraini_Dinar = "Bahraini Dinar"
    private val Bangladeshi_Taka = "Bangladeshi Taka"
    private val Barbadian_Dollar = "Barbadian Dollar"
    private val Belarusian_Ruble = "Belarusian Ruble"
    private val Belize_Dollar = "Belize Dollar"
    private val Bermudan_Dollar = "Bermudan Dollar"
    private val Bhutanese_Ngultrum = "Bhutanese Ngultrum"
    private val Boliviano = "Bolivian Boliviano"
    private val Bosnia_Mark = "Bosnia-Herzegovina Convertible Mark"
    private val Botswanan_Pula = "Botswanan Pula"
    private val Brazilian_Real = "Brazilian Real"
    private val Brunei_Dollar = "Brunei Dollar"
    private val Bulgarian_Lev = "Bulgarian Lev"
    private val Burundian_Franc = "Burundian Franc"
    private val CFP_Franc = "CFP Franc"
    private val Cambodian_riel = "Cambodian riel"
    private val Cape_Verdean_Escudo = "Cape Verdean Escudo"
    private val Cayman_Islands_Dollar = "Cayman Islands Dollar"
    private val franc = "Central African CFA franc"
    private val Chilean_Peso = "Chilean Peso"
    private val UF = "Chilean Unit of Account (UF)"
    private val Yuan_offshore = "Yuan (offshore)"
    private val Peso = "Colombian Peso"
    private val  Comorian_Franc = " Comorian Franc"
    private val Congolese_Franc = "Congolese Franc"
    private val Costa_Rican_Colón = "Costa Rican Colón"
    private val Cuban_Peso = "Cuban Peso"
    private val Czech_Koruna= "Czech Koruna"
    private val Danish_Krone = "Danish Krone"
    private val Djiboutian_Franc = "Djiboutian Franc"
    private val Dominican_Peso = "Dominican Peso"
    private val East_Caribbean_Dollar = "East Caribbean Dollar"
    private val Fijian_Dollar = "Fijian Dollar"
    private val Gambian = "Gambian Dalasi"
    private val Lari = "Georgian Lari"
    private val Cedi = "Ghanaian Cedi"
    private val Quetzal = "Guatemalan Quetzal"
    private val Guinean_Franc = "Guinean Franc"
    private val Guyanaese_Dollar = "Guyanaese Dollar"
    private val Gourde = "Haitian Gourde"
    private val Lempira = "Honduran Lempira"
    private val Hong_Kong_Dollar = "Hong Kong Dollar"
    private val Forint = "Hungarian Forint"
    private val Króna = "Icelandic Króna"
    private val Rupiah = "Indonesian Rupiah"
    private val Iranian_Rial = "Iranian Rial"
    private val Iraqi_Dinar = "Iraqi Dinar"
    private val Shekel = "Shekel"
    private val Jamaican_Dollar = "Jamaican Dollar"
    private val Japanese_Yen = "Japanese Yen"
    private  val Jordanian_Dinar = "Jordanian Dinar"
    private val Tenge = "Kazakhstani Tenge"
    private val Shilling = "Kenyan Shilling"
    private val Kuwaiti_Dinar = "Kuwaiti Dinar"
    private val Kyrgystani_Som = "Kyrgystani Som"
    private val Kip = "Laotian Kip"
    private val Lebanese = "Lebanese pound"
    private val Lesotho = "Lesotho Loti"
    private val Liberian = "Liberian"
    private val Libyan_Dinar = "Libyan Dinar"
    private val Pataca = "Macanese Pataca"
    private val Macedonian = "Macedonian Denar"
    private val Malagasy = "Malagasy Ariary"
    private val Kwacha = "Malawian Kwacha"
    private val Malaysian = "Malaysian Ringgit"
    private val Maldivian = "Maldivian Rufiyaa"
    private val Mauritian_Rupee = "Mauritian Rupee"
    private val Mexican_Peso = "Mexican Peso"
    private val Leu = "Moldovan Leu"
    private val Moroccan_Dirham = "Moroccan Dirham"
    private val Mozambican = "Mozambican metical"
    private val Kyat = "Myanmar Kyat"
    private val Namibian = "Namibian Dollar"
    private val Nepalese ="Nepalese Rupee"
    private val Netherlands = "Netherlands Antillean Guilder"
    private val Taiwan = "New Taiwan dollar"
    private val Zealand = "New Zealand Dollar"
    private val Nigerian ="Nigerian Naira"
    private val Norwegian ="Norwegian Krone"
    private val Omani ="Omani Rial"
    private val Pakistani = "Pakistani Rupee"
    private val Panamanian = "Panamanian Balboa"
    private val  Papua = "Papua New Guinean Kina"
    private val Paraguayan = "Paraguayan Guarani"
    private val Polish = "Polish Zloty"
    private val Pound = "Pound sterling"
    private val Qatari = "Qatari Riyal"
    private val Romanian = "Romanian Leu"
    private val Russian = "Russian Ruble"
    private val Rwandan = "Rwandan Franc"
    private val Salvadoran = "Salvadoran Colón"
    private val Saudi= "Saudi Riyal"
    private val Serbian = "Serbian Dinar"
    private val Seychellois= "Seychellois Rupee"
    private val Singapore = "Singapore Dollar"
    private val Sol = "Sol"
    private val Solomon ="Solomon Islands Dollar"
    private val Somali = "omali Shilling"
    private val South = "South African Rand"
    private val won = "South Korean won"
    private val Sovereign = "Sovereign Bolivar"
    private val Sri = "Sri Lankan Rupee"
    private val Sudanese = "Sudanese pound"
    private val Surinamese = "Surinamese Dollar"
    private val Swazi = " Swazi Lilangeni"
    private val Swedish = "Swedish Krona"
    private val Swiss = "Swiss Franc"
    private val Tajikistani = "Tajikistani Somoni"
    private val Tanzanian = "Tanzanian Shilling"
    private val Thai = "Thai Baht"
    private val Trinidad= "Trinidad & Tobago Dollar"
    private val Tunisian = "Tunisian Dinar"
    private val Turkmenistani = "Turkmenistani Manat"
    private val Ugandan = "Ugandan Shilling"
    private val Ukrainian = "Ukrainian hryvnia"
    private val Uruguayan = "Uruguayan Peso"
    private val Uzbekistani = "Uzbekistani Som"
    private val Vietnamese = "Vietnamese dong"
    private val West_African = "West African CFA franc"
    private val Yemeni = "Yemeni Rial"
    private val Zambian = "Zambian Kwacha"



    val values = mapOf(
        americanDollar to 1.0, egyptianPound to 30.95,
        AED to 3.67 , GBP to 0.81, Euro to 0.94, Yuan to 7.08,
        Rupee to 82.68, Afghan to 87.56, Albanian_Lek to 102.65,
        Algerian_Dinar to 136.92, Angolan_Kwanza to 565.00,
        Argentine_Peso to 238.86 , Armenian_Dram to 385.09, Aruban_Florin to 1.80,
        Australian_Dollar to 1.54 , Azerbaijani_Manat to 1.70, Bahamian_Dollar to 1.00,
        Bahraini_Dinar to 0.38 , Bangladeshi_Taka to 107.26, Barbadian_Dollar to 2.02,
        Belarusian_Ruble to 2.52, Belize_Dollar to 2.02 , Bermudan_Dollar to 1.00,
        Bhutanese_Ngultrum to 82.67, Boliviano to 6.91, Bosnia_Mark to 1.82,
        Bosnia_Mark to 13.77 , Brazilian_Real to 5.04, Brunei_Dollar to 1.35,
        Bulgarian_Lev to 1.83 , Burundian_Franc to 2820.44, CFP_Franc to 111.82,
        Cambodian_riel to 4109.35, Cape_Verdean_Escudo to 102.72,Cape_Verdean_Escudo to 0.83,
        franc to 611.03, Chilean_Peso to 804.85, UF to 0.022,Yuan_offshore to 7.12, Peso to 4393.00,
        Comorian_Franc to 459.45, Congolese_Franc to 2335.00, Costa_Rican_Colón to 540.56,
        Cuban_Peso to 23.99, Czech_Koruna to 22.18 , Danish_Krone to 6.98, Djiboutian_Franc to 177.99,
        Dominican_Peso to 54.69, East_Caribbean_Dollar to 2.70, Fijian_Dollar to 2.26 , Gambian to 59.55,
        Lari to 2.59, Cedi to 11.15, Quetzal to 7.82, Guinean_Franc to 8594.00, Guyanaese_Dollar to 211.44,
        Gourde to 140.78 , Lempira to 24.58, Hong_Kong_Dollar to 7.83 , Forint to 347.46, Króna to 139.94,
        Rupiah to 14999.50, Iranian_Rial to 42325.00, Iranian_Rial to 1309.62 , Shekel to 3.72,
        Jamaican_Dollar to 153.84 , Japanese_Yen to 139.70, Jordanian_Dinar to 0.71, Tenge to 447.31,
        Shilling to 138.60,Kuwaiti_Dinar to 0.31, Kyrgystani_Som to 87.59,Kip to 17731.39, Lebanese to 15000.23,
        Lesotho to 19.71 , Liberian to 168.38, Libyan_Dinar to 4.82, Pataca to 8.07,Macedonian to 57.78,
        Malagasy to 4405.11, Kwacha to 1026.06,Malaysian to 4.62 , Maldivian to 15.31,Mauritian_Rupee to 45.60,
        Mexican_Peso to 17.65 , Leu to 17.80, Moroccan_Dirham to 10.21 ,Mozambican to 63.25,Kyat to 2099.32,
        Namibian to 19.72,Nepalese to 131.84,Netherlands to 1.80,Taiwan to 30.68,Zealand to 1.65,Nigerian to 461.26,
        Norwegian to 11.06, Omani to 0.39, Pakistani to 285.19, Panamanian to 1.00,Papua to 3.59, Paraguayan to 7270.57,
        Polish to 4.20, Pound to 0.80,Qatari to 3.64,Romanian to 4.62, Russian to 81.00,Rwandan to 1128.44,Salvadoran to 8.75,
        Saudi to 3.75 , Serbian to 108.95, Seychellois to 14.02, Singapore to 1.35, Sol to 3.67, Solomon to 8.33,
        Somali to 568.50, South to 19.62 , won to 1315.72 , Sovereign to 26.13, Sri to 294.89 , Sudanese to 601.00,
        Surinamese to 37.83 , Swazi to 19.77, Swedish to 10.82 , Swiss to 0.91,Tajikistani to 10.87,Tanzanian to 2364.00,
        Thai to 34.58,Trinidad to 6.73,Tunisian to 3.09, Turkmenistani to 3.50, Ugandan to 3732.66, Ukrainian to 36.75,
        Uruguayan to 38.56,Uzbekistani to 11352.96, Vietnamese to 23471.00,West_African to 609.48, Yemeni to 250.35,
        Zambian to 19.43
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fvb()
        adapter()

        textAmount.addTextChangedListener {
            cal()}
        fromConutry.setOnItemClickListener { parent, view, position, id ->
            cal()}
        toConutry.setOnItemClickListener { parent, view, position, id ->
            cal()}


    }

    /* btuConvert.setOnClickListener {
           cal()
        }*/
    /*val snake =  Snackbar.make(textAmount, "Amount is Empty.", Snackbar.LENGTH_SHORT)
                   snake.show()
                   snake.setAction("ok"){

                   }*/
    //Toast.makeText(this, "Amount is Empty." ,Toast.LENGTH_SHORT).show()
    /*if (from == "$" || from == "USD" && to == "£" || to == "EGP") {
        result = amount.times(30.90)
    } else if (from == "£" || from == "EGP" && to == "$" || to == "USD") {
        result = amount.div(30.90)
    }else{
        Toast.makeText(this, "Check your Enters", Toast.LENGTH_SHORT).show()
    }*/

    // resultEdit.setText(result.toString())

    /*if (from == "KWD" || from == "د.ك" && to == "£" || to == "EGP"){
        result = amount / 100.51
    }else if (from == "£" || from == "EGP" && to == "KWD" || to == "د.ك"){
        result = amount.times(100.51)*/

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
            var result = to?.div(from!!)?.let { amount.times(it) }
            val format = String.format("%.3f", result)
            resultEdit.setText(format)
        }
    }

   private fun adapter(){
        val list = listOf(americanDollar,Afghan,Albanian_Lek,Algerian_Dinar,
            Angolan_Kwanza,Argentine_Peso,Armenian_Dram,Aruban_Florin,Australian_Dollar,
            Azerbaijani_Manat,Bahamian_Dollar,Bahraini_Dinar,Bangladeshi_Taka,Barbadian_Dollar,
            Belarusian_Ruble,Belize_Dollar,Bermudan_Dollar,Bhutanese_Ngultrum,Boliviano,Bosnia_Mark,
            Botswanan_Pula,Brazilian_Real ,Brunei_Dollar,Bulgarian_Lev,Burundian_Franc,CFP_Franc,
            Cambodian_riel,Cape_Verdean_Escudo,Cayman_Islands_Dollar,franc,Chilean_Peso,UF,
            Yuan,Yuan_offshore,Peso,Comorian_Franc,Congolese_Franc,Costa_Rican_Colón,Cuban_Peso,
            Czech_Koruna,Danish_Krone,Djiboutian_Franc,Dominican_Peso,East_Caribbean_Dollar,
            egyptianPound,Euro,Fijian_Dollar,Gambian,Lari,Cedi,Quetzal,GBP,Guinean_Franc,Guyanaese_Dollar,
            Gourde,Lempira,Hong_Kong_Dollar,Forint,Króna,Rupee,Rupiah,Iranian_Rial,Iraqi_Dinar,Shekel,
            Jamaican_Dollar,Jamaican_Dollar,Jordanian_Dinar,Tenge,Shilling,Kuwaiti_Dinar,Kyrgystani_Som,
            Kip,Lebanese,Lesotho,Liberian, Libyan_Dinar,Pataca,Macedonian,Malagasy,Kwacha,Malaysian,
            Maldivian,Mauritian_Rupee,Mexican_Peso,Leu,Moroccan_Dirham,Mozambican,Kyat,Namibian,Nepalese,
            Netherlands,Taiwan,Zealand,Nigerian,Norwegian,Omani,Pakistani,Panamanian,Papua,Paraguayan,
            Polish,Pound,Qatari,Romanian,Rwandan,Salvadoran,Saudi,Serbian,Seychellois,Singapore,Sol,
            Solomon,South,won,Sovereign,Sri,Sudanese,Surinamese,Swazi,Swedish,Swiss,Tajikistani,Tanzanian,Thai,
            Trinidad,Tunisian,Turkmenistani,Ugandan,Ukrainian,AED,Uruguayan,Uzbekistani,Vietnamese,
            West_African,Yemeni,Zambian)
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

    @SuppressLint("QueryPermissionsNeeded")
    fun share(view: View) {
        val share = Intent(Intent.ACTION_SEND)
        share.type = "text/plain"
        val message = "${textAmount.text.toString()} ${fromConutry.text.toString()}" +
                "is equal to ${resultEdit.text.toString()} ${toConutry.text.toString()}"
        share.putExtra(Intent.EXTRA_TEXT, message)
        if(share.resolveActivity(packageManager) !=null){
            startActivity(share)
        }
    }

}