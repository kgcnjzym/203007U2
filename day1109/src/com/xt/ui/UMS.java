package com.xt.ui;

import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * UserManageSystem
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:47
 * @since V1.00
 */
public class UMS {
    private static UserService service=new UserServiceImpl();
    private static User current=null;
    private static Scanner sc=null;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        while(true){
            System.out.println("1.注册，2.登陆，0.退出");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    reg();
                    break;
                case 2:
                    login();
                    break;
            }
            if(choice==0){
                break;
            }
        }
        sc.close();
    }

    private static void reg() {
        System.out.println("pls input name:");
        String name=sc.next();
        System.out.println("pls input pass:");
        String pass=sc.next();
        System.out.println("pls input email:");
        String email=sc.next();
        System.out.println("pls input age:");
        int age=sc.nextInt();
        System.out.println("pls input phone:");
        String phone=sc.next();
        System.out.println("pls input gender:");
        String gender=sc.next();
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(pass);
        user.setGender(gender);
        user.setPhone(phone);
        try {
            int ret = service.reg(user);
            if(ret>0){
                System.out.println("reg success!");
            }
            else{
                System.out.println("reg fail!");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    private static void login() {
        System.out.println("pls input name or email or phone:");
        String name=sc.next();
        System.out.println("pls input pass:");
        String pass=sc.next();
        User user=new User();
        user.setName(name);
        user.setPassword(pass);
        User temp=service.login(user);
        if(temp==null){
            System.out.println("login fail!");
        }
        else{
            System.out.println("login ok!");
            current=temp;
        }
        if(current!=null){
            while(true) {
                System.out.println("1.修改密码，2.修改信息，0.返回");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        pass();
                        break;
                    case 2:
                        info();
                        break;
                }
                if(choice==0){
                    current=null;
                    return;
                }
            }
        }
    }
    private static void pass() {
        System.out.println("pls input old pass:");
        String oldpass=sc.next();
        System.out.println("pls input new pass:");
        String newpass1=sc.next();
        System.out.println("pls input new pass again:");
        String newpass2=sc.next();

        if(!newpass1.equals(newpass2)){
            System.out.println("new password is not same");
            return;
        }
        int ret=service.modifyPass(newpass1,oldpass,current.getId());
        if(ret==1){
            System.out.println("password modify success!");
            current.setPassword(newpass1);
        }
        else{
            System.out.println("password modify fail!");
        }


    }
    private static void info() {
        System.out.println("pls input name:");
        String name=sc.next();
        System.out.println("pls input email:");
        String email=sc.next();
        System.out.println("pls input age:");
        int age=sc.nextInt();
        System.out.println("pls input phone:");
        String phone=sc.next();
        System.out.println("pls input gender:");
        String gender=sc.next();
        User temp=new User();
        temp.setName(name);
        temp.setAge(age);
        temp.setEmail(email);
        temp.setGender(gender);
        temp.setPhone(phone);
        temp.setId(current.getId());
        try {
            int ret = service.modifyInfo(temp);
            if (ret == 1) {
                System.out.println("modify info success");
                current.setName(temp.getName());
                current.setAge(temp.getAge());
                current.setEmail(temp.getEmail());
                current.setGender(temp.getGender());
                current.setPhone(temp.getPhone());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
