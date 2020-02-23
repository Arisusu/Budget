package com.example.budget;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable{
    private String uniqueID = "";
    private double totalBudget;
    private double currentBudget;
    private int numPeople;
    private int moneySaved;
    private int schedule;
    private int strawNum;
    private int spinNum;
    private int carrotNum;
    private double totalCost;

    /**
     * Creates a new User
     * Pushes a generic user to FireBase
     */
    public User(){
        DatabaseReference temp = FirebaseDatabase.getInstance().getReference().push();
        HashMap<String, Integer> dataMap = new HashMap<>();
        dataMap.put("totalBudget", 0);
        dataMap.put("currentBudget", 0);
        dataMap.put("numPeople", 1);
        dataMap.put("moneySaved", 0);
        dataMap.put("schedule", 0);
        temp.setValue(dataMap);
        uniqueID = temp.getKey();
        schedule = 2;
    }

    //schedule: monthly is stored as 1, weekly is stored as 0
    public void update(double totalBudget, int numPeople, int schedule){
        DatabaseReference temp = FirebaseDatabase.getInstance().getReference();
        this.totalBudget = Math.round(totalBudget * 100.0) / 100.0;;
        this.numPeople = numPeople;
        this.schedule = schedule;
        currentBudget = totalBudget;
        System.out.println(temp.child(uniqueID).child("totalBudget").setValue(this.totalBudget));
        System.out.println(temp.child(uniqueID).child("numPeople").setValue(numPeople));
        System.out.println(temp.child(uniqueID).child("currentBudget").setValue(this.totalBudget));
        System.out.println(temp.child(uniqueID).child("schedule").setValue(schedule));
    }

    public void setMoneySaved(int num) {
        moneySaved = num;
    }
    public void spentMoney(double num) {
        DatabaseReference temp = FirebaseDatabase.getInstance().getReference();
        currentBudget = Math.round((currentBudget - num) * 100.0) / 100.0;
        System.out.println(temp.child(uniqueID).child("currentBudget").setValue(currentBudget));
    }
    public String getUniqueID() {
        return uniqueID;
    }

    public double getTotalBudget(){
        return totalBudget;
    }

    public double getCurrentBudget() {
        return currentBudget;
    }
    public int getSchedule() {
        return schedule;
    }

    public void setStrawNum(int num) {
        strawNum = num;
    }

    public void setSpinNum(int spinNum) {
        this.spinNum = spinNum;
    }

    public void setCarrotNum(int carrotNum) {
        this.carrotNum = carrotNum;
    }

    public int getCarrotNum() {
        return carrotNum;
    }

    public int getSpinNum() {
        return spinNum;
    }

    public int getStrawNum() {
        return strawNum;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}