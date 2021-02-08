package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q2SingletonTest {

    private Q2SingletonTest() {
    }

    /**
     * volatile双检查锁
     */
    private static volatile Q2SingletonTest instance = null;
    public static Q2SingletonTest getInstance1(){
        //没有初始化时获取锁
        if (null==instance){
            synchronized (Q2SingletonTest.class){
                //进入锁的线程只能有一个创建
                if (null == instance){
                    instance = new Q2SingletonTest();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类
     */
    private static class holder{
        private static final Q2SingletonTest INSTANCE = new Q2SingletonTest();
    }
    public static Q2SingletonTest getInstance2(){
        return holder.INSTANCE;
    }
}
