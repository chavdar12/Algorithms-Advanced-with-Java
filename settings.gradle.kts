rootProject.name = "Algorithms-Advanced-with-Java"

listOf(
    "001-Graphs-Topological-Sorting-MST/Lab",
    "002-Graphs-Bellman-Ford-Longest-PathIn-DAG/Lab",
    "002-Graphs-Bellman-Ford-Longest-PathIn-DAG/Exercise",
    "003-Graphs-Strongly-Connected-Components-Max-Flow/Lab",
    "003-Graphs-Strongly-Connected-Components-Max-Flow/Exercise",
    "004-Dynamic-Programming-Advanced/Lab",
    "004-Dynamic-Programming-Advanced/Exercise",
).forEach { dir ->
    val name = dir.replace('/', '-')
    include(name)
    project(":$name").projectDir = file(dir)
}
