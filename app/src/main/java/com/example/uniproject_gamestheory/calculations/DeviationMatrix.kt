package com.example.uniproject_gamestheory.calculations

import kotlin.math.pow
import kotlin.math.sqrt

class DeviationMatrix(
    private val arrayMain: Array<Array<Float>>,
    private val arrayPossibility: Array<Float>,
    private val arrayBayesResult: Array<Float>
) {
    private val innerSize: Int = arrayMain[0].size
    private val outerSize: Int = arrayMain.size
    private val arrayDeviationMatrix = Array(outerSize) { Array(innerSize) { 0F } }
    private val arrayResultDeviationMatrix = Array(outerSize) { 0F }
    private val resultDeviationMatrix = Array(innerSize) { 0F }
    private val coefficient = Array(outerSize) { 0F }

    private fun fillArrayDeviationMatrix() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                arrayDeviationMatrix[i][j] = arrayMain[i][j] - arrayBayesResult[i]
            }
        }
    }

    fun fillArrayResultDeviationMatrix() {
        fillArrayDeviationMatrix()
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                resultDeviationMatrix[j] = arrayDeviationMatrix[i][j].pow(2) * arrayPossibility[j]
            }
            arrayResultDeviationMatrix[i] = resultDeviationMatrix.sum()
        }
    }

    fun countCoefficient() {
        for (i in 0 until outerSize) {
            coefficient[i] = sqrt(arrayResultDeviationMatrix[i]) / outerSize
        }
    }

    fun getDeviationMatrix(): Array<Array<Float>> {
        fillArrayDeviationMatrix()
        return arrayDeviationMatrix
    }
}