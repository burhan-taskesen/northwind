package com.nortwind.app.business.concretes;

import com.nortwind.app.business.abstracts.UserService;
import com.nortwind.app.core.Entity.User;
import com.nortwind.app.core.dataAccess.UserDao;
import com.nortwind.app.core.utilities.results.DataResult;
import com.nortwind.app.core.utilities.results.Result;
import com.nortwind.app.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email),"Kişi bulundu");
    }

    @Override
    public Result add(User user) {
        return new SuccessDataResult(userDao.save(user),"Kişi eklendi");
    }
}
