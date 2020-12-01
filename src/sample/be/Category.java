package sample.be;

public class Category {

        private static int id;
        private String name;

        public Category(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }
}
