package sample.gui.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;

public class PlaylistModel {

    private SimpleObjectProperty<Playlist> selectedPlaylist;
    private ObservableList<Song> songsOnPlaylist;

    private LogicFacade logicFacade;

    public PlaylistModel() {
        selectedPlaylist = new SimpleObjectProperty<>();
        logicFacade = new MyTunesManager();
        //songsOnPlaylist.addAll(logicFacade.getAllSongsOnSelectedPlaylist());
    }

    public void getSelectedPlaylist(ObservableValue<Playlist> playlist) {
        selectedPlaylist.bind(playlist);
    }

}
