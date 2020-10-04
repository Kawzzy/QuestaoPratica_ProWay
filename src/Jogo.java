
public class Jogo {
	private int jogo,
				placar;
	
	public Jogo(int pontuacao, int counter) {
		this.setPlacar(pontuacao);
		this.setQtdJogos(counter);
		
	}

	public int getQtdJogos() {
		return jogo;
	}

	public void setQtdJogos(int qtdJogos) {
		int qtdJogo = qtdJogos;
		if (this.getQtdJogos() == 0) {
			 this.jogo = qtdJogo;	
		} else {
			this.jogo = this.getQtdJogos() + qtdJogo;
		}
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int pontuacao) {
		int novaPontuacao = pontuacao;
		if (novaPontuacao > this.getPlacar() && novaPontuacao < 1000) {
			this.placar = novaPontuacao;
		} else {
			this.placar = this.getPlacar();
		}
	}
	
}
