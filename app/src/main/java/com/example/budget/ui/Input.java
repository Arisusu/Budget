package com.example.budget.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.budget.R;
import com.example.budget.User;


public class Input extends AppCompatActivity {
    private Button budgetMenu;
    private Button searchMenu;
    private Button update;
    private User user;
    private EditText budgetAmount;
    private EditText numPeople;
    private RadioGroup schedule;
    private EditText updatedText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        setContentView(R.layout.input);


        budgetMenu = findViewById(R.id.budget);
        budgetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Input.this, Budget.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

        searchMenu = findViewById(R.id.search);
        searchMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Input.this, Search.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });
        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetAmount = findViewById(R.id.budgetAmount);
                numPeople = findViewById(R.id.numPeople);
                schedule = findViewById(R.id.radioGroup);
                int id = schedule.getCheckedRadioButtonId();
                //monthly checked
                if(id == 2131230894) {
                    user.update(Double.parseDouble(budgetAmount.getText().toString()),
                            Integer.parseInt(numPeople.getText().toString()), 1);
                } else {
                    user.update(Double.parseDouble(budgetAmount.getText().toString()),
                            Integer.parseInt(numPeople.getText().toString()), 0);
                }

                TextView updatedText = findViewById(R.id.input_updatedText);
                updatedText.setVisibility(View.VISIBLE);
                budgetAmount.clearFocus();
                budgetAmount.setText("");
                numPeople.clearFocus();
                numPeople.setText("");
                schedule.clearCheck();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.weekly:
                if (checked)
                    System.out.println("weekly checked");
                    break;
            case R.id.monthly:
                if (checked)
                    System.out.println("monthly checked");
                    break;
        }
    }


}
