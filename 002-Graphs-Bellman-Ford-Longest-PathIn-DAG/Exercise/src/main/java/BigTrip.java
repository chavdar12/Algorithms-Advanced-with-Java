import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BigTrip {

    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(rd.readLine());
        int e = Integer.parseInt(rd.readLine());

        graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < e; i++) {

            int[] nextLine = Arrays.stream(rd.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = nextLine[0];
            int dest = nextLine[1];
            int weight = nextLine[2];

            graph[source][dest] = weight;
        }

        int source = Integer.parseInt(rd.readLine());
        int destination = Integer.parseInt(rd.readLine());

        rd.close();

        visited = new boolean[nodes + 1];
        Deque<Integer> sortedNodes = new ArrayDeque<>();

        for (int i = 1; i < graph.length; i++) {

            topSortDfs(i, sortedNodes);
        }

        int[] distances = new int[nodes + 1];
        Arrays.fill(distances, Integer.MIN_VALUE);
        distances[source] = 0;

        int[] prev = new int[nodes + 1];
        Arrays.fill(prev, -1);

        for (int from : sortedNodes) {

            if (distances[from] == Integer.MIN_VALUE) {

                continue;
            }

            for (int to = 1; to < graph[from].length; to++) {

                int weight = graph[from][to];

                if (weight != 0) {

                    if (distances[from] + weight > distances[to]) {

                        distances[to] = distances[from] + weight;
                        prev[to] = from;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(destination);
        int current = prev[destination];

        while (current != -1) {

            path.add(current);
            current = prev[current];
        }
        Collections.reverse(path);

        System.out.println(distances[destination]);
        System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static void topSortDfs(int node, Deque<Integer> sortedNodes) {

        if (visited[node]) {

            return;
        }

        visited[node] = true;

        for (int i = 1; i < graph[node].length; i++) {

            if (graph[node][i] != 0) {

                topSortDfs(i, sortedNodes);
            }
        }

        sortedNodes.push(node);
    }
}