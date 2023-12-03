package applicationtier.service.impl;

import applicationtier.DAO.Supervisor.SupervisorDao;
import applicationtier.model.SupervisorModel;
import applicationtier.service.api.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService
{
    private final SupervisorDao supervisorDao;

    @Autowired
    public SupervisorServiceImpl(SupervisorDao supervisorDao)
    {
        this.supervisorDao = supervisorDao;
    }
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
