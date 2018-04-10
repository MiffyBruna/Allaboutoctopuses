package com.example.android.allaboutoctopuses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity_q1 = 0;
    int score = 0;
    /**
     * Question Eight Logic
     **/

    int speed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*** Question One logic*/
    public void decrease(View view) {
        TextView octopusFact1 = (TextView) findViewById(R.id.answer1);
        Button addButton = (Button) findViewById(R.id.plus);
        Button minusButton = (Button) findViewById(R.id.minus);

        if (quantity_q1 == 3) {
            return;
        }
        if (quantity_q1 == 0) {
            Toast.makeText(getApplicationContext(), "Add Another one(^_^)", Toast.LENGTH_SHORT).show();
            octopusFact1.setText("");
            return;
        }
        quantity_q1 = quantity_q1 - 1;
        Toast.makeText(getApplicationContext(), "Add Another one(^_^)", Toast.LENGTH_SHORT).show();
        octopusFact1.setText("");
        display(quantity_q1);
    }

    public void increase(View view) {
        Button addButton = (Button) findViewById(R.id.plus);
        Button minusButton = (Button) findViewById(R.id.minus);
        TextView octopusFact1 = (TextView) findViewById(R.id.answer1);

        if (quantity_q1 > 2) {
            return;
        }

        if (quantity_q1 < 2) {
            octopusFact1.setText("");
        } else {
            setTestScore();

            Toast.makeText(getApplicationContext(), "Good Job!!", Toast.LENGTH_SHORT).show();
            octopusFact1.setText("\"One pumps blood through its organs; the two others pump blood through its gills\"");


        }
        quantity_q1 = quantity_q1 + 1;
        display(quantity_q1);

    }

    public void display(int number) {
        TextView octopusHearts = (TextView) findViewById(R.id.quantity_q1);
        octopusHearts.setText("" + number);
    }

    /*** Question Two logic*/

    public void radioButtonQ2(View view) {
        TextView octopusFact2 = (TextView) findViewById(R.id.answer2);

        boolean checked = ((RadioButton) view).isChecked();
        RadioGroup radioCheck = (RadioGroup) findViewById(R.id.radioG1);
        switch (view.getId()) {

            case R.id.red:
            case R.id.purple:

                if (checked)
                    octopusFact2.setText("");
                Toast.makeText(getApplicationContext(), "Try Again!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue:
                if (checked)
                    octopusFact2.setText("\"Octopus blood is blue because it has a copper-based protein called hemocyanin\"");
                Toast.makeText(getApplicationContext(), "Good Job!!", Toast.LENGTH_SHORT).show();
                setTestScore();
                disableGroup1();


        }
    }

    private void disableGroup1() {
        RadioGroup radioCheck = (RadioGroup) findViewById(R.id.radioG1);
        for (int i = 0; i < radioCheck.getChildCount(); i++) {
            radioCheck.getChildAt(i).setEnabled(false);
        }
    }

    /*** Question Three logic*/
    public void check(View view) {
        TextView octopusFact3 = (TextView) findViewById(R.id.answer3);
        EditText answer_field = (EditText) findViewById(R.id.answer_field);
        Button sendAnswer = (Button) findViewById(R.id.send);
        String answer3 = answer_field.getText().toString();


        if (answer_field.getText().toString().equalsIgnoreCase("crawl") || answer_field.getText().toString().equalsIgnoreCase("to crawl") || answer_field.getText().toString().equalsIgnoreCase("crawling")) {
            octopusFact3.setText("\"When an octopus is swimming, the organ that delivers blood to the organs stops beating which takes a lot of energy that's the reason they prefer to crawl\"");
            Toast.makeText(getApplicationContext(), "Good Job!!", Toast.LENGTH_SHORT).show();
            setTestScore();
            sendAnswer.setEnabled(false);
        } else {
            Toast.makeText(getApplicationContext(), "Try Again!!", Toast.LENGTH_SHORT).show();
            octopusFact3.setText("");

        }
    }

    /*** Question Four logic*/

    public void radioButtonQ4(View view) {
        TextView octopusFact4 = (TextView) findViewById(R.id.answer4);

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.hellYeah:
                if (checked)
                    octopusFact4.setText("Octopuses learn to solve puzzles, use tools and play if bored some scientists have found that they have their own personality.\n");
                Toast.makeText(getApplicationContext(), "Of course ^-^!!", Toast.LENGTH_SHORT).show();
                disableGroup2();
                setTestScore();

                break;
            case R.id.naynay:
                if (checked)
                    octopusFact4.setText("Aristotle in the year 305 BC thought the same thing as you.\nYet science has proven he was wrong!\nHope you will change your mind someday!!\n");
                Toast.makeText(getApplicationContext(), "How dare you >n<!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void disableGroup2() {
        RadioGroup radioCheck = (RadioGroup) findViewById(R.id.radioG2);
        for (int i = 0; i < radioCheck.getChildCount(); i++) {
            radioCheck.getChildAt(i).setEnabled(false);
        }
    }

    /*** Question Five logic*/

    public void onClick(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        TextView octopusFact1 = (TextView) findViewById(R.id.answer5);


        switch (view.getId()) {

            case R.id.mecha1:
                if (checked)
                    octopusFact1.setText("\"It works to confuse a predator, it can blind an enemy because it's very irritant. It can mess up their  sense of taste, smell and sight\"");
                else
                    octopusFact1.setText("");
                break;

            case R.id.mecha2:
                if (checked)
                    octopusFact1.setText("\"It's the ability to regenerete an arm. Octopus tentacles have their own brain which controls it's movement.\"");
                else
                    octopusFact1.setText("");
                break;
            case R.id.mecha3:
                if (checked)
                    octopusFact1.setText("\"A number of cephalopods are skilled in the art of color change.\"");
                else
                    octopusFact1.setText("");
                break;
            case R.id.mecha4:
                if (checked)
                    octopusFact1.setText("\"The Mimic Octopus is a master of disguise, it can change it's shape to imitate other predators.\"");
                else
                    octopusFact1.setText("");
                break;

        }
    }

    /**
     * Question Five submit button
     */

    public void check1(View view) {
        Button sendAnswer1 = (Button) findViewById(R.id.send1);
        TextView octopusFact1 = (TextView) findViewById(R.id.answer5);

        CheckBox mecha1 = findViewById(R.id.mecha1);
        boolean option1 = mecha1.isChecked();

        CheckBox mecha2 = findViewById(R.id.mecha2);
        boolean option2 = mecha2.isChecked();

        CheckBox mecha3 = findViewById(R.id.mecha3);
        boolean option3 = mecha3.isChecked();

        CheckBox mecha4 = findViewById(R.id.mecha4);
        boolean option4 = mecha4.isChecked();

        if (option1 && option2 && option3 && option4) {
            setTestScore();

            octopusFact1.setText("\"Good Job!! Three defensive mechanisms are typical of octopuses, yet the Mimic Octopus goes even further than that.\"");
            sendAnswer1.setEnabled(false);
        } else {
            octopusFact1.setText("\"Something is wrong.\"");
        }
    }

    /**
     * Question Six Logic
     **/

    public void onClick1(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        TextView octopusFact6 = (TextView) findViewById(R.id.answer6);


        switch (view.getId()) {

            case R.id.type1:
                if (checked)
                    octopusFact6.setText("\"This is a very broad classification. All animals without a backbone belong here.\"");
                else
                    octopusFact6.setText("");
                break;

            case R.id.type2:
                if (checked)
                    octopusFact6.setText("\"Not all mollusks own shells, this classification includes snails and slugs.\"");
                else
                    octopusFact6.setText("");
                break;
            case R.id.type3:
                if (checked)
                    octopusFact6.setText("\"Cephalopods have multiple arms or tentacles, large heads and symmetrical bodies. They live in saltwater.\"");
                else
                    octopusFact6.setText("");
                break;


        }
    }

    /**
     * Question Six submit button
     */

    public void check2(View view) {
        TextView octopusFact6 = (TextView) findViewById(R.id.answer6);

        CheckBox type1 = findViewById(R.id.type1);
        boolean option1 = type1.isChecked();

        CheckBox type2 = findViewById(R.id.type2);
        boolean option2 = type2.isChecked();

        CheckBox type3 = findViewById(R.id.type3);
        boolean option3 = type3.isChecked();


        if (option1 && option2 && option3) {
            octopusFact6.setText("\"Good Job!! Octopuses belong to the order Octopoda which belong to the cephalopod's class. This means they are both mollusks and invertebrates\"");
        } else {
            octopusFact6.setText("\"Something is missing\"");
        }

        if (option1 && option2 && option3) {
            Button sendAnswer2 = (Button) findViewById(R.id.send2);
            sendAnswer2.setEnabled(false);
            setTestScore();

        }
    }

    /****/
    public void radioButtonQ7(View view) {
        TextView octopusFact7 = (TextView) findViewById(R.id.answer7);

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.hellYeah1:

                if (checked)
                    octopusFact7.setText("\"The bite from an Octopus has a very powerful venom to paralyze their prey. This venom is generally not harmful to humans except for some species like  the lethal poison of the Blue Ring Octopus.\"");
                Toast.makeText(getApplicationContext(), "Good job!!", Toast.LENGTH_SHORT).show();
                setTestScore();

                disableGroup3();
                break;
            case R.id.naynay1:
                if (checked)
                    octopusFact7.setText(null);
                Toast.makeText(getApplicationContext(), "Try Again!!", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void disableGroup3() {
        RadioGroup radioCheck = (RadioGroup) findViewById(R.id.radioG3);
        for (int i = 0; i < radioCheck.getChildCount(); i++) {
            radioCheck.getChildAt(i).setEnabled(false);
        }
    }

    /*** Question Eight logic*/
    public void decrease1(View view) {

        TextView octopusFact8 = (TextView) findViewById(R.id.answer8);
        if (speed == 25) {
            return;
        }
        if (speed == 0) {
            Toast.makeText(getApplicationContext(), "Faster!", Toast.LENGTH_SHORT).show();
            return;
        }

        speed = speed - 5;
        Toast.makeText(getApplicationContext(), "Faster!", Toast.LENGTH_SHORT).show();
        display1(speed);
        octopusFact8.setText("");
    }

    public void increase1(View view) {
        TextView octopusFact8 = (TextView) findViewById(R.id.answer8);

        if (speed > 20) {
            return;
        }
        if (speed < 20) {
            octopusFact8.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Good Job!!", Toast.LENGTH_SHORT).show();
            octopusFact8.setText("Octopuses swim by sucking water and then expelling it. I like to call that technique \"Octo-propulsion\"");
            setTestScore();

        }
        speed = speed + 5;
        display1(speed);
    }

    public void display1(int speed) {
        TextView octopusSpeed = (TextView) findViewById(R.id.speed);
        octopusSpeed.setText(speed + " mph");
    }

    private void setTestScore() {
        score = score + 1;
        return;
    }

    private void wrongAnswer() {
        score = score - 1;
        return;
    }

    /**
     * Submit answers button
     **/
    public void yasYouMadeIt(View view) {
        TextView theEnd = (TextView) findViewById(R.id.doneView);
        if (score >= 7) {
            displayScore(score);
            theEnd.setText("\"Octotastic!! Now you are an Octopus expert\"");
        } else {
            displayScore(score);
            theEnd.setText("\"Something is missing, you can go back and review your answers\"");
        }
    }

    /**
     * reset all views button
     **/
    public void wipeItOff(View view) {

        //Clear all int and Global score //
        speed = 0;
        quantity_q1 = 0;
        score = 0;
        display1(speed);
        display(quantity_q1);
        displayScore(score);

        //Clear facts from all textViews//
        TextView octopusFact1 = (TextView) findViewById(R.id.answer1);
        TextView octopusFact2 = (TextView) findViewById(R.id.answer2);
        TextView octopusFact3 = (TextView) findViewById(R.id.answer3);
        TextView octopusFact4 = (TextView) findViewById(R.id.answer4);
        TextView octopusFact5 = (TextView) findViewById(R.id.answer5);
        TextView octopusFact6 = (TextView) findViewById(R.id.answer6);
        TextView octopusFact7 = (TextView) findViewById(R.id.answer7);
        TextView octopusFact8 = (TextView) findViewById(R.id.answer8);
        EditText answer_field = (EditText) findViewById(R.id.answer_field);
        TextView theEnd = (TextView) findViewById(R.id.doneView);
        TextView scoring = (TextView) findViewById(R.id.scoree);

        octopusFact1.setText(null);
        octopusFact2.setText(null);
        octopusFact3.setText(null);
        octopusFact4.setText(null);
        octopusFact5.setText(null);
        octopusFact6.setText(null);
        octopusFact7.setText(null);
        octopusFact8.setText(null);
        answer_field.setText(null);
        theEnd.setText(null);
        scoring.setText(null);

        enableRadioG();
        enableButtons();
        unCheckBoxes();

    }

    //Enable Question 3, Question 4 and Question 6 Buttons//
    private void enableButtons() {
        Button sendAnswer = (Button) findViewById(R.id.send);
        Button sendAnswer1 = (Button) findViewById(R.id.send1);
        Button sendAnswer2 = (Button) findViewById(R.id.send2);
        sendAnswer.setEnabled(true);
        sendAnswer1.setEnabled(true);
        sendAnswer2.setEnabled(true);

    }

    //Clear Checkboxes Question 5 and Question 6//
    private void unCheckBoxes() {
        CheckBox mecha1 = findViewById(R.id.mecha1);
        CheckBox mecha2 = findViewById(R.id.mecha2);
        CheckBox mecha3 = findViewById(R.id.mecha3);
        CheckBox mecha4 = findViewById(R.id.mecha4);

        CheckBox type1 = findViewById(R.id.type1);
        CheckBox type2 = findViewById(R.id.type2);
        CheckBox type3 = findViewById(R.id.type3);

        mecha1.setChecked(false);
        mecha2.setChecked(false);
        mecha3.setChecked(false);
        mecha4.setChecked(false);

        type1.setChecked(false);
        type2.setChecked(false);
        type3.setChecked(false);
    }

    //Enable RadioGroup Question 2, Question 4 and Question 6//
    private void enableRadioG() {

        RadioGroup radioCheck1 = (RadioGroup) findViewById(R.id.radioG1);
        RadioGroup radioCheck2 = (RadioGroup) findViewById(R.id.radioG2);
        RadioGroup radioCheck3 = (RadioGroup) findViewById(R.id.radioG3);
        radioCheck1.clearCheck();
        radioCheck2.clearCheck();
        radioCheck3.clearCheck();

        for (int i = 0; i < radioCheck1.getChildCount(); i++) {
            radioCheck1.getChildAt(i).setEnabled(true);
        }
        for (int i = 0; i < radioCheck2.getChildCount(); i++) {
            radioCheck2.getChildAt(i).setEnabled(true);
        }
        for (int i = 0; i < radioCheck3.getChildCount(); i++) {
            radioCheck3.getChildAt(i).setEnabled(true);
        }
    }

    public void displayScore(int score) {
        TextView scoring = (TextView) findViewById(R.id.scoree);
        scoring.setText(score + " out of 8");
    }
}


