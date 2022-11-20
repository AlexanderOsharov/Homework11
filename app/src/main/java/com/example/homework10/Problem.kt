package com.example.homework10
import android.annotation.SuppressLint
import com.example.homework10.databinding.FragmentRandomequationsBinding
import java.util.*
class Problem {
    var result = 0
        private set

    fun getRandom(min: Int, max: Int): Int {
        return (Math.random() * (max - min)).toInt() + min
    }

    val problem: String
        get() {
            var a = getRandom(-100, 100)
            var b = getRandom(-100, 100)
            while (b == 0) {
                b = getRandom(-100, 100)
            }
            val sign = randomSign
            if (sign == "+") result = a + b
            if (sign == "-") result = a - b
            if (sign == "*") result = a * b
            if (sign == "/") {
                a *= b
                result = a / b
            }
            return a.toString() + sign + b
        }
    val noiseResult: Int
        get() {
            var c = getRandom(-10, 10)
            while (c == 0) {
                c = getRandom(-10, 10)
            }
            return result + c
        }
    private val randomSign: String
        get() {
            val sign = getRandom(1, 5)
            if (sign == 1) return "+"
            if (sign == 2) return "-"
            return if (sign == 3) "*" else "/"
        }

    fun getScore(a: Int, b: Int): String {
        return "$a/$b"
    }
}