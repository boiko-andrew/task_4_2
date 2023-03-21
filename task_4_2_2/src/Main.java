import java.util.*;

public class Main {
    public static final int LONDON_POPULATION = 10_000_000;
    public static final int MAX_AGE = 100;

    public static final int LAWFUL_AGE = 18;

    public static final int MAX_RECRUIT_AGE = 27;
    public static final int MIN_LABOR_AGE = 18;
    public static final int MAX_WOMAN_LABOR_AGE = 60;
    public static final int MAX_MAN_LABOR_AGE = 65;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor",
                "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young",
                "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < LONDON_POPULATION; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(MAX_AGE),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // Count quantity of minor citizens
        int minorCitizensQty = (int) persons.stream()
                .filter(x -> x.getAge() < LAWFUL_AGE)
                .count();
        System.out.println("(1) Quantity of minor citizens is: " + minorCitizensQty + ".");

        // Find recruits
        List<String> recruits = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN &&
                        x.getAge() >= LAWFUL_AGE && x.getAge() < MAX_RECRUIT_AGE)
                .map(Person::getFamily)
                .toList();

        System.out.println("(2) Quantity of recruits is: " + recruits.size() + ".");

        // Find labours
        Collection<Person> labours = persons.stream()
                .filter(x -> x.getAge() >= MIN_LABOR_AGE &&
                        x.getEducation() == Education.HIGHER &&
                        (x.getSex() == Sex.WOMAN && x.getAge() <= MAX_WOMAN_LABOR_AGE ||
                                x.getSex() == Sex.MAN && x.getAge() <= MAX_MAN_LABOR_AGE))
                .sorted(new PersonComparator())
                .toList();
        System.out.println("(3) Quantity of labours is: " + labours.size() + ".");
    }
}