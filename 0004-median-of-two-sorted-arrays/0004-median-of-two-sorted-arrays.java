import java.util.*;

class Solution {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int leftDiv = 0;
        int rightDiv = m;
        while (leftDiv <= rightDiv) {
            int midM = (leftDiv + rightDiv)/2;
            int midN = (m + n + 1)/2 - midM;

            int maxLeftM = (midM == 0) ? Integer.MIN_VALUE : nums1[midM - 1];
            int minRightM = (midM == m) ? Integer.MAX_VALUE : nums1[midM];


            int maxLeftN = (midN == 0) ? Integer.MIN_VALUE : nums2[midN - 1];
            int minRightN = (midN == n) ? Integer.MAX_VALUE : nums2[midN];

            if (maxLeftM <= minRightN && maxLeftN <= minRightM) {
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeftM, maxLeftN) + Math.min(minRightM, minRightN))/2;
                } else {
                    return (double)Math.max(maxLeftM, maxLeftN);
                }
            } else if (maxLeftM > minRightN) {
                rightDiv = midM - 1;
            } else {
                leftDiv = midM + 1;
            }
        }
        return -1;
    }
}