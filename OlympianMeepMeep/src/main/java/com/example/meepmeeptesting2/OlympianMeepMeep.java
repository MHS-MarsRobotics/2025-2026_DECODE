package com.example.meepmeeptesting2;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.ColorScheme;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class OlympianMeepMeep {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity REDFAR = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .build();

        RoadRunnerBotEntity REDGOAL = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .build();

        RoadRunnerBotEntity BLUEFAR = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        RoadRunnerBotEntity BLUEGOAL = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(14,15)
                .setColorScheme(new ColorSchemeBlueDark())
                .build();

        REDFAR.runAction(REDFAR.getDrive().actionBuilder(new Pose2d(61.3, 14.4, Math.toRadians(180)))
                .splineTo(new Vector2d(-47, 49), Math.toRadians(135))
                .strafeToLinearHeading(new Vector2d(-52,8),Math.toRadians(90))
                .build());



        REDGOAL.runAction(REDGOAL.getDrive().actionBuilder(new Pose2d( -50, 50,Math.toRadians(135)))
                .strafeTo(new Vector2d(-47,49))
                .strafeToLinearHeading(new Vector2d(-52,8),Math.toRadians(90))
                .build());



        BLUEFAR.runAction(BLUEFAR.getDrive().actionBuilder(new Pose2d(61.3, -14.4, Math.toRadians(180)))
                .splineTo(new Vector2d(-47, -49), Math.toRadians(225))
                .strafeToLinearHeading(new Vector2d(-52,-8),Math.toRadians(270))
                .build());



        BLUEGOAL.runAction(BLUEGOAL.getDrive().actionBuilder(new Pose2d( -50, -50,Math.toRadians(225)))
                .strafeTo(new Vector2d(-47,-49))
                .strafeToLinearHeading(new Vector2d(-52,-8),Math.toRadians(270))
                .build());



        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(REDFAR)
                .addEntity(REDGOAL)
                .addEntity(BLUEFAR)
                .addEntity(BLUEGOAL)
                .start();


}};
