package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class TitanMeepMeep {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        //Olympian rubber band launch bot

        //Initialize Bot to blue goal
        RoadRunnerBotEntity myBotToBlueGoal = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .setDimensions(14,15)
                .build();
        //Initialize Bot to red goal
        RoadRunnerBotEntity myBotToRedGoal = new DefaultBotBuilder(meepMeep)

                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .setDimensions(14,15)
                .build();

       // Drive to Blue Goal
        myBotToBlueGoal.runAction(myBotToBlueGoal.getDrive().actionBuilder(new Pose2d(63, -12, Math.toRadians(0)))
                        .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(47,-0),Math.toRadians(210))
                        .waitSeconds(1)
                        .strafeToLinearHeading(new Vector2d(63.4,-34),Math.toRadians(270))
                .build());

        // Drive to Red Goal
        myBotToRedGoal.runAction(myBotToRedGoal.getDrive().actionBuilder(new Pose2d(63, 12, Math.toRadians(0)))
                .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(47,0),Math.toRadians(150))
                .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(63.4,34),Math.toRadians(90))
                .build());



     //Titan Far launch bot

        //Initialize Bot to blue goal
        RoadRunnerBotEntity TitanToBlueGoal = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .build();
        //Initialize Bot to red goal
        RoadRunnerBotEntity TitanToRedGoal = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .build();

        // Drive to Blue Goal
        TitanToBlueGoal.runAction(TitanToBlueGoal.getDrive().actionBuilder(new Pose2d(-50, -50, Math.toRadians(229)))
                .waitSeconds(2)
                .strafeTo(new Vector2d(0,0))
                .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(-63.4,-8),Math.toRadians(270))
                .build());

        TitanToRedGoal.runAction(TitanToRedGoal.getDrive().actionBuilder(new Pose2d(-50, 50, Math.toRadians(129)))
                .waitSeconds(2)
                .strafeTo(new Vector2d(0,0))
                .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(-63.4,8),Math.toRadians(90))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(TitanToBlueGoal)
                .addEntity(TitanToRedGoal)
                .addEntity(myBotToBlueGoal)
                .addEntity(myBotToRedGoal)
                .start();


    }
}