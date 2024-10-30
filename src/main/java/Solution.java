class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] ldsRes = new int[n];
        lds(nums, ldsRes);
        int[] tails = new int[n];
        tails[0] = nums[0];
        int p = 0;
        if(tails[p] < nums[1]) {
            if(ldsRes[1] > 1) {
                res = Math.max(res, 1 + ldsRes[1]);
            }

        }
        for(int i = 1; i < n - 1 ; i++) {
            int cur = nums[i];
            if(cur > tails[p]) {
                p++;
                tails[p] = cur;
                if(ldsRes[i + 1] > 1 && tails[p] < nums[i + 1]) {
                    res = Math.max(res, p + 1 + ldsRes[i + 1]);
                }
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
            if(tails[p] < nums[i + 1]) {
                if(ldsRes[i + 1] > 1) {
                    res = Math.max(res, p + 1 + ldsRes[i + 1]);
                }

            }
        }


        return nums.length - res;
    }

    int lis(int end, int[] nums) {
        if(end == -1) {
            return 0;
        }


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
    int lds(int[] nums, int[] ldsRes) {
        int  n = nums.length;

        int[] tails = new int[n];
        tails[0] = nums[n - 1];
        int p = 0;
        for(int i = n - 2; i > 0; i--) {
            int cur = nums[i];
            if(cur > tails[p]) {
                p++;
                tails[p] = cur;
                ldsRes[i] = p + 1;
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
            ldsRes[i] = p + 1;
        }

        return p;
    }
}