package com.sda.pid.exercise3.service;

import java.io.IOException;

import com.sda.pid.exercise3.http.PokemonApiClient;
import com.sda.pid.exercise3.model.Location;
import com.sda.pid.exercise3.model.Pokemon;

public class PokemonService {

	private PokemonApiClient api;

	public PokemonService() throws Exception {
		 api = new PokemonApiClient();

	}

	public Pokemon showPokemon(String namePokemon) throws IOException, InterruptedException {
		return api.findPokemon(namePokemon);
	}
	
	public Location showLocation(String nameLocation) throws IOException, InterruptedException {
		return api.findLocation(nameLocation);
	}

}
