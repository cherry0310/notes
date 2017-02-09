/*
 *装饰者模式定义
 *动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的解决方案
 *被装饰者和装饰者的类型是一样的，它们都继承自同一个抽象类或接口
 *装饰者的构造函数的参数是一个具体的被装饰者实例
 */
//组件类，被装饰者和装饰者都是这个类型
public abstract class Berverage{
    String description = "Unknown kind coffee";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}

//被装饰者类1-HouseBlend咖啡-单价10元
public class HouseBlend extends Berverage{
    public HouseBlend(){
        description = "House Blend Coffee";
    }

    public double cost(){
        return 10;
    }
}
//被装饰者类2-Expresso咖啡-单价15元
public class Expresso extends Berverage{
    public Expresso(){
        description = "Expresso Coffee";
    }

    public double cost(){
        return 15;
    }
}

//装饰者抽象类
public abstract class CondimentDecorator extends Berverage{
    public abstract String getDescription();
}

//装饰者类1-奶泡-单价1元
public class Whip extends CondimentDecorator{
    Berverage berverage;
    public Whip(Berverage b){
        this.berverage = b;
    }

    public String getDescription(){
        return berverage.getDescription() + ",Whip";
    }

    public double cost(){
        return berverage.cost() + 1;
    }
}

//装饰者类2-摩卡-单价2元
public class Mocha extends CondimentDecorator{
    Berverage berverage;
    public Mocha(Berverage b){
        this.berverage = b;
    }
    public String getDescription(){
        return berverage.getDescription() + ",Mocha";
    }
    public double cost(){
        return berverage.cost() + 2;
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        Berverage berverage1 = new HouseBlend();
        System.out.println(berverage1.getDescription() + "," + berverage1.cost() + "元");//House Blend Coffee,10元

        Berverage berverage2 = new Expresso();
        berverage2 = new Whip(berverage2);
        berverage2 = new Mocha(berverage2);
        System.out.println(berverage2.getDescription() + "," + berverage2.cost() + "元");//Expresso Coffee,Whip,Mocha,18元（15+1+2）
    }
}
