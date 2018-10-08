package cn.com;

import cn.com.pojo.Constants;

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

    public Method method(String type) {
        if (Constants.HTTP_METHOD.GET.equalsIgnoreCase(type)) {
            return new GetMethod();
        } else if (Constants.HTTP_METHOD.POST.equalsIgnoreCase(type)) {
            return new PostMethod();
        }

        return null;
    }
}
