package org.example;

import java.util.ArrayList;

public class DAOImpl implements DAO{

//    private static  DAOImpl instance;
//
//    private DAOImpl() {
//    }
//
//    public static DAOImpl getInstance() {
//        if (instance == null) {
//            instance = new DAOImpl();
//        }
//        return instance;
//    }
//    DAO myDAO = DAOImpl.getInstance();


//    я так и не понял надо ли делать методы  или это уже выполнено задание

    @Override
    public ReceiverDTO getReceiver(int num) {
        return null;
    }

    @Override
    public ArrayList<ReceiverDTO> getReceiver() {
        return null;
    }

    @Override
    public ExpenseDTO getExpence(int num) {
        return null;
    }

    @Override
    public ArrayList<ExpenseDTO> getExpenses() {
        return null;
    }


    @Override
    public int addReceiver(ReceiverDTO receiver) {
        return 0;
    }

    @Override
    public int addExpense(ExpenseDTO expense) {
        return 0;
    }
}
