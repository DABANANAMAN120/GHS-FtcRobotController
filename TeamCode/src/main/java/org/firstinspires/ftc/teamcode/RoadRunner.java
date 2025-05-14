package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RoadRunner extends LinearOpMode {
    /*
    Notes:
    Do not program sharp turns. either split it into 2 trajectories, or use a spline
    Coordinate system is in inches, 72x72, (0,0) is the center of the field
    If running trajectory with robot moving backwards is desired, add boolean true new Pose2d() at location specified in code
    If running trajectory at angle is desired, add Math.toRadians() function as 2nd param at location specified in code
    Vector 2d is a simple point on the field, but pose adds a 3rd param, the heading (in radians)
    When calculating headings, higher angle will move counter clockwise
    When using splines, endTangent is just a math factor for how sharp the curve is
    Possible movement functions (for this example, distance is in inches, and heading is in radians):
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
    Other functions:
        .turn(radians) //turn counterclockwise
        .waitSeconds(seconds) // similar to sleep()


    Markers basically allow you to incorporate other movement actuators into your RR program, such as and arm or claw.
    There are 3 types of markers:
        Temporal Markers - Runs after specified time has passed since beginning of trajectory
            Does not matter placement in code, will always wun at specified time
            .addTemporalMarker(seconds, () -> {
                //Your action code here
            })
        Displacement Markers - Two types
            Inline Displacement Marker - Runs like normal code, after the previous lines have been executed
                .addDisplacementMarker(() -> {
                    //Your action code here
                })
            Global Displacement Marker - Runs one robot has moved specified distance
                .addDisplacementMarker(inches, () -> {
                    //Your action code here
                )}
        Spatial Markers - Runs when robot reaches point in path closest to specified coordinate
            //Note: Can be a little unpredictable
            //Replace X and Y in following line
            .addSpatialMarker(new Vector2d(x, y), () -> {
                //Your action code here
            })

    The full documentation can be found at https://learnroadrunner.com/trajectories.html
    Everything above current location sidebar is irrelevant unless tuning RR, for programming, focus on everything on the current page and below


     */
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(0, 0,Math.toRadians(90)); //x coord, y coord, heading
        drive.setPoseEstimate(startPose);

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d()) //See lines 15 and 16 for instructions
                .strafeRight(10)
                .forward(5)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);
    }
}