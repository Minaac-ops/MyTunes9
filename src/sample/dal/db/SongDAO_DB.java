package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO_DB {
    private MyDatabaseConnector myDatabaseConnector;

    public SongDAO_DB() throws IOException, SQLServerException {
        myDatabaseConnector = new MyDatabaseConnector();
    }

    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<>();
        
    }

}
