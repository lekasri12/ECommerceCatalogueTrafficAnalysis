
import java.util.Arrays;

public class GiftCardPairs {

    public static void findPairs(int[] orders, int target) {

        // Sort the array
        Arrays.sort(orders);

        int left = 0;
        int right = orders.length - 1;

        System.out.println("Matching pairs:");

        while (left < right) {

            int sum = orders[left] + orders[right];

            if (sum == target) {

                System.out.println(
                    orders[left] + " + " + orders[right]
                );

                left++;
                right--;

            } 
            else if (sum < target) {

                left++;

            } 
            else {

                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] orders = {
            10, 20, 30, 40, 50, 60, 70
        };

        int target = 80;

        findPairs(orders, target);
    }
}
