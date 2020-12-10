package sample.be;

import java.util.List;

public class Playlist {

    private List<Song> songList; //List of songs in the playlist
    private String name;
    // private int songCount;
    // private String totalTime;
    private int id;

    public Playlist(String name, int id) {
        this.name = name;
        //this.songCount = songCount;
        // this.totalTime = totalTime;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  public int getSongCount()
    {
        //  return songCount;
    }

    //  public void setSongCount(int songCount)
    {
        //  this.songCount = songCount;
    }

    //  public String getTotalTime()
    {
        //  return totalTime;
    }

    // public void setTotalTime(String totalTime)
    {
        //  this.totalTime = totalTime;
    }

    public int getId() {
        return id;
    }

    private List<Song> getSongList() {
        return songList;
    }

    private void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() { return "Playlist# " + name + ":" + id;}
}

