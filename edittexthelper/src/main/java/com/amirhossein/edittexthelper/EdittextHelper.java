package com.amirhossein.edittexthelper;

import android.widget.EditText;

import java.util.List;

/**
 * EdittextHelper is a controller assistant that checks edittexts input
 *
 * EdittextHelper is used in two ways:
 * The first way is set EditText in the constructor
 * The second way is set EditText in the methods
 *
 */
public class EdittextHelper {

    private EditText et;
    public EdittextHelper(EditText et){
        this.et=et;
    }
    public EdittextHelper(){}

    final static String EDITTEXTISEMPTY = "Edittext is empty";
    final static String ONEOFEDITTEXTISNONEMPTY = "One of edittexs is empty";
    final static String NOTINLIMITS = "The string is not within the limit";
    final static String THISISNOTANEMAILADDRESS = "This is not an email address";
    final static String THEKEYISNOTEXIST="The key is not exist in Edittext";

    public boolean nonEmpty(List<EditText> editList) {
        /**
         * nonEmpty method for a list of EditText check that all of edittexts in list is full or not
         *
         * boolean method return true when all EditTexts in list are full
         * void method use Action interface for callback
         */
        for (int i = 0; i < editList.size(); i++) {
            if (editList.get(i).getText().toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void nonEmpty(List<EditText> editList, Action action) {
        /**
         * nonEmpty method for a list of EditText check that all of edittexts in list is full or not
         *
         * boolean method return true when all EditTexts in list are full
         * void method use Action interface for callback
         */
        boolean res = true;
        for (int i = 0; i < editList.size(); i++) {
            if (editList.get(i).getText().toString().trim().isEmpty()) {
                action.onError(ONEOFEDITTEXTISNONEMPTY);
                res = false;
                break;
            }
        }
        if (res) {
            action.onOK();
        }
    }

    public boolean nonEmpty() {
        /**
         * nonEmpty method check EditText for empty or full
         *
         * void method use Action interface for callback
         */
        return !et.getText().toString().trim().isEmpty();
    }

    public void nonEmpty(Action action) {
        /**
         * nonEmpty method check EditText for empty or full
         *
         * void method use Action interface for callback
         */
        boolean res = true;
        if (et.getText().toString().trim().isEmpty()) {
            action.onError(EDITTEXTISEMPTY);
            res = false;
        }
        if (res) {
            action.onOK();
        }
    }

    public boolean nonEmpty(EditText editText) {
        /**
         * nonEmpty method check EditText for empty or full
         *
         * void method use Action interface for callback
         */
        return !editText.getText().toString().trim().isEmpty();
    }

    public void nonEmpty(EditText editText, Action action) {
        /**
         * nonEmpty method check EditText for empty or full
         *
         * void method use Action interface for callback
         */
        boolean res = true;
        if (editText.getText().toString().trim().isEmpty()) {
            action.onError(EDITTEXTISEMPTY);
            res = false;
        }
        if (res) {
            action.onOK();
        }
    }

    public boolean limit(int min, int max) {
        /**
         * limit method checks input for its range
         *
         * void method use Action interface for callback
         */
        return et.getText().toString().trim().length() >= min && et.getText().toString().trim().length() <= max;
    }

    public void limit(int min, int max, Action action) {
        /**
         * limit method checks input for its range
         *
         * void method use Action interface for callback
         */
        if (et.getText().toString().trim().length() >= min &&
                et.getText().toString().trim().length() <= max) {
            action.onOK();
        } else {
            action.onError(NOTINLIMITS);
        }

    }

    public boolean limit(EditText editText, int min, int max) {
        /**
         * limit method checks input for its range
         *
         * void method use Action interface for callback
         */
        return editText.getText().toString().trim().length() >= min && editText.getText().toString().trim().length() <= max;
    }

    public void limit(EditText editText, int min, int max, Action action) {
        /**
         * limit method checks input for its range
         *
         * void method use Action interface for callback
         */
        if (editText.getText().toString().trim().length() >= min &&
                editText.getText().toString().trim().length() <= max) {
            action.onOK();
        } else {
            action.onError(NOTINLIMITS);
        }

    }

    public boolean isEmail() {
        /**
         * isEmail use for check that the input is a email address or not
         *
         * void method use Action interface for callback
         */
        String s = et.getText().toString().trim().toLowerCase();
        char[] echars = "abcdefghijklmnopqrstuvwxyz1234567890@.".toCharArray();
        boolean flag =true;
        for (int i = 0; i <s.length() ; i++) {
            char tChar=s.charAt(i);
            for (char ch: echars ) {
                if (tChar==ch){
                    flag=true;
                    break;
                }
                flag=false;
            }
            if (!flag){
                break;
            }
        }
        return flag && s.indexOf("@") < s.lastIndexOf(".")
                && s.split("@").length == 2
                && s.length() > 7 && s.length() < 40;
    }

    public void isEmail(Action action) {
        /**
         * isEmail use for check that the input is a email address or not
         *
         * void method use Action interface for callback
         */
        String s = et.getText().toString().trim().toLowerCase();
        char[] echars = "abcdefghijklmnopqrstuvwxyz1234567890@.".toCharArray();
        boolean flag =true;
        for (int i = 0; i <s.length() ; i++) {
            char tChar=s.charAt(i);
            for (char ch: echars ) {
                if (tChar==ch){
                    flag=true;
                    break;
                }
                flag=false;
            }
            if (!flag){
                break;
            }
        }
        if (flag && s.indexOf("@") < s.lastIndexOf(".") && s.split("@").length == 2 && s.length() > 7 && s.length() < 40) {
            action.onOK();
        } else {
            action.onError(THISISNOTANEMAILADDRESS);
        }
    }

    public boolean isEmail(EditText editText) {
        /**
         * isEmail use for check that the input is a email address or not
         *
         * void method use Action interface for callback
         */
        String s = editText.getText().toString().trim().toLowerCase();
        char[] echars = "abcdefghijklmnopqrstuvwxyz1234567890@.".toCharArray();
        boolean flag =true;
        for (int i = 0; i <s.length() ; i++) {
            char tChar=s.charAt(i);
            for (char ch: echars ) {
                if (tChar==ch){
                    flag=true;
                    break;
                }
                flag=false;
            }
            if (!flag){
                break;
            }
        }
        return flag && s.indexOf("@") < s.lastIndexOf(".")
                && s.split("@").length == 2
                && s.length() > 7 && s.length() < 40;
    }

    public void isEmail(EditText editText, Action action) {
        /**
         * isEmail use for check that the input is a email address or not
         *
         * void method use Action interface for callback
         */
        String s = editText.getText().toString().trim().toLowerCase();
        char[] echars = "abcdefghijklmnopqrstuvwxyz1234567890@.".toCharArray();
        boolean flag =true;
        for (int i = 0; i <s.length() ; i++) {
            char tChar=s.charAt(i);
            for (char ch: echars ) {
                if (tChar==ch){
                    flag=true;
                    break;
                }
                flag=false;
            }
            if (!flag){
                break;
            }
        }
        if (flag && s.indexOf("@") < s.lastIndexOf(".")
                && s.split("@").length == 2
                && s.length() > 7 && s.length() < 40) {
            action.onOK();
        } else {
            action.onError(THISISNOTANEMAILADDRESS);
        }
    }

    public boolean isExist(String key){
        /**
         * isExist use for check that the input contain the key or not
         *
         * void method use Action interface for callback
         */
        String s=et.getText().toString().trim();
        return s.contains(key);
    }

    public void isExist(String key , Action action){
        /**
         * isExist use for check that the input contain the key or not
         *
         * void method use Action interface for callback
         */
        String s=et.getText().toString().trim();
        if (s.contains(key)){
            action.onOK();
        }else{
            action.onError(THEKEYISNOTEXIST);
        }
    }

    public boolean isExist(EditText editText , String key){
        /**
         * isExist use for check that the input contain the key or not
         *
         * void method use Action interface for callback
         */
        String s=editText.getText().toString().trim();
        return s.contains(key);
    }

    public void isExist(EditText editText , String key , Action action){
        /**
         * isExist use for check that the input contain the key or not
         *
         * void method use Action interface for callback
         */
        String s=editText.getText().toString().trim();
        if (s.contains(key)){
            action.onOK();
        }else{
            action.onError(THEKEYISNOTEXIST);
        }
    }


    public interface Action {
        void onOK();

        void onError(String msg);
    }

}
