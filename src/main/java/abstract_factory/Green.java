package abstract_factory;

/**
 * DateTime 2018-04-22 17:19
 *
 * @author db
 **/
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
