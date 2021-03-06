package com.tekmob.spaceexplorers.Screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tekmob.spaceexplorers.Assets;
import com.tekmob.spaceexplorers.Controller.PreferenceController;
import com.tekmob.spaceexplorers.SpaceExplorer;

/**
 * Created by Rahmat Rasyidi Hakim on 12/8/2014.
 */
public class StatScreen extends BaseScreen {

    private Table table;
    private Label title;
    private Image backgorund;
    private Image back;
    private Skin skin;
    private Label highscore, maxMissile, maxShield, maxMilestone;

    public StatScreen(SpaceExplorer s){
        super(s);
        table = new Table();
        skin = new Skin();
        skin.addRegions(Assets.gameAtlas);

        loadUI();
        createUI();
        setupHandler();

        stage.addActor(backgorund);
        stage.addActor(table);
    }

    private void setupHandler(){
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(spaceExplorer.getPrefController().isSoundEnabled()) Assets.click.play();
                spaceExplorer.getScreenstack().pop();
            }
        });
    }

    private void loadUI(){
        Label.LabelStyle l = new Label.LabelStyle();
        l.font = Assets.nasa;
        l.fontColor = Color.WHITE;
        title = new Label("STATS", l);

        l.font = Assets.roboto;
        highscore = new Label("Highscore : "+spaceExplorer.getPrefController().getInteger(PreferenceController.STATISTIC, PreferenceController.SCORE),l);
        maxMilestone = new Label("Last Milestone : "+spaceExplorer.getPrefController().getString(PreferenceController.STATISTIC, PreferenceController.MILESTONE).substring(1),l);
        maxMissile = new Label("Maximum Missile : "+spaceExplorer.getPrefController().getInteger(PreferenceController.STATISTIC, PreferenceController.MISSILE),l);
        maxShield = new Label("Maximum Shield : "+spaceExplorer.getPrefController().getInteger(PreferenceController.STATISTIC, PreferenceController.SHIELD),l);

        back = new Image(Assets.arrow);

        backgorund = new Image(Assets.background);
        backgorund.setSize(SpaceExplorer.WIDTH, SpaceExplorer.HEIGHT);
    }

    private void createUI(){
        table.setFillParent(true);
        table.top();
        table.add(title).padBottom(50).padTop(20).expandX().row();
        table.add(highscore).left().padLeft(30).padBottom(30).padTop(40).row();
        table.add(maxMilestone).left().padLeft(30).padBottom(30).padTop(30).row();
        table.add(maxMissile).left().padLeft(30).padBottom(30).padTop(30).row();
        table.add(maxShield).left().padLeft(30).padBottom(30).padTop(30).row();
        table.add(back).left();
    }
}
