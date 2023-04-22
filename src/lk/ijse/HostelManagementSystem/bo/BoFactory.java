package lk.ijse.HostelManagementSystem.bo;

import lk.ijse.HostelManagementSystem.bo.custom.impl.StudentBoImpl;

public class BoFactory {
    public static BoFactory boFactory;


    public BoFactory() {
    }

    public BoFactory  getBoFactory(){
        if (boFactory==null){
            boFactory=new BoFactory ();
        }
        return boFactory;
    }

    public enum BOTypes{
        STUDENT,ROOM,RESERVATION
    }

    public static SuperBo getBo(BOTypes boTypes) {
        switch (boTypes){
            case STUDENT:
                return  new StudentBoImpl();
            case ROOM:
            default:
                return null;
        }
    }
}
