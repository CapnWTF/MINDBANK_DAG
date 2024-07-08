
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        // int e = 8;
        // System.out.println("Enter the number of edges : " + e);
        // //System.in.read();
        //RandomDAG.generateRandomGraphs(e);
        
        NonRandomDAG nrd = new NonRandomDAG();
        NonRandomDAG.Graph g = nrd.newGraph(6);

        g.addEdge(0,1,5);
        g.addEdge(0,2,3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        // g.addEdge(2, 3, 7);
        // g.addEdge(3, 4, -1);
        // g.addEdge(4, 5, -2);
 
        int s = 1;
        System.out.println("Following are shortest distances "+
                            "from source " + s );
        g.shortestPath(s);
    }

    public static void generateDAG(){

    }

}
