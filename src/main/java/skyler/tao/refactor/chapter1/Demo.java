package skyler.tao.refactor.chapter1;

public class Demo {
    public static void main(String[] args) {
        System.out.println("================");
        Customer customer1 = new Customer("chaoqiang");
        Rental rental1 = new Rental(new Movie("move1", Movie.CHILDRENS), 3);
        customer1.addRental(rental1);

        Rental rental2 = new Rental(new Movie("move2", Movie.NEW_RELEASE), 5);
        customer1.addRental(rental2);

        System.out.println(customer1.statement());
    }
}
