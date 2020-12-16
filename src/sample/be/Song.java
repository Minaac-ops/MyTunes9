package sample.be;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Song {

    private static final String PROP_FILE = "resources/config.properties";

    private int id;
    private String title;
    private String artist;
    private String category;
    private int duration;
    private String path;
    private int IDD;

    public Song(int id, String title, String artist, String category, int duration, String path) throws IOException {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.duration = duration;
        this.path = path;
        Properties pathProperties = new Properties();
        pathProperties.load(new FileInputStream(new File(PROP_FILE)));
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public String getPath() throws IOException {
        String url;
        Properties pathProperties = new Properties();
        FileInputStream ip = new FileInputStream(PROP_FILE);
        pathProperties.load(ip);
        url = pathProperties.getProperty("url");
        return url + path;

    }

    public int getIDD() {
        return IDD;
    }

    public void setIDD(int IDD) {
        this.IDD = IDD;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String toString()
    {
         return "Song#" + id + ": " + title + " by " + artist + " (" + duration + "min." + ")";
    }
}
