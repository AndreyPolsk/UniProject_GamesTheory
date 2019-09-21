package com.example.uniproject_gamestheory.enterData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.uniproject_gamestheory.R
import com.example.uniproject_gamestheory.databinding.FragmentEnterBinding

class EnterDataFragment: Fragment() {

    private lateinit var binding: FragmentEnterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter, container, false)

        return binding.root
    }
}