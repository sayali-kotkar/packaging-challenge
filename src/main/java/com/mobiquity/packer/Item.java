package com.mobiquity.packer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Item {
	
	private String itemId;
	private float weight;
	private int cost;
}
