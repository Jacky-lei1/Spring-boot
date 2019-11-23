package com.bjsxt.config;


import java.util.Arrays;

/**
 * 自定义key生成策略
 * @author lvyelanshan
 * @create 2019-11-22 19:10
 */
public class CustomKey  {

    private Class clazz;
    private String methodName;
    private Object[] params;
    private int hashCode;

    public CustomKey(Class clazz, String methodName, Object[] params) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.params = params;

        int code = Arrays.deepHashCode(params);
        code = 31 * code + clazz.hashCode();
        code = 31 * code + methodName.hashCode();

        this.hashCode = code;
    }

    public CustomKey() {
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomKey)) {
            return false;
        }
        CustomKey other = (CustomKey) obj;
        if (this.hashCode != other.hashCode) {
            return false;
        }

        return this.clazz.equals(other.clazz) && this.methodName.equals(other.methodName) && Arrays.deepEquals(this.params, other.params);
        }

    @Override
    public String toString() {
        return "CustomKey{" +
                "clazz=" + clazz +
                ", methodName='" + methodName + '\'' +
                ", params=" + Arrays.toString(params) +
                ", hashCode=" + hashCode +
                '}';
    }
}

