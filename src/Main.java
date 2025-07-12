public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        int left = 0;
        int right = prices.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (prices[mid] <= money) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left — индекс первого элемента, который > money
        return prices.length - left;
    }
}
