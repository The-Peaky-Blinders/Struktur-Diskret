import java.util.Scanner;

public class PewarnaanGraphMain
{     

    //method pewarnaan
    public static void coloring(int v, int[][] matriks,int[] idxwarna,int banyakWarna) throws Exception
    {

        //Jika panjang matrix sama dengan banyak vertex maka dapat ditemukan solusinya
        if (v == idxwarna.length){
            throw new Exception("\nAda Solusi\n");
        }

        //Proses pewarnaan
        for (int c = 1; c <= banyakWarna; c++)
        {

            //mengecek apakah valid untuk membagikan warna tersebut ke vertex
            boolean posible = true;
            for (int j = 0; j < idxwarna.length; j++){
                if (c == idxwarna[j]&&matriks[v][j] == 1){
                    posible = false;
                }
            }

            //proses pewarnaan
            while(posible==true)
            {
                //pewarnaan vertex berikutnya
                idxwarna[v] = c;
                coloring(v+1,matriks,idxwarna,banyakWarna);
                //reset
                idxwarna[v] = 0;
            }

        }
        
    }

    //method main
    public static void main (String[] args) 
    {
        //inisiasi Scanner
        Scanner sc = new Scanner(System.in);
        
        //input banyaknya vertex
        System.out.println("Banyak Vertex:");
        int vertex = sc.nextInt();

        //input matriks
        System.out.println("\nMatriks:\n");
        int[][] matriks;
        matriks = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++){
            for (int j = 0; j < vertex; j++){
                matriks[i][j] = sc.nextInt();
            }
        }

        //input banyaknya warna
        System.out.println("\nBanyak Warna:");
        int banyakWarna = sc.nextInt();

        //menentukan panjang matriks
        int panjangMatriks = matriks.length;

        //inisiasi array index warna
        int[] idxwarna;
        idxwarna = new int[panjangMatriks];

        //mengecek apakah solusi bisa didapatkan menggunakan try and catch(jika error maka solusi tidak dapat ditemukan sedangkan jika tidak error maka solusi dapat ditemukan)
        try
        {
            //memanggil method coloring
            coloring(0, matriks,idxwarna,banyakWarna);
            System.out.println("\nTidak ada Solusi\n");
        }
        catch (Exception e)
        {
            System.out.println("\nAda Solusi\n");

            //output
            String [] temp = new String [idxwarna.length];
            String [] warna = {"hitam","merah","biru","kuning","putih"};
            int kromatik = 1;
            temp[0] = warna[idxwarna[0]];

            //cari bilangan kromatik
            for (int i = 1; i < idxwarna.length; i++){
                // System.out.print("\nvertex " + i);
                //System.out.println(color[i]);
                boolean hasil = false;
                if(i>1){
                    temp[i-1] = warna[idxwarna[i-1]];
                }
                for(int j = 0; j < temp.length; j++){

                    if(temp[j] == warna[idxwarna[i]]){
                        hasil = true;
                    }
                }
                if(hasil==false){
                    kromatik++;
                }
            }

            //menampilkan hasil
            for (int i = 0; i < idxwarna.length; i++){
                System.out.println("Vertex "+ (i+1) + ": "+ warna[idxwarna[i]] +" ");
            }
            System.out.println();
            System.out.println("bilangan kromatik: "+ kromatik);
        }

    }
}
