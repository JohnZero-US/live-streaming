package com.johnzero.model.useraccount;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/6/25 5:11
  Description: 
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String username;

    private String password;

    private String email;
}
