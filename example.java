import josx.platform.rcx.*;

            //////////////////////////////////////
            /**
            * Represents a simple sample application.
            *
            * @author The leJOS Tutorial
            * @version 1.0 
            */
            public class SimpleSample {        

                ////////////////////////////////////////////
                // public methods
                ////////////////////////////////////////////

                ////////////////////////////////////////////
                /**
                 * main method 
                 * @throws InterruptedException
                 */
                public static void main(String[] args) 
                    throws InterruptedException {

                    // message
                    TextLCD.print("DRIVE");

                    // drive forward
                    Motor.A.forward();

                    // just run until RUN button is pressed again
                    Button.RUN.waitForPressAndRelease();

                } // main()

            } // class SimpleSample