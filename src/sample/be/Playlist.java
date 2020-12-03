package sample.be;

public class Playlist {

    private String name;
    private String duration;
    private int songs = 0;
    private int id;

    public Playlist(int id, String name)
    {
        this.name = name;
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


    public String toString()
    {
        return "Playlist#" + id + ": " + name;
    }
}
