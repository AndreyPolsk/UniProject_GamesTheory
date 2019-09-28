package com.example.uniproject_gamestheory.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.uniproject_gamestheory.MainActivity
import com.example.uniproject_gamestheory.R
import com.example.uniproject_gamestheory.databinding.FragmentStartBinding
import com.example.uniproject_gamestheory.result.ResultFragment

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        binding.bDefault.setOnClickListener { (activity as MainActivity).setFragment(ResultFragment()) }

        return binding.root
    }
}