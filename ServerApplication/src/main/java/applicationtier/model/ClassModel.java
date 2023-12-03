package applicationtier.model;

import org.springframework.lang.NonNull;

public record ClassModel(@NonNull String className, int classId)
{
}
