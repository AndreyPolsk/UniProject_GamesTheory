package com.example.uniproject_gamestheory.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.uniproject_gamestheory.R
import com.example.uniproject_gamestheory.databinding.FragmentResultBinding

class ResultFragment: Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        val resultArray = viewModel.defaultResults()
        binding.tvBayes.text = getString(R.string.bayes, resultArray[0].toString())
        binding.tvSemiVariat.text = getString(R.string.semivar, resultArray[1].toString())
        binding.tvWald.text = getString(R.string.walds, resultArray[2].toString())
        binding.tvRegret.text = getString(R.string.savages, resultArray[3].toString())
        binding.tvHurwitz05.text = getString(R.string.hurwitz05, resultArray[4].toString())
        binding.tvHurwitz03.text = getString(R.string.hurwitz03, resultArray[5].toString())
        return binding.root
    }
}