/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package izv.prision;

import Exception.InvalidAgeException;
import Guardias.Guard;
import Guardias.Guard.CARGO;
import Inmate.Inmate;
import InterfacesGraficas.GuardInterface;
import InterfacesGraficas.InmateInterface;
import InterfacesGraficas.PrisonInterface;
import InterfacesGraficas.VisitationInterface;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author JJ y Hugo
 */
public class Prision {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    /*
    
    
    
    
    
    
    empty espace to make the main look prettier
    
    
    
    
    
    
    
     */
    //normal funtions
    //here there will be oall the funtions normaly used in the program
    public static void menu() {
        boolean menuIncorrecto = true;
        int opcion;
        while (menuIncorrecto) {
            System.out.println("=== MAIN MENU ===");
            System.out.println("1. Use current prison");
            System.out.println("2. make a new prison");
            System.out.println("3. exit");
            System.out.print("Choose typing a number: ");
            opcion = userInput();;
            // Validación de entrada

            switch (opcion) {
                case 1:
                    mainPrisonWork();
                    break;
                case 2:
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new InmateInterface().setVisible(true);
                        }
                    });
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new PrisonInterface().setVisible(true);
                        }
                    });
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new GuardInterface().setVisible(true);
                        }
                    });
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new VisitationInterface().setVisible(true);
                        }
                    });
                    break;
                case 3:
                    System.out.println("exiting program");
                    menuIncorrecto = false;
                    break;
                default:
                    System.out.println("choose betewing 1 and 3");
            }

            System.out.println(); // Línea en blanco para separación
        }

    }

    public static int userInput() {
        int number = 0;
        boolean rightNumber = true;
        while (rightNumber) {
            try {
                number = input.nextInt();
                rightNumber = false;
            } catch (InputMismatchException e) {
                System.out.println("you must put a full number");
            }
        }
        return number;
    }

    public static void mainPrisonWork() {
        ArrayList<Inmate> inmates = obtainAllInmates();
        ArrayList<Guard> guards = obtainAllGuards();


    }

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/prision";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

    public static ArrayList<Inmate> obtainAllInmates() {
        ArrayList<Inmate> inmates = new ArrayList<>();

        try {
            Connection conn = connect();

            Statement stmtInmates = conn.createStatement();
            Statement stmtVisits = conn.createStatement();

            ResultSet rs = stmtInmates.executeQuery("SELECT * FROM `inmate`");
            ResultSet res = stmtVisits.executeQuery("SELECT * FROM `visitation`");

            ArrayList<Visit> allVisits = new ArrayList<>();
            while (res.next()) {
                System.out.println(res.getInt("inmate_ID"));
                allVisits.add(new Visit(
                        res.getInt("visitation_ID"),
                        res.getDate("visitation_date"),
                        res.getString("visitor_name"),
                        res.getString("relationship"),
                        res.getInt("inmate_ID")
                ));
            }

            while (rs.next()) {
                int inmateId = rs.getInt("inmate_ID");

                // Filtrar solo las visitas de ese preso
                ArrayList<Visit> visits = new ArrayList<>();
                for (Visit v : allVisits) {
                    if (v.getInmate_ID() == inmateId) {
                        visits.add(v);
                    }
                }

                try {
                    inmates.add(new Inmate(
                            rs.getDate("inserction_date"),
                            rs.getDate("exit_date"),
                            rs.getString("status"),
                            rs.getString("crime"),
                            visits,
                            rs.getString("name"),
                            rs.getDate("born_date"),
                            inmateId
                    ));
                } catch (InvalidAgeException ex) {
                    System.err.println("Invalid age for inmate ID " + inmateId + ": " + ex.getMessage());
                }
            }

            res.close();
            rs.close();
            stmtInmates.close();
            stmtVisits.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return inmates;
    }

    public static ArrayList<Guard> obtainAllGuards() {
        ArrayList<Guard> guards = new ArrayList<>();
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `guard`");

            while (rs.next()) {
                try {
                    guards.add(new Guard(
                            CARGO.valueOf(rs.getString("position")),
                            rs.getString("name"),
                            rs.getDate("born_date"),
                            rs.getInt("guard_ID")
                    ));
                } catch (InvalidAgeException ex) {
                    System.err.println("Invalid age for inmate ID: " + ex.getMessage());
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return guards;
    }

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

    public static Inmate manualInmateCreator() {
        System.out.println("Date entrance_date, Date exit_date, String status, String felony,\n"
                + "ArrayList<Visit> visits(automatic but you must enter an int(number of visits)),\n"
                + "String name, Date born_date, int id");
        Inmate inmate = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        String entrance_date = input.nextLine();
        String exit_date = input.nextLine();
        String status = input.nextLine();
        input.nextLine();
        String felony = input.nextLine();
        int numberOfVisits = input.nextInt();
        input.nextLine();
        input.nextLine();
        String name = input.nextLine();
        String born_date = input.nextLine();
        int id = input.nextInt();

        ArrayList<Visit> visits = new ArrayList<>();
        for (int i = 0; i < numberOfVisits; i++) {
            visits.add(automaticVisitCreator());
        }

        try {
            Date entranceDate = format.parse(entrance_date);
            Date exitDate = format.parse(exit_date);
            Date bornDate = format.parse(born_date);
            inmate = new Inmate(entranceDate, exitDate, status, felony, visits, name, bornDate, id);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }

        return inmate;
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

        String name = autoNameSelector();

        String relationship = input.nextLine();

        return new Visit(visit_id, visit_Date, name, relationship);

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

    //this is an automatic selector of felonies that will, you'll never guess it, select felonies
    public static String autoFelonySelector() {
        String felony;
        long coinflip = ThreadLocalRandom.current().nextLong(0, 6);
        //I made so that there is a small chande that the felony is something goofy
        //I did this to add some flavor to the program
        if (coinflip == 0) {
            String[] goofyFelonies = {
                "Stealing 37 rubber ducks from a public fountain",
                "Arson at a marshmallow factory",
                "Impersonating a famous chef to steal recipes",
                "Selling moon rocks on Craigslist",
                "Throwing spaghetti at politicians",
                "Public karaoke under the influence",
                "Robbing a bank using only a banana",
                "Attempting to bribe a vending machine",
                "Illegally racing shopping carts in a mall",
                "Running a black market for rare Pokémon cards",
                "Kidnapping a mime (they didn’t scream)",
                "Faking a ghost to scare tourists",
                "Hijacking an ice cream truck",
                "Stealing candy from a dentist office",
                "Hacking into a toaster",
                "Poisoning a rival's soup with glitter",
                "Starting a cult based on a cat",
                "Smuggling avocados across state lines",
                "Riding a llama on the freeway",
                "Shoplifting socks while wearing them",
                "Attempting to rob a store with a Nerf gun",
                "Creating a fake fast-food franchise",
                "Graffiti of motivational quotes on police cars",
                "Impersonating Santa in July",
                "Performing unauthorized magic in court",
                "Time travel without a permit",
                "Burglary of a haunted house",
                "Selling haunted dolls to children",
                "Running an illegal pillow fight league",
                "Disguising as a tree to spy on neighbors",
                "Hosting illegal backyard musicals",
                "Counterfeiting Monopoly money",
                "Fishing in a hotel fountain",
                "Interrupting a wedding to challenge the groom",
                "Tampering with bowling scores",
                "Stealing dog costumes from a pet fashion show",
                "Moonwalking away from a crime scene",
                "Releasing bees in a courtroom",
                "Organizing a squirrel army",
                "Illegally broadcasting alien signals",
                "Throwing whipped cream at government officials",
                "Teaching pigeons to steal fries",
                "Staging a fake alien abduction",
                "Using karaoke as psychological warfare",
                "Robbing a clown college",
                "Illegally summoning rain for crops",
                "Opening portals to parallel parking spots",
                "Sabotaging talent shows with kazoo solos",
                "Impersonating a park ranger in space",
                "Eating all the samples at Costco",
                "Spray-painting clouds from a helicopter",
                "Running a ninja dojo without a license",
                "Disrupting a chess tournament with sock puppets",
                "Teleporting goats into government buildings",
                "Inventing a fake holiday and demanding time off",
                "Replacing courtroom chairs with whoopee cushions",
                "Trying to bribe a judge with cookies",
                "Releasing glitter bombs in a library",
                "Driving a tank through a drive-thru",
                "Pretending to be an elevator",
                "Hosting illegal wizard duels",
                "Hypnotizing mall Santas",
                "Crashing a yoga class with airhorns",
                "Training ants to perform robberies",
                "Selling fake fortunes to ghosts",
                "Replacing church wine with soda",
                "Cloning yourself to escape jury duty",
                "Faking a time loop to avoid responsibility",
                "Using a tuba as a weapon of distraction",
                "Entering Area 51 in a Pikachu costume",
                "Unlicensed meme distribution",
                "Attempting to marry a statue",
                "Harassing aliens over radio waves",
                "Tax fraud with invisible ink",
                "Flooding a court with rubber chickens",
                "Smuggling glitter into a no-glitter zone",
                "Public performance of interpretive dance without a permit",
                "Stealing a garden gnome and taking it on vacation",
                "Trying to pay fines with chocolate coins",
                "Robbing a petting zoo of its snacks",
                "Filing false complaints against unicorns",
                "Attempting to arrest the mayor using UNO rules",
                "Organizing a protest made of mannequins",
                "Training raccoons to pickpocket",
                "Replacing all road signs with puns",
                "Fishing for compliments in a courtroom",
                "Hosting pirate radio from a bouncy castle",
                "Faking an apocalypse for content",
                "Interrupting an opera with kazoo solos",
                "Releasing confetti in restricted airspace",
                "Pretending to be a lawyer on TikTok",
                "Illegal cupcake distribution",
                "Insulting pigeons in a protected zone",
                "Hacking traffic lights to play disco lights",
                "Staging a flash mob in a courtroom",
                "Public indecency in a mascot costume",
                "Gifting haunted dolls to senators",
                "Making a fake passport for a hamster",
                "Starting a turf war over hotdog stands",
                "Dressing mannequins as witnesses",
                "Trading government secrets for pizza",
                "Breaking and entering just to rearrange furniture",
                "Threatening public order with jazz hands",
                "Disrupting peace with dad jokes"
            };
            felony = goofyFelonies[ThreadLocalRandom.current().nextInt(0, goofyFelonies.length)];
        } else {
            String[] felonies = {
                "Armed robbery",
                "Grand theft auto",
                "Arson",
                "Kidnapping",
                "Drug trafficking",
                "Murder",
                "Manslaughter",
                "Bank robbery",
                "Fraud",
                "Tax evasion",
                "Bribery",
                "Forgery",
                "Money laundering",
                "Extortion",
                "Cyber terrorism",
                "Human trafficking",
                "Aggravated assault",
                "Rape",
                "Identity theft",
                "Burglary",
                "Illegal arms dealing",
                "Child abuse",
                "Animal cruelty",
                "Hacking into government systems",
                "Vandalism of federal property",
                "Possession of illegal firearms",
                "Public corruption",
                "Attempted murder",
                "Embezzlement",
                "Hit and run",
                "Domestic violence",
                "Stalking",
                "Obstruction of justice",
                "Tampering with evidence",
                "Perjury",
                "Counterfeiting",
                "Smuggling",
                "Terrorism in a hospital",
                "Trespassing on military base",
                "Assault on a police officer",
                "Illegal surveillance",
                "Sexual exploitation of minors",
                "Illegal dumping of toxic waste",
                "Sabotage",
                "Insider trading",
                "Illegal organ trade",
                "Disorderly conduct",
                "Breaking and entering",
                "Possession of child pornography",
                "Armed carjacking",
                "Poaching endangered species",
                "Attempted arson",
                "Illegal gambling operation",
                "Theft of government documents",
                "Unlawful imprisonment",
                "Driving under the influence (DUI)",
                "Looting during natural disaster",
                "Smuggling endangered animals",
                "Serial shoplifting",
                "Assault with a deadly weapon",
                "Violation of parole",
                "Hitman for hire",
                "Reckless endangerment",
                "Involuntary manslaughter",
                "Car theft",
                "False imprisonment",
                "Wire fraud",
                "Theft of trade secrets",
                "Unlicensed medical practice",
                "Fake charity scam",
                "Airport security violation",
                "Bomb threat in school",
                "Food tampering",
                "Stealing a military weapon",
                "Running a Ponzi scheme",
                "Using counterfeit money",
                "Hate crime",
                "Possession of explosives",
                "Credit card fraud",
                "Robbing a gas station",
                "Impersonating a police officer",
                "Assaulting a teacher",
                "Burglary of a pharmacy",
                "Hijacking a delivery truck",
                "Destruction of cultural property",
                "Selling illegal fireworks",
                "Illegal street racing",
                "Filing false insurance claims",
                "Medical insurance fraud",
                "Sexual harassment at workplace",
                "Stealing a package of gum",
                "Drunk driving with injuries",
                "Operating a drug lab",
                "Interstate car theft",
                "Abandoning a child",
                "Illegal immigration facilitation",
                "Organizing an illegal protest",
                "Pyramid scheme fraud",
                "Corporate espionage",
                "Sabotaging a power plant",
                "Fake passport creation",
                "Evading police arrest",
                "Robbing a convenience store",
                "Breaking quarantine order",
                "Stealing a baby",
                "Tampering with public utilities"
            };
            felony = felonies[ThreadLocalRandom.current().nextInt(0, felonies.length)];
        }
        return felony;
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

    //this funcion creates a random date beteiwng Current time and 98 years ago
    public static Date automaticPastDateCreator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        //this is the amount of milisecods in a year
        long milisegundosEnUnAno = 1000L * 60 * 60 * 24 * 365;
        Date startDate = new Date(VirtualTime.getVitualGlobalDate().getTime() - milisegundosEnUnAno * 98);

        long startMillis = startDate.getTime();
        long endMillis = VirtualTime.getVitualGlobalDate().getTime();

        long randomDateMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        Date date = new Date(randomDateMillis);

        return date;
    }

    //this funcion creates a random date beteiwng Current time and 98 years form now
    public static Date automaticFutureDateCreator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        //this is the amount of milisecods in a year
        long milisegundosEnUnAno = 1000L * 60 * 60 * 24 * 365;
        Date endDate = new Date(VirtualTime.getVitualGlobalDate().getTime() + milisegundosEnUnAno * 98);

        long endMillis = endDate.getTime();
        long startMillis = VirtualTime.getVitualGlobalDate().getTime();

        long randomDateMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        Date date = new Date(randomDateMillis);

        return date;
    }

    public static Date automaticAnywhereDateCreator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        //this is the amount of milisecods in a year
        long milisegundosEnUnAno = 1000L * 60 * 60 * 24 * 365;
        Date endDate = new Date(VirtualTime.getVitualGlobalDate().getTime() + milisegundosEnUnAno * 98);
        Date startDate = new Date(VirtualTime.getVitualGlobalDate().getTime() - milisegundosEnUnAno * 98);

        long endMillis = endDate.getTime();
        long startMillis = startDate.getTime();

        long randomDateMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        Date date = new Date(randomDateMillis);

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
        String name = autoNameSelector();
        String relationship = automaticRelationShipCreator();
        return new Visit(id, date, name, relationship);
    }

    public static Inmate automaticInmateCreator() {
        Inmate inmate = null;
        Date born_date;
        Date entrance_date;
        Date exit_date;
        String status;
        String felony = autoFelonySelector();
        ArrayList<Visit> visits = new ArrayList<>();
        String name = autoNameSelector();

        do {
            born_date = automaticPastDateCreator();
        } while ((VirtualTime.getVitualGlobalDate().getYear() + 1900) - (born_date.getYear() + 1900) < 16); // no menores

        if ((VirtualTime.getVitualGlobalDate().getYear() + 1900) - (born_date.getYear() + 1900) == 16) {
            entrance_date = VirtualTime.getVitualGlobalDate();
            exit_date = automaticFutureDateCreator();
        } else {
            do {
                entrance_date = automaticPastDateCreator();
                exit_date = automaticAnywhereDateCreator();
            } while ((entrance_date.getYear() + 1900) - (born_date.getYear() + 1900) < 16 || !exit_date.after(entrance_date));
        }

        if (exit_date.getYear() > VirtualTime.getVitualGlobalDate().getYear()) {
            status = "active";
        } else {
            status = "inactive";
        }

        //for every year the inmate has been in priosn im goin to make it so that 
        //there is a 66% chande of them getting visited
        for (var i = 0; i < (exit_date.getYear() - entrance_date.getYear()); i++) {
            if (ThreadLocalRandom.current().nextLong(0, 4) == 0) {
                visits.add(automaticVisitCreator());
            }
        }

        try {
            inmate = new Inmate(entrance_date, exit_date, status, felony, visits, name, born_date);
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
        return inmate;
    }
}
