package example.finds

/**
 * Aplikasi implementasi algoritma Find-S Machine Learning
 *
 * Dibuat oleh Faza Zulfika Permana Putra - 2110151023 - D4 Teknik Informatika PENS 2015
 * Pada tanggal 15 September 2017
 */
object MainKotlin {

    /**
     * Dataset attribute, minimal instance attribute adalah 2, satu instance dan satu target
     */
    private val attributes = arrayOf(
            arrayOf("Sunny", "Warm", "Normal", "Strong", "Warm", "Same", "Yes"),
            arrayOf("Sunny", "Warm", "High", "Strong", "Warm", "Same", "Yes"),
            arrayOf("Rainy", "Cold", "High", "Strong", "Warm", "Change", "No"),
            arrayOf("Sunny", "Warm", "High", "Strong", "Cool", "Change", "Yes")
    )

    @JvmStatic
    fun main(args: Array<String>) {
        getHypotesis("Yes")
        getHypotesis("No")
    }

    /**
     * Fungsi untuk penentuan hipotesa berdasarkan target yang diinginkan
     *
     * @param target adalah target yang diinginkan
     */
    private fun getHypotesis(target: String) {
        val attributesLength = attributes.size

        println("Search hypotesis with target \"$target\"...")
        println("")

        if (attributesLength > 0) { // Pengecekan apakah attribute ada isinya
            var instanceLength = attributes[0].size

            if (instanceLength > 1) { // Pengecekan apakah attribute minimal memiliki 2 instance
                instanceLength-- // Jumlah instance dikurangi satu agar tidak membaca target

                val hypotesis = arrayOfNulls<String>(instanceLength) // Membuat array hipotesis sebesar jumlah instance
                var attributeFirstIndex = 0

                /*
                 * Pengambilan dataset pertama yang memiliki target yang diinginkan
                 */
                for (i in 0..attributesLength - 1) {
                    if (attributes[i][instanceLength] == target) {
                        attributeFirstIndex = i
                        break
                    }
                }

                /*
                 * Menyimpan dataset pertama di array hipotesis
                 */
                System.arraycopy(attributes[attributeFirstIndex], 0, hypotesis, 0, instanceLength)

                /*
                 * Proses membuat instance yang berbeda disetiap dataset mejadi '?'
                 */
                for (i in 1..attributesLength - 1) {
                    if (attributes[i][instanceLength] == target) {
                        for (j in 0..instanceLength - 1) {
                            if (hypotesis[j] != attributes[i][j])
                                hypotesis[j] = "?"
                        }
                    }
                }

                /*
                 * Menampilkan hipotesis yang telah didapatkan
                 */
                for (h in hypotesis)
                    println(h)

                println("")
            } else
                println("Instance must over than 1, and the last column mus be target...")
        } else
            println("Attribute is empty...")
    }
}
