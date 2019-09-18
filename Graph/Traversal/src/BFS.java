import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private int v;
	private LinkedList<Integer> adj[];
	
	public BFS(Graph g) {
		this.v = g.v;
		this.adj = g.adj;
	}
	
	public void bfs(int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[v];
		queue.add(s);
		visited[s] = true;
		
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			System.out.println(u);
			
			Iterator<Integer> it = adj[u].listIterator();
			while(it.hasNext()) {
				Integer v = it.next();
				if(visited[v] == false) {
					visited[v] = true;
					queue.add(v);
				}		
			}
		}
	}
}
