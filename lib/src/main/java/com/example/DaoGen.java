package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoGen {
    public static void main(String[] args)throws Exception{
        Schema schema= new Schema(1,"com.example.administrator.mydbcontrol");
        addCity(schema);
        addProvince(schema);
        new DaoGenerator().generateAll(schema,"F:\\ASWorke\\JingXiApp_Android\\MyDBControl\\app\\src\\main\\java_gen");
    }

    private static void addProvince(Schema schema) {
        Entity note= schema.addEntity("tb_province");
        note.addIntProperty("provinceid");
        note.addStringProperty("provincename");
        note.addLongProperty("datecreated");
        note.addLongProperty("dateupdated");
        note.addIntProperty("countryid");
        note.addStringProperty("province_code");
    }
    private static void addCity(Schema schema) {
        Entity note= schema.addEntity("tb_city");
        note.addIntProperty("cityid");
        note.addStringProperty("cityname");
        note.addStringProperty("zipcode");
        note.addIntProperty("provinceid");
        note.addLongProperty("datecreated");
        note.addLongProperty("dateupdated");
        note.addStringProperty("citycode");
    }
}
