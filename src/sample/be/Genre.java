package sample.be;

public class Genre {

        private String genre;
        private static int genreID;

        public Genre(int genreID, String genre)
        {
            this.genre = genre;
            this.genreID = genreID;
        }

        public int getGenreID()
        {
            return genreID;
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
