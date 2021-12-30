/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/

import java.util.Scanner;

/** Class GraphColoring **/
public class GraphColoring
{    
    int V, jumlahwarna;
    int[] idxwarna; 
    int[][] matriks;

    /** Function to assign color **/
    public void graphColor(int[][] g, int n)
    {
        V = g.length;//panjang matrix
        jumlahwarna = n;//banyaknya warna
        idxwarna = new int[V];
        matriks = g;

        try
        {
            solve(0);
            System.out.println("Tidak ada Solusi");
        }
        catch (Exception e)
        {
            System.out.println("\nSolution exists ");
            display();
        }
    }

    /** method untuk pewarnaan secara rekursive **/
    public void solve(int v) throws Exception
    {
        /** base case - solution found **/
        if (v == idxwarna.length){
            throw new Exception("Solution found");
        }//jika panjang matrix sama dengan banyak vertex

        /** try all colours **/
        for (int c = 1; c <= jumlahwarna; c++)
        {
            while(isPossible(v,c)==true)
            {
                /** assign and proceed with next vertex **/
                idxwarna[v] = c;
                solve(v+1);
                /** wrong assignement **/
                idxwarna[v] = 0;
            }
        }    
    }

    /** berfungsi untuk memeriksa apakah valid untuk membagikan warna itu ke simpul **/
    public boolean isPossible(int v, int c)
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
    public void display()
    {   

        String [] warna = {"merah","biru","kuning","hitam","putih"};
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
        int[][] matriks = new int[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                matriks[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter number of colors");
        int c = sc.nextInt();

        gc.graphColor(matriks, c);

    }
}
