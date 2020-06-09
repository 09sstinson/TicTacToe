package com.sstinson.tictactoe;

import java.util.Scanner;

public class RunGame {

    private static Scanner obj = new Scanner(System.in);
    private static Game game = new Game();
    private static Player player1 = new Player(Token.CROSS, game);
    private static Player player2 = new Player(Token.NAUGHT, game);
    private static Player[] players = {player1, player2};
    private static Listener listener = new Listener(game);

    public static void main(String[] args){
        newGame();
        resolveGame();
    }

    public static void resolveGame(){
        if(game.board.checkWin()){
            System.out.println("You win");
        } else{
            System.out.println("You draw");
        }
    }

    public static void newGame(){
        int[] pos;
        int count = 0;
        game.board.initGameBoard();
        while(!game.board.checkWin() && !game.board.checkDraw()){
            pos = listener.getPositionFromUser(players[count]);
            players[count].placeToken(pos);
            count++;
            if(count == Player.numPlayer){
                count=0;
            }
        }
    }
}
