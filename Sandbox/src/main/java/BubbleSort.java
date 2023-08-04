public class BubbleSort {

    public static void main(String args[]) {
        int[] sortArr = {19, 5, 9, 2, 13, 7};
        bubble(sortArr, true);

        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }

        bubble(sortArr, false);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void bubble(int[] sortArr, boolean ascending) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (ascending) {
                    if (sortArr[j + 1] < sortArr[j]) {
                        int swap = sortArr[j];
                        sortArr[j] = sortArr[j + 1];
                        sortArr[j + 1] = swap;
                    }
                } else {
                    if (sortArr[j + 1] > sortArr[j]) {
                        int swap = sortArr[j];
                        sortArr[j] = sortArr[j + 1];
                        sortArr[j + 1] = swap;
                    }
                }
            }
        }
    }
}