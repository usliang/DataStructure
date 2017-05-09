// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.lang.*;

class MatrixGraph
{
    // Number of vertices in the graph

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < key.length; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge Weight");
        for (int i = 1; i < n; i++)
            System.out.println(parent[i]+" - "+ i+" "+
                    graph[i][parent[i]]);
    }

    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    void primMST(int graph[][], int nodeCount)
    {
        // Array to store constructed MST
        int parent[] = new int[graph.length];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int [nodeCount];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[nodeCount];

        // Initialize all keys as INFINITE
        for (int i = 0; i < nodeCount; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;	 // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < nodeCount-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < nodeCount; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && mstSet[v] == false &&
                        graph[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, nodeCount, graph);
    }

    static int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    static void printSolution(int src, int dist[], int nodeCount, int[] parents)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < nodeCount; i++) {
           System.out.format("\n%d -> %d \t\t %d\t\t%d ", src, i, dist[i], src);
            printPath(parents, i);
        }
    }

    static void findShortestPath(int graph[][], int src, int nodeCount)
    {
        int dist[] = new int[nodeCount]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[nodeCount];

        //parent

        int[] parents = new int[nodeCount];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < nodeCount; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parents[i] = -1;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < nodeCount-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < nodeCount; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                    parents[v] = u;
                }
        }

        // print the constructed distance array
        printSolution(src, dist, nodeCount, parents);
    }

    static void printPath(int parent[], int j)
    {
        // Base Case : If j is source
        if (parent[j]==-1)
            return;

        printPath(parent, parent[j]);

        System.out.format("%d ", j);
    }

    public static void main (String[] args)
    {

    }
    public static void testMST(){

        	/* Let us create the following graph
		2 3
		(0)--(1)--(2)
		| / \ |
		6| 8/ \5 |7
		| /	 \ |
		(3)-------(4)
			9		 */
        MatrixGraph t = new MatrixGraph();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        t.primMST(graph,graph.length);
    }

    public static void testShortestPath(){

        	/* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        findShortestPath(graph, 0, graph.length);

    }
}
