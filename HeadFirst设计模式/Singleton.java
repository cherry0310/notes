/*
 *单件模式
 *一个类只有一个实例变量，并提供全局的访问点
 */
 public class Singleton{
     private static singleton;

     public static Singleton getInstance(){
         if(singleton == null){
             singleton = new Singleton();
         }
         return singleton;
     }
 }

 //运行测试
 public class Test{
     public static void main(String[] args) {
         Singleton s = Singleton.getInstance();
     }
 }
