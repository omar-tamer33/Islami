package com.example.islami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
   private var counter = 0
   private val list = listOf("الحمد لله","الله أكبر","سبحان الله")
   private var index = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.sebhaBody.setOnClickListener{
            binding.sebhaBody.rotation += 30f
            sebhaCounter()
            tasbeehText()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun sebhaCounter(){
        counter++
        binding.sebhaCounterTv.text = counter.toString()
    }

    private fun tasbeehText(){
        if (counter % 33 == 0){
            binding.sebhaTv.text = list[index]
            index = (index + 1) % list.size
        }
    }
}