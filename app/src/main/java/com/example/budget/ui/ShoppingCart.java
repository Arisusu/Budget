package com.example.budget.ui;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.budget.R;
import com.example.budget.User;


public class ShoppingCart extends AppCompatActivity {
    private Button back;
    private User user;
    private TextView totalCost;
    private TextView label1;
    private TextView label2;
    private TextView label3;
    private TextView cost1;
    private TextView cost2;
    private TextView cost3;
    private ImageView car1;
    private ImageView car2;
    private ImageView car3;
    private ImageView spin1;
    private ImageView spin2;
    private ImageView straw1;
    private double calories;
    private double protein;
    private double vE;
    private double VB6;
    private double iron;
    private TextView calorieVal;
    private TextView vEVal;
    private TextView proteinVal;
    private TextView vB6Val;
    private TextView ironVal;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        setContentView(R.layout.shoppingcart);
        totalCost = findViewById(R.id.totalCost);
        label1 = findViewById(R.id.Label1);
        label2 = findViewById(R.id.Label2);
        label3 = findViewById(R.id.Label3);
        cost1 = findViewById(R.id.cost1);
        cost2 = findViewById(R.id.cost2);
        cost3 = findViewById(R.id.cost3);
        car1 = findViewById(R.id.car1);
        car2 = findViewById(R.id.car2);
        car3 = findViewById(R.id.car3);
        spin1 = findViewById(R.id.spin1);
        spin2 = findViewById(R.id.spin2);
        straw1 = findViewById(R.id.straw1);

        reset();
        update();
        showNutrition();

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCart.this, Search.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

    }

    public void showNutrition() {
        calorieVal = findViewById(R.id.calorieVal);
        vEVal = findViewById(R.id.vEVal);
        proteinVal = findViewById(R.id.proteinVal);
        vB6Val = findViewById(R.id.vB6Val);
        ironVal = findViewById(R.id.ironVal);
        calories = (72.6 * user.getStrawNum())
                + (47.6 * user.getSpinNum())
                + (93 * user.getCarrotNum());
        protein = (1.5 * user.getStrawNum())
                + (3.8 * user.getSpinNum())
                + (2.1 * user.getCarrotNum());
        vE = (1.5 * user.getCarrotNum());
        VB6 = (0.1 * user.getStrawNum())
                + (0.3 * user.getCarrotNum());
        iron = (0.6 * user.getStrawNum())
                + (3.4 * user.getSpinNum())
                + (0.7 * user.getCarrotNum());
        calories = Math.round(calories * 100.0) / 100.0;
        protein = Math.round(protein * 100.0) / 100.0;
        vE = Math.round(vE * 100.0) / 100.0;
        VB6 = Math.round(VB6 * 100.0) / 100.0;
        iron = Math.round(iron * 100.0) / 100.0;
        calorieVal.setText(calories + "/1400");
        vEVal.setText(vE + "/105");
        proteinVal.setText(protein + "/350");
        vB6Val.setText(VB6 + "/11.9");
        ironVal.setText(iron + "/126");

    }

    public void reset() {
        label1.setVisibility(View.INVISIBLE);
        label2.setVisibility(View.INVISIBLE);
        label3.setVisibility(View.INVISIBLE);
        cost1.setVisibility(View.INVISIBLE);
        cost2.setVisibility(View.INVISIBLE);
        cost3.setVisibility(View.INVISIBLE);
        car1.setVisibility(View.INVISIBLE);
        car2.setVisibility(View.INVISIBLE);
        car3.setVisibility(View.INVISIBLE);
        spin1.setVisibility(View.INVISIBLE);
        spin2.setVisibility(View.INVISIBLE);
        straw1.setVisibility(View.INVISIBLE);
    }

    public void update() {
        String strawNum = String.valueOf(user.getStrawNum());
        String spinNum = String.valueOf(user.getSpinNum());
        String carrotNum = String.valueOf(user.getCarrotNum());

        if (strawNum.equals("0") && spinNum.equals("0") && carrotNum.equals("0")) {
            //everything is 0
        } else if (strawNum.equals("0") && spinNum.equals("0")) {
            //only show carrot
            label1.setText("Carrots");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(carrotNum);
            cost1.setVisibility(View.VISIBLE);
            car1.setVisibility(View.VISIBLE);
        } else if (strawNum.equals("0") && carrotNum.equals("0")) {
            //only show spinach
            label1.setText("Spinach");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(spinNum);
            cost1.setVisibility(View.VISIBLE);
            spin1.setVisibility(View.VISIBLE);
        } else if (spinNum.equals("0") && carrotNum.equals("0")) {
            //only show strawberry
            label1.setText("Strawberry");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(strawNum);
            cost1.setVisibility(View.VISIBLE);
            straw1.setVisibility(View.VISIBLE);
        } else if (strawNum.equals("0")) {
            //show spinach and carrot
            label1.setText("Spinach");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(spinNum);
            cost1.setVisibility(View.VISIBLE);
            spin1.setVisibility(View.VISIBLE);

            label2.setText("Carrots");
            label2.setVisibility(View.VISIBLE);
            cost2.setText(carrotNum);
            cost2.setVisibility(View.VISIBLE);
            car2.setVisibility(View.VISIBLE);
        } else if (spinNum.equals("0")) {
            //show strawberry and carrot
            label1.setText("Strawberry");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(strawNum);
            cost1.setVisibility(View.VISIBLE);
            straw1.setVisibility(View.VISIBLE);

            label2.setText("Carrots");
            label2.setVisibility(View.VISIBLE);
            cost2.setText(carrotNum);
            cost2.setVisibility(View.VISIBLE);
            car2.setVisibility(View.VISIBLE);
        } else if (carrotNum.equals("0")) {
            //show strawberry and spinach
            label1.setText("Strawberry");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(strawNum);
            cost1.setVisibility(View.VISIBLE);
            straw1.setVisibility(View.VISIBLE);

            label2.setText("Spinach");
            label2.setVisibility(View.VISIBLE);
            cost2.setText(spinNum);
            cost2.setVisibility(View.VISIBLE);
            spin2.setVisibility(View.VISIBLE);
        } else {
            label1.setText("Strawberry");
            label1.setVisibility(View.VISIBLE);
            cost1.setText(strawNum);
            cost1.setVisibility(View.VISIBLE);
            straw1.setVisibility(View.VISIBLE);

            label2.setText("Spinach");
            label2.setVisibility(View.VISIBLE);
            cost2.setText(spinNum);
            cost2.setVisibility(View.VISIBLE);
            spin2.setVisibility(View.VISIBLE);

            label3.setText("Carrots");
            label3.setVisibility(View.VISIBLE);
            cost3.setText(carrotNum);
            cost3.setVisibility(View.VISIBLE);
            car3.setVisibility(View.VISIBLE);
        }
        totalCost.setText(String.valueOf(user.getTotalCost()));
    }
}