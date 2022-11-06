public class Video {
    private String title;
    private String date;

    // Default constructor
    public Video() {
        title = null;
        date = null;
    }

    // Generalized constructor
    public Video(String title, String date) {
        this.title = title;
        this.date = date;
    }

    // Copy constructor
    public Video(Video obj) {
        title = obj.getTitle();
        date = obj.getDate();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String toString(int data) {
        return String.valueOf(data);
    }
}
