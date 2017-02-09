/*
 *观察者模式定义
 *定义了对象之间的一对多依赖，这样一来，当一个对象的状态改变时，它的所有依赖者都会收到通知并自动更新（发布-订阅）
 *subject维护了一个observer的数组，拥有注册、注销、通知观察者的方法,通知就是遍历数组、调用每个observer的update方法
 *每一个observer在构造方法中实现subject的绑定
 *每一个observer都各自实现了一个update的方法
 */
//主题接口
public interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

//气象站类实现主题接口
public class WeatherData implements Subject{
    //主题维护的状态，此处是温度湿度气压数据
    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList observers;

    public WeatherData(){
        observers = new ArrayList();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int index = observers.indexOf(o);
        if(index >= 0){
            observers.remove(index);
        }
    }

    public void notifyObservers(){
        for(int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float t, float h, float p){
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        notifyObservers();
    }
}

//观察者接口
public interface Observer{
    public void update(float t, float h, float p);
}
//观察者1号--当前状况布告板
public class CurrentConditionDisplay implements Observer{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject wd){
        this.weatherData = wd;
        wd.registerObserver(this);
    }

    public void update(float t, float h, float p){
        this.temperature = t;
        this.humidity = h;
        display();
    }

    public void display(){
        System.out.println("当前天气状况是：温度：" + temperature + ";湿度：" + humidity);
    }
}
//观察者2号--天气预报布告板
public class ForecastDisplay{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(WeatherData wd){
        this.weatherData = wd;
        wd.registerObserver(this);
    }

    public void update(float t, float h, float p){
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        display();
    }

    public void display(){
        System.out.println("预测明日的状况是：温度：" + (temperature+1) + ";湿度：" + (humidity+1) + ";气压：" + (pressure+1));
    }

}

//运行测试
public class Test{
    public static void main(String[] args) {
        WeatherData weatherData =new WeatherData();
        CurrentConditionDisplay ccd = new CurrentConditionDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(16, 30, 29); // 当前天气状况是：温度：16；湿度：30
                                                 // 预测明日的状况是：温度：17；湿度31；气压：30
    }
}
