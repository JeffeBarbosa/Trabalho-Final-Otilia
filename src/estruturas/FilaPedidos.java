package estruturas;

public class FilaPedidos <T> extends EstruturaEstatica <T> {
	public FilaPedidos() {
		super();
	}
	public FilaPedidos(int capacidade) {
		super(capacidade);
	}
	public void enfileira(T elemento) {
		super.adiciona(elemento);
	}
	public T frente() {
		if(this.estaVazia()) {
			return null;
		}
		else {
			return(this.elementos[0]);
		}
	}
	public T desenfileira() {
		if (this.estaVazia()) {
			return null;
		}	
		else {
			int POS=0;
			T elemento =this.elementos[POS];	
			super.remove(POS);
			return elemento;
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("[");
		
		int cont;
		for (cont=0; cont<this.tamanho-1; cont++) {
			s.append(this.elementos[cont]);
			s.append(" ");
		} 
		
		if (this.tamanho > 0) {
			s.append(this.elementos[tamanho - 1]);
		}
		
		s.append("]");
		return s.toString();
	}

}
