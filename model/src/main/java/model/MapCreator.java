package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.CallableStatement;


public class MapCreator extends DBConnection{
	
	
	
	String map = "";
	
	public MapCreator(){
		
		final String sql = "{call getMap(?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		final ResultSet resultSet = call.getResultSet();
		this.map = resultSet.getString("Map");
		// Recupere le string de la bdd
	}
	
	public ArrayList <Object> createObjects(){
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
		return al;
	}
}
