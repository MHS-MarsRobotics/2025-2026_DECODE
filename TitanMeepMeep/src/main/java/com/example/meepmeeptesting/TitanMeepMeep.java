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
                .build();
        //Initialize Bot to red goal
        RoadRunnerBotEntity myBotToRedGoal = new DefaultBotBuilder(meepMeep)

                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())

                .build();

       // Drive to Blue Goal
        myBotToBlueGoal.runAction(myBotToBlueGoal.getDrive().actionBuilder(new Pose2d(59, -12, Math.toRadians(180)))
                        .waitSeconds(1)
                        .splineTo(new Vector2d(-36, -36 ), Math.toRadians(225))
                        .waitSeconds(1)
                        .turnTo(Math.toRadians(90))
                        .lineToY(-55)
                .build());

        // Drive to red Goal
        myBotToRedGoal.runAction(myBotToRedGoal.getDrive().actionBuilder(new Pose2d(59, 12, Math.toRadians(180)))
                .waitSeconds(1)
                .splineTo(new Vector2d(-36, 36), Math.toRadians(135))
                .waitSeconds(1)
                .turnTo(Math.toRadians(270))
                .lineToY(55)
                .build());



     //Titan Far launch bot

        //Initialize Bot to blue goal
        RoadRunnerBotEntity TitanToBlueGoal = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();
        //Initialize Bot to red goal
        RoadRunnerBotEntity TitanToRedGoal = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        // Drive to Blue Goal
        TitanToBlueGoal.runAction(TitanToBlueGoal.getDrive().actionBuilder(new Pose2d(59, -12, Math.toRadians(180)))
                .waitSeconds(1)
                .turnTo(Math.toRadians(200))

                //Keep for visuals, (REMOVE LATER) ↓
                .waitSeconds(5)
                .lineToY(-12)
                //Keep for visuals, (REMOVE LATER) ↑
                .build());

        TitanToRedGoal.runAction(TitanToRedGoal.getDrive().actionBuilder(new Pose2d(59, 12, Math.toRadians(180)))
                .waitSeconds(1)
                                .turnTo(Math.toRadians(160))
                //Keep for visuals, (REMOVE LATER) ↓
                .waitSeconds(5)
                .lineToY(-12)
                //Keep for visuals, (REMOVE LATER) ↑
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