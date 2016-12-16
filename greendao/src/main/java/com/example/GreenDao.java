package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

public class GreenDao {

    public static void main(String args[]){
        Schema schema = new Schema(1,"chou.aric.com.mydao.utils");
        Entity son = schema.addEntity("Son");
        son.addStringProperty("name");
        son.addIntProperty("age");
        son.addIdProperty();
        Property fatherId = son.addLongProperty("fatherId").getProperty();


        Entity father = schema.addEntity("Father");
        father.addIdProperty();
        father.addStringProperty("name");
        father.addIntProperty("age");

        son.addToOne(father,fatherId);

        try {
            new DaoGenerator().generateAll(schema,"app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
