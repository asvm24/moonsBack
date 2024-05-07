package com.UdemyProjectDev.UdemyProjectDev.dto;

import com.UdemyProjectDev.UdemyProjectDev.enums.UserRole;
import com.UdemyProjectDev.UdemyProjectDev.model.Client;
import com.UdemyProjectDev.UdemyProjectDev.model.Lead;
import com.UdemyProjectDev.UdemyProjectDev.model.Task;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

        private String email;
        // TODO : change the UserRole class to be named just rol e
        private UserRole role;
        private String phoneNumber;
        private String username;
        private String firstName;
        private String lastName;
        private List<Task> userTasks;
        private List<Client> clients;
        private List<Lead> leads;

}

