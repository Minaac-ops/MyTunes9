package sample.be;

public class Category {

        private String genre;
        private static int categoryID;

        public Category(int categoryID, String genre)
        {
            this.genre = genre;
            this.categoryID = categoryID;
        }

        public int getCategoryID()
        {
            return categoryID;
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
