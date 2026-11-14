import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class DijkstraTests {

    private static int[][] GRAPH =
    {
        // 0   1   2   3   4   5   6   7   8   9  10  11
        { 0,  0,  0,  0,  0,  0, 10,  0, 12,  0,  0,  0 }, // 0
        { 0,  0,  0,  0, 20,  0,  0, 26,  0,  5,  0,  6 }, // 1
        { 0,  0,  0,  0,  0,  0,  0, 15, 14,  0,  0,  9 }, // 2
        { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  7,  0 }, // 3
        { 0, 20,  0,  0,  0,  5, 17,  0,  0,  0,  0, 11 }, // 4
        { 0,  0,  0,  0,  5,  0,  6,  0,  3,  0,  0, 33 }, // 5
        {10,  0,  0,  0, 17,  6,  0,  0,  0,  0,  0,  0 }, // 6
        { 0, 26, 15,  0,  0,  0,  0,  0,  0,  3,  0, 20 }, // 7
        {12,  0, 14,  0,  0,  3,  0,  0,  0,  0,  0,  0 }, // 8
        { 0,  5,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0 }, // 9
        { 0,  0,  0,  7,  0,  0,  0,  0,  0,  0,  0,  0 }, // 10
        { 0,  6,  9,  0, 11, 33,  0, 20,  0,  0,  0,  0 }, // 11
    };

    @Test
    public void FindPathBetween0And9() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 9);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11, 1, 9 };
        int expectedLength = 42;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assertions.assertEquals(expectedLength, length);
        Assertions.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And2() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 2);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 2 };
        int expectedLength = 26;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assertions.assertEquals(expectedLength, length);
        Assertions.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And10() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 10);

        Assertions.assertNull(path);
    }

    @Test
    public void FindPathBetween0And11()
    {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 11);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11 };
        int expectedLength = 31;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assertions.assertEquals(expectedLength, length);
        Assertions.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And1()
    {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 1);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11, 1 };
        int expectedLength = 37;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assertions.assertEquals(expectedLength, length);
        Assertions.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void matchesFloydWarshallOnRandomGraphs() {
        Random random = new Random(1);
        for (int run = 0; run < 500; run++) {
            int n = 2 + random.nextInt(8);
            int[][] graph = new int[n][n];
            long[][] expected = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (random.nextInt(3) == 0) {
                        graph[i][j] = graph[j][i] = 1 + random.nextInt(20);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    expected[i][j] = i == j ? 0 : graph[i][j] == 0 ? Integer.MAX_VALUE : graph[i][j];
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        expected[i][j] = Math.min(expected[i][j], expected[i][k] + expected[k][j]);
                    }
                }
            }

            for (int destination = 1; destination < n; destination++) {
                List<Integer> path = Dijkstra.dijkstraAlgorithm(graph, 0, destination);
                if (expected[0][destination] == Integer.MAX_VALUE) {
                    Assertions.assertNull(path);
                    continue;
                }
                long length = 0;
                for (int i = 1; i < path.size(); i++) {
                    length += graph[path.get(i - 1)][path.get(i)];
                }
                Assertions.assertEquals(expected[0][destination], length);
            }
        }
    }
}
