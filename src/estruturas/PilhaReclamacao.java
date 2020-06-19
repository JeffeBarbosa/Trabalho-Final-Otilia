package estruturas;

public class PilhaReclamacao<T> extends EstruturaEstatica<T>{

	public PilhaReclamacao() {

		super();

	}

	public PilhaReclamacao(int capacidade) {

		super(capacidade);

	}



	public void empilha(T elemento) {

		super.adiciona(elemento);

	}



	public T topo() {

		if(super.estaVazia()) {

			return null;

		}

		else {

			return(this.elementos[tamanho-1]);

		}	

	}



	public T desempilha() {

		if (super.estaVazia()) {

			return null;

		}

		else {

			T elemento = this.elementos[tamanho-1];

			tamanho--;

			return elemento;			

		}			

	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("[");
		
		int cont;
		for (cont=0; cont<this.tamanho-1; cont++) {
			s.append(this.elementos[cont]);
			s.append("\n");
		} 
		
		if (this.tamanho > 0) {
			s.append(this.elementos[tamanho - 1]);
		}
		
		s.append("]");
		return s.toString();
	}

}