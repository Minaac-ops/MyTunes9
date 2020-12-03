package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.manager.MyTunesManager;

import java.util.Comparator;
import java.util.List;

public class SongModel {

    private ObservableList<Song> songs;
    private LogicFacade logicLayer;

    public SongModel()
    {
        songs = FXCollections.observableArrayList();
        logicLayer = new MyTunesManager();
        songs.addAll(logicLayer.getAllSongs());
    }

    public ObservableList<Song> getSongs() {
        return songs;
    }

    public void createMovie(int id, String title, String artist, String category, String duration) {
        Song song = logicLayer.createSong(id, title, artist, category, duration);
        songs.add(song);
    }

    public void deleteSong(Song song) {
            logicLayer.deleteSong(song);
            songs.remove(song);
    }

        public void search(String query) {
            if (query != null) {
                List<Song> searchedSongs = logicLayer.searchSongs(query);
                songs.clear();
                songs.addAll(searchedSongs);
            }
        }

        public void updateSong(Song selectedSong) {
            logicLayer.updateSong(selectedSong);
            if (songs.remove(selectedSong)) {
                songs.add(selectedSong);
                songs.sort(Comparator.comparingInt(Song::getId));
            }
        }

    }
