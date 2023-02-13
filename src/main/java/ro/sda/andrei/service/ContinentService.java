package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.andrei.dto.ContinentDto;
import ro.sda.andrei.entities.Continent;
import ro.sda.andrei.repository.ContinentRepository;


import java.util.List;

@Service
public class ContinentService {

    private ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Continent addNewContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    public List<Continent> findAll() {
        return continentRepository.findAll();
    }

    public Continent findById(Long id) {
        return continentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Continent not found"));
    }

    public void update(Long id, ContinentDto continentDto) {
        continentRepository.findById(id)
                .map(existingContinent -> updateEntity(continentDto, existingContinent))
                .map(updatedContinent -> continentRepository.save(updatedContinent))
                .orElseThrow(() -> new RuntimeException("continent not found"));
    }

    private Continent updateEntity(ContinentDto continentDto, Continent existingContinent) {
        existingContinent.setName(continentDto.getName());

        return existingContinent;
    }

    public void updateNew(Continent continent) {

        String name = continent.getName();
        continentRepository.findByNameIgnoreCase(name)
                .filter(existingContinent -> existingContinent.getId().equals(continent.getId()))
                .map(existingContinent -> continentRepository.save(continent))
                .orElseThrow(() -> {

                    throw new RuntimeException("continent already exist");
                });
    }


    @Transactional
    public void delete(Long id) {
        continentRepository.deleteById(id);
    }

    public void save(Continent continent) {
        continentRepository.save(continent);
    }
}
