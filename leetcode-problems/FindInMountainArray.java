/**
 * This is MountainArray's API interface.You should not implement it, or
 * speculate about its implementation interface MountainArray { public int
 * get(int index) {} public int length() {} }
 */

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        /*
         * finding peak index in the array
         */
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                /**
                 * this is possible ans but let's check in the left side.
                 */
                end = mid;
            } else if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                /**
                 * this is possible ans but let's check in the right side.
                 */
                start = mid + 1;
            }
        }
        int peakIndex = start;
        /*
         * searching target element in the ascending part of array
         */
        int resIndex = binarySearch(target, mountainArr, 0, peakIndex, true);
        if (resIndex == -1) {
            /*
             * searching target element in the descending part of array
             */
            resIndex = binarySearch(target, mountainArr, peakIndex + 1, mountainArr.length() - 1, false);
        }
        return resIndex;
    }

    public int binarySearch(int target, MountainArray mountainArr, int start, int end, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else {
                if (isAscending) {
                    if (mountainArr.get(mid) > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (mountainArr.get(mid) < target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
