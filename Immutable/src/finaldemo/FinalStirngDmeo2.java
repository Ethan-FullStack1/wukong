package finaldemo;

/**
 * @author 多宝
 * @since 2021/2/14 19:54
 */
public class FinalStirngDmeo2 {

    public static void main(String[] args) {
        String a = "wukong2";
        // 这里我们定义的final变量来用方法来获取值
        final String b = getDaShiXiong();
        String c = b + 2;
        System.out.println(a == c);
    }

    private static String getDaShiXiong() {
        return "wukong";
    }

}
