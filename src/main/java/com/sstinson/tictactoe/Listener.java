package com.sstinson.tictactoe;

import java.util.Scanner;

public class Listener {

    private  Scanner obj = new Scanner(System.in);
    private Game game;

    public Listener(Game game){
        this.game = game;
    }

    public int[] getPositionFromUser(Player player){
        int x,y;
        int[] pos = new int[2];
        do {
            System.out.println("Please enter a position Player " + player.playerNum);
            x = getIntFromUser();
            y = getIntFromUser();
            pos[0] = x;
            pos[1] = y;
        } while( !isIntValid(pos) );

            return pos;

    }

    //need to validate inputs ie space not already filled and inside array bounds
    public int getIntFromUser() {

            while (!obj.hasNextInt()) {
                System.out.println("Please enter an integer");
                obj.next();
            }
        return obj.nextInt();
    }

    public boolean isPositionFilled(int[] pos){
        if(game.board.tiles[pos[0]-1][pos[1]-1].status != null ){
            System.out.println("Position filled already");
            return false;
        }
        return true;

    }

    public boolean isPositionInBounds(int[] pos){
        int size = game.board.size;
        if(1<=pos[0] && pos[0]<=size && 1<=pos[1] && pos[1]<=size){
            return true;
        }
        System.out.println("Position not in bounds");
        return false;
    }

    public boolean isIntValid(int[] pos){
        return isPositionInBounds(pos) && isPositionFilled(pos);
    }
}
