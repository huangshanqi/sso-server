package cn.evilcoder.model;

/**
 * Created by evilcoder.cn on 2016/12/22.
 */
public class Test {

    private long id;
    private String content;

    public Test(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Test() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Test withContent(String content) {
        this.content = content;
        return this;
    }

    public Test withId(long id) {
        this.id = id;
        return this;
    }

}
