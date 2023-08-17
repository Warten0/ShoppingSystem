package ShoppingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class ShopSystem {
    private static List<User> users;
    private static List<Product> products;
    private static List<ShoppingCartItem> shoppingCart;

    public static void addProduct(Product product) {
        System.out.println("商品已添加到商品库！");
        products.add(product);
    }

    public  static  void addUser(User user){
        System.out.println("新用户已添加！");
        users.add(user);
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void removeProduct(ShoppingCartItem product) {

        shoppingCart.remove(product);
    }

    public static void displayProducts() {   //显示购物车中的商品
        if (shoppingCart.isEmpty()) {
            System.out.println("购物车为空！");
        } else {
            ShoppingCartItem item0 = null;
            System.out.println("购物车中的商品：");
            for (ShoppingCartItem item : shoppingCart){
                if (item.getQuantity() == 0){
                    item0 = item;
                }
            }
            if (item0 != null){
                shoppingCart.remove(item0);
            }
            for (ShoppingCartItem item1 : shoppingCart){
                System.out.println("商品序号："+item1.getID()+" 名称："+item1.getProName()+" 价格："+item1.getRetailPrice()+"¥ 数量："+item1.getQuantity());
            }
        }
    }

    public ShopSystem() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        shoppingCart = new ArrayList<>();
        initializeUsers();
        initializeProducts();

    }

    public void initializeUsers() {
        // 初始化用户数据库，添加已有用户和管理员账户
        User user1 = new User(1, "user1", "@password1", "2022-01-01", "金牌客户", 4698, "1234567890", "user1@example.com");
        User user2 = new User(2, "user2", "@password2", "2022-07-02", "银牌客户", 3547, "0987654321", "user2@example.com");
        User user3 = new User(3, "user3", "@password3", "2022-04-06", "铜牌客户", 1476, "2014563789", "user3@example.com");
        User admin = new User(4, "admin", "@admin123",  "2022-01-01", "管理员", 9999, "9876543210", "admin@example.com");
        admin.setIsAdmin(true);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(admin);
    }

    public void initializeProducts() {
        // 初始化商品数据库，添加ABCDF商品
        Product productA = new Product(1, "A", "Manufacturer A", "2022-01-01", "Model A", 10.0, 20.0, 10);
        Product productB = new Product(2, "B", "Manufacturer B", "2022-01-01", "Model B", 15.0, 25.0, 20);
        Product productC = new Product(3, "C", "Manufacturer C", "2022-01-01", "Model C", 20.0, 30.0, 15);
        Product productD = new Product(4, "D", "Manufacturer D", "2022-01-01", "Model D", 25.0, 35.0, 5);
        Product productF = new Product(5, "F", "Manufacturer F", "2022-01-01", "Model F", 30.0, 40.0, 30);
        products.add(productA);
        products.add(productB);
        products.add(productC);
        products.add(productD);
        products.add(productF);
    }

    public static boolean validateUsername(String username) {
        // 检验用户名是否至少五位
        return username.length() >= 5;
    }

    public static boolean validatePassword(String password) {
        // 检验密码是否至少八位
        if (password.length() < 8) {
            return false;
        }
        // 检验密码是否由数字、字母、标点符号组成
        String pattern = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()_+=\\-{}\\[\\]:\";'<>?,./]).*$";
        return password.matches(pattern);
    }

    public int login() {
        //登录和注册
        Scanner scanner = new Scanner(System.in);
        System.out.println("是否已有账户（是：1 否：0）：");
        int begin = scanner.nextInt();
        scanner.nextLine();

        if(begin == 1){
            int attempts = 0;
            boolean loggedIn = false;

            while (attempts < 5 && !loggedIn) {
                String username;
                do {
                    System.out.println("请输入用户名（至少五位）：");
                    username = scanner.nextLine();
                } while (!validateUsername(username));
                String password;
                do {
                    System.out.println("请输入密码（至少八位，由数字、字母和标点符号组成）：");
                    password = scanner.nextLine();
                } while (!validatePassword(password));
                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)&&validateUsername(username)&&validatePassword(password)) {
                        System.out.println("登录成功！");
                        //loggedIn = true;
                        return 1;
                    }
                }
                if (!loggedIn) {
                    attempts++;
                    System.out.println("登录失败，请重新输入!");
                }
            }

            if (!loggedIn) {
                System.out.println("登录失败次数过多! ");
                System.out.println("是否需要找回密码(是：1   否：0):");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1)
                {
                    System.out.println("请输入你的用户名：");
                    String name = scanner.nextLine();
                    String password0;
                    do {
                        System.out.println("请输入新密码（至少八位，由数字、字母和标点符号组成）：");
                        password0 = scanner.nextLine();
                    } while (!validatePassword(password0));
                    for (User user : users) {
                        if (user.getUsername().equals(name)){
                            user.setPassword(password0);
                            System.out.println("密码修改成功！请重新登录！");
                        }
                    }
                    login();
                }
                else
                    return 0;
            }
            return 1;
        }

        if(begin == 0){
            System.out.println("现在开始注册你的账户！");
            int id = users.size()+1;
            String name;
            do {
                System.out.println("请输入用户名（至少五位）：");

                name = scanner.nextLine();
            } while (!validateUsername(name));

            String password;
            do {
                System.out.println("请输入密码（至少八位，由数字、字母和标点符号组成）：");
                password = scanner.nextLine();
            } while (!validatePassword(password));
            System.out.println("请输入你的注册时间，格式为：年-月-日！");
            String time = scanner.nextLine();
            System.out.println("请输入你的消费金额：");
            String level;
            double money = scanner.nextDouble();
            if (money<=2000){
                level = "铜牌客户";
            }else if (money<=4000){
                level = "银牌客户";
            }
            else {
                level = "金牌客户";
            }
            scanner.nextLine();
            System.out.println("请输入你的手机号：");
            String phone = scanner.nextLine();
            System.out.println("请输入你的邮箱：");
            String mail = scanner.nextLine();
            User user0 = new User(id,name,password,time,level,money,phone,mail);
            users.add(user0);
            System.out.println("注册成功！");
            return 1;
        }
        else
            return 0;
    }

    public void addNewUser(){
        Scanner scanner = new Scanner(System.in);
        int id = users.size()+1;
        String name;
        do {
            System.out.println("请输入用户名（至少五位）：");

            name = scanner.nextLine();
        } while (!validateUsername(name));

        String password;
        do {
            System.out.println("请输入密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));
        System.out.println("请输入你的注册时间，格式为：年-月-日！");
        String time = scanner.nextLine();
        System.out.println("请输入你的消费金额：");
        String level;
        double money = scanner.nextDouble();
        if (money<=2000){
            level = "铜牌客户";
        }else if (money<=4000){
            level = "银牌客户";
        }
        else {
            level = "金牌客户";
        }
        scanner.nextLine();
        System.out.println("请输入你的手机号：");
        String phone = scanner.nextLine();
        System.out.println("请输入你的邮箱：");
        String mail = scanner.nextLine();
        User user0 = new User(id,name,password,time,level,money,phone,mail);
        addUser(user0);
        scanner.close();
    }

    public void addNewProduct(){
        //增加新商品

        Scanner scanner = new Scanner(System.in);
        int id  = products.size()+1;
        System.out.println("请输入商品名称：");
        String productName = scanner.nextLine();
        System.out.println("请输入商品进价：");
        double puprice = scanner.nextDouble();
        System.out.println("请输入商品售价：");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("请输入商品厂家：");
        String manufacturer = scanner.nextLine();
        System.out.println("请输入商品生产日期：");
        String data = scanner.nextLine();
        System.out.println("请输入商品型号：");
        String model = scanner.nextLine();
        System.out.println("请输入商品数量：");
        int amount = scanner.nextInt();
        Product customProduct = new Product(id,productName,manufacturer,data,model,puprice,productPrice,amount);
        addProduct(customProduct);
    }

    public void addToCart() {
        //添加商品到购物车
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要添加到购物车的商品的序号：");
        for (Product product : products) {
            System.out.println("序号："+product.getId() + " 名称：" + product.getName()+" 价格："+product.getRetailPrice() + "¥");
        }
        int productId = scanner.nextInt();
        System.out.println("请输入要添加的数量：");
        int quantity = scanner.nextInt();

        for (Product product : products) {
            if (product.getId() == productId) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    int proId = product.getId();
                    String proName = product.getName();
                    ShoppingCartItem item = new ShoppingCartItem(proId,proName,quantity,product.getRetailPrice());
                    shoppingCart.add(item);
                    System.out.println("添加成功！");
                } else {
                    System.out.println("库存不足，添加失败！");
                }
                break;
            }
        }
    }

    public static void minusToCart(){
        //从购物车中移除商品
        Scanner scanner = new Scanner(System.in);
        displayProducts();
        System.out.println("请选择需要从购物车中移除的商品序号：");
        int id = scanner.nextInt();
        System.out.println("请选择需要移除的数量（<=购物车中的数量）：");
        int quantity = scanner.nextInt();
        for (ShoppingCartItem item : shoppingCart){
            if(item.getID()==id){
                if (item.getQuantity()>=quantity){   //确保移除的数量小于购物车中的数量
                    item.setQuantity(item.getQuantity()-quantity);
                    for (Product product : products){
                        if (product.getId() == id){   //原商品的库存得加上移除的数量
                            product.setQuantity(quantity+product.getQuantity());
                        }
                    }
                }
                else{
                    System.out.println("移除数量错误！");
                }
            }
        }
        displayProducts();
    }

    public static void removeProductFromCart(ShoppingCartItem product) {
        ShopSystem.removeProduct(product);
        System.out.println("该商品已从购物车移除！");
    }

    public void history(){
        // 购物车历史
        System.out.println("购物历史如下：");
        for (ShoppingCartItem history : shoppingCart){
            System.out.println("商品序号："+history.getID()+" 名称："+history.getProName()+" 价格："+history.getRetailPrice()+"¥ 数量："+history.getQuantity());
        }
        shoppingCart.clear();
    }

    public void clear(){
        shoppingCart.clear();
    }

    public void checkout() {
        // 模拟支付过程，此处省略实现细节

        double totalCost = 0.0;
        for (ShoppingCartItem item : shoppingCart) {
            totalCost += item.getRetailPrice() * item.getQuantity();
        }
        System.out.println("总计金额：" + totalCost);
        System.out.println("请选择支付方式：");
        System.out.println("1. 微信支付");
        System.out.println("2. 支付宝支付");
        System.out.println("3. 银行卡支付");
        int paymentMethod = new Scanner(System.in).nextInt();

        switch (paymentMethod) {
            case 1:
                System.out.println("使用微信支付成功！");
                break;
            case 2:
                System.out.println("使用支付宝支付成功！");
                break;
            case 3:
                System.out.println("使用银行卡支付成功！");
                break;
            default:
                System.out.println("支付方式选择错误！");
                break;
        }
        //shoppingCart.clear();
    }

    public void UserImagination(){
        //输出用户信息
        if(users.isEmpty()){
            System.out.println("用户信息为空！");
        }
        else {
            System.out.println("所有的用户信息如下：");
            System.out.println("用户ID   用户名称       注册时间         用户等级       消费金额        手机号          邮箱  ");
            System.out.println("----|-----------|---------------|-------------|------------|--------------|-------------");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                System.out.println((new StringBuilder()).append(user.getId())
                        .append("\t\t").append(user.getUsername()).append("\t\t")
                        .append(user.getRegistrationTime())
                        .append("\t\t").append(user.getUserLevel()).append("\t\t")
                        .append(user.getTotalExpense()).append("\t\t").append(user.getPhoneNumber())
                        .append("\t\t").append(user.getEmail()).toString());
            }
        }
    }

    public void productImagination(){
        //输出商品信息
        if (products.isEmpty()){
            System.out.println("商品信息为空！");
        }
        else{
            System.out.println("所有的商品信息如下：");
            System.out.println("商品ID  商品名称       厂家           生产日期           型号         进价        售价         数量   ");
            System.out.println("------|-------|-----------------|---------------|------------|-----------|----------|-----------");
            for (int i = 0; i<products.size();i++){
                Product product = products.get(i);
                System.out.println((new StringBuilder()).append(product.getId())
                        .append("\t\t").append(product.getName()).append("\t\t")
                        .append(product.getManufacturer()).append("\t\t").append(product.getProductionDate())
                        .append("\t\t").append(product.getModel()).append("\t\t")
                        .append(product.getPurchasePrice()).append("\t\t").append(product.getRetailPrice())
                        .append("\t\t").append(product.getQuantity()).toString());
            }
        }
    }

    public void addUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("添加新的商品需要登录管理员账户！");
        System.out.println("请登录管理员账户：");
        String username;
        do {
            System.out.println("请输入管理员账户用户名（至少五位）：");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        String password;
        do {
            System.out.println("请输入管理员账户密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));
        for (User admin : users ){
            if (admin.getUsername().equals("admin") && admin.getPassword().equals(password)){
                addNewUser();
                break;
            }
        }
    }

    public void changeProduct(){
        // 增加新商品
        Scanner scanner = new Scanner(System.in);
        System.out.println("添加新的商品需要登录管理员账户！");
        System.out.println("请登录管理员账户：");
        String username;
        do {
            System.out.println("请输入管理员账户用户名（至少五位）：");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        String password;
        do {
            System.out.println("请输入管理员账户密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));

        for (User admin : users){
            if (admin.getUsername().equals("admin") && admin.getPassword().equals(password)){
                addNewProduct();
            }
        }

    }

    public void deleteProduct(){
        //删除商品
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录管理员账户：");
        String username;
        do {
            System.out.println("请输入管理员账户用户名（至少五位）：");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        String password;
        do {
            System.out.println("请输入管理员账户密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));

        for (User admin : users){
            if (admin.getUsername().equals("admin") && admin.getPassword().equals(password)){
                productImagination();
                System.out.println("请输入需要删除的商品的ID：");
                int id = scanner.nextInt();
                Product pro1 = null;
                for (Product pro : products){
                    if (pro.getId() == id){
                        pro1 = pro;
                        break;
                    }
                }
                if (pro1 != null){
                    products.remove(pro1);
                    System.out.println("该商品已删除！");
                } else {
                    System.out.println("未找到商品！");
                }
            }
        }

    }

    public void  editProduct(){
        //更改商品信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录管理员账户：");
        String username;
        do {
            System.out.println("请输入管理员账户用户名（至少五位）：");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        String password;
        do {
            System.out.println("请输入管理员账户密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));

        for(User admin : users ){
            if (admin.getUsername().equals("admin") && admin.getPassword().equals(password)){
                System.out.println("请输入需要修改的商品序号：");
                int id = scanner.nextInt();
                for (int i = 0;i < products.size();i++){
                    Product product = products.get(i);
                    if (product.getId() == id){
                        System.out.println("该商品所有信息如下：");
                        System.out.println("商品ID：" + product.getId());
                        System.out.println("商品名称：" + product.getName());
                        System.out.println("商品厂家：" + product.getManufacturer());
                        System.out.println("商品生产日期：" + product.getProductionDate());
                        System.out.println("商品型号：" + product.getModel());
                        System.out.println("商品进价：" + product.getPurchasePrice());
                        System.out.println("商品售价：" + product.getRetailPrice());
                        System.out.println("商品数量：" + product.getQuantity());
                        System.out.println("请输入需要修改的信息：1.商品ID  2.商品名称  3.商品厂家  4.生产日期  5.商品型号  6.进价  7.售价  8.数量  0.退出");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice){
                            case 1:
                                System.out.println("请输入修改后的商品ID:");
                                int ids = scanner.nextInt();
                                product.setId(ids);
                                break;
                            case 2:
                                System.out.println("请输入修改后的商品名称:");
                                String names = scanner.nextLine();
                                product.setName(names);
                                break;
                            case 3:
                                System.out.println("请输入修改后的商品厂家:");
                                String manufacturers = scanner.nextLine();
                                product.setManufacturer(manufacturers);
                                break;
                            case 4:
                                System.out.println("请输入修改后的生产日期:");
                                String time = scanner.nextLine();
                                product.setProductionDate(time);
                                break;
                            case 5:
                                System.out.println("请输入修改后的商品型号:");
                                String model = scanner.nextLine();
                                product.setModel(model);
                                break;
                            case 6:
                                System.out.println("请输入修改后的商品进价:");
                                double price0 = scanner.nextInt();
                                product.setPurchasePrice(price0);
                                break;
                            case 7:
                                System.out.println("请输入修改后的商品售价:");
                                double price1 = scanner.nextInt();
                                product.setRetailPrice(price1);
                                break;
                            case 8:
                                System.out.println("请输入修改后的商品数量:");
                                int amount = scanner.nextInt();
                                product.setQuantity(amount);
                                break;
                            case 0:
                                break;
                        }
                        System.out.println("商品信息修改成功！");
                    }
                }

            }

            }
    }

    public void changeUser(){
        //更改用户信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录管理员账户：");
        String username;
        do {
            System.out.println("请输入管理员账户用户名（至少五位）：");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        String password;
        do {
            System.out.println("请输入管理员账户密码（至少八位，由数字、字母和标点符号组成）：");
            password = scanner.nextLine();
        } while (!validatePassword(password));

        for (User admin : users){
            if (admin.getUsername().equals("admin") && admin.getPassword().equals(password)){
                System.out.println("请输入需要修改的用户ID:");
                int id = scanner.nextInt();
                for (int i = 0; i < users.size(); i++) {
                    User use = users.get(i);
                    if (use.getId() == id) {
                        System.out.println("该用户的所有信息如下：");
                        System.out.println("ID：" + use.getId());
                        System.out.println("用户名：" + use.getUsername());
                        //System.out.println("密码："+use.getPassword());
                        System.out.println("注册时间：" + use.getRegistrationTime());
                        System.out.println("用户等级：" + use.getUserLevel());
                        System.out.println("消费金额：" + use.getTotalExpense());
                        System.out.println("用户手机号：" + use.getPhoneNumber());
                        System.out.println("用户邮箱：" + use.getEmail());
                        System.out.println("请选择你的操作：1.修改用户信息  2.删除用户  0.退出");
                        int choose = scanner.nextInt();
                        if (choose == 1){
                            System.out.println("是否重置该用户密码（是：1 否：0）：");
                            int ver = scanner.nextInt();
                            if (ver == 1) {
                                use.setPassword("@password0");
                                System.out.println("密码已重置！");
                                System.out.println("重置后的新密码为:@password0");
                                break;
                            }
                        }
                        if (choose == 2){
                            System.out.println("是否确定删除该用户（是：1  否：0）：");
                            int delete = scanner.nextInt();
                            if (delete == 1){
                                User use0 = null;
                                for (User use1 : users ){
                                    if (use1.getUsername().equals(use.getUsername())){
                                        use0 = use1;
                                        break;
                                    }
                                }

                                if (use0 != null){
                                    users.remove(use0);
                                    System.out.println("该用户已删除！");
                                }
                                else {
                                    System.out.println("未找到该用户！");
                                }
                                break;
                            }
                            if (delete == 0)
                                break;
                        }
                        if (choose == 0)
                            break;
                    }

                }
            }
        }

    }

    public void changePassword(){
        //修改密码
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.println("请输入你的用户名(至少五位）：");
            name = scanner.nextLine();
        }while (!validateUsername(name));
        for (User user : users ){
            if (user.getUsername().equals(name)){
                String newPassword;
                do {
                    System.out.println("请输入您的新密码（由至少八位的数字、字母和符号组成）：");
                    newPassword = scanner.nextLine();
                }while (!validatePassword(newPassword));
                user.setPassword(newPassword);
                System.out.println("您的密码已修改成功！");
            }
        }
    }

    public void inquire(){
        //查找用户
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的用户ID:");
        int id = scanner.nextInt();
        for (User use : users){
            if(use.getId()==id){
                System.out.println("该用户的所有信息如下：");
                System.out.println("ID："+use.getId());
                System.out.println("用户名："+use.getUsername());
                //System.out.println("密码："+use.getPassword());
                System.out.println("注册时间："+use.getRegistrationTime());
                System.out.println("用户等级："+use.getUserLevel());
                System.out.println("消费金额："+use.getTotalExpense());
                System.out.println("用户手机号："+use.getPhoneNumber());
                System.out.println("用户邮箱："+use.getEmail());
            }
        }
    }
}
