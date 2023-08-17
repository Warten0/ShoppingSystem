package ShoppingSystem;

//import jdk.internal.org.objectweb.asm.tree.InsnList;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import static ShoppingSystem.ShopSystem.removeProductFromCart;

class Main {
    public static void main(String[] args) {
        ShopSystem shoppingSystem = new ShopSystem();
        System.out.println("欢迎登录购物系统！");
        int login;
        login = shoppingSystem.login();   //登录

        if (login == 1){
            boolean exit = false;
            while (!exit) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请选择你的操作：");
                System.out.println("1. 显示所有的商品信息");
                System.out.println("2. 显示所有的用户信息");
                System.out.println("3. 查看购物车中的商品");
                System.out.println("4. 添加商品到购物车");
                System.out.println("5. 移除购物车中的商品");
                System.out.println("6. 结算商品并支付");
                System.out.println("7. 修改密码");
                System.out.println("0. 退出");
                int choice = new Scanner(System.in).nextInt();

                switch (choice) {
                    case 1:   //显示商品信息
                        shoppingSystem.productImagination();
                        System.out.println("请选择你的操作:1.添加的新商品  2.删除已有商品  3.修改商品信息   0.退出");
                        int pro = scanner.nextInt();
                        if (pro == 1) {
                            shoppingSystem.changeProduct();
                        }
                        if (pro == 2){
                            shoppingSystem.deleteProduct();
                            break;
                        }
                        if (pro == 3){
                            shoppingSystem.editProduct();
                            break;
                        }
                        if (pro == 0)
                            break;
                        break;
                    case 2:  //显示用户信息
                        shoppingSystem.UserImagination();
                        System.out.println("请选择你的操作:1.修改用户信息  2.查询用户信息  3.添加新用户  0.退出");
                        int message = scanner.nextInt();
                        if (message == 1){
                            shoppingSystem.changeUser();
                        }
                        if (message == 2)
                            shoppingSystem.inquire();
                        if (message == 3){
                            shoppingSystem.addUser();
                        }
                        if (message == 0)
                            break;
                        break;
                    case 3:
                        shoppingSystem.displayProducts();
                        break;
                    case 4:  //添加商品到购物车
                        shoppingSystem.addToCart();
                        break;
                    case 5:   //移除购物车中的商品
                        shoppingSystem.minusToCart();
                        break;
                    case 6:  //结算
                        shoppingSystem.checkout();
                        System.out.println("是否查看购物历史：是：1   否：0");
                        int history = scanner.nextInt();
                        if (history == 1)
                            shoppingSystem.history();
                        if (history == 0)
                            shoppingSystem.clear();
                        break;
                    case 7:  //修改密码
                        shoppingSystem.changePassword();
                        shoppingSystem.login();
                        break;
                    case 0:  //退出
                        exit = true;
                        System.out.println("感谢使用购物系统！");
                        break;
                    default:
                        System.out.println("选择无效，请重新选择！");
                        break;
                }
            }
        }

    }
}