import kotlin.random.Random

class Matrix(
    private val innerSize: Int = 5,
    private val outerSize: Int = 7,
    var arrayMain: Array<Array<Float>> = Array(outerSize) { Array(innerSize) { 0F } },
    val arrayPossibility: Array<Float> = arrayOf(0.45F, 0.15F, 0.2F, 0.05F, 0.15F)
) {

    fun randomMainArray() {
        for (i in 0 until outerSize) {
            for (j in 0 until innerSize) {
                arrayMain[i][j] = Random.nextInt(0, 10).toFloat()
            }
        }
    }

    fun defaultMainArray() {
        arrayMain[0][0] = 4F
        arrayMain[0][1] = 4F
        arrayMain[0][2] = 2F
        arrayMain[0][3] = 1F
        arrayMain[0][4] = 3F
        arrayMain[1][0] = 7F
        arrayMain[1][1] = 4F
        arrayMain[1][2] = 1f
        arrayMain[1][3] = 2F
        arrayMain[1][4] = 1F
        arrayMain[2][0] = 5F
        arrayMain[2][1] = 2F
        arrayMain[2][2] = 3F
        arrayMain[2][3] = 4F
        arrayMain[2][4] = 5F
        arrayMain[3][0] = 4F
        arrayMain[3][1] = 7F
        arrayMain[3][2] = 6F
        arrayMain[3][3] = 1F
        arrayMain[3][4] = 2F
        arrayMain[4][0] = 2F
        arrayMain[4][1] = 3F
        arrayMain[4][2] = 5F
        arrayMain[4][3] = 7F
        arrayMain[4][4] = 5F
        arrayMain[5][0] = 2F
        arrayMain[5][1] = 1F
        arrayMain[5][2] = 6F
        arrayMain[5][3] = 1F
        arrayMain[5][4] = 2F
        arrayMain[6][0] = 4F
        arrayMain[6][1] = 4F
        arrayMain[6][2] = 2F
        arrayMain[6][3] = 2F
        arrayMain[6][4] = 1F
    }
}