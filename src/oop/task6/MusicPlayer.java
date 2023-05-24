package oop.task6;

public class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Musicplayer is starting to play");
    }

    @Override
    public void stop() {
        System.out.println("Musicplayer is stopping to play");
    }
}

class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Videoplayer is starting to play");
    }

    @Override
    public void stop() {
        System.out.println("Videoplayer is stopping to play");
    }
}

class Main {
    public static void main(String[] args) {

        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();
        musicPlayer.stop();

        VideoPlayer videoPlayer = new VideoPlayer();
        videoPlayer.play();
        videoPlayer.stop();

    }
}
