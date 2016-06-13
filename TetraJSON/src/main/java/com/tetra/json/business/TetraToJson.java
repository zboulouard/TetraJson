package com.tetra.json.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tetra.json.dao.Link;
import com.tetra.json.dao.Node;

public class TetraToJson {

	private List<Node> nodes;
	private List<Link> links;
	
	public TetraToJson() {
		super();
		this.nodes = new ArrayList<Node>();
		this.links = new ArrayList<Link>();
	}
	
	public void readNodes() {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("src\\main\\java\\com\\tetra\\json\\sources\\A-A.1"));

			if ((sCurrentLine = br.readLine()) != null) {
				Scanner s = new Scanner(sCurrentLine);
				s.useDelimiter(" ");
				while (s.hasNext()) {
					Node node = new Node();
					node.setName(s.next());
					this.nodes.add(node);
				}
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void readLinks() {
		Path filePath = new File("src\\main\\java\\com\\tetra\\json\\sources\\A-A.1").toPath();
		Charset charset = Charset.defaultCharset();        
		List<String> listeLignes;
		try {
			listeLignes = Files.readAllLines(filePath, charset);
			String[] lignes = listeLignes.toArray(new String[]{});
			lignes = ArrayUtils.remove(lignes, 0);
			for (int i = 0; i < lignes.length; i++) {
				String ligne = lignes[i];
				String[] colonnes = ligne.split(" ");
				colonnes = ArrayUtils.remove(colonnes, 0);
				for (int j = 0; j < colonnes.length; j++) {
					String colonne = colonnes[j];
					Integer valeur = Integer.parseInt(colonne);
					if((i == j) || (valeur == 0)) {
						continue;
					} else {
						Link link = new Link();
						link.setSource(i);
						link.setTarget(j);
						this.links.add(link);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void nodesToJson() {
		String json = new Gson().toJson(this.nodes);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);
	}
	
	public void linksToJson() {
		String json = new Gson().toJson(this.links);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
