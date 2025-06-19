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
    private static GamepadKeys.Button getButtonFromString(String buttonName) {
        try {
            return GamepadKeys.Button.valueOf(buttonName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the button name is invalid
            return null;
        }
    }


    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static void createToggle(String name, String buttonName) {
        GamepadEx myGamepad = new GamepadEx(gamepad1);
        GamepadKeys.Button button = getButtonFromString(buttonName);
        if (button != null && !toggles.containsKey(name)) {
            toggles.put(name, new ToggleButtonReader(myGamepad, button));
        }
    }
    /*
    public static void createToggle(String name, Boolean input) {
        GamepadEx myGamepad = new GamepadEx(gamepad1);
        if (!toggles.containsKey(name)) {
            toggles.put(input, new ToggleButtonReader(myGamepad, GamepadKeys.Button.A));
        }
    }
    */

    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static void updateToggle(String name) {
        if (toggles.containsKey(name)) {
            toggles.get(name).readValue();
        }
    }

    @ExportToBlocks(
            parameterLabels = "Button"
    )
    public static boolean getToggleState(String input) {
        return toggles.get(input).getState();
    }
}