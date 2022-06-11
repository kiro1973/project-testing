package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Project extends Application {
        
	  private static String commands;
	  private static int commandInt;
	  private static Customer currentUser;
	  
	  
	  private static boolean LoginAuth(String temp1, String temp2) {
	    String usrname = null;
	    String pwd = null;
	    int accType = 10;
	    int money;
	    int balance = 0;

	    BufferedReader file = null;
	    
	    if (temp1.equals("admin") && temp2.equals("admin")) {
	    	return true;
	    } else {
	    	try {
	    		file = new BufferedReader(new FileReader(""+temp1+".txt"));
	    		usrname = file.readLine();
	    		pwd = file.readLine();
		    	balance = Integer.parseInt(file.readLine());
	    		} catch(Exception ex) {
	    			//TDO nothing
	        	} finally {
	            	if(temp1.equals(usrname) && temp2.equals(pwd)) {
	            		currentUser = new Customer(temp1, temp2, balance);
	            		if (balance < 10000) {
	            			Level level = new Silver();
	            			level.setTheLevel(currentUser);
		            		return true;
	            		} else if (balance >= 10000 && balance < 20000) {
	            			Level level = new Gold();
	            			level.setTheLevel(currentUser);
		            		return true;
	            		} else if (balance > 20000) {
	            			Level level = new Platinum();
	            			level.setTheLevel(currentUser);
		            		return true;
	            		}            		
	            	}	
	    	}
	    }    
	    return false;
	  }
	  	
	  public static void main(String[] args) {
	    Manager manager = new Manager("admin", "admin");
		launch(args);
	  }

    
    Stage window;
    BufferedWriter writer = null;
    
	@Override
	public void start(Stage primaryStage)  {
        window = primaryStage;

		
	//Welcome Window and login window
        primaryStage.setTitle("JavaFX Welcome Scene");
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Welcome to Fahim's Bank!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid1.add(scenetitle, 0, 0, 2, 1);
        Label userName = new Label("Username:");
        grid1.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid1.add(userTextField, 1, 1);
        Label pw = new Label("Password:");
        grid1.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid1.add(pwBox, 1, 2);
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid1.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();
        grid1.add(actiontarget, 1, 6);        
        Scene scene1 = new Scene(grid1, 300, 275, Color.BEIGE);
        
        // Manager Options
        window = primaryStage;
        Button button1 = new Button("Create Customer");
        Button button2 = new Button("Delete Customer");
        Button button3 = new Button("Logout");		
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));        
        grid2.add(button1, 0, 1);
        grid2.add(button2, 0, 2);
        grid2.add(button3, 0, 3);   
        Scene scene2 = new Scene(grid2, 300, 275);
        
        // Customer Options
        window = primaryStage;
        Button button4 = new Button("Deposit");
        Button button5 = new Button("Withdraw");
        Button button6 = new Button("Online Purchase");
        Button button7 = new Button("Check Balance");
        Button button8 = new Button("Logout");		
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));
        grid3.add(button4, 0, 1);
        grid3.add(button5, 0, 2);
        grid3.add(button6, 0, 3);
        grid3.add(button7, 0, 4);
        grid3.add(button8,  0,  5);
        Scene scene3 = new Scene(grid3, 400, 400);
        
        // Enter Amount to deposit
        window = primaryStage;
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));
        Label text = new Label("Enter Amount to deposit");
        grid4.add(text, 0, 1);
        TextField txtField = new TextField();
        grid4.add(txtField, 1, 1);        
        Button button9 = new Button("Done");
        grid4.add(button9,  1, 2);    	
        Scene scene4 = new Scene(grid4, 400, 400);

        //Enter Amount to Withdraw
        window = primaryStage;
        GridPane grid5 = new GridPane();
        grid5.setAlignment(Pos.CENTER);
        grid5.setHgap(20);
        grid5.setVgap(20);
        grid5.setPadding(new Insets(25, 25, 25, 25));
        Label text1 = new Label("Enter Amount to withdraw");
        grid5.add(text1, 0, 1);
        TextField txtField1 = new TextField();
        grid5.add(txtField1, 1, 1);        
        Button button10 = new Button("Done");
        grid5.add(button10,  1, 2);    	
        Scene scene5 = new Scene(grid5, 400, 400);
        
        //Enter Amount to Online Purchase
        window = primaryStage;
        GridPane grid6 = new GridPane();
        grid6.setAlignment(Pos.CENTER);
        grid6.setHgap(10);
        grid6.setVgap(10);
        grid6.setPadding(new Insets(25, 25, 25, 25));
        Label text2 = new Label("Enter Amount for online purchase");
        grid6.add(text2, 0, 1);
        TextField txtField2 = new TextField();
        grid6.add(txtField2, 1, 1);        
        Button button11 = new Button("Done");
        grid6.add(button11,  1, 2);    	
        Scene scene6 = new Scene(grid6, 400, 400);
        
        // Check Balance
        window = primaryStage;
        GridPane grid7 = new GridPane();
        grid7.setAlignment(Pos.CENTER);
        grid7.setHgap(10);
        grid7.setVgap(10);
        grid7.setPadding(new Insets(25, 25, 25, 25));
        Label text3 = new Label("Your Balance is");
        grid7.add(text2, 0, 1);
        Label text4 = new Label("");
        IntegerProperty balance = new SimpleIntegerProperty(0);
        text4.textProperty().bind(balance.asString());
        grid7.add(text4, 1, 1);        
        Button button12 = new Button("Done");
        grid7.add(button12,  1, 2);
        Scene scene7 = new Scene(grid7, 400, 400);
      
        // Create Customer
        GridPane grid8 = new GridPane();
        grid8.setAlignment(Pos.CENTER);
        grid8.setHgap(10);
        grid8.setVgap(10);
        grid8.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle1 = new Text("Enter username and passwrod of new customer");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid8.add(scenetitle1, 0, 0, 2, 1);
        Label userName1 = new Label("User Name:");
        grid8.add(userName1, 0, 1);
        TextField userTextField1 = new TextField();
        grid8.add(userTextField1, 1, 1);
        Label pw1 = new Label("Password:");
        grid8.add(pw1, 0, 2);
        PasswordField pwBox1 = new PasswordField();
        grid8.add(pwBox1, 1, 2);
        Button btn1 = new Button("Done");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid8.add(hbBtn1, 1, 5);
        final Text actiontarget1 = new Text();
        grid8.add(actiontarget1, 1, 6);        
        Scene sceneCreateCustomer = new Scene(grid8, 400, 400);
        
        // Delete Customer
        GridPane grid9 = new GridPane();
        grid9.setAlignment(Pos.CENTER);
        grid9.setHgap(10);
        grid9.setVgap(10);
        grid9.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle2 = new Text("Enter username customer to delete");
        scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid9.add(scenetitle2, 0, 0, 2, 1);
        Label userName2 = new Label("Username:");
        grid9.add(userName2, 0, 1);
        TextField userTextField2 = new TextField();
        grid9.add(userTextField2, 1, 1);
        Button btn2 = new Button("Done");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid9.add(hbBtn2, 1, 5);
        final Text actiontarget2 = new Text();
        grid9.add(actiontarget2, 1, 6);        
        Scene sceneDeleteCustomer = new Scene(grid9, 400, 400);
        
        
        //Error Scene
        GridPane grid99 = new GridPane();
        grid99.setAlignment(Pos.CENTER);
        grid99.setHgap(10);
        grid99.setVgap(10);
        grid99.setPadding(new Insets(25, 25, 25, 25));
        Label text99 = new Label("There has been an error. You have been kicked out.");
        grid99.add(text99, 0, 1);      
        Button button99 = new Button("Okay");
        grid99.add(button99,  1, 2);    	
        Scene scene99 = new Scene(grid99, 500, 500);
        button99.setOnAction(e -> window.setScene(scene1));
        
        window.setScene(scene1);
        window.show();
		
	// Login Authorization
        btn.setOnAction(e -> {
	        if(LoginAuth(userTextField.getText(), pwBox.getText())) {
	            if (userTextField.getText().equals("admin")) {
	                window.setScene(scene2);
	            }	            
	            else {
	                window.setScene(scene3);
	            }
        }});
        
        button3.setOnAction(e -> window.setScene(scene1)); // Logout from Manager
        button1.setOnAction(e -> window.setScene(sceneCreateCustomer)); //Create Customer
        button2.setOnAction(e -> window.setScene(sceneDeleteCustomer)); // Delete Customer
		

	// Exit After Creating Customer
        btn1.setOnAction(e -> {
        	String tmp1 = userTextField1.getText();
        	String tmp2 = pwBox1.getText();
            if ((tmp1 != null) && (tmp2 != null)) {
            	if(Manager.createCustomer(tmp1, tmp2)){
                    window.setScene(scene2);
                } else{
                    window.setScene(scene99);
                }
            } else {
                window.setScene(scene99);
            }
        });
        
        // Exit After Deleting Customer
        btn2.setOnAction(e -> {
            String tmp1 = userTextField2.getText();
            if(Manager.deleteCustomer(tmp1)){
                window.setScene(scene2);
            } else {
                window.setScene(scene99);
            }

	});   
        
        button4.setOnAction(e -> window.setScene(scene4)); //Deposit
        button5.setOnAction(e -> window.setScene(scene5)); //Withdraw
        button6.setOnAction(e -> window.setScene(scene6)); //Online purchase

        //Check Balance
        button7.setOnAction(e -> {
                balance.setValue(currentUser.checkBalance);
                window.setScene(scene7);
        });

        //Logout from Customer
        button8.setOnAction(e -> {
            currentUser.updateBalance(currentUser.getName(), currentUser.getPassword(), currentUser.checkBalance);
            window.setScene(scene1); 
        }); 
        button12.setOnAction(e -> window.setScene(scene3));
        
        //Deposit Amount
        button9.setOnAction(e -> { 
        	int tmp10 = Integer.parseInt(txtField.getText());
            if (tmp10 > 0) {
                //TODO Deposit
                currentUser.cheqDeposit(tmp10);
                window.setScene(scene3);
            } else {
                System.err.println("IllegalArgumentException");
                window.setScene(scene99); 
            }
        });
        
        // Withdraw Amount
        button10.setOnAction(e ->{
            int tmp10 = 0; 
            tmp10 = Integer.parseInt(txtField1.getText());
            if (tmp10 > 0 && currentUser.checkBalance > tmp10) { //TODO Negative Balance Check
                //TODO Withdraw
                currentUser.cheqWithdraw(tmp10);
            	//currentUser.checkBalance -= tmp10;
                window.setScene(scene3);
            } else {
                window.setScene(scene99);
            }
        });	

        // Online Purchase
        button11.setOnAction(e -> {
            int tmp10 = 0;
            tmp10 = Integer.parseInt(txtField2.getText());
            if (tmp10 >= 50 ) {                  
            	if (currentUser.onlinePurchase(tmp10, currentUser)){
                    window.setScene(scene3);
                }
                else{
                    window.setScene(scene99);
                }
            } else {
                window.setScene(scene99);
            }	
        });    
	}
}
