package com.petsync_spring_api.petsync_spring_api.config;

import com.petsync_spring_api.petsync_spring_api.entities.*;
import com.petsync_spring_api.petsync_spring_api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("dev-h2")
public class DevH2Config implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserPhoneService userPhoneService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StatusService statusService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @Autowired
    private ProcedureService procedureService;

    @Autowired
    private AnimalTypeService animalTypeService;

    @Autowired
    private FurColorService furColorService;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        //Roles
        Role r1 = new Role();
        r1.setName("REPRESENTATIVE");
        Role r2 = new Role();
        r2.setName("OWNER");
        Role r3 = new Role();
        r3.setName("STOCKKEEPER");
        Role r4 = new Role();
        r4.setName("ATTENDANT");
        Arrays.asList(r1, r2, r3, r4).forEach(obj -> roleService.put(obj));

        //Users
        User u1 = new User();
        u1.setCpf("12354214251");
        u1.setName("Developer");
        u1.setEmail("developer@gmail.com");
        u1.setPassword("123321");
        userService.encryptPassword(u1);
        u1.setRole(roleService.findById(1).orElseThrow());
        userService.put(u1);

        //UserPhone
        UserPhone up1 = new UserPhone();
        up1.setNumber("18558421754");
        UserPhone up2 = new UserPhone();
        up2.setNumber("18997281458");

        u1.getPhoneNumbers().add(up1);
        u1.getPhoneNumbers().add(up2);
        up1.setUser(u1);
        up2.setUser(u1);

        Arrays.asList(up1, up2).forEach(obj -> userPhoneService.put(obj));

        //Status
        Status s1 = new Status("IN_PROGRESS");
        Status s2 = new Status("COMPLETED");
        Status s3 = new Status("CANCELLED");

        Arrays.asList(s1, s2, s3).forEach(obj -> statusService.put(obj));

        /*//AnimalType
        AnimalType ap1 = new AnimalType("RABBIT");
        AnimalType ap2 = new AnimalType("CAT");
        AnimalType ap3 = new AnimalType("DOG");

        Arrays.asList(ap1, ap2, ap3).forEach(obj -> animalTypeService.put(obj));

        //FurColor
        FurColor fc1 = new FurColor("BLACK");
        FurColor fc2 = new FurColor("WHITE");
        FurColor fc3 = new FurColor("GRAY");
        FurColor fc4 = new FurColor("CARAMEL");
        FurColor fc5 = new FurColor("YELLOW");
        FurColor fc6 = new FurColor("ORANGE");
        FurColor fc7 = new FurColor("BROWN");
        FurColor fc8 = new FurColor("MULTICOLORED");

        Arrays.asList(fc1, fc2, fc3, fc4, fc5, fc6, fc7, fc8).forEach(obj -> furColorService.put(obj));

        //Pet
        Pet pe1 = new Pet();
        pe1.setCode(1);
        pe1.setName("Joseph");
        pe1.setAnimalType(ap3);
        pe1.setFurColor(fc1);
        pe1.setBirthDate(format.parse("09/06/2020"));
        pe1.setWeight(20);
        pe1.setObservation("Normal");*/

        //Schedule
        Schedule sc1 = new Schedule();
        sc1.setDescription("Do a full checkup");
        sc1.setStatus(s1);
        sc1.setUser(u1);
        //sc1.setPet(pe1);
        sc1.setPet(null);

        Schedule sc2 = new Schedule();
        sc2.setDescription("Routine appointment for puppies");
        sc2.setStatus(s2);
        sc2.setUser(u1);
        sc2.setPet(null);

        u1.getSchedules().add(sc1);
        u1.getSchedules().add(sc2);

        Arrays.asList(sc1, sc2).forEach(obj -> scheduleService.put(obj));

        //ProcedureType
        ProcedureType pt1 = new ProcedureType("SURGERY");
        ProcedureType pt2 = new ProcedureType("VACCINATION");
        ProcedureType pt3 = new ProcedureType("CONSULTATION");
        ProcedureType pt4 = new ProcedureType("EXAMINATION");

        Arrays.asList(pt1, pt2, pt3, pt4).forEach(obj -> procedureTypeService.put(obj));

        //Procedure
        Procedure p1 = new Procedure();
        p1.setCost(159.99);
        p1.setStatus(s1);
        p1.setPrescription("NA");
        p1.setUser(u1);
        p1.setProcedureType(pt4);
        p1.setSchedule(sc1);
        u1.getProcedures().add(p1);
        u1.getSchedules().add(sc1);

        List.of(p1).forEach(obj -> procedureService.put(obj));
    }
}
