package businessLogic;

import exception.PercentException;
import model.PercentProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerManagerTest {
    private CustomerManager manager;

    @Before
    public void setUp() throws Exception {
        manager = new CustomerManager();
    }

    @Test
    public void percent() throws Exception {
        Assert.assertEquals(50, manager.percent(2,1), 1.0);

        Assert.assertEquals(25, manager.percent(200,50), 1.0);
    }

    @Test(expected = PercentException.class)
    public void nullDivide() throws Exception {
        manager.percent(0,0);
    }

    @Test(expected = PercentException.class)
    public void amountHigher() throws Exception {
        manager.percent(3,6);
    }

    @Test(expected = PercentException.class)
    public void negativeDivide() throws Exception {
        manager.percent(-6,-3);
    }

    @Test(expected = PercentException.class)
    public void nullAmount() throws Exception {
        manager.percent(6,null);
    }
}