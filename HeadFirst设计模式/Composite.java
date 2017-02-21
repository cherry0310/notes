/*
 *组合模式
 *允许你将对象组合成树形结构来表现“整体/部分”层次结构。组合能让客户以一致的方式处理个别对以及对象组合。
 *有一个抽象类菜单组件
 *菜单项和菜单都继承菜单组件，覆盖实现其中的方法
 *服务员含有一个总的菜单组件的对象
 */
//菜单组件
 public abstract class MenuComponent{
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
 }
//菜单项
public class MenuItem extends MenuComponent{
    String name;
    String description;
    double price;

    public MenuItem(String name,String description,double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }

    public void print(){
        System.our.println(name + "," + description + "," + price);
    }
}

//菜单
public class Menu extends MenuComponent{
    ArrayList menuComponents = new ArrayList();
    String menuName;
    String menuDescription;

    public Menu(String menuName,String menuDescription){
        this.menuName = menuName;
        this.menuDescription = menuDescription;
    }

    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i){
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName(){
        return menuName;
    }

    public String getDescription(){
        return menuDescription;
    }

    public void print(){
        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent mc = (MenuComponent)iterator.next();
            mc.print();
        }
    }
}

//服务员
public class Waitress{
    MenuComponent allMenus;
    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new MenuComponent("PancakeHouseMenu","breakfast menu");
        MenuComponent dinerMenu = new MenuComponent("DinerMenu","lunch menu");
        MenuComponent dissertMenu = new MenuComponent("DissertMenu","dissert menu belong to diner menu");

        MenuComponent allMenus = new MenuComponent("all menu","overall menu");

        //菜单中添加其他菜单
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);

        dinerMenu.add(dissertMenu);

        //菜单中添加菜单项
        pancakeHouseMenu.add(new MenuItem("pancake1","one kind of pancake",12.5));
        dinerMenu.add(new MenuItem("meat","one kind of meat",24.5));
        dissertMenu.add(new MenuItem("applePie","one kind of dissert",8));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
        //最终结果：一个总菜单包含一份pancakeHouseMenu（含有单品pancake1）和dinerMenu（含有单品meat以及子菜单dissertMenu，子菜单含有单品applePie）
    }
}
