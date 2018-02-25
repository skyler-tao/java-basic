package skyler.tao.refactor.chapter1.afterrefactor;

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

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPrinceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
                default:
                    throw new IllegalArgumentException("Not support movie type.");
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if (getPrinceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
