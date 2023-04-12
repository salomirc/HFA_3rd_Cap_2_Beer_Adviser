package com.getadroid.hfa_3rdcap2beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var findBeerButton: Button
    private lateinit var beerColorSpinner: Spinner
    private lateinit var brandsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findBeerButton = findViewById(R.id.find_beer_button)
        beerColorSpinner = findViewById(R.id.beer_color_spinner)
        brandsTextView = findViewById(R.id.brands_text_view)

        findBeerButton.setOnClickListener {
            val color = beerColorSpinner.selectedItem.toString()
            val beers = getBeers(color)
            brandsTextView.text = beers.joinToString(separator = ",\n")
        }
    }

    private fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }

}