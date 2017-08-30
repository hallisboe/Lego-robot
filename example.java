import josx.platform.rcx.*;
import lejos.hardware.Sound;

            public class SimpleSample {        

                public static void main(String[] args) throws InterruptedException {

                    TextLCD.print("DRIVE");
                    Sound.playSample(java.io.File('./song.wav'));

                    Button.RUN.waitForPressAndRelease();

                } 

            } 