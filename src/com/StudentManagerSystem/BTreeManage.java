package Com.StudentManagerSystem;

import Com.StudentManagerSystem.Btree.BPlusTree;

import java.io.IOException;

public class BTreeManage {

    private static BPlusTree<Integer,Integer> studentUniID_btree = new BPlusTree<>();
    private static BPlusTree<String,Integer> studentName_btree = new BPlusTree<>();
    private static BPlusTree<String,Integer> studentLastname_btree = new BPlusTree<>();
    private static BPlusTree<Integer,Integer> studentID_btree =new BPlusTree<>();


//    save load btrees
//    find insert delete info from or to btrees indirectly

    public static void load() {

        loadBtree_StudentUniID();
        loadBtree_StudentID();
        loadBtree_StudentName();
        loadBtree_StudentLastname();
    }
    public static void save() {

        saveBtree_StudentID();
        saveBtree_StudentUniID();
        saveBtree_StudentName();
        saveBtree_StudentLastname();
    }

    private static void loadBtree_StudentUniID() {
        // load btree if empty
        try {
            if (studentUniID_btree == null) studentUniID_btree = (BPlusTree<Integer, Integer>) FileManage.loadBtree_StudentUniID();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( e.toString() );
        }
    }
    private static void loadBtree_StudentName() {
        try {
            if (studentName_btree == null) studentName_btree = (BPlusTree<String, Integer>) FileManage.loadBtree_StudentName();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( e.toString() );
        }
    }
    private static void loadBtree_StudentLastname() {
        try {
            if (studentLastname_btree == null) studentLastname_btree = (BPlusTree<String, Integer>) FileManage.loadBtree_StudentLastName();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( e.toString() );
        }
    }
    private static void loadBtree_StudentID() {
        try {
            if (studentName_btree == null) studentName_btree = (BPlusTree<String, Integer>) FileManage.loadBtree_StudentName();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( e.toString() );
        }
    }

    private static void saveBtree_StudentUniID() {
        // save btree if is't empty
        try {
            if (studentUniID_btree != null) FileManage.saveBtree_StudentUniID(studentUniID_btree);
        } catch (IOException e) {
            System.out.println( e.toString() );
        }
    }
    private static void saveBtree_StudentName() {
        try {
            if (studentName_btree != null) FileManage.saveBtree_StudentUniID(studentUniID_btree);
        } catch (IOException e) {
            System.out.println( e.toString() );
        }
    }
    private static void saveBtree_StudentLastname() {
        try {
            if (studentLastname_btree != null) FileManage.saveBtree_StudentUniID(studentLastname_btree);
        } catch (IOException e) {
            System.out.println( e.toString() );
        }
    }
    private static void saveBtree_StudentID() {
        try {
            if (studentUniID_btree != null) FileManage.saveBtree_StudentUniID(studentID_btree);
        } catch (IOException e) {
            System.out.println( e.toString() );
        }

    }


    //------------------------------------------------------------------------
    //------------------------------------------------------------------------


    //CRUD operations on student personal info

    //add student key and index to BTree

    public static void createStudent(Student student) {
        createStudentUniID(student.getUniID() , student.getIndex_PersonalInfo());
        createStudentLastname(student.getLastname() , student.getIndex_PersonalInfo());
        createStudentName(student.getName() , student.getIndex_PersonalInfo());
        createStudentID(student.getId() , student.getIndex_PersonalInfo());
    }

    //TODO: add link list to avoid multiple items
    private static void createStudentUniID(int uniID, int index) {
        if (studentUniID_btree.search(uniID) == null){
            studentUniID_btree.insert(uniID , index);
        }else{
            //TODO: add link list to avoid multiple items
        }
    }
    private static void createStudentID(int id, int index) {
        if (studentID_btree.search(id) == null){
            studentID_btree.insert(id , index);
        }else{
            //TODO: add link list to avoid multiple items
        }
    }
    private static void createStudentName(String name, int index) {
        if (studentName_btree.search(name) == null){
            studentName_btree.insert(name , index);
        }else{
            //TODO: add link list to avoid multiple items
        }
    }
    private static void createStudentLastname(String lastname, int index) {
        if (studentLastname_btree.search(lastname) == null){
            studentLastname_btree.insert(lastname , index);
        }else{
            //TODO: add link list to avoid multiple items
        }
    }



    //update

    public static void updateStudent(Student student1, Student student2) {

        updateStudentID(student1.getId(), student2.getId(), student1.getIndex_PersonalInfo());
        updateStudentUniID(student1.getUniID(), student2.getUniID(), student1.getIndex_PersonalInfo());
        updateStudentName(student1.getName(), student2.getName(), student1.getIndex_PersonalInfo());
        updateStudentLastname(student1.getLastname(), student2.getLastname(), student1.getIndex_PersonalInfo());
    }

    private static void updateStudentUniID(int uniID1, int uniID2, int index) {

        if (uniID1 != uniID2) {

            studentUniID_btree.delete(uniID1);
            studentUniID_btree.insert(uniID2, index);
        }
    }
    private static void updateStudentID(int id1, int id2, int index) {

        if (id1 != id2){

            studentID_btree.delete(id1);
            studentID_btree.insert(id2, index);
        }
    }
    private static void updateStudentName(String name1, String name2, int index) {

        if (name1 != name2){

            studentName_btree.delete(name1);
            studentName_btree.insert(name2, index);
        }
    }
    private static void updateStudentLastname(String lastname1, String lastname2, int index) {

        if (lastname1 != lastname2){

            studentLastname_btree.delete(lastname1);
            studentLastname_btree.insert(lastname2, index);
        }
    }



    //find and return index

    public static int readStudent(String inputKey, String searchField) {
        return readByStudentUniID(Integer.parseInt(inputKey));
    }

    private static int readByStudentUniID(int input) throws NullPointerException {
        return studentUniID_btree.search(input);
    }
    private static int readByStudentName(String input)     {
        return studentName_btree.search(input);
    }
    private static int readByStudentLastname(String input) {
        return studentLastname_btree.search(input);
    }
    private static int readByStudentID(int  input)       {
        return studentID_btree.search(input);
    }



    //remove index records from BTree

    public static void deleteStudent(Student student) {
        deleteStudentID(student.getId());
        deleteStudentName(student.getName());
        deleteStudentLastname(student.getLastname());
        deleteStudentUniID(student.getUniID());
    }

    private static void deleteStudentUniID(int UniId)    {
        studentUniID_btree.delete(UniId);
    }
    private static void deleteStudentName(String name)     {
        studentName_btree.delete(name);
    }
    private static void deleteStudentLastname(String lastname) {
        studentLastname_btree.delete(lastname);
    }
    private static void deleteStudentID(int id)       {
        studentID_btree.delete(id);

    }



}