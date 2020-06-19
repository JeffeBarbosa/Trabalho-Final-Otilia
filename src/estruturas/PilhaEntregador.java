package estruturas;

public class PilhaEntregador<T> extends EstruturaEstatica<T>{

	

		public PilhaEntregador() {

			super();

		}

		public PilhaEntregador(int capacidade) {

			super(capacidade);

		}



		public void empilha(T elemento) {

			super.adiciona(elemento);

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
}
