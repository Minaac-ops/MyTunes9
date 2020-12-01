package sample.be;

public class Song {

    private final int id;
    private String title;
    private String artist;
    private String duration;

    public Song(int id, String title, String artist, String duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public int getid()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String toString()
    {
        return id + ": " + artist + " by " + title + " (" + duration + ")";
    }

}
