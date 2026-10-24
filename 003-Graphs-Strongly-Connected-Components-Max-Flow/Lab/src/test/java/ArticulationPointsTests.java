import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticulationPointsTests {

    @Test
    public void findsCutVertices() {
        // triangle 0-1-2, bridge 2-3, triangle 3-4-5
        List<Integer>[] graph = Graphs.adjacency(6, true,
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 3},
                new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 3});

        assertEquals(List.of(2, 3), ArticulationPoints.findArticulationPoints(graph).stream().sorted().toList());
    }

    @Test
    public void searchesEveryComponent() {
        List<Integer>[] graph = Graphs.adjacency(6, true,
                new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4}, new int[]{4, 5});

        assertEquals(List.of(1, 4), ArticulationPoints.findArticulationPoints(graph).stream().sorted().toList());
    }

    @Test
    public void cycleHasNoCutVertices() {
        List<Integer>[] graph = Graphs.adjacency(4, true,
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});

        assertEquals(List.of(), ArticulationPoints.findArticulationPoints(graph));
    }
}
