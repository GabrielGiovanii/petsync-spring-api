package com.petsync_spring_api.petsync_spring_api.config;

import com.petsync_spring_api.petsync_spring_api.entities.*;
import com.petsync_spring_api.petsync_spring_api.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

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

    @Override
    public void run(String... args) throws Exception {
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

        //Schedule
        Schedule sc1 = new Schedule();
        sc1.setDescription("Do a full checkup");
        sc1.setStatus(s1.getCode());
        sc1.setUser(u1);
        sc1.setPet(null);

        Schedule sc2 = new Schedule();
        sc2.setDescription("Routine appointment for puppies");
        sc2.setStatus(s1.getCode());
        sc2.setUser(u1);
        sc2.setPet(null);

        u1.getSchedules().add(sc1);
        u1.getSchedules().add(sc2);

        Arrays.asList(sc1, sc2).forEach(obj -> scheduleService.put(obj));
    }
}
