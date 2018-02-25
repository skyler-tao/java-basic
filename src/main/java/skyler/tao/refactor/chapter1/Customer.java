package skyler.tao.refactor.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String getName() {
        return this.name;
    }

    /**
     * 获取该消费者的借书详单
     *
     * @return
     */
    public String statement() {
        // 标记该消费者的所有消费金额
        double totalAmount = 0;
        // 标记该消费者的消费积分
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double thisAmount = 0;
            // TODO 封装成方法，放入 Rental 类中
            switch (rental.getMovie().getPrinceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                default:
                    throw new IllegalArgumentException("Not supported movie type.");
            }

            // TODO 提炼积分计算
            frequentRenterPoints++;
            if (rental.getMovie().getPrinceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points.";
        return result;
    }
}
