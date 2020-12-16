package sample.gui.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SongModel {


    private ObservableList<Song> allSongs;
    private LogicFacade logiclayer;

    public SongModel() throws SQLException, IOException {
        allSongs = FXCollections.observableArrayList();
        logiclayer = new MyTunesManager();
        allSongs.addAll(logiclayer.getAllSongs());
    }

    public ObservableList<Song> getAllSongs() {
        return allSongs;
    }

    public void serchSongs(String query) throws SQLException {
        if (query != null)
        {
            List<Song> searchedSongs = logiclayer.searchSong(query);
            allSongs.clear();
            allSongs.addAll(searchedSongs);
        }
    }

    public void deleteSong(Song songToDelete) {
        logiclayer.deleteSong(songToDelete);
        allSongs.remove(songToDelete);
    }

    public void createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException {
        Song song = logiclayer.createSong(title, artist, category, duration, path);
        allSongs.add(song);
    }

    public void updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws IOException, SQLException {
        logiclayer.updateSong(songToUpdate, title, artist, category, duration, path);
    }
}
