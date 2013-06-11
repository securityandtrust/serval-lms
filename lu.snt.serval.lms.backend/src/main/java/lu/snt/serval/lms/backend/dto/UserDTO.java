package lu.snt.serval.lms.backend.dto;

import lu.snt.serval.lms.framework.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserDTO {

    private String login, password, name, mail, phone;
    private int id_user;

    public UserDTO() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * main constructor
     *
     * @param user     login name
     * @param password password
     */
    public UserDTO(String user, String password) {
        this.login = user;
        this.password = password;
    }

    public UserDTO(User user) {
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        setName(user.getName());
        setMail(user.getMail());
        setPhone(user.getPhone());
        setId_user(user.getUserId());
    }

    // accessors and modifiers
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void getUser() {

        User user = new User();


        user.setLogin(getLogin());
        user.setPassword(getPassword());
        user.setName(getName());
        user.setMail(getMail());
        user.setPhone(getPhone());
        user.setUserId(getId_user());

    }


    public void setReservationsFromDTOs(Collection<BookDTO> dtos)   {

        // init the reservation list
        reservations = new ArrayList<Book>();

        //creates books and put them in reservations
        for (Iterator<BookDTO> iterator = dtos.iterator(); iterator.hasNext();) {
            reservations.add(new Book(iterator.next()));
        }

    }
    public void setBorrowedFromDTOs(Collection<BookDTO> dtos)   {

        // init the reservation list
        borrowed = new ArrayList<Book>();

        //creates books and put them in reservations
        for (Iterator<BookDTO> iterator = dtos.iterator(); iterator.hasNext();) {
            borrowed.add(new Book(iterator.next()));
        }

    }




}
