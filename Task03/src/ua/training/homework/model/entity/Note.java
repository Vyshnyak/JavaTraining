package ua.training.homework.model.entity;

import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Note entity that consists of the multiple fields represented
 * as person's information
 */
public class Note implements Cloneable {
    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private String nickname;
    private String comment;
    private Group group;
    private String homePhone;
    private String cellPhone;
    private String secondCellPhone;
    private String email;
    private String skype;
    private Address address;
    private String fullAddress;
    private Date additionDate;
    private Date lastChangeDate;

    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat(Constants.DATE_PATTERN);

    public Note(String lastName, String firstName, String middleName,
                String nickname, String comment, Group group, String homePhone,
                String cellPhone, String secondCellPhone, String email, String skype, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        setFullName();
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.secondCellPhone = secondCellPhone;
        this.email = email;
        this.skype = skype;
        this.address = address;
        setFullAddress();
        this.additionDate = new Date();
        this.lastChangeDate = additionDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return fullName;
    }

    /**
     * Sets a full name information by concatenating the last name with
     * the first letter of the first name
     */
    public void setFullName() {
        fullName = lastName +
                Constants.SPACE +
                firstName.charAt(Constants.ZERO) +
                Constants.DOT;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setSecondCellPhone(String secondCellPhone) {
        this.secondCellPhone = secondCellPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Sets a full address that consists of all address fields (index, city,
     * street, house number, apartment number)
     */
    public void setFullAddress() {
        fullAddress = address.toString();
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public Note clone() throws CloneNotSupportedException {
        return (Note) super.clone();
    }

    /**
     * Builds and returns a string represented as a menu of the note fields.
     * This method builds and return menu that can be used only for reading
     *
     * @return  string that is represented as a read-menu list of note fields
     */
    public String getReadElementMenu() {
        return View.menuBuilder(View.bundle.getString(Constants.LAST_NAME) + lastName,
                View.bundle.getString(Constants.FIRST_NAME) + firstName,
                View.bundle.getString(Constants.MIDDLE_NAME) + middleName,
                View.bundle.getString(Constants.NICKNAME) + nickname,
                View.bundle.getString(Constants.COMMENT) + comment,
                View.bundle.getString(Constants.GROUP) + group,
                View.bundle.getString(Constants.HOME_PHONE) + homePhone,
                View.bundle.getString(Constants.CELL_PHONE_ONE) + cellPhone,
                View.bundle.getString(Constants.CELL_PHONE_TWO) + secondCellPhone,
                View.bundle.getString(Constants.EMAIL) + email,
                View.bundle.getString(Constants.SKYPE) + skype,
                View.bundle.getString(Constants.ADDRESS) + fullAddress,
                View.bundle.getString(Constants.ADDITION_DATE) + dateFormat.format(additionDate),
                View.bundle.getString(Constants.LAST_UPDATE_DATE) + dateFormat.format(lastChangeDate));
    }

    /**
     * Builds and returns a string represented as a menu of the note fields.
     * This method builds and return menu that can be used for updating
     *
     * @return  string that is represented as a update-menu list of note fields
     */
    public String getUpdateElementMenu() {
        return View.menuBuilder(View.bundle.getString(Constants.LAST_NAME) + lastName,
                        View.bundle.getString(Constants.FIRST_NAME) + firstName,
                        View.bundle.getString(Constants.MIDDLE_NAME) + middleName,
                        View.bundle.getString(Constants.NICKNAME) + nickname,
                        View.bundle.getString(Constants.COMMENT) + comment,
                        View.bundle.getString(Constants.GROUP) + group,
                        View.bundle.getString(Constants.HOME_PHONE) + homePhone,
                        View.bundle.getString(Constants.CELL_PHONE_ONE) + cellPhone,
                        View.bundle.getString(Constants.CELL_PHONE_TWO) + secondCellPhone,
                        View.bundle.getString(Constants.EMAIL) + email,
                        View.bundle.getString(Constants.SKYPE) + skype,
                        View.bundle.getString(Constants.ADDRESS) + fullAddress);
    }
}
