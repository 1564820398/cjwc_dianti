package dao;

import entiy.Elevatot;
import netscape.security.UserTarget;

import java.util.Scanner;

public class ElevatorMethod implements EM {
    Scanner sc=new Scanner(System.in);
    Elevatot e=new Elevatot();

    public ElevatorMethod(){
        e.setThisFloor(3);
        e.setPeoFloor(2);
        }

    public void start(){

    }

    public void end(){}

    public void openDoor(){
        System.out.println("电梯门打开中");
        e.setDooropen(1);
        boolDoorOpen();
    }

    public void closeDoor(){
        System.out.println("电梯门关闭关闭中");
        e.setDooropen(2);
        boolDoorOpen();
    }

    public void boolDoorOpen(){
        if (e.getDooropen()==1){
            System.out.println("电梯门打开了");
        }else if (e.getDooropen()==2){
            System.out.println("电梯门关闭了");
        }else {
            System.out.println("当前状态不明");
        }
    }
    public void boolEleRun(){
        if (e.getElevator()==1){
            System.out.println("电梯上升中请等待");
        }else if (e.getElevator()==2){
            System.out.println("电梯下降中请稍等");
        }else if (e.getElevator()==0){
            System.out.println("电梯停止运行");
        }
    }
    public void showFloor( ){
        System.out.println("电梯在"+e.getThisFloor()+"层");
    }

    public void showPeoFloor( ){
        System.out.println("您在"+e.getPeoFloor()+"层");
    }
    public void EleGoPeo(){
        if (e.getPeoFloor()!=e.getThisFloor()){
            boolEleUD();
        }
    }

    public  void  doUp(){
        showFloor();
        closeDoor();
        e.setElevator(1);
        boolEleRun();
        for (int i=e.getThisFloor()+1;i<=e.getPeoFloor();i++){
            e.setThisFloor(i);
            if (e.getThisFloor()==0){
                continue;
            }
            if (i==e.getPeoFloor()){
                System.out.println("电梯到达了"+i+"层");
                break;
            }
            System.out.println("电梯到达了"+i+"层");
        }
        e.setElevator(0);
        boolEleRun();
        openDoor();
    }

public void doDown(){
    showFloor();
    closeDoor();
    e.setElevator(1);
    boolEleRun();
    for (int i=e.getThisFloor()-1;i>=e.getPeoFloor();i--){
        e.setThisFloor(i);
        if (e.getThisFloor()==0){
            continue;
        }
        if (i==e.getPeoFloor()){
            System.out.println("电梯到达了"+i+"层");
            break;
        }
        System.out.println("电梯到达了"+i+"层");
    }
    e.setElevator(0);
    boolEleRun();
    openDoor();
}
public void boolEleUD(){
        if (e.getPeoFloor()>e.getThisFloor()){
            doUp();
        }else {
            doDown();
        }
}

    @Override
    public void peoEntEle() {
        System.out.println("人进来了");
    }

    @Override
    public void peoOutEle() {

    }

    @Override
    public void boolOverload() {

    }

    @Override
    public void boolInElePeoNum() {

    }

    @Override
    public void toThetop() {

    }

    @Override
    public void toTheBom() {

    }

    @Override
    public void chooseINEleFloor() {


    }

    @Override
    public void chooseOutEleFloor() {
        showFloor();
        showPeoFloor();

        if (e.getPeoFloor()==e.getMInFLOOR()){
            System.out.println("您当前在"+e.getPeoFloor()+"楼,只能上楼");
            System.out.println("请选择是否上楼：上楼请按1");
            int chosse=sc.nextInt();
            if (chosse==1){
                EleGoPeo();
                peoEntEle();
            }else{
                chooseOutEleFloor();
            }
        }else if (e.getPeoFloor()==e.getMAXFLOOR()){
            System.out.println("您当前在"+e.getPeoFloor()+"楼,只能下楼");
            System.out.println("请选择是否下楼：上楼请按0");
            int chosse=sc.nextInt();
            if (chosse==0){
                EleGoPeo();
                peoEntEle();
            }else{
                chooseOutEleFloor();
            }
        }else {
            System.out.println("请选择上下楼：上楼请按1,下楼请按0");
            int chosse=sc.nextInt();
            if (chosse==1){
                EleGoPeo();
                peoEntEle();
            }else if (chosse==0){
                EleGoPeo();
                peoEntEle();
            }else if (chosse==2){
                System.out.println("结束了");
            }else {
                chooseOutEleFloor();
            }

        }
/*
        if (e.getPeoFloor()==e.getMInFLOOR()){
            System.out.println("只能上楼");
        }else if (e.getPeoFloor()==e.getMAXFLOOR()){
        }
        int choose=sc.nextInt();
        System.out.println("请选择");

*/
    }

    @Override
    public void backToDefault() {

    }

    @Override
    public void runAsONe() {

    }

    @Override
    public void runAsManyPeo() {

    }

    @Override
    public void boolContinue() {

    }


}
