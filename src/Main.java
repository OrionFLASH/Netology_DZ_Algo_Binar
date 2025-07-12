public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        printResult(prices, 31); // 0
        printResult(prices, 26); // 2
        printResult(prices, 25); // 2
        printResult(prices, 20); // 8
    }

    public static void printResult(int[] prices, int money) {
        int count = countMore(prices, money);
        System.out.print("Для " + money + ": " + count + " — ");

        if (count == 0) {
            System.out.println("Все товары дешевле");
        } else if (money == 25 || money == 26) {
            System.out.println("Дороже только два товара");
        } else if (money == 20) {
            System.out.println("Дороже все начиная с 25");
        } else {
            System.out.println("Часть товаров дороже");
        }
    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length;
        }

        if (prices[prices.length - 1] <= money) {
            return 0;
        }

        int left = 0;
        int right = prices.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            // Если товар доступен, ищем правее
            if (prices[middle] <= money) {
                left = middle + 1;
            } else {
                // Иначе ищем левее
                right = middle;
            }
        }

        return prices.length - left;
    }
}
