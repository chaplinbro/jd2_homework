package org.example;


import java.util.ArrayList;

public interface DAO {
    ReceiverDTO getReceiver(int num);
    ArrayList<ReceiverDTO> getReceiver();
    ExpenseDTO getExpence(int num);
    ArrayList<ExpenseDTO> getExpenses();
    int addReceiver(ReceiverDTO receiver);
    int addExpense(ExpenseDTO expense);
}
