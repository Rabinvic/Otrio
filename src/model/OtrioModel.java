package model;

import java.util.LinkedList;
import java.util.List;

public class OtrioModel {
    private List<Observer<OtrioModel>> observers;
    private int players;


    static int[] player1Pieces, player2Pieces, player3Pieces, player4Pieces;

    public OtrioModel(){
        observers = new LinkedList<Observer<OtrioModel>>();
    }

    public void addObserver(Observer<OtrioModel> observer){
        observers.add(observer);
    }

    public void setPlayers(int numPlayers){
        this.players=numPlayers;
    }

    
    
}
