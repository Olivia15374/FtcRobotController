package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class AutoTensorfail extends LinearOpMode{

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
    boolean isPixelDetceted;



    private void initTfod() {

        // Create the TensorFlow processor the easy way.
        tfod = TfodProcessor.easyCreateWithDefaults();

        // Create the vision portal the easy way.
        if (USE_WEBCAM) {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    hardwareMap.get(WebcamName.class, "Webcam 1"), tfod);
        } else {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    BuiltinCameraDirection.BACK, tfod);
        }

    }


    @Override
    public void runOpMode() {

        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        arm = hardwareMap.get(DcMotor.class, "arm");
        pullup = hardwareMap.get(DcMotor.class, "pullup");
        CAMERA

        waitForStart();

        MoveXY(10, 5, 1, 0.75);

        if




    }
    private void MoveXY(float moveX, float moveY, double power, double seconds){
        float pwrX;
        float pwrY;


        if (moveX > moveY){
            pwrX = 1f;
            pwrY = (moveY / moveX);
        } else{
            pwrY = 1f;
            pwrX = (moveX / moveY);
        }

        pwrX *= power;
        pwrY *= power;

        fl = (pwrY - pwrX);
        fr = (-pwrY - pwrX);
        bl = (pwrY + pwrX);
        br = (-pwrY + pwrX);

        Sleep(seconds * 1000);
    }
