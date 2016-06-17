package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import contract.IAffichable;




public class MapCreator extends DBConnection{
	//Create and initialize the String that will hold the map
	String map = "";
	// Create the list that will hold all objects
	ArrayList<IAffichable> al;
	// Constructor of MapCreator, connect to the DB and get the String of the map thanks to a stored procedure
	public MapCreator() throws SQLException{
		// idMap is the number associated of a map in our DB
		String idMap = "1";
		// Store the name of the stored procedure with its parameters in String sql
		String sql = "{call getMap(?)}";
		CallableStatement call = connection.prepareCall(sql);
		// Put the parameters in the procedure
		call.setString(1, idMap);
		// Execute the procedure
		call.execute();
		// result of the procedure is stored in resultSet
		ResultSet resultSet = call.getResultSet();
		// Select the good line (even if there is only one, it needs to be done)
		resultSet.next();
		// store the result in the map variable
		this.map = resultSet.getString(1);
		// Close the DB
		resultSet.close();
	}
		
	//read the map and create object corresponding, stock all of them in al
	public void createObjects(){
		// Allows us to store all objects in this local variable
		ArrayList <IAffichable> al = new ArrayList<IAffichable>();
		// get the number of char in the map string and store it in nbChar
		int nbChar = map.length();
		int y = 0;
		int x=0;
		// create a loop that will increments i from 0 to nbChar-1
		for(int i = 0;i<nbChar; i++){
			
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
					// on incrémente y, et on retourne x a la ligne
				case 'R' : y+=1; x = -1;
					break;
				case 'X' : x = nbChar; break; 
				default : 
					break;
			}
			x+=1;
		}
		this.al = al;
	}
	public ArrayList<IAffichable> getObjects(){
		return this.al;
	}
	public String getMap(){
		return this.map;
	}
}
