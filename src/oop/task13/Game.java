package oop.task13;
/*
Создайте класс Game, представляющий компьютерную игру, с методами start() и stop(). Создайте классы StrategyGame,
RPGGame и SportsGame, которые наследуются от Game и переопределяют его методы. Создайте экземпляры классов и вызовите
их методы start() и stop().
 */
public class Game {
    public void start() {
        System.out.println("Start Game");
    }

    public void stop() {
        System.out.println("Stop Game");
    }
}

class StrategyGame extends Game {
    @Override
    public void start() {
        System.out.println("Start StrategyGame");;
    }

    @Override
    public void stop() {
        System.out.println("Stop StrategyGame");
    }
}

class RpgGame extends Game {
    @Override
    public void start() {
        System.out.println("Start RpgGame");
    }

    @Override
    public void stop() {
        System.out.println("Stop RpgGame");
    }
}

class SportGame extends Game {
    @Override
    public void start() {
        System.out.println("Start SportGame");
    }

    @Override
    public void stop() {
        System.out.println("Stop SportGame");
    }
}

class Main {
    public static void main(String[] args) {
        StrategyGame strategyGame = new StrategyGame();
        strategyGame.start();
        strategyGame.stop();
        System.out.println();

        RpgGame rpgGame = new RpgGame();
        rpgGame.start();
        rpgGame.stop();
        System.out.println();

        SportGame sportGame = new SportGame();
        sportGame.start();
        sportGame.stop();
    }
}
