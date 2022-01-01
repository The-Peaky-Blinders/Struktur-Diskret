
/**
 * Write a description of class pewarnaan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class pewarnaan
{
    public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    //input banyaknya vertex
    int banyakVertex = sc.nextInt();
    //inisiasi matriks
    int[][]matriks = new int[banyakVertex][banyakVertex];
    //input matriks
    for(int i = 0;i<banyakVertex;i++){
    for(int j = 0;j<banyakVertex;j++){
    matriks[i][j] = sc.nextInt();
    }
    }
    //input banyaknya warna
    int banyakWarna = sc.nextInt();
    
    String warna ="";
    for(int i = 0;i<banyakVertex;i++){
    System.out.println("Vertex"+" "+i+1+":"+" "+warna);
    }
    }
    
    public static int derajat(int[][]matriks, int vertex){
    int derajat = 0;
    int maxI = 0;
    int maxDerajat = 0;
    int count = vertex;
    for(int i = 0;i<=vertex-count;i++){
    for(int j = 0;j<vertex;j++){
    if(matriks[i][j] == 1){
    derajat++;
    }
    }
    if(derajat>maxDerajat){
    maxDerajat = derajat;
    maxI = i;
    }
    count--;
    }
    return maxI;
    }
    
    public static void pewarnaan(int v,int[][]matriks,int vertex){
    int indexWarna = derajat(matriks,vertex);
    int[]warna = new int[vertex];
    for(int x = 1; x<=vertex;x++){
    while(possible(x,matriks,vertex) == true){
    warna[v] = x;
    pewarnaan(v+1,matriks,vertex);
    warna[v] = 0;
    }
    }
      
    
    }
    
    public static boolean possible(int x, int[][]matriks,int vertex){
    int indexWarna = derajat(matriks,vertex);
    boolean possible = true;
    for(int i = 0;i<vertex;i++){
    if(x==indexWarna&&matriks[indexWarna][i]==1){
    possible = false;
    }
    
    }
    return possible;
    }
}
