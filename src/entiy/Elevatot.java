package entiy;

import java.util.Random;

public class Elevatot {
    Random r=new Random();
    private  final int MAXFLOOR=9;//设置最高层数
    private final int MInFLOOR=-1;//设置最低楼层
    private final int ALLFLOOR=10;//设置所有层数
    private final int TOTALPEOSUM=10;//设置最高承载量
    private final int TOTALPEOWEIGHT=1000;//设置最高承重量
    private int dtcsfloor= r.nextInt(10);//设置 默认电梯位置
    private int thisFloor;//设置电梯当前位置
    private int goFloor;//设置电梯要去的楼层。
    private int peoFloor;//设置人所在的楼层
    private int flool=Math.abs(goFloor-thisFloor);//设置电梯；楼层的差值
    private int waitTime=flool*2;//设置电梯等待时间
    private int elevator;//电梯运行状态
    private int dooropen;//电梯门的状态
    private int ispenIn;//设置人的状态：在电梯里，在电梯外。
    private  int EnElePeo;//设置电梯计入人数
    private int inPeoWeight=EnElePeo*60;//设置电梯里的所有人的重量;
    private int goEntpeo;//设置电梯进入人数
    private int goOutPeo;//设置出去人员数量
    private int chuanganqi;//设置门的传感器

    public int getChuanganqi() {
        return chuanganqi;
    }

    public void setChuanganqi(int chuanganqi) {
        this.chuanganqi = chuanganqi;
    }

    public int getPeoFloor() {
        return peoFloor;
    }

    public void setPeoFloor(int peoFloor) {
        this.peoFloor = peoFloor;
    }

    public int getMAXFLOOR() {
        return MAXFLOOR;
    }

    public int getMInFLOOR() {
        return MInFLOOR;
    }

    public int getALLFLOOR() {
        return ALLFLOOR;
    }

    public int getTOTALPEOSUM() {
        return TOTALPEOSUM;
    }

    public int getTOTALPEOWEIGHT() {
        return TOTALPEOWEIGHT;
    }

    public int getDtcsfloor() {
        return dtcsfloor;
    }

    public void setDtcsfloor(int dtcsfloor) {
        this.dtcsfloor = dtcsfloor;
    }

    public int getThisFloor() {
        return thisFloor;
    }

    public void setThisFloor(int thisFloor) {
        this.thisFloor = thisFloor;
    }

    public int getGoFloor() {
        return goFloor;
    }

    public void setGoFloor(int goFloor) {
        this.goFloor = goFloor;
    }

    public int getFlool() {
        return flool;
    }

    public void setFlool(int flool) {
        this.flool = flool;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getElevator() {
        return elevator;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }

    public int getDooropen() {
        return dooropen;
    }

    public void setDooropen(int dooropen) {
        this.dooropen = dooropen;
    }

    public int getIspenIn() {
        return ispenIn;
    }

    public void setIspenIn(int ispenIn) {
        this.ispenIn = ispenIn;
    }

    public int getEnElePeo() {
        return EnElePeo;
    }

    public void setEnElePeo(int enElePeo) {
        EnElePeo = enElePeo;
    }

    public int getInPeoWeight() {
        return inPeoWeight;
    }

    public void setInPeoWeight(int inPeoWeight) {
        this.inPeoWeight = inPeoWeight;
    }

    public int getGoEntpeo() {
        return goEntpeo;
    }

    public void setGoEntpeo(int goEntpeo) {
        this.goEntpeo = goEntpeo;
    }

    public int getGoOutPeo() {
        return goOutPeo;
    }

    public void setGoOutPeo(int goOutPeo) {
        this.goOutPeo = goOutPeo;
    }
}
