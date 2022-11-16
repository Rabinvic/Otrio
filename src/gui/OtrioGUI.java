package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Observer;
import model.OtrioModel;

public class OtrioGUI extends Application implements Observer<OtrioModel>{

    private OtrioModel model;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        GridPane gp = makGridPane();

        bp.setCenter(gp);
        
        primaryStage.setScene(new Scene(bp));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        model=new OtrioModel();
        model.addObserver(this);
    }

    private GridPane makGridPane(){
        GridPane gp= new GridPane();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Button b=new Button();
                gp.add(b, j, i);
            }
        }
        return gp;
    }
    @Override
    public void update(OtrioModel model) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
