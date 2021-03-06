package com.edu.uac.co.newtech_exam2;

public class DbDef {

    public static final String BD_NAME = "USERS_REGISTER";
    public static final String TABLE_NAME = "USERS";
    public static final String ID_COL = "ID";
    public static final String NAME_COL = "NAME";
    public static final String STRATUM_COL = "STRATUM";
    public static final String WAGE_COL = "WAGE";
    public static final String EDUCATION_LEVEL_COL = "EDUCATION_LEVEL";

    public static final String CREATE_TESTS_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+
            " "+ID_COL+" TEXT PRIMARY KEY," +
            " "+NAME_COL+" TEXT," +
            " "+STRATUM_COL+" TEXT," +
            " "+WAGE_COL+" TEXT," +
            " "+EDUCATION_LEVEL_COL+" TEXT" +
            ");";

}
