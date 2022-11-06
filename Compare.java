import java.util.Comparator;

public class Compare implements Comparator<Video> {

    @Override
    public int compare(Video o1, Video o2) {
        // Access titles of video objects to be compared
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();

        // Compare video object titles to see which one is larger
        if (title1.compareTo(title2) > 0) {
            return 1;
        } else if (title1.compareTo(title2) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
