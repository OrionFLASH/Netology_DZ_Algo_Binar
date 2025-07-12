public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        printResult(prices, 31);
        printResult(prices, 26);
        printResult(prices, 25);
        printResult(prices, 20);
    }

    public static void printResult(int[] prices, int money) {
        int count = countMore(prices, money);
        System.out.print("Для " + money + ": " + count + " — ");

        if (count == 0) {
            System.out.println("Все товары дешевле");
        } else {
            int index = prices.length - count;
            int firstUnavailablePrice = prices[index];

            // Считаем, сколько товаров стоят ровно эту цену
            int samePriceCount = 0;
            for (int price : prices) {
                if (price == firstUnavailablePrice) {
                    samePriceCount++;
                }
            }

            if (count == 1) {
                System.out.println("Дороже только один товар");
            } else if (count == samePriceCount) {
                System.out.println("Дороже все начиная с " + firstUnavailablePrice);
            } else {
                System.out.println("Часть товаров дороже начиная с " + firstUnavailablePrice);
            }
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

            if (prices[middle] <= money) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return prices.length - left;
    }
}
