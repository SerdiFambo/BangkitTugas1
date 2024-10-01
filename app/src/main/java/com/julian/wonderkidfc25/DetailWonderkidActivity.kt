package com.julian.wonderkidfc25

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailWonderkidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wonderkid)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val wonderkid = intent.getParcelableExtra<Wonderkid>(MainActivity.INTENT_PARCELABLE)

        val imgWonderkid = findViewById<ImageView>(R.id.img_item_photo)
        val nameWonderkid = findViewById<TextView>(R.id.rv_item_name)
        val descWonderkid = findViewById<TextView>(R.id.rv_item_description)

        if (wonderkid != null) {
            imgWonderkid.setImageResource(wonderkid.imgWonderkid)
            nameWonderkid.text = wonderkid.nameWonderkid ?: "Nama tidak tersedia"

            // Display attributes as a list
            val attributes = wonderkid.descWonderkid
            descWonderkid.text = attributes.joinToString("\n") // Join attributes with line breaks
        } else {
            imgWonderkid.setImageResource(R.drawable.camavinga) // Placeholder image
            nameWonderkid.text = "Data Kosong"
            descWonderkid.text = "Data kosong"
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
