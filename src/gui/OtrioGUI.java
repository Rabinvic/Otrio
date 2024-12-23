package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Observer;
import model.OtrioModel;

public class OtrioGUI extends Application implements Observer<OtrioModel, String>{

    private OtrioModel model;
    private Scene titleScene;
    private Scene disclaimerScene;
    private Scene playerSelectionScene;
    private Scene rulesScene;
    private Scene board;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        makeTitleScene();
        makePlayerSelectionScene();
        
        
        this.stage.setScene(titleScene);
        this.stage.setTitle("Otrio");
        this.stage.setResizable(false);
        this.stage.show();
    }

    @Override
    public void init() throws Exception {
        model=new OtrioModel();
        model.addObserver(this);
    }

    private void makeBoardScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = makGridPane();
        bp.setCenter(gp);
        gp.setAlignment(Pos.CENTER);
        board=new Scene(bp);

        Label playerLabel1 = createPlayerLabel(1);
        bp.setTop(playerLabel1);
        bp.setAlignment(playerLabel1, Pos.CENTER);

        Label playerLabel2 = createPlayerLabel(2);
        bp.setBottom(playerLabel2);
        bp.setAlignment(playerLabel2, Pos.CENTER);

        if(model.getPlayers() >= 3){
            Label playerLabel3 = createPlayerLabel(3);
            bp.setLeft(playerLabel3);
        }
        if(model.getPlayers() == 4){
            Label playerLabel4 = createPlayerLabel(4);
            bp.setRight(playerLabel4);
        }

        
    }

    private Label createPlayerLabel(int player){
        int[] playerInfo = model.getPlayerInfo(player-1);
        String playerInfoString = "";
        for(int i = 0; i < 3; i++){
            playerInfoString += playerInfo[i];
            if (i != 2){
                playerInfoString += ",";
            }
        }
        System.out.println(playerInfoString);
        Label lb = new Label("Player " + player + ": "+ playerInfoString);
        return lb;
    }
    private void makePlayerSelectionScene(){
        FlowPane playerSelect=makePlayerSelectFP();
        playerSelectionScene=new Scene(playerSelect);
        playerSelect.setAlignment(Pos.CENTER);
    }

    private void makeTitleScene() throws FileNotFoundException{
        BorderPane bp= new BorderPane();
        FlowPane fp=new FlowPane();
        Label authLabel=new Label("Application by Victor Rabinovich");

        Image image=new Image(new FileInputStream("src/images/otrio.jpeg"));
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        Button newGameButton=new Button("New Game");
        newGameButton.setOnAction(event -> stage.setScene(playerSelectionScene));
        Button rulesButton=new Button("Rules");
        Button disclaimerButton=new Button("Disclaimer");

        disclaimerButton.setOnAction(event -> {makeDisclaimerScene(); stage.setScene(disclaimerScene);});
        rulesButton.setOnAction(event -> {makeRulesPane(); stage.setScene(rulesScene);});

        fp.getChildren().addAll(newGameButton,rulesButton,disclaimerButton);
        bp.setBottom(fp);
        fp.setAlignment(Pos.BOTTOM_CENTER);

        bp.setCenter(imageView);
        bp.setTop(authLabel);
        //imageView.setAlignment(Pos.CENTER);

        titleScene=new Scene(bp);
    }

    private void makeDisclaimerScene(){
        BorderPane bp = new BorderPane();
        Label disclaimer=new Label("Otrio is a Trademark of Spin Master Ltd.\nThis is just made for fun and as aprreciation for the wonderful game they've created");
        disclaimer.setStyle("-fx-font-size: 24px;-fx-content-display: center;");
        bp.setCenter(disclaimer);

        Button backButton=new Button("Main Menu");
        backButton.setOnAction(event -> stage.setScene(titleScene));
        backButton.setStyle("-fx-font-size: 20px;");
        bp.setTop(backButton);
        backButton.setAlignment(Pos.TOP_LEFT);
        disclaimerScene=new Scene(bp);
    }

    private void makeRulesPane(){
        BorderPane bp = new BorderPane();
        Label rules=new Label("Each player will have their own set of pieces including 3 big, medium, and small pieces of the same color.\n Going in order, players place their respective color peice onto the board.If the player can not make a move they skip their turn until a player has achieved an Otrio.\n\nTo get an Otrio and win the game, a player must have all 3 types of pieces in a singular cell, have 3 in the row of the same size, or 3 in a row of ascending or descending piecies.");
        rules.setStyle("-fx-font-size: 18px;-fx-content-display: center;");
        bp.setCenter(rules);

        Button backButton=new Button("Main Menu");
        backButton.setOnAction(event -> stage.setScene(titleScene));
        backButton.setStyle("-fx-font-size: 20px;");
        bp.setTop(backButton);
        backButton.setAlignment(Pos.TOP_LEFT);
        rulesScene=new Scene(bp);
    }

    private FlowPane makePlayerSelectFP(){
        FlowPane fp=new FlowPane();
        for(int i=2;i<=4;i++){
            Button b = new Button("Players: "+i);
            int players=i;
            b.setOnAction(event -> {model.setPlayers(players); makeBoardScene(); stage.setScene(board);});
            b.setPrefSize(100, 100);
            fp.getChildren().add(b);
        }
        return fp;
    }
    private GridPane makGridPane(){
        GridPane gp= new GridPane();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Button b=new Button();
                b.setPrefSize(100, 100);
                b.setStyle("-fx-bacground-color: white;");
                gp.add(b, j, i);
            }
        }
        return gp;
    }

    @Override
    public void update(OtrioModel model, String msg) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
