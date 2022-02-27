package graphtheory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class DepthFistStack {

    public static void main(String... args) {
        // Total 5 vertices in graph
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }
    /*
    * This class represents the node and its adjacency
    * */
    static class Graph {
        int V;
        LinkedList<Integer> adj[];

        //constructor initializes node's value and adjacency list of nodes
        //of it...
        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        /*This one adds weights on the
        *edges - en espanol, arista -
        * */
        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        private void DFS(int s) {
            //se marcan todos los nodos como no visitados
            Vector<Boolean> visited = new Vector<Boolean>(V);
            for (int i = 0; i < V; i++) {
                visited.add(false);
            }
            //se crea una pila (Stack) para el algoritmo
            Stack<Integer> stack = new Stack<>();
            //se coloca en la pila el nodo inicial
            stack.push(s);

            while (stack.isEmpty() == false) {
                //saca al nodo de la pila y lo imprime
                s = stack.peek();
                stack.pop();
                // Stack may contain same vertex twice. So
                // we need to print the popped item only
                // if it is not visited.
                if (visited.get(s) == false) {
                    System.out.print(s + " ");
                    visited.set(s, true);
                }
                // Get all adjacent vertices of the popped vertex s
                // If a adjacent has not been visited, then push it
                // to the stack.
                Iterator<Integer> itr = adj[s].iterator();
                while (itr.hasNext()) {
                    int v = itr.next();
                    if (!visited.get(v)) {
                        stack.push(v);
                    }
                }
            }
        }
    }
}
