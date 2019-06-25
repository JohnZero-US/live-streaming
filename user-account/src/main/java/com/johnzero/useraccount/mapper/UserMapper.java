package com.johnzero.useraccount.mapper;

import com.johnzero.model.useraccount.User;
import org.apache.ibatis.annotations.*;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Interface
  User: John Zero
  DateTime: 2019/6/25 5:40
  Description: 
*/
@Mapper
public interface UserMapper {

    @Results(
            id = "UserResult",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "email", property = "email")
            }
    )
    @Select("select * from user where email=#{email} and password=#{password}")
    User getUserByEmail(@Param("email") String email, @Param("password") String password);
}
