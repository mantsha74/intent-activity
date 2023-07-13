package com.example.intentactivity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.Serializable

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //reciveing the data from the first activity
        val textByUser:String = intent.serializable("text_by_user")!!

        val tvText:TextView? = findViewById(R.id.tv_second_activity)
        tvText?.text = textByUser.toString()


    }

    private inline fun <reified  T:Serializable> Intent.serializable(key:String):T? = when{
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key,T::class.java)
        else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
    }
}