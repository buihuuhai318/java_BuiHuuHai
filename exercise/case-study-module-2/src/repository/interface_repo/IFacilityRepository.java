package repository.interface_repo;

import model.facility.Facility;

public interface IFacilityRepository extends IRepository<Facility> {
    void addMaintenance(Facility facility);

    void showMaintenance();

    void houseHead();

    void villaHead();

    void roomHead();

    void maintenanceHear();
}
