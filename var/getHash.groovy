def call (){
	StringBuilder str=new StringBuilder();
	def random=new Random();
	for(int i=0;i<8;i++){
	    str.append(random.nextInt(10));
	}
	int num=Integer.parseInt(str.toString());
	return num
}