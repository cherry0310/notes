/*
 *迭代器模式
 *提供一种方法顺序访问集合中的各个元素，而又不暴露其内部实现
 *interface Iterator(hasNext() next())
 *concrete Iterator
 *interface Aggregate(createIterator())
 *concrete Aggregate(持有对象集合，实现createIterator)
 *Client拥有Aggregate对象
 */
 //菜单项
public class MenuItem{
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
}

//菜单接口
public interface Menu{
    public Iterator createIterator();
}

//煎饼屋菜单
public class PancakeHouseMenu implements Menu{
    ArrayList menuItems;
    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("lemon cake","made by lemon",12.5);
        addItem("banana cake","made by banana",10.5);
        addItem("apple cake","made by apple",6);
    }
    void addItem(String name,String description,double price){
        MenuItem item = new MenuItem(name,description,price);
        menuItems.add(item);
    }

    public Iterator createIterator(){
        return new PancakeHouseMenuIterator(menuItems);
    }
}

//午餐餐厅菜单
public class DinerMenu implements Menu{
    final int MENU_LENGTH = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = MenuItem[MENU_LENGTH];
        addItem("meat","made by meat",24.5);
        addItem("fish","made by fish",16);
        addItem("vegetable","made by vegetable",8);
    }

    void addItem(String name,String description,double price){
        MenuItem item = new MenuItem(name,description,price);
        if(numberOfItems >= MENU_LENGTH || menuItems[numberOfItems] == null){
            throw Error;
        }else{
            menuItems[numberOfItems] = item;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}

//迭代器接口
public interface Iterator{
    public boolean hasNext();
    public Object next();
}

//煎饼屋菜单迭代器
public class PancakeHouseMenuIterator{
    ArrayList menuItems;
    int index = 0;

    public PancakeHouseMenuIterator(ArrayList menuItems){
        this.menuItems = menuItems;
    }

    public boolean hasNext(){
        if(menuItems.get(index) == null){
            return false;
        }else{
            return true;
        }
    }

    public Object next(){
        MenuItem item = menuItems.get(i);
        index++;
        return item;
    }
}

//午餐餐厅菜单迭代器
public class DinerMenuIterator{
    MenuItem[] menuItems;
    int index = 0;

    public DinerMenuIterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
    }

    public boolean hasNext(){
        if(menuItems[index] == null || index >= menuItems.length){
            return false;
        }else{
            return true;
        }
    }

    public Object next(){
        MenuItem item = menuItems[index];
        index++;
        return item;
    }
}

//女服务员
public class Waitress{
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu,Menu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    };

    public void printMenu(){
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        System.out.println("Start printing pancakeHouseMenu...");
        printMenu(pancakeIterator);
        System.out.println("Start printing dinerMenu...");
        printMenu(dinerIterator);
    }

    public void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem item = (MenuItem)iterator.next();
            System.out.println(item.getName() + "," + item.getDescription() + "--" + item.getPrice());
        }
    }
}

//运行测试
public class Test{
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu =new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu);
        waitress.printMenu();
    }
}
