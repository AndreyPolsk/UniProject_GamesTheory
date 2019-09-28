package com.example.uniproject_gamestheory.calculations

class WaldsMaximin(private val arrayMain: Array<Array<Float>>) {
    private val outerSize = arrayMain.size
    private val innerSize = arrayMain[0].size
    private val resultArray = Array(outerSize) { 0F }

    private fun fillResultArray() {
        for (i in 0 until outerSize) {
            resultArray[i] = arrayMain[i].min()!!
        }
    }

    fun getWaldsArray(): Array<Float> {
        fillResultArray()
        return resultArray
    }

    fun getResult(): Int {
        val array = getWaldsArray()
        return array.indexOf(array.max()!!)+1
    }
}