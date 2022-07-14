import java.util.Arrays;

public class Main {

    /**
     * Program amely a sumOfTwoEqualsK és better_sumOfTwoEqualsK függvények ellenőrzésére szolgál
     *
     */
    public static void main(String[] args) {
	int[] a = {1, 2, 10, -6, -8, 90, 100};
	int[] b = {12, 35, 16, 109, 48};
    int target = 112;
    //sums(a, b); //csak a manuális tesztelés megkönnyítésére szolgál
    System.out.println(sumOfTwoEqualsK(a, b, target));
    System.out.println(better_sumOfTwoEqualsK(a, b, target));
    }

    /**
     * A feladat megoldására szolgáló függvény egszerű változata
     * O (N*M) komplexitású, ahol N és M a tömbök mérete
     *
     * @param a Az első tömb, amely egész számokat tartalmaz
     * @param b A második tömb, amely egész számokat tartalmaz
     * @param K Egy választott egész szám amely alapján az összehasonlítást végezzük
     * @return Igaz, ha létezik két olyan szám, (egy az egyik, egy a másik tömbből),
     *          amiknek az összege megegyezik a K paraméterként kapott számmal
     */
    public static boolean sumOfTwoEqualsK (int[] a, int[] b, int K){

        int count = 0;
        for(int i = 0 ; i < a.length ; i++)
            for (int j = 0 ; j < b.length ; j++){
                count++;
                if(a[i]+b[j] == K)
                {
                    //A kiírás a könyebb ellenőrizhatőséget szolgálja csak
                    System.out.println(a[i] + " + " + b[j] + " = " + K + "   count: " + count);
                    return true;
                }
            }


        return false;
    }

    /**
     * A feladat megoldására szolgáló függvény hatékonyabb változata változata
     * Az Arrays.sort() metódus komplexitása O(n log(N)), ahol N a tömb mérete
     * Az összehasonlító algoritmus N+M-1 összehasonítást végez legrosszabb esetben, ahol N és M a tömbök mérete
     *
     * @param a Az első tömb, amely egész számokat tartalmaz
     * @param b A második tömb, amely egész számokat tartalmaz
     * @param K Egy választott egész szám amely alapján az összehasonlítást végezzük
     * @return Igaz, ha létezik két olyan szám, (egy az egyik, egy a másik tömbből),
     *          amiknek az összege megegyezik a K paraméterként kapott számmal
     */
    public static boolean better_sumOfTwoEqualsK (int[] a, int[] b, int K){
        int count = 0;
        int sum;
        //Tömbök rendezése
        Arrays.sort(a);
        Arrays.sort(b);
        //Az egyik tömbön előről a másikon hátulról kezdjük a végig iterálást
        int i = 0;
        int j = b.length-1;

        while(i <= a.length-1 && j >= 0){
            count++;
            sum = a[i] + b[j];
            if (sum == K){
                //A kiírás a könyebb ellenőrizhatőséget szolgálja csak
                System.out.println(a[i] + " + " + b[j] + " = " + K + "   count: " + count);
                return true;
            }
            //Ha az összeg nagyobb mint a keresett, csökkentjük a visszafelé bejárt tömb indexét
            if (sum > K)
                j--;
            //Ha az összeg kisebb mint a keresett, növeljük az előrefelé bejárt tömb indexét
            else
                i++;
        }
        return false;
    }

    /**
     * Kiirja a kimenetre a tömb elemek minden kombinációjának összegét
     */
    public static void sums(int[] a, int[] b){
        for(int i = 0 ; i < a.length ; i++)
            for (int j = 0 ; j < b.length ; j++)
                System.out.println(a[i] + b[j]);
    }
}
