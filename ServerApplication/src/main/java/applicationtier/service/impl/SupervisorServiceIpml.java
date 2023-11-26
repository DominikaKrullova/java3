package applicationtier.service.impl;

import applicationtier.model.SupervisorModel;
import applicationtier.service.api.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceIpml implements SupervisorService
{
    @Override
    public List<SupervisorModel> fetchSupervisorsById(String Id)
    {
        return null;
    }

    @Override
    public SupervisorModel storeSupervisorData(SupervisorModel supervisor)
    {
        return null;
    }
}
