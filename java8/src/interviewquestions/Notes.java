package interviewquestions;

public class Notes {
    private int id;
    private long tag;
    private String name;

    public Notes(int id,  String name,long tag) {
        this.id = id;
        this.tag = tag;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTag() {
        return tag;
    }

    public void setTag(long tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", tag=" + tag +
                ", name='" + name + '\'' +
                '}';
    }
}
