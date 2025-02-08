package com.metaprogramming.metaprogramming.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser(int id, String firstName, String lastName, String email) {
        String sql = "INSERT INTO public.user_table (id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, firstName, lastName, email);
    }
}

