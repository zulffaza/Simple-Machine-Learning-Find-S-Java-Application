package example.finds;

/**
 * Aplikasi implementasi algoritma Find-S Machine Learning
 *
 * Dibuat oleh Faza Zulfika Permana Putra - 2110151023 - D4 Teknik Informatika PENS 2015
 * Pada tanggal 15 September 2017
 */
public class Main {

    /**
     * Dataset attribute, minimal instance attribute adalah 2, satu instance dan satu target
     */
    private static String[][] attributes = {
            {"Sunny", "Warm", "Normal", "Strong", "Warm", "Same", "Yes"},
            {"Sunny", "Warm", "High", "Strong", "Warm", "Same", "Yes"},
            {"Rainy", "Cold", "High", "Strong", "Warm", "Change", "No"},
            {"Sunny", "Warm", "High", "Strong", "Cool", "Change", "Yes"},
    };

    public static void main(String[] args) {
        getHypotesis("Yes");
        getHypotesis("No");
    }

    /**
     * Fungsi untuk penentuan hipotesa berdasarkan target yang diinginkan
     *
     * @param target adalah target yang diinginkan
     */
    private static void getHypotesis(String target) {
        int attributesLength = attributes.length;

        System.out.println("Search hypotesis with target \"" + target + "\"...");
        System.out.println("");

        if (attributesLength > 0) { // Pengecekan apakah attribute ada isinya
            int instanceLength = attributes[0].length;

            if (instanceLength > 1) { // Pengecekan apakah attribute minimal memiliki 2 instance
                instanceLength--; // Jumlah instance dikurangi satu agar tidak membaca target

                String[] hypotesis = new String[instanceLength]; // Membuat array hipotesis sebesar jumlah instance
                int attributeFirstIndex = 0;

                /*
                 * Pengambilan dataset pertama yang memiliki target yang diinginkan
                 */
                for (int i = 0; i < attributesLength; i++) {
                    if (attributes[i][instanceLength].equals(target)) {
                        attributeFirstIndex = i;
                        break;
                    }
                }

                /*
                 * Menyimpan dataset pertama di array hipotesis
                 */
                System.arraycopy(attributes[attributeFirstIndex], 0, hypotesis, 0, instanceLength);

                /*
                 * Proses membuat instance yang berbeda disetiap dataset mejadi '?'
                 */
                for (int i = 1; i < attributesLength; i++) {
                    if (attributes[i][instanceLength].equals(target)) {
                        for (int j = 0; j < instanceLength; j++) {
                            if (!hypotesis[j].equals(attributes[i][j]))
                                hypotesis[j] = "?";
                        }
                    }
                }

                /*
                 * Menampilkan hipotesis yang telah didapatkan
                 */
                for (String h : hypotesis)
                    System.out.println(h);

                System.out.println("");
            } else
                System.out.println("Instance must over than 1, and the last column mus be target...");
        } else
            System.out.println("Attribute is empty...");
    }
}
