package applicationtier.service.api;

import applicationtier.model.SupervisorModel;

import java.util.List;

public interface SupervisorService
{
    List<SupervisorModel> fetchSupervisorsById(String Id);

    SupervisorModel storeSupervisorData(SupervisorModel supervisor);
}
