import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PewarnaanGraph
{     

    //method memberi pewarnaan
    public String [] pewarnaanGraph(int banyakWarna,int[][] matriks)
    {
        String []solusi = new String[2];
        String hasil;
        //menentukan panjang matriks
        int panjangMatriks = matriks.length;
        
        //inisiasi array index warna
        int[] idxwarna;
        idxwarna = new int[panjangMatriks];

        try
        {
            coloring(0, matriks,idxwarna,banyakWarna);
            solusi[0] ="\nTidak ada Solusi\n";
        }
        catch (Exception e)
        {
            
            solusi[0] =  "Ada Solusi";
            solusi[1] =output(idxwarna);    
        }
        return solusi;
    }

    //method untuk memeriksa apakah valid untuk membagikan warna itu ke simpul
    public boolean possible(int v, int c,int[][] matriks,int[] idxwarna)
    {
        boolean posible = true;
        for (int j = 0; j < idxwarna.length; j++){
            if (c == idxwarna[j]&&matriks[v][j] == 1){
                posible = false;
            }
        }
        return posible;
    }

    //method pewarnaan
    public void coloring(int v, int[][] matriks,int[] idxwarna,int banyakWarna) throws Exception
    {
        
        //Jika panjang matrix sama dengan banyak vertex maka dapat ditemukan solusinya
        if (v == idxwarna.length){
            throw new Exception("\nAda Solusi\n");
        }

        //Proses pewarnaan
        for (int c = 1; c <= banyakWarna; c++)
        {
            while(possible(v,c,matriks,idxwarna)==true)
            {
                //pewarnaan vertex berikutnya
                idxwarna[v] = c;
                coloring(v+1,matriks,idxwarna,banyakWarna);
                //reset
                idxwarna[v] = 0;
            }
        }    
    }


    //method output
    public String output(int[] idxwarna)
    {   
        String hasiloutput = "";
       // String bilangan_kromatik;
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
        for (int i = 0; i < idxwarna.length; i++){
            

            hasiloutput += "Vertex "+ (i+1) + ": "+ warna[idxwarna[i]] +"\n";
        }
        
        hasiloutput += "\n";
        hasiloutput += "Bilangan Kromatik: "+ kromatik;
        return hasiloutput;
    }    

    //method main
    public static void main (String[] args) 
    {
        //inisiasi Scanner
        Scanner sc = new Scanner(System.in);
        
        //mebuat object pewarnaan graph
        PewarnaanGraph pg = new PewarnaanGraph();

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
        System.out.println("\nBanyaknya Warna:");
        int banyakWarna = sc.nextInt();

        //memanggil method pewarnaan
        pg.pewarnaanGraph(banyakWarna,matriks);

    }
}
