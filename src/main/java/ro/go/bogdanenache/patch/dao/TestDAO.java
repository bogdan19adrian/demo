package ro.go.bogdanenache.patch.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import ro.go.bogdanenache.patch.entity.UserEntity;

import java.io.IOException;
import java.io.InputStream;

@Component
public class TestDAO {

    private final ResourceLoader resourceLoader;

    public TestDAO(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public UserEntity getUser() {
        Resource resource = resourceLoader.getResource("classpath:resource.json");
        ObjectMapper objectMapper = new ObjectMapper();
        UserEntity entity = null;
        try (InputStream input = resource.getInputStream()) {
            entity = objectMapper.readValue(input, UserEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
}
