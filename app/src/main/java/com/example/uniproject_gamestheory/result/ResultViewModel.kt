package com.example.uniproject_gamestheory.result

import androidx.lifecycle.ViewModel
import com.example.uniproject_gamestheory.calculations.*

class ResultViewModel : ViewModel() {

    fun defaultResults(): Array<Int> {
        val matrix = Matrix()
        matrix.defaultMainArray()
        val arrayMain = matrix.arrayMain
        val arrayPossibility = matrix.arrayPossibility
        val bayes = BayesClassifier(arrayMain, arrayPossibility)
        val deviation = DeviationMatrix(arrayMain, arrayPossibility, bayes.getDefaultResultArray())
        val deviationMatrix = deviation.getDeviationMatrix()
        val counter = CounterMatrix(deviationMatrix, arrayPossibility)
        val walds = WaldsMaximin(arrayMain)
        val hurwitz05 = HurwitzCriterion(arrayMain, 0.5F)
        val hurwitz03 = HurwitzCriterion(arrayMain, 0.3F)
        val regret = Regret(arrayMain)
        return arrayOf(
            bayes.getResult(),
            counter.getVariationResult(),
            walds.getResult(),
            regret.getResult(),
            hurwitz05.getResult(),
            hurwitz03.getResult()
        )
    }
}