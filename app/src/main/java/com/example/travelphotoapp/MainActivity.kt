package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var places = arrayOf("Phi Phi island","Switzerland","Sinhgad Fort","Nepal","New York")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)

        next.setOnClickListener {
            // I want to get the next image
            var idCurrentImageString ="pic$currentImage"

            // I have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage + 1)%5
            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            placeName.text = places[currentImage]
        }

        prev.setOnClickListener{
            // I want to see the previous image
            var idCurrentImagestring = "pic$currentImage"

            // I have to get the Integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImagestring,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage - 1)%5
            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            placeName.text = places[currentImage]

        }
    }
}