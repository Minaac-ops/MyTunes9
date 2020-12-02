package sample.be;

public class Playlist {

    private String name;
    private String duration;
    private int songs;
    private int id;

    public Playlist(int id, String name, int songs, String duration)
    {
        this.name = name;
        this.duration = duration;
        this.songs = songs;
        this.id = id;
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

    public String toString()
    {
        return "Playlist: " + name + ", " + songs + "songs, " + duration + "min";
    }
}
