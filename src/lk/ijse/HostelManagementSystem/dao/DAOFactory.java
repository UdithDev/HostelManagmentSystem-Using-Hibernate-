package lk.ijse.HostelManagementSystem.dao;

import lk.ijse.HostelManagementSystem.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;

    public DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,RESERVATION
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
