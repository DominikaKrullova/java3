package applicationtier.model;

import org.springframework.lang.NonNull;

public record TeacherModel(@NonNull String id, String userId, @NonNull String name, @NonNull String password) {
    // TODO: should introduce inheritance
}
