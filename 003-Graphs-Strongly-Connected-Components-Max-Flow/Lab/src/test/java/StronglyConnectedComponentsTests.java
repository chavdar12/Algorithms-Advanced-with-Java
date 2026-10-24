import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StronglyConnectedComponentsTests {

    private static Set<Set<Integer>> components(List<Integer>[] graph) {
        return StronglyConnectedComponents.findStronglyConnectedComponents(graph).stream()
                .map(HashSet::new)
                .collect(Collectors.toSet());
    }

    @Test
    public void findsComponents() {
        List<Integer>[] graph = Graphs.adjacency(6, false,
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 3},
                new int[]{3, 4}, new int[]{4, 3}, new int[]{4, 5});

        assertEquals(Set.of(Set.of(0, 1, 2), Set.of(3, 4), Set.of(5)), components(graph));
    }

    @Test
    public void dagHasSingletonComponents() {
        List<Integer>[] graph = Graphs.adjacency(3, false, new int[]{0, 1}, new int[]{1, 2});

        assertEquals(Set.of(Set.of(0), Set.of(1), Set.of(2)), components(graph));
    }
}
