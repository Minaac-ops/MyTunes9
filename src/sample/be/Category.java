package sample.be;

public class Category {

        private static int songId;
        private String genre;

        public Category(int id, String genre)
        {
            this.songId = id;
            this.genre = genre;
        }

        public int getSongId()
        {
            return songId;
        }

        public String getGenre()
        {
            return genre;
        }

        public void setGenre(String genre)
        {
            this.genre = genre;
        }
}
