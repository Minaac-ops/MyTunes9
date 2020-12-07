package sample.be;

import java.util.List;

public class Playlist {

    private List<Song> songList; //List of songs in the playlist
    private String name;
    private int songCount;
    private String totalTime;
    private final int id;

    public Playlist(String name, int songCount, String totalTime, int id)
    {
        this.name = name;
        this.songCount = songCount;
        this.totalTime = totalTime;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSongCount()
    {
        return songCount;
    }

    public void setSongCount(int songCount)
    {
        this.songCount = songCount;
    }

    public String getTotalTime()
    {
        return totalTime;
    }

    public void setTotalTime(String totalTime)
    {
        this.totalTime = totalTime;
    }

    private final int getId()
    {
        return id;
    }

    private List<Song> getSongList()
    {
        return songList;
    }

    private void setSongList(List<Song> songList)
    {
        this.songList = songList;
    }
}
