import josx.platform.rcx.*;
import lejos.hardware.Sound;

            public class SimpleSample {        

                public static void main(String[] args) throws InterruptedException {

                    TextLCD.print("DARRRRRRUUUUUDE VERDEN!!!!");
                    Sound.playSample(java.io.File('./song.wav'));

                    Button.RUN.waitForPressAndRelease();

                    // Dette er en endring

                } 

            } 