package com.petsync_spring_api.petsync_spring_api.config;

import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.entities.Status;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.services.RoleService;
import com.petsync_spring_api.petsync_spring_api.services.StatusService;
import com.petsync_spring_api.petsync_spring_api.services.UserPhoneService;
import com.petsync_spring_api.petsync_spring_api.services.UserService;
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
        Arrays.asList(r1, r2, r3, r4).forEach(role -> roleService.put(role));

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

        Arrays.asList(up1, up2).forEach(userPhone -> userPhoneService.put(userPhone));

        //Status
        Status s1 = new Status("EM_ANDAMENTO");
        Status s2 = new Status("CONCLUIDO");
        Status s3 = new Status("CANCELADO");

        Arrays.asList(s1, s2, s3).forEach(status -> statusService.put(status));
    }
}
