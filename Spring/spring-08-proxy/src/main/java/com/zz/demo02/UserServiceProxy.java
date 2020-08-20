package com.zz.demo02;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        System.out.println("add");
    }

    public void delete() {
        log("delete");
        System.out.println("delete");
    }

    public void update() {
        log("update");
        System.out.println("update");
    }

    public void query() {
        log("query");
        System.out.println("query");
    }

    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
