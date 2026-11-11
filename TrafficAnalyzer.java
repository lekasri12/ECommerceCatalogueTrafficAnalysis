
public class TrafficAnalyzer {

    public static void findBusiestWindow(int[] traffic, int k) {

        int sum = 0;

        // Calculate the first window
        for (int i = 0; i < k; i++) {
            sum += traffic[i];
        }

        int maxSum = sum;
        int start = 0;

        // Slide the window
        for (int i = k; i < traffic.length; i++) {

            sum = sum - traffic[i - k] + traffic[i];

            if (sum > maxSum) {
                maxSum = sum;
                start = i - k + 1;
            }
        }

        System.out.println("Busiest 3-hour window:");
        System.out.println("Starting hour: " + start);
        System.out.println("Ending hour: " + (start + k - 1));
        System.out.println("Total visitors: " + maxSum);
    }

    public static void main(String[] args) {

        // Website visitors for 24 hours
        int[] traffic = {
            10, 15, 20, 25, 30, 45,
            60, 80, 100, 120, 90, 70,
            50, 40, 35, 30, 25, 20,
            15, 10, 12, 14, 16, 18
        };

        int k = 3;

        findBusiestWindow(traffic, k);
    }
}
