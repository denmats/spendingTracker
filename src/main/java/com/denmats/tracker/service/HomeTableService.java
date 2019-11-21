package com.denmats.tracker.service;

import java.util.List;

import com.denmats.tracker.model.HomeTable;

public interface HomeTableService {

	public List<HomeTable> findAllByOperation();
}
