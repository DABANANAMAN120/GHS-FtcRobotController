package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.teamcode.GhostRecorder.CodeSharer;
import org.firstinspires.ftc.teamcode.GhostRecorder.GhostController;
import org.firstinspires.ftc.teamcode.GhostRecorder.GhostRecorder;

public class Auto_Recorder extends BlocksOpModeCompanion {
    @ExportToBlocks()
    public static void Record_Auto (){
        GhostRecorder recorder = new GhostRecorder();
        CodeSharer codeSharer = new CodeSharer(hardwareMap.appContext);
        recorder.recordButtonA(gamepad1.cross);
        recorder.recordButtonB(gamepad1.circle);
        recorder.recordButtonX(gamepad1.square);
        recorder.recordButtonY(gamepad1.triangle);
        recorder.recordDpadUp(gamepad1.dpad_up);
        recorder.recordDpadDown(gamepad1.dpad_down);
        recorder.recordDpadLeft(gamepad1.dpad_left);
        recorder.recordDpadRight(gamepad1.dpad_right);
        recorder.recordLeftStickY(gamepad1.left_stick_y);
        recorder.recordLeftStickX(gamepad1.left_stick_x);
        recorder.recordRightStickY(gamepad1.right_stick_y);
        recorder.recordRightStickX(gamepad1.right_stick_x);
        recorder.recordLeftBumper(gamepad1.left_bumper);
        recorder.recordRightBumper(gamepad1.right_bumper);
        recorder.recordLeftTrigger(gamepad1.left_trigger);
        recorder.recordRightTrigger(gamepad1.right_trigger);
    }
    static GhostController controller;
    @ExportToBlocks(
            parameterLabels = "Recorded Code"
    )
    public static void Init_Controller(String code){
         controller = new GhostController(code);
    }

    @ExportToBlocks(
            comment = "IMPORTANT - Must include at top of OpMode loop"
    )
    public static void Playback_Auto(String code){
        controller.update();
    }
}
