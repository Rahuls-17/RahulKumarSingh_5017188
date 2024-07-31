public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display(); // Loads and displays image1
        image1.display(); // Displays cached image1

        image2.display(); // Loads and displays image2
        image2.display(); // Displays cached image2
    }
}
