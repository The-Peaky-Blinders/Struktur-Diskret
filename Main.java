
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  The Graph data stored in a txt file and the example of the input shows like:
 
 *  13 vertices, 16 edges
0: 1 4 5
1: 0 5 2
2: 1 5 3
3: 4 5 2
4: 0 3
5: 0 1 2 3 
6: 2 7
7: 2 6
8: 9 10
9: 8 10
10: 8 9
11: 12
12: 11

*/
public class Main {

	private List<Vertex> Point;
	
	public Main(String _path){
		Point = new ArrayList<Vertex>();
		ArrayList<String> lines = (ArrayList<String>) readData(_path);
		
		
		if (lines != null){
			for (int i = 1; i < lines.size(); i++){				
				String node = lines.get(i).split(":")[0];
				String[] tmp = lines.get(i).split(":")[1].split(" ");				
				List<String> neighbors = new ArrayList<String>();
				for (int j = 1; j < tmp.length; j++){
					neighbors.add(tmp[j]);
				}
				Point.add(new Vertex(node, new ArrayList<String>(neighbors)));
			}	
			
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		for (Vertex v: Point){
			result += v.node + ":" + v.neighbors.toString() + "\n";
		}
		return result;
	}
	
	
	/*
	 * Implement the Welsh-Powell Algorithm 
	 */
	public void colour(){
		Collections.sort(Point, new Vertexcompare());// sort the points according to their degree				
		Map<String, String> vertex_color_index = new HashMap<String, String>(); //create Map<Vertex, Color>
		
		for (int i = 0; i < Point.size(); i++){
			if ((vertex_color_index.containsKey(Point.get(i).node))){					
				continue;				
			}
			else{
				vertex_color_index.put(Point.get(i).node, "Colour " + i);
				for (int j = i + 1; j < Point.size(); j++){
					if(vertex_color_index.containsKey(Point.get(j).node)){						
						continue;
					}
					else{
						if (!(Point.get(i).neighbors.contains(Point.get(j).node))){							
							boolean b = true;
							List n = new ArrayList();
							for(int k = 0; k < Point.get(j).neighbors.size(); k++){
								if(vertex_color_index.containsKey(Point.get(j).neighbors.get(k))){// exited point in the map					
									n.add(Point.get(j).neighbors.get(k));
									for(int t = 0; t < n.size(); t++){										
										if(vertex_color_index.get(n.get(t)).equals("Colour " + i)){
											b = false;
										}
									}																	
								}
								else{
									continue;
								}
							}
							if(b){
								vertex_color_index.put(Point.get(j).node, "Colour " + i);	
								//System.out.println(vertex_color_index);
							}
						}
						else{
							continue;
						}
					}
				}
			}	
		}	
		System.out.println(vertex_color_index);
	}
	
	private List<String> readData(String _path){
		Path path = FileSystems.getDefault().getPath(_path, "");
		try {
			return Files.readAllLines(path, Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("I/O Error");
			return null;
		}
	}	
	
	private static class Vertex{
		private String node;
		private List<String> neighbors;
		
		public Vertex(String node, ArrayList<String> neighbors){
			this.node = node;
			this.neighbors = neighbors;
		}
		
	}
	
	class Vertexcompare implements Comparator<Vertex>{

		@Override
		public int compare(Vertex x, Vertex y) {
			return x.neighbors.size() < y.neighbors.size() ? 1 : x.neighbors.size() == y.neighbors.size() ? 0 : -1;
		}
		
	}
	
	public static void main(String[] args){
		Main graph = new Main("src/txt/data2.txt");
		graph.colour();
	}
}