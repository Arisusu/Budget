package com.example.budget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.budget.ui.Budget;

public class MainActivity extends AppCompatActivity {
    private TextView signUpBtn;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);

        signUpBtn = findViewById(R.id.login);
        signUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                User owo = new User();
                NextActivity(owo);
            }
        });

    }

    private void NextActivity(User user){
        Intent intent = new Intent(MainActivity.this, Budget.class );
        intent.putExtra("USER_OBJECT", user);
        startActivity(intent);
    }

}