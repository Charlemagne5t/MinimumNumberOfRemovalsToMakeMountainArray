import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {2,1,1,5,6,2,3,1};

        int expected = 3;
        int actual = new Solution().minimumMountainRemovals(nums);

        Assert.assertEquals(expected, actual);
    }
    //
    @Test
    public void test2() {
        int[] nums = {9,8,1,7,6,5,4,3,2,1};

        int expected = 2;
        int actual = new Solution().minimumMountainRemovals(nums);

        Assert.assertEquals(expected, actual);
    }
}
