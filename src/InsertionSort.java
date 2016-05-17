public class InsertionSort {

        public static int[] sort(int[] ary) {
                int tmp;

                for (int i = 1; i < ary.length; i++) {
                        for (int j = i; j >= 1; j--) {
                                if (ary[j] < ary[j - 1]) {
                                        tmp = ary[j];
                                        ary[j] = ary[j - 1];
                                        ary[j - 1] = tmp;
                                }

                        }
                }
                return ary;
        }
}

