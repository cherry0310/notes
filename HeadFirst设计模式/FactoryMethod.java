/*
 *工厂方法模式
 *定义了一个创建对象的接口，但由子类决定要实例化的是哪一个。工厂方法让类把实例化推迟到子类
 *4个组成部分：抽象创建者、具体创建者（实现创建具体产品的方法）、抽象产品、具体产品
 */
//抽象creator
 public abstract class PizzaStore{
     public Pizza orderPizza(String type){
         Pizza pizza = createPizza(type);
         pizza.prepare();
         pizza.bake();
         pizza.cut();
         pizza.box();
         return pizza;
     }
     //最重要的生产产品的方法
     public abstract Pizza createPizza(String type);
 }
//具体creator-纽约风味的披萨店
 public class NYPizzaStore extends PizzaStore{
     public Pizza createPizza(String type){
         if(type.equals('cheese')){
             return new NYStyleCheesePizza();
         }else if(type.equals('onion')){
             return new NYStyleOnionPizza();
         }else if(type.equals('clam')){
             return new NYStyleClamPizza();
         }
     }
 }
//具体creator-芝加哥风味披萨店
public class ChicagoPizzaStore extends PizzaStore{
    public Pizza createPizza(String type){
        if(type.equals('cheese')){
            return new ChicagoStyleCheesePizza();
        }else if(type.equals('onion')){
            return new ChicagoStyleOnionPizza();
        }else if(type.equals('clam')){
            return new ChicagoStyleClamPizza();
        }
    }
}

//抽象Product 披萨
public abstract class Pizza{
    public String name;//名称
    public String dough;//面团类型
    public String sauce;//酱料类型

    public void prepare(){
        System.out.println("preparing:" + dough + "," + sauce + "...");
    }

    public void bake(){
        System.out.println("baking");
    }

    public void cut(){
        System.out.println("cutting");
    }

    public void box(){
        System.out.println("boxing");
    }

    public String getName(){
        return name;
    }

}
//具体Product-NYStyleCheesePizza
public class NYStyleCheesePizza extends Pizza{
    public  NYStyleCheesePizza(){
        name = "NYStyleCheesePizza";
        dough = "dough1";
        sauce = "sauce1";
    }
    //每个具体披萨类里可以根据实际需要覆盖四道工序对应的方法
}
//具体Product-NYStyleCheesePizza
public class NYStyleOnionPizza extends Pizza{
    public NYStyleOnionPizza(){
        name = "NYStyleOnionPizza";
        dough = "dough2";
        sauce = "sauce2";
    }
}
//其余四个Pizza具体类以此类推
public class NYStyleClamPizza extends Pizza{}
public class ChicagoStyleCheesePizza extends Pizza{}
public class ChicagoStyleOnionPizza extends Pizza{}
public class ChicagoStyleClamPizza extends Pizza{}

//运行测试
public class Test{
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza1 = nyStore.orderPizza("cheese");//打印出纽约芝士披萨的制作过程
        System.out.println(pizza1.getName());//打印出 NYStyleCheesePizza

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza2 = chicagoStore.orderPizza("clam");//打印出芝加哥文蛤披萨的制作过程
        System.out.println(pizza2.getName());//打印出 ChicagoStyleClamPizza

    }
}
