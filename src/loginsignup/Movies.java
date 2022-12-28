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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author EMPEROR
 */
public class Movies {
    
   
    GridPane moviegrid = new GridPane();
    public Movies()throws FileNotFoundException, IOException{
 
       
    Stage moviest = new Stage();
    
    moviegrid.setGridLinesVisible(false);
 
    Scene moviesc = new Scene(moviegrid,1366,700);
    moviegrid.setPadding(new Insets(30,30,30,30));    
    
    
    Button moana=new Button();
    Button smallfoot=new Button();

    this.setGraphics(moana,"moana.jpg");
    this.setGraphics(smallfoot,"smallfoot.jpg");
    
    moana.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            try {
                new Overview("moana.txt","Moana");
            } catch (IOException ex) {
                Logger.getLogger(Movies.class.getName()).log(Level.SEVERE, null, ex);
            }
    moviest.hide();
        }
    });
    smallfoot.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            try {
                new Overview("smallfoot.txt","SmallFoot");
            } catch (IOException ex) {
                Logger.getLogger(Movies.class.getName()).log(Level.SEVERE, null, ex);
            }
     moviest.hide();
        }
    });
    Background movieback = new Background(new BackgroundImage((new Image(new FileInputStream("movieback.jpg"))), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

   
   moviegrid.add(moana,0,4);
   moviegrid.add(smallfoot,1,4);
   
    moviegrid.setBackground(movieback); 
   //moviegrid.add(select,0,0);
    for(int i=0;i<6;i++){
    moviegrid.addColumn(i,new Text("                                                                  "));
    }
    for(int i=0;i<30;i++){
    moviegrid.addRow(i,new Text("                                                                  "));
    }
    moviegrid.setVgap(30);
    moviegrid.setHgap(30);
   

    moviest.setScene(moviesc);
    moviest.show();
    
    
  //  ImageView movie1 = new ImageView(new Image(new FileInputStream("")));
    
    
    }

    public void setGraphics(Button m,String s) throws FileNotFoundException
    {
    
    ImageView image = new ImageView(new Image(new FileInputStream(new File(s))));
    image.setFitHeight(200);
    image.setFitWidth(150);
    m.setGraphic(image);
        System.out.println("set graphic call"+s);
    }
    
    
}
