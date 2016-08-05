package cn.yxffcode.mybatispagequeryall;

/**
 * @author gaohang on 16/8/5.
 */
public abstract class DaoQueryPageContextHolder {
    private DaoQueryPageContextHolder() {
    }

    private static final ThreadLocal<Paged> pageContext = new ThreadLocal<>();

    public static Paged get() {
        return pageContext.get();
    }

    public static void remove() {
        pageContext.remove();
    }

    public static void set(Paged paged) {
        pageContext.set(paged);
    }
}
