/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsignup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Shah
 */
public class Reciept {
String movieName;
String file; 
        ArrayList<String> no=new ArrayList<>();

int n=3;
GridPane gp=new GridPane();
    public Reciept(ArrayList<String> seat) throws FileNotFoundException {
    
    Stage primaryStage=new Stage();
    
    Scene scene=new Scene(gp,400,400);
    gp.setAlignment(Pos.TOP_LEFT);
    for(int i=0;i<4;i++){
    gp.addColumn(i,new Text("                               \n                               "));
    }
    for(int i=0;i<12;i++){
    gp.addRow(i,new Text("                              \n                               "));
    }
    ImageView iv=new ImageView(new Image(new FileInputStream(new File("ticket.png"))));
    iv.setFitHeight(200);
    iv.setFitWidth(400);
    gp.add(iv,0,0,4,2);
    
    Button buy=new Button("Buy");
    Button cancel=new Button("Cancel");
     Label seats=new Label("Seats");
     seats.setFont(Font.font("ARIAL", FontWeight.THIN, FontPosture.REGULAR, 15));
        gp.add(seats,1, 3);
    
    gp.add(buy,2,8);
    gp.add(cancel,1,8);
    
    buy.setOnMouseClicked((MouseEvent event) -> {
        this.writeDisabled(seat,file);
        JOptionPane.showMessageDialog(null, "Seats Reserved Successfully");
        try {
            new Overview(file, movieName);
        } catch (IOException ex) {
            Logger.getLogger(Reciept.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaryStage.hide();
    });
    cancel.setOnMouseClicked((MouseEvent event) -> {
        try {
            Overview overview=new Overview(file, movieName);
        } catch (IOException ex) {
            Logger.getLogger(Reciept.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaryStage.hide();
    });
    
    // Adding Products
                  for(String strLabel:seat)
                {
                Label l=new Label(strLabel);
                
                gp.add(l,2, n);
                n+=1;
                }
    
    gp.setGridLinesVisible(false);
    primaryStage.setScene(scene);
    primaryStage.show();
    
    }
    
    public void setmovieName(String s)
    {
    movieName=s;
    Label name=new Label();
    name.setText(movieName);
    name.setPadding(new Insets(50));
    name.setFont(Font.font("ALGERIAN", FontWeight.BOLD, FontPosture.REGULAR, 18));
    gp.add(name,1,1,2,1);
    }

    
        public void writeButton(String n,String s)
    {
         try {
             File disableBtn=new File(s);
             
             FileWriter buttonWriter=new FileWriter(disableBtn,true);
             try (BufferedWriter Writer = new BufferedWriter(buttonWriter)) {
                 
                 Writer.write(n);
                 Writer.newLine();
                 Writer.flush();
             }
         } catch (IOException ex) {
             Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

public void writeDisabled(ArrayList<String> b ,String s)
{
           no.clear();
           for(String i:b)
           {
           no.add(i);
           }
    for (String no1 : no) {
        System.out.println(no1);
        writeButton(no1, s);
    }

}
    public void setFile(String address)
    {
    file=address;
    
    }
}
