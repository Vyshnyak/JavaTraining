package ua.training.homework.controller;

/**
 * Regular Expression patterns
 */
public interface RegExp {
    String LAST_NAME = "^[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String FIRST_NAME = "^[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String MIDDLE_NAME = "^[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String NICKNAME = "^(A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[0-9-_\\.])*[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[0-9]*$";
    String COMMENT = "^([\\wА-ЩЬЮЯІЇЄа-щьюяіїє']+\\s)*[\\wА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String GROUP = "(Friends|Colleagues|Siblings)";
    String HOME_PHONE = "^\\+?\\d*(\\(\\d{3}\\))?(\\d+-?){0,2}\\d+$";
    String CELL_PHONE_ONE = "^\\+?\\d*(\\(\\d{3}\\))?(\\d+-?){0,2}\\d+$";
    String SECOND_CELL_TWO = "(^\\+?\\d*(\\(\\d{3}\\))?(\\d+-?){0,2}\\d+)?$";
    String EMAIL = "^([\\w!#$%&'*+\\-/=?^`{|}~]+\\.)*[\\w!#$%&'*+\\-/=?^`{|}~]+@([A-Za-z0-9]+\\-)*[A-Za-z0-9]+\\.(com|ua|net|ru)$";
    String SKYPE = "^([A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[0-9-_\\.])*[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[0-9]*$";
    String INDEX = "^\\d+$";
    String CITY = "^([A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+\\-)*[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String STREET = "^([A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[-.]\\s)*[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+[-\\s]?[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']+$";
    String HOUSE = "^([\\d])+/?[A-Za-zА-ЩЬЮЯІЇЄа-щьюяіїє']?$";
    String APARTMENT = "^\\d+$";

    String LANGUAGE = "^(en|ua)$";

    String YES_NO = "yes.no.regexp";
}
