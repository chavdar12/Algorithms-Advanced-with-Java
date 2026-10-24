import java.util.*;

public class MostReliablePath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nodes = Integer.parseInt(sc.nextLine().split("\\s+")[1]);

        String[] path = sc.nextLine().split("\\s+");

        int edges = Integer.parseInt(sc.nextLine().split("\\s+")[1]);

        int source = Integer.parseInt(path[1]);
        int destination = Integer.parseInt(path[3]);


        int[][] graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {

            int[] tokens = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[tokens[0]][tokens[1]] = tokens[2];
            graph[tokens[1]][tokens[0]] = tokens[2];
        }

        sc.close();

        double[] distances = new double[nodes];
        boolean[] visited = new boolean[nodes];

        int[] prev = new int[nodes];

        Arrays.fill(prev, -1);

        distances[source] = 100.00;

        // {node, reliability} snapshots: ordering by the live distances array would corrupt the heap
        PriorityQueue<double[]> queue = new PriorityQueue<>((f, s) -> Double.compare(s[1], f[1]));

        queue.offer(new double[]{source, distances[source]});

        while (!queue.isEmpty()) {

            int minNode = (int) queue.poll()[0];

            if (visited[minNode]) {

                continue;
            }

            visited[minNode] = true;

            for (int i = 0; i < graph[minNode].length; i++) {

                int weight = graph[minNode][i];
                if (weight != 0 && !visited[i]) {

                    double newDistance = distances[minNode] * weight / 100.00;

                    if (newDistance > distances[i]) {

                        distances[i] = newDistance;
                        prev[i] = minNode;
                        queue.offer(new double[]{i, newDistance});
                    }
                }
            }
        }

        System.out.printf("Most reliable path reliability: %.2f%%%n", distances[destination]);

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(destination);

        int node = prev[destination];

        while (node != -1) {

            stack.push(node);
            node = prev[node];
        }

        while (!stack.isEmpty()) {

            System.out.print(stack.pop());

            if (stack.size() > 0) {

                System.out.print(" -> ");
            }
        }

        System.out.println();
    }
}