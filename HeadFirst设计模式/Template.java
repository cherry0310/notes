/*
 *模板方法模式
 *在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 *超类中定义一个算法的实现步骤
 *子类可以覆盖其中某些步骤的实现
 */

//抽象超类，内含有不可覆盖的模板方法，以及由子类实现的模板方法的子步骤
public abstract class CaffeineBeverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        addCondiments();
        pourInCup();
    }
    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring in cup");
    }
}
//子类1
public class Tea extends CaffeineBeverage{
    public void brew(){
        System.out.println("Steeping tea");
    }
    public void addCondiments(){
        System.out.println("Adding lemon");
    }
}
//子类2
public class Coffee extends CaffeineBeverage{
    public void brew(){
        System.out.println("Steeping cofee");
    }
    public void addCondiments(){
        System.out.println("Adding milk and sugar");
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
