package applicationtier.DAO.Supervisor;

import applicationtier.model.SupervisorModel;

import java.util.List;

public interface SupervisorDao
{
    String addSupervisor(String Id, String password);
    String deleteSupervisor(String Id, String password);
    String updateSupervisor(String Id, String password);

    SupervisorModel getSupervisorById(String Id);
    List<SupervisorModel> getAllSupervisors();
}
