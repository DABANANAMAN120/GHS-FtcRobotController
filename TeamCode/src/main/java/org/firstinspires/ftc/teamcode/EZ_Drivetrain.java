package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class EZ_Drivetrain extends BlocksOpModeCompanion {
    static SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);



    @ExportToBlocks(
            parameterLabels = "Using Dashboard?"
    )
    public static void EZMecanum_Robot_Centric(boolean dash){
        Motor backLeft = new Motor(hardwareMap, "backLeft");
        Motor backRight = new Motor(hardwareMap, "backRight");
        Motor frontLeft = new Motor(hardwareMap, "frontLeft");
        Motor frontRight = new Motor(hardwareMap, "frontRight");
        MecanumDrive mecanum = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        if (dash){
            mecanum.driveRobotCentric(gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        } else {
            mecanum.driveRobotCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
    @ExportToBlocks(
            parameterLabels = "Using Dashboard?"
    )
    public static void EZMecanum_Field_Centric(boolean dash){
        Motor backLeft = new Motor(hardwareMap, "backLeft");
        Motor backRight = new Motor(hardwareMap, "backRight");
        Motor frontLeft = new Motor(hardwareMap, "frontLeft");
        Motor frontRight = new Motor(hardwareMap, "frontRight");
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        double heading = Math.toDegrees(drive.getExternalHeading());
        MecanumDrive mecanum = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        if (dash){
            mecanum.driveFieldCentric(gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x, heading);
        } else {
            mecanum.driveFieldCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, heading);
        }
    }


    @ExportToBlocks()
    public static void EZDiff_Arcade(){
        Motor leftDrive = new Motor(hardwareMap, "leftDrive");
        Motor rightDrive = new Motor(hardwareMap, "rightDrive");
        DifferentialDrive diff = new DifferentialDrive(leftDrive, rightDrive);
        diff.arcadeDrive(gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    @ExportToBlocks()
    public static void EZDiff_Tank(){
        Motor leftDrive = new Motor(hardwareMap, "leftDrive");
        Motor rightDrive = new Motor(hardwareMap, "rightDrive");
        DifferentialDrive diff = new DifferentialDrive(leftDrive, rightDrive);
        diff.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
    }



}
