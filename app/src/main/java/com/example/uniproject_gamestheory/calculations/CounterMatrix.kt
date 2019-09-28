import kotlin.math.pow
import kotlin.math.sqrt

class CounterMatrix(
    private val deviationMatrix: Array<Array<Float>>,
    private val arrayPossibility: Array<Float>
) {
    private val innerSize = deviationMatrix[0].size
    private val outerSize = deviationMatrix.size
    private val counterMatrix = Array(outerSize) { Array(innerSize) { 0F } }

    private fun fillCounterMatrix() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                counterMatrix[i][j] = if (deviationMatrix[i][j] < 0) 1F else 0F
            }
        }
    }

    private val semiDispersion1 = Array(innerSize) { 0F }
    private val semiDispersion2 = Array(innerSize) { 0F }
    private val semiDispersionResult = Array(outerSize) { 0F }
    private val semiVariation = Array(outerSize) { 0F }

    private fun fillSemiDispersion() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                semiDispersion1[j] = (deviationMatrix[i][j].pow(2) * arrayPossibility[j] * counterMatrix[i][j])
                semiDispersion2[j] = (arrayPossibility[j] * counterMatrix[i][j])
            }
            semiDispersionResult[i] = semiDispersion1.sum() / semiDispersion2.sum()
        }
    }

    private fun fillSemiVariation() {
        for (i in 0 until outerSize) {
            semiVariation[i] = sqrt(semiDispersionResult[i]) / outerSize
        }
    }

    fun getCounterMatrix(): Array<Array<Float>> {
        fillCounterMatrix()
        return counterMatrix
    }

    fun getSemiDispersion(): Array<Float> {
        fillCounterMatrix()
        fillSemiDispersion()
        return semiDispersionResult
    }

    fun getSemiVariation(): Array<Float> {
        fillCounterMatrix()
        fillSemiDispersion()
        fillSemiVariation()
        return semiVariation
    }

    fun getDispersionResult(): Int {
        val array = getSemiDispersion()
        return array.indexOf(array.min()!!)+1
    }

    fun getVariationResult(): Int {
        val array = getSemiVariation()
        return array.indexOf(array.min()!!)+1
    }

}