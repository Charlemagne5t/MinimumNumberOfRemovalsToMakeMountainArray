class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int res = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            int left = lis(i, nums);
            int right = lds(i, nums);
            if(left != 0 && right != 0) {
                res = Math.max(res, 1 + left + right);
            }

        }


        return nums.length - res;
    }

    int lis(int end, int[] nums) {
        if(end == -1) {
            return 0;
        }

        int  n = nums.length;
        int[] tails = new int [end + 1];
        tails[0] = nums[0];
        int p = 0;
        for(int i = 1; i <= end; i++) {
            int cur = nums[i];
            if(cur > tails[p]) {
                p++;
                tails[p] = cur;
                continue;
            }
            int l = 0;
            int r = p;
            int mid;
            int replacePoint = 0;
            while(l <= r) {
                mid = l + (r - l) / 2;
                if(tails[mid] >= cur) {
                    replacePoint = mid;
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
            tails[replacePoint] = cur;
        }

        return p;
    }
    int lds(int start, int[] nums) {
        int  n = nums.length;
        if(start == n) {
            return 0;
        }

        int[] tails = new int[n - start];
        tails[0] = nums[n - 1];
        int p = 0;
        for(int i = n - 2; i >= start; i--) {
            int cur = nums[i];
            if(cur > tails[p]) {
                p++;
                tails[p] = cur;
                continue;
            }
            int l = 0;
            int r = p;
            int mid;
            int replacePoint = 0;
            while(l <= r) {
                mid = l + (r - l) / 2;
                if(tails[mid] >= cur) {
                    replacePoint = mid;
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
            tails[replacePoint] = cur;
        }

        return p;
    }
}