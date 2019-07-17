package com.liling.smartband.util;

import org.springframework.stereotype.Component;

@Component
public class FallDetection {
    private static final double MOTIONLESS_THRESHOLD = 0.1875;  //静止状态阈值
    private static final double FREE_FALL_THRESHOLD = 0.75;  //失重判断阈值，单位g
    private static final double HIT_THRESHOLD = 2;  //撞击阈值
    private static final double FLIP_THRESHOLD = 0.7;  //翻转状态阈值

    //静止状态判断
    public static boolean isMotionless(double x, double y, double z){
        //加速度计算
        double acceleration = getAcceleration(x,y,z);

        //状态判断
        //静止状态判断
        return acceleration < MOTIONLESS_THRESHOLD;
    }

    //失重状态判断
    public static boolean isFreeFall(double x, double y, double z){
        //加速度计算
        double acceleration = getAcceleration(x,y,z);

        //失重状态检测
        return acceleration < FREE_FALL_THRESHOLD;
    }

    //撞击状态判断
    public static boolean isHit(double x, double y, double z){
        //加速度计算
        double acceleration = getAcceleration(x,y,z);

        //失重状态检测
        return acceleration > HIT_THRESHOLD;
    }

    //翻转状态判断
    public static boolean isFlip(double x, double y, double z){
        //加速度计算
        double acceleration = getAcceleration(x,y,z);

        //失重状态检测
        return acceleration > FLIP_THRESHOLD;
    }

    /**
     * 求和速度
     * @param x x轴速度
     * @param y y轴速度
     * @param z z轴速度
     * @return 和速度
     */
    private static double getAcceleration(double x,double y,double z){
        //x，y，z的平方和
        Double tmp = Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2);
        //和再开方
        return Math.sqrt(tmp);
    }
}
