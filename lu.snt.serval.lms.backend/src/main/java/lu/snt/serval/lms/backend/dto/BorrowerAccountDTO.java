package lu.snt.serval.lms.backend.dto;


import java.util.Date;


public class BorrowerAccountDTO {

    private int id_borrower_account, active, can_borrow, id_user;

    private Date creation_date;


    public BorrowerAccountDTO() {
    }

    public int getId_borrower_account() {
        return id_borrower_account;
    }

    public void setId_borrower_account(int id_borrower_account) {
        this.id_borrower_account = id_borrower_account;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCan_borrow() {
        return can_borrow;
    }

    public void setCan_borrow(int can_borrow) {
        this.can_borrow = can_borrow;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
