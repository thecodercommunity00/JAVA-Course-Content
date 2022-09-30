import java.util.Scanner;

public class BS {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = { 5, 6 };
        // System.out.println(BSCE(arr, 6));
        System.out.println(BSFluctuationpoint(arr));
    }

    public static int BSCE(int arr[], int data) {
        int li = 0;
        int ri = arr.length - 1;

        if (arr[li] > data)
            return li;
        if (arr[ri] < data)
            return ri;

        while (li <= ri) {
            int mid = (li + ri) / 2;

            if (arr[mid] == data)
                return mid;

            else if (arr[mid] < data)
                li = mid + 1;

            else
                ri = mid - 1;
        }

        return data - arr[ri] <= arr[li] - data ? ri : li;
    }

    public static int BSFluctuationpoint(int arr[]) {
        int li = 0;
        int ri = arr.length - 1;

        if (arr[li] <= arr[ri])
            return ri; // if sorted

        while (li < ri) {
            int mid = (li + ri) / 2;
            if (arr[mid] - arr[li] < 0) {
                ri = mid;
            } else if (arr[ri] - arr[mid] < 0) {
                li = mid;
            }

            if (li == ri - 1) {
                return li; // end of 1st sorted part.
            }
        }
        return ri;
    }
}