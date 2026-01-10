package org.firstinspires.ftc.teamcode.auto;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "RedFar", group = "Autonomous")
public class RedFar extends LinearOpMode {
    public class arm {
        public Action Armdown;
        private DcMotor arm;

        public arm(HardwareMap hardwareMap) {
            arm = hardwareMap.get(DcMotorEx.class, "arm");
            arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        public class Armdown implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    arm.setPower(-0.8);
                    sleep(3000);
                    arm.setPower(0);
                    initialized = true;
                }

                return arm.isBusy();
            }
        }

        public Action Armdown() {
            return new Armdown();
        }
    }



    public void runOpMode() {
        Pose2d initialPose = new Pose2d( 59,12, Math.toRadians(180));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        arm arm = new arm(hardwareMap);

        // vision here that outputs position
        int visionOutputPosition = 1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(-36, 36), Math.toRadians(135));


        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                .turnTo(Math.toRadians(270))
                .lineToY(55);

        waitForStart();

        if (isStopRequested()) return;



        Actions.runBlocking(
                new SequentialAction(
                        tab1.build()
                )
        );

        Actions.runBlocking(
                new SequentialAction(
                        arm.Armdown()
                )
        );

        Actions.runBlocking(
                new SequentialAction(
                        tab2.build()
                )
        );
    }
}