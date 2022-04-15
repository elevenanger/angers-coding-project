package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 16:49
 * @description : 接口-使用工厂方法的游戏框架
 */
public class Games {
    public static void playGame(GameFactory factory){
        Game game = factory.getGame();
        while (game.move());
    }

    public static void main(String[] args) {
        Games.playGame(new CheckersFactory());
        Games.playGame(new ChessFactory());
        /* output
        Checkers.move() 0
        Checkers.move() 1
        Checkers.move() 2
        Chess.move() 0
        Chess.move() 1
        Chess.move() 2
        Chess.move() 3
         */
    }
}

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;
    @Override
    public boolean move() {
        System.out.println(getClass().getSimpleName() + ".move() " + moves);
        return ++moves!=MOVES;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;
    @Override
    public boolean move() {
        System.out.println(getClass().getSimpleName() + ".move() " + moves);
        return ++moves!=MOVES;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }
}