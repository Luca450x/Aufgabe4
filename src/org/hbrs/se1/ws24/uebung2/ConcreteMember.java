package org.hbrs.se1.ws24.uebung2;

public class ConcreteMember implements Member {
    private Integer id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + id + ")";
    }
}