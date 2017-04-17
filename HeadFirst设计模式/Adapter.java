/*
 *适配器模式
 *将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
 *Adapter实现Target接口，并持有Adaptee的引用
 */
//鸭子
public  interface Duck{
    public void quack();
    public void fly();
}
public class MallardDuck implements Duck{
    public void quack(){
        System.out.println("Quack");
    }
    public void fly(){
        System.out.println("I'm flying");
    }
}
//火鸡
public interface Turkey{
    public void gobble();
    public void fly();
}
public class WildTurkey implements Turkey{
    public void gobble(){
        System.out.println("Gobble.");
    }
    public void fly(){
        System.out.println("I'm flying a short distance");
    }
}

//让火鸡冒充鸭子
public class TurkeyAdapter implements Duck{
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }
    public void fly(){
        for(int i=0;i<5;i++){
            turkey.fly();
        }
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();
        Turkey turkey = new WildTurkey();
        turkey.gobble();
        turkey.fly();
        Duck ta = new TurkeyAdapter(turkey);
        ta.quack();
        ta.fly();
    }
}
