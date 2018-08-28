package autoextender;

import net.sf.cglib.proxy.Enhancer;

/**
 * Allows to auto implement methods in abstract class
 * by throwing {@link UnsupportedOperationException} on not implemented methods
 *
 * @author Sergii Karpenko
 */
public class AutoImplementer {

    public static <A> A implement(Class<A> abstractClass){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(abstractClass);

        enhancer.setCallback(new ThrowingInterceptor());

        return (A)enhancer.create();
    }
}
