/**
 * JVM2022 class01 获取栈顶方法
 * @author HuanyuLee
 * @date 2022/3/27
 */
public class D {
    static void func_a(){
        int a = 9;
        func_b();
    }
    static void func_b(){
        func_c();
    }
    static void func_c(){
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
        }
//        System.out.println(stackTrace[0].getMethodName());
        /*throw new RuntimeException();   // 流氓写法，不建议*/
    }

    public static void main(String[] args) {
        func_a();
    }
}
