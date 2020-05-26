package com.sda.pid.exercise3;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sda.pid.exercise3.model.Area;
import com.sda.pid.exercise3.model.Location;
import com.sda.pid.exercise3.model.Pokemon;
import com.sda.pid.exercise3.service.PokemonService;

public class PokemonApp {

	public static void main(String[] args) throws Exception {

		PokemonService service = new PokemonService();

		try (Scanner sc = new Scanner(System.in)) {
			int userOption;
			do {
				System.out.println("\n*****  Welcome to Pokemon App  *****");
				System.out.println("*************************************");
				System.out.println("Here you can see some Pokemon information.");
				System.out.println("Pick an option:");
				System.out.println("(1) Choose one Pokemon to see");
     			System.out.println("(2) Choose one specific location");
//			System.out.println("(3) Save the attendance list in a file");
				System.out.println("(4) Quit");

				userOption = Integer.parseInt(sc.nextLine());

				switch (userOption) {
				case 1:
					// TODO
				System.out.println("Please, enter the Pokemon name");
				String namePokemon = sc.nextLine();
					showListPokemon(service, namePokemon);
					break;
				case 2:
					System.out.println("Please, enter the location name");
					String nameLocation = sc.nextLine();
					showLocations(service,nameLocation);
					break;
//				case 3:
//					// TODO
//					break;
				}
			} while (userOption != 4);

		} catch(NumberFormatException ex) {
			System.out.println("Impossible to find this option/name");
		} catch (IOException e) {
			System.out.println(e);
		}catch(InterruptedException ei) {
			System.out.println("Time out. Server not responding.");
		} finally {
			System.out.println("Bye Bye");
		}

	}

	private static void showListPokemon(PokemonService service, String namePokemon) throws IOException, InterruptedException {

		Pokemon choosenPokemon = service.showPokemon(namePokemon);

		if (choosenPokemon != null && !"".equals(choosenPokemon.getName())) {
			System.out.println("Pokemon name: " + choosenPokemon.getName() + "\t Id: " + choosenPokemon.getId()
					+ "\t height: " + choosenPokemon.getHeight() + "\t weight: " + choosenPokemon.getWeight());
		} else {
			System.out.println("Pokemon not found.");
		}

	}
	
	private static void showLocations(PokemonService service, String nameLocation) throws IOException, InterruptedException {
		
		Location choosenLocation = service.showLocation(nameLocation);
		
		if(choosenLocation != null && !"".equals(choosenLocation.getName())) {
			System.out.println("\nLocation Name:" + choosenLocation.getName());
			System.out.println("Region: "+ choosenLocation.getRegion().getName());
			 choosenLocation.getNames().stream().forEach(name -> {
				System.out.println("language: " + name.getLanguage().getName() + "\t Name: " + name.getName());
				});
		} else {
			System.out.println("Location not found.");
		}
		
		
		
	}

}
