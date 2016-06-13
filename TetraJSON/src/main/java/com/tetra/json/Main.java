package com.tetra.json;

import com.tetra.json.business.TetraToJson;

public class Main {

	public static void main(String[] args) {
		TetraToJson tetraToJson = new TetraToJson();
		tetraToJson.readNodes();
		tetraToJson.nodesToJson();
		tetraToJson.readLinks();
		tetraToJson.linksToJson();
	}

}
