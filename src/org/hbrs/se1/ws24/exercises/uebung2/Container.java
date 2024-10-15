package org.hbrs.se1.ws24.exercises.uebung2;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Member> memberList = new ArrayList<>();

    // FA1: Methode zum Hinzufügen eines Member-Objekts
    public void addMember(Member member) throws ContainerException {
        for (Member m : memberList) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }

    // FA2: Methode zum Löschen eines Member-Objekts
    public String deleteMember(Integer id) {
        for (Member m : memberList) {
            if (m.getID().equals(id)) {
                memberList.remove(m);
                return "Member mit ID " + id + " wurde gelöscht.";
            }
        }
        return "Fehler: Kein Member mit ID " + id + " gefunden.";
    }

    // FA3: Methode zur Ausgabe aller Member-IDs (Dump)
    public void dump() {
        for (Member m : memberList) {
            System.out.println(m);
        }
    }

    // FA4: Methode zur Rückgabe der Anzahl der gespeicherten Member
    public int size() {
        return memberList.size();
    }
}
