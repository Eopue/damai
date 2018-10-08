package cn.com.method;

import org.springframework.http.HttpMethod;

/**
 * The type MethodFactory.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class MethodFactory {
    private static MethodFactory methodFactory = new MethodFactory();

    public static MethodFactory methodFactory() {
        return methodFactory;
    }

    public Method method(HttpMethod type) {
        if (HttpMethod.GET.equals(type)) {
            return new GetMethod();
        } else if (HttpMethod.POST.equals(type)) {
            return new PostMethod();
        }

        return null;
    }
}
