package dao;

import java.security.PublicKey;

public interface EM {
    public void start();
    public void end();

    public void openDoor();//开门
    public void closeDoor();//关门
    public void boolDoorOpen();//判断们是否开启
    public void boolEleRun();//判断电梯是否运行
    public void showFloor();//显示电梯所在当前楼层
    public void doUp();//电梯上升
    public void doDown();//电梯下降
    public void boolEleUD();//判断电梯需要上升或者下降
    public void peoEntEle();//人进入电梯
    public void peoOutEle();//人走出电梯
    public void boolOverload();//判断电梯是否超载
    public void totop();//电梯到最高层
    public void toBom();//电梯到最底层
    public void chooseINEleFloor();//选择电梯按键
    public void chooseOutEleFloor();//选择电梯按键
    public void backToDefault();//回到默认地点
    public void runAsONe();//一个人时
    public void runAsManyPeo();//多人时
    public void boolContinue();//判断程序是否继续
    public void showPeoFloor();//显示人当前所在楼层
    public void EleGoPeo();//电梯到人的位置。在人要进入电梯时
      public void boolInElePeoNum();//判断电梯里的人数
    public void goUp();//
    public void goDown();//
    public void boolSomething();//判断传感器是否有都行
    public void showCGQ();

}
