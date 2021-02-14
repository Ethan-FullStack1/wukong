package finaldemo;

/**
 *
 *
 * @author 多宝
 * @since 2021/2/14 19:23
 */
public class FinalStirngDemo1 {

    public static void main(String[] args) {
        String a = "wukong2";
        final String b = "wukong";
        String d = "wukong";
        String c = b + 2;
        String e = d + 2;
        System.out.println(a == c);
        System.out.println(a == e);
    }

}
