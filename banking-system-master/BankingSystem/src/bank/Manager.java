package bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Manager  {
    private String name;
    private String password;
    private static BufferedWriter writer = null;

    public Manager(String Name, String Password) {
        this.name="admin";
        this.password="admin";
    }

    public static boolean createCustomer(String Name1, String Password1) {
        String tmp1 = Name1;
        String tmp2 = Password1;
        //String tmp3 = num;
        if ((tmp1 != null) && (tmp2 != null)) {
            try {
                    File f = new File(""+tmp1+".txt");
                    if(!f.exists()) {
                            writer = new BufferedWriter(new OutputStreamWriter(
                                            new FileOutputStream("" +tmp1+".txt"), "utf-8"));
                            writer.write(tmp1);
                            writer.newLine();
                            writer.write(tmp2);
                            writer.newLine();
                            writer.write("0");
                            return true;
                    }
            } catch(IOException ex) {
                    System.out.println("File" +tmp1+".txt not created");
            } finally {
                    try {writer.close();} catch(Exception ex) {
                            System.out.println("File not closed properly.");
                    }
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean deleteCustomer(String Name) {
        String tmp1 = Name;
        if (tmp1 != null){
            File file = new File(""+Name+".txt");
            if (file.exists()){
                file.delete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }   
}