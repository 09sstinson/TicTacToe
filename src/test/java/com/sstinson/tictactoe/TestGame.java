package com.sstinson.tictactoe;

import org.junit.Test;

public class TestGame {

    @Test
    public void shouldPlaceToken(){
        Game game = new Game();
        Player player = new Player(Token.CROSS, game);
        int[] pos = {1,1};
        player.placeToken(pos);
        System.out.println(game.board.tiles[0][0].status);
//        int[][] a = {{2,3},{3,4}};
//        int[] b = {2,3};
//        if(Arrays.equals(a[0],b)){
//            System.out.println("yes");
//        }
    }

    @Test
    public void testCheckRowWin(){
        Game game = new Game();
        Player player = new Player(Token.CROSS, game);
        int[][] positions = {{1,1},{1,2},{1,3}};
        for(int[] pos:positions){
            player.placeToken(pos);
        }
        System.out.println(game.board.checkRowWin());
    }

    @Test
    public void testCheckColumnWin(){
        Game game = new Game();
        Player player = new Player(Token.CROSS, game);
        int[][] positions = {{1,1},{2,1},{3,1}};
        for(int[] pos:positions){
            player.placeToken(pos);
        }

        System.out.println(game.board.checkColumnWin());
    }

    @Test
    public void testCheckDiagonalWin(){
        Game game = new Game();
        Player player = new Player(Token.CROSS, game);
        int[][] positions = {{1,1},{2,2},{3,3}};
        for(int[] pos:positions){
            player.placeToken(pos);
        }
        System.out.println(game.board.checkDiagonalWin());
    }

    @Test
    public void testPlayerNum(){
        Game game = new Game();
        Player player1 = new Player(Token.CROSS, game);
        Player player2 = new Player(Token.CROSS, game);

        System.out.println(player1.playerNum);
        System.out.println(player2.playerNum);
    }
}
