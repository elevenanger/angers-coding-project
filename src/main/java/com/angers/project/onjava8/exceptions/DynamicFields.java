package com.angers.project.onjava8.exceptions;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/25 16:03
 * @description :
 */
class DynamicFieldsException extends Exception {}

public class DynamicFields {
    private Object [] [] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        Arrays.stream(fields)
                .forEach(field -> field = new Object[]{null,null});
    }

    @Override
    public String toString() {
        return "DynamicFieldsException{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }

    private int hasField(String id){
        return Arrays.stream(fields)
                .filter(field -> field[0]== id)
                .findFirst()
                .map(objects -> Arrays.asList(fields).indexOf(objects))
                .orElse(-1);
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int field = hasField(id);
        if (field == -1) throw new NoSuchFieldException();
        return field;
    }
    private int makeField(String id){
        Optional<Integer> optional = Arrays.stream(fields)
                .filter(field -> field[0]== null)
                .findFirst()
                .map(objects -> Arrays.asList(fields).indexOf(objects));
        if (optional.isPresent()) return optional.get();
        Object [] [] tmp = new Object[fields.length+1][2];
        for (int i = 0; i <fields.length ; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length ;i < tmp.length;i++){
            tmp[i] = new Object[]{null,null};
        }
        fields = tmp;
        return makeField(id);
    }
    Object getField(String id)throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }
    Object setField(String id ,Object value) throws DynamicFieldsException {
        if (value ==null){
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1){
            fieldNumber = makeField(id);
        }
        Object result  =  null;
        try {
            result = getField(id);
        }catch (NoSuchFieldException e){
            throw  new RuntimeException();
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d","d");
            df.setField("number",93);
            System.out.println(df);
            df.setField("d","a value for d");
            df.setField("number3",11);
            System.out.println("df" + df);
            System.out.println(df.getField("d"));
        }catch (NoSuchFieldException | DynamicFieldsException e){
            e.printStackTrace(System.out);
        }
    }
}