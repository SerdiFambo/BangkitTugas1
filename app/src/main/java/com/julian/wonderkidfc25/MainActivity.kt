package com.julian.wonderkidfc25

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wonderkidList = listOf<Wonderkid>(
            Wonderkid(
                R.drawable.jude,
                "Jude Bellingham",
                arrayOf("Pace: 80", "Shooting: 83", "Passing: 81", "Dribbling: 87", "Defending: 78", "Physical: 83")
            ),
            Wonderkid(
                R.drawable.camavinga,
                "Eduardo Camavinga",
                arrayOf("Pace: 82", "Shooting: 75", "Passing: 80", "Dribbling: 84", "Defending: 79", "Physical: 80")
            ),
            Wonderkid(
                R.drawable.wirtz,
                "Florian Wirtz",
                arrayOf("Pace: 79", "Shooting: 81", "Passing: 83", "Dribbling: 88", "Defending: 72", "Physical: 76")
            ),
            Wonderkid(
                R.drawable.doku,
                "Jeremy Doku",
                arrayOf("Pace: 90", "Shooting: 78", "Passing: 76", "Dribbling: 89", "Defending: 70", "Physical: 75")
            ),
            Wonderkid(
                R.drawable.gavi,
                "Pablo Gavi",
                arrayOf("Pace: 81", "Shooting: 79", "Passing: 82", "Dribbling: 85", "Defending: 77", "Physical: 74")
            ),
            Wonderkid(
                R.drawable.gravenberch,
                "Ryan Gravenberch",
                arrayOf("Pace: 78", "Shooting: 80", "Passing: 83", "Dribbling: 81", "Defending: 74", "Physical: 79")
            ),
            Wonderkid(
                R.drawable.musiala,
                "Jamal Musiala",
                arrayOf("Pace: 85", "Shooting: 78", "Passing: 81", "Dribbling: 90", "Defending: 70", "Physical: 72")
            ),
            Wonderkid(
                R.drawable.pedri,
                "Pedri",
                arrayOf("Pace: 80", "Shooting: 77", "Passing: 85", "Dribbling: 88", "Defending: 72", "Physical: 70")
            ),
            Wonderkid(
                R.drawable.warren,
                "Warren Zaire-Emery",
                arrayOf("Pace: 84", "Shooting: 76", "Passing: 78", "Dribbling: 80", "Defending: 73", "Physical: 77")
            ),
            Wonderkid(
                R.drawable.gvardiol,
                "Josko Gvardiol",
                arrayOf("Pace: 75", "Shooting: 70", "Passing: 72", "Dribbling: 76", "Defending: 88", "Physical: 84")
            )
        )


        val recyclerView = findViewById<RecyclerView>(R.id.rv_player)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = WonderkidAdapter(this, wonderkidList){
            val intent = Intent(this, DetailWonderkidActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }


    }
}