package com.metaprogramming.metaprogramming.repository;

import com.metaprogramming.metaprogramming.entity.ColumnName;
import com.metaprogramming.metaprogramming.entity.TableName;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.lang.reflect.Field;
import java.util.Arrays;

@Repository
public class GenericRepository<T> {
    private final JdbcTemplate jdbcTemplate;

    public GenericRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(T entity) {
        Class<?> clazz = entity.getClass();

        TableName tableNameAnnotation = clazz.getAnnotation(TableName.class);
        String tableName = (tableNameAnnotation != null) ? tableNameAnnotation.value() : clazz.getSimpleName().toLowerCase();

        Field[] fields = clazz.getDeclaredFields();

        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        Object[] params = new Object[fields.length];

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                ColumnName columnNameAnnotation = fields[i].getAnnotation(ColumnName.class);
                String columnName = (columnNameAnnotation != null) ? columnNameAnnotation.value() : fields[i].getName();

                columns.append(columnName).append(",");
                values.append("?,");
                params[i] = fields[i].get(entity);
            }

            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                    tableName,
                    columns.substring(0, columns.length() - 1),
                    values.substring(0, values.length() - 1)
            );

            jdbcTemplate.update(sql, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error al acceder a los campos de la entidad", e);
        }
    }
}
