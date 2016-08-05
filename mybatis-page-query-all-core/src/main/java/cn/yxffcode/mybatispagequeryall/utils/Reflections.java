package cn.yxffcode.mybatispagequeryall.utils;

import java.lang.reflect.Field;

/**
 * @author gaohang on 16/7/9.
 */
public final class Reflections {
    private Reflections() {
    }

    public static void setField(Object target, String field, Object value) {
        Field ss = findField(target.getClass(), field);
        ss.setAccessible(true);
        setField(ss, target, value);
    }

    public static void setField(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage()
                    , ex);
        }
    }

    private static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }
    public static Field findField(Class<?> clazz, String name, Class<?> type) {
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if ((name == null || name.equals(field.getName())) && (type == null || type
                        .equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }
}
