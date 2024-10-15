package org.hbrs.se1.ws24.exercises.uebung2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void testContainer() throws ContainerException {
        Container container = new Container();

        // Erstelle zwei Member-Objekte
        Member member1 = new ConcreteMember(1);
        Member member2 = new ConcreteMember(2);

        // Test 1: Leerer Container hat die Größe 0
        assertEquals(0, container.size());

        // Test 2: Member1 hinzufügen
        container.addMember(member1);
        assertEquals(1, container.size());

        // Test 3: Member2 hinzufügen
        container.addMember(member2);
        assertEquals(2, container.size());

        // Test 4: Duplicate Member hinzufügen sollte eine Exception werfen
        ContainerException exception = assertThrows(ContainerException.class, () -> {
            container.addMember(member1);
        });
        assertEquals("Das Member-Objekt mit der ID 1 ist bereits vorhanden!", exception.getMessage());

        // Test 5: Löschen von Member1
        assertEquals("Member mit ID 1 wurde gelöscht.", container.deleteMember(1));
        assertEquals(1, container.size());

        // Test 6: Löschen eines nicht existierenden Members
        assertEquals("Fehler: Kein Member mit ID 1 gefunden.", container.deleteMember(1));

        // Test 7: Löschen von Member2
        assertEquals("Member mit ID 2 wurde gelöscht.", container.deleteMember(2));
        assertEquals(0, container.size());

        // Test 8: Dump eines leeren Containers (keine Ausgabe erwartet)
        container.dump();

        // Test 9: Member1 erneut hinzufügen und dump überprüfen
        container.addMember(member1);
        assertEquals(1, container.size());
        container.dump(); // Es sollte "Member (ID = 1)" ausgegeben werden.

        // Test 10: Anzahl der Member nach erneutem Hinzufügen
        Member member3 = new ConcreteMember(3);
        container.addMember(member3);
        assertEquals(2, container.size());
    }
}
