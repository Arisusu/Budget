package com.example.budget.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.budget.Cart;
import com.example.budget.R;
import com.example.budget.User;


public class Search extends AppCompatActivity {
    private Button budgetMenu;
    private Button inputMenu;
    private User user;
    private Button addCarrot;
    private Button addSpinach;
    private Button addStrawberry;
    private Button shoppingCartMenu;
    private Cart cart;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        setContentView(R.layout.search);
        cart = new Cart();

        addCarrot = findViewById(R.id.addCarrot);
        addCarrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.addItem("Carrot");
            }
        });

        addSpinach = findViewById(R.id.addSpinach);
        addSpinach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.addItem("Spinach");
            }
        });

        addStrawberry = findViewById(R.id.addStraw);
        addStrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.addItem("Strawberry");
            }
        });

        budgetMenu = findViewById(R.id.budget);
        budgetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, Budget.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

        inputMenu = findViewById(R.id.input);
        inputMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, Input.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

        shoppingCartMenu = findViewById(R.id.shoppingCart);
        shoppingCartMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setStrawNum(cart.getCart().get("Strawberry"));
                user.setCarrotNum(cart.getCart().get("Carrot"));
                user.setSpinNum(cart.getCart().get("Spinach"));
                user.setTotalCost(cart.calcCost());
                Intent intent = new Intent(Search.this, ShoppingCart.class );
                intent.putExtra("USER_OBJECT", user);
                startActivity(intent);
            }
        });

    }
}