package estruturas;

public abstract class EstruturaEstatica<T> {
	
	protected T[] elementos;
	protected int tamanho;
	
	protected EstruturaEstatica() {
	}

	protected EstruturaEstatica(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	protected void aumentaCapacidade() {
		int cont;
		
		if (this.tamanho == this.elementos.length-1) {
			T elementosNovos[] = (T[]) new Object[this.elementos.length*2];
			
			for (cont=0; cont<this.tamanho; cont++) {
				elementosNovos[cont] = this.elementos[cont];
			}
			elementos = elementosNovos;
		}
	}
	
	protected void adiciona(T elemento) {
		this.aumentaCapacidade();
		elementos[tamanho] = elemento;
		tamanho++;
	}
	
	protected boolean adiciona(int posicao, T elemento) {
		int cont;
		
		if (posicao>=0 && posicao<this.tamanho-1) {
			this.aumentaCapacidade();
			for (cont=this.tamanho-1; cont>=posicao; cont--) {
				this.elementos[cont+1] = this.elementos[cont];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
			return true;
		} else {
			return false;
		}
	}
	
	protected Object busca(int posicao) {
		if (posicao >= 0 && posicao <= this.tamanho) {
			return elementos[posicao];
		} else {
			return "Não encontrado";
		}
	}
	
	protected int busca(T elemento) {
		int cont;
		
		for (cont=0; cont<this.tamanho; cont++) {
			if (this.elementos[cont].equals(elemento)) {
				return cont;
			}
		}
		return -1;
	}
	
	protected void remove(int posicao) {
		int cont;
		
		if (posicao>=0 && posicao<this.tamanho) {
			for (cont=posicao; cont<this.tamanho-1; cont++) {
				this.elementos[cont] = this.elementos[cont+1];
			}
			this.tamanho--;
		}
	}
	
	protected void remove(T elemento) {
		int cont;
		
		for (cont=0; cont<this.tamanho; cont++) {
			if (this.elementos[cont].equals(elemento)){
				for (int cont2=cont; cont2<tamanho-1; cont2++) {
					this.elementos[cont2] = this.elementos[cont2+1];
				}
				this.tamanho--;
			}
		}
	}

	protected void atualiza(int posicao, T elemento) {
		this.elementos[posicao] = elemento;
	}
	
	public boolean estaVazia() {
		if (this.tamanho == 0) {
			return true;
		} else {
			return false;
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
