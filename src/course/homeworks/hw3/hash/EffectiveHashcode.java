package course.homeworks.hw3.hash;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* Класс для генерации хэшкода у любого объекта. Не поддерживает Collections. Алгоритм по Effective Java */
public class EffectiveHashcode {

    public EffectiveHashcode() {
    }

    // Метод для генерации хэшкода для примитивов, String или массивов.
    private int generatePrimitiveHashcode(Object object) {
        int c = 0;
        if (object instanceof Boolean) {
            c = ((boolean) object ? 0 : 1);
        } else if (object instanceof Byte) {
            c = ((Byte) object).intValue();
        } else if (object instanceof Character) {
            c = (Character) object;
        } else if (object instanceof Short) {
            c = ((Short) object).intValue();
        } else if (object instanceof Integer) {
            c = ((Integer) object);
        } else if (object instanceof Long) {
            c = (int) ((long) object ^ ((long) object >>> 32));
        } else if (object instanceof Float) {
            c = Float.floatToIntBits((float) object);
        } else if (object instanceof Double) {
            c = (int) Double.doubleToLongBits((double) object);
        } else if (object instanceof String) {
            c = object.hashCode();
        } else if (object.getClass().isArray()) {
            int len = Array.getLength(object);
            for (int i = 0; i < len; i++) {
                c += generatePrimitiveHashcode(Array.get(object, i));
            }
        }
        return c;
    }

    // Метод для генерации хэшкода для объектов.
    public int getHashcode(Object obj) {
        // Случайное число
        int result = 17;
        // Под хэшкод примитивов
        int c = 0;

        if (obj.getClass().isPrimitive()) {
            // 31 натуральное нечетное число
            result = 31 * result + generatePrimitiveHashcode(obj);
        } else {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (var field : fields) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) instanceof Number || field.get(obj) instanceof Boolean
                            || field.get(obj) instanceof Character || field.getType() == String.class) {
                        c = generatePrimitiveHashcode(field.get(obj));
                    } else {
                        c = getHashcode(field.get(obj));
                    }
                } catch (IllegalAccessException e) {
                    System.err.println(e.getMessage());
                    System.exit(-1);
                }
                result = 31 * result + c;
            }
        }
        return result;
    }
}
