package bank;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class ManagerTest extends TestCase {

    public String name1;
    public String password1;



    @Test
    public void testCreateCustomer() {
        name1=null;
        password1 = "2786";
        boolean output = Manager.createCustomer(name1,password1);
        assertFalse(output);
    }
    @Test
    public void testCreateCustomer2() {
        name1="customer";
        password1 = "2786";
        boolean output = Manager.createCustomer(name1,password1);
        assertTrue(output);
    }
    @Test
    public void testCreateCustomer3() {
        name1=null;
        password1 = null;
        boolean output = Manager.createCustomer(name1,password1);
        assertFalse(output);
    }
@Test
    public void testDeleteCustomer() {
        name1="pola";
        boolean output = Manager.deleteCustomer(name1);
        assertFalse(output);

    }

    @Test
    public void testDeleteCustomer2() {
        name1="customer";
        boolean output = Manager.deleteCustomer(name1);
        assertTrue(output);
    }
    @Test
    public void testDeleteCustomer3() {
        name1=null;
        boolean output = Manager.deleteCustomer(name1);
        assertFalse(output);
    }
}