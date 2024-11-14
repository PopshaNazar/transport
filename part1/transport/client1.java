class Main{
    public static void main(String[] args){
	Transport bmw = new Transport();
	Transport truck = new Transport();
	bmw.setValues(100,12,"black");
	truck.setValues(50,31,"White");

	System.out.println(bmw.getValues()+"\n");
	System.out.println(truck.getValues());
	
    }

}
