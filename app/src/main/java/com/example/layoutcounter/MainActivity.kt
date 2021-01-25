/*
    Author: Anastasiia Egorova, GEx Sr
    Project: Android Programming, Assignment1
    Date: January 24, 2021
*/


package com.example.layoutcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.layoutcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var number: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.numberToShow = number.toString()

        binding.apply {
            countupButton.setOnClickListener { add() }
            countdownButton.setOnClickListener { subtract() }
            toastButton.setOnClickListener { showToast() }
        }
    }

    private fun add() {
        number++
        binding.numberToShow = number.toString()
    }

    private fun subtract() {
        number--
        binding.numberToShow = number.toString()
    }

    private fun showToast() {
        Toast.makeText(applicationContext, "Hello " + number.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("savedNumber", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt("savedNumber")

        binding.apply{
            numberToShow = number.toString()
            //invalidateAll()
        }
    }
}