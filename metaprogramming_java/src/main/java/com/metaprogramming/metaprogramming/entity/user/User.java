package com.metaprogramming.metaprogramming.entity.user;

import com.metaprogramming.metaprogramming.entity.TableName;
import com.metaprogramming.metaprogramming.entity.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_table")
public class User {

    @ColumnName("id")
    private int id;
    @ColumnName("first_name")
    private String firstName;
    @ColumnName("last_name")
    private String lastName;
    @ColumnName("email")
    private String email;
}

