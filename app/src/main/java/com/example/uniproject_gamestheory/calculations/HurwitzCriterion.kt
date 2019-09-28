class HurwitzCriterion(private val arrayMain: Array<Array<Float>>, private val multiplier: Float = 0.5F) {
    private val outerSize = arrayMain.size
    private val innerSize = arrayMain[0].size
    private val alphaArray = Array(outerSize) { 0F }
    private val betaArray = Array(outerSize) { 0F }

    private fun fillAlphaArray() {
        for (i in 0 until outerSize) {
            alphaArray[i] = arrayMain[i].min()!!
        }
    }

    private fun fillBetaArray() {
        for (i in 0 until outerSize) {
            betaArray[i] = arrayMain[i].max()!!
        }
    }

    private val arrayResult = Array(outerSize) { 0F }

    private fun fillArrayResult() {
        for (i in 0 until outerSize) {
            arrayResult[i] = multiplier * alphaArray[i] + (1 - multiplier) * betaArray[i]
        }
    }

    fun getHurwitzArray(): Array<Float> {
        fillAlphaArray()
        fillBetaArray()
        fillArrayResult()
        return arrayResult
    }

    fun getResult(): Int {
        val array = getHurwitzArray()
        return array.indexOf(array.max()!!)+1
    }


}