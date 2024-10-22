public class Transport{
    public int speed;
    public int weight;
    public String color;
    
    public void setValues(int _speed, int _weight, String _color){
	speed = _speed;
	weight = _weight;
	color = _color;
	
    }
    public String getValues(){
	String info = "speed:"+speed+"  weight:"+weight+"  color:"+color;
	return info;
    }
    
}
