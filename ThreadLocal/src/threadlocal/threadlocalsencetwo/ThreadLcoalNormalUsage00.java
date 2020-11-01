package threadlocal.threadlocalsencetwo;

/**
 * 演示ThreadLcoal的用法二：避免传递参数的麻烦
 *
 * @author 多宝
 * @since 2020/10/25 17:31
 */
public class ThreadLcoalNormalUsage00 {
    public static void main(String[] args) {
        new Service1().process();
    }

}

class Service1 {
    public void process() {
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2          " + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3       " + user.name);
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}


class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}