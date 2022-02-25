package graphtheory;
/*
* IMLEMENTACION DEL ALGORITMO BELLMAN-FORD
*
* 1) This step initializes distances from the source to all vertices as infinite and
* distance to the source itself as 0. Create an array dist[] of size |V| with all values
* as infinite except dist[src] where src is source vertex.
2) This step calculates shortest distances. Do following |V|-1 times where |V| is
*  the number of vertices in given graph.
…..a) Do following for each edge u-v
………………If dist[v] > dist[u] + weight of edge uv, then update dist[v]
………………….dist[v] = dist[u] + weight of edge uv
3) This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
……If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”
The idea of step 3 is, step 2 guarantees the shortest distances if the graph doesn’t
* contain a negative weight cycle.
* If we iterate through all edges one more time and get
* a shorter path for any vertex, then there is a negative weight cycle
*
OUTPUT:
Vertex   Distance from Source
0                0
1                -1
2                2
3                -2
4                1
* */
public class GraphBF {
    int V;
    int E;
    Edge edge[];

    public static void main(String... main) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        GraphBF graphBF = new GraphBF(V, E);

        // add edge 0-1 (or A-B in above figure)
        graphBF.edge[0].src = 0;
        graphBF.edge[0].dest = 1;
        graphBF.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graphBF.edge[1].src = 0;
        graphBF.edge[1].dest = 2;
        graphBF.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graphBF.edge[2].src = 1;
        graphBF.edge[2].dest = 2;
        graphBF.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graphBF.edge[3].src = 1;
        graphBF.edge[3].dest = 3;
        graphBF.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graphBF.edge[4].src = 1;
        graphBF.edge[4].dest = 4;
        graphBF.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graphBF.edge[5].src = 3;
        graphBF.edge[5].dest = 2;
        graphBF.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graphBF.edge[6].src = 3;
        graphBF.edge[6].dest = 1;
        graphBF.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graphBF.edge[7].src = 4;
        graphBF.edge[7].dest = 3;
        graphBF.edge[7].weight = -3;

        graphBF.bellmanFord(graphBF, 0);
    }

    //creates a grapth with V vertices and E edges
    public GraphBF(int v, int e) {
        this.V = v;
        this.E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }
    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm. The
    // function also detects negative weight cycle
    void bellmanFord(GraphBF graphBF, int src) {
        int V = graphBF.V;
        int E = graphBF.E;
        int dist[] = new int[V];

        //step1: inicializar las distancias desde el nodo inicial src
        //a infinito
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;                                          //inicializar el nodo inicial con dist 0...
        //step 2: Relajar los nodos |V| - 1 veces,
        //Un camino simple optimo (minimo) entre
        //desde el nodo inical a todos los demas debe de tener
        // |V| - 1 aristas.
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graphBF.edge[j].src;
                int v = graphBF.edge[j].dest;
                int weight = graphBF.edge[j].weight;
                /*
                *la condicional siguiente comienza el proceso de
                * "relajacion - relaxation" - quote:
                * if (dist(u) + C(u, v) < dist(v)) then dist(v) = dist(u) + C(u, v)
                * */
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        //Step 3: Verificar si existen ciclos negativos en el grafo.
        //Si la condicional de mas abajo tiene lugar, entonces hay un
        //ciclo negativo. -- eso es, hace una evaluacion adicional, si algun
        //nodo cambia luego de la |V| - 1 iteracion, entonces hay un ciclo
        //negativo en el grafo y el Algoritmo del Bellman - Ford no puede utilizarse
        //en el grafo.
        for (int j = 0; j < E; j++) {
            int u = graphBF.edge[j].src;
            int v = graphBF.edge[j].dest;
            int weight = graphBF.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("The graph contains nevative cycle");
                return;
            }
        }
        printArr(dist, V);
    }

    private void printArr(int[] dist, int v) {
        System.out.println("Vertex distance from the source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

}

/*This is a class that encapsulates
 a weighted Edge concept - arista
  */
class Edge {
    int src;
    int dest;
    int weight;

    public Edge() {
        src = 0;
        dest = 0;
        weight = 0;
    }
}
