package bank;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class GoldTest extends TestCase {

    Customer shady = new Customer("shady ","123",100);
    Gold gold = new Gold();
    @Test
    public void testcheck_Deposit() {
        int Amount = 15000 ;
        shady.cheqDeposit(Amount);
        assertEquals(Amount+100,shady.getCheckBalance());
        //assertTrue(Gold.setTheLevel(Customer c) == );
    }
    @Test
    public void test_Gold ()
    {
        Customer shadyyy = new Customer("shady ","123",100);
      gold.setTheLevel(shadyyy);
      Level x = shadyyy.getMylevel();
      boolean output = x instanceof Silver;
     assertTrue(output);

    }

}