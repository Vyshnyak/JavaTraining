package ua.training.homework.bean;

import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Note bean that consists of the multiple fields represented
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

    /**
     * Sets the last name information to the corresponding note field
     *
     * @param  lastName  a last name of the person to be put in the note field
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the first name information to the corresponding note field
     *
     * @param  firstName  a first name of the person to be put in the note field
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the middle name information to the corresponding note field
     *
     * @param  middleName  a middle name of the person to be put in the note field
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns a full name information that is consisting of the last name
     * and the first letter of the first name
     *
     * @return  the string of a full name (last name + firs letter of the name)
     */
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

    /**
     * Sets a nickname information to the corresponding field
     *
     * @param  nickname  a nickname of the person to be put in the note field
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Sets a comment about corresponding note
     *
     * @param  comment  a comment about a note to be put in the note field
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Sets group information to the corresponding note field
     *
     * @param  group  a group to be put in the note field
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Sets home phone information to the corresponding field
     *
     * @param  homePhone  a home phone of the person to be put in the note field
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Sets a cell phone information to the corresponding note field
     *
     * @param  cellPhone  a person's cell phone to be put in the note field
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * Sets an additional cell phone information to the corresponding note field
     *
     * @param  secondCellPhone  a person's cell phone to be put in the note field
     */
    public void setSecondCellPhone(String secondCellPhone) {
        this.secondCellPhone = secondCellPhone;
    }

    /**
     * Sets an email information to the corresponding note field
     *
     * @param  email  a person's email to be put in the note field
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the skype name information to the corresponding note field
     *
     * @param  skype  a person's skype to be put in the note field
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }

    /**
     * Sets the person's address information to the corresponding note field
     *
     * @param  address  a person's address to be put in the note field
     */
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

    /**
     * Sets the date of the last note's modifying
     *
     * @param  lastChangeDate  a date of the last note change to be put in t
     *                         he note field
     */
    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    /**
     * Clones this note object so it can't be change out from the class area
     *
     * @return  the clone of the note object from which this method was called
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     */
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
