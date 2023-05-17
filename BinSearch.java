public class BinSearch {
    public static void main(String[] args) {
        int[] prices = { 13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30 };

//        На вход подается упорядочный массив с ценами на товары и цена сертификата.
//        Необходимо найти количество товаров, которые нельзя купить с
//        помощью сертификата

            String str1 = new String("A");
            String str2 = new String("A");
        System.out.println(str1 == str2);

    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length;
        }

        if (prices[prices.length - 1] < money) {
            return 0;
        }

        int left = 0;
        int right = prices.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (prices[middle] == money && prices[middle+1] != money ) {
                return prices.length - middle;
            } else if (prices[middle] < money) {
                if (prices[middle + 1] < money) {
                    left = middle + 1;
                } else if (prices[middle+1] > money) {
                    return prices.length - middle -1;
                }
            } else if (prices[middle] > money && prices[middle-1] > money) {
                right = middle -1;
            }
        }

//        while (left < right) {
//            int middle = (left + right) / 2;
//            if ((prices[middle] >= money && prices[middle-1] < money) || (prices[middle] > money && prices[middle-1] == money)) {
//                return prices.length - middle;
//            } else if ((prices[middle] < money) || (prices[middle] == money && prices[middle+1] == money) || (prices[middle] == money && prices[middle+1] > money)) {
//                left = middle + 1;
//            } else if (prices[middle] > money && prices[middle-1] > money) {
//                right = middle - 1;
//            }
//        }


        return 0;
    }
}
