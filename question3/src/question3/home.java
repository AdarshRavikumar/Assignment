package question3;

import java.util.ArrayList;

public class home {

	public static void main(String[] args) {
		
		int noOfNodes=5;
		
		dependencyGraph graph = new dependencyGraph(noOfNodes);
		
		
		/**
		 * Following Methods can be used based on defination to perform the operations
		 * public void addNode(int id, Node n);
	
				public ArrayList<Integer> getParents(int id);
				
				public ArrayList<Integer> getChildren(int id);
			
				public ArrayList<Integer> getAncestors(int id);
				
				public ArrayList<Integer> getDescendents(int id);
				
				public void addDependency(int id1, int id2);
				
				public void deleteDependency(int id);
				
				public void deleteDependency(int parentId, int childId);
		 */
		
		
		
		// Following is an example to use the methods, Here user input isn't taken
		
		/**
		 * 
		 * Node n1 = new Node(0,"A");
		Node n2 = new Node(1,"B");
		Node n3 = new Node(2,"C");
		Node n4 = new Node(3,"D");
		Node n5 = new Node(4,"E");
		
		graph.addNode(0, n1);
		graph.addNode(1, n2);
		graph.addNode(2, n3);
		graph.addNode(3, n4);
		graph.addNode(4, n5);
		
		graph.addDependency(0,2);
		graph.addDependency(1,3);
		graph.addDependency(3,2);
		graph.addDependency(1,4);
		
		
		ArrayList<Integer> parents = graph.getParents(3);
		
		System.out.println("Parents of Node ");
		for(int x : parents)
		{
			System.out.print(x+ " ");
		}
		
		System.out.println("Ancestors of Node ");
		ArrayList<Integer> Ancestors = graph.getAncestors(3);
		for(int x : Ancestors)
		{
			System.out.print(x+ " ");
		}
		
		System.out.println();
		
		graph.addDependency(1,2);
		
		System.out.println("Immediate Children");
		ArrayList<Integer> children = graph.getChildren(1);
		for(int x : children)
		{
			System.out.print(x+ " ");
		}
		
		
		System.out.println("Descendants");
		ArrayList<Integer> descendants = graph.getDescendents(1);
		for(int x : descendants)
		{
			System.out.print(x+ " ");
		}
		
		System.out.println();
		
		
		// Before Deleting
		for(int i=0;i<graph.depGraph.length;i++)
		{
			for(int j=0;j<graph.depGraph[i].size();j++)
			{
				System.out.print(graph.depGraph[i].get(j));
				
			}
			System.out.println();
		}
		
		//After deleting node 3
		
		graph.deleteDependency(4);
		System.out.println("After deleting");
		
		for(int i=0;i<graph.depGraph.length;i++)
		{
			for(int j=0;j<graph.depGraph[i].size();j++)
			{
				System.out.print(graph.depGraph[i].get(j));
				
			}
			System.out.println();
		}
		
	
		// Delete dependency given parent and Child Node
		
		//System.out.println("Deleting child and parent dependency");
		//graph.deleteDependency(1,2);
		
		for(int i=0;i<graph.depGraph.length;i++)
		{
			for(int j=0;j<graph.depGraph[i].size();j++)
			{
				System.out.print(graph.depGraph[i].get(j));
				
			}
			System.out.println();
		}
		
	
		 */
		
		
	}

}
