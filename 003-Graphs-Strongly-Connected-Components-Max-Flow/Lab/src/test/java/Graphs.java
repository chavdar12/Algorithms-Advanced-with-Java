import java.util.ArrayList;
import java.util.List;

final class Graphs {

    /** Builds an adjacency list from {from, to} pairs; undirected adds both directions. */
    @SuppressWarnings("unchecked")
    static List<Integer>[] adjacency(int nodes, boolean undirected, int[]... edges) {
        List<Integer>[] graph = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            if (undirected) {
                graph[edge[1]].add(edge[0]);
            }
        }
        return graph;
    }

    private Graphs() {
    }
}
