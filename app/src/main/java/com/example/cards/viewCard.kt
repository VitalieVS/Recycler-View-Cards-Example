package com.example.cards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.viewcardhotel.*

class ViewCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewcardhotel)
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val bundle = intent.extras
        if (bundle != null) {
            val image = bundle.getInt("resId")
            imageExample.setImageResource(image)
        }
      exampleName.text = title
      exampleDescription.text = description
    }
}