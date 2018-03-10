package ua.training.homework.controller;

/**
 * Regular Expression patterns
 */
public interface RegExp {
    String LAST_NAME = "^[A-Za-zА-Яа-я'іІїЇ]+$";
    String FIRST_NAME = "^[A-Za-zА-Яа-я'іІїЇ]+$";
    String MIDDLE_NAME = "^[A-Za-zА-Яа-я'іІїЇ]+$";
    String NICKNAME = "^([A-Za-zА-Яа-я'іІїЇ]+[0-9-_\\.])*[A-Za-zА-Яа-я'іІїЇ]+[0-9]*$";
    String COMMENT = "^([\\wА-Яа-я'іІїЇ]+\\s)*[\\wА-Яа-я'іІїЇ]+$";
    String GROUP = "(Friends|Colleagues|Siblings)";
    String HOME_PHONE = "^\\+?\\d*(\\(\\d{3}\\))?(\\d+-?){0,2}\\d+$";
    String CELL_PHONE = "^\\+?\\d*(\\(\\d{3}\\))?(\\d+-?){0,2}\\d+$";
    String EMAIL = "^([\\w!#$%&'*+\\-/=?^`{|}~]+\\.)*[\\w!#$%&'*+\\-/=?^`{|}~]+@([A-Za-z0-9]+\\-)*[A-Za-z0-9]+\\.(com|ua|net|ru)$";
    String SKYPE = "^([A-Za-zА-Яа-я'іІїЇ]+[0-9-_\\.])*[A-Za-zА-Яа-я'іІїЇ]+[0-9]*$";
    String INDEX = "^\\d+$";
    String CITY = "^([A-Za-zА-Яа-я'іІїЇ]+\\-)*[A-Za-zА-Яа-я'іІїЇ]+$";
    String STREET = "^([A-Za-zА-Яа-я'іІїЇ]+[-.]\\s)*[A-Za-zА-Яа-я'іІїЇ]+[-\\s]?[A-Za-zА-Яа-я'іІїЇ]+$";
    String HOUSE = "^([\\d])+/?[A-Za-zА-Яа-яіІїЇ]?$";
    String APARTMENT = "^\\d+$";

    String LANGUAGE = "^(en|ua)$";

    String YES_NO = "yes.no.regexp";
}
