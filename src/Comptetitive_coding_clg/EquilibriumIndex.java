public class EquilibriumIndex {

    static int findEquilibriumIndex(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;


            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    static int findEquilibriumIndex_optimize(int[] arr) {

        int totalSum = 0;


        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    static List<Integer> findAllEquilibriumIndex_optimize(int[] arr){
        List<Integer> list = new ArrayList<>();

        int totalSum = 0;


        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
              list.add(i);
            }

            leftSum += arr[i];
        }

        return list;

    }
}
