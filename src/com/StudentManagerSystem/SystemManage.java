
package com.StudentManagerSystem;

import java.io.File;

public class SystemManage {


    private static Student studentTmp;
    private static Student updatedStudentTmp;
    private static void addStudent() {
        int index = IndexManage.addStudent();
        studentTmp.setIndex_PersonalInfo(index);
        BTreeManage.createStudent(studentTmp);
        FileManage.createStudent(studentTmp);
    }



    public static void loadProgram() {
        BTreeManage.load();
        IndexManage.load();
        IDManage.load();
    }
    public static void saveProgram() {
        BTreeManage.save();
        IndexManage.save();
        IDManage.save();

    }

    //buttons
    public static Student searchStudent(String inputKey, String searchField) {

        int index;

        index = BTreeManage.readStudent(searchField, inputKey);
        studentTmp = FileManage.readStudent(index);
        return studentTmp;
    }
    public static Student signupStudent() {

        String uniId = IDManage.createNewID();
        addStudent();
        return studentTmp;
    }
    public static Student updateStudent() {

        BTreeManage.updateStudent(studentTmp, updatedStudentTmp);
        FileManage.updateStudent(studentTmp, updatedStudentTmp);
        return updatedStudentTmp;
    }
    public static Student removeStudent() {

        int index;
        BTreeManage.deleteStudent(studentTmp);
        index = studentTmp.getIndex_PersonalInfo();
        IndexManage.removeStudent(index);
        FileManage.deleteStudent(studentTmp);// i don't know if it's needed cause if u remove the index the data i considered removed
        return studentTmp;
    }






    //get and set properties

    public static void setStudentTmp(Student student) {

        studentTmp.setUniID(student.getUniID());
        studentTmp.setName(student.getName());
        studentTmp.setLastname(student.getLastname());
        studentTmp.setPhoneNum(student.getPhoneNum());
        studentTmp.setBirthDate(student.getBirthDate());
        studentTmp.setId(student.getId());
    }

    public static Student getStudentTmp() {
        return studentTmp;
    }

}
