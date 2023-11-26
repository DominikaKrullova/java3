package applicationtier.model;

import org.springframework.lang.NonNull;

public record SupervisorModel(@NonNull String id, @NonNull String password)
{

}
