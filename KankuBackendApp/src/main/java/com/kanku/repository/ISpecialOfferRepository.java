package com.kanku.repository;

import com.kanku.model.SpecialOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISpecialOfferRepository extends JpaRepository<SpecialOffers,Long> {

    List<SpecialOffers> findBySpecialOfferEndDateBefore(LocalDate date);
}
