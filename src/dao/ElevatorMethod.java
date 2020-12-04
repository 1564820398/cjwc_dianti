package dao;

import entiy.Elevatot;
import netscape.security.UserTarget;

import java.util.Scanner;

public class ElevatorMethod implements EM {
    Scanner sc = new Scanner(System.in);
    Elevatot e = new Elevatot();

    public ElevatorMethod() {//程序初始化
        e.setThisFloor(5);
        e.setPeoFloor(1);
        e.setDooropen(2);
        e.setElevator(0);
    }

    public void start() {//开始
        System.out.println("电梯程序开始运行" );
        showPeoFloor();
        showFloor();
        boolEleRun();
        boolDoorOpen();
    }

    public void end() {//关闭
        boolContinue();
    }

    public void openDoor() {//开门
        System.out.println("电梯门打开中");
        e.setDooropen(1);
        boolDoorOpen();
    }

    public void closeDoor() {//关门
        System.out.println("电梯门关闭关闭中");
        e.setDooropen(2);
        boolDoorOpen();
    }

    public void boolDoorOpen() {
        if (e.getDooropen() == 1) {
            System.out.println("电梯门打开了");
        } else if (e.getDooropen() == 2) {
            System.out.println("电梯门关闭了");
        } else {
            System.out.println("当前状态不明");
        }
    }

    public void boolEleRun() {
        if (e.getElevator() == 1) {
            System.out.println("电梯上升中请等待");
        } else if (e.getElevator() == 2) {
            System.out.println("电梯下降中请稍等");
        } else if (e.getElevator() == 0) {
            System.out.println("电梯停止运行");
        }
    }

    public void showFloor() {
        System.out.println("电梯在" + e.getThisFloor() + "层");
    }

    public void showPeoFloor() {
        System.out.println("您在" + e.getPeoFloor() + "层");
    }

    public void EleGoPeo() {
        if (e.getPeoFloor() > e.getThisFloor()) {
            doUp();
        } else if (e.getPeoFloor() < e.getThisFloor()) {
            doDown();
        } else {
            openDoor();
        }

    }

    @Override
    public void boolInElePeoNum() {

    }

    @Override
    public void goUp() {
        showFloor();
        closeDoor();
        e.setElevator(1);
        boolEleRun();
        for (int i = e.getThisFloor() + 1; i <= e.getGoFloor(); i++) {
            e.setThisFloor(i);

            if (e.getThisFloor() == 0) {
                continue;
            }
            if (i == e.getGoFloor()) {
                System.out.println("电梯已到达" + i + "层");
                break;
            }
            System.out.println("电梯到达了" + i + "层");

        }
        e.setElevator(0);
        boolEleRun();
        openDoor();

    }

    @Override
    public void goDown() {
        showFloor();
        closeDoor();
        toBom();
        boolEleRun();
        for (int i = e.getThisFloor() - 1; i >= e.getGoFloor(); i--) {
            e.setThisFloor(i);
            if (e.getThisFloor() == 0) {
                continue;
            }
            if (i == e.getGoFloor()) {
                System.out.println("电梯已到达" + i + "层");
                break;
            }
            System.out.println("电梯到达了" + i + "层");

        }
        e.setElevator(0);
        boolEleRun();
        openDoor();
    }

    @Override
    public void boolSomething() {
        if (e.getChuanganqi()==1){
            System.out.println("传感器有东西门不能关闭电梯门,电梯门持续开启");
            e.setDooropen(1);
        }else if (e.getChuanganqi()==2){
            System.out.println("当前电梯门传感器没有感应到东西 可以关闭电梯门");
            e.setDooropen(2);
        }

    }

    @Override
    public void showCGQ() {
        System.out.print("当前传感器状态时+");
        boolSomething();
    }

    public void doUp() {
        showFloor();
        closeDoor();
        totop();
        boolEleRun();
        for (int i = e.getThisFloor() + 1; i <= e.getPeoFloor(); i++) {
            e.setThisFloor(i);
            if (e.getThisFloor() == 0) {
                continue;
            }
            if (i == e.getPeoFloor()) {
                System.out.println("电梯到达了" + i + "层");
                break;
            }
            System.out.println("电梯到达了" + i + "层");
        }
        e.setElevator(0);
        boolEleRun();
        openDoor();
    }

    public void doDown() {
        showFloor();
        closeDoor();
        e.setElevator(2);
        boolEleRun();
        for (int i = e.getThisFloor() - 1; i >= e.getPeoFloor(); i--) {
            e.setThisFloor(i);
            if (e.getThisFloor() == 0) {
                continue;
            }
            if (i == e.getPeoFloor()) {
                System.out.println("电梯到达了" + i + "层");
                break;
            }
            System.out.println("电梯到达了" + i + "层");
        }
        e.setElevator(0);
        boolEleRun();
        openDoor();
    }

    public void boolEleUD() {
        System.out.println("请选择到几楼-1~9楼");
        int goflor = sc.nextInt();
        e.setGoFloor(goflor);
        if (goflor==e.getThisFloor()){
            System.out.println("您当前已在所在楼层楼请重新判断输入的对不对后重新输入");
            boolEleUD();
        }else if (e.getGoFloor() > e.getThisFloor()) {//要去的地方和现在电梯的位置
            //上咯
            goUp();
            peoOutEle();
        } else if (e.getGoFloor() < e.getThisFloor()) {
            goDown();
            peoOutEle();
        }  else  {

        }
    }

    @Override
    public void peoEntEle() {
        System.out.println("人进来了");
        //设置传感器
        e.setChuanganqi(1);
        boolSomething();
        e.setChuanganqi(2);
        boolSomething();

        chooseINEleFloor();
        // boolOverload();
    }

    @Override
    public void peoOutEle() {
        System.out.println("人出来了");
        System.out.println("请输入走出人数");
        int peo = sc.nextInt();
        if (peo > e.getEnElePeo()) {
            System.out.println("输入错误");
            peoOutEle();
        }else {
            System.out.println("剩余多少人");
            e.setEnElePeo(e.getEnElePeo() - peo);
            System.out.println(e.getEnElePeo());

        }

    }

    @Override
    public void boolOverload() {
        if (e.getEnElePeo() > e.getTOTALPEOSUM() | e.getInPeoWeight() > e.getTOTALPEOWEIGHT()) {
            System.out.println("当前人数" + e.getEnElePeo());
            System.out.println("超重，请走出一些人");
            chooseINEleFloor();
        } else {
            System.out.println("当前人数" + e.getEnElePeo());
            System.out.println("没有超载，电梯正常运行");
        }
    }


    @Override
    public void totop() {
        System.out.println("向上运行");
        e.setElevator(1);
    }

    @Override
    public void toBom() {
        System.out.println("向下运行");
        e.setElevator(2);
    }
public void boolhasPeo(){
        if (e.getGoEntpeo()==1){
            runAsONe();
        }else if (e.getGoOutPeo()>1&e.getGoOutPeo()<e.getTOTALPEOSUM()){
            runAsManyPeo();

        }
}
    @Override
    public void chooseINEleFloor() {
        System.out.println("请输入进来的人数");
        int peosum = sc.nextInt();
        e.setGoEntpeo(peosum);
        boolOverload();
        e.setEnElePeo(e.getGoEntpeo());

        boolEleUD();

    }

    @Override
    public void chooseOutEleFloor() {
        showFloor();
        showPeoFloor();

        if (e.getPeoFloor() == e.getMInFLOOR()) {
            System.out.println("您当前在" + e.getPeoFloor() + "楼,只能上楼");
            System.out.println("请选择是否上楼：上楼请按1");
            int chosse = sc.nextInt();
            if (chosse == 1) {
                EleGoPeo();
                peoEntEle();
            } else {
                chooseOutEleFloor();
            }
        } else if (e.getPeoFloor() == e.getMAXFLOOR()) {
            System.out.println("您当前在" + e.getPeoFloor() + "楼,只能下楼");
            System.out.println("请选择是否下楼：下楼请按0");
            int chosse = sc.nextInt();
            if (chosse == 0) {
                EleGoPeo();
                peoEntEle();
            } else {
                chooseOutEleFloor();
            }
        } else {
            System.out.println("请选择上下楼：上楼请按1,下楼请按0,结束运行请输入2");
            int chosse = sc.nextInt();
            if (chosse == 1) {
                EleGoPeo();
                peoEntEle();
            } else if (chosse == 0) {
                EleGoPeo();
                peoEntEle();
            } else if (chosse == 2) {
                System.out.println("结束了");
            } else {
                chooseOutEleFloor();
            }

        }
    }

    @Override
    public void backToDefault() {
        System.out.println("电梯回到默认点1L");
        e.setThisFloor(1);
        System.out.println(e.getThisFloor());
    }

    @Override
    public void runAsONe() {
        System.out.println("启动电梯只有一个人");

    }

    @Override
    public void runAsManyPeo() {
        System.out.println("启动电梯里有多人");
    }

    @Override
    public void boolContinue() {
        System.out.println("是否继续");
        System.out.println("按Y继续，N退出程序");
        String choose = sc.next();
        if (choose.equals("y")) {
            chooseOutEleFloor();
        } else if (choose.equals("N")) {
            System.out.println("程序结束");
        } else {
        boolContinue();
        }

    }


}
