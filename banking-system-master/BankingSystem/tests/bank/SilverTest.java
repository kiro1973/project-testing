package bank;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class SilverTest extends TestCase {

    @BeforeClass
    public static void setUp_SetTheLevel() {
        System.out.println("STARTING JUNIT Test of "+Silver.class.getName());
        Customer nach = new Customer("nach","098",20);
        Silver silver = new Silver();
        int Amount = 8000;
        nach.cheqDeposit(Amount);
        assertEquals(Amount,nach.getCheckBalance());

        silver.setTheLevel(nach);
        Level lvl = nach.getMylevel();
        boolean output = lvl instanceof Silver;
        assertTrue(output);

        silver.setTheLevel(nach);
        Level lvl2 = nach.getMylevel();
        boolean output1 = lvl2 instanceof Platinum;
        assertFalse(output1);

    }

@Before
public void setUP(){
        System.out.println("NOW TESTING");
}
@After
public void Teardown(){

        System.out.print("TEST IS OVER");

}

    @AfterClass
    public static void tearDownClass() {

        Customer nach = new Customer("aka","123098",20);
        Silver silver = new Silver();
        int Amount = 6000;
        nach.cheqDeposit(Amount);
        assertEquals(Amount,nach.getCheckBalance());

        silver.setTheLevel(nach);
        Level lvl = nach.getMylevel();
        boolean output = lvl instanceof Silver;
        assertTrue(output);

        silver.setTheLevel(nach);
        Level lvl2 = nach.getMylevel();
        boolean output1 = lvl2 instanceof Platinum;
        assertFalse(output1);
        System.out.println("END JUNIT TEST OF "+Silver.class.getName());
    }

    @Test
    public void test_Silver2()
    {
        Silver silver = new Silver();
        Customer nach = new Customer("nach","098",20);
        silver.setTheLevel(nach);
        Level y = nach.getMylevel();
        boolean output = y instanceof Silver;
        assertTrue(output);
    }


    @Test
    public void test_Silver ()
    {
        Customer nach = new Customer("aka","123098",20);
        Silver silver = new Silver();
        silver.setTheLevel(nach);
        Level y = nach.getMylevel();
        boolean output = y instanceof Silver;
        assertTrue(output);
    }



}