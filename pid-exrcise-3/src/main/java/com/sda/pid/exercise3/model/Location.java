package com.sda.pid.exercise3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "areas", "id", "name", "names", "region" })
public class Location {

	@JsonProperty("areas")
	private List<Area> areas = null;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("names")
	private List<Name> names = null;
	@JsonProperty("region")
	private Region region;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("areas")
	public List<Area> getAreas() {
		return areas;
	}

	@JsonProperty("areas")
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("names")
	public List<Name> getNames() {
		return names;
	}

	@JsonProperty("names")
	public void setNames(List<Name> names) {
		this.names = names;
	}

	@JsonProperty("region")
	public Region getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(Region region) {
		this.region = region;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
