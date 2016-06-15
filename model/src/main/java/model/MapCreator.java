package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MapCreator extends DBConnection{
	
	String map = "";

	ArrayList <Object> al;
	public MapCreator() throws SQLException{
		String idMap = "1";
		String sql = "{call getMap(?)}";
		CallableStatement call = connection.prepareCall(sql);
		call.setString(1, idMap);
		
		ResultSet resultSet = call.getResultSet();
		this.map = resultSet.getString("Map");
		// Recupere le string de la bdd
	}
	
	public void createObjects(){
		//read the map and create object corresponding, stock all of them in al
		ArrayList <Object> al = new ArrayList<Object>();
		int nbChar = map.length();
		int y = 0;
		for(int x = 0;x!=nbChar; x++){
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
				case '\n' : y = y++;
					break;
				default :
					break;
			}
		}
		this.al = al;
	}
	public ArrayList<Object> getObjects(){
		return this.al;
	}
}
