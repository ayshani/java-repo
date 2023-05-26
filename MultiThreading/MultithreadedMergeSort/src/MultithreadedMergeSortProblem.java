public class MultithreadedMergeSortProblem {

    private static int SIZE = 25;
    private int[] input = new int[SIZE];
    private int[] scratch = new int[SIZE];

    public void mergeSort(int start, int end, int[] input) {

        if(start == end)
            return;

        int mid = start +(end-start)/2;

        Thread worker1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mergeSort(start,mid,input);
            }
        });

        Thread worker2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mergeSort(mid+1,end,input);
            }
        });
         worker1.start();
         worker2.start();

         try {
             worker1.join();
             worker2.join();
         } catch(InterruptedException e){

         }

         merge(input, start,mid, end);
    }

    private void merge(int[] input, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int k;

        for (k = start; k <= end; k++) {
            scratch[k] = input[k];
        }

        k = start;
        while (k <= end) {

            if (i <= mid && j <= end) {
                input[k] = Math.min(scratch[i], scratch[j]);

                if (input[k] == scratch[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i <= mid && j > end) {
                input[k] = scratch[i];
                i++;
            } else {
                input[k] = scratch[j];
                j++;
            }
            k++;
        }
    }
}
