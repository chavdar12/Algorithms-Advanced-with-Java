import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumTasksAssignmentTests {

    @Test
    public void assignsEveryPerson() throws Exception {
        String input = "Persons: 4\nTasks: 4\nYNYN\nNYYN\nYNYY\nNNNY\n";

        assertEquals("A-3\nB-2\nC-1\nD-4", Console.run(MaximumTasksAssignment::main, input));
    }

    @Test
    public void leavesPersonUnassignedWhenTasksRunOut() throws Exception {
        String input = "Persons: 3\nTasks: 2\nYN\nYN\nNY\n";

        assertEquals("B-1\nC-2", Console.run(MaximumTasksAssignment::main, input));
    }
}
