package com.iscas.r1.utils;

import java.io.*;

/**
 * @Author: zhuquanwen
 * @Description:
 * @Date: 2018/4/26 14:50
 * @Modified:
 **/
public class SerializableUtil {
    /**
     * 对象转数组
     *
     * @param obj
     * @return
     */
    public static byte[] serializable(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     *
     * @param bytes
     * @return
     */
    public static Object unserializable(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }



}

