package applicationtier.service.impl;

import applicationtier.model.UserModel;
import applicationtier.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Override
    public List<UserModel> fetchUsersById(String Id)
    {
        return null;
    }

    @Override
    public UserModel storeUserData(UserModel user)
    {
        return null;
    }
}
