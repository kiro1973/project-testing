package bank;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ManagerTestintegration extends TestCase {



    public static class integ {


     public static ArrayList<String>arr1 = new ArrayList<>();

      public  static ArrayList<String> arr = new ArrayList<>();

       public static boolean createcustomer(String nam,String pass) {
           if ((nam==null)||(pass==null))
                   return false;
           else if(arr.contains(nam+" "+pass)){
               return false;
           }
           else {
               arr.add(nam + " " + pass);
               arr1.add(nam);
               return true;
           }
       }

       public static boolean del_customer(String namee) {
           arr1.add("nachaat1");
           arr1.add("shady");
           if (namee == null) {
               return false;
           }

               for (String element : arr1) {
                   if (element.equals(namee)) {
                       arr1.remove(element);
                       return true;
                   }
               }


return  false ;
       }
      public static boolean Driver_createCustomer(String customer,String password_customer){
           boolean x = false ;
           if (customer!=null && password_customer!=null)
              x =  Manager.createCustomer(customer,password_customer);
           return  x;
       }

       public static boolean Driver_deleteCustomer(String customer){
           boolean y ;
          y= Manager.deleteCustomer(customer);
           return y ;
       }

    }



@Test
    public void testCreateCustomer() {
        String customer_name="nachaat1";
       String password = "0128";
       boolean output= integ.createcustomer(customer_name,password);
        assertTrue(output);
    }
    @Test
    public void testCreateCustomer2() {
       String customer_name="shady";
       String password = null;
        boolean output= integ.createcustomer(customer_name,password);
        assertFalse(output);
    }

@Test
    public void testDeleteCustomer() {
      String  customer_name = null;
        boolean out = integ.del_customer(customer_name);
        assertFalse(out);
    }

    @Test
    public void testDeleteCustomer2() {
       String customer_name1 = "nachaat1";
        boolean out = integ.del_customer(customer_name1);
        assertTrue(out);
    }
@Test
    public void Driver_test_createCustomer(){
String customer_name ="s";
String password = "s" ;
        assertTrue(integ.Driver_createCustomer(customer_name,password));

}

@Test
public void Driver_test_delCustomer(){
       String customer_name = "s";
        assertTrue(integ.Driver_deleteCustomer(customer_name));
}

}