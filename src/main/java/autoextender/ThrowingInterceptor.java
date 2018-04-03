package autoextender;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Sergii Karpenko
 */
public class ThrowingInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(!method.getDeclaringClass().isInterface()){
            return methodProxy.invokeSuper(o, objects);
        } else {
            throw new UnsupportedOperationException(String.format("%s (%s)", method, Arrays.toString(objects)));
        }
    }
}
