/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/

import java.util.Scanner;

/** Class GraphColoring **/
public class GraphColoring
{     
    
     
    

    /** Function to assign color **/
    public void graphColor(int c,int[][] matriks)
    {
        int n = c;
        int jumlahwarna;
        int V;
        V = matriks.length;//panjang matrix
        jumlahwarna = n;//banyaknya warna
        int[] idxwarna;
        idxwarna = new int[V];
        
        try
        {
            solve(0, matriks,idxwarna,jumlahwarna);
            System.out.println("Tidak ada Solusi");
        }
        catch (Exception e)
        {
            System.out.println("\nSolution exists ");
            display(idxwarna);
        }
    }

    /** method untuk pewarnaan secara rekursive **/
    public void solve(int v, int[][] matriks,int[] idxwarna,int jumlahwarna) throws Exception
    {
        /** base case - solution found **/
        if (v == idxwarna.length){
            throw new Exception("Solution found");
        }//jika panjang matrix sama dengan banyak vertex

        /** try all colours **/
        for (int c = 1; c <= jumlahwarna; c++)
        {
            while(isPossible(v,c,matriks,idxwarna)==true)
            {
                /** assign and proceed with next vertex **/
                idxwarna[v] = c;
                solve(v+1,matriks,idxwarna,jumlahwarna);
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
            if (matriks[v][j] == 1 && c == idxwarna[j]){
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

    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Graph Coloring Algorithm Test\n");
        /** Make an object of GraphColoring class **/
        GraphColoring gc = new GraphColoring();

        /** input banyak vertices **/
        System.out.println("Enter number of verticesz\n");
        int len = sc.nextInt();
        
        /** get graph **/
        System.out.println("\nEnter matrix\n");
        int[][] matriks;
        matriks = new int[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                matriks[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter number of colors");
        int c = sc.nextInt();

        gc.graphColor(c,matriks);

    }
}
