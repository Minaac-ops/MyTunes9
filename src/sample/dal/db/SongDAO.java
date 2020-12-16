package sample.dal.db;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SongDAO {

    private MyDatabaseConnector databaseConnector;

    private final JDBCConnectionPool connectionPool;

    public SongDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Song> getAllSongs() throws SQLException
    {
        ArrayList<Song> allSongs = new ArrayList<>();
        Connection con = connectionPool.checkOut();
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Songs;");
            while (rs.next()) {
                int id = rs.getInt("ID_Song");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String category = rs.getString("Category");
                int duration = rs.getInt("Time");
                String path = rs.getString("url");
                Song song = new Song(id, title, artist, category, duration, path);
                allSongs.add(song);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } return allSongs;
    }

    public Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException {
        String sql = "INSERT INTO Songs (Title,Artist,Category,Time,url) VALUES (?,?,?,?,?);";

        try (Connection con = connectionPool.checkOut();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, title);
            st.setString(2, artist);
            st.setString(3, category);
            st.setInt(4, duration);
            st.setString(5, path);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            Song song = new Song(id, title, artist, category, duration, path);
            return song;
        }
    }

    public Song updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws SQLException {
        try (Connection con = connectionPool.checkOut()) {
            String query = "UPDATE Songs SET Title = ?, Artist = ?, Category = ?, Time= ?, url = ? WHERE ID_Song = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, artist);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, duration);
            preparedStatement.setString(5, path);
            preparedStatement.executeUpdate();
            Song song = new Song(songToUpdate.getId(), title, artist, category, duration, path);
            return song;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteSong(Song songToDelete) {
        try (Connection con = connectionPool.checkOut()) {
            String query = "DELETE from Songs WHERE ID_Song = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, songToDelete.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
