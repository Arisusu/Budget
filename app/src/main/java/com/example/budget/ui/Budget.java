package com.example.budget.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.budget.R;
import com.example.budget.User;

public class Budget extends AppCompatActivity {
    private Button searchMenu;
    private Button inputMenu;
    private User user;
    private Button update;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        setContentView(R.layout.budget);
        updateGraph();

        update = findViewById(R.id.updateGraph);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText moneySpentText = findViewById(R.id.moneySpent);
                double moneySpent = Double.parseDouble(moneySpentText.getText().toString());
                user.spentMoney(moneySpent);
                updateGraph();
                moneySpentText.setText("");
                moneySpentText.clearFocus();
            }
        });

        searchMenu = findViewById(R.id.search);
        searchMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, Search.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

        inputMenu = findViewById(R.id.input);
        inputMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, Input.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

    }
    public void updateGraph() {
        TextView sched = findViewById(R.id.daysLeft);
        if (user.getSchedule() == 0) {
            sched.setText(getResources().getString(R.string.budget_7daysLeft));
        } else if (user.getSchedule() == 1){
            sched.setText(getResources().getString(R.string.budget_30daysLeft));
        } else {
            sched.setText(getResources().getString(R.string.budget_daysLeft));
        }
        TextView remBudget = findViewById(R.id.remBudgetText);
        remBudget.setText(String.valueOf(user.getCurrentBudget()));
        System.out.println(user.getCurrentBudget());
        ProgressBar pieChart = findViewById(R.id.stats_progressbar);
        double d = user.getCurrentBudget()/user.getTotalBudget();
        int progress = (int) (d * 100);
        pieChart.setProgress(progress);
    }

}
