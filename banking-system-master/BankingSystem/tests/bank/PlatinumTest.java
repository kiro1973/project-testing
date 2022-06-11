package bank;
import static org.junit.Assert.*;
import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class PlatinumTest extends TestCase {


    Customer kiro = new Customer("Kiro ","122333",1000);
    Platinum platinum = new Platinum();
    @Test
    public void testcheck_Deposit() {
        int Amount = 300000;
        kiro.cheqDeposit(Amount);
        assertEquals(Amount,kiro.getCheckBalance());
        //assertTrue(Gold.setTheLevel(Customer c) == );
    }

    @Test
    public void testcheck_Withdraw() {
        int Amount2 = 100000;
        kiro.cheqWithdraw(Amount2);
        assertEquals(300000-Amount2,kiro.getCheckBalance());
        //assertTrue(Gold.setTheLevel(Customer c) == );
    }

    @Test
    public void test_Platinum ()
    {
        Customer kiro = new Customer("Kiro ","122333",1000);
        platinum.setTheLevel(kiro);
        Level y = kiro.getMylevel();
        boolean output = y instanceof Platinum;
        assertTrue(output);
    }

}