package BinarySearch;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {

        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int[] nums = {0, 1, 0};
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray2(nums));
        System.out.println("Rahul khichar");
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && i != n - 1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int ans = -1;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid != 0 && mid != n && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid != 0 && arr[mid] > arr[mid-1]) {
                left = mid ;
            } else {
                right = mid ;
            }
        }
        return ans;
    }
}
