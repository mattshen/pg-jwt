package io.github.mattshen.pgjwt;


public class Payload {
    public String sub;
    public String name;
    public boolean admin;

    public Payload(String sub, String name, boolean admin) {
        this.sub = sub;
        this.name = name;
        this.admin = admin;
    }

}
