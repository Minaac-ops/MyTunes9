package sample.be;

public class Playlist {

    public static int id;
    private String name;
    private String duration;
    private int songs;

    public Playlist(int id, String name, String duration, int songs)
    {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.songs = songs;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public int getSongs()
    {
        return songs;
    }

    public void setSongs(int songs)
    {
        this.songs = songs;
    }
}
