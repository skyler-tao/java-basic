package skyler.tao.refactor.chapter1;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int princeCode;

    public Movie(String title, int princeCode) {
        this.title = title;
        this.princeCode = princeCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrinceCode() {
        return princeCode;
    }

    public void setPrinceCode(int princeCode) {
        this.princeCode = princeCode;
    }
}
