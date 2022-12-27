package com.sprint1.tourmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.tourmanagement.entity.Tour;
import com.sprint1.tourmanagement.exception.TourNotFoundException;
import com.sprint1.tourmanagement.repository.TourRepository;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepository;
	@Override
	public Tour addTour(Tour tour) {
		Tour tour1=tourRepository.save(tour);
		return tour1;
	}
	@Override
	public List<Tour> displayTours() {
		List<Tour> tours=tourRepository.findAll();
		return tours;
	}
	@Override
	public Tour updateTour(Tour tour) {
		Optional<Tour> tour1=tourRepository.findById(tour.getTourId());
		if(tour1.isEmpty()) {
			throw new TourNotFoundException("Tour with id "+tour.getTourId()+" is not existed");
		}
		Tour tour2=tourRepository.save(tour);
		return tour2;
	}
	@Override
	public void deleteTour(int tourId) {
		Optional<Tour> tour=tourRepository.findById(tourId);
		if(tour.isEmpty()) {
			throw new TourNotFoundException("Tour with id "+tourId+" is not existed");
		}
		tourRepository.deleteById(tourId);
	}
	@Override
	public Tour findTour(int tourId) {
		Optional<Tour> optionalTour=tourRepository.findById(tourId);
		if(optionalTour.isEmpty()) {
			throw new TourNotFoundException("There is no Tour with the Id:"+tourId);
		}
		Tour tour=optionalTour.get();
		return tour;
	}

}