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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * @author EMPEROR
 */
public class Overview {

    
    ArrayList<Button> buttons = new ArrayList<>(100);
    ArrayList<String> strings=new ArrayList<>();
    Overview(String s,String name) throws FileNotFoundException, IOException{
  
       
    Stage st = new Stage();
    GridPane grid = new GridPane();
    grid.setVgap(30);
    grid.setHgap(30);
    Scene sc = new Scene(grid,1366,700);
    
    
// ALL BUTTONS
    
    for(int i = 0;i<90;i++){
    buttons.add(new Button(new String(""+i)));
    ImageView iv=new ImageView(new Image(new FileInputStream("button1.jpg")));
    iv.setFitHeight(25);
    iv.setFitWidth(25);
    buttons.get(i).setTextFill(null);
    buttons.get(i).setGraphic(iv);
    
    } 
    readDisabled(s); 
    grid.setGridLinesVisible(false);
    
    
    File fB=new File("back (2).jpg");
  Image background = new Image(new FileInputStream(fB));
   Background b1 = new Background(new BackgroundImage(background,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
    grid.setBackground(b1);
    
    
    
   
    
    
   for(Button b:buttons)
   {
   b.setOnMouseClicked((MouseEvent event) -> {
       strings.add(b.getText());
       b.setDisable(true);
   });
  
   

   }
  
   
 // PLACING L1
    HBox L1 = new HBox();
    for(int i=0;i<=9;i++){
    L1.getChildren().add(buttons.get(i));
    }
    L1.setSpacing(10);
    
    grid.add(L1,0,0);
         // PLACING R1
    HBox hR1 = new HBox();
    for(int i=10;i<=19;i++){
    hR1.getChildren().add(buttons.get(i));
    }
    hR1.setSpacing(10);
    grid.add(hR1,2,0);
//PLACING L2
    HBox L2 = new HBox();
    L2.getChildren().add(new Text("              "));
    for(int i=20;i<=28;i++){
    L2.getChildren().add(buttons.get(i));
    }
    L2.setSpacing(10);
    
    grid.add(L2,0,1);
//PLACING R2
    HBox hR2 = new HBox();
 //   R2.getChildren().add(new Text("              "));
    for(int i=29;i<=37;i++){
    hR2.getChildren().add(buttons.get(i));
    }
    hR2.setSpacing(10);
    grid.add(hR2,2,1);
   
//PLACING L3
    HBox L3 = new HBox();
     L3.getChildren().add(new Text("                               "));
    for(int i=38;i<=45;i++){
    L3.getChildren().add(buttons.get(i));
    }
    L3.setSpacing(10);
    
    grid.add(L3,0,2);
//PLACING R3
    HBox hR3 = new HBox();
  //   R3.getChildren().add(new Text("                               "));
    for(int i=46;i<=53;i++){
    hR3.getChildren().add(buttons.get(i));
    }
    hR3.setSpacing(10);
    grid.add(hR3,2,2);
        
//PLACING L4
    HBox L4 = new HBox();
     L4.getChildren().add(new Text("                                                "));
    for(int i=54;i<=60;i++){
    L4.getChildren().add(buttons.get(i));
    }
    L4.setSpacing(10);
    
    grid.add(L4,0,3);
    //PLACING R4
    HBox hR4 = new HBox();
    // R4.getChildren().add(new Text("                                                "));
    for(int i=61;i<=67;i++){
    hR4.getChildren().add(buttons.get(i));
    }
    hR4.setSpacing(10);
    grid.add(hR4,2,3); 
    
//PLACING L5
    HBox L5 = new HBox();
    L5.getChildren().add(new Text("                                                                 "));
    for(int i=68;i<=73;i++){
    L5.getChildren().add(buttons.get(i));
    }
    L5.setSpacing(10);
    
    grid.add(L5,0,4);
    
//PLACING R5
    HBox hR5 = new HBox();
  //  R5.getChildren().add(new Text("                                                                 "));
    for(int i=74;i<=79;i++){
    hR5.getChildren().add(buttons.get(i));
    }
    hR5.setSpacing(10);
    grid.add(hR5,2,4);
    
//PLACING L6
    HBox L6 = new HBox();
    L6.getChildren().add(new Text("                                                                                   "));
    for(int i=80;i<=84;i++){
    L6.getChildren().add(buttons.get(i));
    }
    L6.setSpacing(10);
    
    grid.add(L6,0,5);
    
//PLACING R6
    HBox hR6 = new HBox();
  //  R6.getChildren().add(new Text("                                                                                  "));
    for(int i=85;i<=89;i++){
    hR6.getChildren().add(buttons.get(i));
    }
    hR6.setSpacing(10);
    grid.add(hR6,2,5);
    Button back=new Button("Back");
    back.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            try {
                new Movies();
            } catch (IOException ex) {
                Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
            }
st.hide();
        }
    });
    Button bill=new Button("Reciept");
    bill.setOnMouseClicked(e->{
        try {
            Reciept r;
            
            r = new Reciept(strings);
            
            r.setmovieName(name);
            r.setFile(name+".txt");
            st.hide();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    grid.setGridLinesVisible(false);
    grid.add(bill,2,6);
    grid.add(back, 2,7);
    grid.setPadding(new Insets(50,50,50,50));
    st.setScene(sc);
    st.show();
    }

    
    



    public void readDisabled(String s) throws FileNotFoundException, IOException
    {
     BufferedReader br=new BufferedReader(new FileReader(new File(s)));
    String temp;    
    while((temp=br.readLine())!=null)
{
        String a=temp;
        
        for(int g=0;g<90;g++){
if(a.contains(new String(""+g))==true)
{
    
buttons.get(Integer.parseInt(a)).setDisable(true);
}
        }

}
    }
   
}    

