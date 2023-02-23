
public class Main {
    public static void main(String[] args) {
        int[] numbers = {0,1,3};
        System.out.println(tim_so_thieu(numbers));
    }
    public static int tim_so_thieu(int[] nums) {
        boolean check = false;
        int a = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int num : nums) {
                if (i == num) {
                    check = true;
                    break;
                } else {
                    check = false;
                    a = i;
                }
            }
            if (!check) {
                break;
            }
        }
        return a;
    }

}