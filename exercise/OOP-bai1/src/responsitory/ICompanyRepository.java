package responsitory;

import model.CanBo;

import java.util.List;

public interface ICompanyRepository {
    void addNew(CanBo canBo);

    int searchId(int id);

    CanBo getCanBo(int index);

    List<CanBo> display();

    List<CanBo> displayByName();
}
