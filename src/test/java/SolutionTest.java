import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {1,2,1,3,4,4};

        int expected = 3;
        int actual = new Solution().minimumMountainRemovals(nums);

        Assert.assertEquals(expected, actual);
    }
    //
    @Test
    public void test2() {
        int[] nums = {1,2,3,4,4,3,2,1};

        int expected = 1;
        int actual = new Solution().minimumMountainRemovals(nums);

        Assert.assertEquals(expected, actual);
    }
}
