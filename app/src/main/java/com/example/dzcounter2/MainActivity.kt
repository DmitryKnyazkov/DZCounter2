package com.example.dzcounter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    var counter = 0

    val buttonReset by lazy { findViewById<Button>(R.id.buttonReset) }
    val remains by lazy { findViewById<TextView>(R.id.remains) }
    val button_minus by lazy { findViewById<Button>(R.id.button_minus) }
    val screenCounter by lazy { findViewById<TextView>(R.id.screenCounter) }
    val button_plus by lazy { findViewById<TextView>(R.id.button_plus) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_minus.setOnClickListener { count(-1) }
        button_plus.setOnClickListener { count(1) }
        buttonReset.setOnClickListener {
            counter = 0
            count(0)
        }
    }

    fun count(value: Int) {
        counter = counter + value
        screenCounter.text = counter.toString()
        update(counter)
    }

    fun update(counter: Int) {
        if (counter == 0) {
            remains.text = "Все места свободны"
            remains.setTextColor(getResources().getColor(R.color.green))
            button_minus.isEnabled = false
            buttonReset.isVisible = false
        }
        if (counter in 1..49) {
            remains.text = "Осталось мест: ${50 - counter}"
            remains.setTextColor(getResources().getColor(R.color.blue))
            button_minus.isEnabled = true
            buttonReset.isVisible = false}
        if (counter > 49) {
            remains.text = "Пассажиров слишком много"
            remains.setTextColor(getResources().getColor(R.color.red))
            button_minus.isEnabled = true
            buttonReset.isVisible = true
        }
    }
}