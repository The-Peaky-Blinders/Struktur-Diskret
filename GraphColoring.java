/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/

import java.util.Scanner;

/** Class GraphColoring **/
public class GraphColoring
{     

    
    /** Function to assign color **/
    public void graphColor(int jmlWarna,int[][] matriks)
    {
        int panjangMatriks = matriks.length;
        int[] idxwarna;
        idxwarna = new int[panjangMatriks];

        try
        {
            coloring(0, matriks,idxwarna,jmlWarna);
            System.out.println("Tidak ada Solusi");
        }
        catch (Exception e)
        {
            System.out.println("Ada Solusi");
            display(idxwarna);
        }
    }

    /** method untuk pewarnaan secara rekursive **/
    public void coloring(int v, int[][] matriks,int[] idxwarna,int jmlWarna) throws Exception
    {
        /** base case - solution found **/
        if (v == idxwarna.length){
            throw new Exception("Ada Solusi");
        }//jika panjang matrix sama dengan banyak vertex maka dapat ditemukan solusinya

        /** try all colours **/
        for (int c = 1; c <= jmlWarna; c++)
        {
            while(isPossible(v,c,matriks,idxwarna)==true)
            {
                /** assign and proceed with next vertex **/
                idxwarna[v] = c;
                coloring(v+1,matriks,idxwarna,jmlWarna);
                /** wrong assignement **/
                idxwarna[v] = 0;
            }
        }    
    }

    /** berfungsi untuk memeriksa apakah valid untuk membagikan warna itu ke simpul **/
    public boolean isPossible(int v, int c,int[][] matriks,int[] idxwarna)
    {
        boolean posible = true;
        for (int j = 0; j < idxwarna.length; j++){
            if (c == idxwarna[j]&&matriks[v][j] == 1){
                posible = false;
            }
        }
        return posible;
    }

    /** display solution **/
    public void display(int[] idxwarna)
    {   

        String [] warna = {"hitam","merah","biru","kuning","putih"};
        // System.out.print("\nColors : ");
        for (int i = 0; i < idxwarna.length; i++){
            System.out.println("vertex "+ (i+1) + " warna :"+ warna[idxwarna[i]] +" ");
        }
        System.out.println();
        // System.out.print("\nvertex " + i);

    }    

    //method main
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        /** Make an object of GraphColoring class **/
        GraphColoring wm = new GraphColoring();

        //input banyaknya vertex
        System.out.println("Enter number of vertices\n");
        int vertex = sc.nextInt();

        //input matriks
        System.out.println("\nEnter matrix\n");
        int[][] matriks;
        matriks = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++){
            for (int j = 0; j < vertex; j++){
                matriks[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter number of colors");
        int jmlWarna = sc.nextInt();

        wm.graphColor(jmlWarna,matriks);

    }
}
