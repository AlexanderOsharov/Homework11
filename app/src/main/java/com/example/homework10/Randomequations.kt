package com.example.homework10

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework10.databinding.FragmentRandomequationsBinding
import kotlinx.android.synthetic.main.fragment_randomequations.*
import kotlinx.android.synthetic.main.fragment_randomequations.view.*
import java.lang.String
import kotlin.run


class Randomequations : Fragment() {

    private lateinit var binding: FragmentRandomequationsBinding
    private final val problem = Problem()
    var position = problem.getRandom(1, 4)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = FragmentRandomequationsBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).setContentView(binding.root)
        generateProblem()
        val listener: MyClickListener = MyClickListener()
        binding.next.setOnClickListener(listener)
        binding.solution1.setOnClickListener(listener)
        binding.solution2.setOnClickListener(listener)
        binding.solution3.setOnClickListener(listener)
        return inflater.inflate(com.example.homework10.R.layout.fragment_randomequations, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = Randomequations()
    }

    public fun generateProblem(){
        binding.problem.text = problem.problem
        binding.solution1.setBackgroundColor(0x80808050.toInt())
        binding.solution2.setBackgroundColor(0x80808050.toInt())
        binding.solution3.setBackgroundColor(0x80808050.toInt())
        val position_2 = problem.getRandom(1, 4)
        while (position_2 == position){
            position = problem.getRandom(1, 4)
        }
        when (position) {
            1 -> {
                binding.solution1.text = problem.result.toString()
                binding.solution2.text = problem.noiseResult.toString()
                binding.solution3.text = problem.noiseResult.toString()
            }
            2 -> {
                binding.solution1.text = problem.noiseResult.toString()
                binding.solution2.text = problem.result.toString()
                binding.solution3.text = problem.noiseResult.toString()
            }
            else -> {
                binding.solution1.text = problem.noiseResult.toString()
                binding.solution2.text = problem.noiseResult.toString()
                binding.solution3.text = problem.result.toString()
            }
        }
        binding.problem.text = problem.problem
        binding.solution1.text = problem.result.toString()
    }

    internal inner class MyClickListener : View.OnClickListener {
        var v = 0
        var f = 0
        override fun onClick(view: View) {
            run breaking@{
                when (view.id) {
                    com.example.homework10.R.id.next -> {
                        solution1.setBackgroundResource(R.color.holo_blue_bright)
                        solution2.setBackgroundResource(R.color.holo_blue_bright)
                        solution3.setBackgroundResource(R.color.holo_blue_bright)
                        generateProblem()
                        return@breaking
                    }
                    com.example.homework10.R.id.solution1, com.example.homework10.R.id.solution2, com.example.homework10.R.id.solution3 -> {
                        val text = (view as TextView).text.toString()
                        if (text == problem.result.toString()) {
                            v++
                            f++
                            problem.getScore(v, f)
                            view.setBackgroundColor(resources.getColor(R.color.holo_green_dark))
                            binding.score.text = String.valueOf(problem.getScore(v, f))
                        } else {
                            f++
                            problem.getScore(v, f)
                            view.setBackgroundColor(resources.getColor(R.color.holo_red_dark))
                            binding.score.text = String.valueOf(problem.getScore(v, f))
                        }
                    }
                }
            }
        }

    }


}