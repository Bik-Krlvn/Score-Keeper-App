package com.birikorang_kelvin_proj.soccermetricapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTmAGoal, mTmBGoal, mTmACard, mTmBCard, mTmAFoul, mTmBFoul;
    private int currentAGoal = 0,
            currentBGoal = 0,
            currentAFoul = 0, currentBFoul = 0,
            currentACard = 0, currentBCard = 0;

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

        //init button
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
        currentAGoal = savedInstanceState.getInt("currentAGoal");
        currentBGoal = savedInstanceState.getInt("currentBGoal");
        currentAFoul = savedInstanceState.getInt("currentAFoul");
        currentBFoul = savedInstanceState.getInt("currentBFoul");
        currentACard = savedInstanceState.getInt("currentACard");
        currentBCard = savedInstanceState.getInt("currentBCard");

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
        currentACard += 1;
        mTmACard.setText(String.valueOf(currentACard));
    }

    private void addCardToTeamB() {
        currentBCard += 1;
        mTmBCard.setText(String.valueOf(currentBCard));
    }

    private void addFoulToTeamA() {
        currentAFoul += 1;
        mTmAFoul.setText(String.valueOf(currentAFoul));
    }

    private void addFoulToTeamB() {
        currentBFoul += 1;
        mTmBFoul.setText(String.valueOf(currentBFoul));
    }

    private void addGoalToTeamA() {
        currentAGoal += 1;
        mTmAGoal.setText(String.valueOf(currentAGoal));
    }

    private void addGoalToTeamB() {
        currentBGoal += 1;
        mTmBGoal.setText(String.valueOf(currentBGoal));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentAGoal", currentAGoal);
        outState.putInt("currentBGoal", currentBGoal);
        outState.putInt("currentAFoul", currentAFoul);
        outState.putInt("currentBFoul", currentBFoul);
        outState.putInt("currentACard", currentACard);
        outState.putInt("currentBCard", currentBCard);
    }


}
