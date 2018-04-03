package autoextender;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Sergii Karpenko
 */
public class AutoExtender<A> {

    private Class<A> abstractClass;

    private AutoExtender (Class<A> abstractClass){
        this.abstractClass = abstractClass;
    }

    public static <A> AutoExtender<A> extend(Class<A> abstractClass){
        return new AutoExtender<>(abstractClass);
    }

    @SuppressWarnings("unchecked")
    public <T> T to(Class<T> interfaceClass){
        return (T)toAll(interfaceClass);
    }

    @SuppressWarnings("unchecked")
    public A toAll(Class... interfaces){

        for(Class interfacce : interfaces){
            if(!interfacce.isAssignableFrom(abstractClass)){
                throw new IllegalArgumentException(String.format("Wrong hierarchy: %s is not assignable from %s",
                        interfacce, abstractClass));
            }
        }

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(abstractClass);
        enhancer.setInterfaces(interfaces);

        enhancer.setCallback(new ThrowingInterceptor());

        return (A)enhancer.create();
    }

}
