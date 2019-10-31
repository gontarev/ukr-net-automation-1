package net.ukr.automation;

import net.ukr.automation.transforms.ArrayTransformation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTransformationTest {

    int[] input = new int[] {1,2,3,4,5,-3,2,5,7,9,0,2,3,4,1,-10,12,14};
    int[] output = new int[] {2,4,2,0,2,4,-10,12,14,1,3,5,-3,5,7,9,3,1};

            ArrayTransformation at = new ArrayTransformation();

    @Test
    public void transformTest()
    {
        Assert.assertEquals(Arrays.toString(at.transform(input)), Arrays.toString(output));
    }

    @Test
    public void transformTest2()
    {
        Assert.assertEquals(Arrays.toString(at.transform2(input)), Arrays.toString(output));
    }

    @Test
    public void transformTest3()
    {
        Assert.assertEquals(Arrays.toString(at.transform3(input)), Arrays.toString(output));
    }

    @Test
    public void transformTest4()
    {
        Assert.assertEquals(Arrays.toString(at.transform4(input)), Arrays.toString(output));
    }

    @Test
    public void transformTest5()
    {
        Assert.assertEquals(Arrays.toString(at.transform5(input)), Arrays.toString(output));
    }

}
