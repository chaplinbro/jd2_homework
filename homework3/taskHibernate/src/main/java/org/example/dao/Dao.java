package org.example.dao;

import org.example.pojo.Expense;
import org.example.pojo.Receiver;

import java.util.ArrayList;

public interface Dao {


    int saveReceiver(Receiver receiver);

    int saveExpense(Expense expense);

    ArrayList<Receiver> getReceiver();

    ArrayList<Expense> getExpenses();

    boolean deleteExpense(String id);

    boolean deleteReceiver(String id);

    Receiver getReceiver(int num);

    Expense getExpense(int num);

    Receiver loadReceiver(int num);

    void flush(Receiver receiver);


}
