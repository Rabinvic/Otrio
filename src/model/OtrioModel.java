package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OtrioModel {
    private List<Observer<OtrioModel, String>> observers;
    private int numPlayers;
    private ArrayList<int[]> players = new ArrayList<int[]>();


    static int[] player1Pieces, player2Pieces, player3Pieces, player4Pieces;

    public OtrioModel(){
        observers = new LinkedList<Observer<OtrioModel, String>>();
    }

    public void addObserver(Observer<OtrioModel, String> observer){
        observers.add(observer);
    }

    public void setPlayers(int numPlayers){
        this.numPlayers=numPlayers;
        for (int i = 0; i < numPlayers; i++){
            players.add(new int[3]);
            for(int j = 0; j < 3; j++){
                players.get(i)[j] = 3;
            }
        }
    }

    public int getPlayers(){
        return this.numPlayers;
    }

    public int[] getPlayerInfo(int player){
        return players.get(player);
    }
    
}
