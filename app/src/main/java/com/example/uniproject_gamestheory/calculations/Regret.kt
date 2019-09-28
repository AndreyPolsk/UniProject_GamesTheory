class Regret(private val arrayMain: Array<Array<Float>>) {
    private val outerSize = arrayMain.size
    private val innerSize = arrayMain[0].size
    private val invertedArrayMain = Array(innerSize) { Array(outerSize) { 0F } }

    private fun fillInvertedArrayMain() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                invertedArrayMain[j][i] = arrayMain[i][j]
            }
        }
    }

    private val riskArray = Array(outerSize) { Array(innerSize) { 0F } }

    private fun fillRiskArray() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                riskArray[i][j] = arrayMain[i][j] - invertedArrayMain[j].max()!!
            }
        }
    }

    private val resultArray = Array(outerSize) { 0F }

    private fun fillResultArray() {
        for (i in 0 until outerSize) {
            resultArray[i] = riskArray[i].max()!!
        }
    }

    fun getRegretArray(): Array<Float> {
        fillInvertedArrayMain()
        fillRiskArray()
        fillResultArray()
        return resultArray
    }

    fun getResult(): Int {
        val array = getRegretArray()
        return array.indexOf(array.min()!!)+1
    }

}