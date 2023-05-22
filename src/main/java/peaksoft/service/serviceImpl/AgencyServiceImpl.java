package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;
import peaksoft.service.AgencyService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;
    @Override
    public void saveAgency(Agency agency) {
      agencyRepository.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyRepository.getAllAgency();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.getAgencyById(id);
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) {
    agencyRepository.updateAgencyById(id,agency);
    }

    @Override
    public void deleteById(long id) {
    agencyRepository.deleteById(id);
    }
}
