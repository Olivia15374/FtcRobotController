package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous

public class AutoDistanceTest extends LinearOpMode {

    private DcMotor bl;
    private DcMotor br;
    private DcMotor fl;
    private DcMotor fr;
    private DcMotor arm;
    private Servo claw1;
    private DistanceSensor distanceSensor;

    double pwr;
    double lift;
    double rotation;
    double pwrY;
    double pwrX;
    int pwrZ;
    boolean isBeaconDetected;





    @Override
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        arm = hardwareMap.get(DcMotor.class, "arm");
        //distance sensor


        waitForStart();

        MoveXY(10, 5, 1, 0.75);




    }
    public void distance()
    {
        double value =distanceSensor.getDistance(DistanceUnit.CM);
        telemetry.addData("Distance:", value);
        if(value > 5 && value <= 10){
            isBeaconDetected = true;}
        if(value >10){
            isBeaconDetected = false;
        }



    }
    private void MoveXY(float moveX, float moveY, double power, double seconds) {
        float pwrX;
        float pwrY;


        if (moveX > moveY) {
            pwrX = 1f;
            pwrY = (moveY / moveX);
        } else {
            pwrY = 1f;
            pwrX = (moveX / moveY);
        }

        pwrX *= power;
        pwrY *= power;

        fl.setPower(pwrY - pwrX);
        fr.setPower(-pwrY - pwrX);
        bl.setPower(pwrY + pwrX);
        br.setPower(-pwrY + pwrX);


    }

}