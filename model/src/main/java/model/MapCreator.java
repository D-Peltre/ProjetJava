package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import contract.IAffichable;




public class MapCreator extends DBConnection{
	//Create and initialize the String that will hold the map
	String map = "";

	ArrayList<IAffichable> al;
	
	public MapCreator() {
		try{
		String idMap = "1";
		String sql = "{call getMap(?)}";
		CallableStatement call = connection.prepareCall(sql);
		call.setString(1, idMap);
		call.execute();
		ResultSet resultSet = call.getResultSet();
		resultSet.next();
		this.map = resultSet.getString(1);
		// Recupere le string de la bdd
		resultSet.close();
		}catch(SQLException e){
			System.out.println("Could not connect to the database");
		}
	}
		
	
	public void createObjects(){
		//read the map and create object corresponding, stock all of them in al
		ArrayList <IAffichable> al = new ArrayList<IAffichable>();
		int nbChar = map.length();
		int y = 0;
		int x=0;
		/// i est l'indice du pointeur vers le map. X et Y sont les coordonnées du nouvel object a créer
		for(int i = 0;i<nbChar; i++){
			// Test value of char, and create object corresponding with its coordinates
			switch(map.charAt(i)){
				case '-' : al.add(new HorizontalWall(x, y));
					break;
				case '|' : al.add(new VerticalWall(x,y));
					break;
				case 'o' : al.add(new DiagonalWall(x,y));
					break;
				case '{' : al.add(new Door(x,y));
					break;
				case '*' : al.add(new EnergyBall(x,y));
					break;
				case 'd' : al.add(new Daemon(x,y));
					break;
				case '$' : al.add(new Gold(x,y));
					break;
				case 'L' : al.add(new Lorann(x,y));
					break;
					// when reaching end of line, set coordinate X at -1 (not 0 because of the x+=1) and coordinate Y at Y+1
				case 'R' : y+=1; x = -1;
					break;
				case 'X' : x = nbChar; break; 
				default : 
					break;
			}
			x+=1;
		}
		// Store local al in the object al
		this.al = al;
	}
	// get the list of all objects
	public ArrayList<IAffichable> getObjects(){
		return this.al;
	}
	// get the string of the map
	public String getMap(){
		return this.map;
	}
}