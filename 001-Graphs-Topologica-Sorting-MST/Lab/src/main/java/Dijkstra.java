import java.util.*;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {

        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);

        int[] previous = new int[graph.length];
        Arrays.fill(previous, -1);

        boolean[] visited = new boolean[graph.length];


        distances[sourceNode] = 0;

        // {node, distance} snapshots: ordering by the live distances array would corrupt the heap
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(entry -> entry[1]));

        queue.offer(new int[]{sourceNode, 0});

        while (!queue.isEmpty()) {
            int parent = queue.poll()[0];
            if (visited[parent]) {
                continue;
            }
            visited[parent] = true;
            int[] children = graph[parent];

            for (int childNode = 0; childNode < children.length; childNode++) {
                if (children[childNode] != 0 && !visited[childNode]) {
                    int distance = distances[parent] + graph[parent][childNode];

                    if (distance < distances[childNode]) {
                        distances[childNode] = distance;
                        previous[childNode] = parent;
                        queue.offer(new int[]{childNode, distance});
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        path.add(destinationNode);

        int n = previous[destinationNode];

        while (n != -1) {
            path.add(n);
            n = previous[n];
        }

        Collections.reverse(path);

        return path.size() == 1 ? null : path;
    }
}