public class Poly{
	// declare variables
	private Term first;
	private Term last;

	// Term class, with coefficient, exponential and next as its attributes
    private static class Term{
    	// declare vairables
    	private int coef;
    	private int expo;
    	private Term next;

    	// Generator 
		private Term(int coef, int expo){
		    this.coef = coef;
		    this.expo = expo;
		    // this.next = next;
		}

		// setters and getters for class Term
		private int getCoef(){return this.coef;} 
		private int getExpo(){return this.expo;} 
		private Term getNext(){return this.next;} 

		private void setCoef(int coef){this.coef = coef;} 
		private void setExpo(int expo){this.expo = expo;} 
		private void setNext(Term next_term){this.next = next_term;}
    }

    // Generator
    public Poly(){
    	Term t = new Term(0, Integer.MAX_VALUE);
    	this.first = t;
    	this.last = t;
    }

    public String toString(){
    	String res = "";
    	Term ptr = this.first;
    	StringBuffer sb = new StringBuffer();
    	while(ptr != null){
    		System.out.println("sb.coef: " + Integer.toString(ptr.coef)) ;
    		if(ptr.getCoef() == 0){continue;}
    		if(ptr.getCoef() > 0){
    			sb.append('+');
    			sb.append(Integer.toString(ptr.coef));
	    		sb.append('x');
	    		sb.append(Integer.toString(ptr.expo));
    		}
    		else{
    			// sb.append('-');
    			sb.append(Integer.toString(ptr.coef));
	    		sb.append('x');
	    		sb.append(Integer.toString(ptr.expo));
    		}
    		ptr = ptr.next;
    	}
    	if(sb.charAt(0) == '+'){
    		sb.deleteCharAt(0);
    	}
   //  	while(ptr != null){
			// if(sb.length() != 0 && sb.charAt(sb.length()-1) == '+'){
			// 	System.out.println(".....");
			// 	sb.deleteCharAt(sb.length()-1);
			// 	sb.append(Integer.toString(ptr.coef));
	  //   		sb.append('x');
	  //   		sb.append(Integer.toString(ptr.expo));
	  //   		sb.append('+');
	  //   		ptr = ptr.getNext();
			// }
   //  		else if(ptr.coef == 0){
   //  			continue;
   //  		}
   //  		else{
	  //   		sb.append(Integer.toString(ptr.coef));
	  //   		sb.append('x');
	  //   		sb.append(Integer.toString(ptr.expo));
	  //   		sb.append('+');
	  //   		ptr = ptr.getNext();
   //  		}
   //  	}
   //  	sb.deleteCharAt(sb.length()-1);
    	return sb.toString();
    }

    // Getters and Setters
    public Term getFirst(){return first;}
    public Term getLast(){return last;}
    public void setFirst(Term first){this.first = first;}
    public void setLast(Term last){this.last = last;}
    
    //methods for Poly
    public boolean isZero(){
    	return (this.first.coef == 0 && this.last.coef == 0 && first.next == null) ? true : false;
    }

    public Poly minus(){
    	Poly res = new Poly();
    	Term temp = this.first;
    	Term prev = new Term(0,Integer.MAX_VALUE);
    	Term dummy_first =prev;
    	// Term ptr = res.first;
    	while(temp != null){
    		Term ptr = new Term(0,Integer.MAX_VALUE);
    		ptr.setCoef(temp.getCoef()*(-1));
    		ptr.setExpo(temp.getExpo());
    		System.out.println("coeff now is: " + Integer.toString(ptr.coef));
    		prev.next = ptr;
    		prev = ptr;
    		temp = temp.getNext();
    	}
    	res.first = dummy_first.next;
    	return res;
    }
    





    public static void main(String []args){
    	System.out.println("Hello World");
        Term ttt = new Term(-1,2);
        Term tt = new Term(3,4);
        Term t = new Term(5,6);
        t.setNext(tt);
        tt.setNext(ttt);
        System.out.println(t.coef);
        System.out.println(t.expo);
        System.out.println(t.next);
        Poly p = new Poly();
        System.out.println(p.first.coef);
        System.out.println(p.last.coef);
        System.out.println(p.isZero());
        System.out.println("--------------");
        p.first = t;
        // Term temp = p.first;
        Poly q = p.minus();
        Term temp = q.first;
        // while(temp != null){
        // 	System.out.print(Integer.toString(temp.coef));
        // 	temp = temp.getNext();
        // }
        System.out.println(q);

        // Poly p = new Poly();
    }
}