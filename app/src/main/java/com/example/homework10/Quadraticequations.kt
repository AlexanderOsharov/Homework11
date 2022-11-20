package com.example.homework10

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.math.pow
import kotlin.math.sqrt


class Quadraticequations : Fragment() {
    private var editTextA: EditText? = null
    private var editTextB: EditText? = null
    private var editTextC: EditText? = null
    private var textViewX1: TextView? = null
    private var textViewX2: TextView? = null
    var mActivity: Activity? = this.activity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        editTextA = view?.findViewById(R.id.edit_text_a)
        editTextB = view?.findViewById(R.id.edit_text_b)
        editTextC = view?.findViewById(R.id.edit_text_c)
        textViewX1 = view?.findViewById(R.id.text_view_x1)
        textViewX2 = view?.findViewById(R.id.text_view_x2)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return inflater.inflate(R.layout.fragment_quadraticequations, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = Quadraticequations()
    }


    private fun getDoubleValue(editText: EditText?): Double {
        if (editText!!.text.toString().isEmpty()) {
            Toast.makeText(mActivity, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show()
            return 0.0
        }
        return editText.text.toString().toDouble()
    }
    private fun result(editText: EditText?): Double {
        if (editText!!.text.toString().isEmpty()) {
            Toast.makeText(mActivity, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show()
            return 0.0
        }
        return editText.text.toString().toDouble()
    }

    @SuppressLint("DefaultLocale", "SetTextI18n")
    fun click(view: View?) {
        val a = getDoubleValue(editTextA)
        val b = getDoubleValue(editTextB)
        val c = getDoubleValue(editTextC)
        val d = b.pow(2) - 4 * a * b
        if (d < 0) {
            textViewX1!!.text = "No solutions"
            textViewX2!!.text = "No solutions"
            Toast.makeText(mActivity, "No solutions", Toast.LENGTH_SHORT).show()
        }
        else if (d == 0.0){
            val x = -b / (2 * a)
            if (a == 0.0) {
                textViewX1!!.text = "No solutions"
                textViewX2!!.text = "No solutions"
                Toast.makeText(mActivity, "No solutions", Toast.LENGTH_SHORT).show()
            }
            else {
                textViewX1!!.text = String.format("%.2f", x)
                Toast.makeText(mActivity, "x1 = $x", Toast.LENGTH_SHORT).show()
                textViewX2!!.text = "No solutions"
                Toast.makeText(mActivity, "x2 = no solutions", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            val x = (-b + sqrt(d)) / (2 * a)
            textViewX1!!.text = String.format("%.2f", x)
            Toast.makeText(mActivity, "x1 = $x", Toast.LENGTH_SHORT).show()
            val x2 = (-b - sqrt(d)) / (2 * a)
            textViewX2!!.text = String.format("%.2f", x2)
            Toast.makeText(mActivity, "x2 = $x2", Toast.LENGTH_SHORT).show()
        }
    }
}