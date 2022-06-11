package bank;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class CustomerTest_1 extends TestCase {

    String customer_name="bolbol";
    String Password="bolbolv";

    int customer_balance ;
    public   Customer customer= new Customer(customer_name,Password,100);
    Level customer_level = new Gold();

    @Test
    public void test_cheq_deposit()
    {
        int amount=200;
        customer.cheqDeposit(100);
        Assert.assertEquals(amount,customer.getCheckBalance());
    }
    @Test
    public void test_cheq_deposit_for_negative ()
    {
        //int amount=200;
        customer.cheqDeposit(-100);

        Assert.assertEquals(0,customer.getCheckBalance());
    }
    /*
    @Test(expected=IllegalArgumentException.class)
    public void test_cheq_deposit_for_negative ()
    {
        //int amount=200;
        customer.cheqDeposit(-100);
       customer.getCheckBalance();
        //Assert.assertEquals(0,customer.getCheckBalance());
    }

     */
    @ Test
    public void test_cheqWithdraw()
    {
        int withraw_amount=50;
        Assert.assertTrue(customer.cheqWithdraw(withraw_amount));
    }
    public void test_cheqWithdraw_negative()
    {
        int withraw_amount=200;
        Assert.assertEquals(true,customer.cheqWithdraw(withraw_amount));
    }
    @Test
    public void test_get_name()
    {
        Assert.assertEquals("bolbol",customer.getName());
    }
    @Test
    public void test_get_password()
    {
        Assert.assertEquals("bolbol",customer.getPassword());
    }
    @Test
    public void test_get_wrong_password()
    {
        Assert.assertEquals("bolbol",customer.getPassword());
    }
    @Test
    public void test_getcheckBalance()
    {
        Assert.assertEquals(100,customer.getCheckBalance());
    }
    public void test_wrong_getcheckBalance()
    {
        Assert.assertEquals(110,customer.getCheckBalance());
    }
    @Test
    public void test_positiveCheck()
    {
        Assert.assertTrue(customer.positiveCheck(0));
    }
    @Test
    public void testonlinePurchase()
    {
        customer.setTheLevel(new Gold());
        Assert.assertEquals(true,customer.onlinePurchase(30,customer));

    }

    public void testonlinePurchase_1()
    {
        customer.setTheLevel(new Gold());
        Assert.assertEquals(true,customer.onlinePurchase(60,customer));

    }

}