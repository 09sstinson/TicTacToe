package com.sstinson.tictactoe;

public class GameBoard {

    public final int size = 3;
    Tile[][] tiles = new Tile[size][size];

    public void initGameBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                tiles[i][j] = new Tile();
            }
        }
    }

    public void placeToken(int[] pos, Token token){
        Tile tile;
        tile = tiles[pos[0]-1][pos[1]-1];
        tile.status = token;
    }

    public boolean checkWin(){
        return checkColumnWin() || checkRowWin() || checkDiagonalWin();
    }

    public boolean checkDraw() {
        return isAllFilled() && !checkWin();
    }

    public boolean checkRowWin(){
        for(int i = 0;i<size;i++){
            if(checkEquals(tiles[i])){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnWin(){
        Tile[] col = new Tile[size];
        for(int j =0;j<size;j++) {
            for (int i = 0; i < size; i++) {
                col[i] = tiles[i][j];
            }
            if(checkEquals(col)){
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalWin(){
        Tile[] rdiag = new Tile[size];
        Tile[] ldiag = new Tile[size];
        for(int i =0;i<size;i++) {
            rdiag[i] = tiles[i][i];
            ldiag[i] = tiles[i][size-(i+1)];
        }

        return checkEquals(rdiag) || checkEquals(ldiag);
    }

    public boolean checkEquals(Tile[] tiles) {
        int i = 0;
        if (tiles[0].status != null) { // eliminate case when all statuses are null
            while (tiles[size - 1].status == tiles[i].status && i < size - 1) {
                i++;
            }
        }
        return i == size-1;
    }

    public boolean isAllFilled(){
        for(int i = 0; i<size ; i++){
            for(int j = 0;j<size;j++){
                if(tiles[i][j].status == null){
                    return false;
                }
            }
        }
        return true;
    }
}
