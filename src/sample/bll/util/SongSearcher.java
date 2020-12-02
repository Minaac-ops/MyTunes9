package sample.bll.util;

import sample.be.Song;

import java.util.ArrayList;
import java.util.List;

public class SongSearcher {

    /**
     * Searches for Songs that matches the given query String
     *
     */
    public static List<Song> search(List<Song> searchBase, String query)
    {
        List<Song> result = new ArrayList<>(searchBase);
        result.removeIf(song -> !(song.getTitle().toLowerCase().contains(query.toLowerCase()) || ("" + song.getArtist()).contains(query)));

        return result;
    }
}
