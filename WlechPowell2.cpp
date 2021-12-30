
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class peakyBlinders
{
    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);
        int ukuranM = sc.nextInt();//ukuran matrix
        int matrixGraf[][] = new int[ukuranM][ukuranM];//arr 2D utk menyimpan matrix graf
        int arrayEdge[] = new int[ukuranM];
        for(int i=0; i<ukuranM; i++){
            for(int j=0; j<ukuranM; j++){
                matrixGraf[i][j] = sc.nextInt();
            }
        }
        String namaVertex [] = new String[ukuranM];//array untuk menyimpan nama vertex
        for(int i=0; i<ukuranM; i++){
            namaVertex [i] = sc.next();
        }
        int drjt_Tertinggi[] = new int[ukuranM]; //untuk menyimpan derajat tertinggi;
        
        for(int i=0; i<ukuranM; i++){
            arrayEdge[i] = 0;
        }
    }

    public static void coloring(int[][]matrixGraf,int ukuranM, int drjt_Tertinggi,int[]arrayEdge){
        int counter = 0;
        counter++;
        drjt_Tertinggi=0;
        int temp_rate = 0;

        //menghitung edge

        if (counter == 1){
            for (int i = 0; i < ukuranM; i++){
                for (int j = 0; j < ukuranM; j++){
                    if (matrixGraf[i][j]==1){
                    arrayEdge[i]++;
                    } 
                }

            }

        }

        for (int k = 0; k < ukuranM; k++){
            if (!matrixGraf.colored[k]) {
                matrixGraf.vertex_rates[w] = arrayEdge[k];
                if (temp_rate < matrixGraf.vertex_rates[k]) {
                    temp_rate = matrixGraf.vertex_rates[k];
                    drjt_Tertinggi = k;
                }
            }
        }

        //coloring biggest one first
        matrixGraf.colors[drjt_Tertinggi] = colors[counter];
        System.out.print(g.vertex_id[drjt_Tertinggi]+":color "+g.colors[drjt_Tertinggi]<<std::endl);
    }
}
