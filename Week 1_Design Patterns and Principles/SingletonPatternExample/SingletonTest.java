public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both references point to the same instance
        System.out.println(logger1 == logger2); // Should print true

        logger1.log("Logging a message from logger1.");
        logger2.log("Logging a message from logger2.");
    }
}
