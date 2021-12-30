/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/
 
import java.util.Scanner;
 
/** Class GraphColoring **/
public class GraphColoring
{    
    int len, jumlahwarna;
    int[] idxwarna; 
    int[][] graph;
    
    /** Function to assign color **/
    public void graphColor(int[][] g, int n)
    {
        len = g.length;//panjang matrix
        jumlahwarna = n;//banyaknya warna
        idxwarna = new int[len];
        graph = g;
 
        try
        {
            solve(0);
            System.out.println("No solution");
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
        if (v == len)//jika panjang matrix sama dengan banyak vertex
            throw new Exception("Solution found");
        /** try all colours **/
        for (int c = 1; c <= jumlahwarna; c++)
        {
            while(isPossible(v,c)==true)
            {
                /** assign and proceed with next vertex **/
                idxwarna[v] = c;
                solve(v + 1);
                /** wrong assignement **/
                idxwarna[v] = 0;
            }
        }    
    }
    /** berfungsi untuk memeriksa apakah valid untuk membagikan warna itu ke simpul **/
    public boolean isPossible(int v, int c)
    {
        for (int i = 0; i < len; i++)
            if (graph[v][i] == 1 && c == idxwarna[i])
                return false;
        return true;
    }
    /** display solution **/
    public void display()
    {   

        String [] warna = {"merah","biru","kuning","hitam","putih"};
       // System.out.print("\nColors : ");
        for (int i = 0; i < len; i++)
           // System.out.print("\nvertex " + i);
           
            System.out.println("vertex "+ (i+1) + " warna :"+ warna[idxwarna[i]] +" ");
        System.out.println();
    }    
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Graph Coloring Algorithm Test\n");
        /** Make an object of GraphColoring class **/
        GraphColoring gc = new GraphColoring();
 
        /** input banyak vertices **/
        System.out.println("Enter number of verticesz\n");
        int V = scan.nextInt();
 
        /** get graph **/
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
 
        System.out.println("\nEnter number of colors");
        int c = scan.nextInt();
 
        gc.graphColor(graph, c);
 
    }
}
