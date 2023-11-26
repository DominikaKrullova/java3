package applicationtier.service.api;

import applicationtier.model.UserModel;

import java.util.List;

public interface UserService
{
    List<UserModel> fetchUsersById(String Id);

    UserModel storeUserData(UserModel user);
}
