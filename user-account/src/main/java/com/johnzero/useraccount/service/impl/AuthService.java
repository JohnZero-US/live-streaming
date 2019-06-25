package com.johnzero.useraccount.service.impl;

import com.johnzero.model.useraccount.User;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/6/25 5:48
  Description: 
*/
public interface AuthService {
    User getUserByEmail(String email, String password);
}
