package com.nortwind.app.business.abstracts;

import com.nortwind.app.core.Entity.User;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;

public interface UserService {
    DataResult<User> findByEmail(String email);
    Result add(User user);
}
