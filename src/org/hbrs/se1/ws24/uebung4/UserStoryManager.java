package org.hbrs.se1.ws24.uebung4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserStoryManager {

    private static ContainerStory<UserStory> container = new ContainerStory<>();
    private static PersistenceStrategyStream<UserStory> persistence = new PersistenceStrategyStream<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Story Management Tool - Eingabe 'help' für Befehle");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] tokens = input.trim().split("\\s+");  // trim und split für saubere Eingaben
            String command = tokens[0];

            switch (command) {
                case "enter":
                    enterUserStory(tokens);
                    break;
                case "store":
                    storeUserStories();
                    break;
                case "load":
                    loadUserStories();
                    break;
                case "dump":
                    dumpUserStories();
                    break;
                case "exit":
                    System.out.println("Programm wird beendet.");
                    System.exit(0);
                case "help":
                    showHelp();
                    break;
                default:
                    System.out.println("Unbekannter Befehl. Geben Sie 'help' für eine Liste der Befehle ein.");
            }
        }
    }

    private static void enterUserStory(String[] tokens) {
        if (tokens.length < 9) {
            System.out.println("Fehler: Bitte geben Sie alle notwendigen Parameter ein.");
            System.out.println("Format: enter <ID> <Titel> <Akzeptanzkriterium> <Projekt> <Geschäftswert> <Risiko> <Priorität> <Aufwand>");
            return;
        }

        try {
            int id = Integer.parseInt(tokens[1]);
            String title = tokens[2];
            String acceptanceCriteria = tokens[3];
            String project = tokens[4];
            double businessValue = Double.parseDouble(tokens[5]);
            double risk = Double.parseDouble(tokens[6]);
            double priority = Double.parseDouble(tokens[7]);
            double effort = Double.parseDouble(tokens[8]);

            UserStory userStory = new UserStory(id, title, acceptanceCriteria, project, businessValue, risk, priority, effort);
            container.addItem(userStory);
            System.out.println("User Story wurde erfolgreich hinzugefügt.");

        } catch (NumberFormatException e) {
            System.out.println("Fehler: Bitte stellen Sie sicher, dass ID, Geschäftswert, Risiko, Priorität und Aufwand numerisch sind.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
        }
    }

    private static void storeUserStories() {
        try {
            persistence.save(container.getItems(), "userstories.ser");
            System.out.println("User Stories wurden erfolgreich gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der User Stories: " + e.getMessage());
        }
    }

    private static void loadUserStories() {
        try {
            container.clear();
            List<UserStory> loadedStories = persistence.load("userstories.ser");
            loadedStories.forEach(container::addItem);
            System.out.println("User Stories wurden erfolgreich geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler: Ungültiges Dateiformat.");
        } catch (Exception e) {
            System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
        }
    }

    private static void dumpUserStories() {
        List<UserStory> sortedStories = container.getSortedItems();
        if (sortedStories.isEmpty()) {
            System.out.println("Es sind keine User Stories zur Anzeige verfügbar.");
        } else {
            System.out.println("User Stories nach Priorität sortiert:");
            sortedStories.forEach(System.out::println);
        }
    }

    private static void showHelp() {
        System.out.println("Verfügbare Befehle:");
        System.out.println("enter <ID> <Titel> <Akzeptanzkriterium> <Projekt> <Geschäftswert> <Risiko> <Priorität> <Aufwand>");
        System.out.println("store - Persistentes Speichern der User Stories");
        System.out.println("load - Laden der User Stories aus Datei");
        System.out.println("dump - Ausgabe der User Stories nach Priorität sortiert");
        System.out.println("exit - Beenden des Programms");
        System.out.println("help - Anzeige der Befehle");
    }
}
