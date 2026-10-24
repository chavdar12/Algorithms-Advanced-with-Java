import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTests {

    @Test
    public void picksMostValuableItems() throws Exception {
        String input = "20\nBeer 2 12\nVodka 12 31\nCheese 5 30\nNuts 4 15\nHam 3 90\nWater 3 10\nend\n";

        assertEquals("Total Weight: 17\nTotal Value: 157\nBeer\nCheese\nHam\nNuts\nWater",
                Console.run(Knapsack::main, input));
    }

    @Test
    public void nothingFits() throws Exception {
        assertEquals("Total Weight: 0\nTotal Value: 0", Console.run(Knapsack::main, "5\nGold 10 100\nend\n"));
    }

    @Test
    public void reportedWeightMatchesPickedItems() throws Exception {
        // the full-capacity column can hold a heavier set of equal value than the minimal one
        assertEquals("Total Weight: 5\nTotal Value: 10\nB", Console.run(Knapsack::main, "10\nA 10 10\nB 5 10\nend\n"));
    }
}
