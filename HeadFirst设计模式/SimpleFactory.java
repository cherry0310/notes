/*
 *简单工厂
 *简单工厂不是一个模式，算是一种编程习惯
 */

 //客户端，负责处理顾客的披萨订单
 public class PizzaStore{
     SimplePizzaFactory simplePizzaFactory;

     public PizzaStore(SimplePizzaFactory spf){
         this.simplePizzaFactory = spf;
     }

     public Pizza orderPizza(String type){
         Pizza pizza = simplePizzaFactory.createPizza(type);
         pizza.prepare();
         pizza.bake();
         pizza.cut();
         pizza.box();
         return pizza;
     }
 }

 //披萨工厂，职责是创建披萨
 public class SimplePizzaFactory{
     public Pizza createPizza(String type){
         Pizza pizza = null;
         if(type.equals('cheese')){
             pizza = new CheesePizza();
         }else if(type.equals('onion')){
             pizza = new OnionPizza();
         }else if(type.equals('clam')){
             pizza = new ClamPizza();
         }
         return pizza;
     }
 }

//披萨抽象类
public abstract class Pizza{
    //做披萨的四道工序
    public void prepare();
    public void bake();
    public void cut();
    public void box();
}

//披萨1号-Cheese Pizza
public class CheesePizza extends Pizza{
    public void prepare(){
        //具体实现
    }
    public void bake(){
        //具体实现
    }
    public void cut(){
        //具体实现
    }
    public void box(){
        //具体实现
    }
}

//披萨2号-Onion Pizza
public class OnionPizza extends Pizza{
    public void prepare(){
        //具体实现
    }
    public void bake(){
        //具体实现
    }
    public void cut(){
        //具体实现
    }
    public void box(){
        //具体实现
    }
}

//披萨3号-ClamPizza
public class ClamPizza extends Pizza{
    public void prepare(){
        //具体实现
    }
    public void bake(){
        //具体实现
    }
    public void cut(){
        //具体实现
    }
    public void box(){
        //具体实现
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = store.orderPizza("cheese");//pizza就是经过四道工序之后的cheese披萨
    }
}
