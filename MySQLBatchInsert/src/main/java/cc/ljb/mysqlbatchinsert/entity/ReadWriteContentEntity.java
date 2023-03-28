package cc.ljb.mysqlbatchinsert.entity;

public class ReadWriteContentEntity {

    private String name;
    private String title;
    private String author;

    private String age;

    private String address;

    private String classId;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAge() {
        return age == null ? "" : age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassId() {
        return classId == null ? "" : classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
