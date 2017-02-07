/*
 *策略模式定义
 *定义了算法族，分别封装起来，让它们可以之间可以相互替换，此模式让算法的变化独立于使用算法的客户
 */
//飞行行为接口
public interface FlyBehavior{
	public void fly();
}

public class FlyMethodA implements FlyBehavior{
	public void fly(){
		System.out.println("飞行方法A");
	}
}

public class FlyMethodB implements FlyBehavior{
	public void fly(){
		System.out.println("飞行方法B");
	}
}

//叫行为接口
public interface QuackBehavior{
	public void quack();
}

public class QuackMethodA implements QuackBehavior{
	public void quack(){
		System.out.println("叫方法A");
	}
}

public class QuackMethodB implements QuackBehavior {
	public void quack(){
		System.out.println("叫方法B");
	}
}


//鸭子类
public abstract Duck{
	FlyBehavior fb;
	QuackBehavior qb;

	public Duck(){}

	//每个鸭子的外貌不同，所以是抽象方法
	public abstract void display();

	public void performFly(){
		fb.fly();
	}

	public void performQuack(){
		qb.fly();
	}

	//所有鸭子都会游泳
	public void swim(){
		System.out.println("鸭子在游泳");
	}

	public void setFlyBehavior(FlyBehavior f){
		fb = f;
	}

	public void setQuackBehavior(QuackBehavior q){
		qb = q;
	}

}

//鸭子类-绿头鸭子
public class MallardDuck extends Duck{
	//在构造方法中指定飞行方法和叫方法
	public MallardDuck(){
		fb = new FlyMethodA();
		qb = new QuackMethodB();
	}

	public void display(){
		 System.out.println("我是一只绿头鸭子");
	}
}


//运行测试
public class Test{
	public static void main(String[] args){
		Duck duck = new MallardDuck();
		duck.performFly(); //输出：飞行方法A
		duck.performQuack(); //输出：叫方法B

		duck.setFlyBehavior(new FlyMethodB());
		duck.performFly(); //输出：飞行方法B

		duck.setQuackBehavior(new QuackMethodA());
		duck.performQuack(); //输出：叫方法A
	}
}












