package applicationtier.model;

import org.springframework.lang.NonNull;

public record UserModel(@NonNull String id, @NonNull String password)
{

}
