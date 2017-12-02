package io.github.mattshen.pgjwt;

public class Header {
    final public String alg;
    final public String typ;

    public Header(String alg, String typ) {
        this.alg = alg;
        this.typ = typ;
    }

}
