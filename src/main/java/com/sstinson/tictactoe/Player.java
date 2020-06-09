package com.sstinson.tictactoe;

public class Player {

    Token token;
    Game game;
    static int numPlayer = 0;
    int playerNum;

    public Player(Token token, Game game){
        this.token = token;
        this.game = game;
        numPlayer++;
        playerNum = numPlayer;
    }

    public void placeToken(int[] pos){
        game.board.placeToken(pos, token);
    }
}