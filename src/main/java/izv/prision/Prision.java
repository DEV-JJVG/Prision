/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package izv.prision;

import Exception.InvalidAgeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author JJ y Hugo
 */
public class Prision {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(automaticVisitCreator());
    }

    /*
    
    
    
    
    
    
    empty espace to make the main look prettier
    
    
    
    
    
    
    
     */
    //normal funtions
    //here there will be oall the funtions normaly used in the program
    /*
    
    
    
    
    
    
    
     */
    //manual creation of obgets,
    //here the will be funtions that will create obgets in the program itself, and with 
    //no prtections from erros, they will only be used to test the obgets
    //and are only meantto be used by the programer
    //the will be call manual to make clear what they do, other similar funtions
    //meants for the user will be call "user______" and will be put in the section above.
    public static Cell manualCellcreation() {
        System.out.println("int cellID, Integer cellNumber, String location, Integer CellCapacity");
        int cellID = input.nextInt();
        int cellNumber = input.nextInt();
        input.nextLine();
        String location = input.nextLine();
        int cellCapacity = input.nextInt();
        Cell cell = new Cell(cellID, cellNumber, location, cellCapacity);
        System.out.println(cell);
        return cell;
    }

    public static void manualPersonCreator() {
        System.out.println("String name, Date born_date (dd/MM/yyyy), int id");
        String name = input.nextLine();

        String date = input.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        int id = input.nextInt();

        try {
            Date born_date = format.parse(date);
            Person person = new Person(name, born_date, id);
            System.out.println(person);
        } catch (ParseException e) {
            System.out.println("date format invalid.");
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
        //in case it doesnt work I just made an error person 
        try {
            Person pepe = new Person("error", new Date(125, 3, 10), 1);
            System.out.println(pepe);
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void manualInmateCreator() {
        System.out.println("Date entrance_date, Date exit_date, boolean status, String felony,\n ArrayList<Visit> visits, String name, Date born_date, int id");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        String entrance_date = input.nextLine();
        String exit_date = input.nextLine();
    }

    public static Visit manualVisitCreator() {
        System.out.println("int visit_Id, Date visit_Date(dd/MM/yyyy), Person (it is automaic), String relationship");
        int visit_id = input.nextInt();
        input.nextLine();
        String date = input.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date visit_Date = null;
        try {
            visit_Date = format.parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        Person person = automaticPersonCreator();

        String relationship = input.nextLine();

        return new Visit(visit_id, visit_Date, person, relationship);

    }

    /*
    
    
    
    
    
     */
    //automatic creation of obgets
    //here there will be funtions that will create obgets automaticly and ramdomly or that purpose
    //they will be used when a valid obget is nededd and witch atributtes doesn't matter
    //this is an automatic name selector, for selecting names (genious)
    public static String autoNameSelector() {
        String[][] names = {
            {
                "Aiko", "Luca", "Zahra", "Nikolai", "Kwame", "Leila", "Yara", "Santiago", "Anika", "Thabo",
                "Ines", "Arjun", "Fatima", "Björn", "Ming", "Sofia", "Jamal", "Eva", "Diego", "Hana",
                "Noor", "Igor", "Soraya", "Tariq", "Amira", "Marina", "Yusuf", "Kira", "Omar", "Lucía",
                "Ravi", "Amina", "Mateo", "Chiara", "Nadia", "Isaac", "Malika", "Kenji", "Helena", "Ali",
                "Lina", "Andrei", "Maya", "Samir", "Talia", "Raul", "Zainab", "Milos", "Rania", "Jonas"
            },
            {
                "Ishikawa", "Bianchi", "Rahimi", "Petrov", "Mensah", "Benali", "Haddad", "Muñoz", "Singh", "Nkosi",
                "López", "Mehra", "El-Sayed", "Lindberg", "Zhang", "Kowalska", "Abdullah", "Nowak", "Torres", "Kim",
                "Farah", "Kuznetsov", "Darwish", "Qureshi", "Nassar", "Fischer", "Demir", "Volkova", "Nasr", "Fernández",
                "Patel", "Hassan", "García", "Romano", "Bakri", "Goldberg", "Cherif", "Yamamoto", "Müller", "Akbari",
                "Barakat", "Stoica", "Navarro", "Aziz", "Mizrahi", "Costa", "Saidi", "Jovanovic", "Habib", "Schmidt"
            }
        };

        String name = names[0][ThreadLocalRandom.current().nextInt(50)];
        String lastName = names[1][ThreadLocalRandom.current().nextInt(50)];

        String fullName = name + " " + lastName;
        return fullName;
    }

    //this funcion automaticly select a relationship for the visits
    public static String automaticRelationShipCreator() {
        String[] relationships = {
            "Mother", "Father", "Older brother", "Younger sister", "Wife supporting her husband",
            "Husband visiting his wife", "Adult son visiting father", "Daughter reconnecting with father", 
            "Cousin checking in on family", "Long-time friend offering support",
            "Uncle offering guidance", "Aunt who’s been a second mother", "Grandfather sharing wisdom",
            "Grandmother bringing comfort", "Stepfather offering a second chance",
            "Stepmother offering support", "Stepbrother with family ties",
            "Stepsister offering emotional support", "Fiancé visiting for love", "Fiancée rekindling connection",
            "Boyfriend standing by his partner", "Girlfriend offering love and hope",
            "Life partner showing commitment", "Ex-husband trying to maintain friendship", "Ex-wife offering closure",
            "Colleague from previous job", "Employer showing empathy", "Employee seeking closure",
            "Neighbor reaching out for a visit", "Prison chaplain providing spiritual guidance",
            "Teacher who once mentored", "Tutor continuing education support", 
            "Mentor offering life advice", "Counselor trying to help heal", "Therapist guiding emotional recovery",
            "Social worker helping with reintegration", "Attorney offering legal advice", 
            "Lawyer providing case updates", "Public defender keeping in touch", "Judge offering support in difficult times",
            "Bail bondsman offering financial help", "Caseworker assisting with rehabilitation",
            "Volunteer visiting for encouragement", "Chaplain providing peace", "Psychologist giving professional support",
            "Doctor offering medical advice", "Nurse caring for the inmate's health",
            "Medical staff working on treatment", "Prison guard maintaining order", "Correctional officer ensuring safety",
            "Detective investigating a case", "Investigator working on a case update",
            "Old childhood friend reconnecting", "Close friend providing emotional support", "Best friend showing up through thick and thin",
            "High school friend keeping in touch", "College friend checking on well-being",
            "Supporter offering kindness", "Sponsor helping with rehabilitation", "Adoptive mother providing care",
            "Foster parent offering a safe space", "Godparent offering spiritual guidance",
            "Caretaker ensuring well-being", "Religious guide offering comfort", "Spiritual mentor giving hope",
            "Rehabilitation counselor helping transition", "Legal representative offering advice",
            "Community leader offering assistance", "Activist advocating for fair treatment", 
            "Prison reform supporter helping improve conditions",
            "Rehabilitation mentor guiding the way", "Support group member offering solidarity",
            "Anger management coach teaching control", "Substance abuse counselor offering guidance",
            "Family therapist improving relationships",
            "Mental health advocate supporting recovery", "Crisis counselor helping through difficult times",
            "Prison reform advocate working for change", "Civil rights leader standing for justice", 
            "Victim support counselor offering understanding",
            "Political representative offering help", "Non-profit worker providing resources",
            "Charity worker spreading compassion", "Ex-prisoner offering mentorship", "Convicted felon sharing experiences",
            "Reformed individual giving hope", "Social justice warrior advocating for rights",
            "Advocate fighting for a fair system", "Defender ensuring fair treatment", "Protector ensuring safety and rights",
            "Financial backer supporting reintegration", "Adviser helping make critical decisions",
            "Mediator helping with conflict resolution", "Lifeline offering emotional stability", "Safety net supporting the inmate's journey",
            "Second chance provider helping with new beginnings", "Stabilizer providing consistent guidance", 
            "Bridge offering connections to the outside world", "Hope bearer offering positivity", "Peacekeeper during tense moments",
            "Conflict resolution specialist guiding harmony", "Risk manager for reintegration planning",
            "Legal advisor clarifying options", "Crisis manager helping during stressful situations", "Reentry counselor supporting smooth transition",
            "Family mediator offering conflict solutions", "Volunteer coordinator organizing help",
            "Prison reform specialist advocating for change", "Reentry program participant guiding others", "Mediation expert solving interpersonal issues",
            "Emotional support provider during tough times", "Family counselor guiding difficult conversations",
            "Group leader in support networks", "Community volunteer offering encouragement", "Youth mentor guiding troubled youth",
            "Relational partner offering understanding", "Support system offering a solid foundation",
            "Emotional anchor keeping the peace", "Family support ensuring well-being", "Mental health worker promoting recovery",
            "Work release mentor guiding through reentry", "Prison reform activist fighting for justice",
            "Restorative justice advocate for healing", "Peer counselor providing guidance", "Peer mentor offering practical advice",
            "Cognitive behavioral therapist working on change", "Life coach motivating growth",
            "Anger management facilitator offering coping skills", "Reintegration specialist helping with adaptation",
            "Counseling supervisor overseeing progress"
        };
        
        return relationships[ThreadLocalRandom.current().nextInt(0, 100)];
    }

    //this funcion creates a random date beteiwng 1950 and 2025 
    public static Date automaticPastDateCreator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        //You must set it to null in order to declare it outside the try-catch.
        Date date = null;
        try {
            Date startDate = dateFormat.parse("01/01/1950");
            Date endDate = dateFormat.parse("01/01/2025");

            long startMillis = startDate.getTime();
            long endMillis = endDate.getTime();

            long randomDateMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
            date = new Date(randomDateMillis);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }

    public static Person automaticPersonCreator() {
        String name = autoNameSelector();
        Date born_date = automaticPastDateCreator();
        int id = ThreadLocalRandom.current().nextInt(1, 500);
        Person person = null;
        try {
            person = new Person(name, born_date, id);
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
        return person;
    }

    public static Visit automaticVisitCreator() {
        int id = ThreadLocalRandom.current().nextInt(1, 500);
        Date date = automaticPastDateCreator();
        Person person = automaticPersonCreator();
        String relationship = automaticRelationShipCreator();
        return new Visit(id, date, person, relationship);
    }
}
