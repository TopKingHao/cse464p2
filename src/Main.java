public class Main {
    public static void main(String[] args) {
        System.out.println("random testing");
        MyGraph myGraph = new MyGraph();
        myGraph.parseGraph("input2.dot");
        GraphSearchStrategy graphSearchSolution = new GraphSearchStrategy(new SearchStrategyRandom());
        for (int i = 0; i < 4; i++) {
            System.out.println("Test " + i);
            MyGraph.Path path = graphSearchSolution.graphSearch(myGraph, "a", "c");
            System.out.println("Path: " + path.toString());
        }
    }
}
