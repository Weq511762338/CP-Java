package LeetCode;

public class MedianOfTwoSortedArr {
    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{-2, -1}, new int[]{3}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n)
            return bs(nums2, nums1);
        else
            return bs(nums1, nums2);

    }

    public static double bs (int[] small, int[] large){

        int l = 0;
        int r = small.length - 1;

        while(true){
            int Xl = (l + r)/2 < 0 ? -Integer.MAX_VALUE : small[(l + r)/2];
            int Yl = (small.length  + large.length + 1)/2 - (l + r)/2 - 1 - 1 < 0 ? -Integer.MAX_VALUE : large[(small.length + large.length + 1)/2 - (l + r)/2 - 1 - 1];

            int Xr = (l + r)/2 + 1 >= small.length ? Integer.MAX_VALUE : small[(l + r)/2 + 1];
            int Yr = (small.length  + large.length + 1)/2 - (l + r)/2 - 1 >= large.length ? Integer.MAX_VALUE : large[(small.length  + large.length + 1)/2 - (l + r)/2 - 1];

            if(Xl <= Yr && Yl <= Xr){
                if((small.length + large.length)%2 == 1)
                    return Math.max(Xl, Yl);
                else
                    return (Math.max(Xl, Yl) + Math.min(Xr, Yr))/2.0;
            }

            if(Xl > Yr)
                r = (l + r)/2 - 1;
            else if(Yl > Xr)
                l = (l + r)/2 + 1;
        }


    }
}
