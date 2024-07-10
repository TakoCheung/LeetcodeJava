package com.example.demo;

import static org.mockito.Mockito.*;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccessControllerTest {

    @Mock
    private User user;

    @InjectMocks
    private AccessController accessController;

    @Value("${access.file.path}")
    private String accessFilePath;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() throws Exception {
        when(user.getRole()).thenReturn("admin");

        Access access = new Access();
        access.setUserId(123456L);
        access.setResources(List.of("resource A", "resource B"));

        accessController.addUser(access, user);

        List<String> lines = Files.readAllLines(Paths.get(accessFilePath));
        assert lines.stream().anyMatch(line -> line.contains("123456:resource A,resource B"));
    }

    @Test
    public void testCheckAccess() throws Exception {
        when(user.getUserId()).thenReturn(123456L);

        try (FileWriter writer = new FileWriter(accessFilePath, true)) {
            writer.write("123456:resource A,resource B
");
        }

        String response = accessController.checkAccess("resource A", user);
        assert response.equals("Access granted");

        response = accessController.checkAccess("resource C", user);
        assert response.equals("Access denied");
    }
}
