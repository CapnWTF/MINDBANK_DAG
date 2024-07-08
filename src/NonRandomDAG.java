/*
 * Generates a graph as an adjacency list of nodes of type AdjListNode
 * This Utility uses a Bellman-Ford algo to path, as opposed to a Djikstra's or a Floyd Washington Algorithm
 */
import java.io.*;
import java.util.*;

public class NonRandomDAG {

    static final int INF=Integer.MAX_VALUE;
    class AdjListNode
    {
        private int v;
        private int weight = 1;
            AdjListNode(int _v, int _w)
            {
                v = _v;
                weight = _w;
            }
            int getV(){
                return v;
            }
            int getWeight(){
                return weight;
            }
    }
    
    class Graph
    {
        private int V;
        private LinkedList<AdjListNode>adj[];
    
            Graph(int v)
            {
                V=v;
                adj = new LinkedList[V];
                for(int i=0; i<v; ++i)
                adj[i] = new LinkedList <AdjListNode>();


            }

            void addEdge(int u, int v, int weight)
            {
                AdjListNode node = new AdjListNode(v, weight);
                adj[u].add(node); //Add V to the list for U
            }
            // void negateEdge(int u, int v){
            //     //AdjListNode node = new AdjListNode(v, adj[u].element.getWeight() * - 1)
            //     adj[u].element().getWeight();
            // }
            AdjListNode negateNode(AdjListNode node){
                node.weight = node.getWeight() * -1;
                return new AdjListNode( node.v, node.getWeight()* - 1);

            }
            void topologicalSortUtil(int v, Boolean visited[], Stack<Integer> stack)
            {
                
                //Mark the current node as visited.
                visited[v] = true;
                //Integer i;

                // Recur for all the vertices adjacent to this vertex
                Iterator<AdjListNode> it = adj[v].iterator();
                while(it.hasNext())
                {
                    AdjListNode node = it.next();
                    if(!visited[node.getV()])
                    {
                        topologicalSortUtil(node.getV(), visited, stack);
                    }
                }
                // Push current vertex to stack to store the result
                stack.push( Integer.valueOf(v));
            }
            
            void shortestPath(int s)
            {
                Stack<Integer> stack = new Stack<Integer>();
                int dist[] = new int[V];

                //Mark all the vertices as not visited
                Boolean visited[] = new Boolean[V];
                for (int i =0;i<V; i++)
                {
                    visited[i] = false;
                }

                //Call recursive function to store Topological sort starting from all vertices one by one
                for (int i = 0; i<V; i++){
                    if(visited[i] == false)
                    {
                        topologicalSortUtil(i, visited, stack);
                    }
                }

                //Initialize Distances to all vertices as infinite and distance to source as 0
                for(int i = 0; i< V; i++){
                    dist[i] = INF;
                    dist[s] = 0;
                }

                //Process vertices in topological order
                while (stack.empty() == false){
                    int u = (int)stack.pop();
                    //Update distances of all adjacent vertices
                    Iterator<AdjListNode> it;
                    if(dist[u] != INF)
                    {
                        it = adj[u].iterator();
                        while (it.hasNext())
                        {
                            AdjListNode i = it.next();
                            if(dist[i.getV()] > dist[u] + i.getWeight())
                            {
                                dist[i.getV()] = dist[u + i.getWeight()];
                            }
                        }
                    }

                }
                //Print the calculated shortest distances
                for (int i = 0; i < V; i++)
                {
                    if(dist[i] == INF){
                        System.out.print("CANNOT BE REACHED");
                    }
                    else {
                        System.out.print( dist[i] + " ");
                    }
                }
            }

            void negateEdges(Graph g){
                // foreach edge e in g.adj[i]{
                    
                // }
            }
            //longest Path uses the shortest path algorithm after negating the edge weights. this should work regardless of the presence of negative weights.
            void longestPath(int s)
            {
                //TODO
            }

            
            
            //TODO: Optional Dijkstra's algorithm utility for non-negative graphs.

    }

    Graph newGraph(int number){
        return new Graph(number);
    }

}
