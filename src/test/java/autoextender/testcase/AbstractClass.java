package autoextender.testcase;

/**
 * @author Sergii Karpenko
 */
abstract public class AbstractClass implements Interface{

    public static final String VALUE = "Just implementation";

    @Override
    public String implemented(){
        return VALUE;
    }

}
