/*
 *外观模式
 *提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用
 *外观类拥有子系统多个类的引用，按顺序调用这些类的方法实现一个功能
 *适配器的思想和外观相似，但是意图不同，前者目的是将一个接口转换成另一个接口；后者目的是简化接口
 *一个子系统可以创建多个外观
 */
 public class HomeTheaterFacade{
     Amplifier amp;
     Tuner tuner;
     DvdPlayer dvd;
     CdPlayer cd;
     Projector projector;
     TheaterLights lights;
     Screen screen;
     PopcornPopper popper;

     public HomeTheaterFacade(Amplifier amp,Tuner tuner,DvdPlayer dvd,CdPlayer cd,Projector projector,TheaterLights lights,Screen screen,PopcornPopper popper){
         this.amp = amp;
         this.tuner = tuner;
         this.dvd = dvd;
         this.cd = cd;
         this.projector = projector;
         this.lights = lights;
         this.screen = screen;
         this.popper = popper;
     }

     public void watchMovie(String movie){
         System.out.println("Get ready to watch a movie");
         popper.on();
         popper.pop();
         lights.dim(10);
         screen.down();
         projector.on();
         projector.wideScreenMode();
         amp.on();
         amp.setDvd(dvd);
         amp.setSurroundSound();
         amp.setVolume(5);
         dvd.on();
         dvd.play(movie);
     }

     public void endMovie(){
         System.out.println("Movie is end");
         popper.off();
         lights.on();
         screen.up();
         projector.off();
         amp.off();
         dvd.stop();
         dvd.eject();
         dvd.off();
     }
 }

//运行测试
public class Test{
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, lights, screen, popper);
        homeTheater.watchMovie("Leon and me");
        homeTheater.endMovie();
    }
}
