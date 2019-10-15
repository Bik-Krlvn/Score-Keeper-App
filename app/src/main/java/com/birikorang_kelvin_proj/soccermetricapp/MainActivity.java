package com.birikorang_kelvin_proj.soccermetricapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTmAGoal;
    private TextView mTmBGoal;
    private TextView mTmACard;
    private TextView mTmBCard;
    private TextView mTmAFoul;
    private TextView mTmBFoul;

    private int currentAGoal = 0;
    private int currentBGoal = 0;
    private int currentAFoul = 0;
    private int currentBFoul = 0;
    private int currentACard = 0;
    private int currentBCard = 0;

    private final String KEY_CURRENT_A_GOAL = "currentAGoal";
    private final String KEY_CURRENT_B_GOAL = "currentBGoal";
    private final String KEY_CURRENT_A_FOUL = "currentAFoul";
    private final String KEY_CURRENT_B_FOUL = "currentBFoul";
    private final String KEY_CURRENT_A_CARD = "currentACard";
    private final String KEY_CURRENT_B_CARD = "currentBCard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init text views
        mTmACard = findViewById(R.id.tv_tm_a_card);
        mTmBCard = findViewById(R.id.tv_tm_b_card);
        mTmAFoul = findViewById(R.id.tv_tm_a_foul);
        mTmBFoul = findViewById(R.id.tv_tm_b_foul);
        mTmAGoal = findViewById(R.id.tv_tm_a_goal);
        mTmBGoal = findViewById(R.id.tv_tm_b_goal);

        //set button listeners
        findViewById(R.id.btn_reset).setOnClickListener(this);
        findViewById(R.id.btn_tm_a_card).setOnClickListener(this);
        findViewById(R.id.btn_tm_b_card).setOnClickListener(this);
        findViewById(R.id.btn_tm_a_goal).setOnClickListener(this);
        findViewById(R.id.btn_tm_b_goal).setOnClickListener(this);
        findViewById(R.id.btn_tm_a_foul).setOnClickListener(this);
        findViewById(R.id.btn_tm_b_foul).setOnClickListener(this);

        if (savedInstanceState != null) {
            restoreMetricInfo(savedInstanceState);
        } else {
            resetMetricInfo();
        }
    }

    private void restoreMetricInfo(Bundle savedInstanceState) {
        currentAGoal = savedInstanceState.getInt(KEY_CURRENT_A_GOAL);
        currentBGoal = savedInstanceState.getInt(KEY_CURRENT_B_GOAL);
        currentAFoul = savedInstanceState.getInt(KEY_CURRENT_A_FOUL);
        currentBFoul = savedInstanceState.getInt(KEY_CURRENT_B_FOUL);
        currentACard = savedInstanceState.getInt(KEY_CURRENT_A_CARD);
        currentBCard = savedInstanceState.getInt(KEY_CURRENT_B_CARD);

        mTmACard.setText(String.valueOf(currentACard));
        mTmBCard.setText(String.valueOf(currentBCard));
        mTmAFoul.setText(String.valueOf(currentAFoul));
        mTmBFoul.setText(String.valueOf(currentBFoul));
        mTmAGoal.setText(String.valueOf(currentAGoal));
        mTmBGoal.setText(String.valueOf(currentBGoal));
    }


    private void resetMetricInfo() {
        currentAGoal = 0;
        currentBGoal = 0;
        currentAFoul = 0;
        currentBFoul = 0;
        currentACard = 0;
        currentBCard = 0;

        mTmACard.setText(String.valueOf(currentACard));
        mTmBCard.setText(String.valueOf(currentBCard));
        mTmAFoul.setText(String.valueOf(currentAFoul));
        mTmBFoul.setText(String.valueOf(currentBFoul));
        mTmAGoal.setText(String.valueOf(currentAGoal));
        mTmBGoal.setText(String.valueOf(currentBGoal));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reset:
                resetMetricInfo();
                break;
            case R.id.btn_tm_a_card:
                addCardToTeamA();
                break;
            case R.id.btn_tm_b_card:
                addCardToTeamB();
                break;
            case R.id.btn_tm_a_foul:
                addFoulToTeamA();
                break;
            case R.id.btn_tm_b_foul:
                addFoulToTeamB();
                break;
            case R.id.btn_tm_a_goal:
                addGoalToTeamA();
                break;
            case R.id.btn_tm_b_goal:
                addGoalToTeamB();
                break;
            default:
                break;
        }
    }

    private void addCardToTeamA() {
        currentACard ++;
        mTmACard.setText(String.valueOf(currentACard));
    }

    private void addCardToTeamB() {
        currentBCard ++;
        mTmBCard.setText(String.valueOf(currentBCard));
    }

    private void addFoulToTeamA() {
        currentAFoul ++;
        mTmAFoul.setText(String.valueOf(currentAFoul));
    }

    private void addFoulToTeamB() {
        currentBFoul ++;
        mTmBFoul.setText(String.valueOf(currentBFoul));
    }

    private void addGoalToTeamA() {
        currentAGoal ++;
        mTmAGoal.setText(String.valueOf(currentAGoal));
    }

    private void addGoalToTeamB() {
        currentBGoal ++;
        mTmBGoal.setText(String.valueOf(currentBGoal));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_A_GOAL, currentAGoal);
        outState.putInt(KEY_CURRENT_B_GOAL, currentBGoal);
        outState.putInt(KEY_CURRENT_A_FOUL, currentAFoul);
        outState.putInt(KEY_CURRENT_B_FOUL, currentBFoul);
        outState.putInt(KEY_CURRENT_A_CARD, currentACard);
        outState.putInt(KEY_CURRENT_B_CARD, currentBCard);
    }


}
