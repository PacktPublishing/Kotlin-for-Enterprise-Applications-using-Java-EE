fun main(args: Array<String>) {
   System.out.println(isPrime(2));
}
private fun isPrime(number:Int): Boolean{
	for(i in 2..number /2) {
		if(number % i == 0){
			return true
		}
	}
	return false;
}