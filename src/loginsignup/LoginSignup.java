/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsignup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author EMPEROR
 */
public class LoginSignup extends Application {
    Stage s1;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException,Exception {
        //FILE
    File f = new File("userdata.txt");
    f.createNewFile();
   // FileOutputStream fo = new FileOutputStream(f,true);
   // ObjectOutputStream ob = new ObjectOutputStream(fo);
  //  FileInputStream fi = new FileInputStream(f);
   // ObjectInputStream oi = new ObjectInputStream(fi);
        
    s1 = primaryStage;
        Button login = new Button("Login");
        Button signup = new Button("Signup");
        Label user = new Label("Username");
        Label pass = new Label("Password");
        TextField text = new TextField();
        PasswordField passf = new PasswordField();
        HBox hb = new HBox();
        hb.getChildren().addAll(login,signup);
        hb.setSpacing(5);
        ImageView back = new ImageView(new Image (new FileInputStream("back1.jpg")));
        back.setFitHeight(50);
        back.setFitWidth(300);
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);
        Scene loginscene = new Scene(grid, 300, 200);
        grid.add(back,0,0,3,3);
        grid.add(user,0,3);
        grid.add(pass,0,4);
        grid.add(text,1,3);
        grid.add(passf,1,4);
        grid.add(hb,1,5);
                
      //  grid.setPadding(new Insets(30,30,30,30));
        grid.setHgap(20);
        grid.setVgap(10);
        s1.setTitle("Log In");
        s1.setScene(loginscene);
        s1.show();
       
            
    
    //FOR SIGNUP:
    GridPane signupgrid = new GridPane();
    
    Scene signupscene = new Scene(signupgrid,400,400);
    Label fname = new Label("First Name");
    Label lname = new Label("Last Name");
    Label email = new Label("Email");
    Label pass1 = new Label("Password");
    Label date = new Label("Date of Birth");
    Label gender = new Label("Gender");
    Label username = new Label("Username");
    TextField fn = new TextField();
    TextField ln = new TextField();
    TextField em = new TextField();
    DatePicker dob = new DatePicker();
    TextField usertext = new TextField();
    PasswordField passtext = new PasswordField();
    RadioButton male = new RadioButton("male");
    RadioButton female = new RadioButton("female");
    ToggleGroup t = new ToggleGroup();
    male.setToggleGroup(t);
    female.setToggleGroup(t);
    HBox hb1 = new HBox();
    hb1.getChildren().addAll(male,female);
    signup.setOnAction(e-> {s1.setScene(signupscene);
            s1.show();
            });
    signupgrid.setPadding(new Insets(30,30,30,30));
    ArrayList<User> users = new ArrayList<>();
    //LABELS
    signupgrid.add(fname,0,0);
    signupgrid.add(lname,0,1);
    signupgrid.add(email,0,2);
    signupgrid.add(username,0,3);
    signupgrid.add(pass1,0,4);
    signupgrid.add(date,0,5);
    signupgrid.add(gender,0,6);
    //TEXTFIELDS
    signupgrid.add(fn,1,0);
    signupgrid.add(ln,1,1);
    signupgrid.add(em,1,2);
    signupgrid.add(usertext,1,3);
    signupgrid.add(passtext,1,4);
    signupgrid.add(dob,1,5);
    signupgrid.add(hb1,1,6);
    signupgrid.setHgap(10);
    signupgrid.setVgap(10);
    signupgrid.setPadding(new Insets(20,20,20,20));
    //SUBMIT & CANCEL
    Button submit = new Button("Submit");
    Button cancel = new Button("Cancel");
    HBox sub = new HBox();
    sub.getChildren().addAll(submit,cancel);
    sub.setSpacing(10);
    signupgrid.add(sub,1,7);
 //   submit.setOnAction(e -> s1.setScene(loginscene));

 


//SUBMIT BUTTON
    submit.setOnAction(e->{
    User n = new User(usertext.getText(),passtext.getText());
        try {
        try {
            writeuser(n,users,f);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        s1.setScene(loginscene);
    
    });
     // LOGIN ACTION
       login.setOnAction(e ->{
        try {
            User n = new User(text.getText(),passf.getText());
          //  Boolean b = readuser(n,f);
            if(readuser(n,f)==true){
            new Movies();
            }else
                System.out.println("123");
            
            s1.hide();
        } catch (IOException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        }


       
       });

 
 
    /*   login.setOnAction(e -> {
        try {
           while(oi.readObject()!=null){
               
           
           
            
        
        
            System.out.println(oi.readObject().toString());
         //   oi.close();
        }
        } catch (IOException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginSignup.class.getName()).log(Level.SEVERE, null, ex);
        }
       });  
    */
    
    
    
    
    }
    
    public void writeuser(User o,List s,File f) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream(f);
        ObjectInputStream bi = new ObjectInputStream(fi);
        ArrayList<User> list =(ArrayList<User>)bi.readObject();
        if(list.size()!=0)
        {
            list.add(o);
            bi.close();
        }
        FileOutputStream fo= new  FileOutputStream(f);
        ObjectOutputStream ob = new ObjectOutputStream(fo);
        ob.writeObject(list);
        ob.close();
    }
   
    
    public boolean readuser(User o,File f) throws FileNotFoundException, IOException, ClassNotFoundException{
    FileInputStream fi = new FileInputStream(f);
    ObjectInputStream bi = new ObjectInputStream(fi); 
    ArrayList<User> list =(ArrayList<User>)bi.readObject();
    for (User s: list){
    if(s.getUsername().equals(o.getUsername()) && s.getPassword().equals(o.getPassword())){
        return true;
    }
        System.out.println(list);
    }
        return false;
    
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
