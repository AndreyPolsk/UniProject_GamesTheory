package com.example.uniproject_gamestheory.calculations

class BayesClassifier(
    private val arrayMain: Array<Array<Float>>,
    private val arrayPossibility: Array<Float>
) {
    private val innerSize: Int = arrayMain[0].size
    private val outerSize: Int = arrayMain.size
    private var arrayResult = Array(outerSize) { 0.0F }
    private var arrayNumberResult = 0

    private fun countClassifier(array: Array<Float>, arrayOfPossibilities: Array<Float>): Float {
        val arrayResult = Array<Float>(array.size) { 0F }
        for (i in 0 until array.size) {
            arrayResult[i] = array[i] * arrayOfPossibilities[i]
        }
        return arrayResult.sum()
    }

    private fun countArrayOfClassifiers(array: Array<Array<Float>>, arrayOfPossibilities: Array<Float>): Array<Float> {
        val returnArray = Array<Float>(array.size) { 0.0F }
        for (i in 0 until array.size) {
            returnArray[i] = countClassifier(array[i], arrayOfPossibilities)
        }
        return returnArray
    }

    fun getDefaultResultArray(): Array<Float> {
        arrayResult = countArrayOfClassifiers(arrayMain, arrayPossibility)
        arrayNumberResult = arrayResult.indexOf(arrayResult.max())
        return arrayResult
    }

    fun getResult(): Int{
        val array = getDefaultResultArray()
        return array.indexOf(array.max()!!)+1
    }
}