package com.example.homework10

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt
import com.example.homework10.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val fragList = listOf(
        Equations.newInstance(),
        Quadraticequations.newInstance(),
        Randomequations.newInstance()
    )
    private val fragListTitles = listOf(
        "Equations",
        "Quadratic equations",
        "Random equations"
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) { // ax + b = c // x = (c-b)/a
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = VpAdapter(this, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.ourtablayout, binding.vp2){
                tab, pos -> tab.text = fragListTitles[pos]
        }.attach()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.x ->{
                Toast.makeText(this, "Equations", Toast.LENGTH_SHORT).show()
            }
            R.id.xx ->Toast.makeText(this, "Quadratic equations", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}