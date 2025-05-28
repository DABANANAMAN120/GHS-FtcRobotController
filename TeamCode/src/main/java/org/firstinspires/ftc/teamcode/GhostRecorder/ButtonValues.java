package org.firstinspires.ftc.teamcode.GhostRecorder;

import java.util.ArrayList;
import java.util.Arrays;

public class ButtonValues extends ControllerValues<Boolean> {
  public final static String buttonA="cross";
  public final static String buttonB="circle";
  public final static String buttonX="square";
  public final static String buttonY="triangle";
  public final static String dpadUp="du";
  public final static String dpadDown="dd";
  public final static String dpadLeft="dl";
  public final static String dpadRight="dr";

  public final static String rightBumper="rb";
  public final static String leftBumper="lb";
 
   
  
  public ButtonValues() {
    super(false,
          new ArrayList<Boolean>(Arrays.asList(new Boolean[]{false,false,false,false,false,false,false,false,false,false})),
          new ArrayList<String>(Arrays.asList(new String[]{buttonA,buttonB,buttonX,buttonY,dpadUp,dpadDown,dpadLeft,dpadRight,rightBumper,leftBumper}))
         ); 
    
  }
}
