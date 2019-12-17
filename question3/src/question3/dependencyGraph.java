package question3;


import java.util.*;

public class dependencyGraph implements operations{

	public ArrayList<Integer> depGraph[];
	public int vertices; 
	public Map<Integer,Node> nodesOfGraph = new HashMap<Integer,Node>() ;
	
	public dependencyGraph()
	{
		
	}
	
	public dependencyGraph(int v)
	{
		this.vertices=v;
		depGraph = new ArrayList[v];
		
		for(int i=0;i<v;i++)
		{
			depGraph[i]= new ArrayList<>();
		}
		
		
	}
	
	
	public ArrayList<Integer>[] reverseDependency(ArrayList<Integer> depgraph[],int vertices)
	{
		ArrayList<Integer> revDependency[]= new ArrayList[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			revDependency[i]= new ArrayList<>();
		}
		//System.out.println(vertices);
	
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<depgraph[i].size();j++)
			{
				
				if(depgraph[i].get(j)!=null)
				{
					revDependency[depgraph[i].get(j)].add(i);
				}
			}
		}
		
		return revDependency;
		
	}
	
	@Override
	public void addNode(int id, Node n) {
		// TODO Auto-generated method stub
		
		nodesOfGraph.put(id, n);		

	}

	@Override
	public ArrayList<Integer> getParents(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> revDependency[];
		dependencyGraph dg = new dependencyGraph();
		

		revDependency=dg.reverseDependency(depGraph,vertices);
		
		/**
		for(int i=0;i<revDependency.length;i++)
		{
			for(int j=0;j<revDependency[i].size();j++)
			{
				System.out.print(revDependency[i].get(j));
			}
			System.out.println();
		}
		
		**/
		
		dfs dfsObj = new dfs();
		int level=0 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.DFS(vertices,id, revDependency,level);
		
		
	}

	@Override
	public ArrayList<Integer> getChildren(int id) {
		// TODO Auto-generated method stub
		
		
		dfs dfsObj = new dfs();
		int level=0 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.DFS(vertices,id,depGraph,level);
		
	}

	@Override
	public ArrayList<Integer> getAncestors(int id) {
		// TODO Auto-generated method stub

		ArrayList<Integer> revDependency[];
		dependencyGraph dg = new dependencyGraph();
		

		revDependency=dg.reverseDependency(depGraph,vertices);
		
		/**
		for(int i=0;i<revDependency.length;i++)
		{
			for(int j=0;j<revDependency[i].size();j++)
			{
				System.out.print(revDependency[i].get(j));
			}
			System.out.println();
		}
		
		**/
		
		dfs dfsObj = new dfs();
		int level=2 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.DFS(vertices,id, revDependency,level);
		
	}

	@Override
	public ArrayList<Integer> getDescendents(int id) {
		// TODO Auto-generated method stub
		
		
		/**
		for(int i=0;i<revDependency.length;i++)
		{
			for(int j=0;j<revDependency[i].size();j++)
			{
				System.out.print(revDependency[i].get(j));
			}
			System.out.println();
		}
		
		**/
		
		dfs dfsObj = new dfs();
		int level=2 ;   // To find parent pass level as 0, if ancestor pass level any value greater than 1
		return dfsObj.DFS(vertices,id,depGraph,level);
		
	}

	@Override
	public void addDependency(int id1, int id2) {
		// TODO Auto-generated method stub
		
		depGraph[id1].add(id2);
		
		checkCycle cycle = new checkCycle();
		if(cycle.checkCycle(depGraph, id1, id2, vertices))
		{
			System.out.println("This edge Can't be added . It Would Cause a cycle");
		
		
			for(int j=0;j<depGraph[id1].size();j++)
			{
				if(depGraph[id1].get(j)==id2)
					depGraph[id1].remove(j);
			}
		}
		
		/**
		 * Should Check Cyclic Dependencies
		 */
		
	}

	@Override
	public void deleteDependency(int id) {
		// TODO Auto-generated method stub
		
		depGraph[id].clear();
		
		for(int i=0;i<depGraph.length;i++)
		{
			for(int j=0;j<depGraph[i].size();j++)
			{
				if(depGraph[i].get(j)==id)
				{
					depGraph[i].remove(j);
				}
			}
		}
		
		
	}

	@Override
	public void deleteDependency(int parentId, int childId) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<depGraph[parentId].size();i++)
		{
			if(depGraph[parentId].get(i)==childId)
			{
				depGraph[parentId].remove(i);
			}
		}
		
	}

	
	
	
	
}
