class Solution43 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len2 > len1){
            int[] tempNums = nums1;
            nums1 = nums2;
            nums2 = tempNums;
        }

        len1 = nums1.length;
        len2 = nums2.length;

        int totalLeft = (len1 + len2 +1) /2;

        return 0d;
    }

    public int findIndex2(int[] nums1, int[] nums2, int totalLeft, int index2){
        int index1 = totalLeft-index2;

        return 0;
    }
}