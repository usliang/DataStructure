// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int totalNode; // No. of vertices
    private LinkedList<Integer> adjListArray[]; //Adjacency Lists

    // Constructor
    Graph(int totalNode)
    {
        this.totalNode = totalNode;
        adjListArray = new LinkedList[totalNode];
        for (int i=0; i<totalNode; ++i)
            adjListArray[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adjListArray[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[totalNode];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjListArray[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjListArray[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[totalNode];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[totalNode];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i=0; i< totalNode; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }

    public static int getNextMinSpanNode(boolean[] isNodeInMSTs, int[] minSpans){
        int ret = -1;
        int minSpan = Integer.MAX_VALUE;

        for (int i = 0; i < isNodeInMSTs.length; i++ ){
            if (!isNodeInMSTs[i]){
                if (minSpans[i] < minSpan ){
                    ret = i;
                }
            }
        }

        return ret;
    }

    public void updateMinSpans(int index){

        Iterator<Integer> iterator = adjListArray[index].iterator();

        while (iterator.hasNext()){
            int adjNode = iterator.next();

        }
    }

    public void printMST(){
        boolean[] isNodeInMSTs = new boolean[totalNode];
        int[] maxSpans = new int[totalNode];

        for (int i = 0; i<totalNode; i++ ){
            maxSpans[i] = Integer.MAX_VALUE;
            isNodeInMSTs[i] = false;
        }

        int[] mstPath = new int[totalNode];

        mstPath[0] = 0;
        isNodeInMSTs[0] = true;
        maxSpans[0] = 0;






    }

    // Driver method to
    public static void main(String args[])
    {
        testDFS();
    }

    public static void testBFS(){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

    public static void testDFS(){

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS();

    }
}

