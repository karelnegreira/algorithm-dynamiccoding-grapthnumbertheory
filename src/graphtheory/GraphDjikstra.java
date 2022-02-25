package graphtheory;
/*
* Here is an implementation of the Djikstra algorithm
* by a classical greedy approach
*
* Output:

Vertex   Distance from Source
0                0
1                4
2                12
3                19
4                21
5                11
6                9
7                8
8                14
*
* COMPLEXITY = O(V^2)
* */
public class GraphDjikstra {

    static final int V = 9;
    //the following function is an utility that gets the vertex
    //with the minimum distance between from the set of vertex
    //(conjunto de nodos o vertices) not yet included in the
    //shortest path.
    int minDistance(int dist[], Boolean stpSet[]) {
        //initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++) {
            if (stpSet[v] == false && dist[v] <= min) { // si no esta incluido en el conj de nodos visitados... y tiene una distancia minima
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    //This utility method prints the constructed distance
    public void printArr(int[] dist) {
        System.out.println("Vertex \t\t Distance from the source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
    //The following method implements the Djikstra's shortest path
    //algorithm by using an adjacency matrix representation - graph[][]
    public void djikstra(int graph[][], int src) {
        //el conjunto de todas las distancias desde el vertice inicial hasta el vertice
        //en cuestion.
        int dist[] = new int[V];
        //sptSet es el conjunto de los vertices incluidos en la ruta mas corta.
        //sptSet es false si el vertice no esta incluido y true si esta.
        Boolean sptSet[] = new Boolean[V];
        //se inicializan todas las distancias a INF...
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        //La distancia del nodo inicial a el mismo es siempre 0...
        dist[src] = 0;
        //Busca el camino mas corto desde src a todos los demas.
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
            //marks the picked vertex as processed
            sptSet[u] =  true;
            //actualiza el valor de los vertices adyacentes
            //al vertice o nodo seleccionado
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
            }
        printArr(dist);
        }

        public static void main(String... args) {
            /* Let us create the example graph discussed above */
            int graph[][] = new int[][] {
                    { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            GraphDjikstra t = new GraphDjikstra();

            t.djikstra(graph, 0);
        }

    }


