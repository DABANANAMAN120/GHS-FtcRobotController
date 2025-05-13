package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RoadRunner extends LinearOpMode {
    /*
    IMPORTANT NOTES:
    Do not program sharp turns. either split it into 2 trajectories, or use a spline
    Coordinate system is in inches, 72x72, (0,0) is the center of the field
    If running trajectory with robot moving backwards is desired, add boolean true to line 24 after new Pose2d()
    If running trajectory at angle is desired, add Math.toRadians() function as 2nd param in line 24
    Vector 2d is a simple point on the field, but pose adds a 3rd param, the heading (in radians)
    When calculating headings, higher angle will move counter clockwise
    When using splines, endTangent is just a math factor for how sharp the curve is
    Possible functions (for this example, distance is in inches, and heading is in radians):
        .forward(distance)
        .back(distance)
        .strafeLeft(distance)
        .strafeRight(distance)
        .lineTo(Vector2d) //Straight line to point, maintains heading
        .lineToConstantHeading(Vector2d) //Same as lineTo
        .strafeTo(Vector2d) // Same as lineTo, but shorter
        .lineToLinearHeading(Pose2d) // Moves in straight line to position, turns to face heading while moving
        .lineToSplineHeading(Pose2d) //Mostly the same as lineToLinearHeading, but a bit more accel and deccel
        .splineTo(Vector2d, endTangent) //Moves in an S shape, faces to follow path
        .splineToConstantHeading(Pose2d, endTangent) //Moves in an S shape, faces constant direction
        .splineToLinearHeading(Pose2d, endTangent) //Moves in a spline path, turns to heading while moving
        .splineToSplineHeading(Pose2d, endTangent) //Moves in a spline, turns to move with the spline


     */
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(0, 0,Math.toRadians(90)); //x coord, y coord, heading
        drive.setPoseEstimate(startPose);

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
                .forward(5)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);
    }
}