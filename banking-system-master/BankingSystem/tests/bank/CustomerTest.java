package bank;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class CustomerTest extends TestCase {

String customer_name="bolbol";
String Password="bolbol";

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
    @Test(expected=IllegalArgumentException.class)
    public void test_cheq_deposit_for_negative ()
    {
        //int amount=200;
        customer.cheqDeposit(-100);
        //Assert.assertEquals(0,customer.getCheckBalance());
    }
@ Test
    public void test_cheqWithdraw()
{
    int withraw_amount=50;
    Assert.assertTrue(customer.cheqWithdraw(withraw_amount));
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
            public void test_getcheckBalance()
    {
        Assert.assertEquals(100,customer.getCheckBalance());
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
        Assert.assertFalse(customer.onlinePurchase(30,customer));

    }


}