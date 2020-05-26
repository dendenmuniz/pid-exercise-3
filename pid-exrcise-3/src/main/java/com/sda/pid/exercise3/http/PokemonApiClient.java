package com.sda.pid.exercise3.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.pid.exercise3.model.Location;
import com.sda.pid.exercise3.model.Pokemon;

public class PokemonApiClient {

	private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	private ObjectMapper mapper = new ObjectMapper();
	
	public Pokemon findPokemon(String namePokemon) throws IOException, InterruptedException {

		return sendGetPokemon(namePokemon);
	}

	public Location findLocation(String nameLocation)throws IOException, InterruptedException {
		return sendGetLocation(nameLocation);
	}

	private Pokemon sendGetPokemon(String namePokemon) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + namePokemon)).build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {

			return mapper.readValue(response.body(), Pokemon.class);
		} else {
			return null;
		}

	}

	private Location sendGetLocation(String nameLocation) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://pokeapi.co/api/v2/location/" + nameLocation)).build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {

			return mapper.readValue(response.body(), Location.class);
		} else {
			return null;
		}

	}

}
