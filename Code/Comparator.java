import java.util.Comparator;

public class Studnet {
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();
    //生成了一个静态对象BY_NAME 为Student类的一个Comparator
    private final String name;
    private final int section;

    //使用nested class 实现Comparator接口
    private static class Byname implements Comparator<Student>
    {
        public int compare(Student v, Student w)
        { return v.name.compareTo(w.name) }
    } 

    private static class BySection implements Comparator<Student>
    {
        public int compare(Student v, Student w)
        { return v.section - w.section; }
    }
}