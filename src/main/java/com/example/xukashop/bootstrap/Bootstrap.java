package com.example.xukashop.bootstrap;

import com.example.xukashop.model.Category;
import com.example.xukashop.model.Image;
import com.example.xukashop.model.Role;
import com.example.xukashop.repository.CategoryRepository;
import com.example.xukashop.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
    public Bootstrap(RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0){
            Role role_user = new Role();
            role_user.setRole("ROLE_USER");
            Role saved_role_user = roleRepository.save(role_user);

            Role role_admin = new Role();
            role_admin.setRole("ROLE_ADMIN");
            Role saved_role_admin = roleRepository.save(role_admin);

            Category category = new Category();
            category.setName("son");
            category.setDescription("son duck");
            category.getImages().add(new Image("sdfsdfdg.com","asdjkhdadfhvoisduhcvpyhefvjia"));
            category.getImages().add(new Image("lsdfdfg.com","sadfsdfgsdfg"));
            categoryRepository.save(category);

        }
    }
}
