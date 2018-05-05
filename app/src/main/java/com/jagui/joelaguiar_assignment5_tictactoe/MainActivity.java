package com.jagui.joelaguiar_assignment5_tictactoe;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class MainActivity extends Activity implements OnClickListener{

    // Variables for the widgets
    private Button newgame;
    private TextView status;
    private Button ul;
    private Button um;
    private Button ur;
    private Button ml;
    private Button mm;
    private Button mr;
    private Button bl;
    private Button bm;
    private Button br;
    private float counter = 1;
    private boolean gameover = false;

    private SharedPreferences savedValues;

    private String ulString;
    private String umString;
    private String urString;
    private String mlString;
    private String mmString;
    private String mrString;
    private String blString;
    private String bmString;
    private String brString;
    private String statusString;
    private String gameoverString;
    private String counterString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the widget
        newgame = (Button) findViewById(R.id.newgame);
        status = (TextView) findViewById(R.id.status);
        ul = (Button) findViewById(R.id.ul);
        um = (Button) findViewById(R.id.um);
        ur = (Button) findViewById(R.id.ur);
        ml = (Button) findViewById(R.id.ml);
        mm = (Button) findViewById(R.id.mm);
        mr = (Button) findViewById(R.id.mr);
        bl = (Button) findViewById(R.id.bl);
        bm = (Button) findViewById(R.id.bm);
        br = (Button) findViewById(R.id.br);

        //Set the listener
        newgame.setOnClickListener(this);
        ul.setOnClickListener(this);
        um.setOnClickListener(this);
        ur.setOnClickListener(this);
        ml.setOnClickListener(this);
        mm.setOnClickListener(this);
        mr.setOnClickListener(this);
        bl.setOnClickListener(this);
        bm.setOnClickListener(this);
        br.setOnClickListener(this);

        status.setText("Player X's turn");

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    } //END of oncreate()

    public void calculateAndDisplay(){

        ulString = ul.getText().toString();
        umString = um.getText().toString();
        urString = ur.getText().toString();
        mlString = ml.getText().toString();
        mmString = mm.getText().toString();
        mrString = mr.getText().toString();
        blString = bl.getText().toString();
        bmString = bm.getText().toString();
        brString = br.getText().toString();
        statusString = status.getText().toString();
        gameoverString = String.valueOf(gameover);
        counterString = Float.toString(counter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newgame:
                eraseall();
                calculateAndDisplay();
                break;
            case R.id.ul:
                playgame(ul);
                calculateAndDisplay();
                break;
            case R.id.um:
                playgame(um);
                calculateAndDisplay();
                break;
            case R.id.ur:
                playgame(ur);
                calculateAndDisplay();
                break;
            case R.id.ml:
                playgame(ml);
                calculateAndDisplay();
                break;
            case R.id.mm:
                playgame(mm);
                calculateAndDisplay();
                break;
            case R.id.mr:
                playgame(mr);
                calculateAndDisplay();
                break;
            case R.id.bl:
                playgame(bl);
                calculateAndDisplay();
                break;
            case R.id.bm:
                playgame(bm);
                calculateAndDisplay();
                break;
            case R.id.br:
                playgame(br);
                calculateAndDisplay();
                break;

        }

    }

    public void eraseall(){
        ur.setText("");
        um.setText("");
        ul.setText("");
        ml.setText("");
        mm.setText("");
        mr.setText("");
        bl.setText("");
        bm.setText("");
        br.setText("");
        counter = 1;
        gameover = false;
        status.setText("Player X's turn");
        calculateAndDisplay();
    }

    public void playgame(Button b){
        if (!gameover){
            if (counter == 1){
                b.setText("X");
                status.setText(win("X"));
                counter += 1;
            } else if (counter == 2){
                b.setText("O");
                status.setText(win("O"));
                counter += 1;
            } else if (counter == 3){
                b.setText("X");
                status.setText(win("X"));
                counter += 1;
            } else if (counter == 4){
                b.setText("O");
                status.setText(win("O"));
                counter += 1;
            } else if (counter == 5){
                b.setText("X");
                status.setText(win("X"));
                counter += 1;
            } else if (counter == 6){
                b.setText("O");
                status.setText(win("O"));
                counter += 1;
            } else if (counter == 7){
                b.setText("X");
                status.setText(win("X"));
                counter += 1;
            } else if (counter == 8){
                b.setText("O");
                status.setText(win("O"));
                counter += 1;
            } else if (counter == 9){
                b.setText("X");
                status.setText(win("X"));
                counter += 1;
            }
        }

    }

    public String win(String xoro){
        if ( //Horizonal win
                (ul.getText().equals(xoro)) && (um.getText().equals(xoro)) && (ur.getText().equals(xoro)) ||
                        (ml.getText().equals(xoro)) && (mm.getText().equals(xoro)) && (mr.getText().equals(xoro)) ||
                        (bl.getText().equals(xoro)) && (bm.getText().equals(xoro)) && (br.getText().equals(xoro)) ||
                        //Vertical win
                        (ul.getText().equals(xoro)) && (ml.getText().equals(xoro)) && (bl.getText().equals(xoro)) ||
                        (um.getText().equals(xoro)) && (mm.getText().equals(xoro)) && (bm.getText().equals(xoro)) ||
                        (ur.getText().equals(xoro)) && (mr.getText().equals(xoro)) && (br.getText().equals(xoro)) ||
                        //Diagonal win
                        (ul.getText().equals(xoro)) && (mm.getText().equals(xoro)) && (br.getText().equals(xoro)) ||
                        (ur.getText().equals(xoro)) && (mm.getText().equals(xoro)) && (bl.getText().equals(xoro))
                ){
            gameover = true;
            return xoro+ " wins!";
        } else if ((counter == 2) || (counter == 4) || (counter == 6) || (counter == 8)) {
            return "Player X's turn";
        } else if (counter == 9){
            return "Tie game";
        } else {
            return "Player O's turn";
        }
    }

    //SAVE and RESTORE VALUES
    @Override
    public void onPause() {
        Editor editor = savedValues.edit();
        editor.putString("ulString", ulString);
        editor.putString("umString", umString);
        editor.putString("urString", urString);
        editor.putString("mlString", mlString);
        editor.putString("mmString", mmString);
        editor.putString("mrString", mrString);
        editor.putString("blString", blString);
        editor.putString("bmString", bmString);
        editor.putString("brString", brString);
        editor.putString("statusString", statusString);
        editor.putString("gameoverString", gameoverString);
        editor.putString("counterString", counterString);


        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();

        ulString = savedValues.getString("ulString", "");
        ul.setText(ulString);

        umString = savedValues.getString("umString", "");
        um.setText(umString);

        urString = savedValues.getString("urString", "");
        ur.setText(urString);

        mlString = savedValues.getString("mlString", "");
        ml.setText(mlString);

        mmString = savedValues.getString("mmString", "");
        mm.setText(mmString);

        mrString = savedValues.getString("mrString", "");
        mr.setText(mrString);

        blString = savedValues.getString("blString", "");
        bl.setText(blString);

        bmString = savedValues.getString("bmString", "");
        bm.setText(bmString);

        brString = savedValues.getString("brString", "");
        br.setText(brString);

        statusString = savedValues.getString("statusString", "");
        status.setText(statusString);

        gameoverString = savedValues.getString("gameoverString", "");
        gameover = Boolean.valueOf(gameoverString);

        counterString = savedValues.getString("counterString", "");
        counter = Float.parseFloat(counterString);

        calculateAndDisplay();

    }
}

