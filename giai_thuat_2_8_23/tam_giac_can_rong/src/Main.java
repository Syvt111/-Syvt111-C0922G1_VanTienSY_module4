public class Main {
    public static void main(String[] args) {
        System.out.println("*");
        for (int i = 1; i < 7; i++) {
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 7; i > 0; i--) {
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.println("*");
    }
}