/*
 *命令模式
 *将“请求”封装成对象，以便使用不同的请求、队列或日志来参数化其他对象。命令对象也支持可撤销的操作。
 *一个抽象命令对象-execute方法
 *每个具体命令对象-含有一个执行者的引用，构造方法的参数是执行者实例对象；实现execute方法（执行者调用相应的方法）
 *一个遥控器-含有一个命令的引用，提供setCommand方法来设置要执行的命令
 */
//命令接口
public interface Command{
    public void execute();
}
//具体命令类1-开灯命令
public class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
}
//具体命令类2-车库开门命令
public class GarageDoorOpenCommand implements Command{
    GarageDoor garageDoor;
    public GarageDoor(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    public void execute(){
        garageDoor.up();
    }
}

//遥控器类
public class SimpleRemoteControl{
    Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void buttonWasPressed(){
        command.execute();
    }
}

//灯类和车库门类
public class Light{
    public Light(){}
    public void on(){
        System.out.println("Light is on.");
    }
}
public class GarageDoor{
    public GarageDoor(){}
    public void up(){
        System.out.println("Garage Door is opened.")
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        //创建开灯命令
        Light light = new Light();
        LightOnCommand loc = new LightOnCommand(light);
        //创建开门命令
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand gdoc = new GarageDoorOpenCommand(garageDoor);

        control.setCommand(loc);
        control.buttonWasPressed();//Light is on.

        control.setCommand(gdoc);
        control.buttonWasPressed();//Garage Door is opened.
    }
}
