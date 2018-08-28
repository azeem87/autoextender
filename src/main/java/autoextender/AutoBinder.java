package autoextender;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Sergii Karpenko
 */
public class AutoBinder<A> {

    private Class<A> type;

    private AutoBinder(Class<A> type){
        this.type = type;
    }

    public static <A> AutoBinder<A> extend(Class<A> type){
        return new AutoBinder<>(type);
    }

    @SuppressWarnings("unchecked")
    public <T> T to(Class<T> interfaceClass){
        return (T)toAll(interfaceClass);
    }

    @SuppressWarnings("unchecked")
    public A toAll(Class... interfaces){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(type);
        enhancer.setInterfaces(interfaces);

        enhancer.setCallback(new ThrowingInterceptor());

        return (A)enhancer.create();
    }

}
