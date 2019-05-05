package com.hengda.hotfix.design_patterns;

import java.util.HashMap;
import java.util.Map;

//单例模式
class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    //double-check,避免并发时创建了多个实例,该方式不能完全避免并发带来的破坏(加上volatile)
    private static Singleton getInstance1() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    //静态内部类,第一次调用getInstance方法会导致虚拟机加载SingletonHolder类,不仅能确保线程安全,也保证单例对象的唯一性,同时也延迟单例的实例化
    private static Singleton getInstance2() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }

    //枚举单例, 线程安全
    private static Singleton1 getInstance3() {
        return Singleton1.INSTANCE;
    }

    enum Singleton1 {
        INSTANCE;

        public void doSomething() {

        }
    }

    //注册到容器, 根据key获取对象.一般都会有多种相同属性类型的对象会注册到一个map中
    private static Map<String, Object> objMap = new HashMap<>();


    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }

    //WindowsManagerService,ActivityManagerService,LayoutInflater
}
