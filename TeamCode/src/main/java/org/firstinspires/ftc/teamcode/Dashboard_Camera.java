package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.vision.VisionPortal;

public class Dashboard_Camera extends BlocksOpModeCompanion {
    @ExportToBlocks()
    public static void Init_Camera(){
        final VisionPortalStreamingOpMode.CameraStreamProcessor processor = new VisionPortalStreamingOpMode.CameraStreamProcessor();

        new VisionPortal.Builder()
                .addProcessor(processor)
                .setCamera(BuiltinCameraDirection.BACK)
                .build();

        FtcDashboard.getInstance().startCameraStream(processor, 0);
    }
}
