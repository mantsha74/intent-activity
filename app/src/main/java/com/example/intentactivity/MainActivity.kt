package com.example.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etText:EditText = findViewById(R.id.et_text)

        //it will open second activity
        val btnIntent:Button = findViewById(R.id.btn_intent)

        btnIntent.setOnClickListener {

            var writtenText=etText.text.toString()
            if (writtenText.isEmpty()){
                writtenText = "empty tha"
            }
            //explicit intent
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            //passing data between activity
            intent.putExtra("text_by_user", writtenText)
            startActivity(intent)


        }


    }
}