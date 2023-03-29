public class Main {
    public static void main(String[] args) {
        MyGraph test = new MyGraph();
        test.parseGraph("demo.dot");
//      test
        test.outputGraphics("demo1.png", "png");
    }


}
