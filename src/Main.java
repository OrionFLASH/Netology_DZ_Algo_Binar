public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        // Если первый товар уже дороже — все недоступны
        if (prices[0] > money) {
            return prices.length;
        }

        // Если даже последний товар дешевле — все доступны
        if (prices[prices.length - 1] <= money) {
            return 0;
        }

        int left = 0;
        int right = prices.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            // Если в middle первый недоступный товар,
            // то все после него тоже недоступны — идем влево
            if (prices[middle] > money) {
                right = middle;
            }
            // Если товар по цене подходит — ищем правее
            else {
                left = middle + 1;
            }
        }

        // После выхода из цикла left — индекс первого недоступного товара
        return prices.length - left;
    }
}
