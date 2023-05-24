package oop.task6;
/*
Создайте интерфейс Playable с методами play() и stop(). Создайте классы MusicPlayer и VideoPlayer, которые реализуют
интерфейс Playable и переопределяют его методы. Создайте экземпляры классов MusicPlayer и VideoPlayer и вызовите их
методы play() и stop().
 */
public interface Playable {
    public void play();

    public void stop();
}
