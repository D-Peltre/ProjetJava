package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import contract.IAffichable;




public class MapCreator extends DBConnection{
	
	String map = "";

	ArrayList<IAffichable> al;
	
	public MapCreator() throws SQLException{
		String idMap = "1";
		String sql = "{call getMap(?)}";
		CallableStatement call = connection.prepareCall(sql);
		call.setString(1, idMap);
		call.execute();
		ResultSet resultSet = call.getResultSet();
		resultSet.next();
		this.map = resultSet.getString(1);
		// Recupere le string de la bdd
		System.out.print(this.map);
		resultSet.close();
	}
		
	
	public void createObjects(){
		//read the map and create object corresponding, stock all of them in al
		ArrayList <IAffichable> al = new ArrayList<IAffichable>();
		int nbChar = map.length();
		int y = 0;
		for(int x = 0;x!=nbChar; x++){
			System.out.print(map.charAt(x));
			switch(map.charAt(x)){
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
				case 'R' : y = y++; x = 0;
					break;
				case 'X' : x = nbChar; break; 
				default : 
					break;
			}
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
