package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class AgencyRepositoryImpl implements AgencyRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return entityManager.createQuery("select a from Agency a", Agency.class).getResultList();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return entityManager.find(Agency.class, id);
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) {
        Agency foundeAgency = entityManager.find(Agency.class, id);
        foundeAgency.setName(agency.getName());
        foundeAgency.setCountry(agency.getCountry());
        foundeAgency.setPhoneNumber(agency.getPhoneNumber());
        foundeAgency.setImageLink(agency.getImageLink());
        foundeAgency.setEmail(agency.getEmail());
        foundeAgency.setHouses(agency.getHouses());
        foundeAgency.setCustomers(agency.getCustomers());
        entityManager.merge(foundeAgency);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Agency.class,id));
    }
}
