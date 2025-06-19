package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import kotlin._Assertions;

public class Dash_Telemetry extends BlocksOpModeCompanion {
    static TelemetryPacket packet = new TelemetryPacket();
    static FtcDashboard dashboard = FtcDashboard.getInstance();
    @ExportToBlocks()
    public static void Init_Telemetry (){
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        packet.fieldOverlay()
                .setFill("blue")
                .fillRect(-20, -20, 40, 40);
    }

    @ExportToBlocks()
    public static void Add_Number (String Label, Number Data){
        packet.put(Label, Data);
    }

    @ExportToBlocks()
    public static void Add_Text(String Label, String Data){
        packet.put(Label, Data);
    }

    @ExportToBlocks()
    public static void Send_Packet () {
        dashboard.sendTelemetryPacket(packet);
    }


}
