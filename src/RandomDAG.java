import java.util.Random;

public class RandomDAG {

    //Maximum number of vertices for the random graph
    static int maxVertex = 20;

    //Function to check for cycle, upon addition of new edge in the graph
    public static boolean checkAcyclic(int[][] edge, int ed, boolean[] check, int v)
    {
        int i;
        boolean value;

        // If the current vertex is visited already, then the graph contains a cycle

        if(check[v] == true){
            return false;
        }
        else{
            check[v] = true;
            // For each vertex, go for all the vertex connected to it
            for (i=ed;i>=0;i--){
                if(edge[i][0] == v)
                return checkAcyclic(edge, ed, check, edge[i][1]);
            }
        }
        // In case, if the path ends then reassign the vertices visited in that path to false again
        check[v]=false;
        if(i==0)
        {
            return true;
        }
        return true;
    }
    
    //Function to generate random graph
    public static void generateRandomGraphs(int e)
    {
        int i = 0;
        int j = 0;
        int count = 0;
        int[][] edge = new int[e][2];
        boolean[] check = new boolean[21];
        Random rand = new Random();

        //Build a connection between two random vertex
        while (i<e){
            edge[i][0] = rand.nextInt(maxVertex) + 1;
            edge[i][1] = rand.nextInt(maxVertex) + 1;

            for (j=1; j<=20;j++){
                check[j] = false;
            }
            if(checkAcyclic(edge, i, check, edge[i][0]) == true){
                i++;
            }
            //Check for cycle and if found discard this edge and generate random vertex pair again
        }
System.out.println("The Generated Random Graph is :");

    //Print Graph
    for(i=0;i<maxVertex;i++){
        count = 0;

        System.out.print((i+1) + "->{ ");
        for(j=0;j<e;j++){
            if( edge[j][0] == i + 1){
                System.out.print(edge[j][1] + " ");
                count++;
            }
            else if (edge[j][1] == i + 1){
                count++;
            }
            else if(j == e - 1 && count == 0){
                System.out.print("Isolated Vertex!");
            }
        }
        System.out.print("}\n");
    }
    }
}
