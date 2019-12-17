package question3;

import java.util.ArrayList;
import java.util.Iterator;

public class dfs {


	public void DFSUtil(int v,boolean visited[],ArrayList<Integer>[] depGraph,ArrayList<Integer> resultofDFS,int level) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        resultofDFS.add(v);
  

		// Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = depGraph[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if(level==1)
            	return;
            if (!visited[n]) 
                DFSUtil(n, visited,depGraph,resultofDFS,level+1); 
        } 
        
        return ;
    } 
 
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    public ArrayList<Integer> DFS(int v, int startingNode, ArrayList<Integer> depGraph[],int level) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[v]; 
        
        ArrayList<Integer> resultofDFS= new ArrayList<Integer>();
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(startingNode, visited,depGraph,resultofDFS,level); 
        resultofDFS.remove(0);
        
        return resultofDFS;
    } 
}
