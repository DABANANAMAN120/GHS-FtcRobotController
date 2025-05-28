package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import java.util.HashMap;
import java.util.Map;



//Please note: The majority of this file was written by ChatGPT
public class FTCLib_Toggle extends BlocksOpModeCompanion {
    private static final Map<Object, ToggleButtonReader> toggles = new HashMap<>();

    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static void createToggle(String name, Object input) {
        GamepadEx myGamepad = new GamepadEx(gamepad1);
        if (!toggles.containsKey(name)) {
            toggles.put(input, new ToggleButtonReader(myGamepad, GamepadKeys.Button.A));
        }
    }

    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static void updateToggle(Object name) {
        if (toggles.containsKey(name)) {
            toggles.get(name).readValue();
        }
    }

    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static boolean getToggleState(Boolean input) {
        return toggles.get(input).getState();
    }
}