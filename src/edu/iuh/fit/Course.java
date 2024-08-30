/*
 * @ (#) Course.java    1.0  8/30/2024
 *
 *Copyright (c) 2024 IUH.All rights reserved
 */
package edu.iuh.fit;

/*
 * @description:This class represents a bank with many bank accounts
 * @author: Thu Phuong
 * @version: 1.0
 * @date:8/30/2024
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    //Contructor


    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public Course() {
        this("","",0,"");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(String id) {
        if (id.trim().length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");

        int len = id.length();
        for (int i = 0; i < len; i++) {
            char ch = id.charAt(i);
            if (Character.isLetterOrDigit(ch))
                throw new IllegalArgumentException("ID must not contain letters or numbers");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%10d%-20s ", id, title, credit, department);
    }




}
